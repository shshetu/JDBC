/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_06_03_2019.SalesMg;

import Date_05_03_2019.JFrameCollection.*;
import java.util.List;

/**
 *
 * @author User
 */
public interface RoleDao {
    void createTable(String sql);
    void save(Role role);
    void update(Role role);
    Role getRoleById(int id);
    Role getRoleByRoleNmae(String roleName);
    void delete(int id);
    
    List<Role> getRoles();
    
    
    
    
    
    
    
    
}
