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
        Category id = categoryRepository.findById(dto.getParentId()).orElse(null);

        Category newCategory = new Category(id, dto);
        categoryRepository.save(newCategory);
    }

    @Transactional
    public List<CategoryResult> getAllCategories() {
        List<Category> result = categoryRepository.findCustom();
        List<CategoryResult> a = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            Category c = result.get(i);
            a.add(new CategoryResult(c.getId(),c.getName(),c.getSub()));
        }

        return a;
    }
}
