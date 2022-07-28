package com.example.service;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Page<Blog> viewBlog(int id, Pageable pageable);

    Page<Blog> findAll(Pageable pageable);

    Optional<Blog> findById(int id);

    void create(Blog blog);

    void update(Blog blog);

    void delete(int id);

    Page<Blog> search(String name, Pageable pageable);
}
