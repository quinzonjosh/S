package com.sxi.employeemanagementsystem.exception;

public class EmployeeNotFoundException extends RuntimeException{
    
    public EmployeeNotFoundException(String employeeID){
        super("Could not find employee with employee id: "+employeeID);
    }
    
}
