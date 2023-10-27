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
        iconLbl = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1015, 738));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addUserBtnIcon.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\AddUserPurpleIcon.png")); // NOI18N
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
        add(addUserBtnIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 950, 480));

        iconLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\images\\UserManagement.png")); // NOI18N
        iconLbl.setPreferredSize(new java.awt.Dimension(1015, 738));
        add(iconLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void addUserBtnIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserBtnIconMouseEntered
        // TODO add your handling code here:
        func.iconSetter(addUserBtnIcon, il.addUserWhiteIcon);
    }//GEN-LAST:event_addUserBtnIconMouseEntered

    private void addUserBtnIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserBtnIconMouseExited
        // TODO add your handling code here:
        func.iconSetter(addUserBtnIcon, il.addUserPurpleIcon);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addUserBtnIcon;
    private javax.swing.JLabel iconLbl;
    private javax.swing.JScrollPane jScrollPane1;
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

}
