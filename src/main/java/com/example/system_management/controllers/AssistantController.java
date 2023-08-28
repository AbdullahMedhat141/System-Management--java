package com.example.system_management.controllers;

import com.example.system_management.Navigation;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class AssistantController{
    @FXML
    public AnchorPane rootPane;
    Navigation navigation = new Navigation();
    public void onFiles() {
        navigation.navigateTo(rootPane, navigation.Files_FXML);
    }
    public void onFiles2() {
        navigation.navigateTo(rootPane, navigation.Files2_FXML);
    }
    public void logOut(){
        navigation.navigateTo(rootPane, navigation.MAIN_FXML );
    }

}
