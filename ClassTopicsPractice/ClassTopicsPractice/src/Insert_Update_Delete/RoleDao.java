/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Insert_Update_Delete;

import java.util.List;

/**
 *
 * @author User
 */
public interface RoleDao {
    //crude operation
    void createTable();
    void insert(Role role);
    void update(Role role);
    void delete(Role role);
    
    //Validation
    Role getRoleById(int id);
    Role getRoleByRoleName(String roleName);
    ///collect data from the database 
    List<Role> getRoles();
}
