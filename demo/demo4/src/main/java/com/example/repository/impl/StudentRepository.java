package com.example.repository.impl;

import com.example.model.Student;
import com.example.repository.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1, "sang", new String[]{"hoa", "sinh"}));
        studentList.add(new Student(2, "dan", new String[]{"ly", "toan"}));
        studentList.add(new Student(3, "quy", new String[]{"lich su", "sinh"}));
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public void create(Student student) {
        studentList.add(student);
    }
}
