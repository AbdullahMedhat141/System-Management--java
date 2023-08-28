package com.example.system_management.controllers;

import com.example.system_management.Navigation;
import com.example.system_management.models.Course;
import com.example.system_management.models.DataModel;
import com.example.system_management.models.Student;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class AddCourseController implements Initializable {
    DataModel model = new DataModel();
    Navigation navigation = new Navigation();
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField name;
    @FXML
    private TextField instructor;
    @FXML
    private TextField book;
    @FXML
    private TextField room;
    @FXML
    private Label label;

    public void save() {
        model.addCourse(new Course(name.getText(), instructor.getText(), book.getText(), room.getText()));
        model.save_Courses();
        label.setText("Course is added _/");
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            label.setText("");
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }
    public void back(){
        navigation.navigateTo(rootPane, navigation.SHOW_COURSES_FXML);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

