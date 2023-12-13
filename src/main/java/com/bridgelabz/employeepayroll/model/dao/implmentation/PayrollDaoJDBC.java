package com.bridgelabz.employeepayroll.model.dao.implmentation;
import com.bridgelabz.employeepayroll.db.DatabaseConnection;
import com.bridgelabz.employeepayroll.model.dao.PayrollDao;
import com.bridgelabz.employeepayroll.model.entities.EmployeePayroll;
import com.bridgelabz.employeepayroll.model.entities.Payroll;

import java.lang.module.Configuration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PayrollDaoJDBC implements PayrollDao {
    private Connection connection;
    private static PayrollDaoJDBC instance;
    private PayrollDaoJDBC(){}
    public static PayrollDaoJDBC getInstance(){
        if(instance == null){
            instance = new PayrollDaoJDBC();
        }
        return instance;
    }
    @Override
    public void insert(Payroll payroll) {
        connection = DatabaseConnection.getConnection();
        try {
            String sql = "insert into Payroll(EmployeeId, BasicPay,Deductions ,TaxablePay,IncomeTax,NetPay) values (? , ? , ? , ? , ? , ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            System.out.println(payroll.getEmployeeId());
            preparedStatement.setInt(1, payroll.getEmployeeId());
            preparedStatement.setInt(2, payroll.getBasicPay());
            preparedStatement.setInt(3, payroll.getDeductions());
            preparedStatement.setInt(4, payroll.getTaxable());
            preparedStatement.setInt(5 , payroll.getIncomeTax());
            preparedStatement.setInt(6 , payroll.getNetPay());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Rows are affected");
            } else {
                System.out.println("No row affected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    /**
     * @desc :Method to update the employee payroll by using the JDBC prepared statement
     * @param : payroll - payroll object that is updated
     */
    @Override
    public void update(Payroll payroll) {
        connection = DatabaseConnection.getConnection();
        try {
            String sql = "UPDATE Payroll SET EmployeeId = ? , BasicPay = ? , Deductions = ? , TaxablePay = ? , IncomeTax = ? , NetPay = ?  where PayrollId = ? ;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, payroll.getEmployeeId());
            preparedStatement.setInt(2, payroll.getBasicPay());
            preparedStatement.setInt(3, payroll.getDeductions());
            preparedStatement.setInt(4, payroll.getTaxable());
            preparedStatement.setInt(5, payroll.getIncomeTax());
            preparedStatement.setInt(6, payroll.getNetPay());
            preparedStatement.setInt(7, payroll.getPayrollId());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Rows are affected");
            } else {
                System.out.println("No row affected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteBy(int id) {
        connection = DatabaseConnection.getConnection();
        try {
            String sql = "DELETE from Payroll where PayrollId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Rows are affected");
            } else {
                System.out.println("No row affected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Payroll findById(int id) {
        connection= DatabaseConnection.getConnection();
        try{
            String sql = "select * from Payroll where PayrollId = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1 , id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Payroll payroll = instantitatePayroll(resultSet);
                return payroll;
            }
            return null;
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Payroll findByEmployeeId(int id) {
        connection= DatabaseConnection.getConnection();
        try{
            String sql = "select * from Payroll where EmployeeId = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1 , id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                System.out.println("Hello");
                return instantitatePayroll(resultSet);
            }
            return null;
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }
    public List<Payroll> findAll() {
        connection= DatabaseConnection.getConnection();
        List<Payroll> payrollList = new ArrayList<>();
        try{
            String sql = "select * from Payroll;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Payroll payroll = instantitatePayroll(resultSet);
                payrollList.add(payroll);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return payrollList;
    }

    private Payroll instantitatePayroll(ResultSet resultSet) throws SQLException {
        Payroll payroll = new Payroll();
        payroll.setPayrollId(resultSet.getInt("PayrollId"));
        payroll.setEmployeeId(resultSet.getInt("EmployeeId"));
        payroll.setBasicPay(resultSet.getInt("BasicPay"));
        payroll.setDeductions(resultSet.getInt("Deductions"));
        payroll.setTaxable(resultSet.getInt("TaxablePay"));
        payroll.setIncomeTax(resultSet.getInt("IncomeTax"));
        payroll.setNetPay(resultSet.getInt("NetPay"));
        return payroll;
    }
}
