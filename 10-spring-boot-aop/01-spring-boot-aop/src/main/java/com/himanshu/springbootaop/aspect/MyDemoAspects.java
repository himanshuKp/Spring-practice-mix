package com.himanshu.springbootaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoAspects {

    @Pointcut("execution(* com.himanshu.springbootaop.dao.*.*(..))")
    private void beforeDaoPackage() {}

    @Before("beforeDaoPackage()")
    public void beforeAddAccount(){
        System.out.println("==> beforeAddAccount on method in demo aspect");
    }

    @Before("beforeDaoPackage()")
    public void performApiAnalytics(){
        System.out.println("==> performApiAnalytics on method");
    }

    @AfterThrowing(
            pointcut = "beforeDaoPackage()",
            throwing = "exc"
    )
    public void afterThrowingAdviceDemo(JoinPoint joinPoint, Throwable exc){
        System.out.println("==> afterThrowingAdviceDemo on method : "+joinPoint.getSignature().getName());
        System.out.println("==> afterThrowingAdviceDemo on method : "+exc.getMessage());
    }
}
