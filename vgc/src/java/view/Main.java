package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String arg[]) {
        try {
            //LoginFrame frame = new LoginFrame();
            FeesManagementPage frame = new FeesManagementPage("calnedar management");
            frame.setTitle("VGC");
            frame.setVisible(true);
            frame.setBounds(10, 10, 810, 510);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
