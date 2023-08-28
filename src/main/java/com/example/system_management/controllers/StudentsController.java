package com.example.system_management.controllers;

import com.example.system_management.Navigation;
import com.example.system_management.models.DataModel;
import com.example.system_management.models.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentsController implements Initializable {
    @FXML
    public TableView<Student> table;
    @FXML
    public AnchorPane rootPane;
    public TableColumn<Student, String> Name;
    public TableColumn<Student, Integer> Id;
    public TableColumn<Student, String> Address;
    DataModel model = new DataModel();
    Navigation navigation = new Navigation();
    FileChooser fileChooser = new FileChooser();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //make sure the property value factory should be exactly same as the getStudentId from your model class
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Id.setCellValueFactory(new PropertyValueFactory<>("id"));
        Address.setCellValueFactory(new PropertyValueFactory<>("address"));

        table.setItems(FXCollections.observableArrayList(model.getStudents()));
        table.refresh();
    }
    public void add() {
        navigation.navigateTo(rootPane, navigation.ADD_STUDENT_FXML);
    }
    public void back() {
        navigation.navigateTo(rootPane, navigation.Manager_FXML);
    }

    @FXML
    public void onClick(MouseEvent Event) {
        Student selected = table.getSelectionModel().getSelectedItem();
        Name.setCellFactory(TextFieldTableCell.<Student>forTableColumn());
        Name.setOnEditCommit(event -> {
            model.getStudentById(selected.getId()).setName(event.getNewValue());
            model.save_Students();
            System.out.println("Name was updates to: " + event.getNewValue());
        });
        Address.setCellFactory(TextFieldTableCell.<Student>forTableColumn());
        Address.setOnEditCommit(event -> {
            model.getStudentById(selected.getId()).setAddress(event.getNewValue());
            model.save_Students();
            System.out.println("Address was updates to: " + event.getNewValue());
        });
    }
    public void remove(ActionEvent event) throws IOException {
        Student selected = table.getSelectionModel().getSelectedItem();
        table.getItems().remove(selected);
        model.deleteStudentById(selected.getId());
        model.save_Students();
    }
    public void save(MouseEvent event){
        File file = fileChooser.showSaveDialog(new Stage());
        if(file != null){
            saveStudents(file,  model.getStudents());
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