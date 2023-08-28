package com.example.system_management.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class DataModel {
    private static ArrayList<Student> students = null;
    private static ArrayList<Course> courses = null;
    private static ArrayList<Student> attendance = null;
    private static ArrayList<Date> dates = null;
    private static ArrayList<Assistant> assistants = null;
    private static ArrayList<Student> logicStudents = null;
    private static ArrayList<Student> JavaStudents = null;


    public DataModel() {
        initialize();
        initialize2();
        initialize4();
        initialize5();
        initialize6();
        initialize7();
    }
    public DataModel(String s){
        initialize3(s);
    }


    //    ******************************************************************************************************************
    public static void initialize7() {
        if (JavaStudents == null) {
            File file = new File("javaStudents.csv");
            if (file.exists()) {
                try (Scanner scanner = new Scanner(file)) {
                    //read header line
                    String s = scanner.nextLine();
                    JavaStudents = new ArrayList<>();
                    while (scanner.hasNext()) {
                        s = scanner.nextLine();
                        String[] strings = s.split(",");
                        JavaStudents.add(new Student(strings[0], Integer.parseInt(strings[1]), strings[2]));
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                JavaStudents = new ArrayList<>();
                // add Test data when you run the program for the first time
                JavaStudents.add(new Student("Student 1", 120210622,"AlJalaa"));
                JavaStudents.add(new Student("Student 2", 120210623,"AlRemal"));
            }
        }
    }
    public void save_JavaStudents() {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("javaStudents.csv"))) {
            pw.println("name, id, address");
            for (Student s : JavaStudents) {
                pw.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addJavaStudent(Student student) {

        JavaStudents.add(student);
    }

    public Student getJavaStudentById(int id) {
        for (Student student : JavaStudents) {
            if (Objects.equals(student.getId(), id)) {
                return student;
            }
        }
        return null;
    }

    public ArrayList<Student> getJavaStudents() {

        return JavaStudents;
    }
    public void deleteJavaStudentById(int id) {
        for (Student student : JavaStudents) {
            if (Objects.equals(student.getId(), id)) {
                JavaStudents.remove(student);
                return;
            }
        }
    }


    //    ******************************************************************************************************************
    public static void initialize6() {
        if (logicStudents == null) {
            File file = new File("logicStudents.csv");
            if (file.exists()) {
                try (Scanner scanner = new Scanner(file)) {
                    //read header line
                    String s = scanner.nextLine();
                    logicStudents = new ArrayList<>();
                    while (scanner.hasNext()) {
                        s = scanner.nextLine();
                        String[] strings = s.split(",");
                        logicStudents.add(new Student(strings[0], Integer.parseInt(strings[1]), strings[2]));
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                logicStudents = new ArrayList<>();
                // add Test data when you run the program for the first time
                logicStudents.add(new Student("Student 1", 120210622,"AlJalaa"));
                logicStudents.add(new Student("Student 2", 120210623,"AlRemal"));
            }
        }
    }
    public void save_LogicStudents() {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("logicStudents.csv"))) {
            pw.println("name, id, address");
            for (Student s : logicStudents) {
                pw.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addLogicStudent(Student student) {

        logicStudents.add(student);
    }

    public Student getLogicStudentById(int id) {
        for (Student student : logicStudents) {
            if (Objects.equals(student.getId(), id)) {
                return student;
            }
        }
        return null;
    }

    public ArrayList<Student> getLogicStudents() {

        return logicStudents;
    }
    public void deleteLogicStudentById(int id) {
        for (Student student : logicStudents) {
            if (Objects.equals(student.getId(), id)) {
                logicStudents.remove(student);
                return;
            }
        }
    }


    //    ******************************************************************************************************************
    public static void initialize5() {
        if (assistants == null) {
            File file = new File("assistants.csv");
            if (file.exists()) {
                try (Scanner scanner = new Scanner(file)) {
                    //read header line
                    String s = scanner.nextLine();
                    assistants = new ArrayList<>();
                    while (scanner.hasNext()) {
                        s = scanner.nextLine();
                        String[] strings = s.split(",");
                        assistants.add(new Assistant(strings[0], strings[1], strings[2]));
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                assistants = new ArrayList<>();
                // add Test data when you run the program for the first time
                assistants.add(new Assistant("Ahmed", "logic 2","5548$$23"));
                assistants.add(new Assistant("Omar", "java 2","5548$$44"));
            }
        }
    }
    public void save_Assistants() {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("assistants.csv"))) {
            pw.println("name, course, password");
            for (Assistant a : assistants) {
                pw.println(a);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addAssistant(Assistant assistant) {

        assistants.add(assistant);
    }

    public Assistant getAssistantByName(String name) {
        for (Assistant assistant : assistants) {
            if (Objects.equals(assistant.getName(), name)) {
                return assistant;
            }
        }
        return null;
    }

    public ArrayList<Assistant> getAssistants() {

        return assistants;
    }
    public void deleteAssistantByName(String name) {
        for (Assistant assistant : assistants) {
            if (Objects.equals(assistant.getName(), name)) {
                assistants.remove(assistant);
                return;
            }
        }
    }

    //    ******************************************************************************************************************
    public static void initialize4() {
        if (dates == null) {
            File file = new File("dates.csv");
            if (file.exists()) {
                try (Scanner scanner = new Scanner(file)) {
                    //read header line
                    String s = scanner.nextLine();
                    dates = new ArrayList<>();
                    while (scanner.hasNext()) {
                        s = scanner.nextLine();
                        String[] strings = s.split(",");
                        dates.add(new Date(strings[0]));
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                dates = new ArrayList<>();
                dates.add(new Date("25-5-2023"));
                dates.add(new Date("26-5-2023"));
            }
        }
    }
    public ArrayList<Date> getAllDates() {
        return dates;
    }
    public void addDate(Date d) {
        dates.add(d);
    }
    public void save_Dates() {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("dates.csv"))) {
            pw.println("date");
            for (Date d : dates) {
                pw.println(d);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void deleteDateByName(String string) {
        for (Date date : dates) {
            if (Objects.equals(date.getDate(), date)) {
                dates.remove(date);
                return;
            }
        }
    }

    //    ******************************************************************************************************************
    public static void initialize3(String string) {
        if (attendance == null) {
            File file = new File(string);
            if (file.exists()) {
                try (Scanner scanner = new Scanner(file)) {
                    //read header line
                    String s = scanner.nextLine();
                    attendance = new ArrayList<>();
                    while (scanner.hasNext()) {
                        s = scanner.nextLine();
                        String[] strings = s.split(",");
                        attendance.add(new Student(strings[0], Integer.parseInt(strings[1]), strings[2]));
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else {
                attendance = new ArrayList<>();
                // add Test data when you run the program for the first time
                attendance.add(new Student("Student 1", 120210622,"AlJalaa"));
                attendance.add(new Student("Student 2", 120210623,"AlRemal"));
                attendance.add(new Student("Student 3", 120210624,"AlShekh-Redwan"));
                attendance.add(new Student("Student 4", 120210625,"Tal-ElHawa"));
            }
        }
    }
    public void save_allStudents(String string) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(string))) {
            pw.println("name, id, address");
            for (Student s : attendance) {
                pw.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void addOneStudent(Student student) {

        attendance.add(student);
    }
    public Student getOneStudentById(int id) {
        for (Student student : attendance) {
            if (Objects.equals(student.getId(), id)) {
                return student;
            }
        }
        return null;
    }

    public ArrayList<Student> getAllStudents() {

        return attendance;
    }
    public void deleteOneStudentById(int id) {
        for (Student student : attendance) {
            if (Objects.equals(student.getId(), id)) {
                attendance.remove(student);
                return;
            }
        }
    }

//    ******************************************************************************************************************

    public static void initialize() {
        if (students == null) {
            File file = new File("students.csv");
            if (file.exists()) {
                try (Scanner scanner = new Scanner(file)) {
                    //read header line
                    String s = scanner.nextLine();
                    students = new ArrayList<>();
                    while (scanner.hasNext()) {
                        s = scanner.nextLine();
                        String[] strings = s.split(",");
                        students.add(new Student(strings[0], Integer.parseInt(strings[1]), strings[2]));
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                students = new ArrayList<>();
                // add Test data when you run the program for the first time
                students.add(new Student("Student 1", 120210622,"AlJalaa"));
                students.add(new Student("Student 2", 120210623,"AlRemal"));
                students.add(new Student("Student 3", 120210624,"AlShekh-Redwan"));
                students.add(new Student("Student 4", 120210625,"Tal-ElHawa"));
            }
        }
    }
    public void save_Students() {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("students.csv"))) {
            pw.println("name, id, address");
            for (Student s : students) {
                pw.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(Student student) {

        students.add(student);
    }

    public Student getStudentByName(String name) {
        for (Student student : students) {
            if (Objects.equals(student.getName(), name)) {
                return student;
            }
        }
        return null;
    }
    public Student getStudentById(int id) {
        for (Student student : students) {
            if (Objects.equals(student.getId(), id)) {
                return student;
            }
        }
        return null;
    }

    public ArrayList<Student> getStudents() {

        return students;
    }
    public Student deleteStudentByName(String name) {
        for (Student student : students) {
            if (Objects.equals(student.getName(), name)) {
                students.remove(student);
                return student;
            }
        }
        return null;
    }
    public void deleteStudentById(int id) {
        for (Student student : students) {
            if (Objects.equals(student.getId(), id)) {
                students.remove(student);
                return;
            }
        }
    }
//**********************************************************************************************************************
    public static void initialize2(){
        if (courses == null) {
            File file = new File("courses.csv");
            if (file.exists()) {
                try (Scanner scanner = new Scanner(file)) {
                    //read header line
                    String s = scanner.nextLine();
                    courses = new ArrayList<>();
                    while (scanner.hasNext()) {
                        s = scanner.nextLine();
                        String[] strings = s.split(",");
                        courses.add(new Course(strings[0], strings[1], strings[2],strings[3]));
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                courses = new ArrayList<>();
                // add Test data when you run the program for the first time
                courses.add(new Course("Course 1", "Wesam","Roth", "K512"));
                courses.add(new Course("Course 2", "Ayman","Java", "K417"));
                courses.add(new Course("Course 3", "Ashraf","Math", "K202"));
                courses.add(new Course("Course 4", "Jawdat","Electronics", "K216"));
            }
        }
    }
    public void save_Courses() {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("courses.csv"))) {
            pw.println("name, instructor, book, room");
            for (Course c : courses) {
                pw.println(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void addCourse(Course course) {courses.add(course);
    }
    public Course getCourseByName(String name) {
        for (Course course : courses) {
            if (Objects.equals(course.getName(), name)) {
                return course;
            }
        }
        return null;
    }
    public ArrayList<Course> getCourses() {
        return courses;
    }
    public void deleteCourseByName(String name) {
        for (Course course : courses) {
            if (Objects.equals(course.getName(), name)) {
                courses.remove(course);
                return;
            }
        }
    }

}

