/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_06_03_2019.SalesMg;

import Date_05_03_2019.JFrameCollection.*;
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
 * @author User
 */
public class RoleDaoImp implements RoleDao {



    @Override
    public void save(Role role) {
      String sql = "insert into role((role_name) values(?))";
        try {
            PreparedStatement pstm = BasicDatabaseBrowser.conn.prepareStatement(sql);
            pstm.setString(1, role.getRoleName());
            pstm.executeUpdate();
            System.out.println("Insert Success!");
        } catch (Exception e) {
        }
    }

    @Override
    public void update(Role role) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Role getRoleById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Role getRoleByRoleNmae(String roleName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Role> getRoles() {
        List<Role> list = new ArrayList<>();
        String sql = "select * from role";
        try {
            PreparedStatement ps = BasicDatabaseBrowser.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
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
    public void createTable(String sql) {
      //  String sql = "create table (role int(2) auto_increment primary key,role_name varchar(20) not null unique)";
        PreparedStatement pstm;
        try {
            pstm = BasicDatabaseBrowser.conn.prepareStatement(sql);
            pstm.execute();
            
            System.out.println("Table created");
        } catch (SQLException ex) {
            Logger.getLogger(RoleDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
