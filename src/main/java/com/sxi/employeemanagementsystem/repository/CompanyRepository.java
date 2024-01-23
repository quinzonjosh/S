package com.sxi.employeemanagementsystem.repository;

import com.sxi.employeemanagementsystem.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {
}
