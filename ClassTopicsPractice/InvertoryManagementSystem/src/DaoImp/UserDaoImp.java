/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImp;

import Connection.CustomDBConnection;
import Dao.UserDao;
import Pojo.Role;
import Pojo.User;
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
public class UserDaoImp implements UserDao {

    Connection conn = CustomDBConnection.getConnection();

    @Override
    public void createTable() {
        try {
            String sql = "create table if not exists user(id int(11) auto_increment primary key,full_name varchar(50),user_name varchar(30) unique,password varchar(30),mobile_no varchar(14),role_id int(2),foreign key(role_id) references role(id))";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            System.out.println("User table created!");
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(User user) {
        String sql = "insert into user(full_name,user_name,password,mobile_no,role_id) values(?,?,?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, user.getFullName());
            pstm.setString(2, user.getUserName());
            pstm.setString(3, user.getPassword());
            pstm.setString(4, user.getMobile());
            pstm.setInt(5, user.getRole().getId());
            pstm.executeUpdate();
            System.out.println("Data inserted successfully into user table!");
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(User user) {
        String sql = "update user set full_name= ?, user_name= ?, password= ?,mobile_no = ?,role_id = ? where id=?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, user.getFullName());
            pstm.setString(2, user.getUserName());
            pstm.setString(3, user.getPassword());
            pstm.setString(4, user.getMobile());
            pstm.setInt(5, user.getRole().getId());
            pstm.setInt(6, user.getId());
            System.out.println("Data updated successfully into user table!");
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(User user) {
        String sql = "delete from user where id=?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, user.getId());
            pstm.executeUpdate();
            System.out.println("Data deleted from user table where id= " + user.getId());
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public User findUserById(int id) {
        User user = new User();

        return user;
    }

    @Override
    public User findUserByUsername(String username) {
        User user = null;
        String sql = "select * from user where username = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, username);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), new Role(rs.getInt(6)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public List<User> getUsers() {
        List<User> list = new ArrayList<>();
        String sql = "select * from user";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), new Role(rs.getInt(6)));
                list.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

}
