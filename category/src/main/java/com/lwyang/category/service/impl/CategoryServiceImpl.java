package com.lwyang.category.service.impl;

import com.lwyang.category.dao.CategoryMapper;
import com.lwyang.category.dto.CategoryDTO;
import com.lwyang.category.dto.EditCategoryDTO;
import com.lwyang.category.entity.Category;
import com.lwyang.category.enums.CategoryConstEnum;
import com.lwyang.category.enums.CategoryErrorEnum;
import com.lwyang.category.exception.CategoryException;
import com.lwyang.category.service.CategoryService;
import com.lwyang.common.util.IdUtil;
import lombok.Builder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Category模块Service实现类
 * @author lwyang  2019/11/25
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryDTO> getCategories(@Nullable Long parentId){
        List<Category> categories = categoryMapper.selectAllOrByParentId(parentId);
        List<CategoryDTO> categoryDTOS = new ArrayList<>(categories.size());
        for (Category category : categories) {
            CategoryDTO categoryDTO = new CategoryDTO();
            BeanUtils.copyProperties(category, categoryDTO);
            categoryDTOS.add(categoryDTO);
        }
        return categoryDTOS;
    }

    @Override
    public CategoryDTO getCategory(Long categoryId) {
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        if (category == null){
            throw new CategoryException(CategoryErrorEnum.CATEGORY_NOT_EXIST);
        }
        CategoryDTO categoryDTO = new CategoryDTO();
        BeanUtils.copyProperties(category, categoryDTO);
        return categoryDTO;
    }

    @Override
    public Map<String, String> addCategory(CategoryDTO categoryDTO){
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO, category);
        Long id = IdUtil.nextId();
        category.setId(id);
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());

        if (0 == categoryMapper.insertSelective(category)){
            throw new CategoryException(CategoryErrorEnum.CATEGORY_INSERT_ERROR);
        }
        Map<String, String> returnData = new HashMap<>(1,1);
        returnData.put(CategoryConstEnum.CATEGORY_ID.getStr(), String.valueOf(id));
        return returnData;
    }

    @Override
    public Optional editCategory(EditCategoryDTO editCategoryDTO, Long categoryId){

        Category category = new Category();
        BeanUtils.copyProperties(editCategoryDTO, category);
        category.setId(categoryId);
        if (0 == categoryMapper.updateByPrimaryKeySelective(category)){
            throw new CategoryException(CategoryErrorEnum.CATEGORY_UPDATE_ERROR);
        }
        return Optional.empty();
    }

    @Override
    public Optional deleteCategories(List<Long> categoryIds){
        if (0 == categoryMapper.deleteByPrimaryKeyIn(categoryIds)){
            throw new CategoryException(CategoryErrorEnum.CATEGORY_DELETE_ERROR);
        }
        return Optional.empty();
    }
}
