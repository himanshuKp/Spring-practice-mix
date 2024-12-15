package com.himanshu.springbootrest.controller;

import com.himanshu.springbootrest.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private static final List<Student> studentList = new ArrayList<>();
    private static int studentId = 0;

    static {
        studentList.add(new Student(++studentId,"himanshu"));
        studentList.add(new Student(++studentId,"rishabh"));
    }

    @GetMapping
    public ResponseEntity<?> students(){
        if(studentList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(studentList);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        student.setId(++studentId);
        studentList.add(student);

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateStudent(@RequestBody Student student){
        if (studentList.contains(student)) {
            student.setName(student.getName());
            studentList.set(studentList.indexOf(student), student);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id){
        Student student = studentList.get(id);
        if (studentList.contains(student)) {
            studentList.remove(student);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
