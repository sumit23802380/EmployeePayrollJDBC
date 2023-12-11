package com.bridgelabz.employeepayroll.app;

import com.bridgelabz.employeepayroll.db.DatabaseConnection;

import java.sql.Connection;

/**
 * @desc : Employee Payroll Main Class
 */
public class Main {
    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        DatabaseConnection.closeConnection();
    }
}
