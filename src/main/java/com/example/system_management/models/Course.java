package com.example.system_management.models;

import java.io.Serializable;

public class Course implements Serializable {
    private String name;
    private String instructor;
    private String book;
    private String room;
    public Course(){

    }

    public Course(String name, String instructor, String book, String room){
        this.name=name;
        this.instructor=instructor;
        this.book=book;
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
    public String toString(){
        return name+","+instructor+","+book+","+room;
    }
}

