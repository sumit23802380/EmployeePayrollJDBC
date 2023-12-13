package com.bridgelabz.employeepayroll.model.entities;

import java.time.LocalDate;

/**
 * @desc : Employee class , contains all information related to employee
 */
public class Employee {
    private int employeeId;
    private String employeeName;
    private int departmentId;
    private int companyId;
    private String gender;
    private LocalDate startDate;

    /**
     * @desc : Method to return the start date of employment of employee
     * @return : startDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Method to set the start date of employment of employee
     * @param : startDate
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * @desc : Method to get the employee id unique
     * @return : employeeId
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * @desc : Method to get the company id
     * @return : companyId
     */
    public int getCompanyId() {
        return companyId;
    }

    /**
     * @desc : Method to get the department id
     * @return : departmentId
     */
    public int getDepartmentId() {
        return departmentId;
    }

    /**
     * @desc : Method to get the name of employee
     * @return : employeeName
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * @desc : Method to get the gender of employee
     * @return : gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @desc : Method to set the employee id
     * @param : employeeId
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @desc : Method to set the company id of the employee
     * @param : companyId
     */
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    /**
     * @desc : Method to set the department id of the employee
     * @param : departmentId
     */
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * @desc : Method to set the employee name
     * @param : employeeName
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * @desc : Method to set the gender of the employee
     * @param : gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @desc : Method to return formatted Employee object string
     * @return : formatted employee object string
     */
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