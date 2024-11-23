package com.luv2code.spring_core_demo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach, Stadium {

    public CricketCoach() {
        System.out.println("cricketcoach");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes.";
    }

    @Override
    public void stadimName() {

    }
}
