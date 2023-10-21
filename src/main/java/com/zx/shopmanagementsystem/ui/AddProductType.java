/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.zx.shopmanagementsystem.ui;

import com.zx.shopmanagementsystem.assests.Func;
import com.zx.shopmanagementsystem.assests.IconLocation;
import com.zx.shopmanagementsystem.dbconnection.JDBC;
import com.zx.shopmanagementsystem.notifications.MessageDialog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class AddProductType extends javax.swing.JFrame {

    /**
     * Creates new form AddBarcode
     */
    Func func = new Func();
    IconLocation il = new IconLocation();
    JDBC DB = new JDBC();

    int maxId;
    int newId;

    public AddProductType() {
        initComponents();
        getMaxValue();
        head1.setFrame(this);
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
        addProcuctTypeBtnLbl = new javax.swing.JLabel();
        productTypeTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        jScrollPane1 = new javax.swing.JScrollPane();
        productDescriptionTxt = new javax.swing.JTextArea();
        iconLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        head1.setHeaderTextColor("#000000");
        head1.setHeaderTitle("Add Barcode");
        head1.setOpaque(false);
        getContentPane().add(head1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, -1));

        addProcuctTypeBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\AddPurpleIcon.png")); // NOI18N
        addProcuctTypeBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addProcuctTypeBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addProcuctTypeBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addProcuctTypeBtnLblMouseExited(evt);
            }
        });
        getContentPane().add(addProcuctTypeBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 480, -1, -1));

        productTypeTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        productTypeTxt.setHintText("Enter Product Type");
        productTypeTxt.setPreferredSize(new java.awt.Dimension(129, 50));
        getContentPane().add(productTypeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 230, 480, -1));

        productDescriptionTxt.setColumns(20);
        productDescriptionTxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        productDescriptionTxt.setRows(5);
        jScrollPane1.setViewportView(productDescriptionTxt);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 330, 460, -1));

        iconLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\images\\Add_Product_Type.png")); // NOI18N
        getContentPane().add(iconLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addProcuctTypeBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addProcuctTypeBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(addProcuctTypeBtnLbl, il.addWhiteIcon);
    }//GEN-LAST:event_addProcuctTypeBtnLblMouseEntered

    private void addProcuctTypeBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addProcuctTypeBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(addProcuctTypeBtnLbl, il.addPurpleIcon);
    }//GEN-LAST:event_addProcuctTypeBtnLblMouseExited

    private void addProcuctTypeBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addProcuctTypeBtnLblMouseClicked
        // TODO add your handling code here:
        MessageDialog DialogBox = new MessageDialog(this);
        if (productTypeTxt.getText().equals("")) {
            DialogBox.showMessage("WARNING!!!", "Product Type Text Empty", 2);
        } else if (productDescriptionTxt.getText().equals("")) {
            DialogBox.showMessage("WARNING!!!", "Product Description Text Empty", 2);
        } else {
            if (typeChecker(productTypeTxt.getText())) {
                DialogBox.showMessage("ERROR!!!", "Type is already taken.", 3);
            } else {
                try {
                    DB.putdata("INSERT INTO product_type (product_type_id, product_type, product_type_description) VALUES ('" + newId + "', '" + productTypeTxt.getText() + "', '" + productDescriptionTxt.getText() + "')");
                    getMaxValue();
                    DialogBox.showMessage("Done!!!", "Product Type Saved!!!", 1);
                    productTypeTxt.setText("");
                    productDescriptionTxt.setText("");
                } catch (Exception ex) {
                    System.out.println("Add Product Type Btn : " + ex.getMessage());
                }
            }
        }

    }//GEN-LAST:event_addProcuctTypeBtnLblMouseClicked

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
            java.util.logging.Logger.getLogger(AddProductType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddProductType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddProductType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddProductType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddProductType().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addProcuctTypeBtnLbl;
    private com.zx.shopmanagementsystem.components.Head head1;
    private javax.swing.JLabel iconLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea productDescriptionTxt;
    private com.zx.shopmanagementsystem.components.RoundedText productTypeTxt;
    // End of variables declaration//GEN-END:variables

    private void getMaxValue() {
        try {
            java.sql.ResultSet rs1 = DB.getdata("SELECT MAX(product_type_id) FROM product_type");
            if (rs1.next()) {
                //System.out.println("Table not empty");
                maxId = rs1.getInt("max(product_type_id)");
                //System.out.println(maxCusId);
                //customerIdLbl.setText(String.valueOf(maxCusId + 1));
                newId(maxId);
            } else {
                System.out.println("Table Empty");
            }
        } catch (Exception ex) {
            System.out.println("Max Value : " + ex.getMessage());
        }
    }

    private void newId(int maxValue) {
        newId = maxValue + 1;
    }

    private boolean typeChecker(String type) {
        String sql = "SELECT * FROM product_type WHERE product_type=?";
        boolean Exist = false;
        try {
            PreparedStatement pstmt = DB.con().prepareStatement(sql);
            pstmt.setString(1, type);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                System.out.println("Type is already taken.");
                Exist = true;
            } else {
                System.out.println("Type is available.");
                Exist = false;
            }
        } catch (Exception ex) {
            System.out.println("Type Checkr : " + ex.getMessage());
        }
        return Exist;
    }
}
