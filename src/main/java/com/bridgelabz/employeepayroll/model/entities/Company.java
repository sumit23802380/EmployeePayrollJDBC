package com.bridgelabz.employeepayroll.model.entities;

public class Company {
    private int companyId;
    private String companyName;

    public int getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Company{" +
                " companyName='" + companyName + '\'' +
                '}';
    }
}
