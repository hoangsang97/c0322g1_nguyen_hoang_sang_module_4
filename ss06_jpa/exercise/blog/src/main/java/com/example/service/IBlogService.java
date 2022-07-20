package com.example.service;

import com.example.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(int id);

    void create(Blog blog);

    void update(Blog blog);

    void delete(int id);
}
