package com.luv2code.demo.exception;

import com.luv2code.demo.rest.StudentErrorResponse;
import com.luv2code.demo.rest.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    @ExceptionHandler
    private ResponseEntity<StudentErrorResponse> handleStudentException(StudentNotFoundException exception){
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setErrorCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setErrorMessage(exception.getMessage());
        errorResponse.setErrorTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    //    generic exception handler
    @ExceptionHandler
    private ResponseEntity<StudentErrorResponse> handleGenericStudentException(Exception exception){
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setErrorMessage(exception.getMessage());
        errorResponse.setErrorTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
