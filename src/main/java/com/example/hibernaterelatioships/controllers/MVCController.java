package com.example.hibernaterelatioships.controllers;

import com.example.hibernaterelatioships.models.Department;
import com.example.hibernaterelatioships.models.Employee;
import com.example.hibernaterelatioships.repositories.DepartmentRepository;
import com.example.hibernaterelatioships.services.DepartmentService;
import com.example.hibernaterelatioships.services.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mvc")
public class MVCController {

    @GetMapping("/greet")
    @ResponseBody
    public ResponseEntity<String> greet(Model model) {
    System.out.println("Hello MVC");
    model.addAttribute("message", "Welcome to Spring Boot!");
    return new ResponseEntity<>("greeting.html",HttpStatus.OK); // This corresponds to a view named "greeting.html"
    }
}
