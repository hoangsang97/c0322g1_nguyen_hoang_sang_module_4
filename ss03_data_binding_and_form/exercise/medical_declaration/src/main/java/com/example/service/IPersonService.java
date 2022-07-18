package com.example.service;

import com.example.model.Person;

import java.util.List;

public interface IPersonService {
    List<Person> findAll();

    String[] yearOfBirth();

    String[] gender();

    String[] nationality();

    Person FindById(int id);

    void create(Person person);

    void update(int id, Person person);
}
