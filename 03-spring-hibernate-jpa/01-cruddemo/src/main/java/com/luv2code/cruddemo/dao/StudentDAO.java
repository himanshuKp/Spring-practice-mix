package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(int studentId);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void updateStudent(Student student);
}
