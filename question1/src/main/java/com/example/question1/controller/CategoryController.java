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

    //카테고리 추가
    @PostMapping("/category")
    public void addCategory(@RequestBody CategoryDto dto){
        categoryService.createCategory(dto);
    }
//
//    @PostMapping("/category/anonymous")
//    public void addAnonymousCategory(@RequestBody CategoryDto dto){
//        categoryService.createAnonymousCategory(dto);
//    }


    //식별번호로 카테고리 조회
    @GetMapping("/category/id/{id}")
    public List<CategoryResult> getCategoryById(@PathVariable("id") Long categoryId){
        return categoryService.getCategoryById(categoryId);
    }

    //카테고리 이름으로 조회
    @GetMapping("/category/name/{name}")
    public List<CategoryResult> getCategoryByName(@PathVariable("name") String categoryName){
        return categoryService.getCategoryByName(categoryName);
    }

    //최상위 카테고리부터 최하위까지 모든 카테고리 조회
    @GetMapping("/category")
    public List<CategoryResult> getAllCategory(){
        return categoryService.getAllCategories();
    }

}
