/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Insert_Update_Delete;

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

    Connection conn = CustomDBConnection.getConnection();

    @Override
    public void createTable() {
        //make query
        String sql = "create table if not exists employees(id int(11) primary key, role_name varchar(20))";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            System.out.println("employees table created successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(RoleDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void insert(Role role) {
        //make query
        String sql = "insert into employees values(?,?)";
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, role.getId());
            pstm.setString(2, role.getRoleName());
            pstm.executeUpdate();
            System.out.println("Data inserted into employees table successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(RoleDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Role role) {
        //make query
        String sql = "update employees set role_name = ? where id = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, role.getRoleName());
            pstm.setInt(2, role.getId());
            pstm.executeUpdate();
            System.out.println("Data updated into employees table successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(RoleDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Role role) {

        //make query
        String sql = "delete from employees where id = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, role.getId());
            pstm.executeUpdate();
            System.out.println("Deleted from employees table successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(RoleDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Role getRoleById(int id) {
        Role role = null;
        try {

            String sql = "select * from employees where id = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                role = new Role(rs.getInt(1), rs.getString(2));

            }

        } catch (SQLException ex) {
            Logger.getLogger(RoleDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return role;
    }

    @Override
    public Role getRoleByRoleName(String roleName) {
Role role = null;
        try {

            String sql = "select * from employees where role_name = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, roleName);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                role = new Role(rs.getInt(1), rs.getString(2));
            }

        } catch (SQLException ex) {
            Logger.getLogger(RoleDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return role;
    }

    @Override
    public List<Role> getRoles() {
        List<Role> list = new ArrayList<Role>();
        try {

            String sql = "select * from employees";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Role role = new Role(rs.getInt(1), rs.getString(2));
                list.add(role);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RoleDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

}
