package org.bearer.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author chenmengyu
 * @version 1.0
 * @date Created in 2023/11/14 15:40
 */
@Mapper
public interface MaterialNameMapper {
    /**
     * 主材和菜名的关联
     *
     * @param materialId 主材id
     * @param id 菜名id
     * @return boolean
     */
    Boolean insertMaterialName(String materialId, String id);
}
