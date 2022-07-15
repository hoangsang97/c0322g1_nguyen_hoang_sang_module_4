package com.example.controller;

import com.example.service.ConversionServiceImpl;
import com.example.service.IConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/conversion")
public class Conversion {
    private IConversionService conversionService = new ConversionServiceImpl();

    @GetMapping
    public String convertUsd(@RequestParam(defaultValue = "0") int usd, Model model) {
        int result = conversionService.conversion(usd);
        model.addAttribute("result", result);
        return "conversion";
    }
}
