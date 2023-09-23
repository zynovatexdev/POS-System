/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zx.shopmanagementsystem.assests;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

/**
 *
 * @author User
 */
public class Func {

    IconLocation il = new IconLocation();

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
}
