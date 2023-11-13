/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.zx.shopmanagementsystem.forms;

import com.zx.shopmanagementsystem.assests.Func;
import com.zx.shopmanagementsystem.assests.IconLocation;
import com.zx.shopmanagementsystem.notifications.ConfirmDialog;
import com.zx.shopmanagementsystem.notifications.MessageDialog;
import com.zx.shopmanagementsystem.ui.DashboardAdmin;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.json.JSONObject;

/**
 *
 * @author User
 */
public class Settings extends javax.swing.JPanel {

    /**
     * Creates new form Home
     */
    IconLocation il = new IconLocation();
    Func func = new Func();

    public Settings() {
        initComponents();
        jsonRead();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lowStockCombo = new com.zx.shopmanagementsystem.components.ComboBoxSuggestion();
        backUpTimeCombo = new com.zx.shopmanagementsystem.components.ComboBoxSuggestion();
        settingBtnLbl = new javax.swing.JLabel();
        iconLbl = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1015, 738));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Minute");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, 100, 20));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Items");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 100, 20));

        lowStockCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "50", "100", "150", "200" }));
        lowStockCombo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lowStockCombo.setPreferredSize(new java.awt.Dimension(163, 50));
        add(lowStockCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 250, 50));

        backUpTimeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5", "10", "15", "20", "25", "30" }));
        backUpTimeCombo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        backUpTimeCombo.setPreferredSize(new java.awt.Dimension(163, 50));
        add(backUpTimeCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 250, 50));

        settingBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\SavePurpleIcon.png")); // NOI18N
        settingBtnLbl.setText("jLabel3");
        settingBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingBtnLblMouseExited(evt);
            }
        });
        add(settingBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 630, 245, 50));

        iconLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\images\\Settings.png")); // NOI18N
        add(iconLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void settingBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(settingBtnLbl, il.SaveWhiteIcon);
    }//GEN-LAST:event_settingBtnLblMouseEntered

    private void settingBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(settingBtnLbl, il.SavePurpleIcon);
    }//GEN-LAST:event_settingBtnLblMouseExited

    private void settingBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingBtnLblMouseClicked
        // TODO add your handling code here:
        save();
    }//GEN-LAST:event_settingBtnLblMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.zx.shopmanagementsystem.components.ComboBoxSuggestion backUpTimeCombo;
    private javax.swing.JLabel iconLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private com.zx.shopmanagementsystem.components.ComboBoxSuggestion lowStockCombo;
    private javax.swing.JLabel settingBtnLbl;
    // End of variables declaration//GEN-END:variables

    private void save() {
        // Create a JSON object
        JSONObject jsonObject = new JSONObject();

        // Add strings to the JSON object
        jsonObject.put("LowStockAlert", lowStockCombo.getSelectedItem());
        jsonObject.put("BackupTime", backUpTimeCombo.getSelectedItem());
        // Convert JSON object to Properties
        Properties properties = new Properties();
        jsonObject.toMap().forEach((key, value) -> properties.setProperty(key.toString(), value.toString()));

        // Save Properties to a file
        try (FileOutputStream fileOutputStream = new FileOutputStream("Settings.properties")) {
            properties.store(fileOutputStream, "Settings");
            System.out.println("Properties saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void jsonRead() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("Settings.properties")) {
            properties.load(fileInputStream);
            System.out.println("Settings loaded successfully.");

            // Access individual properties
            lowStockCombo.setSelectedItem(properties.getProperty("LowStockAlert"));
            backUpTimeCombo.setSelectedItem(properties.getProperty("BackupTime"));
        } catch (Exception en) {
            System.err.println("Settings jsonRead : " + en);
        }
    }

}