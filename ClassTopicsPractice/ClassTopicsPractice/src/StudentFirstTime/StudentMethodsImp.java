/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentFirstTime;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shshe
 */
public class StudentMethodsImp implements StudentMethods{

    @Override
    public void save(StudentFields s) {
        try {
            //3.Create Statement
            PreparedStatement pstm = DBConnection.conn.prepareStatement("insert into stud (name) values(?)");
            pstm.setString(1, s.getName());
            
            //4.execute Statement
            pstm.executeUpdate();
            System.out.println("Success!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(StudentFields s) {
        try {
            //3.Create Statement
            PreparedStatement pstm = DBConnection.conn.prepareStatement("update stud set name=? where id=?");
            pstm.setString(1, s.getName());
            pstm.setInt(2, s.getId());
            //4.Execute Statement
            pstm.executeUpdate();
            System.out.println("Update is successful...");
        } catch (SQLException ex) {
            Logger.getLogger(StudentMethodsImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
