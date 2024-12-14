package com.himanshu.springbootaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudAspect {
    @Pointcut("execution(* com.himanshu.springbootaop.dao.*.*(..))")
    private void beforeDaoPackage() {}

    @Before("beforeDaoPackage()")
    public void beforeAddAccount(){
        System.out.println("==> beforeAddAccount on method in cloud aspect");
    }
}
