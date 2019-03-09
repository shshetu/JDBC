/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author shshe
 */
public class StudentService implements StudentDao{
    Connection conn = DBConnection.getConnection();
    
    @Override
    public void save(Student s) {
        try {
            if(s.getName() != null){
            //create statement
                PreparedStatement pstm = conn.prepareStatement("insert into stud(name) values(?)");
                pstm.setString(1, s.getName());
                //execute the statement
                  pstm.executeUpdate();
                  System.out.println("Success!");
            }
        }
         catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Student s) {
        try {
           //create statement
           PreparedStatement pstm = conn.prepareStatement("update stud set name=? where id=?");
           pstm.setString(1, s.getName());
           pstm.setInt(2, s.getId());
            //execute the statement
            pstm.executeUpdate();
            System.out.println("Update success...");
        } catch (Exception e) {
        }
    }
    
}
