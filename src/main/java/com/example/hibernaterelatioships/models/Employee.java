package com.example.hibernaterelatioships.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "employees")  // This property is used just for Table modification only lowercase is used in postgresql
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long empId;

    String empName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "dept_id") //// It is used to give the name of the relationship column
    Department department;

}
