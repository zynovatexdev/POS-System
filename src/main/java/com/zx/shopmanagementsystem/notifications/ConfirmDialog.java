/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.zx.shopmanagementsystem.notifications;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class ConfirmDialog extends javax.swing.JDialog {

    /**
     * Creates new form ConfirmDialog
     */
    private final JFrame fram;
    private MessageType messageType = MessageType.CANCEL;

    public ConfirmDialog(JFrame fram) {
        super(fram, true);
        this.fram = fram;
        initComponents();
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

        panelBorder1 = new com.raven.swing.PanelBorder();
        noBtnLbl = new javax.swing.JLabel();
        yesBtnLbl = new javax.swing.JLabel();
        titleLbl = new javax.swing.JLabel();
        messageLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        noBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\NoIcon.png")); // NOI18N
        noBtnLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        noBtnLbl.setPreferredSize(new java.awt.Dimension(50, 50));
        noBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                noBtnLblMouseClicked(evt);
            }
        });

        yesBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\YesIcon.png")); // NOI18N
        yesBtnLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        yesBtnLbl.setPreferredSize(new java.awt.Dimension(50, 50));
        yesBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                yesBtnLblMouseClicked(evt);
            }
        });

        titleLbl.setFont(new java.awt.Font("Poppins SemiBold", 1, 14)); // NOI18N
        titleLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        messageLbl.setFont(new java.awt.Font("Poppins SemiBold", 1, 12)); // NOI18N
        messageLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        messageLbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(yesBtnLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(noBtnLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBorder1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(messageLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addComponent(titleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(noBtnLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yesBtnLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                    .addContainerGap(41, Short.MAX_VALUE)
                    .addComponent(messageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(62, 62, 62)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public MessageType getMessageType() {
        return messageType;
    }
    private void yesBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yesBtnLblMouseClicked
        // TODO add your handling code here:
        messageType = MessageType.YES;
        ConfirmDialog.this.dispose();

    }//GEN-LAST:event_yesBtnLblMouseClicked

    private void noBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noBtnLblMouseClicked
        // TODO add your handling code here:
        messageType = MessageType.CANCEL;
        ConfirmDialog.this.dispose();
    }//GEN-LAST:event_noBtnLblMouseClicked

    /**
     * @param args the command line arguments
     */
    public static enum MessageType {
        CANCEL, YES
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel messageLbl;
    private javax.swing.JLabel noBtnLbl;
    private com.raven.swing.PanelBorder panelBorder1;
    private javax.swing.JLabel titleLbl;
    private javax.swing.JLabel yesBtnLbl;
    // End of variables declaration//GEN-END:variables

    public void showMessage(String title, String message) {
        titleLbl.setText(title);
        messageLbl.setText(message);
        setLocationRelativeTo(fram);
        setVisible(true);
    }
}
