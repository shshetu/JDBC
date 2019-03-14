/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalesMgmtPractice1;

import java.util.List;

/**
 *
 * @author shshe
 */
public interface StudentDao {
    //Crude Operation
    void insert(Student s);
    void update(Student s);
    void delete(Student s);
    
    //Need List to get all data from Student class
    List<Student> getStudentDataFromDatabaseTable();
    
    ///Check options
    Student getStudentDataById(int stId);
    Student getStudentDataByName(String stName);
}
