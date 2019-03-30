/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageaddproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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
public class StudentDaoImp implements StudentDao {

    Connection conn = CustomDBConnection.getConnection();

    @Override
    public void createTable() {
        //student id, student name, student file_name , file_path, photo = blob
        String sql = "create table if not exists student(id int auto_increment primary key,name text not null, photo blob not null,file_path varchar(155) not null,file_name varchar(155))";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            System.out.println("Student table is created successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(Student student, File file) {
        FileInputStream inputStream = null;
        String sql = "insert into student(name,photo,file_path,file_name) values(?,?,?,?)";
        try {
            inputStream=new FileInputStream(file);
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, student.getName());
            pstm.setBinaryStream(2, (InputStream) inputStream, (int) file.length()); //going for file path
            pstm.setString(3, student.getFilePath());
            pstm.setString(4, student.getFileName());
            pstm.executeUpdate();
            System.out.println("Insertion is successful into student table!");

        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StudentDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Student> getStudent() {
        List<Student> list = new ArrayList<>();
        String sql = "select * from student";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Student st = new Student(rs.getInt(1), rs.getString(2), rs.getBytes(3), rs.getString(4), rs.getString(5));
                list.add(st);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
