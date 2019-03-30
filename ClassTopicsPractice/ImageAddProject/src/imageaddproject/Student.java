/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageaddproject;

/**
 *
 * @author User
 */
public class Student {

    private int id;
    private String name;  //student name
    private byte[] photo; //collect the bytes from database for the photo
    //two things are must for a file: path,name
    private String filePath;  //where
    private String fileName;

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

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Student(int id, String name, byte[] photo, String filePath, String fileName) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.filePath = filePath;
        this.fileName = fileName;
    }

    public Student(String name, byte[] photo, String filePath, String fileName) {
        this.name = name;
        this.photo = photo;
        this.filePath = filePath;
        this.fileName = fileName;
    }

    public Student() {
    }

    public Student(String name, byte[] photo) {
        this.name = name;
        this.photo = photo;
    }

    public Student(String name, String filePath, String fileName) {
        this.name = name;
        this.filePath = filePath;
        this.fileName = fileName;
    }

}
