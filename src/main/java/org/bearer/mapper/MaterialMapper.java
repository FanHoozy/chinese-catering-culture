package org.bearer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.bearer.entity.vo.Material;

import java.util.List;

/**
 * @author chenmengyu
 * @version 1.0
 * @date Created in 2023/11/14 13:47
 */
@Mapper
public interface MaterialMapper {
    /**
     * 查询所有材料名
     *
     * @return List<Material>
     */
    List<Material> selectList();
}
