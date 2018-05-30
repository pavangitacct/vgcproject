package view;

import entity.SuperAdmin;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class SuperAdminPage extends JFrame implements ActionListener {
SuperAdmin admin;
    Container container = getContentPane();

    SuperAdminPage(SuperAdmin admin) {
        this.admin = admin;
        this.setBounds(10, 10, 810, 510);
        container.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
