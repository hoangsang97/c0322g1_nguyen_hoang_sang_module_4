package com.example.service;

import com.example.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    void create(Student student);
}
