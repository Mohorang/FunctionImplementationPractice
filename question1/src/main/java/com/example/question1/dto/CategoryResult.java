package com.example.question1.dto;

import com.example.question1.domain.Category;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class CategoryResult {
    private Long id;
    private String name;
    private int level;
    private List<CategoryResult> sub = new ArrayList<>();

    public CategoryResult(Long id , String name, int level,List<Category> sub){
        this.id = id;
        this.name = name;
        this.level = level;
        for (Category category : sub) {
            if(category.getSub() != null) {
                this.sub.add(new CategoryResult(category.getId(), category.getName(), category.getLevel(),category.getSub()));
            }
        }
    }
}
