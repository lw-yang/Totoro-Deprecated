package com.lwyang.category.service;

import com.lwyang.category.dto.CategoryDTO;

import java.util.List;
import java.util.Map;

/**
 * Category模块Service接口
 * @author lwyang  2019/11/25
 */
public interface CategoryService {
    List<CategoryDTO> getRootCategory();

    CategoryDTO getCategory(String categoryId);

    Map<String, String> addCategory(CategoryDTO categoryDTO);
}
