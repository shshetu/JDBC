/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalesMgmtPractice1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shshe
 */
public class CustomDBConnection {

    static Connection conn = null;
    static String dbName = "shetu";
    static String tbName = "employees";
    static String user = "root";
    static String pass = "1234";

    ///Create a Database
    public static void createDatabase() {
        try {
            //1. create a connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/? user=" + user + " & password =" + pass);
            //2. create a statement
            String sql = "create database if not exists " + dbName;
            PreparedStatement pstm = conn.prepareStatement(sql);
            //3. execute a statment
            pstm.executeUpdate();
            System.out.println(dbName + " Database is created Successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(CustomDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Drop Databasse
    public static void dropDatabase() {
        try {
            //1. create a connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/? user=" + user + " & password =" + pass);
            //2. create a statement
            String sql = "drop database if exists " + dbName;
            PreparedStatement pstm = conn.prepareStatement(sql);
            //3. execute a statment
            pstm.executeUpdate();
            System.out.println(dbName + " Database is dropped Successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(CustomDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Create a table
    public static void createTable() {
        try {
            //1. create a connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, user, pass);
            //2. create a statement
            String sql = "create table if not exists " + tbName + "(id int(20) primary key auto_increment,name varchar(30))";
            PreparedStatement pstm = conn.prepareStatement(sql);
            //3. execute a statment
            pstm.executeUpdate();
            System.out.println(tbName + " Table is created Successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(CustomDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Drop table
    public static void dropTable() {
        try {
            //1. create a connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, user, pass);
            //2. create a statement
            String sql = "drop table if exists " + tbName;
            PreparedStatement pstm = conn.prepareStatement(sql);
            //3. execute a statment
            pstm.executeUpdate();
            System.out.println(tbName + " Table is dropped Successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(CustomDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Create Connection
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/" + dbName;
        try {
            conn = DriverManager.getConnection(url,user,pass);
            System.out.println("Connected to datase: "+dbName);
        } catch (SQLException ex) {
            Logger.getLogger(CustomDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
