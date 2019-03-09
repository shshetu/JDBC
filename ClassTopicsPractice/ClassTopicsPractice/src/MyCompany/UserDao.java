/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyCompany;

import java.util.List;

/**
 *
 * @author User
 */
public interface UserDao {
    void createTable();
    
    //Void Type : pass by reference
    void save(User user);
    void update(User user);
    //delete pass by value
    void delete(int id);
    
    // User Type
    User getUserById(int id);
    User getUserByUsername(String username);
    
    //List Type
    List<User> getUsers();
}
