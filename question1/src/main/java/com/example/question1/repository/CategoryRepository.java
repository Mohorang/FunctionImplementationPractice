package com.example.question1.repository;

import com.example.question1.domain.Category;
import com.example.question1.dto.CategoryResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    //가장 위의 카테고리는 parent가 null이므로 parent가 null인 row를 검색
    @Query("select c from Category c where c.parent is null")
    List<Category> findAllCategory();

    @Query("select c from Category c  where c.level = :level")
    List<Category> findByLevel(@Param("level") int level);

    @Query("select c from Category c where c.id = :id")
    Category findByCategoryId(@Param("id") Long id);

    @Query("select c from Category c where c.name = :name")
    Category findByCategoryName(@Param("name") String categoryName);
}
