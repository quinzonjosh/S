package com.sxi.employeemanagementsystem.controller;

import com.sxi.employeemanagementsystem.exception.EmployeeNotFoundException;
import com.sxi.employeemanagementsystem.model.Employee;
import com.sxi.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employee")
    Employee newEmployee(@RequestBody Employee newEmployee){
        return employeeRepository.save(newEmployee);
    }

    @GetMapping("/allEmployees")
    List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/currentEmployees")
    List<Employee> getCurrentEmployees(){
        return employeeRepository.findByDelFalse();
    }

    @GetMapping("/employees/{employeeID}")
    Employee getEmployee(@PathVariable String employeeID){
        return employeeRepository.findById(employeeID)
                .orElseThrow(()->new EmployeeNotFoundException(employeeID));
    }

    @GetMapping("/employees/latestID")
    String generateNextEmployeeID(){
        String latestID = employeeRepository.getLatestId();
        if(latestID == null) return "EMP001";
        else {
            int num = Integer.parseInt(latestID.substring(3)) + 1;
            return "EMP" + String.format("%03d", num);
        }
    }

    @PutMapping("/employees/edit/{employeeID}")
    Employee updateEmployee(@RequestBody Employee updatedEmployee, @PathVariable String employeeID){
        return employeeRepository.findById(employeeID)
                .map(employee->{
                    employee.setEmployeeID(updatedEmployee.getEmployeeID());
                    employee.setCompanyID(updatedEmployee.getCompanyID());
                    employee.setFirstName(updatedEmployee.getFirstName());
                    employee.setMiddleName(updatedEmployee.getMiddleName());
                    employee.setLastName(updatedEmployee.getLastName());
                    employee.setTin(updatedEmployee.getTin());
                    employee.setSssGsis(updatedEmployee.getSssGsis());
                    employee.setHireDate(updatedEmployee.getHireDate());
                    employee.setSalary(updatedEmployee.getSalary());
                    return employeeRepository.save(employee);
                }).orElseThrow(()-> new EmployeeNotFoundException(employeeID));
    }

    @DeleteMapping("/employees/softDelete/{employeeID}")
    String softDelete(@PathVariable String employeeID){
        Employee employee = employeeRepository.findById(employeeID)
                .orElseThrow( () ->  new EmployeeNotFoundException(employeeID));
        employee.setDel(true);
        employeeRepository.save(employee);
        return employeeID + " soft deletion successful.";
    }

    @DeleteMapping("/employees/hardDelete/{employeeID}")
    String hardDeleteEmployee(@PathVariable String employeeID){
        if(!employeeRepository.existsById(employeeID)){
            throw new EmployeeNotFoundException((employeeID));
        }
        employeeRepository.deleteById(employeeID);
        return employeeID + " hard deletion successful.";
    }

}
