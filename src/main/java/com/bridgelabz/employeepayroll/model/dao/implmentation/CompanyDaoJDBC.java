package com.bridgelabz.employeepayroll.model.dao.implmentation;

import com.bridgelabz.employeepayroll.db.DatabaseConnection;
import com.bridgelabz.employeepayroll.model.dao.CompanyDao;
import com.bridgelabz.employeepayroll.model.entities.Company;
import com.bridgelabz.employeepayroll.model.entities.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDaoJDBC implements CompanyDao {
    private Connection connection;

    @Override
    public void insert(Company company) {
        connection = DatabaseConnection.getConnection();
        try {
            String sql = "insert into Company(CompanyName) values (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, company.getCompanyName());
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
    public void update(Company company) {
        connection = DatabaseConnection.getConnection();
        try {
            String sql = "UPDATE COMPANY SET CompanyName = ? where CompanyId = ? ;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, company.getCompanyName());
            preparedStatement.setInt(2, company.getCompanyId());
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
            String sql = "delete from Company where CompanyId = ?";
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
    public Company findById(int id) {
        connection = DatabaseConnection.getConnection();
        try {
            String sql = "select * from Company where CompanyId = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return instantiateCompany(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    private Company instantiateCompany(ResultSet resultSet) throws SQLException {
        Company company = new Company();
        company.setCompanyName(resultSet.getString("CompanyName"));
        return company;
    }

    @Override
    public List<Company> findAll() {
        List<Company> companyList = new ArrayList<>();
        connection = DatabaseConnection.getConnection();
        try {
            String sql = "select * from Company";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                companyList.add(instantiateCompany(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return companyList;
    }
}
