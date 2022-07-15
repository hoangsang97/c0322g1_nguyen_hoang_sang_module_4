package com.example.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnerController {

    @GetMapping(value = "/hello", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String hello() {
        return "Hello word!";
    }
}
