package com.example.config;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class ExceptionHandle {

    @ExceptionHandler(Exception.class)
    public String showErrorPage() {
        return "error";
    }
}
