package view;

import entity.Faculty;
import entity.Student;
import entity.SuperAdmin;
import entity.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Manager;

class LoginFrame extends JFrame implements ActionListener {
    
    Container container = getContentPane();
    JLabel pageTitle = new JLabel("Login page");
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    Manager manager = new Manager();
    
    LoginFrame() {
        loginButton.addActionListener(this);
        container.setLayout(null);
        pageTitle.setBounds(75, 50, 150, 50);
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        
        container.add(pageTitle);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(loginButton);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String un = userTextField.getText();
        String pw = passwordField.getText();
        System.out.println("User Name : " + un);
        System.out.println("Password : " + pw);
        User user = manager.getUser(un, pw);
        if (user == null) {
            Errorpage errorPage = new Errorpage("No User found with the given credentials.");
            errorPage.setVisible(true);
            this.setVisible(false);
        } else {
            if (user.isSuperAdmin()) {                
                System.out.println("Logged in as super admin.");
                SuperAdminPage adminPage = new SuperAdminPage((SuperAdmin) user);
                adminPage.setVisible(true);
                this.setVisible(false);
            } else if (user.isFaculty()) {
                System.out.println("Logged in as faculty.");
                FacultyPage facultyPage = new FacultyPage((Faculty) user);
                facultyPage.setVisible(true);
                this.setVisible(false);
            } else if (user.isStudent()) {
                System.out.println("Logged in as student.");
                StudentPage studentPage = new StudentPage((Student) user);
                studentPage.setVisible(true);
                this.setVisible(false);
            }
        }
        
    }
}
