package com.example.hibernaterelatioships.services;

import com.example.hibernaterelatioships.models.Department;
import com.example.hibernaterelatioships.models.Employee;
import com.example.hibernaterelatioships.repositories.DepartmentRepository;
import java.util.List;

import com.example.hibernaterelatioships.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        List<Employee> employeeList=employeeRepository.findAll();
        return employeeList;
    }

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
}
