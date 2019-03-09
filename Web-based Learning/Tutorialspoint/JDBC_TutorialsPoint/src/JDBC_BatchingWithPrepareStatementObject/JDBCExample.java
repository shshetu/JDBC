/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC_BatchingWithPrepareStatementObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author shshe
 */
public class JDBCExample {
    //JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/emp";
    
    //Database credentials
    static final String USER = "root";
    static final String PASS = "1234";
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
              //1.Register the driver
//        Class.forName(JDBC_DRIVER);
        //2. Create Connection
            System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
        //3. Create Statement
        //create sql statement
        String sql = "Insert into employess(id,first,last,age) values(?,?,?,?)";
            System.out.println("Creating Statement.....");
            stmt = conn.prepareStatement(sql);
            
            //set auto-Commit to false
            conn.setAutoCommit(false);
            
            //First let us select all the records and display them
            printRows(stmt);

            //Set the variables
            stmt.setInt(1, 400);
            stmt.setString(2, "Pappu");
            stmt.setString(3,"Singh");
            stmt.setInt(4, 33);
            
            ///Add it to the batch
            stmt.addBatch();
            
            //Set the variables
             stmt.setInt(1, 401);
            stmt.setString(2, "Pawan");
            stmt.setString(3,"Singh");
            stmt.setInt(4, 31);
            
            //Add it to the batch
            stmt.addBatch();
            
                //4. Execute Statement
            //Create and int[] to hold returned values
            int[] count = stmt.executeBatch();
            
            //Explicitly commit statements to apply changes
            conn.commit();
            
            //Again, let us select all the records and display them.
            printRows(stmt);

            
       //5. close the connection or clean up teh environment
       stmt.close();
       conn.close();
        //5. Close connection
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.getMessage();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();}
        finally{
        //finally block used to close resources
            try {
                if(stmt!=null){stmt.close();}
            } catch (SQLException se) {
                //nothing we can do
            }
            try {
                if(conn!= null){conn.close();}
            } catch (SQLException se) {
            se.printStackTrace();
            } //end finally try
        } //end try
        System.out.println("GoodBye!");
        
        
    }
    
    //printRows class
    public static void printRows(Statement stmt) throws SQLException{
        System.out.println("Displaying available rows...");
        //Let us select all the records and display them
        String sql = "select id,first,last,age from employees";
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
        //Retrieve by column name
        int id = rs.getInt("id");
        int age = rs.getInt("age");
        String first = rs.getString("first");
        String last = rs.getString("last");
        
        //Display values
            System.out.print("ID: "+id);
            System.out.print(",Age: "+age);
            System.out.print(",First: "+first);
            System.out.print("Last: "+last);
        }
        System.out.println("");
        rs.close();
    }
}
