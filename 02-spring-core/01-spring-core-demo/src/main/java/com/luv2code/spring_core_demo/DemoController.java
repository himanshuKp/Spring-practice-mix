package com.luv2code.spring_core_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final Coach myCoach;

    @Autowired
    DemoController(Coach theCoach){
        myCoach = theCoach;
    }

    @GetMapping("/getDailyWorkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}