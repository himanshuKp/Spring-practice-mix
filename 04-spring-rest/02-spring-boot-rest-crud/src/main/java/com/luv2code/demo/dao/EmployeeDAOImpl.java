package com.luv2code.demo.dao;

import com.luv2code.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl  implements EmployeeDAO{
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findEmployees() {
//        create query
        TypedQuery<Employee> findEmployees = entityManager.createQuery("from Employee", Employee.class);

        return findEmployees.getResultList();
    }

    @Override
    public Employee findEmployee(int id) {

        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee addEmployee(Employee employee) {

        return entityManager.merge(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        Employee findEmployee = entityManager.find(Employee.class, id);

        entityManager.remove(findEmployee);
    }
}
