package com.lwyang.category.service.impl;

import com.lwyang.category.CategoryApplication;
import com.lwyang.category.dao.CategoryMapper;
import com.lwyang.category.entity.Category;
import com.lwyang.category.service.CategoryService;
import com.lwyang.common.util.IdUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = CategoryApplication.class)
class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    void getRootCategory() {
        System.out.println(categoryService.getCategories(null));
        Assertions.assertEquals(categoryService.getCategories(null).size(), 3);
    }

    @Test
    void addCategory() {
        Category category = new Category();
        category.setId(IdUtil.nextId());
        category.setName("taet");
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.insertSelective(category);
    }
}