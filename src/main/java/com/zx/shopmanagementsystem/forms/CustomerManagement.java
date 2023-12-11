/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.zx.shopmanagementsystem.forms;

import com.zx.shopmanagementsystem.assests.Func;
import com.zx.shopmanagementsystem.assests.IconLocation;
import com.zx.shopmanagementsystem.dbconnection.JDBC;
import com.zx.shopmanagementsystem.table.TableCustom;
import com.zx.shopmanagementsystem.ui.CustomerCategory;
import com.zx.shopmanagementsystem.ui.CustomerDetails;
import com.zx.shopmanagementsystem.ui.CustomerRegistration;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class CustomerManagement extends javax.swing.JPanel {

    /**
     * Creates new form Home
     */
    Func func = new Func();
    IconLocation il = new IconLocation();
    JDBC DB = new JDBC();
    CustomerCategory cc = new CustomerCategory();

    public CustomerManagement() {
        initComponents();
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        tableDataClear();
        tableDataLoader();

        // Add a DocumentListener to the searchTxt
        searchTxt.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                try {
                    // Call your method to handle the text update
                    handleSearchTextUpdate();
                } catch (Exception ex) {
                    Logger.getLogger(CustomerManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                try {
                    // Call your method to handle the text update
                    handleSearchTextUpdate();
                } catch (Exception ex) {
                    Logger.getLogger(CustomerManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                try {
                    // Call your method to handle the text update
                    handleSearchTextUpdate();
                } catch (Exception ex) {
                    Logger.getLogger(CustomerManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addCustomerCategoryBtnLbl = new javax.swing.JLabel();
        addCustomerBtnLbl = new javax.swing.JLabel();
        searchTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerTbl = new javax.swing.JTable();
        iconLbl = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1116, 718));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addCustomerCategoryBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addCustomerCategoryBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addCustomerCategoryBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addCustomerCategoryBtnLblMouseExited(evt);
            }
        });
        add(addCustomerCategoryBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 270, 36));

        addCustomerBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addCustomerBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addCustomerBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addCustomerBtnLblMouseExited(evt);
            }
        });
        add(addCustomerBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 260, 36));

        searchTxt.setFont(new java.awt.Font("Poppins Medium", 1, 13)); // NOI18N
        searchTxt.setHintText("EnteName or Phone Number");
        searchTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTxtActionPerformed(evt);
            }
        });
        add(searchTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(757, 160, 260, -1));

        jScrollPane1.setBorder(null);

        customerTbl.setFont(new java.awt.Font("Poppins SemiBold", 1, 13)); // NOI18N
        customerTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Customer ID", "Name", "Address", "Phone Number", "Category"
            }
        ));
        customerTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(customerTbl);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 207, 1020, 470));

        iconLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\images\\CustomerManagement.png")); // NOI18N
        add(iconLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void addCustomerBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addCustomerBtnLblMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_addCustomerBtnLblMouseEntered

    private void addCustomerBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addCustomerBtnLblMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_addCustomerBtnLblMouseExited

    private void addCustomerCategoryBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addCustomerCategoryBtnLblMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_addCustomerCategoryBtnLblMouseEntered

    private void addCustomerCategoryBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addCustomerCategoryBtnLblMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_addCustomerCategoryBtnLblMouseExited

    private void addCustomerBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addCustomerBtnLblMouseClicked
        // TODO add your handling code here:
        CustomerRegistration cr = new CustomerRegistration(this);
        cr.setVisible(true);
    }//GEN-LAST:event_addCustomerBtnLblMouseClicked

    private void customerTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerTblMouseClicked
        // TODO add your handling code here:
        int row = customerTbl.getSelectedRow();
        int userID = Integer.parseInt((String) customerTbl.getModel().getValueAt(row, 0));
        CustomerDetails cd = new CustomerDetails(this);
        cd.setVisible(true);
        cd.dataLoad(userID);
    }//GEN-LAST:event_customerTblMouseClicked

    private void addCustomerCategoryBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addCustomerCategoryBtnLblMouseClicked
        // TODO add your handling code here:
        cc.setVisible(true);
    }//GEN-LAST:event_addCustomerCategoryBtnLblMouseClicked

    private void searchTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTxtActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_searchTxtActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addCustomerBtnLbl;
    private javax.swing.JLabel addCustomerCategoryBtnLbl;
    private javax.swing.JTable customerTbl;
    private javax.swing.JLabel iconLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private com.zx.shopmanagementsystem.components.RoundedText searchTxt;
    // End of variables declaration//GEN-END:variables

    private void tableDataLoader() {
        try {
            java.sql.ResultSet rs = DB.getdata("SELECT\n"
                    + "    c.customer_id,\n"
                    + "    c.customer_name,\n"
                    + "    c.customer_address,\n"
                    + "    c.customer_phone,\n"
                    + "    cc.customer_type\n"
                    + "FROM\n"
                    + "    shopdb.customer c\n"
                    + "JOIN\n"
                    + "    shopdb.customer_category cc ON c.category_id = cc.customer_category_id;");
            while (rs.next()) {
                String customerId = String.valueOf(rs.getInt("customer_id"));
                String customerName = String.valueOf(rs.getString("customer_name"));
                String customerAddress = String.valueOf(rs.getString("customer_address"));
                String customerPhone = String.valueOf(rs.getString("customer_phone"));
                String customerCategoryId = String.valueOf(rs.getString("customer_type"));

//                System.out.println("User ID" + userId);
//                System.out.println("User Name" + userName);
//                System.out.println("Full Name" + fullName);
                String table_data[] = {customerId, customerName, customerAddress, customerPhone, customerCategoryId};
                DefaultTableModel table = (DefaultTableModel) customerTbl.getModel();
                table.addRow(table_data);

            }
        } catch (Exception ex) {
            System.out.println("User Management Table Data Loader : " + ex);
        }
    }

    private void tableDataClear() {
        try {
            while (0 <= customerTbl.getRowCount()) {
                DefaultTableModel table = (DefaultTableModel) customerTbl.getModel();
                table.removeRow(customerTbl.getRowCount() - 1);
            }
        } catch (Exception e) {
            System.out.println("Customer Management Table Data Clear : " + e);
        }
    }

    public void setTable() {
        tableDataClear();
        tableDataLoader();
    }

    private void handleSearchTextUpdate() throws Exception {
        if (searchTxt.getText().equals("")) {
            tableDataClear();
            tableDataLoader();
        } else {

            tableDataClear();
            String sql = "SELECT\n"
                    + "    c.customer_id,\n"
                    + "    c.customer_name,\n"
                    + "    c.customer_address,\n"
                    + "    c.customer_phone,\n"
                    + "    cc.customer_type\n"
                    + "FROM\n"
                    + "    shopdb.customer c\n"
                    + "JOIN\n"
                    + "    shopdb.customer_category cc ON c.category_id = cc.customer_category_id\n"
                    + "WHERE\n"
                    + "    c.customer_name LIKE ? OR c.customer_phone LIKE ?";

            try (PreparedStatement preparedStatement = DB.con().prepareStatement(sql)) {
                preparedStatement.setString(1, "%" + searchTxt.getText() + "%");
                preparedStatement.setString(2, "%" + searchTxt.getText() + "%");

                ResultSet rs = preparedStatement.executeQuery();

                // Process the resultSet as needed
                while (rs.next()) {
                    String customerId = String.valueOf(rs.getInt("customer_id"));
                    String customerName = String.valueOf(rs.getString("customer_name"));
                    String customerAddress = String.valueOf(rs.getString("customer_address"));
                    String customerPhone = String.valueOf(rs.getString("customer_phone"));
                    String customerCategoryId = String.valueOf(rs.getString("customer_type"));

//                System.out.println("User ID" + userId);
//                System.out.println("User Name" + userName);
//                System.out.println("Full Name" + fullName);
                    String table_data[] = {customerId, customerName, customerAddress, customerPhone, customerCategoryId};
                    DefaultTableModel table = (DefaultTableModel) customerTbl.getModel();
                    table.addRow(table_data);

                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

    }
}
