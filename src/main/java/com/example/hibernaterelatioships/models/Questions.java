package com.example.hibernaterelatioships.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "questions")
@Data
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long qId;

    String qName;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "questions")
    List<Answers> answers;

    
    /* @JoinColumn(name = "dept_Id")  */   // No matter whether you name in lowercase or in uppercase , it will always use lowercase only.
//    List<Employee> employees;
}
