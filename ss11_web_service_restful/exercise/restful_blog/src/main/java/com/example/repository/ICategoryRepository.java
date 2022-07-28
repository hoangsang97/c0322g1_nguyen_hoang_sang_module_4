package com.example.repository;

import com.example.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    @Modifying
    @Query(value = "update category set name = :name where id = :id", nativeQuery = true)
    void update(@Param("name") String name, @Param("id") int id);
}
