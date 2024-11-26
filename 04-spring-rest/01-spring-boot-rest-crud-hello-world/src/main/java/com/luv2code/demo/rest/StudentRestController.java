package com.luv2code.demo.rest;

import com.luv2code.demo.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("api")
public class StudentRestController {
    private List<User> studentsList;

    private static final Logger logger = Logger.getLogger(StudentRestController.class.getName());

    @PostConstruct
    private void loadData(){
        logger.info("Load Data postcontruct called");
        studentsList = new ArrayList<>();

        studentsList.add(new User("himanshu","kandpal"));
        studentsList.add(new User("pratibha", "joshi"));
    }

    @GetMapping("allStudents")
    private List<User> getStudentsList(){
        return studentsList;
    }
}
