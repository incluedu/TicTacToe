package net.lustenauer.tictactoe.util;

import javax.swing.*;

public class ShowInFrame {

    public static void show(String title, JComponent component) {
        JFrame frame = new JFrame(title);

        frame.add(component);
        frame.pack();
        frame.setVisible(true);
    }

    public static void show(JComponent component) {
        show("", component);
    }
}
