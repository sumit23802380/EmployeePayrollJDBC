package com.bridgelabz.employeepayroll.model.entities;

public class Payroll {
    private int payrollId;
    private int employeeId;
    private int basicPay;
    private int deductions;
    private int taxable;
    private int incomeTax;
    private int netPay;

    public int getPayrollId() {
        return payrollId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getBasicPay() {
        return basicPay;
    }

    public void setBasicPay(int basicPay) {
        this.basicPay = basicPay;
    }

    public int getDeductions() {
        return deductions;
    }

    public void setDeductions(int deductions) {
        this.deductions = deductions;
    }

    public int getTaxable() {
        return taxable;
    }

    public void setTaxable(int taxable) {
        this.taxable = taxable;
    }

    public int getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(int incomeTax) {
        this.incomeTax = incomeTax;
    }

    public int getNetPay() {
        return netPay;
    }

    public void setNetPay(int netPay) {
        this.netPay = netPay;
    }

    @Override
    public String toString() {
        return "Payroll{" +
                "employeeId=" + employeeId +
                ", basicPay=" + basicPay +
                ", deductions=" + deductions +
                ", taxable=" + taxable +
                ", incomeTax=" + incomeTax +
                ", netPay=" + netPay +
                '}';
    }
}
