package com.luv2code.demo.service;

import com.luv2code.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findEmployees();

    Employee findEmployee(int employeeId);

    Employee addEmployee(Employee employee);

    void deleteEmployee(int employeeId);
}
