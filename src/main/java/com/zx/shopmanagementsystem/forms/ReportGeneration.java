/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.zx.shopmanagementsystem.forms;

import com.zx.shopmanagementsystem.ui.ProfitReport;
import com.zx.shopmanagementsystem.ui.SalesReport;
import com.zx.shopmanagementsystem.ui.TopPerformingReport;
import com.zx.shopmanagementsystem.ui.UnderPerformingReport;

/**
 *
 * @author User
 */
public class ReportGeneration extends javax.swing.JPanel {

    /**
     * Creates new form Home
     */
    public ReportGeneration() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profitReportBtnLbl = new javax.swing.JLabel();
        topReportBtnLbl = new javax.swing.JLabel();
        underReportBtnLbl = new javax.swing.JLabel();
        salsReportBtnLbl = new javax.swing.JLabel();
        sendLbl = new javax.swing.JLabel();
        iconLbl = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1116, 718));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profitReportBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profitReportBtnLblMouseClicked(evt);
            }
        });
        add(profitReportBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 150, 50));

        topReportBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                topReportBtnLblMouseClicked(evt);
            }
        });
        add(topReportBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 180, 50));

        underReportBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                underReportBtnLblMouseClicked(evt);
            }
        });
        add(underReportBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 90, 190, 50));

        salsReportBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salsReportBtnLblMouseClicked(evt);
            }
        });
        add(salsReportBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 150, 50));
        add(sendLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 640, 155, 40));

        iconLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\images\\ReportGeneration.png")); // NOI18N
        add(iconLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void salsReportBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salsReportBtnLblMouseClicked
        // TODO add your handling code here:
        new SalesReport().setVisible(true);
    }//GEN-LAST:event_salsReportBtnLblMouseClicked

    private void profitReportBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profitReportBtnLblMouseClicked
        // TODO add your handling code here:
        new ProfitReport().setVisible(true);
    }//GEN-LAST:event_profitReportBtnLblMouseClicked

    private void topReportBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topReportBtnLblMouseClicked
        // TODO add your handling code here:
        new TopPerformingReport().setVisible(true);
    }//GEN-LAST:event_topReportBtnLblMouseClicked

    private void underReportBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_underReportBtnLblMouseClicked
        // TODO add your handling code here:
        new UnderPerformingReport().setVisible(true);
    }//GEN-LAST:event_underReportBtnLblMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconLbl;
    private javax.swing.JLabel profitReportBtnLbl;
    private javax.swing.JLabel salsReportBtnLbl;
    private javax.swing.JLabel sendLbl;
    private javax.swing.JLabel topReportBtnLbl;
    private javax.swing.JLabel underReportBtnLbl;
    // End of variables declaration//GEN-END:variables
}
