package com.himanshukandpal.thymeleafSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homePage(){
        return "home";
    }

    @GetMapping("/leaders")
    public String leadersPage(){
        return "leaders";
    }

    @GetMapping("/systems")
    public String systemsPage(){
        return "systems";
    }
}
