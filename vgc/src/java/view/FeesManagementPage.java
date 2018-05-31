package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Manager;

public class FeesManagementPage extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel pageTitleLabel = null;

    JLabel feesPurposeLabel = new JLabel("Fees purpose :");
    JTextField feesPurposeField = new JTextField();

    JLabel studentIdLabel = new JLabel("Student id :");
    JTextField studentIdField = new JTextField();

    JLabel amountLabel = new JLabel("Amount :");
    JTextField amoutField = new JTextField();

    JLabel paidDateLabel = new JLabel("Paid Date :");
    JTextField paidDateField = new JTextField();

    JButton updateResultButton = new JButton("Update Fees");

    Manager manager = new Manager();

    FeesManagementPage(String title) {
        this.setBounds(10, 10, 810, 510);
        container.setLayout(null);
        updateResultButton.addActionListener(this);

        pageTitleLabel = new JLabel(title);
        pageTitleLabel.setBounds(20, 10, 150, 50);

        feesPurposeLabel.setBounds(75, 50, 450, 30);
        feesPurposeField.setBounds(350, 50, 250, 30);

        studentIdLabel.setBounds(75, 100, 450, 30);
        studentIdField.setBounds(350, 100, 250, 30);

        amountLabel.setBounds(75, 150, 450, 30);
        amoutField.setBounds(350, 150, 250, 30);

        paidDateLabel.setBounds(75, 200, 450, 30);
        paidDateField.setBounds(350, 200, 250, 30);

        updateResultButton.setBounds(75, 300, 450, 30);
        container.add(pageTitleLabel);
        container.add(feesPurposeLabel);
        container.add(feesPurposeField);
        container.add(studentIdLabel);
        container.add(studentIdField);
        container.add(amountLabel);
        container.add(amoutField);
        container.add(paidDateLabel);
        container.add(paidDateField);
        container.add(updateResultButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Updating the results.
        if (e.getActionCommand().equals("Update Fees")) {
            manager.createFee(feesPurposeField.getText(), Long.parseLong(studentIdField.getText()),
               Integer.parseInt(amoutField.getText()), paidDateField.getText());
            setVisible(false);
        }
    }

}
