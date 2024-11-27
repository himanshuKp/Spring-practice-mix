package com.luv2code.demo.rest;

import com.luv2code.demo.dao.EmployeeDAO;
import com.luv2code.demo.entity.Employee;
import com.luv2code.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

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

    @GetMapping("employees/{employeeId}")
    private Employee findEmployee(@PathVariable int employeeId) {
        return employeeService.findEmployee(employeeId);
    }

    @PostMapping("employees")
    private Employee addEmployee(@RequestBody Employee employee){

        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("employees/{employeeId}")
    private void deleteEmployee(@PathVariable int employeeId){

        employeeService.deleteEmployee(employeeId);
    }
}
