package com.himanshu.hibernatejpa.dao;

import com.himanshu.hibernatejpa.entity.Course;
import com.himanshu.hibernatejpa.entity.Instructor;
import com.himanshu.hibernatejpa.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDaoImpl implements AppDao {
    private EntityManager entityManager;

    @Autowired
    public AppDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Transactional
    @Override
    public void deleteInstructor(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        instructor.getCourses().forEach(course -> course.setInstructor(null));
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Transactional
    @Override
    public void deleteInstructorDetail(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructor(int id) {
        TypedQuery<Course> findCourses = entityManager.createQuery("from Course c where c.instructor.id = :id", Course.class);
        findCourses.setParameter("id", id);
        List<Course> courses = findCourses.getResultList();
        System.out.println(courses);
        return courses;
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void deleteCourse(int courseId) {
        Course course = entityManager.find(Course.class, courseId);
        entityManager.remove(course);
    }
}
