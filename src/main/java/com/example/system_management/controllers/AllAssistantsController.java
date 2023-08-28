package com.example.system_management.controllers;

import com.example.system_management.Navigation;
import com.example.system_management.models.Assistant;
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

public class AllAssistantsController implements Initializable {
    @FXML
    public AnchorPane rootPane;
    DataModel model = new DataModel();
    Navigation navigation = new Navigation();

    @FXML
    public TableView<Assistant> table;
    public TableColumn<Assistant, String> Name;

    public TableColumn<Assistant, String> Course;
    public TableColumn<Assistant, String> Password;
    FileChooser fileChooser = new FileChooser();


    public void back() {
        navigation.navigateTo(rootPane, navigation.Manager_FXML);
    }

    public void add() {
        navigation.navigateTo(rootPane, navigation.ADDAssistant_FXML);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Course.setCellValueFactory(new PropertyValueFactory<>("course"));
        Password.setCellValueFactory(new PropertyValueFactory<>("password"));

        table.setItems(FXCollections.observableArrayList(model.getAssistants()));

    }
    @FXML
    public void onClick(MouseEvent Event) {
        Assistant selected = table.getSelectionModel().getSelectedItem();
        Name.setCellFactory(TextFieldTableCell.<Assistant>forTableColumn());
        Name.setOnEditCommit(event -> {
            model.getAssistantByName(selected.getName()).setName(event.getNewValue());
            model.save_Assistants();
            System.out.println("Name was updates to: " + event.getNewValue());
        });
        Course.setCellFactory(TextFieldTableCell.<Assistant>forTableColumn());
        Course.setOnEditCommit(event -> {
            model.getAssistantByName(selected.getName()).setCourse(event.getNewValue());
            model.save_Students();
            System.out.println("Course was updates to: " + event.getNewValue());
        });
    }
    public void remove(ActionEvent event) throws IOException {
       Assistant selected = table.getSelectionModel().getSelectedItem();
        table.getItems().remove(selected);
        model.deleteAssistantByName(selected.getName());
        model.save_Assistants();
    }
    public void save(MouseEvent event){
        File file = fileChooser.showSaveDialog(new Stage());
        if(file != null){
            saveAssistants(file,  model.getAssistants());
        }
    }
    public void saveAssistants(File file, ArrayList<Assistant> assistant){
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println("name, course, password");
            for (Assistant a : assistant) {
                printWriter.println(a);
            }
            printWriter.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
