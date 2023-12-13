package com.bridgelabz.employeepayroll.model.dao.implmentation;

import com.bridgelabz.employeepayroll.db.DatabaseConnection;
import com.bridgelabz.employeepayroll.model.dao.CompanyDao;
import com.bridgelabz.employeepayroll.model.entities.Company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @desc : CompanyDaoJDBC Class implements CompanyDao
 */
public class CompanyDaoJDBC implements CompanyDao {
    private Connection connection;
    private static CompanyDaoJDBC instance;

    /**
     * @desc : Constructor create the single instance of CompanyDaoJDBC
     */
    private CompanyDaoJDBC() {
    }

    /**
     * @desc : Method to get the instance of CompanyDaoJDBC single instance
     * @return : instance of CompanyDaoJDBC
     */
    public static CompanyDaoJDBC getInstance() {
        if (instance == null) {
            instance = new CompanyDaoJDBC();
        }
        return instance;
    }

    /**
     * @desc : Method to insert the new Company
     * @param : company
     */
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

    /**
     * @desc : Method to update  the Company
     * @param : company
     */
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

    /**
     * @desc : Method to delete the Company by using id
     * @param : id
     */
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

    /**
     * @desc : Method to find the Company by id
     * @param : id
     * @return : Company
     */
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

    /**
     * @desc : Method to list all the companies
     * @return : list of companies
     */
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

    /**
     * @desc : Method to instantiateCompany Object from ResultSet
     * @param : resultSet
     * @return : Company object
     * @throws : SQLException
     */
    private Company instantiateCompany(ResultSet resultSet) throws SQLException {
        Company company = new Company();
        company.setCompanyId(resultSet.getInt("CompanyId"));
        company.setCompanyName(resultSet.getString("CompanyName"));
        return company;
    }
}