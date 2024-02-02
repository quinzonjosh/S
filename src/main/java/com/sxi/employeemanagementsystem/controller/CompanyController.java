package com.sxi.employeemanagementsystem.controller;


import com.sxi.employeemanagementsystem.model.Company;
import com.sxi.employeemanagementsystem.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping("/company")
    Company newCompany(@RequestBody Company newCompany) {return companyRepository.save(newCompany);}

    @GetMapping("/companies")
    List<Company> getAllCompanies(){return companyRepository.findAll();}

    @GetMapping("/companies/{companyID}")
    Company getCompany(@PathVariable String companyID){
        return companyRepository.findById(companyID).orElseThrow(null);
    }

    @PutMapping("/companies/edit/{companyID}")
    Company updateCompany(@RequestBody Company updatedCompany, @PathVariable String companyID){

        return companyRepository.findById(companyID)
                .map(company -> {
                    company.setCompanyID(updatedCompany.getCompanyID());
                    company.setCompanyName(updatedCompany.getCompanyName());
                    return companyRepository.save(company);
                }).orElseThrow(null);
    }
}
