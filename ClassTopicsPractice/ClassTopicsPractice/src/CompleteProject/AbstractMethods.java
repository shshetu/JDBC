/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CompleteProject;

import java.util.List;

/**
 *
 * @author shshe
 */
public interface AbstractMethods {
    //Crude Operations
    void createDatabase();
    void createTable();
    void insert(Fields f);
    void update(Fields f);
    void delete(Fields f);
    
    //List type data to add to the table
    List<Fields> getFields();
    
    //getFieldsByName
    Fields getFieldsByName(String name);
}
