package com.bridgelabz.employeepayroll.model.dao.implmentation;

import com.bridgelabz.employeepayroll.db.DatabaseConnection;
import com.bridgelabz.employeepayroll.model.dao.DepartmentDao;
import com.bridgelabz.employeepayroll.model.entities.Department;
import com.bridgelabz.employeepayroll.model.entities.EmployeePayroll;
import com.bridgelabz.employeepayroll.model.entities.Payroll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {
    private Connection connection;
    @Override
    public void insert(Department department) {
        connection = DatabaseConnection.getConnection();
        try {
            String sql = "insert into Department(DepartmentName) values (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, department.getDepartmentName());
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
    public void update(Department department) {
        connection = DatabaseConnection.getConnection();
        try {
            String sql = "UPDATE Department SET DepartmentName = ? where DepartmentId = ? ;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, department.getDepartmentName());
            preparedStatement.setInt(2, department.getDepartmentId());
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
            String sql = "DELETE from Department where DepartmentId = ?";
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
    public Department findById(int id) {
        connection= DatabaseConnection.getConnection();
        try{
            String sql = "select * from Department where DepartmentId = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1 , id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return instantiateDepartment(resultSet);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Department> findAll() {
        List<Department> departmentList = new ArrayList<>();
        connection= DatabaseConnection.getConnection();
        try{
            String sql = "select * from Department";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                departmentList.add(instantiateDepartment(resultSet));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return departmentList;
    }

    private Department instantiateDepartment(ResultSet resultSet) throws SQLException {
        Department department = new Department();
        department.setDepartmentName(resultSet.getString("DepartmentName"));
        return department;
    }
}
