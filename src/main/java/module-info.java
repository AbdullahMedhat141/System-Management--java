module com.example.system_managment {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.system_management to javafx.fxml;
    exports com.example.system_management;
    exports com.example.system_management.controllers;
    opens com.example.system_management.controllers to javafx.fxml;
    opens com.example.system_management.models to javafx.base;
}