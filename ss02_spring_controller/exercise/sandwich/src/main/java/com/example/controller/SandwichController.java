package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"", "/sandwich"})
public class SandwichController {

    @GetMapping("")
    public String save(@RequestParam(value = "condiment", required = false) String[] condiment, Model model) {
        model.addAttribute("listSand", condiment);
        return "sandwich";
    }
}
