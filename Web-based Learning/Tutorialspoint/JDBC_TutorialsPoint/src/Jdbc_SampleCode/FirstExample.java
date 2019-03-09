/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jdbc_SampleCode;
import java.sql.*;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author shshe
 */
public class FirstExample {
    ///5 steps to follow:
    //1. Register the Driver
    //2. Create Connection
    //3. Create Statement
    //4. Execute Query
    //5. Close the connection
    ////=====================================////
    
               
 //jdbc driver name and database url
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/shetu";
    
    //Database credentials
    static final String USER = "root";
    static final String PASS = "1234";
    
    //main method
    public static void main(String[] args) {
        //Declaring the objects
        Connection conn = null;
        Statement stmt = null;
        try {
            //1. Register JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //2. Create a connection
            System.out.println("Connecting to database.....");
            //instantiate the object
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            //3.Create the statement
            System.out.println("Creating Statement: ");
          stmt = (Statement) conn.createStatement();
            
            //4.Execute the query
            String sql;
            sql = "Select id,first,last,age from shetu";
//            ResultSet rs = stmt.execute();
        } catch (Exception e) {
        }
    }
}
