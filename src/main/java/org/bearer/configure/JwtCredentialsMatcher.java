package org.bearer.configure;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.bearer.util.JedisUtil;

/**
 * @author fyhz
 * @version 1.0
 * @date Created in 2023/10/17 14:50
 */
public class JwtCredentialsMatcher implements CredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        String clientToken = (String) authenticationToken.getCredentials();
        String redisToken = (String) authenticationInfo.getCredentials();
        String id = (String) authenticationToken.getPrincipal();

        if (clientToken.equals(redisToken)) {
            return JedisUtil.refresh(id, 1000 * 60 * 60 * 24);
        } else {
            return false;
        }
    }
}