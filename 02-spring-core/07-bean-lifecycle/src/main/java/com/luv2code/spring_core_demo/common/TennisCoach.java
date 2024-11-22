package com.luv2code.spring_core_demo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    public TennisCoach() {
        System.out.println("tenniscoach");
    }

    @PostConstruct
    public void postConstructMethod(){
        System.out.println("in postConstructMethod");
    }

    @PreDestroy
    public void preDestroyMethod(){
        System.out.println("in predestroy method");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice backend volley";
    }
}
