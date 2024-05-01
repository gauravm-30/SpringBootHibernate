package com.example.hibernaterelatioships.controllers;

import com.example.hibernaterelatioships.models.Department;
import com.example.hibernaterelatioships.models.Employee;
import com.example.hibernaterelatioships.repositories.DepartmentRepository;
import com.example.hibernaterelatioships.services.DepartmentService;
import com.example.hibernaterelatioships.services.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/controller")
public class SQLController {

@Autowired
DepartmentService departmentService;

@Autowired
    EmployeeService employeeService;

@Autowired
DepartmentRepository departmentRepository;

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getAllDepartments(){
//        List<Department> departmentList=departmentService.getAllDepartments();

        return new ResponseEntity<>(departmentRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees=employeeService.getAllEmployees();

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/department")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department){
 return new ResponseEntity<>(departmentService.addDepartment(department),HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.addEmployee(employee),HttpStatus.OK);
    }

    @GetMapping("/stringVal")
    public Employee getString(){
        Employee e1 = new Employee();
        e1.setEmpId(1L);
        e1.setEmpName("Gaurav");
        e1.setDepartment(null);
        return e1;
    }

    @GetMapping("/greet")
    public String greet(Model model) {
        model.addAttribute("message", "Welcome to Spring Boot!");
        return "greeting.html"; // This corresponds to a view named "greeting.html"
    }
}
