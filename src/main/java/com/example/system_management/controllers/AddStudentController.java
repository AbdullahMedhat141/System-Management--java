package com.example.system_management.controllers;

import com.example.system_management.Navigation;
import com.example.system_management.models.DataModel;
import com.example.system_management.models.Student;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class AddStudentController implements Initializable {
    DataModel model = new DataModel();
    Navigation navigation = new Navigation();
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField name;
    @FXML
    private TextField id;
    @FXML
    private TextField address;
    @FXML
    private Label label;

    public void save() {
        try {
            int studentId = Integer.parseInt(id.getText());
            // Process the studentId
        } catch (NumberFormatException e) {
            // Handle the case where the input string is not a valid integer
            // Display an error message or take appropriate action
        }
        model.addStudent(new Student(name.getText(), Integer.parseInt(id.getText()),address.getText()));
        model.save_Students();
        label.setText("Student is added _/");
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            label.setText("");
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }
    public void back(){
        navigation.navigateTo(rootPane, navigation.SHOW_STUDENTS_FXML);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //set TextFiled to accept Numbers Only
        id.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && !newValue.matches("\\d*")) {
                id.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }
}
