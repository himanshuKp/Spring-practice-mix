package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Employee;
import com.luv2code.demo.entity.UserRegisteredEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EmailNotifier implements ApplicationListener<UserRegisteredEvent> {

    @Override
    public void onApplicationEvent(UserRegisteredEvent event) {
        Employee employee = event.getUser();

        System.out.println("Sending welcome email to : "+employee.getEmail());
    }
}
