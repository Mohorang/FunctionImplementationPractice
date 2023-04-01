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

    @GetMapping("/category")
    public List<CategoryResult> getCategories(){
        return categoryService.getAllCategories();
    }

}
