package com.bridgelabz.employeepayroll.model.dao.implmentation;

import com.bridgelabz.employeepayroll.db.DatabaseConnection;
import com.bridgelabz.employeepayroll.model.dao.EmployeeDao;
import com.bridgelabz.employeepayroll.model.entities.Employee;
import com.bridgelabz.employeepayroll.model.entities.EmployeePayroll;
import com.bridgelabz.employeepayroll.model.entities.Payroll;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Date.*;

public class EmployeeDaoJDBC implements EmployeeDao {
    private Connection connection;
    private static EmployeeDaoJDBC instance;
    private EmployeeDaoJDBC(){}
    public static EmployeeDaoJDBC getInstance(){
        if(instance == null){
            instance = new EmployeeDaoJDBC();
        }
        return instance;
    }
    @Override
    public void insert(Employee employee) {
        connection= DatabaseConnection.getConnection();
        try{
            String sql = "insert into Employee(EmployeeName , DepartmentId , CompanyId, Gender) values  (? , ? , ? , ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1 , employee.getEmployeeName());
            preparedStatement.setInt(2 , employee.getDepartmentId());
            preparedStatement.setInt(3 , employee.getCompanyId());
            preparedStatement.setString(4 , employee.getGender());
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected>0){
                System.out.println("Rows are affected");
            }
            else{
                System.out.println("No row affected");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void update(Employee employee) {
        connection = DatabaseConnection.getConnection();
        try {
            String sql = "UPDATE Department SET EmployeeName = ? , DepartmentId = ? , CompanyId = ? , Gender = ? , StartDate = ? , where EmployeeId = ? ;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setInt(2, employee.getDepartmentId());
            preparedStatement.setInt(3, employee.getCompanyId());
            preparedStatement.setString(4, employee.getGender());
            preparedStatement.setDate(5, java.sql.Date.valueOf(employee.getStartDate()));
            preparedStatement.setInt(6, employee.getEmployeeId());
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
            String sql = "DELETE from Employee where EmployeeId = ?";
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
    public Employee findById(int id) {
        connection= DatabaseConnection.getConnection();
        try{
            String sql = "select * from Employee where EmployeeId = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1 , id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return instantiateEmployee(resultSet);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Employee> findAll() {
        connection= DatabaseConnection.getConnection();
        List<Employee> employeeList = new ArrayList<>();
        try{
            String sql = "select * from Employee;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Employee employee = instantiateEmployee(resultSet);
                employeeList.add(employee);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return employeeList;
    }

    public List<Employee> getEmployeesJoinedInDateRange(LocalDate start , LocalDate end) {
        connection= DatabaseConnection.getConnection();
        List<Employee> employeeList = new ArrayList<>();
        try{
            String sql = "SELECT * FROM Employee WHERE StartDate BETWEEN ? AND ? ;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, java.sql.Date.valueOf(start));
            preparedStatement.setDate(2, java.sql.Date.valueOf(end));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Employee employee = instantiateEmployee(resultSet);
                employeeList.add(employee);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return employeeList;
    }

    private Employee instantiateEmployee(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployeeId(resultSet.getInt("EmployeeId"));
        employee.setEmployeeName(resultSet.getString("EmployeeName"));
        employee.setGender(resultSet.getString("Gender"));
        employee.setCompanyId(resultSet.getInt("CompanyId"));
        employee.setDepartmentId(resultSet.getInt("DepartmentId"));
        employee.setStartDate(resultSet.getDate("StartDate").toLocalDate());
        return employee;
    }


    public EmployeePayroll getEmployeePayroll(int id){
        connection= DatabaseConnection.getConnection();
        try{
            String sql = "select e.EmployeeId as employeeId , e.EmployeeName as employeeName , p.PayrollId as payrollId , p.NetPay as employeeNetPay from Employee as e join Payroll as p on e.EmployeeId = p.EmployeeId where e.EmployeeId = ? ;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1 , id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                EmployeePayroll employeePayroll = instantiateEmployeePayroll(resultSet);
                return employeePayroll;
            }
            return null;
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<EmployeePayroll> getEmployeePayrollList(){
        List<EmployeePayroll> employeePayrollList = new ArrayList<>();
        connection= DatabaseConnection.getConnection();
        try{
            String sql = "select e.EmployeeId as employeeId , e.EmployeeName as employeeName , e.StartDate as startDate , p.PayrollId as payrollId , p.NetPay as employeeNetPay from Employee as e join Payroll as p on e.EmployeeId = p.EmployeeId;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                EmployeePayroll employeePayroll = instantiateEmployeePayroll(resultSet);
                employeePayrollList.add(employeePayroll);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return employeePayrollList;
    }

    public Map<String , Double> analyzeEmployeeSalaries(){
        Map<String, Double> analysis = new HashMap<>();
        connection= DatabaseConnection.getConnection();
        try{
            String sql = "select SUM(p.NetPay) as SalarySum , MIN(p.NetPay) as MinimumNetPay , MAX(p.NetPay) as MaximumNetPay , COUNT(*) as TotalCount  , e.Gender as Gender from Employee as e join Payroll as p on e.EmployeeId = p.EmployeeId  GROUP BY Gender";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Double salarySum = resultSet.getDouble("SalarySum");
                Double minimumNetPay = resultSet.getDouble("MinimumNetPay");
                Double maximumNetPay = resultSet.getDouble("MaximumNetPay");
                Double totalCount = resultSet.getDouble("TotalCount");
                String gender = resultSet.getString("Gender");
                analysis.put("SalarySum : " + gender , salarySum);
                analysis.put("MinimumNetPay : " + gender, minimumNetPay);
                analysis.put("MaximumNetPay : " + gender, maximumNetPay);
                analysis.put("TotalCount : " + gender, totalCount);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return analysis;
    }

    private EmployeePayroll instantiateEmployeePayroll(ResultSet resultSet) throws SQLException {
        EmployeePayroll employeePayroll = new EmployeePayroll();
        employeePayroll.setEmployeeId(resultSet.getInt("employeeId"));
        employeePayroll.setEmployeeName(resultSet.getString("employeeName"));
        employeePayroll.setPayrollId(resultSet.getInt("payrollId"));
        employeePayroll.setEmployeeNetPay(resultSet.getInt("employeeNetPay"));
        employeePayroll.setStartDate(resultSet.getDate("startDate").toLocalDate());
        return employeePayroll;
    }
}
