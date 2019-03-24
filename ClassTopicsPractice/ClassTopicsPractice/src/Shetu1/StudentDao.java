/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shetu1;

import java.util.List;

/**
 *
 * @author shshe
 */
public interface StudentDao {
    //Crude Operation
    void createTable();
    void insert(Student student);
    void update(Student student);
    void delete(Student student);
    //Search
    List<Student> findStudentById(int id);
    List<Student> findStudentByName(String name);
    
   
    
    ///Get data from database
    List<Student> findStudent();
    
    
}
