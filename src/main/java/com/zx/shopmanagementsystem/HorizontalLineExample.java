package com.zx.shopmanagementsystem;

import javax.swing.*;
import java.awt.*;

public class HorizontalLineExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Horizontal Line Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);

            JPanel panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);

                    int y = getHeight() / 2; // Y-coordinate for the horizontal line
                    int x1 = 50; // Starting X-coordinate
                    int x2 = getWidth() - 50; // Ending X-coordinate

                    g.setColor(Color.BLACK); // Set the line color
                    g.drawLine(x1, y, x2, y); // Draw the horizontal line
                }
            };

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
