package com.example.hibernaterelatioships.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "Employees")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long empId;

    String empName;

}
