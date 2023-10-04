/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.zx.shopmanagementsystem.ui;

import com.zx.shopmanagementsystem.assests.Func;
import com.zx.shopmanagementsystem.assests.IconLocation;
import com.zx.shopmanagementsystem.forms.CustomerManagement;
import com.zx.shopmanagementsystem.forms.DebtManagement;
import com.zx.shopmanagementsystem.forms.Help;
import com.zx.shopmanagementsystem.forms.Home;
import com.zx.shopmanagementsystem.forms.InvoiceCreation;
import java.awt.Color;

/**
 *
 * @author User
 */
public class DashboardUser extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    IconLocation il = new IconLocation();
    Func func = new Func();

    public DashboardUser() {
        initComponents();
        setBackground(new Color(255, 255, 255, 0));
        head1.setOpaque(true);
        head1.setHeaderTitle("Dashboard User");
        head1.setHeaderTextColor("#800080");
        head1.setFrame(DashboardUser.this);
        func.setForm(mainPanal, new Home());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        head1 = new com.zx.shopmanagementsystem.components.Head();
        menu1 = new com.raven.component.Menu();
        customerManagementBtnLbl = new javax.swing.JLabel();
        dashboardBtnLbl = new javax.swing.JLabel();
        debtManagementBtnLbl = new javax.swing.JLabel();
        invoiceCreationBtnLbl = new javax.swing.JLabel();
        helpBtnLbl = new javax.swing.JLabel();
        logoutBtnLbl = new javax.swing.JLabel();
        mainPanal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setUndecorated(true);
        setResizable(false);

        customerManagementBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\CustomerManagementPurple.png")); // NOI18N
        customerManagementBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerManagementBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                customerManagementBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                customerManagementBtnLblMouseExited(evt);
            }
        });

        dashboardBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\DashboardPurple.png")); // NOI18N
        dashboardBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashboardBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashboardBtnLblMouseExited(evt);
            }
        });

        debtManagementBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\DebtManagementPurple.png")); // NOI18N
        debtManagementBtnLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        debtManagementBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                debtManagementBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                debtManagementBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                debtManagementBtnLblMouseExited(evt);
            }
        });

        invoiceCreationBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\InvoiceCreationPurple.png")); // NOI18N
        invoiceCreationBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invoiceCreationBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                invoiceCreationBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                invoiceCreationBtnLblMouseExited(evt);
            }
        });

        helpBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\HelpPurple.png")); // NOI18N
        helpBtnLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        helpBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                helpBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                helpBtnLblMouseExited(evt);
            }
        });

        logoutBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\LogoutPurple.png")); // NOI18N
        logoutBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutBtnLblMouseExited(evt);
            }
        });

        javax.swing.GroupLayout menu1Layout = new javax.swing.GroupLayout(menu1);
        menu1.setLayout(menu1Layout);
        menu1Layout.setHorizontalGroup(
            menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customerManagementBtnLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                    .addComponent(dashboardBtnLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(debtManagementBtnLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(invoiceCreationBtnLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(helpBtnLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(menu1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(logoutBtnLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menu1Layout.setVerticalGroup(
            menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dashboardBtnLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerManagementBtnLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(debtManagementBtnLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invoiceCreationBtnLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(helpBtnLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(237, 237, 237)
                .addComponent(logoutBtnLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        mainPanal.setBackground(new java.awt.Color(255, 255, 255));
        mainPanal.setPreferredSize(new java.awt.Dimension(1015, 738));
        mainPanal.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(head1, javax.swing.GroupLayout.PREFERRED_SIZE, 1009, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(mainPanal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(head1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainPanal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dashboardBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(dashboardBtnLbl, il.dashboardWhiteIcon);
    }//GEN-LAST:event_dashboardBtnLblMouseEntered

    private void dashboardBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(dashboardBtnLbl, il.dashboardPurpleIcon);
    }//GEN-LAST:event_dashboardBtnLblMouseExited

    private void customerManagementBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerManagementBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(customerManagementBtnLbl, il.customerManagementWhiteIcon);
    }//GEN-LAST:event_customerManagementBtnLblMouseEntered

    private void customerManagementBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerManagementBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(customerManagementBtnLbl, il.customerManagementPurpleIcon);
    }//GEN-LAST:event_customerManagementBtnLblMouseExited

    private void debtManagementBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_debtManagementBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(debtManagementBtnLbl, il.debtManagemetWhiteIcon);
    }//GEN-LAST:event_debtManagementBtnLblMouseEntered

    private void debtManagementBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_debtManagementBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(debtManagementBtnLbl, il.debtManagemetPurpleIcon);
    }//GEN-LAST:event_debtManagementBtnLblMouseExited

    private void invoiceCreationBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceCreationBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(invoiceCreationBtnLbl, il.invoiceCreationWhiteIcon);
    }//GEN-LAST:event_invoiceCreationBtnLblMouseEntered

    private void invoiceCreationBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceCreationBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(invoiceCreationBtnLbl, il.invoiceCreationPurpleIcon);
    }//GEN-LAST:event_invoiceCreationBtnLblMouseExited

    private void helpBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(helpBtnLbl, il.helpWhiteIcon);
    }//GEN-LAST:event_helpBtnLblMouseEntered

    private void helpBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(helpBtnLbl, il.helpPurpleIcon);
    }//GEN-LAST:event_helpBtnLblMouseExited

    private void logoutBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(logoutBtnLbl, il.logoutWhiteIcon);
    }//GEN-LAST:event_logoutBtnLblMouseEntered

    private void logoutBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(logoutBtnLbl, il.logoutPurpleIcon);
    }//GEN-LAST:event_logoutBtnLblMouseExited

    private void dashboardBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardBtnLblMouseClicked
        // TODO add your handling code here:
        func.setForm(mainPanal, new Home());
        head1.setHeaderTitle("Admin Dashboard");
    }//GEN-LAST:event_dashboardBtnLblMouseClicked

    private void customerManagementBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerManagementBtnLblMouseClicked
        // TODO add your handling code here:
        func.setForm(mainPanal, new CustomerManagement());
        head1.setHeaderTitle("Customer Management");
    }//GEN-LAST:event_customerManagementBtnLblMouseClicked

    private void debtManagementBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_debtManagementBtnLblMouseClicked
        // TODO add your handling code here:
        func.setForm(mainPanal, new DebtManagement());
        head1.setHeaderTitle("Debt Management");
    }//GEN-LAST:event_debtManagementBtnLblMouseClicked

    private void invoiceCreationBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceCreationBtnLblMouseClicked
        // TODO add your handling code here:
        func.setForm(mainPanal, new InvoiceCreation());
        head1.setHeaderTitle("Invoice Management");
    }//GEN-LAST:event_invoiceCreationBtnLblMouseClicked

    private void helpBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpBtnLblMouseClicked
        // TODO add your handling code here:
        func.setForm(mainPanal, new Help());
        head1.setHeaderTitle("Help and Documentation");
    }//GEN-LAST:event_helpBtnLblMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashboardUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel customerManagementBtnLbl;
    private javax.swing.JLabel dashboardBtnLbl;
    private javax.swing.JLabel debtManagementBtnLbl;
    private com.zx.shopmanagementsystem.components.Head head1;
    private javax.swing.JLabel helpBtnLbl;
    private javax.swing.JLabel invoiceCreationBtnLbl;
    private javax.swing.JLabel logoutBtnLbl;
    private javax.swing.JPanel mainPanal;
    private com.raven.component.Menu menu1;
    // End of variables declaration//GEN-END:variables
}
