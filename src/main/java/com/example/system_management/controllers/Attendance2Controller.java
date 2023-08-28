package com.example.system_management.controllers;

import com.example.system_management.Navigation;
import com.example.system_management.models.DataModel;
import com.example.system_management.models.Date;
import com.example.system_management.models.Student;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Attendance2Controller implements Initializable {

    @FXML
    DataModel model = new DataModel();
    LocalDate myDate = LocalDate.now();
    @FXML
    private DatePicker datePicker = new DatePicker(myDate);
    String s = datePicker.getValue()+".csv";
    String string = datePicker.getValue()+"";
    DataModel model2 = new DataModel(s);
    Navigation navigation = new Navigation();
    @FXML
    public TableView<Student> table = new TableView<>();
    @FXML
    public AnchorPane rootPane;
    public TableColumn<Student, String> nameCol = new TableColumn<>();
    public TableColumn<Student, Integer> idCol = new TableColumn<>();

    public TableColumn<Date, String> datesCol = new TableColumn<>();
    public TableView<Date> datesTable = new TableView<>();
    public TextField studentId;
    public Label label;
    public Label label2;
    public Label label3;
    FileChooser fileChooser = new FileChooser();

    public void back() {
        navigation.navigateTo(rootPane, navigation.Assistant_FXML);
    }

    public void creat(){
        model.addDate(new Date(string));
        model.save_Dates();
        label3.setText("File is created");
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            label3.setText("");
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }
    public void add() {
        try {
            if (model.getJavaStudentById(Integer.parseInt(studentId.getText())) == null) {

                label.setText("Student isn't found!!");
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
                    label.setText("");
                }));
                timeline.setCycleCount(1);
                timeline.play();
            }
            else {
                model2.addOneStudent(new Student(model.getStudentById(Integer.parseInt(studentId.getText())).getName(),
                        model.getStudentById(Integer.parseInt(studentId.getText())).getId(),
                        model.getStudentById(Integer.parseInt(studentId.getText())).getAddress()));
                model2.save_allStudents(s);
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        table.setItems(FXCollections.observableArrayList(model.getAllStudents()));

        datesCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        datesTable.setItems(FXCollections.observableArrayList(model.getAllDates()));
    }

    public void save2(MouseEvent event){
        File file = fileChooser.showSaveDialog(new Stage());
        if(file != null){
            copyFile(file,  model2.getAllStudents());
        }
    }
    public void copyFile(File file, ArrayList<Student> attendance){
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println("name, id, address");
            for (Student s : attendance) {
                printWriter.println(s);
            }
            printWriter.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void remove(ActionEvent event) throws IOException {
        Student selected = table.getSelectionModel().getSelectedItem();
        table.getItems().remove(selected);
        model.deleteOneStudentById(selected.getId());
        model.save_allStudents(s);
    }
}
