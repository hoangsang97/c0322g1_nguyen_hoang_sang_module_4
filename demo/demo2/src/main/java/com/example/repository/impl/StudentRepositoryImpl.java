package com.example.repository.impl;

import com.example.model.Student;
import com.example.repository.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements IStudentRepository {
    public static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student(1, "Nguyen Van A", new String[]{"JAVA", "C#"}));
        studentList.add(new Student(2, "Nguyen Van B", new String[]{"C#"}));
        studentList.add(new Student(3, "Nguyen Van C", new String[]{"JAVA"}));

    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }
}
