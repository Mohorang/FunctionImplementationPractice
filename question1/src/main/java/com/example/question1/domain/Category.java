package com.example.question1.domain;

import com.example.question1.dto.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> sub = new ArrayList<>();

    public Category(Category parent , CategoryDto dto){
        this.name = dto.getName();
        this.parent = parent;
        if(parent != null){
            parent.sub.add(this);
        }
    }
}
