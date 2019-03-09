/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC_DataTypes;

/**
 *
 * @author shshe
 */
public class SqlDateTime {
    public static void main(String[] args) {
        //Get standard date and time
        java.util.Date javaDate = new java.util.Date();
        long javaTime = javaDate.getTime();
        System.out.println("The Java Date is: "+ javaDate.toString());
        
        //Get and display SQL Date
        java.sql.Date sqlDate = new java.sql.Date(javaTime);
        System.out.println("The Sql Date is: "+ sqlDate.toString()); //we hava to use teh toStringMethod() coz it will return the object
        
        //Get and Disply SQL Time
        java.sql.Time sqlTime = new java.sql.Time(javaTime);
        System.out.println("The SQL Time is: "+ sqlTime.toString());
        
        //Get and display SQL TimeStamp
        java.sql.Timestamp sqlTimeStamp = new java.sql.Timestamp(javaTime);
        System.out.println("The SQL TimeStamp is: "+ sqlTimeStamp.toString());
    }
  
}
