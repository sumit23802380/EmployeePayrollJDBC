package com.bridgelabz.employeepayroll.model.entities;

import java.time.LocalDate;

public class EmployeePayroll {
    private int payrollId;
    private String employeeName;
    private int employeeNetPay;
    private int employeeId;
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

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(int payrollId) {
        this.payrollId = payrollId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeNetPay() {
        return employeeNetPay;
    }

    public void setEmployeeNetPay(int employeeNetPay) {
        this.employeeNetPay = employeeNetPay;
    }

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
