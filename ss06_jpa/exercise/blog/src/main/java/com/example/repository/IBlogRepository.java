package com.example.repository;

import com.example.model.Blog;

import java.util.List;

public interface IBlogRepository {
    List<Blog> findAll();

    Blog findById(int id);

    void create(Blog blog);

    void update(Blog blog);

    void delete(int id);
}
