package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeService.findAll();
        employees = employees.stream().sorted(Comparator.comparing(Employee::getLastName)).toList();
        model.addAttribute("employees", employees);

        return "list-employees";
    }

    @GetMapping("/addEmployee")
    public String addEmployeePage(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "add-employee";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
         employeeService.save(employee);

         return "redirect:/employees/list";
    }
}
