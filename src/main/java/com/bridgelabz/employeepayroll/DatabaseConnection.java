package com.bridgelabz.employeepayroll;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Enumeration;
import java.util.Properties;

public class DatabaseConnection {
    private static Connection connection;
    private static String url;
    private static String username;
    private static String password;

    private static boolean checkDriverClass() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;
    }

    private static void checkDriversList() {
        Enumeration<Driver> driversList = DriverManager.getDrivers();
        while (driversList.hasMoreElements()) {
            Driver driver = driversList.nextElement();
            System.out.println(driver.getClass().getName());
        }
    }

    public static Connection getConnection() {
        if (!checkDriverClass()) {
            System.out.println("No Driver Class found");
            return connection;
        }
        if (!loadProperties()) {
            System.out.println("Properties of url username and password not able to load");
        }
        checkDriversList();
        if (connection == null) {
            try {
                System.out.println("Connecting to DB...");
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("DB Connection successful!");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
        return connection;
    }

    private static boolean loadProperties() {
        Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        url = properties.getProperty("jdbc.url");
        username = properties.getProperty("jdbc.user");
        password = properties.getProperty("jdbc.password");
        return true;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                System.out.println("Closing DB connection...");
                connection.close();
                System.out.println("DB connection closed!");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }
}
