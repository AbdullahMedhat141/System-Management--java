package com.example.system_management.controllers;

import com.example.system_management.Navigation;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class ManagerController {
    @FXML
    public AnchorPane rootPane;
    Navigation navigation = new Navigation();
    public void onStudents() {
        navigation.navigateTo(rootPane, navigation.SHOW_STUDENTS_FXML);
    }
    public void onCourses() {
        navigation.navigateTo(rootPane, navigation.SHOW_COURSES_FXML);
    }
    public void onAssistants() {
        navigation.navigateTo(rootPane, navigation.ALLAssistants_FXML);
    }
    public void logOut(){
        navigation.navigateTo(rootPane, navigation.MAIN_FXML );
    }
}
