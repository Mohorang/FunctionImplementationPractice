package com.example.question1.repository;

import com.example.question1.domain.Category;
import com.example.question1.dto.CategoryResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query("select c from Category c where c.parent is null")
    List<Category> findCustom();
}
