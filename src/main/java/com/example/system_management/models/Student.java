package com.example.system_management.models;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int id;
    private String address;

    public Student(){

    }
    public Student(String name,int id,String address){
        this.name = name;
        this.id = id;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String toString(){

        return name+","+id+","+address;
    }
}
