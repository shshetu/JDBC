/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CompleteProject;

/**
 *
 * @author shshe
 */
public class Fields {
    //Fields
    private int id;
    private String name;

    public Fields() {
    }

    //Make the private variables public
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    //Constructors

    public Fields(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Fields(String name) {
        this.name = name;
    }
    
    
}
