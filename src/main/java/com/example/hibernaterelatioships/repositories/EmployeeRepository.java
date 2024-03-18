package com.example.hibernaterelatioships.repositories;

import com.example.hibernaterelatioships.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {}
