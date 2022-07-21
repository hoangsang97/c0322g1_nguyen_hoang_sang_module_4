package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.codegym.model.Student;
import vn.codegym.service.IStudentService;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("")
    public String homeStudent(@PageableDefault(value = 1) Pageable pageable, Model model) {
        Page<Student> studentList = studentService.findAll(pageable);
        model.addAttribute("student", studentList);
        return "student/list";
    }
}
