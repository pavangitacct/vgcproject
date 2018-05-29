package view;

import javax.swing.*;

public class Errorpage extends JFrame {
String errorMessage;
    Errorpage(String errorMessage) {
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("VGC - ErrorPage");
        setSize(400, 200);
    }
}
