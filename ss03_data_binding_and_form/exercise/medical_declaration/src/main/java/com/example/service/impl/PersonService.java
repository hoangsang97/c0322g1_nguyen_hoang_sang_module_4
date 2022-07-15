package com.example.service.impl;

import com.example.model.Person;
import com.example.repository.IPersonRepository;
import com.example.repository.impl.PersonRepository;
import com.example.service.IPersonService;

import java.util.List;

public class PersonService implements IPersonService {
    private IPersonRepository personRepository = new PersonRepository();

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person FindById(int id) {
        return personRepository.FindById(id);
    }

    @Override
    public void create(Person person) {
        personRepository.create(person);
    }

    @Override
    public void update(int id, Person person) {
        personRepository.update(id, person);
    }
}
