package com.example.question1.service;


import com.example.question1.domain.Category;
import com.example.question1.dto.CategoryDto;
import com.example.question1.dto.CategoryResult;
import com.example.question1.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;


    public void createCategory(CategoryDto dto) {
        Category parent = categoryRepository.findById(dto.getParentId()).orElse(null);

        Category newCategory = new Category(parent, dto);
        categoryRepository.save(newCategory);
    }

//    //익명 게시판 생성
//    @Transactional
//    public void createAnonymousCategory(CategoryDto dto) {
//        List<Category> parent = categoryRepository.findByLevel(dto.getLevel()-1);
//
//        Category anonymousCategory = new Category(parent.get(0), dto);
//        for (int i = 1; i < parent.size(); i++) {
//            parent.get(i).addSubCategory(parent.get(i),anonymousCategory);
//        }
//
//        categoryRepository.save(anonymousCategory);
//    }

    //모든 카테고리 검색
    @Transactional
    public List<CategoryResult> getAllCategories() {
        List<Category> result = categoryRepository.findAllCategory();
        List<CategoryResult> a = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            Category c = result.get(i);
            a.add(new CategoryResult(c.getId(),c.getName(),c.getLevel(),c.getSub()));
        }

        return a;
    }

    //카테고리 식별자로 검색
    @Transactional
    public List<CategoryResult> getCategoryById(Long categoryId) {
        Category result = categoryRepository.findByCategoryId(categoryId);
        List<CategoryResult> b = new ArrayList<>();
        b.add(new CategoryResult(result.getId(),result.getName(),result.getLevel(),result.getSub()));

        return b;
    }

    //카테코리 이름으로 검색
    @Transactional
    public List<CategoryResult> getCategoryByName(String categoryName) {
        Category result = categoryRepository.findByCategoryName(categoryName);
        List<CategoryResult> b = new ArrayList<>();
        b.add(new CategoryResult(result.getId(),result.getName(),result.getLevel(),result.getSub()));

        return b;
    }
}
