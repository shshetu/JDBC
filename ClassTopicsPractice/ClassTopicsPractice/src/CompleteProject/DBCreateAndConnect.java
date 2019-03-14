/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CompleteProject;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author shshe
 */
public class DBCreateAndConnect {
    static Connection conn = null;
   static String dbName = "Alhamdulillah";
   static String tbName = "employees";
    public static void main(String[] args) {
       createDatabase();
       dbConnection();
       createTable();
      // dropTable();
//  dropDatabase();
    }
    
    //Database create
    public static void createDatabase(){
       try {
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/? user=root & password =1234");
           //make the query
           String sql = "create database if not exists "+dbName;
           //create and execute statement
           PreparedStatement pstm = conn.prepareStatement(sql);
           pstm.executeUpdate();
           System.out.println(dbName+" database is successfully created!");
       }
       catch (SQLException ex) {
           Logger.getLogger(DBCreateAndConnect.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    //Database drop
    public static void dropDatabase(){
       try {
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/? user=root & password =1234");
           //make the query
           String sql = "drop database if  exists "+dbName;
           //create and execute statement
           PreparedStatement pstm = conn.prepareStatement(sql);
           pstm.executeUpdate();
           System.out.println(dbName+" database is successfully dropped!");
       
       }
       catch (SQLException ex) {
           Logger.getLogger(DBCreateAndConnect.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    //Connect to database
    public static Connection dbConnection(){
       try {
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName,"root","1234");
           System.out.println("Connected to "+dbName+"!");      
       } catch (SQLException ex) {
           Logger.getLogger(DBCreateAndConnect.class.getName()).log(Level.SEVERE, null, ex);
       }
       return conn;
    }
    
    //Create table
    public static void createTable(){
        try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName,"root","1234");
        //make the query
        String sql = "create table if not exists "+tbName+" (id int(20) primary key auto_increment,name varchar(20))";
        //Create and execute statement
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.executeUpdate();
            System.out.println(tbName+" table is created successfully!");
        } catch (Exception e) {
        }
    }
    
    //drop table
    public static void dropTable(){
        try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName,"root","1234");
        //make the query
        String sql = "drop table if exists "+tbName;
        //Create and execute statement
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.executeUpdate();
            System.out.println(tbName+" table is dropped successfully!");
        } catch (Exception e) {
        }
    } 
}
