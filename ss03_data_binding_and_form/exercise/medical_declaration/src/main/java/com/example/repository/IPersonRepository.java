package com.example.repository;

import com.example.model.Person;

import java.util.List;

public interface IPersonRepository {
    List<Person> findAll();

    Person FindById(int id);

    void create(Person person);

    void update(int id, Person person);
}
