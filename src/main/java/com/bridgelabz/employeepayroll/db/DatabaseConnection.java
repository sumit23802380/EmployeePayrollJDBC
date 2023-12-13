package com.bridgelabz.employeepayroll.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @desc : Database Connection class
 * method getConnection , closeConnection , checkDriverClass , checkDriversList and loadProperties are implemented
 */
public class DatabaseConnection {
    private static Connection connection;
    private static String url;
    private static String username;
    private static String password;

    /**
     * @return : boolean value true or false whether project contains the driver class
     * @desc : Check if the driver class is loaded or not in project
     */
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

    /**
     * @desc : Method to print the drivers list that is loaded in project
     */
    private static void checkDriversList() {
        Enumeration<Driver> driversList = DriverManager.getDrivers();
        while (driversList.hasMoreElements()) {
            Driver driver = driversList.nextElement();
            System.out.println(driver.getClass().getName());
        }
    }

    /**
     * @return : connection static instance
     * @desc : Method to get the connection of the database only if connection is null
     * First check whether driver class is present and load all the properties
     */
    public static Connection getConnection() {
        if (!checkDriverClass()) {
            System.out.println("No Driver Class found");
            return connection;
        }
        if (!loadProperties()) {
            System.out.println("Properties of url username and password not able to load");
            return connection;
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

    /**
     * @return : Boolean value whether properties are loaded or not
     * @desc : Method to load the properties like url , username and password for connection from config file
     */
    private static boolean loadProperties() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        url = properties.getProperty("jdbc.url");
        username = properties.getProperty("jdbc.username");
        password = properties.getProperty("jdbc.password");
        return true;
    }

    /**
     * @desc : Method to close the connection that is not null
     */
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
