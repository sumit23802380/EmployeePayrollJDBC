package com.bridgelabz.employeepayroll;

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
