package com.bridgelabz.employeepayroll;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionTest {
    private static Connection connection;
    @BeforeClass
    public static void setUp() {
        connection = DatabaseConnection.getConnection();
        assertNotNull(connection,"Connection should not be null");
    }

    @Test
    public void testDatabaseConnection(){
        assertNotNull(connection,"Connection should not be null");
    }

    @AfterClass
    public static void tearDown() {
        DatabaseConnection.closeConnection();
        try{
            assertTrue(connection.isClosed() , "Connection should be closed");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}

/**
 * Add test for config.properties file
 */