package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("calculator")
    public String calculation(@RequestParam(required = false, defaultValue = "0") int numLeft,
                              @RequestParam(required = false, defaultValue = "0") int numRight,
                              @RequestParam(required = false, defaultValue = "0") String cal,
                              Model model) {
        int result = 0;
        switch (cal) {
            case "Addition":
                result = numLeft + numRight;
                break;
            case "Subtraction":
                result = numLeft - numRight;
                break;
            case "Multiplication":
                result = numLeft * numRight;
                break;
            case "Division":
                result = numLeft / numRight;
                break;
        }
        model.addAttribute("numLeft", numLeft);
        model.addAttribute("numRight", numRight);
        model.addAttribute("result", result);
        return "calculator";
    }
}
