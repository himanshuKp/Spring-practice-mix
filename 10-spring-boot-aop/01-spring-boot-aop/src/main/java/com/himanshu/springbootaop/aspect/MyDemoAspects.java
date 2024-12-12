package com.himanshu.springbootaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoAspects {

    @Before("execution(public void add*())")
    public void before() {
        System.out.println("=====>calling the before add*()<======");
    }
}
