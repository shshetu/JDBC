/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jdbc_CreateDatabaseExample;

/**
 *
 * @author shshe
 */
import java.sql.*;
public class JDBCExample {
 
    //JDBC DriverName and Database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.driver";
    static final String DB_URL = "jdbc:mysql://localhost";
    
    //Database Credentials
    static final String USER = "root";
    static final String PASS = "1234";
    
    //Main method
    public static void main(String[] args) {
        //Create the Object 
        Connection conn = null;
        Statement stmt = null;
        try {
            //1. Register the driver
            Class.forName(JDBC_DRIVER);
            
            //2.Create a connection
            System.out.println("Connecting to database....");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            //3.Create the statement
            System.out.println("Creating database...");
            stmt = conn.createStatement();
            
            //4.Execute the statement
            String sql = "create database students";
            stmt.executeUpdate(sql);
            System.out.println("Database create Successfully....");
            
        } catch (Exception e) {
        }
    }
}
