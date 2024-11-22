package com.luv2code.spring_core_demo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class TennisCoach implements Coach{

    public TennisCoach() {
        System.out.println("tenniscoach");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice backend volley";
    }
}
