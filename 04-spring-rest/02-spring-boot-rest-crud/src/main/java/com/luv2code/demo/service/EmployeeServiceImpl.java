package com.luv2code.demo.service;

import com.luv2code.demo.dao.EmployeeDAO;
import com.luv2code.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findEmployees() {
        return employeeDAO.findEmployees();
    }

    @Override
    public Employee findEmployee(int employeeId) {
        return employeeDAO.findEmployee(employeeId);
    }

    @Override
    @Transactional
    public Employee addEmployee(Employee employee) {
        return employeeDAO.addEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int employeeId) {
        employeeDAO.deleteEmployee(employeeId);
    }

}
