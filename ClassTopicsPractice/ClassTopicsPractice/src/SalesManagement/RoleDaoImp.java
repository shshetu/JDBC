/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalesManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shshe
 */
public class RoleDaoImp implements RoleDao{
    //We must call the CustomDB Connection
    Connection conn = CustomDBConnection.getDBConnection();
    @Override
    public void createTable() {
        try {
            //make the query
            String sql = "create table IF NOT EXISTS role(id int(2) auto_increment primary key,role_name varchar(20) unique)";
            //create the statement
            PreparedStatement pstm = conn.prepareStatement(sql);
           //If we do not pass any object we won't use setInt()
          //Execute the statement
           pstm.execute();
           //Give a message
            System.out.println("Table Created!");
        } catch (SQLException ex) {
            Logger.getLogger(RoleDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

    @Override
    public void save(Role role) {
        try {
            //make the query
            String sql ="insert into role(name) values(?)";
            //create statement
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, role.getRoleName());
            //execute statement
            pstm.executeUpdate();
            System.out.println("Insertion Successful!");
        } catch (Exception e) {
        }
   
    }

    @Override
    public void delete(Role role) {
        try {
            //make the query
            String sql = "delete from role where id = ?";
            //Create the statement
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, role.getId());
            //Confirmation message
            System.out.println("Delete Successful!");
        } catch (SQLException ex) {
            Logger.getLogger(RoleDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @Override
    public Role getRoleById(int id) {
        Role role = new Role();
        //make the query
        String sql = "select * from role where id = ?";
        try {
            //create the Statement
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            //Executing the statement using ResultSet
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
            role.setId(rs.getInt(1));
            role.setRoleName(rs.getString(2));
            }
        } catch (Exception e) {
        }
        return role;
    }

    @Override
    public Role getRoleByRoleName(String roleName) {
         //make an object
            Role role = new Role();
        try {
            //Make the query
            String sql ="select * from role where name=?";
            //Create the statement
            PreparedStatement pstm = conn.prepareStatement(sql);
           pstm.setString(1, roleName);
           //Execute the query using Resultset
           ResultSet rs = pstm.executeQuery(); //if result set then Execute is a must
           while(rs.next()){
           role.setId(rs.getInt(1));
           role.setRoleName(rs.getString(2));
           }
        } catch (SQLException ex) {
            Logger.getLogger(RoleDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
         return role;
    }

    @Override
    public List<Role> getRoles() {
        //Create the object of List
            List<Role> list = new ArrayList<Role>();
        try {
            
            //make the query
            String sql = "select * from role";
            //Create the statement
            PreparedStatement pstm = conn.prepareStatement(sql);
            //Execute the statement
            ResultSet rs  = pstm.executeQuery();
            while(rs.next()){
            Role role = new Role(rs.getInt(1),rs.getString(2));
            list.add(role);
            }
       
        } catch (SQLException ex) {
            Logger.getLogger(RoleDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
             return list;
    }

    @Override
    public void update(Role role) {
        try {
            //make the query
            String sql = "update role set name = ? where id = ?";
            //Create the statement
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, role.getRoleName());
            //Execute the statement
            pstm.executeUpdate();
            System.out.println("Update Successful!");
        } catch (SQLException ex) {
            Logger.getLogger(RoleDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
