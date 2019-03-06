/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Temporary.SalesManagement;

import java.sql.PreparedStatement;

/**
 *
 * @author User
 */
public class RoleDaoImp {
    public void save(Role role){
        //3.Create statement
        String sql = "insert into role(role_name) values(?))";
        try {
            //4.execute statement
            PreparedStatement pstm =  
        } catch (Exception e) {
        }
    }
}
