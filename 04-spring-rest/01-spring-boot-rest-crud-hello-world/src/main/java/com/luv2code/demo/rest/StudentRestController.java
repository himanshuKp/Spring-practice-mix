package com.luv2code.demo.rest;

import com.luv2code.demo.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("findStudent/{studentId}")
    private User getStudent(@PathVariable int studentId){
        if(studentId > studentsList.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found: "+studentId);
        }

        return studentsList.get(studentId);
    }

    @ExceptionHandler
    private ResponseEntity<StudentErrorResponse> handleStudentException(StudentNotFoundException exception){
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setErrorCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setErrorMessage(exception.getMessage());
        errorResponse.setErrorTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
