package org.bearer.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author fanyuhongzhe
 * @description
 * @date 10/22/23 0:18 PM
 */
@Data
public class SearchRecordsDTO implements Serializable {

    private static final long serialVersionUID = -370850206087589849L;
    
    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 搜索内容
     */
    @TableField(value = "search_content")
    private String searchContent;
}
