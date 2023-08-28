# System Management

System Management is a program designed to assist system managers in managing student information and course-related tasks. With this program, system managers can add, delete, and edit students in the system, as well as add courses and assistants. The program also enables assistants to take attendance of students and download files containing student information.

## Installation

To use the System Management program, Install the following libraries using Maven::

    - org.apiguardian:apiguardian-api:1.1.22
    - org.junit.jupiter:junit-jupiter-api:5.9.12
    - org.junit.jupiter:junit-jupiter-engine:5.9.12
    - org.junit.platform:junit-platform-commons:1.9.12
    - org.junit.platform:junit-platform-engine:1.9.12
    - org.openjfx:javafx-base:192
    - org.openjfx:javafx-base:win:192
    - org.openjfx:javafx-controls:192
    - org.openjfx:javafx-controls:win:192
    - org.openjfx:javafx-fxml:192
    - org.openjfx:javafx-fxml:win:192
    - org.openjfx:javafx-graphics:192
    - org.openjfx:javafx-graphics:win:192
    - org.opentest4j:opentest4j:1.2.02

## Usage

1. Launch the System Management program.
2. On the login page, you have two options:

    - Manager login: Use the following credentials:
        - Username: Admin
        - Password: 700

    - Assistant login: Use the assistant-specific password set by the manager. For example, if the assistant for the logic course is Ahmed, use the password assigned by the manager(Ahmed, 500).

![](/imgs/login.png)




3. After logging in as a manager, you will have access to the following functionalities:

    - Students: Add, edit, or remove students. Download student files.
    - Courses: Add, edit, or remove courses. Download course files.
    - Assistants: Add, edit, or remove assistants. Link an assistant to a specific course.

![](/imgs/Manager.png)


   Adding: Click on the Add button, enter the information then click Save.

   Editing: DoubleClick in the cell you want to edit, enter the new value then click the Enter key .

   Deleting: Select the row you want to delete then click the Remove button.

   Downloading: Click on the Download button then choose where to download in your computer  .



![](/imgs/Courses management.png)

   To add student to a course, click on the course then click on Students button after that enter the student id then click Add.

![](/imgs/add student to a course.png)


4. When an assistant logs in, they will have access to the following functionalities:

    - Students: View and manage the attendance of students enrolled in the course they teach. Download attendance files and student files.
    - Students of other courses: In case the assigned assistant is absent, access and manage the students of another course.

![](/imgs/Assistant.png)

   To take attendance click on Take Attendance then enter the student id the click ob Add.
   
![](/imgs/Students(course).png)

   To download the attendance file click on Attendance files, click on the file then choose where to download in your computer.

   To delete a file select it then click on the Delete button.
   
![](/imgs/Attendance files.png)
## Contact

If you have any questions or need further assistance, please feel free to contact us at aboodmabusharekh1412004@gmail.com.
