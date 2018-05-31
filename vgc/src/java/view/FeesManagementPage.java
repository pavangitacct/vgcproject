package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FeesManagementPage extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel pageTitleLabel = null;

    FeesManagementPage(String title) {
        this.setBounds(10, 10, 810, 510);
        container.setLayout(null);

        pageTitleLabel = new JLabel(title);
        pageTitleLabel.setBounds(20, 10, 150, 50);
        container.add(pageTitleLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
