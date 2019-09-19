package com.ideas2it.feastr.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ideas2it.feastr.exception.CustomException;

/**
 * Establishes and closes the JDBC connection with the mysql database for the
 * java program
 */
public class JdbcConnection {
    private static JdbcConnection jdbcConnection = null;
    private Connection connection = null;
    
    private JdbcConnection() {}
    
    public static JdbcConnection createInstance() {
        if (jdbcConnection == null) {
            jdbcConnection = new JdbcConnection();
        }
        return jdbcConnection;
    }
     
    /**
     * Creates a connection and returns the created connection
     *
     * @return Connection connection with the Mysql database 
     */
    public Connection getConnection(Connection connection) throws CustomException{
        try {
            if (connection == null) {        
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());  
                connection = DriverManager.getConnection(  
                "jdbc:mysql://localhost:3306/feastr","root","ubuntu");  
                //here menu is database name, root is username
            }
        } catch (SQLException exception) {
                throw new CustomException("Unable to establish connection" + exception);
        }
        return connection;
    }
 
    /** Closes the established JDBC connection */   
    public static void closeConnection(Connection connection) throws CustomException{
        try {
            connection.close();
        } catch (SQLException exception) {
            throw new CustomException("Unable to close connection" + exception);
        }
    }
}
