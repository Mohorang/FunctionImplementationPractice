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
    private List<CategoryResult> sub = new ArrayList<>();

    public CategoryResult(Long id , String name, List<Category> sub){
        this.id = id;
        this.name = name;
        for (Category category : sub) {
            if(category.getSub() != null) {
                this.sub.add(new CategoryResult(category.getId(), category.getName(), category.getSub()));
            }
        }
    }
}
