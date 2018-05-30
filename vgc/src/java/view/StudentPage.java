package view;

import entity.Student;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class StudentPage extends JFrame implements ActionListener {

    Student student;
    Container container = getContentPane();

    StudentPage(Student student) {
        this.student = student;
        this.setBounds(10, 10, 810, 510);
        container.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
