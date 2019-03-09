/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyCompany;

import SalesManagement.*;
import java.util.List;

/**
 *
 * @author shshe
 */
public interface RoleDao {
    //void type
    void createTable();
    void save(Role role);
    void delete(Role role);
    void update(Role role);
    //Role type
    Role getRoleById(int id);
    Role getRoleByRoleName(String roleName);
    
    //List type
    List<Role> getRoles();
}
