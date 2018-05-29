package view;

import entity.Student;
import javax.swing.*;

public class StudentPage extends JFrame {

    Student student;

    StudentPage(Student student) {
        this.student = student;
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Welcome");
        setSize(400, 200);
    }
}
