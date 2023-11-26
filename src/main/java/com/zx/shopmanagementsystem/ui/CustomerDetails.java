/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.zx.shopmanagementsystem.ui;

import com.zx.shopmanagementsystem.assests.Func;
import com.zx.shopmanagementsystem.assests.IconLocation;
import com.zx.shopmanagementsystem.dbconnection.JDBC;
import com.zx.shopmanagementsystem.forms.CustomerManagement;
import com.zx.shopmanagementsystem.notifications.ConfirmDialog;
import com.zx.shopmanagementsystem.notifications.MessageDialog;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class CustomerDetails extends javax.swing.JFrame {

    /**
     * Creates new form CustomerDetails
     */
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(il.logo));
    }
    Func func = new Func();
    IconLocation il = new IconLocation();
    JDBC DB = new JDBC();

    int cusID;
    private CustomerManagement customerManagement;

    public CustomerDetails(CustomerManagement customerManagement) {
        this.customerManagement = customerManagement;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(il.logo));
        head1.setFrame(this);
        disableForm();
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

        head1 = new com.zx.shopmanagementsystem.components.Head();
        customerNameTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        customerAddressTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        customerNumberTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        deleteCustomerBtnLbl = new javax.swing.JLabel();
        editCustomerBtnLbl = new javax.swing.JLabel();
        updateCustomerBtnLbl = new javax.swing.JLabel();
        customerCategoryCombo = new com.zx.shopmanagementsystem.components.ComboBoxSuggestion();
        iconLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        head1.setHeaderTextColor("#000000");
        head1.setHeaderTitle("");
        head1.setOpaque(false);
        getContentPane().add(head1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        customerNameTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        customerNameTxt.setHintText("Enter Customer Name");
        getContentPane().add(customerNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 310, 50));

        customerAddressTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        customerAddressTxt.setHintText("Enter Customer Address");
        getContentPane().add(customerAddressTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 310, 50));

        customerNumberTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        customerNumberTxt.setHintText("Enter Customer Number");
        getContentPane().add(customerNumberTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 310, 50));

        deleteCustomerBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\delete.png")); // NOI18N
        deleteCustomerBtnLbl.setPreferredSize(new java.awt.Dimension(183, 54));
        deleteCustomerBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteCustomerBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteCustomerBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteCustomerBtnLblMouseExited(evt);
            }
        });
        getContentPane().add(deleteCustomerBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 550, 203, 60));

        editCustomerBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\edit.png")); // NOI18N
        editCustomerBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editCustomerBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editCustomerBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editCustomerBtnLblMouseExited(evt);
            }
        });
        getContentPane().add(editCustomerBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 550, 200, 60));

        updateCustomerBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\update.png")); // NOI18N
        updateCustomerBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateCustomerBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateCustomerBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateCustomerBtnLblMouseExited(evt);
            }
        });
        getContentPane().add(updateCustomerBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 550, -1, -1));

        customerCategoryCombo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        customerCategoryCombo.setPreferredSize(new java.awt.Dimension(163, 50));
        getContentPane().add(customerCategoryCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 540, 310, -1));

        iconLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\images\\CustomerDetails.png")); // NOI18N
        iconLbl.setText("jLabel1");
        iconLbl.setPreferredSize(new java.awt.Dimension(1280, 720));
        getContentPane().add(iconLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void editCustomerBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editCustomerBtnLblMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_editCustomerBtnLblMouseEntered

    private void editCustomerBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editCustomerBtnLblMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_editCustomerBtnLblMouseExited

    private void deleteCustomerBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteCustomerBtnLblMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_deleteCustomerBtnLblMouseEntered

    private void deleteCustomerBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteCustomerBtnLblMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_deleteCustomerBtnLblMouseExited

    private void updateCustomerBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateCustomerBtnLblMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_updateCustomerBtnLblMouseEntered

    private void updateCustomerBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateCustomerBtnLblMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_updateCustomerBtnLblMouseExited

    private void editCustomerBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editCustomerBtnLblMouseClicked
        // TODO add your handling code here:
        enebleForm();
    }//GEN-LAST:event_editCustomerBtnLblMouseClicked

    private void deleteCustomerBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteCustomerBtnLblMouseClicked
        // TODO add your handling code here:
        MessageDialog DialogBox = new MessageDialog(this);
        ConfirmDialog confrim = new ConfirmDialog(this);
        confrim.showMessage("Delete", "Do you want to Delete ?");
        if (confrim.getMessageType() == ConfirmDialog.MessageType.YES) {
            System.out.println("Yes");
            try {
                DB.putdata("DELETE FROM customer WHERE customer_id = '" + cusID + "';");
                System.out.println("Data Deleted");
                DialogBox.showMessage("Deleted", "User Deleted", 1);
                customerManagement.setTable();
                this.dispose();

            } catch (Exception ex) {
                System.out.println("Delete Button Mouse Clicked (Customer Details) : " + ex.getMessage());
            }
        } else {
            System.out.println("No");
        }
    }//GEN-LAST:event_deleteCustomerBtnLblMouseClicked

    private void updateCustomerBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateCustomerBtnLblMouseClicked
        // TODO add your handling code here:
        updateCustomer();
        customerManagement.setTable();
    }//GEN-LAST:event_updateCustomerBtnLblMouseClicked

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
            java.util.logging.Logger.getLogger(CustomerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        CustomerManagement cs = new CustomerManagement();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CustomerDetails cd = new CustomerDetails(cs);
                cd.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.zx.shopmanagementsystem.components.RoundedText customerAddressTxt;
    private com.zx.shopmanagementsystem.components.ComboBoxSuggestion customerCategoryCombo;
    private com.zx.shopmanagementsystem.components.RoundedText customerNameTxt;
    private com.zx.shopmanagementsystem.components.RoundedText customerNumberTxt;
    private javax.swing.JLabel deleteCustomerBtnLbl;
    private javax.swing.JLabel editCustomerBtnLbl;
    private com.zx.shopmanagementsystem.components.Head head1;
    private javax.swing.JLabel iconLbl;
    private javax.swing.JLabel updateCustomerBtnLbl;
    // End of variables declaration//GEN-END:variables
    public void dataLoad(int customerID) {
        this.cusID = customerID;
        try {
            //System.out.println("Customer ID : " + cusID);
            ResultSet rs = DB.getdata("SELECT * FROM customer WHERE customer_id = '" + cusID + "'");
            while (rs.next()) {
                String cusName = rs.getString("customer_name");
                String cusAddress = rs.getString("customer_address");
                String cusContact = rs.getString("customer_phone");
                int cusCatId = rs.getInt("category_id");
                comboLoader(cusCatId);

                customerNameTxt.setText(cusName);
                customerNumberTxt.setText(cusContact);
                customerAddressTxt.setText(cusAddress);

            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void disableForm() {
        customerNameTxt.setEditable(false);
        customerNumberTxt.setEditable(false);
        customerAddressTxt.setEditable(false);
        customerCategoryCombo.setEnabled(false);
        editCustomerBtnLbl.setVisible(true);
        deleteCustomerBtnLbl.setVisible(true);
        updateCustomerBtnLbl.setVisible(false);

    }

    private void enebleForm() {
        customerNameTxt.setEditable(true);
        customerNumberTxt.setEditable(true);
        customerAddressTxt.setEditable(true);
        customerCategoryCombo.setEnabled(true);
        editCustomerBtnLbl.setVisible(false);
        deleteCustomerBtnLbl.setVisible(false);
        updateCustomerBtnLbl.setVisible(true);

    }

    private void comboLoader(int index) {
        try {
            ResultSet rs = DB.getdata("SELECT * FROM customer_category ;");
            customerCategoryCombo.addItem("Select Role");
            while (rs.next()) {
                String cusCatName = rs.getString("customer_type");
                int cusCatId = rs.getInt("customer_category_id");
                customerCategoryCombo.addItem(cusCatName);
                if (cusCatId == index) {
                    customerCategoryCombo.setSelectedItem(cusCatName);
                }
            }

        } catch (Exception ex) {
            System.out.println("Combo Loader Function (Customer Details) : " + ex.getMessage());
        }
    }

    private void updateCustomer() {
        int customerCategoryId = 0;
        MessageDialog DialogBox = new MessageDialog(this);
        String cusName = customerNameTxt.getText();
        String cusNumber = customerNumberTxt.getText();
        String cusAddress = customerAddressTxt.getText();
        String cusCategory = (String) customerCategoryCombo.getSelectedItem();

        try {
            ResultSet rs = DB.getdata("SELECT customer_category_id FROM customer_category WHERE customer_type = '" + cusCategory + "'");
            while (rs.next()) {
                customerCategoryId = rs.getInt("customer_category_id");
            }
        } catch (Exception ex) {
            System.out.println("Update Customer Customer Id Finder : " + ex.getMessage());
        }
        if (cusName.equals("")) {
            System.out.println("Customer Name Empty");
            DialogBox.showMessage("WARNING", "Customer Name Empty", 2);
        } else if (cusNumber.equals("")) {
            System.out.println("Customer Contact Empty");
            DialogBox.showMessage("WARNING", "Customer Contact Empty", 2);
        } else if (cusAddress.equals("")) {
            System.out.println("Customer Address Empty");
            DialogBox.showMessage("WARNING", "Customer Address Empty", 2);
        } else if (cusCategory.equals("Select Role")) {
            System.out.println("Please Select a Customer Category");
            DialogBox.showMessage("WARNING", "Please Select a Customer Category", 2);
        } else {
            if (func.isValidMobileNumber(cusNumber)) {
                System.out.println("Valid Number");
                ConfirmDialog confrim = new ConfirmDialog(this);
                confrim.showMessage("Update", "Do you want to Update ?");
                if (confrim.getMessageType() == ConfirmDialog.MessageType.YES) {
                    System.out.println("Yes");
                    try {
                        DB.putdata("UPDATE customer SET customer_name = '" + cusName + "', customer_address = '" + cusAddress + "', customer_phone = '" + cusNumber + "', category_id = '" + customerCategoryId + "' WHERE customer_id = '" + cusID + "'");
                        System.out.println("Data Updated");
                        DialogBox.showMessage("Done", "Customer Updated", 1);
                        disableForm();
                    } catch (Exception ex) {
                        System.out.println("Update Customer -> Update Query Runs : " + ex.getMessage());
                    }
                } else {
                    System.out.println("No");
                }
            } else {
                System.out.println("Not Valid Number");
                DialogBox.showMessage("ERROR", "Not a Valid Mobile Number", 3);
            }
        }
    }

}
