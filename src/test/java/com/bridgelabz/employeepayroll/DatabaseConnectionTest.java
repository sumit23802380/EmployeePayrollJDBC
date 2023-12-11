package com.bridgelabz.employeepayroll;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.sql.Connection;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @desc : DatabaseConnection Class testclass
 */
public class DatabaseConnectionTest {
    private static Connection connection;

    /**
     * @desc : Method to test the set up of connection check whether null or not , connection should not be null
     */
    @BeforeClass
    public static void setUp() {
        connection = DatabaseConnection.getConnection();
        assertNotNull(connection,"Connection should not be null");
    }

    /**
     * @desc : Method to test the db connection , should not be null
     */
    @Test
    public void testDatabaseConnection(){
        assertNotNull(connection,"Connection should not be null");
    }

    /**
     * @desc : Method to check after close connection , it should be null or connection is closed or not
     */
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