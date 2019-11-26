package com.lwyang.category.service;

import com.lwyang.category.dto.CategoryDTO;
import com.lwyang.category.dto.EditCategoryDTO;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Category模块Service接口
 * @author lwyang  2019/11/25
 */
public interface CategoryService {
    List<CategoryDTO> getRootCategory();

    CategoryDTO getCategory(Long categoryId);

    Map<String, String> addCategory(CategoryDTO categoryDTO);

    Optional editCategory(EditCategoryDTO editCategoryDTO);
}
