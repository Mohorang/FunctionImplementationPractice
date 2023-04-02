package com.example.question1.controller;


import com.example.question1.domain.Category;
import com.example.question1.dto.CategoryDto;
import com.example.question1.dto.CategoryResult;
import com.example.question1.repository.CategoryRepository;
import com.example.question1.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;

    @PostMapping("/category")
    public void addCategory(@RequestBody CategoryDto dto){
        categoryService.createCategory(dto);
    }
//
//    @PostMapping("/category/anonymous")
//    public void addAnonymousCategory(@RequestBody CategoryDto dto){
//        categoryService.createAnonymousCategory(dto);
//    }


    @GetMapping("/category/id/{id}")
    public List<CategoryResult> getCategoryById(@PathVariable("id") Long categoryId){
        return categoryService.getCategoryById(categoryId);
    }

    @GetMapping("/category/name/{name}")
    public List<CategoryResult> getCategoryByName(@PathVariable("name") String categoryName){
        return categoryService.getCategoryByName(categoryName);
    }

    @GetMapping("/category")
    public List<CategoryResult> getAllCategory(){
        return categoryService.getAllCategories();
    }

}
