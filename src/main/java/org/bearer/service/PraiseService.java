package org.bearer.service;

import org.bearer.entity.dto.Ids;
import org.bearer.entity.dto.PostId;

/**
 * @author guanjiamin
 * @version 1.0
 * @date Created in 2023/11/01 12:56
 */
public interface PraiseService {

    /**
     * 保存文章点赞
     *
     * @param id JSON{"id":"文章id"}
     * @return int
     */
    int insertArticlePraise(PostId id);

    /**
     * 保存视频点赞
     *
     * @param id JSON{"id":"文章id"}
     * @return int
     */
    int insertVideoPraise(PostId id);
}
