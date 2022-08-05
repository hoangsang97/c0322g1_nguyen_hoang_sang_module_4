package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("")
    public String homeFacility(){
        return "homeFacility";
    }

    @GetMapping("/home")
    public String homeLoginFacility(){
        return "homeFacility";
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }
}
