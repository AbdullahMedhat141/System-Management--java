package com.example.system_management.models;


import java.io.Serializable;

public class Date implements Serializable {
    private String date;

    public Date(String date){
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String toString(){
        return date;
    }

}
