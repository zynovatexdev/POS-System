/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.zx.shopmanagementsystem.ui;

import com.zx.shopmanagementsystem.assests.Func;
import com.zx.shopmanagementsystem.assests.IconLocation;
import com.zx.shopmanagementsystem.dbconnection.JDBC;
import com.zx.shopmanagementsystem.notifications.MessageDialog;
import java.awt.Toolkit;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class CustomerCategory extends javax.swing.JFrame {

    /**
     * Creates new form CustomerCategory
     */
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(il.logo));
    }

    Func func = new Func();
    IconLocation il = new IconLocation();
    JDBC DB = new JDBC();

    boolean exsit;

    public CustomerCategory() {
        initComponents();
        head1.setFrame(CustomerCategory.this);
        setIcon();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        typeTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTxt = new javax.swing.JTextArea();
        submitBtnLbl = new javax.swing.JLabel();
        head1 = new com.zx.shopmanagementsystem.components.Head();
        iconLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        typeTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        typeTxt.setHintText("Enter Customer Category Type");
        getContentPane().add(typeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 230, 440, 50));

        descriptionTxt.setColumns(20);
        descriptionTxt.setRows(5);
        jScrollPane1.setViewportView(descriptionTxt);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 330, 420, 150));

        submitBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\AddPurpleIcon.png")); // NOI18N
        submitBtnLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submitBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                submitBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                submitBtnLblMouseExited(evt);
            }
        });
        getContentPane().add(submitBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 510, -1, -1));

        head1.setHeaderTextColor("#FFFFFF");
        head1.setHeaderTitle("");
        head1.setOpaque(false);
        getContentPane().add(head1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        iconLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\images\\CustomerCategory.png")); // NOI18N
        getContentPane().add(iconLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(submitBtnLbl, il.submitWhiteIcon);
    }//GEN-LAST:event_submitBtnLblMouseEntered

    private void submitBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(submitBtnLbl, il.submitPurpleIcon);
    }//GEN-LAST:event_submitBtnLblMouseExited

    private void submitBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitBtnLblMouseClicked
        // TODO add your handling code here:
        addCategory();
    }//GEN-LAST:event_submitBtnLblMouseClicked

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
            java.util.logging.Logger.getLogger(CustomerCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerCategory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea descriptionTxt;
    private com.zx.shopmanagementsystem.components.Head head1;
    private javax.swing.JLabel iconLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel submitBtnLbl;
    private com.zx.shopmanagementsystem.components.RoundedText typeTxt;
    // End of variables declaration//GEN-END:variables

    private void categoryChecker(String type) {

        try {
            ResultSet rs = DB.getdata("SELECT * FROM customer_category WHERE customer_type = '" + type + "'");
            if (rs.next()) {
                System.out.println("Customer Type Exsist");
                exsit = true;
            } else {
                System.out.println("Customer Type Not Exsist");
                exsit = false;
            }
            rs.close();
            DB.con().close();
            rs.close();
        } catch (Exception ex) {
            System.out.println("Customer Category Category Checker : " + ex.getMessage());
        }
    }

    private void addCategory() {
        String type = typeTxt.getText();
        String description = descriptionTxt.getText();
        categoryChecker(type);
        MessageDialog DialogBox = new MessageDialog(this);

        //System.out.println(exsit);
        if (type.equals("")) {
            System.out.println("Customer Category Type Empty");
            DialogBox.showMessage("WARNING !!!", "Customer Category Type Empty", 2);
        } else if (description.equals("")) {
            System.out.println("Customer Description Empty");
            DialogBox.showMessage("WARNING !!!", "Customer Description Empty", 2);
        } else if (exsit) {
            DialogBox.showMessage("ERROR !!!", "Categoey Already Exsist", 3);
        } else {
            try {
                DB.putdata("INSERT INTO customer_category (customer_type, customer_category_description) VALUES ('" + type + "','" + description + "');");
                DialogBox.showMessage("Done !!!", "Category Saved!", 1);
                clear();
                DB.con().close();
            } catch (Exception ex) {
                System.out.println("Add Category : " + ex.getMessage());
            }

        }
    }

    private void clear() {
        typeTxt.setText("");
        descriptionTxt.setText("");
    }
}