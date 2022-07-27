package vn.codegym.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
public class DemoAspect {

//    @Pointcut("execution(* vn.codegym.controller.StudentController.showList(..))")
    @Pointcut("within(vn.codegym.controller.StudentController.*)")
    public void allMethodPointCut() {
    }

    @Before("allMethodPointCut()")
    public void beforeCallMethod(JoinPoint joinPoint) {
        System.out.println("Star method name" + joinPoint.getSignature().getName() + LocalDate.now());
    }
}
