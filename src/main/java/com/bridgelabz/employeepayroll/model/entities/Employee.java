package com.bridgelabz.employeepayroll.model.entities;

import java.time.LocalDate;

public class Employee {
    private int employeeId;
    private String employeeName;
    private int departmentId;
    private int companyId;
    private String gender;
    private LocalDate startDate;

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getGender() {
        return gender;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", departmentId=" + departmentId +
                ", companyId=" + companyId +
                ", gender='" + gender + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}