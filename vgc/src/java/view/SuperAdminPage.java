package view;

import entity.SuperAdmin;
import javax.swing.*;

public class SuperAdminPage extends JFrame {

    SuperAdmin superAdmin;

    SuperAdminPage(SuperAdmin superAdmin) {
        this.superAdmin = superAdmin;
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Welcome");
        setSize(400, 200);
    }
}
