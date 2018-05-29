package view;

import entity.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Manager;

class LoginFrame extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    Manager manager = new Manager();

    LoginFrame() {        
        loginButton.addActionListener(this);
        container.setLayout(null);
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);

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
            } else if (user.isFaculty()) {
            } else if (user.isStudent()) {
            }
        }

    }
}
