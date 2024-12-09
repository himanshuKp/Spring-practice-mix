package com.himanshu.hibernatejpa.dao;

import com.himanshu.hibernatejpa.entity.Course;
import com.himanshu.hibernatejpa.entity.Instructor;
import com.himanshu.hibernatejpa.entity.InstructorDetail;

import java.util.List;

public interface AppDao {
    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteInstructor(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetail(int id);

    List<Course> findCoursesByInstructor(int id);
}
