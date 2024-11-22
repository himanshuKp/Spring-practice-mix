package com.luv2code.spring_core_demo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BaseballCoach implements Coach{

    public BaseballCoach() {
        System.out.println("basecall coach");
    }

    @Override
    public String getDailyWorkout() {
        return "Plean do 50 dribber practice.";
    }
}
