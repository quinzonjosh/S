package com.sxi.employeemanagementsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Employee {

    @Id
    private String employeeID;
    private String companyID;
    private String firstname;
    private String middleName;
    private String lastName;
    private String tin;
    private String sssGsis;
    private LocalDate hireDate;
    private float salary;

    public Employee() {
    }

    public Employee(String employeeID, String companyID, String firstname, String middleName, String lastName, String tin, String sssGsis, LocalDate hireDate, float salary) {
        this.employeeID = employeeID;
        this.companyID = companyID;
        this.firstname = firstname;
        this.middleName = middleName;
        this.lastName = lastName;
        this.tin = tin;
        this.sssGsis = sssGsis;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getSssGsis() {
        return sssGsis;
    }

    public void setSssGsis(String sssGsis) {
        this.sssGsis = sssGsis;
    }

    public LocalDate getDate() {
        return hireDate;
    }

    public void setDate(LocalDate hireDate) {
        hireDate = hireDate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
