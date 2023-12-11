/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.zx.shopmanagementsystem.forms;

import com.zx.shopmanagementsystem.assests.Func;
import com.zx.shopmanagementsystem.assests.IconLocation;
import com.zx.shopmanagementsystem.dbconnection.JDBC;
import com.zx.shopmanagementsystem.table.TableCustom;
import com.zx.shopmanagementsystem.ui.UserDetails;
import com.zx.shopmanagementsystem.ui.UserRegistration;
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
public class UserManagement extends javax.swing.JPanel {

    /**
     * Creates new form Home
     */
    Func func = new Func();
    IconLocation il = new IconLocation();

    JDBC DB = new JDBC();

    public UserManagement() {
        initComponents();
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        tableDataClear();
        tableDataLoader();
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

        addUserBtnIcon = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTbl = new javax.swing.JTable();
        searchTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        iconLbl = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1116, 718));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addUserBtnIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addUserBtnIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addUserBtnIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addUserBtnIconMouseExited(evt);
            }
        });
        add(addUserBtnIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 90, 210, 40));

        userTbl.setFont(new java.awt.Font("Poppins SemiBold", 1, 13)); // NOI18N
        userTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "User ID", "User Name", "Full Name"
            }
        ));
        userTbl.setOpaque(false);
        userTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(userTbl);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 207, 1020, 470));

        searchTxt.setFont(new java.awt.Font("Poppins Medium", 1, 13)); // NOI18N
        searchTxt.setHintText("User Name or User ID");
        searchTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTxtActionPerformed(evt);
            }
        });
        add(searchTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(757, 160, 260, -1));

        iconLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\images\\UserManagement.png")); // NOI18N
        add(iconLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void addUserBtnIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserBtnIconMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_addUserBtnIconMouseEntered

    private void addUserBtnIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserBtnIconMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_addUserBtnIconMouseExited

    private void addUserBtnIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserBtnIconMouseClicked
        // TODO add your handling code here:
        UserRegistration ur = new UserRegistration(this);
        ur.setVisible(true);
    }//GEN-LAST:event_addUserBtnIconMouseClicked

    private void userTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTblMouseClicked
        // TODO add your handling code here:
        int row = userTbl.getSelectedRow();
        int userID = Integer.parseInt((String) userTbl.getModel().getValueAt(row, 0));
        UserDetails ud = new UserDetails(this);
        ud.setVisible(true);
        ud.dataLoad(userID);

    }//GEN-LAST:event_userTblMouseClicked

    private void searchTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTxtActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addUserBtnIcon;
    private javax.swing.JLabel iconLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private com.zx.shopmanagementsystem.components.RoundedText searchTxt;
    private javax.swing.JTable userTbl;
    // End of variables declaration//GEN-END:variables

    private void tableDataLoader() {
        try {
            java.sql.ResultSet rs = DB.getdata("SELECT * FROM user");
            while (rs.next()) {
                String userId = String.valueOf(rs.getInt("user_id"));
                String userName = String.valueOf(rs.getString("user_name"));
                String fullName = String.valueOf(rs.getString("full_name"));

                System.out.println("User ID" + userId);
                System.out.println("User Name" + userName);
                System.out.println("Full Name" + fullName);

                String table_data[] = {userId, userName, fullName};
                DefaultTableModel table = (DefaultTableModel) userTbl.getModel();
                table.addRow(table_data);

            }
        } catch (Exception ex) {
            System.out.println("User Management Table Data Loader : " + ex);
        }
    }

    private void tableDataClear() {
        try {
            while (0 <= userTbl.getRowCount()) {
                DefaultTableModel table = (DefaultTableModel) userTbl.getModel();
                table.removeRow(userTbl.getRowCount() - 1);
            }
        } catch (Exception e) {
            System.out.println("User Management Table Data Clear : " + e);
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
            String sql = "SELECT * FROM user\n"
                    + "WHERE user_id = ? OR user_name LIKE ?;";

            try (PreparedStatement preparedStatement = DB.con().prepareStatement(sql)) {
                preparedStatement.setString(2, "%" + searchTxt.getText() + "%");
                preparedStatement.setString(1, searchTxt.getText());

                ResultSet rs = preparedStatement.executeQuery();

                // Process the resultSet as needed
                while (rs.next()) {
                    String userId = String.valueOf(rs.getInt("user_id"));
                    String userName = String.valueOf(rs.getString("user_name"));
                    String fullName = String.valueOf(rs.getString("full_name"));

                    System.out.println("User ID" + userId);
                    System.out.println("User Name" + userName);
                    System.out.println("Full Name" + fullName);

                    String table_data[] = {userId, userName, fullName};
                    DefaultTableModel table = (DefaultTableModel) userTbl.getModel();
                    table.addRow(table_data);

                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

    }
}
