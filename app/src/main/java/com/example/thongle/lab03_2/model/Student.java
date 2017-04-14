package com.example.thongle.lab03_2.model;

import java.util.UUID;

/**
 * Created by thongle on 14/04/2017.
 */

public class Student {
    private int id;
    private String name;
    private String classname;

    public Student(int m_id, String m_name, String m_classname){
        this.id = m_id;
        this.name = m_name;
        this.classname = m_classname;
    }

    @Override
    public String toString() {
        return id + ". " + name + " " + classname;
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
    public String getClassname() {
        return classname;
    }
    public void setClassname(String classname) {
        this.classname = classname;
    }

}
