package com.zx.shopmanagementsystem.assests;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSpinnerUI;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CustomSpinnerUI extends BasicSpinnerUI {

    @Override
    protected Component createPreviousButton() {
        JButton button = (JButton) super.createPreviousButton();
        customizeButton(button);
        return button;
    }

    @Override
    protected Component createNextButton() {
        JButton button = (JButton) super.createNextButton();
        customizeButton(button);
        return button;
    }

    private void customizeButton(JButton button) {
        button.setPreferredSize(new Dimension(20, 20)); // Set preferred size as needed
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setBackground(Color.WHITE); // Set background color
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Custom Spinner UI Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JSpinner spinner = new JSpinner();
            spinner.setUI(new CustomSpinnerUI());

            frame.getContentPane().add(spinner);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
