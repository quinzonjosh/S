package com.sxi.employeemanagementsystem.repository;

import com.sxi.employeemanagementsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query("SELECT MAX(employeeID) FROM Employee")
    String getLatestId();

    List<Employee> findByDelFalse();

}
