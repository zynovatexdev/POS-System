/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zx.shopmanagementsystem.assests;

import com.zx.shopmanagementsystem.Test;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

/**
 *
 * @author User
 */
public class Func {

    IconLocation il = new IconLocation();

    public String codeValue;

    public void iconSetter(JLabel lable, String url) {
        lable.setIcon(new javax.swing.ImageIcon(url));
    }

    boolean isHide = true;

    public void mouseClicked(JLabel lable, JPasswordField password) {

        if (isHide) {
            mouseEnter(lable, password);
            isHide = false;
        } else {
            mouseExit(lable, password);
            isHide = true;
        }
    }

    private void mouseEnter(JLabel lable, JPasswordField password) {
        password.setEchoChar((char) 0);
        iconSetter(lable, il.showPassword);
    }

    private void mouseExit(JLabel lable, JPasswordField password) {
        password.setEchoChar('*');
        iconSetter(lable, il.hidePassword);
    }

    public void closeWindow(JFrame frame) {
        frame.dispose();
    }

    public void minimiseWindow(JFrame frame) {
        frame.setExtendedState(JFrame.ICONIFIED);
    }

    public int x;
    public int y;

    public void initMoving(JFrame frame, JLabel lable) {
        lable.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                frame.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }

    public void initMovingDialog(JDialog frame, JLabel lable) {
        lable.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                frame.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }

    public static boolean isValidMobileNumber(String number) {
        // Define the regular expression pattern for Sri Lankan mobile numbers
        String regex = "^(07)\\d{8}$"; // Sri Lankan mobile numbers start with 07 followed by 8 digits

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(number);

        // Check if the input matches the pattern
        return matcher.matches();
    }

    public void setForm(JComponent panal, JComponent component) {
        panal.removeAll();
        panal.add(component);
        panal.repaint();
        panal.revalidate();
    }

    String line;

    public void barcodeDetect() {

        try {
            String pythonScript = "C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\barcode_Python\\scanner.py";
            Process process = Runtime.getRuntime().exec("python " + pythonScript);

            // Read the output from the Python script
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = reader.readLine()) != null) {
                codeValue = line;
            }

            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getCode() {
        barcodeDetect();
        return codeValue;
    }

}
