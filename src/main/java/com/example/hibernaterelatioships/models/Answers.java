package com.example.hibernaterelatioships.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "answers")  // This property is used just for Table modification only lowercase is used in postgresql
@Data
public class Answers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long ansId;

    String ansName;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name= "dept_id") //// It is used to give the name of the relationship column

    @ManyToMany(fetch = FetchType.LAZY)
    List<Questions> questions;



    /*ManyToOne don't have mappedBy variable. Why ?
    Because mappedBy tells Hibernate that relationship is managed by the field defined into the mappedBy .
    In this case one-side of ManyToOne will handle the relationship which is not possible because  other side will look like
    this . It can't handle the relatioship , it will need to create the new table we want to handle the relatioship
    @OneToMany(fetch = FetchType.LAZY)
    List<Answers> answers;
    * */
}


