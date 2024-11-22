package com.luv2code.spring_core_demo.config;

import com.luv2code.spring_core_demo.common.Coach;
import com.luv2code.spring_core_demo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwimConfig {

    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
