/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalesMgmtPractice1;

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
public class StudentDaoImp implements StudentDao {
    //1. Create connection

    Connection conn = CustomDBConnection.getConnection();

    @Override
    public void insert(Student s) {

        try {
            //2. Create Statement
            String sql = "insert into " + CustomDBConnection.tbName + "(name) values = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, s.getName());
            //3. Execute Statement
            pstm.executeUpdate();
            //4.cloe the connection, statements
            pstm.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Student s) {
        try {
            //2. Create Statement
            String sql = "update " + CustomDBConnection.tbName + " set name = ? where id = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, s.getName());
            pstm.setInt(2, s.getId());
            //3. Execute Statement
            pstm.executeUpdate();
            //4.cloe the connection, statements
            pstm.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Student s) {
        try {
            //2. Create Statement
            String sq1 = "delete " + CustomDBConnection.tbName + " where id = ?";
            PreparedStatement pstm = conn.prepareStatement(sq1);
            pstm.setInt(1, s.getId());
            //3. Execute Statement
            pstm.executeUpdate();
            //4.cloe the connection, statements
            pstm.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Student> getStudentDataFromDatabaseTable() {
        //Create an object
        List<Student> list = new ArrayList<>();
        try {

            //2. Create Statement
            String sql = "Select * from " + CustomDBConnection.tbName;
            PreparedStatement pstm = conn.prepareStatement(sql);
            //3. Execute Statement
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
           Student student = new Student(rs.getInt("id"),rs.getString("name"));
           list.add(student);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Student getStudentDataById(int stId) {
        //create an object
        Student obj = null;
        try {
            //create a statement
            String sql = "Select * from "+CustomDBConnection.tbName+" where id=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, stId);
            //execute a statement
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
            Student s = new Student(rs.getInt("id"), rs.getString("name"));
            }
        } catch (Exception e) {
        }
        
        return obj;
    }

    @Override
    public Student getStudentDataByName(String stName) {
          //create an object
        Student obj = null;
        try {
            //create a statement
            String sql = "Select * from "+CustomDBConnection.tbName+" where name=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, stName);
            //execute a statement
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
            Student s = new Student(rs.getInt("id"), rs.getString("name"));
            }
        } catch (Exception e) {
        }
        
        return obj;
    }
    

}
