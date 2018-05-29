package view;

import entity.Faculty;
import javax.swing.*;

public class FacultyPage extends JFrame {

    Faculty faculty;

    FacultyPage(Faculty faculty) {
        this.faculty = faculty;
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Welcome");
        setSize(400, 200);
    }
}
