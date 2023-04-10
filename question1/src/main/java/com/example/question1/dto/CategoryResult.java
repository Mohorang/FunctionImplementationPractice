package com.example.question1.dto;

import com.example.question1.domain.Category;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 카테고리 목록을 불러올 때 사용되는 DTO
 * 식별번호를 통한 카테고리 조회 , 카테고리 이름으로 조회  둘 다 사용된다.
 * 하위 카테고리가 존재하면 하위 카테고리도 전부 불러온다.
 */
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
