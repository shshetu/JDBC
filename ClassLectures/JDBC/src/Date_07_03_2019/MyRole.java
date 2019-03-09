/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Date_07_03_2019;

/**
 *
 * @author User
 */
public class MyRole {
    private int id;
    private String roleName;

    public MyRole(int id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }
    public MyRole(){}
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
