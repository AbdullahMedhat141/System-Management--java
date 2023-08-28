package com.example.system_management.controllers;

import com.example.system_management.Navigation;
import com.example.system_management.models.Assistant;
import com.example.system_management.models.DataModel;
import com.example.system_management.models.Student;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class AddAssistantController {
    DataModel model = new DataModel();
    Navigation navigation = new Navigation();
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField name;
    @FXML
    private TextField course;
    @FXML
    private TextField password;
    @FXML
    private Label label;

    public void save(){
        model.addAssistant(new Assistant(name.getText(), course.getText(),password.getText()));
        model.save_Assistants();
        label.setText("Assistant is added _/");
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            label.setText("");
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }
    public void back(){
        navigation.navigateTo(rootPane, navigation.ALLAssistants_FXML);
    }
}
