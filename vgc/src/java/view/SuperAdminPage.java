package view;

import entity.SuperAdmin;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SuperAdminPage extends JFrame implements ActionListener {

    SuperAdmin admin;
    Container container = getContentPane();

    JLabel pageTitleLabel = new JLabel("Super Admin Home page");

    JButton facultyRegistrationButton = new JButton("Faculty Registration");
    JButton superAdminRegistrationButton = new JButton("SuperAdmin Registration");
    JButton academicCalenderManagementButton = new JButton("Academic Calender Management");
    JButton examsManagementButton = new JButton("Exams Management");
    JButton networkManagementButton = new JButton("Network Management");
    JButton feesManagementButton = new JButton("Fees Management");

    SuperAdminPage(SuperAdmin admin) {
        this.admin = admin;
        container.setLayout(null);
        this.setBounds(10, 10, 810, 510);
        pageTitleLabel.setBounds(20, 10, 150, 50);

        facultyRegistrationButton.setBounds(75, 50, 250, 30);
        superAdminRegistrationButton.setBounds(350, 50, 250, 30);

        academicCalenderManagementButton.setBounds(75, 100, 250, 30);
        examsManagementButton.setBounds(75, 150, 250, 30);
        networkManagementButton.setBounds(75, 200, 250, 30);
        feesManagementButton.setBounds(75, 250, 250, 30);

        container.add(pageTitleLabel);
        container.add(facultyRegistrationButton);
        container.add(superAdminRegistrationButton);
        container.add(academicCalenderManagementButton);
        container.add(examsManagementButton);
        container.add(networkManagementButton);
        container.add(feesManagementButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Register faculty and other superadmin users.
        // 1.Manage Academic Calendar (Exam dates, assignment dates)
        //2.Manage Exams, Assignments and Results.
        //4.Manage Network – Adding more branches.
        //7.Management of fees paid
    }

}
