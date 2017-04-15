package com.example.thongle.lab03_2.model;

/**
 * Created by thongle on 14/04/2017.
 */

public class Contact {
    private int id;
    private String name;
    private String phone_number;

    public Contact(int m_id, String m_name, String m_phone_number){
        this.id = m_id;
        this.name = m_name;
        this.phone_number = m_phone_number;
    }
    public Contact(String m_name, String m_phone_number) {
        this.name = m_name;
        this.phone_number = m_phone_number;
    }
    @Override
    public String toString() {
        return "id: " + id + ", " + "name: " + name + ", " + "phone: " + phone_number + ".";
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
    public String getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
