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
    //JPQL and HQL queries is written using @Query annotation
    @Query("SELECT dept FROM Department dept LEFT JOIN FETCH dept.employees")
    List<Department> findAllUsingQuery();

    //if you want to write the native sql query then we need to use native query param of @Query
    //by default native query is false.
//    @Query(value = "SELECT * FROM USERS u WHERE u.status = 1", nativeQuery = true)
//    Collection<User> findAllActiveUsersNative();

//    @NamedNativeQuery:
//    @NamedNativeQuery is specifically for writing native SQL queries.
//    These queries are validated during compile time, reducing the chances of runtime exceptions.
//    Use @NamedNativeQuery when you need to define complex native SQL queries.
//    Example:
//    Java
//
//    @NamedNativeQuery(name = "User.findActiveUsers", query = "SELECT * FROM USERS WHERE status = 1")

    @EntityGraph(attributePaths = {"employees"})
    List<Department> findAll();


    //It is not working because 'findAllUsingEntityGraph' is not a query method that's why it is giving error
//    @EntityGraph(attributePaths = {"employees"})
//    List<Department> findAllUsingEntityGraph();
}
