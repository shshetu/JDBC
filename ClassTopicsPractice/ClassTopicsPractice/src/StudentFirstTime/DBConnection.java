/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentFirstTime;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author shshe
 */
public class DBConnection {
   //Declare the Connection object
    //1. Create Connection
    public static Connection conn = null;
    public static Connection getConnection(){
        try {
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","1234");
            System.out.println("::Connected::");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
