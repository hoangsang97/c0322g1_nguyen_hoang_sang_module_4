package com.example.service;

import com.example.model.Listen;

import java.util.List;

public interface IListenService {
    List<Listen> findAll();

    Listen findById(int id);

    void create(Listen listen);

    void update(int id, Listen listen);

    void delete(int id);

    List<Listen> search(String name);
}
