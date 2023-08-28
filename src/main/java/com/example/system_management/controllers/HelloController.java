package com.example.system_management.controllers;

import com.example.system_management.Navigation;
import com.example.system_management.models.DataModel;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class HelloController {
    @FXML
    public AnchorPane rootPane;
    public Label wrongLogIn;
    Navigation navigation = new Navigation();
    DataModel model = new DataModel();

    public TextField name;
    public TextField password;

    public void logIn() {
    if(name.getText().equals("Admin") && password.getText().equals("700")){
        navigation.navigateTo(rootPane, navigation.Manager_FXML);
    } else if (model.getAssistantByName(name.getText()) != null) {
        if (model.getAssistantByName(name.getText()).getPassword().equals(password.getText()) )
        {
            navigation.navigateTo(rootPane, navigation.Assistant_FXML);
        }
        else {
            wrongLogIn.setText("Password is Wrong!!");
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
                wrongLogIn.setText("");
            }));
            timeline.setCycleCount(1);
            timeline.play();
        }
    }
    else {
        wrongLogIn.setText("Account isn't found!!");
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            wrongLogIn.setText("");
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }
    }
}