package mianban;

import javax.swing.*;

public class frame {

    public frame() {

        JFrame frame = new JFrame("mianban");
        frame.setContentPane(new mianban().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void error_frame(String error) {
        JOptionPane.showMessageDialog(null, error, "error", JOptionPane.ERROR_MESSAGE);
    }

    public static void success_frame(String success) {
        JOptionPane.showMessageDialog(null, success, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
