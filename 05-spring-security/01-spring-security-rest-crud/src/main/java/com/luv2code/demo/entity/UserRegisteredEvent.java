package com.luv2code.demo.entity;

import org.springframework.context.ApplicationEvent;

public class UserRegisteredEvent extends ApplicationEvent {
    private final Employee user;

    public UserRegisteredEvent(Employee user) {
        super(user);
        this.user = user;
    }

    public Employee getUser(){
        return user;
    }
}
