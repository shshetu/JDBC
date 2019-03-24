/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojo.User;
import java.util.List;

/**
 *
 * @author User
 */
public interface UserDao {
    //crude operation
    void createTable();
    void insert(User user);
    void update(User user);
    void delete(User user);
    
    //validation
    User findUserById(int id);
    User findUserByUsername(String username);
    //get data from the database
    List<User> getUsers();
    
}
