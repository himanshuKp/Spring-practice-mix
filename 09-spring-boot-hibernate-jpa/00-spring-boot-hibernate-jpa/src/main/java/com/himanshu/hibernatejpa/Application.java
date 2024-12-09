package com.himanshu.hibernatejpa;

import com.himanshu.hibernatejpa.dao.AppDao;
import com.himanshu.hibernatejpa.entity.Instructor;
import com.himanshu.hibernatejpa.entity.InstructorDetail;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDao appDao) {
       return runner -> {
//           createInstructor(appDao);
           findInstructor(appDao);
       };
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
