package com.sxi.employeemanagementsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Company {

    @Id
    private String companyID;
    private String companyName;

    public Company(String companyID, String companyName) {
        this.companyID = companyID;
        this.companyName = companyName;
    }

    public Company() {
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
