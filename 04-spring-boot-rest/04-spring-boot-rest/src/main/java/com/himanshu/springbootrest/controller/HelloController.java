package com.himanshu.springbootrest.controller;

import com.himanshu.springbootrest.entity.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public Response getHello(){
        return new Response("hello");
    }
}
