/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentFirstTime;

/**
 *
 * @author shshe
 */
public class StudentFields {
    //Fields: Name, Id
    private int id;
    private String name;

    public StudentFields(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public StudentFields() {
    }

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
}
