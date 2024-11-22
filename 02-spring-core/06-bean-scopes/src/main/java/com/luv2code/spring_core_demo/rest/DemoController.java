package com.luv2code.spring_core_demo.rest;

import com.luv2code.spring_core_demo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    @Autowired
    DemoController(@Qualifier("tennisCoach") Coach theCoach,
                   @Qualifier("tennisCoach") Coach otherCoach){
        System.out.println("in constructor:  "+theCoach.getClass().getName());
        myCoach = theCoach;
        System.out.println("Prototype: "+(theCoach == otherCoach));
    }

    @GetMapping("/getDailyWorkout")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
