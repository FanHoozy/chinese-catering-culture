package org.bearer.configure;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.config.ShiroConfiguration;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.bearer.filter.JwtFilter;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.Filter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2023/10/7 13:23
 */
@ConditionalOnClass({RedisConfig.class})
@Configuration
public class ShiroConfig extends ShiroConfiguration {

    @Resource
    private AuthorizingRealm myRealm;
    @Resource
    private AuthorizingRealm jwtRealm;

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(mySecurityManager());
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator app = new DefaultAdvisorAutoProxyCreator();
        app.setProxyTargetClass(true);
        return app;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(mySecurityManager());

        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("jwtFilter", new JwtFilter());
        factoryBean.setFilters(filterMap);

        Map<String, String> urls = new LinkedHashMap<>();
        urls.put("/weChatLogin", "anon");
        urls.put("/adminLogin", "anon");
        urls.put("/swagger-ui/**", "anon");
        urls.put("/swagger-resources/**", "anon");
        urls.put("/v2/**", "anon");
        urls.put("/home/**", "anon");
        urls.put("/search/**", "anon");
        urls.put("/dynamic/getDynamic/**", "anon");
        urls.put("/static/**", "anon");
        urls.put("/upload/**", "anon");

        urls.put("/logout", "jwtFilter");
//        urls.put("/**", "jwtFilter,authc");
        urls.put("/**","anon");
        factoryBean.setFilterChainDefinitionMap(urls);
        return factoryBean;
    }

    @Bean
    public DefaultWebSecurityManager mySecurityManager() {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealms(Arrays.asList(myRealm(), jwtRealm()));
        return defaultWebSecurityManager;
    }

    public Realm myRealm() {
        HashedCredentialsMatcher matcher = new MyHashedCredentialsMatcher("MD5");
        matcher.setHashIterations(1);
        myRealm.setCredentialsMatcher(matcher);
        return myRealm;
    }

    public Realm jwtRealm() {
        JwtCredentialsMatcher matcher = new JwtCredentialsMatcher();
        jwtRealm.setCredentialsMatcher(matcher);
        return jwtRealm;
    }
}