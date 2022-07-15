package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("")
    public String homeController() {
        return "/home";
    }

    @GetMapping("/index")
    public String indexController() {
        return "/index";
    }
}
