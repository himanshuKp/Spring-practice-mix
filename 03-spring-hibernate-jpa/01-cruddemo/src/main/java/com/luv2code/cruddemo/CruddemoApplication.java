package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			createStudent(studentDAO);

//			createMultipleStudents(studentDAO);

//			readStudent(studentDAO);

//			getAllStudents(studentDAO);

			getAllStudentsBasedOnLastName(studentDAO);
		};
	}

	private void getAllStudentsBasedOnLastName(StudentDAO studentDAO) {
		studentDAO.findByLastName("test").parallelStream().forEachOrdered(System.out::println);
	}

	private void getAllStudents(StudentDAO studentDAO) {
		studentDAO.findAll().parallelStream().forEachOrdered(System.out::println);
	}

	private void readStudent(StudentDAO studentDAO){
//		create student object
		Student tempStudent  = new Student("test1","test","test1@test.com");

//		save student object
		studentDAO.save(tempStudent);

//		get student id
		System.out.println("Student id: "+tempStudent.getId());

//		find by student id
		Student getStudent = studentDAO.findById(tempStudent.getId());

//		print the student
		System.out.println(getStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO){
		//		create the student dao
		System.out.println("Creating new student object....");
		Student tempStudent1 = new Student("Himanshu", "Kandpal", "hk@hi.com");
		Student tempStudent2 = new Student("Pratibha", "Kandpal", "hk@hi.com");
		Student tempStudent3 = new Student("Rishabh", "Kandpal", "hk@hi.com");

//		save the student
		System.out.println("Saving the student...");
//		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO){
//		create the student dao
		System.out.println("Creating new student object....");
		Student tempStudent = new Student("Himanshu", "Kandpal", "hk@hi.com");

//		save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

//		display id of saved student
		System.out.println("Student is saved into the databse...- Student id: "+tempStudent.getId());
	}
}
