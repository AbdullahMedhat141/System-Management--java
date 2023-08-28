package com.example.system_management.models;

import java.io.Serializable;

public class Assistant implements Serializable {
    private String name;
    private String course;
    private String password;

    public Assistant(){
    }
    public Assistant(String name, String course, String password){
        this.name = name;
        this.course = course;
        this.password =password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String toString(){

        return name+","+course+","+password;
    }
}
