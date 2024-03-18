package com.example.hibernaterelatioships.controllers;

import com.example.hibernaterelatioships.models.Department;
import com.example.hibernaterelatioships.models.Employee;
import com.example.hibernaterelatioships.repositories.DepartmentRepository;
import com.example.hibernaterelatioships.services.DepartmentService;
import com.example.hibernaterelatioships.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RelationshipController {

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

    {

    }
}
