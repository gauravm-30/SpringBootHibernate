package com.example.hibernaterelatioships.repositories;

import com.example.hibernaterelatioships.models.Department;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    //JPA Specific to resolve n+1 problem
    @Query("SELECT dept FROM Department dept LEFT JOIN FETCH dept.employees")
    List<Department> findAllUsingQuery();

    @EntityGraph(attributePaths = {"employees"})
    List<Department> findAll();


    //It is not working because it is not a query method thats why it is giving error
    @EntityGraph(attributePaths = {"employees"})
    List<Department> findAllUsingEntityGraph();
}
