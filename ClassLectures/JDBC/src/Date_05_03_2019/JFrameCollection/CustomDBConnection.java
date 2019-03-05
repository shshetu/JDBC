/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Date_05_03_2019.JFrameCollection;

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

    static Connection conn = null;

    public static Connection getDBConnection(String host, String port,String dbname,String username,String password) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+dbname, username, password);
            System.out.println("Connected");
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(CustomDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
