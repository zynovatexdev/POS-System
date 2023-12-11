/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.zx.shopmanagementsystem.ui;

import com.zx.shopmanagementsystem.assests.IconLocation;
import com.zx.shopmanagementsystem.dbconnection.JDBC;
import com.zx.shopmanagementsystem.notifications.ConfirmDialog;
import com.zx.shopmanagementsystem.notifications.MessageDialog;
import com.zx.shopmanagementsystem.table.TableCustom;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aruna
 */
public class ExpensesCategory extends javax.swing.JFrame {

    private int maxBarId;
    private int newBarId;
    JDBC DB = new JDBC();
    IconLocation il = new IconLocation();

    /**
     * Creates new form Expenses
     */
    public ExpensesCategory() {
        initComponents();
        TableCustom.apply(jScrollPane2, TableCustom.TableType.MULTI_LINE);
        head2.setFrame(this);
        getMaxValue();
        tableDataClear();
        tableDataLoader();
        setIconImage(Toolkit.getDefaultToolkit().getImage(il.logo));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        head2 = new com.zx.shopmanagementsystem.components.Head();
        categoryNameTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        saveBtbLbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        categoryTbl = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTxt = new javax.swing.JTextPane();
        iconLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        head2.setOpaque(false);
        getContentPane().add(head2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, -1));

        categoryNameTxt.setFont(new java.awt.Font("Poppins SemiBold", 1, 13)); // NOI18N
        categoryNameTxt.setHintText("Enter Category Name");
        getContentPane().add(categoryNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 260, 45));

        saveBtbLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveBtbLblMouseClicked(evt);
            }
        });
        getContentPane().add(saveBtbLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 616, 190, 40));

        categoryTbl.setFont(new java.awt.Font("Poppins SemiBold", 1, 13)); // NOI18N
        categoryTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Category Name", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(categoryTbl);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 164, 635, 415));

        descriptionTxt.setFont(new java.awt.Font("Poppins SemiBold", 1, 13)); // NOI18N
        descriptionTxt.setSelectionColor(new java.awt.Color(42, 44, 116));
        jScrollPane1.setViewportView(descriptionTxt);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 260, 170));

        iconLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\images\\ExpensesCategory.png")); // NOI18N
        getContentPane().add(iconLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 718));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtbLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtbLblMouseClicked
        // TODO add your handling code here:
        ConfirmDialog confrim = new ConfirmDialog(this);
        confrim.showMessage("Save", "Do you want to Add ?");
        if (confrim.getMessageType() == ConfirmDialog.MessageType.YES) {
            save();
            tableDataClear();
            tableDataLoader();
        } else {
            System.out.println("No");
        }
    }//GEN-LAST:event_saveBtbLblMouseClicked

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
            java.util.logging.Logger.getLogger(ExpensesCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExpensesCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExpensesCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExpensesCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExpensesCategory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.zx.shopmanagementsystem.components.RoundedText categoryNameTxt;
    private javax.swing.JTable categoryTbl;
    private javax.swing.JTextPane descriptionTxt;
    private com.zx.shopmanagementsystem.components.Head head2;
    private javax.swing.JLabel iconLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel saveBtbLbl;
    // End of variables declaration//GEN-END:variables

    private void save() {
        MessageDialog DialogBox = new MessageDialog(this);
        if (categoryNameTxt.getText().equals("")) {
            DialogBox.showMessage("WARNING!!!", "Category Name Empty", 2);
        } else if (descriptionTxt.getText().equals("")) {
            DialogBox.showMessage("WARNING!!!", "Description Empty", 2);
        } else {
            try {
                DB.putdata("INSERT INTO expense_category (expenses_category_id, category_name, description) VALUES ('" + newBarId + "','" + categoryNameTxt.getText() + "','" + descriptionTxt.getText() + "')");
                getMaxValue();
                DialogBox.showMessage("Done!!!", "Saved Successfully", 1);
            } catch (Exception ex) {
                Logger.getLogger(ExpensesCategory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void getMaxValue() {
        try {
            java.sql.ResultSet rs1 = DB.getdata("SELECT MAX(expenses_category_id) FROM expense_category");
            if (rs1.next()) {
                //System.out.println("Table not empty");
                maxBarId = rs1.getInt("max(expenses_category_id)");
                //System.out.println(maxCusId);
                //barcodeIdLbl.setText(String.valueOf(maxBarId + 1));
                newId(maxBarId);
            } else {
                System.out.println("Table Empty");
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void newId(int maxValue) {
        newBarId = maxValue + 1;
    }

    private void tableDataLoader() {
        try {
            java.sql.ResultSet rs = DB.getdata("SELECT * FROM expense_category");
            while (rs.next()) {
                String userId = String.valueOf(rs.getInt("expenses_category_id"));
                String userName = String.valueOf(rs.getString("category_name"));
                String fullName = String.valueOf(rs.getString("description"));

                System.out.println("User ID" + userId);
                System.out.println("User Name" + userName);
                System.out.println("Full Name" + fullName);

                String table_data[] = {userName, fullName};
                DefaultTableModel table = (DefaultTableModel) categoryTbl.getModel();
                table.addRow(table_data);

            }
        } catch (Exception ex) {
            System.out.println("expense_category Table Data Loader : " + ex);
        }
    }

    private void tableDataClear() {
        try {
            while (0 <= categoryTbl.getRowCount()) {
                DefaultTableModel table = (DefaultTableModel) categoryTbl.getModel();
                table.removeRow(categoryTbl.getRowCount() - 1);
            }
        } catch (Exception e) {
            System.out.println("expense_category Table Data Clear : " + e);
        }
    }

}
