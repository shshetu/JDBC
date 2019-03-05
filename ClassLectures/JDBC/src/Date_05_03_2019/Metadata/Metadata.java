package Date_05_03_2019.Metadata;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Metadata {
   static Connection connection = CustomDBConnection.getDBConnection();
   static DatabaseMetaData metadata = null;
   
   //static block for initialization
 static{
     try {
         metadata = connection.getMetaData();
     } catch (Exception e) {
         System.err.println("There was an error getting the metadata: "+e.getMessage());
     }
 }
 
 //main method
    public static void printGeneralMetadata() throws SQLException {
        System.out.println("Database Name: "+ metadata.getDatabaseProductName());
        System.out.println("Database Version: "+ metadata.getDatabaseProductVersion());
        System.out.println("Logged User: "+ metadata.getUserName());
        System.out.println("JDBC Driver: "+ metadata.getDriverName());
        System.out.println("Driver Version: "+ metadata.getDriverVersion());
        System.out.println("\n");
    }
    
    //Creating ArrayList
    public static ArrayList getTablesMetadata() throws SQLException{
    String table[] = {"TABLE"};
    ResultSet rs = null;
    ArrayList tables = null;
    //recieve the Type of the object in a String Array
    rs = metadata.getTables(null, null, null, table);
    tables = new ArrayList();
    while(rs.next()){
    tables.add(rs.getString("TABLE_NAME"));
    }
    return tables;
    }
    
    ///next method
    public static void getColumnnsMetadata(ArrayList tables)throws SQLException{
    ResultSet rs = null;
    //Print the columns properties of the actual table
    for(Object actualTable: tables){
    rs = metadata.getColumns(null, null, actualTable.toString(), null);
        System.out.println(actualTable.toString().toUpperCase());
        while (rs.next()) {            
            System.out.println(rs.getString("COLUMN_NAME")+rs.getString("TYPE_NAME")+rs.getString("COLUMN_SIZE"));
        }
        System.out.println("\n");
    }
    }
    
    ///Main method
    public static void main(String[] args) {
        try {
            printGeneralMetadata();
            //print all the tables of the database scheme, with their names
            
            for(Object obj: getTablesMetadata()){
                System.out.println(obj.toString());
            }
            //and structure
            getColumnnsMetadata(getTablesMetadata());
        } catch (Exception e) {
            System.err.println("There was an error retrieving the metadata properties: "+ e.getMessage());
        }
    }
    
}
