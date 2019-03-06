/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Temporary.SalesManagement;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author User
 */
public class DBConnection {
    static Connection conn = null;
    
    public static Connection getDBConnection(String host,String port,String dbname,String username,String password){
        try {
            //1.Register Driver class
            ///2.Create Connection 
            conn = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+dbname,username,password);
            System.out.println("Connected!");
            return conn;
        } catch (Exception e) {
        }
        
        return null;
    }
}
