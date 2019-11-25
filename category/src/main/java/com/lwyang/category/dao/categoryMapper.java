package com.lwyang.category.dao;

import com.lwyang.category.entity.category;

public interface categoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(category record);

    int insertSelective(category record);

    category selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(category record);

    int updateByPrimaryKey(category record);
}