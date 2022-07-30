package com.example.service;

import com.example.model.Phone;

import java.util.List;
import java.util.Optional;

public interface IPhoneService {
    List<Phone> findAll();

    Optional<Phone> findById(int id);

    void create(Phone phone);

    void update(Phone phone);

    void delete(int id);

    List<Phone> search(String name);
}
