package com.example.service.impl;

import com.example.model.Student;
import com.example.repository.IStudentRepository;
import com.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void create(Student student) {
        studentRepository.create(student);
    }
}
