/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojo.User;

/**
 *
 * @author User
 */
public interface LoginDao {
     User findByUsernameAndPassword(String username,String password);
}
