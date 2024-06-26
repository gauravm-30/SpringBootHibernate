package com.example.hibernaterelatioships.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "departments")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long deptId;

    String deptName;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "department")
    List<Employee> employees;

    /* @JoinColumn(name = "dept_Id")  */   // No matter whether you name in lowercase or in uppercase , it will always use lowercase only.
//    List<Employee> employees;
}
