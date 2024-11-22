package com.luv2code.spring_core_demo.common;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("in constructor: swimcoach");
    }

    @Override
    public String getDailyWorkout() {
        return "time to swim 1000 meters.";
    }
}
