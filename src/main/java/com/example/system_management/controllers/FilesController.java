package com.example.system_management.controllers;

import com.example.system_management.Navigation;
import com.example.system_management.models.Course;
import com.example.system_management.models.DataModel;
import com.example.system_management.models.Student;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FilesController implements Initializable {
    @FXML
    public AnchorPane rootPane;
    Navigation navigation = new Navigation();
    DataModel model = new DataModel();
    public TextField studentId;
    public TableColumn<Student, String> nameCol = new TableColumn<>();
    public TableColumn<Student, Integer> idCol = new TableColumn<>();
    public TableColumn<Student, String> addressCol = new TableColumn<>();
    public TableView<Student> tableControl = new TableView<>();
    public Label label;
    public Label label2;
    FileChooser fileChooser = new FileChooser();

    public TableColumn<Student, String> name = new TableColumn<>();
    public TableColumn<Student, Integer> id = new TableColumn<>();
    public TableColumn<Student, String> address = new TableColumn<>();
    public TableView<Student> table = new TableView<>();

    public void back() {
        navigation.navigateTo(rootPane, navigation.Assistant_FXML);
    }
    public void backToCourses() {
        navigation.navigateTo(rootPane, navigation.SHOW_COURSES_FXML);
    }
    public void onAttendance() {
        navigation.navigateTo(rootPane, navigation.Attendance_FXML);
    }
    public void onAttendanceFiles() {
        navigation.navigateTo(rootPane, navigation.AttendanceFiles_FXML);
    }

    public void add() {
        try {
            if (model.getStudentById(Integer.parseInt(studentId.getText())) == null) {

                label.setText("Student isn't found!!");
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
                    label.setText("");
                }));
                timeline.setCycleCount(1);
                timeline.play();
            }
            else {
                model.addLogicStudent(new Student(model.getStudentById(Integer.parseInt(studentId.getText())).getName(),
                        model.getStudentById(Integer.parseInt(studentId.getText())).getId(),
                        model.getStudentById(Integer.parseInt(studentId.getText())).getAddress()));
                model.save_LogicStudents();
                label2.setText("Student is added _/");
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
                    label2.setText("");
                }));
                timeline.setCycleCount(1);
                timeline.play();
            }
        }
        catch (NullPointerException e) {
        }
    }
    public void remove(ActionEvent event) throws IOException {
        Student selected = tableControl.getSelectionModel().getSelectedItem();
        tableControl.getItems().remove(selected);
        model.deleteLogicStudentById(selected.getId());
        model.save_LogicStudents();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
       addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        tableControl.setItems(FXCollections.observableArrayList(model.getLogicStudents()));

        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        table.setItems(FXCollections.observableArrayList(model.getLogicStudents()));
    }

//    ******************************************************************************************************************
    public void save(MouseEvent event){
        File file = fileChooser.showSaveDialog(new Stage());
        if(file != null){
            saveStudents(file,  model.getLogicStudents());
        }
    }
    public void saveStudents(File file, ArrayList<Student> students){
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println("name, id, address");
            for (Student s : students) {
                printWriter.println(s);
            }
            printWriter.close();
        }
        catch (FileNotFoundException e){
        e.printStackTrace();
        }
    }

}
