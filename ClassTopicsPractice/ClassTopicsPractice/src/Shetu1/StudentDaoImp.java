/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shetu1;

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

    Connection conn = CustomDBConnection.getConnection();

    @Override
    public void createTable() {
        String sql = "create table if not exists student(id int(10) primary key, name varchar(11))";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            System.out.println("student Table created Successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(Student student) {
        String sql = "insert into student values(?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, student.getId());
            pstm.setString(2, student.getName());
            pstm.executeUpdate();
            System.out.println("Data successfully inserted into student table!");
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Student student) {
        String sql = "update student set name =? where id=?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, student.getName());
            pstm.setInt(2, student.getId());
            pstm.executeUpdate();
            System.out.println("Data successfully Updated into student table!");
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Student student) {

        String sql = "delete from student where id=?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, student.getId());
            pstm.executeUpdate();
            System.out.println("Data successfully Deleted from student table!");
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Student> findStudentById(int id) {
        List<Student> list = null;

        String sql = "select * from student where id=?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Student student = new Student(rs.getInt(1), rs.getString(2));
                list.add(student);
            }
            System.out.println("Data Found!");
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<Student> findStudentByName(String name) {

        List<Student> list = null;

        String sql = "select * from student where name=?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, name);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Student student = new Student(rs.getInt(1), rs.getString(2));
                list.add(student);
            }
            System.out.println("Data Found!");
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<Student> findStudent() {
        List<Student> list = new ArrayList<>();
        try {

            String sql = "select * from student";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Student student = new Student(rs.getInt(1), rs.getString(2));
                list.add(student);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
