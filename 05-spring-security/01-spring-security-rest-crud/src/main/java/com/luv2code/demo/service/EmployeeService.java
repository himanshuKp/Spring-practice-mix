package com.luv2code.demo.service;

import com.luv2code.demo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findEmployees();

    Optional<Employee> findEmployee(int employeeId);

    Employee addEmployee(Employee employee);

    void deleteEmployee(int employeeId);
}
