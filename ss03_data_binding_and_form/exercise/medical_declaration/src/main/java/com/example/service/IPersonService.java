package com.example.service;

import com.example.model.Person;

import java.util.List;

public interface IPersonService {
    List<Person> findAll();

    Person FindById(int id);

    void create(Person person);

    void update(int id, Person person);
}
