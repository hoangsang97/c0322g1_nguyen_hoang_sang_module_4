package com.example.controller;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
public class ProductAspect {

    @Pointcut("execution(* com.example.controller.ProductController.showList(..))")
    public void allMethodPointCut() {}

    @Before("allMethodPointCut()")
    public void beforeCallMethod() {
        System.out.println(LocalDate.now());
    }
}
