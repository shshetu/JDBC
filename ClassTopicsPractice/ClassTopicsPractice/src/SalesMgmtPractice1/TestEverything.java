/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalesMgmtPractice1;

/**
 *
 * @author shshe
 */
public class TestEverything {
    public static void main(String[] args) {
        //create a database
        CustomDBConnection.createDatabase();
        //create a table
        CustomDBConnection.createTable();
        ///connect to the database
        CustomDBConnection.getConnection();
        //drop table
//        CustomDBConnection.dropTable();
        //drop database
//        CustomDBConnection.dropDatabase();
    }
}
