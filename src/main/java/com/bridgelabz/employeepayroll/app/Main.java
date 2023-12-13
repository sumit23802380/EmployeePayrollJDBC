package com.bridgelabz.employeepayroll.app;
import com.bridgelabz.employeepayroll.db.DatabaseConnection;
import com.bridgelabz.employeepayroll.model.dao.EmployeeDao;
import com.bridgelabz.employeepayroll.model.dao.implmentation.CompanyDaoJDBC;
import com.bridgelabz.employeepayroll.model.dao.implmentation.DepartmentDaoJDBC;
import com.bridgelabz.employeepayroll.model.dao.implmentation.EmployeeDaoJDBC;
import com.bridgelabz.employeepayroll.model.dao.implmentation.PayrollDaoJDBC;
import com.bridgelabz.employeepayroll.model.entities.*;

import java.sql.Connection;
import static com.bridgelabz.employeepayroll.db.DatabaseConnection.*;

/**
 * @desc : Employee Payroll Main Class
 */
public class Main {
    public static void main(String[] args) {
        EmployeeDaoJDBC employeeDaoJDBC = EmployeeDaoJDBC.getInstance();

        Employee employee = employeeDaoJDBC.findById(7);
        System.out.println(employee);

        PayrollDaoJDBC payrollDaoJDBC = PayrollDaoJDBC.getInstance();
        Payroll payroll = payrollDaoJDBC.findByEmployeeId(employee.getEmployeeId());
        System.out.println(payroll);

        payroll.setBasicPay(300000);
        payrollDaoJDBC.update(payroll);

        System.out.println(payrollDaoJDBC.findAll());
    }
}
