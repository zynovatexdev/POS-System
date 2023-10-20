/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.zx.shopmanagementsystem.ui;

import com.zx.shopmanagementsystem.assests.Func;
import com.zx.shopmanagementsystem.assests.IconLocation;
import com.zx.shopmanagementsystem.dbconnection.JDBC;
import com.zx.shopmanagementsystem.forms.SupplierManagement;
import com.zx.shopmanagementsystem.notifications.MessageDialog;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class SupplierRegistration extends javax.swing.JFrame {

    /**
     * Creates new form SupplierRegistration
     */
    IconLocation il = new IconLocation();
    Func func = new Func();

    int maxSupId;
    int newSupId;
    private SupplierManagement supplierManagement;

    public SupplierRegistration(SupplierManagement supplierManagement) {
        this.supplierManagement = supplierManagement;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(il.logo));
        getMaxValue();
        newId(maxSupId);
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
        supplierNumberTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        supplierNameTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        registerBtnLbl = new javax.swing.JLabel();
        iconLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        head1.setFrame(this);
        head1.setHeaderTextColor("#FFFFFF");
        head1.setHeaderTitle("Supplier Registration");
        head1.setOpaque(false);
        getContentPane().add(head1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, -1));

        supplierNumberTxt.setToolTipText("");
        supplierNumberTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        supplierNumberTxt.setHintText("Enter Supplier Contact Number");
        getContentPane().add(supplierNumberTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 360, 440, 50));

        supplierNameTxt.setToolTipText("");
        supplierNameTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        supplierNameTxt.setHintText("Enter Supplier Name");
        getContentPane().add(supplierNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 260, 440, 50));

        registerBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\RegisterPurpleIcon.png")); // NOI18N
        registerBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerBtnLblMouseExited(evt);
            }
        });
        getContentPane().add(registerBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(788, 470, -1, -1));

        iconLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\images\\SupplierRegistration.png")); // NOI18N
        getContentPane().add(iconLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(registerBtnLbl, il.RegisterWhiteIcon);
    }//GEN-LAST:event_registerBtnLblMouseEntered

    private void registerBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(registerBtnLbl, il.RegisterPurpleIcon);
    }//GEN-LAST:event_registerBtnLblMouseExited

    private void registerBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerBtnLblMouseClicked
        // TODO add your handling code here:
        registerSupplier();
        supplierManagement.setTable();
    }//GEN-LAST:event_registerBtnLblMouseClicked

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
            java.util.logging.Logger.getLogger(SupplierRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupplierRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupplierRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupplierRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        SupplierManagement supplierManagementInstance = new SupplierManagement();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SupplierRegistration sr = new SupplierRegistration(supplierManagementInstance);
                sr.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.zx.shopmanagementsystem.components.Head head1;
    private javax.swing.JLabel iconLbl;
    private javax.swing.JLabel registerBtnLbl;
    private com.zx.shopmanagementsystem.components.RoundedText supplierNameTxt;
    private com.zx.shopmanagementsystem.components.RoundedText supplierNumberTxt;
    // End of variables declaration//GEN-END:variables

    private void registerSupplier() {
        MessageDialog DialogBox = new MessageDialog(this);
        JDBC DB = new JDBC();

        String supplierName = supplierNameTxt.getText();
        String supplierNumber = supplierNumberTxt.getText();

        if (supplierName.equals("")) {
            System.out.println("Supplier Name Empty");
            DialogBox.showMessage("WARNING", "Supplier Name Empty", 2);
        } else if (supplierNumber.equals("")) {
            System.out.println("Supplier Number Empty");
            DialogBox.showMessage("WARNING", "Supplier Number Empty", 2);
        } else {
            if (func.isValidMobileNumber(supplierNumber)) {
                System.out.println("Valid Mobile Number");
                try {
                    DB.putdata("INSERT INTO supplier (supplier_id, supplier_name, supplier_contact) VALUES ('" + newSupId + "', '" + supplierName + "', '" + supplierNumber + "')");
                    System.out.println("Data Saved");
                    DialogBox.showMessage("Done", "Supplier Successfully Saved", 1);
                    clear();
                    //System.out.println("New Id : " + newSupId);
                } catch (Exception ex) {
                    System.out.println("Register Supplier Function (SupplierRegistration) -> " + ex.getMessage());
                }
            } else {
                System.out.println("Not Valid Mobile Number");
                DialogBox.showMessage("ERROR!!!", "Not Valid Mobile Number", 3);
            }
        }
    }

    private void getMaxValue() {
        JDBC DB = new JDBC();
        try {
            java.sql.ResultSet rs1 = DB.getdata("SELECT MAX(supplier_id) FROM supplier");
            if (rs1.next()) {
                System.out.println("Table not empty");
                maxSupId = rs1.getInt("max(supplier_id)");
                System.out.println(maxSupId);
                newId(maxSupId);
                DB.con().close();
                rs1.close();
            } else {
                System.out.println("Table Empty");
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void newId(int maxValue) {
        newSupId = maxValue + 1;
    }

    private void clear() {
        supplierNameTxt.setText("");
        supplierNumberTxt.setText("");
    }
}
