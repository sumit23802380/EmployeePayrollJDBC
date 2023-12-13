package com.bridgelabz.employeepayroll.model.entities;

/**
 * @desc : Payroll Class that contains all related information related to salary
 */
public class Payroll {
    private int payrollId;
    private int employeeId;
    private int basicPay;
    private int deductions;
    private int taxable;
    private int incomeTax;
    private int netPay;

    /**
     * @desc : Method to get the payroll id
     * @return : int payrollId
     */
    public int getPayrollId() {
        return payrollId;
    }

    /**
     * @desc : Method to set the payroll id
     * @param : payrollId - unique id of the payroll
     */
    public void setPayrollId(int payrollId) {
        this.payrollId = payrollId;
    }

    /**
     * @desc : Method to get the Employee Id related to payroll
     * @return : employee Id (int) unique id for employee
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * @desc : Method to set the employee id
     * @param : employeeId - unique id for employee
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @desc : Method to get the basic pay salary from payroll
     * @return : basicPay (int) - basic pay of the employee related payroll
     */
    public int getBasicPay() {
        return basicPay;
    }

    /**
     * @desc : Method to set the basic pay for payroll
     * @param : basicPay (int) - basic pay of the employee related payroll
     */
    public void setBasicPay(int basicPay) {
        this.basicPay = basicPay;
    }

    /**
     * @desc : Method to get the deductions from the payroll
     * @return : deductions
     */
    public int getDeductions() {
        return deductions;
    }

    /**
     * @desc : Method to set the deductions of the payroll
     * @param : deductions
     */
    public void setDeductions(int deductions) {
        this.deductions = deductions;
    }

    /**
     * @desc : Method to get the taxable pay from the payroll
     * @return : taxable
     */
    public int getTaxable() {
        return taxable;
    }

    /**
     * @desc : Method to set the taxable
     * @param : taxable
     */
    public void setTaxable(int taxable) {
        this.taxable = taxable;
    }

    /**
     * @desc : Method to get the income tax from the payroll
     * @return : incomeTax
     */
    public int getIncomeTax() {
        return incomeTax;
    }

    /**
     * @desc : Method to set the income tax of payroll
     * @param : incomeTax
     */
    public void setIncomeTax(int incomeTax) {
        this.incomeTax = incomeTax;
    }

    /**
     * @desc : Method to get the net pay
     * @return : netpay
     */
    public int getNetPay() {
        return netPay;
    }

    /**
     * @desc : Method to set the net pay of the payroll
     * @param : netPay
     */
    public void setNetPay(int netPay) {
        this.netPay = netPay;
    }

    /**
     * @desc : Overriden method to print the payroll object
     * @return : Formatted payroll object string
     */
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
