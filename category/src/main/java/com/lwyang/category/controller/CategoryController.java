package com.lwyang.category.controller;

import com.lwyang.category.dto.CategoryDTO;
import com.lwyang.category.service.CategoryService;
import com.lwyang.common.annotation.ResultBodyAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Category模块Controller类
 * @author lwyang  2019/11/25
 */

@RestController
@RequestMapping("category/")
@ResultBodyAdvice
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public List<CategoryDTO> getRootCategories(){
        return categoryService.getRootCategory();
    }

    @GetMapping("/{categoryId}")
    public CategoryDTO getCategory(@PathVariable("categoryId") String categoryId){
        return categoryService.getCategory(categoryId);
    }

    @PostMapping("/")
    public Map<String, String> addCategory(@RequestBody @Validated CategoryDTO categoryDTO){
        return categoryService.addCategory(categoryDTO);
    }
}
