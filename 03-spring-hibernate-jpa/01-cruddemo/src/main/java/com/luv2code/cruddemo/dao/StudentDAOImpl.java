package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    //define fields
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int studentId) {
        return entityManager.find(Student.class, studentId);
    }

    @Override
    public List<Student> findAll() {
//        create typedquery to get all
        TypedQuery<Student> findAllQuery = entityManager.createQuery("From Student", Student.class);

//        return the result
        return findAllQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
//        create typedQuery to get the result
        TypedQuery<Student> findByLastNameQuery = entityManager.createQuery("From Student where lastName=:lastName", Student.class);

//        set the parameter
        findByLastNameQuery.setParameter("lastName", lastName);

//        return the result
        return findByLastNameQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
//    update the student using merge
        entityManager.merge(student);
    }
}
