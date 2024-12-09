package com.himanshu.hibernatejpa;

import com.himanshu.hibernatejpa.dao.AppDao;
import com.himanshu.hibernatejpa.entity.Course;
import com.himanshu.hibernatejpa.entity.Instructor;
import com.himanshu.hibernatejpa.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDao appDao) {
       return runner -> {
//           createInstructor(appDao);
//           findInstructor(appDao);
//           deleteInstructor(appDao);
//           findInstructorDetail(appDao);
//           createCourseWithInstructor(appDao);
//           findCoursesWithInstructor(appDao);
//           updateCourse(appDao);
           updateInstructor(appDao);
       };
    }

    private void updateInstructor(AppDao appDao) {
        int instructorId = 1;
        Instructor instructor = appDao.findById(instructorId);
        instructor.setFirstName("Himanshu");
        appDao.updateInstructor(instructor);
        System.out.println(instructor.getFirstName());
    }

    private void updateCourse(AppDao appDao) {
        int courseId = 10;
        Course course = appDao.findCourseById(courseId);
        course.setTitle("Updated name 1");
        appDao.updateCourse(course);
        System.out.println("Course updated");
    }

    private void findCoursesWithInstructor(AppDao appDao) {
        int instructorId = 1;
        System.out.println("Finding instructor: " + instructorId);
        Instructor instructor = appDao.findById(instructorId);
        System.out.println("Found instructor: " + instructor);

        List<Course> courses = appDao.findCoursesByInstructor(instructorId);
        System.out.println("Found courses: " + courses);
        instructor.setCourses(courses);

        System.out.println("course: " + instructor.getCourses());
    }

    private void createCourseWithInstructor(AppDao appDao) {
        Instructor instructor = new Instructor();
        instructor.setFirstName("John");
        instructor.setLastName("Smith");
        instructor.setEmail("john.smith@gmail.com");
        instructor.setInstructorDetail(new InstructorDetail("youtube.com", "Football"));

        Course course = new Course("abc");
        Course course2 = new Course("def");
        Course course3 = new Course("ghi");
        instructor.addCourse(course);
        instructor.addCourse(course2);
        instructor.addCourse(course3);

        appDao.save(instructor);
    }

    private void findInstructorDetail(AppDao appDao) {
        int id = 2;
        System.out.println("Finding instructor detail by id: " + id);
        System.out.println(appDao.findInstructorDetailById(id).getInstructor());
        System.out.println("Stop");
    }

    private void deleteInstructor(AppDao appDao) {
        int instructorId = 1;
        System.out.println("Deleting instructor " + instructorId);

        appDao.deleteInstructor(instructorId);

        System.out.println("Deleted instructor " + instructorId);
    }

    private void findInstructor(AppDao appDao) {
        int instructorId = 1;
        System.out.println("Finding instructor " + instructorId);
        Instructor instructor = appDao.findById(instructorId);
        System.out.println("Found instructor " + instructor);
    }

    private void createInstructor(AppDao appDao) {
        Instructor instructor = new Instructor("rishabh","kandpal","rishi@gmail.com");

        InstructorDetail instructorDetail = new InstructorDetail("rishi","dancing");

        instructor.setInstructorDetail(instructorDetail);

        System.out.println("Saving the instructor");
        appDao.save(instructor);
        System.out.println("Saved the instructor");
    }
}
