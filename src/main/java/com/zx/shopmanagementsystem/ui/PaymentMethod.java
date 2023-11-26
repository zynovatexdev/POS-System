/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.zx.shopmanagementsystem.ui;

import com.zx.shopmanagementsystem.assests.Func;
import com.zx.shopmanagementsystem.assests.IconLocation;
import com.zx.shopmanagementsystem.dbconnection.JDBC;
import com.zx.shopmanagementsystem.notifications.ConfirmDialog;
import com.zx.shopmanagementsystem.notifications.MessageDialog;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class PaymentMethod extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    Func func = new Func();
    IconLocation il = new IconLocation();
    JDBC DB = new JDBC();

    private int maxBarId;
    private int newBarId;
    private int methodExist;

    public PaymentMethod() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(il.logo));
        head1.setFrame(this);
        getMaxValue();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paymentMethodTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        saveBtnLbl = new javax.swing.JLabel();
        head1 = new com.zx.shopmanagementsystem.components.Head();
        iconLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paymentMethodTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        paymentMethodTxt.setHintText("Enter Payment Method");
        paymentMethodTxt.setPreferredSize(new java.awt.Dimension(129, 50));
        paymentMethodTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentMethodTxtActionPerformed(evt);
            }
        });
        getContentPane().add(paymentMethodTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 340, -1));

        saveBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saveBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                saveBtnLblMouseExited(evt);
            }
        });
        getContentPane().add(saveBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 600, 200, 50));

        head1.setHeaderTitle("");
        head1.setOpaque(false);
        getContentPane().add(head1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        iconLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\images\\Payment Method.png")); // NOI18N
        getContentPane().add(iconLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void paymentMethodTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentMethodTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentMethodTxtActionPerformed

    private void saveBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnLblMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_saveBtnLblMouseEntered

    private void saveBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnLblMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_saveBtnLblMouseExited

    private void saveBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnLblMouseClicked
        // TODO add your handling code here:
        savePaymentMethod();
    }//GEN-LAST:event_saveBtnLblMouseClicked

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
            java.util.logging.Logger.getLogger(PaymentMethod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentMethod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentMethod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentMethod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaymentMethod().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.zx.shopmanagementsystem.components.Head head1;
    private javax.swing.JLabel iconLbl;
    private com.zx.shopmanagementsystem.components.RoundedText paymentMethodTxt;
    private javax.swing.JLabel saveBtnLbl;
    // End of variables declaration//GEN-END:variables

    private void savePaymentMethod() {
        String paymentMethod = paymentMethodTxt.getText();

        MessageDialog DialogBox = new MessageDialog(this);

        if (paymentMethod.equals("")) {
            DialogBox.showMessage("WARNING!!!", "Text Can't Empty", 2);
        } else {
            if (paymentMethodChecker(paymentMethod) == 1) {
                DialogBox.showMessage("ERROR!!!", "Payment Method is Already Taken.", 3);
            } else {
                ConfirmDialog confrim = new ConfirmDialog(this);
                confrim.showMessage("Save", "Do you want to Save ?");
                if (confrim.getMessageType() == ConfirmDialog.MessageType.YES) {
                    System.out.println("Yes");
                    try {
                        String sql = "INSERT INTO payment_method (payment_method_id, payment_method_type) VALUES('" + newBarId + "','" + paymentMethod + "')";
                        DB.putdata(sql);
                        DialogBox.showMessage("Done!!!", "Payment Method Successfully Saved", 1);
                        paymentMethodTxt.setText("");
                        getMaxValue();
                    } catch (Exception ex) {
                        System.err.println("Save Payment Method -> Payment Method : " + ex.getMessage());
                    }
                } else {
                    System.out.println("No");
                }
            }
        }
    }

    private void getMaxValue() {
        try {
            java.sql.ResultSet rs1 = DB.getdata("SELECT MAX(payment_method_id) FROM payment_method");
            if (rs1.next()) {
                //System.out.println("Table not empty");
                maxBarId = rs1.getInt("max(payment_method_id)");
                newId(maxBarId);
                System.out.println(newBarId);
            } else {
                System.out.println("Table Empty");
            }
            DB.con().close();
        } catch (Exception ex) {
            System.err.println("Get Max Value -> Payment Method : " + ex.getMessage());
        }

    }

    private void newId(int maxValue) {
        newBarId = maxValue + 1;
    }

    public int paymentMethodChecker(String method) {
        String sql = "SELECT * FROM payment_method WHERE payment_method_type=?";
        try {
            PreparedStatement pstmt = DB.con().prepareStatement(sql);
            pstmt.setString(1, method);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                System.out.println("Payment Method is already taken.");
                methodExist = 1;
            } else {
                System.out.println("Payment Method is available.");
                methodExist = 0;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "Payment Method Checker");
        }
        return methodExist;
    }

}
