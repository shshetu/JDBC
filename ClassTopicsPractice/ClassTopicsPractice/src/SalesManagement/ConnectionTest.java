/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalesManagement;

/**
 *
 * @author shshe
 */
public class ConnectionTest {
   //main method must
    public static void main(String[] args) {
        RoleDao roledao=new RoleDaoImp();
        roledao.createTable();
    }
}