package org.bearer.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author fanyuhongzhe
 * @description
 * @date 6/22/21 9:27 AM
 */
@Data
public class VideoDTO implements Serializable {

    private static final long serialVersionUID = 4220432718859788043L;

    /**
     * 标题
     */
    private String title;

    /**
     * 视频url
     */
    private String videoUrl;

    /**
     * 视频截图
     */
    private String pictureUrl;

    /**
     * 作者id
     */
    private String authorId;

    /**
     * 菜系分类id
     */
    private String cuisineId;

    /**
     * 主材id
     */
    private String materialId;
}
