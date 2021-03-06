package com.example.repository.impl;

import com.example.model.Person;
import com.example.repository.IPersonRepository;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository implements IPersonRepository {
    private static List<Person> personList = new ArrayList<>();
    static {
        personList.add(new Person(1, "sang", "1997", "Male", "Viet Nam", 3232431, "Tàu bay", "31341", 2, "2022-18-09", "2022-20-09", "khong", "da nang", "que son", 312124, "sadsad@gmail.com"));
        personList.add(new Person(2, "sang", "1997", "Female", "Lao", 3232431, "Tàu bay", "31341", 2, "2022-18-09", "2022-20-09", "khong", "da nang", "que son", 312124, "sadsad@gmail.com"));
        personList.add(new Person(3, "sang", "1997", "Female", "Viet Nam", 3232431, "Tàu bay", "31341", 2, "2022-18-09", "2022-20-09", "khong", "da nang", "que son", 312124, "sadsad@gmail.com"));
    }

    String[] yearOfBirth = new String[]{"1989", "1990", "...", "2022"};
    String[] gender = new String[]{"Male", "Female"};
    String[] nationality = new String[]{"Viet Nam", "Lao", "Campuchia"};

    @Override
    public List<Person> findAll() {
        return personList;
    }

    @Override
    public String[] yearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public String[] gender() {
        return gender;
    }

    @Override
    public String[] nationality() {
        return nationality;
    }

    @Override
    public Person FindById(int id) {
        for (Person item: personList) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void create(Person person) {
        personList.add(person);
    }

    @Override
    public void update(int id, Person person) {
        for (Person item: personList) {
            if (item.getId() == id) {
                item.setName(person.getName());
                item.setYearOfBirth(person.getYearOfBirth());
                item.setGender(person.getGender());
                item.setNationality(person.getNationality());
                item.setIdCard(person.getIdCard());
                item.setVehicle(person.getVehicle());
                item.setNumberVehicle(person.getNumberVehicle());
                item.setSeats(person.getSeats());
                item.setStarDate(person.getStarDate());
                item.setEndDate(person.getEndDate());
                item.setText(person.getText());
                item.setAddressContact(person.getAddressContact());
                item.setAddress(person.getAddress());
                item.setPhone(person.getPhone());
                item.setEmail(person.getEmail());
            }
        }
    }
}
