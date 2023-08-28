package com.example.system_management.controllers;

import com.example.system_management.Navigation;
import com.example.system_management.models.Course;
import com.example.system_management.models.DataModel;
import com.example.system_management.models.Student;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CoursesController implements Initializable {
    @FXML
    public TableView<Course> table;
    @FXML
    public AnchorPane rootPane;
    public TableColumn<Course, String> Name;
    public TableColumn<Course, String> Instructor;
    public TableColumn<Course, String> Book;
    public TableColumn<Course, String> Room;
    DataModel model = new DataModel();
    Navigation navigation = new Navigation();
    FileChooser fileChooser = new FileChooser();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //make sure the property value factory should be exactly same as the getStudentId from your model class
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Instructor.setCellValueFactory(new PropertyValueFactory<>("instructor"));
        Book.setCellValueFactory(new PropertyValueFactory<>("book"));
        Room.setCellValueFactory(new PropertyValueFactory<>("room"));

        table.setItems(FXCollections.observableArrayList(model.getCourses()));

    }
    public void add() {
        navigation.navigateTo(rootPane, navigation.ADD_COURSE_FXML);
    }
    public void back() {
        navigation.navigateTo(rootPane, navigation.Manager_FXML);
    }

    @FXML
    public void onClick(MouseEvent Event) {
        Course selected = table.getSelectionModel().getSelectedItem();
        Name.setCellFactory(TextFieldTableCell.<Course>forTableColumn());
        Name.setOnEditCommit(event -> {
            model.getCourseByName(selected.getName()).setName(event.getNewValue());
            model.save_Courses();
            System.out.println("Name was updates to: " + event.getNewValue());
        });
        Instructor.setCellFactory(TextFieldTableCell.<Course>forTableColumn());
        Instructor.setOnEditCommit(event -> {
            model.getCourseByName(selected.getName()).setInstructor(event.getNewValue());
            model.save_Courses();
            System.out.println("Instructor was updates to: " + event.getNewValue());
        });
        Book.setCellFactory(TextFieldTableCell.<Course>forTableColumn());
        Book.setOnEditCommit(event -> {
            model.getCourseByName(selected.getName()).setBook(event.getNewValue());
            model.save_Courses();
            System.out.println("Book was updates to: " + event.getNewValue());
        });
        Room.setCellFactory(TextFieldTableCell.<Course>forTableColumn());
        Room.setOnEditCommit(event -> {
            model.getCourseByName(selected.getName()).setRoom(event.getNewValue());
            model.save_Courses();
            System.out.println("Room was updates to: " + event.getNewValue());
        });
    }
    public void remove(ActionEvent event) throws IOException {
        Course selected = table.getSelectionModel().getSelectedItem();
        table.getItems().remove(selected);
        model.deleteCourseByName(selected.getName());
        model.save_Courses();
    }
    public void courseStudents(ActionEvent event) throws IOException{
        Course selected = table.getSelectionModel().getSelectedItem();
        if(model.getCourseByName(selected.getName()).getName().equals("Logic 2")) {
            navigation.navigateTo(rootPane, navigation.ADDCourseStudents_FXML);
        } else if (model.getCourseByName(selected.getName()).getName().equals("Java 2")) {
            navigation.navigateTo(rootPane, navigation.ADDCourse2Students_FXML);
        }
    }
    public void save2(MouseEvent event){
        File file = fileChooser.showSaveDialog(new Stage());
        if(file != null){
            saveCourses(file,  model.getCourses());
        }
    }
    public void saveCourses(File file, ArrayList<Course> courses){
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println("name, instructor, book, room");
            for (Course c : courses) {
                printWriter.println(c);
            }
            printWriter.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
