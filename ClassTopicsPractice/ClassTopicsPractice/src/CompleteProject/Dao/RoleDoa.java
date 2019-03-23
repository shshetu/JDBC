/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CompleteProject.Dao;

import CompleteProject.Pojo.Role;
import java.util.List;

/**
 *
 * @author shshe
 */
public interface RoleDoa {
    //crude operation 
    void createTable();
    void insert(Role role);
    void update(Role role);
    void delete(Role role);
    
    //get data from database
    List<Role> getRoles();
    //validation methods
    Role findRolebyid(int id);
    Role findRolebyroleName(String roleName);
}
