/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectivityWithMysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class ConnectJavaWithmysql {
    public static void main(String[] args) {
        //1.Register driver class
        try {
            Class.forName("com.mysql.jdbc.Driver");
             //2. Create connection
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonno", "root", "1234");
             System.out.println("Connection created!");
    //3. Create statement
        Statement stmt = con.createStatement();
        
        //4. Execute query => Result set
        ResultSet rs = stmt.executeQuery("Select * from emp");
        while(rs.next()){
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
        }
        //5. close connection
        con.close();
        } catch (Exception e) {
            e.getMessage();
        }
      
    }
}
