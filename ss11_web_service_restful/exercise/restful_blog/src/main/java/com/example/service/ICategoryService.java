package com.example.service;

import com.example.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> finAllCategory();

    Page<Category> findAll(Pageable pageable);

    Optional<Category> findById(int id);

    void create(Category category);

    void delete(int id);

    void update(Category category);
}
