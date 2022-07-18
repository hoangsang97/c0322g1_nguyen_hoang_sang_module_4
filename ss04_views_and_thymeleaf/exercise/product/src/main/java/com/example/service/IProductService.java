package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product FindById(int id);

    String[] productDescribe();

    void create(Product product);

    void update(int id, Product product);

    void delete(int id);

    List<Product> search(String name);
}
