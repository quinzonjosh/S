package com.sxi.employeemanagementsystem.controller;

import com.sxi.employeemanagementsystem.exception.EmployeeNotFoundException;
import com.sxi.employeemanagementsystem.model.Employee;
import com.sxi.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employee")
    Employee newEmployee(@RequestBody Employee newEmployee){
        return employeeRepository.save(newEmployee);
    }

    @GetMapping("/employees")
    List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("employees/{employeeID}")
    Employee getEmployee(@PathVariable String employeeID){
        return employeeRepository.findById(employeeID)
                .orElseThrow(()->new EmployeeNotFoundException(employeeID));
    }

}
