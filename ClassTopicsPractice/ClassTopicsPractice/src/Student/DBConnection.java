/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author shshe
 */
public class DBConnection {
    private static final String HOST = "jdbc:mysql://localhost:3306";
    private static final String DBNAME = "student";
    private static final String URL = HOST+"/"+DBNAME;
    private static Connection conn = null;
    
    public static Connection getConnection(){
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL,"root","1234");
            System.out.println("::Connected::");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
