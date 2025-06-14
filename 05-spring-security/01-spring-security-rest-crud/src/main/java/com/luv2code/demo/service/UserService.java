package com.luv2code.demo.service;

import com.luv2code.demo.entity.Employee;
import com.luv2code.demo.entity.UserRegisteredEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class UserService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void registerUser(Employee employee){
        // register user logic

//        public the event
        applicationEventPublisher.publishEvent(new UserRegisteredEvent(employee));
    }
}

