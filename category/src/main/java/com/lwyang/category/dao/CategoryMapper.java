package com.lwyang.category.dao;

import com.lwyang.category.entity.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * category模块操作数据库接口
 * @author lwyang
 */
public interface CategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> selectAllOrByParentId(@Param("parentId") Long parentId);

    int deleteByPrimaryKeyIn(@Param("categoryIds") List<Long> categoryIds);
}