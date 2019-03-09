/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC_ExceptionHandling;

/**
 *
 * @author shshe
 */
import java.sql.*;
public class JDBCEXample {
    //JDBC driver name and database url
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/emp"; //we create emp database
    
    //Database credentials
    static final String USER = "root";
    static final String PASS = "1234";
    
    //main method
    public static void main(String[] args) {
        ///decalring the connection
        Connection conn = null;
        try {
            //1. Register the Driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //2.Create a connection
            System.out.println("Connecting to database....");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            //3.Create a statement
            System.out.println("Creating Statement...");
            Statement stmt = conn.createStatement();
            
            //4.Execute the statement
            String sql = "select id,first,last,age from employees";
            ResultSet rs = stmt.executeQuery(sql);
            //Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");
                
                //Display values
                System.out.println("ID: "+id);
                System.out.println(",Age: "+age);
                System.out.println(",First: "+first);
                System.out.println(",Last: "+last);
                
                //5.close the connection
                rs.close();
                stmt.close();
                conn.close();
            }
        } catch (Exception e) {
            
        }
        
    }
    
}
