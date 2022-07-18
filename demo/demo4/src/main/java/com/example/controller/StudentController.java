package com.example.controller;

import com.example.model.Student;
import com.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("showList")
    public ModelAndView showList() {
        List<Student> studentList = studentService.findAll();
        ModelAndView modelAndView = new ModelAndView("student/list", "student", studentList);
        return modelAndView;
    }

    @GetMapping("showCreate")
    public String showCreate(Model model) {
        List<String> subjectList = new ArrayList<>();
        subjectList.add("hoa");
        subjectList.add("sinh");
        subjectList.add("toan");
        model.addAttribute("subjectList", subjectList);
        model.addAttribute("student", new Student());
        return "student/create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Student student,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        studentService.create(student);
        redirectAttributes.addFlashAttribute("mess", "Update Oke");
//        List<Student> studentList = studentService.findAll();
//        model.addAttribute("student", studentList);
//        return "student/list";
        return "redirect:/student/showList";
    }

    @GetMapping("test/{age}/edit")
    public String getParam(Model model, @PathVariable int age) {
        model.addAttribute("age", age);
        return "student/detail";
    }
}
