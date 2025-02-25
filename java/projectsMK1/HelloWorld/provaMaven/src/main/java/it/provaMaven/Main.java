package it.provaMaven;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        FlatLightLaf.setup();

        final JPanel panel = new JPanel(); //FlowLayout.
        panel.add(new JButton("FlatDarkLaf button!"));
        panel.add(new JTextField("FlatDarkLaf text field!"));

        final JFrame frame = new JFrame("FlatDarkLaf test.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}