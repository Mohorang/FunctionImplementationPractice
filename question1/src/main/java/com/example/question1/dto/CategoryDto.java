package com.example.question1.dto;

import com.example.question1.domain.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 카테고리 등록용 Dto
 * 최상위 카테고리의 경우 0같은 수를 입력해주면 Parent가 null이 되고 최상위 카테고리로 들어간다.
 */
@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {
    private String name;
    private Long parentId;
    private int level;

    public CategoryDto(String name, Long parentId, int level) {
        this.name = name;
        this.parentId = parentId;
        this.level = level;
    }
}
