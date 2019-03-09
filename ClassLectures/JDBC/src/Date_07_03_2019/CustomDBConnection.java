/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Date_07_03_2019;

import Date_05_03_2019.Metadata.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class CustomDBConnection {
static String host,dbname,username,password,port;
    static Connection conn = null;

    public static Connection getDBConnection() {
        try {
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shetu","root","1234");
            System.out.println("Connected!");
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(CustomDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
