/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyCompany;

import SalesManagement.*;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author shshe
 */
public class CustomDBConnection {
    static Connection conn = null;
    public static Connection getDBConnection(){
        try {
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mycompany","root","1234");
           //print the message that it's connected 
            System.out.println("Connected!");
            //must return it
            return conn;
        } catch (Exception e) {
        }
        return conn;
    }
}
