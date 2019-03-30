/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageaddproject;

import java.io.File;
import java.util.List;

/**
 *
 * @author User
 */
public interface StudentDao {

    //crude operation
    void createTable();
    void insert(Student student, File file);

    ///Collect data from the database
    List<Student> getStudent();
}
