/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Date_07_03_2019;

import java.util.List;

/**
 *
 * @author User
 */
public interface MyRoleDao {
   
    
    //void type = save, update
    void createTable(String sql);
    void save(MyRole role);
    void update(MyRole role);
    void delete(int id);
    
     //MyRole type
    MyRole getRoleById(int id);
    MyRole getRoleByName(String role_name);
    
    ///To add or remove data
    List<MyRole> getRoles();
}
