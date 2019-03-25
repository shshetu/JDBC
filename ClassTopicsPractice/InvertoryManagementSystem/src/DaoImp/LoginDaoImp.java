/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImp;

import Connection.CustomDBConnection;
import Dao.LoginDao;
import Pojo.Role;
import Pojo.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shshe
 */
public class LoginDaoImp implements LoginDao {

    Connection conn = CustomDBConnection.getConnection();

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = null;
        String sql = "select * from user where user_name = ? and Password = ?";
       
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), new Role(rs.getInt(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

}
