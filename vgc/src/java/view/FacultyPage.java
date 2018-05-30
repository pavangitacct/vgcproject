package view;

import entity.Faculty;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class FacultyPage extends JFrame implements ActionListener {

    Faculty faculty;
    Container container = getContentPane();

    FacultyPage(Faculty faculty) {
        this.faculty = faculty;
        this.setBounds(10, 10, 810, 510);
        container.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
