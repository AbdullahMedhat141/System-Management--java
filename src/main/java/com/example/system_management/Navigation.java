package com.example.system_management;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.Objects;

public class Navigation {
    public final String MAIN_FXML = "views/hello-view.fxml";
    public final String ADD_STUDENT_FXML = "views/add-student.fxml";

    public final String SHOW_STUDENTS_FXML = "views/students.fxml";
    public final String ADD_COURSE_FXML = "views/add-course.fxml";
    public final String SHOW_COURSES_FXML = "views/courses.fxml";
    public final String Manager_FXML = "views/manager.fxml";
    public final String Assistant_FXML = "views/assistant.fxml";
    public final String Attendance_FXML = "views/attendance.fxml";
    public final String Attendance2_FXML = "views/attendance2.fxml";
    public final String Files_FXML = "views/files.fxml";
    public final String Files2_FXML = "views/files2.fxml";
    public final String AttendanceFiles_FXML = "views/attendance-files.fxml";
    public final String ALLAssistants_FXML = "views/all-assistants.fxml";
    public final String ADDAssistant_FXML = "views/add-assistant.fxml";
    public final String ADDCourseStudents_FXML = "views/add-course-students.fxml";
    public final String ADDCourse2Students_FXML = "views/add-course2-students.fxml";

    public void navigateTo(Parent rootPane, String path) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(path)));
            rootPane.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
