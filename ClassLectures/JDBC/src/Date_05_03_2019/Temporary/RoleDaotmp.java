/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Date_05_03_2019.Temporary;

import Date_05_03_2019.JFrameCollection.Role;
import java.util.List;

/**
 *
 * @author User
 */
public interface RoleDaotmp {
    void createTable(String sql);
    void save(Role role);
    void update(Role role);
    Role getRoleById(int id);
    Role getRoleByRoleName(String roleName);
    void delete(int id);
    List<Role> getRoles();
}
