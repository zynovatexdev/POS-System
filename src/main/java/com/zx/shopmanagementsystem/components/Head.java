/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.zx.shopmanagementsystem.components;

import com.zx.shopmanagementsystem.assests.Func;
import com.zx.shopmanagementsystem.assests.IconLocation;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class Head extends javax.swing.JPanel {

    /**
     * Creates new form Head
     */
    JFrame frame;

    public void setFrame(JFrame fr) {
        this.frame = fr;
    }

    public Head() {
        initComponents();

    }

    IconLocation il = new IconLocation();
    Func func = new Func();

    public void setHeaderTitle(String title) {
        titleLbl.setText(title);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLbl = new javax.swing.JLabel();
        closeLbl = new javax.swing.JLabel();
        minimiseLbl = new javax.swing.JLabel();

        titleLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        titleLbl.setForeground(new java.awt.Color(255, 255, 255));
        titleLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLbl.setText("jLabel1");
        titleLbl.setPreferredSize(new java.awt.Dimension(48, 30));
        titleLbl.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                titleLblMouseDragged(evt);
            }
        });
        titleLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                titleLblMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                titleLblMousePressed(evt);
            }
        });

        closeLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\Close_Black.png")); // NOI18N
        closeLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeLblMouseExited(evt);
            }
        });

        minimiseLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\Minimise_Black.png")); // NOI18N
        minimiseLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimiseLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimiseLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimiseLblMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(minimiseLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(closeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(titleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(closeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(minimiseLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void closeLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(closeLbl, il.closeRedIcon);
    }//GEN-LAST:event_closeLblMouseEntered

    private void closeLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(closeLbl, il.closeBlackIcon);
    }//GEN-LAST:event_closeLblMouseExited

    private void closeLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLblMouseClicked
        // TODO add your handling code here:
        func.closeWindow(frame);
    }//GEN-LAST:event_closeLblMouseClicked

    private void minimiseLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimiseLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(minimiseLbl, il.minimiseGreenIcon);
    }//GEN-LAST:event_minimiseLblMouseEntered

    private void minimiseLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimiseLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(minimiseLbl, il.minimiseBlackIcon);
    }//GEN-LAST:event_minimiseLblMouseExited

    private void minimiseLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimiseLblMouseClicked
        // TODO add your handling code here:
        func.minimiseWindow(frame);
    }//GEN-LAST:event_minimiseLblMouseClicked

    private void titleLblMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleLblMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_titleLblMouseDragged

    private void titleLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleLblMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_titleLblMouseClicked

    private void titleLblMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleLblMousePressed
        // TODO add your handling code here:
        func.x = evt.getX();
        func.y = evt.getY();
        func.initMoving(frame, titleLbl);
    }//GEN-LAST:event_titleLblMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel closeLbl;
    private javax.swing.JLabel minimiseLbl;
    private javax.swing.JLabel titleLbl;
    // End of variables declaration//GEN-END:variables
}
