package com.example.hibernaterelatioships.services;

import com.example.hibernaterelatioships.models.Department;
import com.example.hibernaterelatioships.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments(){
        List<Department> departmentList=departmentRepository.findAll();
        return departmentList;
    }

    public Department addDepartment(Department department){
        return departmentRepository.save(department);
    }
}

