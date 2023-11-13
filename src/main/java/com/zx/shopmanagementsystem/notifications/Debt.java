/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.zx.shopmanagementsystem.notifications;

import com.zx.shopmanagementsystem.assests.Func;
import com.zx.shopmanagementsystem.assests.IconLocation;
import com.zx.shopmanagementsystem.dbconnection.JDBC;
import java.awt.Color;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class Debt extends javax.swing.JDialog {

    /**
     * Creates new form ConfirmDialog
     */
    JDBC DB = new JDBC();
    private final JFrame fram;
    private MessageType messageType = MessageType.CANCEL;
    ArrayList<Integer> paymentMethodId = new ArrayList<>();

    Func func = new Func();
    IconLocation il = new IconLocation();

    public Debt(JFrame fram) {
        super(fram, true);
        this.fram = fram;
        initComponents();
        paymentMethodComboLoader();
        setBackground(new Color(255, 255, 255, 0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.zx.shopmanagementsystem.dateChooser.DateChooser();
        panelBorder1 = new com.raven.swing.PanelBorder();
        priceLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nextDateTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        paymentTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        yesLbl = new javax.swing.JLabel();
        noLbl = new javax.swing.JLabel();
        paymentMethodCombo = new com.zx.shopmanagementsystem.components.ComboBoxSuggestion();
        iconLbl = new javax.swing.JLabel();

        dateChooser1.setForeground(new java.awt.Color(153, 0, 255));
        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(nextDateTxt);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        priceLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        priceLbl.setForeground(new java.awt.Color(153, 0, 153));
        panelBorder1.add(priceLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 110, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\CalenderIcon.png")); // NOI18N
        panelBorder1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 86, 33, 33));

        nextDateTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        nextDateTxt.setHintText("Enter Date...");
        nextDateTxt.setPreferredSize(new java.awt.Dimension(129, 50));
        panelBorder1.add(nextDateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 250, -1));

        paymentTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        paymentTxt.setHintText("Enter Price...");
        paymentTxt.setPreferredSize(new java.awt.Dimension(129, 50));
        panelBorder1.add(paymentTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 250, -1));

        yesLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\PayNow.png")); // NOI18N
        yesLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                yesLblMouseClicked(evt);
            }
        });
        panelBorder1.add(yesLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 113, 40));

        noLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\NoIcon.png")); // NOI18N
        noLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                noLblMouseClicked(evt);
            }
        });
        panelBorder1.add(noLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 112, 40));

        paymentMethodCombo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        paymentMethodCombo.setPreferredSize(new java.awt.Dimension(163, 50));
        panelBorder1.add(paymentMethodCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 250, 50));

        iconLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\images\\PayScreen_1.png")); // NOI18N
        panelBorder1.add(iconLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void yesLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yesLblMouseClicked
        // TODO add your handling code here:
        messageType = MessageType.YES;
        Debt.this.dispose();
    }//GEN-LAST:event_yesLblMouseClicked

    private void noLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noLblMouseClicked
        // TODO add your handling code here:
        messageType = MessageType.CANCEL;
        Debt.this.dispose();
    }//GEN-LAST:event_noLblMouseClicked

    /**
     * @param args the command line arguments
     */
    public Debt.MessageType getMessageType() {
        return messageType;
    }

    public static enum MessageType {
        CANCEL, YES
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.zx.shopmanagementsystem.dateChooser.DateChooser dateChooser1;
    private javax.swing.JLabel iconLbl;
    private javax.swing.JLabel jLabel1;
    private com.zx.shopmanagementsystem.components.RoundedText nextDateTxt;
    private javax.swing.JLabel noLbl;
    private com.raven.swing.PanelBorder panelBorder1;
    private com.zx.shopmanagementsystem.components.ComboBoxSuggestion paymentMethodCombo;
    private com.zx.shopmanagementsystem.components.RoundedText paymentTxt;
    private javax.swing.JLabel priceLbl;
    private javax.swing.JLabel yesLbl;
    // End of variables declaration//GEN-END:variables

    public void showMessage(double totalPrice) {
        priceLbl.setText(String.valueOf(totalPrice));
        setVisible(true);

    }

    public String getPaymentValue() {
        return paymentTxt.getText();
    }

    public Integer getPaymentMethodId() {
        return paymentMethodId.get(paymentMethodCombo.getSelectedIndex());
    }

    private void paymentMethodComboLoader() {
        try {
            ResultSet rs = DB.getdata("SELECT * FROM payment_method");
            while (rs.next()) {
                String customerName = rs.getString("payment_method_type");
                int methodId = rs.getInt("payment_method_id");
                paymentMethodCombo.addItem(customerName);
                paymentMethodId.add(methodId);

            }
        } catch (Exception ex) {
            System.out.println("Product Type Combo Loader : " + ex);
        }
    }
}