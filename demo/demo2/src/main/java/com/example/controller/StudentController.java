package com.example.controller;

import com.example.model.Student;
import com.example.service.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String showListStudent(Model model) {
        List<Student> studentList = studentService.findAll();
        model.addAttribute("student", studentList);
        return "view";
    }
}
