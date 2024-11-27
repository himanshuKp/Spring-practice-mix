package com.luv2code.demo.rest;

import com.luv2code.demo.dao.EmployeeDAO;
import com.luv2code.demo.entity.Employee;
import com.luv2code.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    @GetMapping("employees")
    private List<Employee> findAllEmployees(){
        return employeeService.findEmployees();
    }
}
