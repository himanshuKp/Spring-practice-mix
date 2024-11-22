package com.luv2code.spring_core_demo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    public TennisCoach() {
        System.out.println("tenniscoach");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice backend volley";
    }
}
