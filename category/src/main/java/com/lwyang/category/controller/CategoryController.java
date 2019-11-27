package com.lwyang.category.controller;

import com.lwyang.category.dto.CategoryDTO;
import com.lwyang.category.dto.EditCategoryDTO;
import com.lwyang.category.service.CategoryService;
import com.lwyang.common.annotation.ResultBodyAdvice;
import com.lwyang.common.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Category模块Controller类
 * @author lwyang  2019/11/25
 */

@RestController
@RequestMapping("categories/")
@ResultBodyAdvice
@Api("CategoryController")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    @ApiOperation(value = "获取类别列表", response = Result.class)
    public List<CategoryDTO> getCategories(@RequestParam(value = "parentId",required = false) Long parentId){
        return categoryService.getCategories(parentId);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取类别",response = Result.class)
    public CategoryDTO getCategory(@PathVariable("id") Long categoryId){
        return categoryService.getCategory(categoryId);
    }

    @PostMapping("/")
    @ApiOperation(value = "添加类别" , response = Result.class)
    public Map<String, String> addCategory(@RequestBody @Validated CategoryDTO categoryDTO){
        return categoryService.addCategory(categoryDTO);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "修改类别", response = Result.class)
    public Optional editCategory(@RequestBody @Validated EditCategoryDTO editCategoryDTO,
                                 @PathVariable("id") Long categoryId){
        return categoryService.editCategory(editCategoryDTO, categoryId);
    }

    @DeleteMapping("{ids}")
    @ApiOperation(value = "删除类别(批量)", response = Result.class)
    public Optional deleteCategories(@PathVariable("ids") List<Long> categoryIds){
        return categoryService.deleteCategories(categoryIds);
    }
}
