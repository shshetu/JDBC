/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyCompany;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class UserDaoImpl implements UserDao{
//Create Connection 
    Connection conn = CustomDBConnection.getDBConnection();
    //Call the main method
    public static void main(String[] args) {
        UserDao obj = new UserDaoImpl();
        obj.createTable();
    }
    @Override
    public void createTable() {
       String sql = "create table IF NOT EXISTS user(id int(11) auto_increment primary key,full_name varchar(50),user_name varchar(30),password varchar(30),mobile_no varchar(14),role_id int(2),FOREIGN KEY(role_id) REFERENCES role(id))";
        try {
           PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            System.out.println("Table Created!");
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(User user) {
        //make query
        String sql = "insert into user(full_name,user_name,password,mobile_no,role_id) values(?,?,?,?,?)";
        //create Statement
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, user.getFullName());
            pstm.setString(2, user.getUserName());
            pstm.setString(3, user.getPassword());
            pstm.setString(4,user.getMobile());
            pstm.setInt(5, user.getRole().getId());
            pstm.executeUpdate();
            System.out.println("Insert success!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
       
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUserById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUserByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getUsers() {
       List<User> users = new ArrayList<>();
       User user;
       String sql = "select * from user";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery();
            while(rs.next()){
            Role role = new Role(rs.getInt(6)); //why?
            user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),role);
           users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       return users;
    }
    
}
