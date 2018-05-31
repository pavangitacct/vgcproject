package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Manager;

public class ExamsManagementPage extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel pageTitleLabel = null;

    JLabel studentIdLable = new JLabel("Student id :");
    JTextField studentIdField = new JTextField();

    JLabel testIdLabel = new JLabel("Test id :");
    JTextField testIdField = new JTextField();

    JLabel marksLable = new JLabel("Marks :");
    JTextField marksField = new JTextField();

    JButton updateResultButton = new JButton("Update Result");

    Manager manager = new Manager();

    ExamsManagementPage(String title) {
        this.setBounds(10, 10, 810, 510);
        container.setLayout(null);
        updateResultButton.addActionListener(this);

        pageTitleLabel = new JLabel(title);
        pageTitleLabel.setBounds(20, 10, 150, 50);

        testIdLabel.setBounds(75, 50, 450, 30);
        testIdField.setBounds(350, 50, 250, 30);

        studentIdLable.setBounds(75, 100, 450, 30);
        studentIdField.setBounds(350, 100, 250, 30);

        marksLable.setBounds(75, 150, 450, 30);
        marksField.setBounds(350, 150, 250, 30);

        updateResultButton.setBounds(75, 250, 450, 30);
        container.add(pageTitleLabel);
        container.add(testIdLabel);
        container.add(testIdField);
        container.add(studentIdLable);
        container.add(studentIdField);
        container.add(marksLable);
        container.add(marksField);
        container.add(updateResultButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Updating the results.
        if (e.getActionCommand().equals("Update Result")) {
            manager.createStudentResult(Long.parseLong(testIdField.getText()), Long.parseLong(studentIdField.getText()), Integer.parseInt(marksField.getText()));
            setVisible(false);
        }
    }

}
