package com.luv2code.demo.dao;

import com.luv2code.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findEmployees();

    Employee findEmployee(int id);

    Employee addEmployee(Employee employee);

    void deleteEmployee(int id);
}
