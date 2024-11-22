package com.luv2code.spring_core_demo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BaseballCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Plean do 50 dribber practice.";
    }
}
