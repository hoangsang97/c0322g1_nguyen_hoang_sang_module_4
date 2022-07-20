package com.example.repository;

import com.example.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();

    Customer findById(int id);

    void create (Customer customer);

    void update(int id, Customer customer);

    void delete(int id);

    List<Customer> search(String name);
}
