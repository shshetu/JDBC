/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Date_07_03_2019;

import Temporary.SalesManagement.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class MyRoleDaoImp implements MyRoleDao{

    @Override
    public void createTable(String sql) {
        //Create Query
        String sql1;
        sql1 = "create table role(id int(20) auto_increment primary key,role_name varchar(20) not null unique)";
       
        PreparedStatement pstm;
        try {
             //Create statement
            pstm = CustomDBConnection.conn.prepareStatement(sql1);
            //Execute statement
            pstm.execute();
            System.out.println("Table created!");
        } catch (Exception e) {
        }
    }

    @Override
    public void save(MyRole role) {
        String sql;
        sql = "insert into role((role_name) values(?))";
        //create the statement
        try {
            PreparedStatement pstm = CustomDBConnection.conn.prepareStatement(sql);
            pstm.setString(1, role.getRoleName());
            //execute the statement
            pstm.executeUpdate();
            System.out.println("Insertion is successful!");
        } catch (Exception e) {
        }
    }

    @Override
    public void update(MyRole role) {
       //Create Query
        String sql = "update role set role_name = ? where id=?";
       
        try {
            //Create Statement
            PreparedStatement pstm = CustomDBConnection.conn.prepareStatement(sql);
            pstm.setString(1, role.getRoleName());
            pstm.setInt(2, role.getId());
            //Execute statement
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
       //Execute Statement
  
    }

    @Override
    public void delete(int id) {
        //Create Query
        String sql ="delete from role where id=?";
        
        try {
            //Create Statement
            PreparedStatement pstm = CustomDBConnection.conn.prepareStatement(sql);
            pstm.setInt(1, id);
            //Execute Statement
            pstm.executeUpdate(); //If we are not saving data into resultSet we won't use executeQuery()
            System.out.println("Delete Success!");
        } catch (Exception e) {
        }
        
    }

    @Override
    public MyRole getRoleById(int id) {
        //Since MyRole Type so we have to make object
        MyRole role = new MyRole();
        //Create Query
        String sql = "select * from role where id=?";
        try {
            //Create Statement
            PreparedStatement pstm = CustomDBConnection.conn.prepareStatement(sql);
            pstm.setInt(1, id);
        //Execute statement
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
    public MyRole getRoleByName(String roleName) { //Method is MyRole type 
        MyRole role = new MyRole(); 
        //Create Query
        String sql = "select * from role where role_name=?";
        try {
            //Create Statement
            PreparedStatement pstm = CustomDBConnection.conn.prepareStatement(sql);
            pstm.setString(1, roleName); //MyRole Type
            //Execute Statement and keep it on ResultSet
            ResultSet rs = pstm.executeQuery(); //Must to use executeQuery
            while(rs.next()){
            //We have to must use object to call 
            //We must set inside role
            role.setId(rs.getInt(1));
            role.setRoleName(rs.getString(2));
            }
        
        } catch (Exception e) {
        }
        return role;
    }

    @Override
    public List<MyRole> getRoles() {
        List<MyRole> list = new ArrayList<>();
        //Create Query
        String sql = "select * from role";
        try {
            //Create Statement
            PreparedStatement pstm = CustomDBConnection.getDBConnection().prepareStatement(sql);
            //Execute statement using ResultSet 
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {                
                MyRole role = new MyRole(rs.getInt(1),rs.getString(2));
                list.add(role);
            }
        } catch (Exception e) {
        }
    return list;
    }
    
}
