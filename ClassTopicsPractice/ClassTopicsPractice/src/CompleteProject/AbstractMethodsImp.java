/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CompleteProject;
import static CompleteProject.DBCreateAndConnect.dbName;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shshe
 */
public class AbstractMethodsImp implements AbstractMethods{
    Connection conn = DBCreateAndConnect.dbConnection();
     static String dbName = "Alhamdulillah";
   static String tbName = "employees";
    @Override
    public void createTable() {
  try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName,"root","1234");
        //make the query
        String sql = "create table if not exists "+tbName+" (id int(20) primary key auto_increment,name varchar(20))";
        //Create and execute statement
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.executeUpdate();
            System.out.println(tbName+" table is created successfully!");
        } catch (Exception e) {
        } }

    @Override
    public void insert(Fields f) {
        try {
            //make the query
            String sql = "insert into "+DBCreateAndConnect.dbName+"(name) values = ? ";
            //Create and execute the statement
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, f.getName());
            pstm.executeUpdate();
            System.out.println("Data successfully inserted into: "+DBCreateAndConnect.tbName+" table!");
        } catch (SQLException ex) {
            Logger.getLogger(AbstractMethodsImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void update(Fields f) {
        try {
            //Make the query
            String sql = "update "+DBCreateAndConnect.tbName+" set name=? where id=?";
            //Create and execute Statement
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, f.getName());
            pstm.setInt(2, f.getId());
            pstm.executeUpdate();
            System.out.println("Data Successfully updated into "+DBCreateAndConnect.tbName+" table!");
        } catch (SQLException ex) {
            Logger.getLogger(AbstractMethodsImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Fields f) {
        try {
            //make the query
            String sql = "delete from "+DBCreateAndConnect.tbName+" where id=?";
            //Create and execute Statement
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, f.getId());
            System.out.println("Data successfully deleted from "+DBCreateAndConnect.tbName+" table!");
        } catch (SQLException ex) {
            Logger.getLogger(AbstractMethodsImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Fields> getFields() {
    List<Fields> list = new ArrayList<>();
    //make the querry
        String sql = "select * from "+DBCreateAndConnect.tbName;
        try {
            //create and execute Statement
            PreparedStatement pstm = conn.prepareStatement(sql);
            ///Get data using ResultSet
            //statement Executed
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
           Fields f = new Fields(rs.getInt(1),rs.getString(2));
            list.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbstractMethodsImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list; 
    }

    @Override
    public Fields getFieldsByName(String name) {
        Fields f = null;
        //make the query
        String sql = "select * from "+DBCreateAndConnect.tbName+" where name=?";
        try {
            //create and execute statement
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, name);
            ResultSet rs = pstm.executeQuery();
        while(rs.next()){
        //Get from the database and Send data to the Fields
        Fields fi = new Fields();
        fi.setId(rs.getInt(1));
        fi.setName(rs.getString(2));
        }
        } catch (SQLException ex) {
            Logger.getLogger(AbstractMethodsImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
        
    }

    @Override
    public void createDatabase() {
try {
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/? user=root & password =1234");
           //make the query
           String sql = "create database if not exists "+dbName;
           //create and execute statement
           PreparedStatement pstm = conn.prepareStatement(sql);
           pstm.executeUpdate();
           System.out.println(dbName+" database is successfully created!");
       }
       catch (SQLException ex) {
           Logger.getLogger(DBCreateAndConnect.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
}
