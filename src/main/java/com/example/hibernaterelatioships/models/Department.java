package com.example.hibernaterelatioships.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Departments")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long deptId;

    String deptName;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "Dept_Id")
    List<Employee> employees;
}
