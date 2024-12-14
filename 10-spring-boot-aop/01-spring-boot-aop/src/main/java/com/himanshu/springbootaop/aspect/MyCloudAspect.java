package com.himanshu.springbootaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
@Order(1)
public class MyCloudAspect {
    @Pointcut("execution(* com.himanshu.springbootaop.dao.*.*(..))")
    private void beforeDaoPackage() {}

    @Before("beforeDaoPackage()")
    public void beforeAddAccount(JoinPoint joinPoint) {
        System.out.println("==> beforeAddAccount on method in cloud aspect");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("===> method signature: " + methodSignature);

        Method method = methodSignature.getMethod();
        System.out.println("===> method: " + method);

        Object[] args = joinPoint.getArgs();
        System.out.println("===> args: " + Arrays.asList(args));
    }
}
