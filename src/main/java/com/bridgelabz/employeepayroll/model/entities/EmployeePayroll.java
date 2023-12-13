package com.bridgelabz.employeepayroll.model.entities;

import java.time.LocalDate;

/**
 * @desc : Employee Payroll class , contains all the related information related to employee and payroll
 */
public class EmployeePayroll {
    private int payrollId;
    private String employeeName;
    private int employeeNetPay;
    private int employeeId;
    private LocalDate startDate;

    /**
     * @desc : Method to get the start date of the employee
     * @return : startDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * @desc : Method to set the start date of the employee
     * @param : startDate
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * @desc : Method to get the employee id
     * @return : employeeId
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * @desc : Method to set the employee id
     * @param : employeeId
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @desc : Method to get the payroll id
     * @return : payrollId
     */
    public int getPayrollId() {
        return payrollId;
    }

    /**
     * @desc : Method to set the payroll id
     * @param : payrollId
     */
    public void setPayrollId(int payrollId) {
        this.payrollId = payrollId;
    }

    /**
     * @desc : Method to get the employee name
     * @return : employeeName
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * @desc : Method to set the employee name
     * @param : employeeName
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * @desc : Method to get the employee net pay
     * @return : employeeNetPay
     */
    public int getEmployeeNetPay() {
        return employeeNetPay;
    }

    /**
     * @desc : Method to set the employee net pay
     * @param : employeeNetPay
     */
    public void setEmployeeNetPay(int employeeNetPay) {
        this.employeeNetPay = employeeNetPay;
    }

    /**
     * @desc : Method to return the formatted employee Payroll object string
     * @return : Formatted employee payroll object string
     */
    @Override
    public String toString() {
        return "EmployeePayroll{" +
                "payrollId=" + payrollId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeNetPay=" + employeeNetPay +
                ", employeeId=" + employeeId +
                ", startDate=" + startDate +
                '}';
    }
}