package com.example.question1.domain;

import com.example.question1.dto.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * 자기 자신과 연관관계를 맺도록 테이블을 설계햇습니다.
 */
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //카테고리 이름
    private String name;

    //카테고리 레벨
    private int level;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> sub = new ArrayList<>();

    public Category(Category parent , CategoryDto dto){
        this.name = dto.getName();
        this.level = dto.getLevel();
        this.parent = parent;
        if(parent != null){
            parent.sub.add(this);
        }
    }

    public void addSubCategory(Category parent , Category anonymousCategory) {
        parent.sub.add(anonymousCategory);
    }
}
