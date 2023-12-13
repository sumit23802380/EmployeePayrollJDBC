package com.bridgelabz.employeepayroll.app;

import com.bridgelabz.employeepayroll.db.DatabaseConnection;
import com.bridgelabz.employeepayroll.model.dao.EmployeeDao;
import com.bridgelabz.employeepayroll.model.dao.PayrollDao;
import com.bridgelabz.employeepayroll.model.dao.implmentation.CompanyDaoJDBC;
import com.bridgelabz.employeepayroll.model.dao.implmentation.DepartmentDaoJDBC;
import com.bridgelabz.employeepayroll.model.dao.implmentation.EmployeeDaoJDBC;
import com.bridgelabz.employeepayroll.model.dao.implmentation.PayrollDaoJDBC;
import com.bridgelabz.employeepayroll.model.entities.*;

import java.sql.Connection;
import java.time.LocalDate;

import static com.bridgelabz.employeepayroll.db.DatabaseConnection.*;

/**
 * @desc : Employee Payroll Main Class
 */
public class Main {
    public static void main(String[] args) {
        EmployeeDaoJDBC employeeDaoJDBC = EmployeeDaoJDBC.getInstance();
        System.out.println(employeeDaoJDBC.analyzeEmployeeSalaries());
        PayrollDaoJDBC payrollDaoJDBC = PayrollDaoJDBC.getInstance();
        System.out.println(payrollDaoJDBC.findAll());
    }
}