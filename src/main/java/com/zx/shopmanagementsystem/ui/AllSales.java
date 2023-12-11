/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.zx.shopmanagementsystem.ui;

import com.zx.shopmanagementsystem.assests.IconLocation;
import com.zx.shopmanagementsystem.dbconnection.JDBC;
import com.zx.shopmanagementsystem.notifications.MessageDialog;
import com.zx.shopmanagementsystem.table.TableCustom;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class AllSales extends javax.swing.JFrame {

    /**
     * Creates new form LowStock
     */
    JDBC DB = new JDBC();
    IconLocation il = new IconLocation();

    public AllSales(int value) {
        initComponents();
        combo.setSelectedIndex(value + 1);
        if (value == 0) {
            daily();
        } else {
            monthly();
        }
        setIconImage(Toolkit.getDefaultToolkit().getImage(il.logo));
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        head1.setFrame(this);
        fromDateTxt.setText("");
        toDateTxt.setText("");
        toDateTxt.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                // This method is called when text is inserted into the document
                handleTextChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // This method is called when text is removed from the document
                //handleTextChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // This method is generally not needed for plain text fields
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

        fromDate = new com.zx.shopmanagementsystem.dateChooser.DateChooser();
        toDate = new com.zx.shopmanagementsystem.dateChooser.DateChooser();
        toDateTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        fromDateTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        combo = new com.zx.shopmanagementsystem.components.ComboBoxSuggestion();
        head1 = new com.zx.shopmanagementsystem.components.Head();
        totalProfitTxt = new javax.swing.JLabel();
        totalSalesTxt = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        allSalesTbl = new javax.swing.JTable();
        iconLbl = new javax.swing.JLabel();

        fromDate.setForeground(new java.awt.Color(0, 51, 204));
        fromDate.setDateFormat("yyyy-MM-dd");
        fromDate.setTextRefernce(fromDateTxt);

        toDate.setForeground(new java.awt.Color(0, 51, 204));
        toDate.setDateFormat("yyyy-MM-dd");
        toDate.setTextRefernce(toDateTxt);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        toDateTxt.setFont(new java.awt.Font("Poppins Medium", 1, 13)); // NOI18N
        toDateTxt.setHintText("Enter To Date");
        getContentPane().add(toDateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, 190, 40));

        fromDateTxt.setFont(new java.awt.Font("Poppins Medium", 1, 13)); // NOI18N
        fromDateTxt.setHintText("Enter From Date");
        getContentPane().add(fromDateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 190, 40));

        combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Value", "Daily", "Monthly" }));
        combo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        combo.setMinimumSize(new java.awt.Dimension(185, 50));
        combo.setPreferredSize(new java.awt.Dimension(185, 50));
        combo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comboPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });
        getContentPane().add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 48, 240, 40));

        head1.setHeaderTitle("");
        head1.setOpaque(false);
        getContentPane().add(head1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        totalProfitTxt.setFont(new java.awt.Font("Poppins SemiBold", 1, 14)); // NOI18N
        totalProfitTxt.setText("sample");
        getContentPane().add(totalProfitTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 650, 150, -1));

        totalSalesTxt.setFont(new java.awt.Font("Poppins SemiBold", 1, 14)); // NOI18N
        totalSalesTxt.setText("sample");
        getContentPane().add(totalSalesTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 630, 150, -1));

        jLabel2.setFont(new java.awt.Font("Poppins SemiBold", 1, 14)); // NOI18N
        jLabel2.setText("Total Profit");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 650, 90, -1));

        jLabel1.setFont(new java.awt.Font("Poppins SemiBold", 1, 14)); // NOI18N
        jLabel1.setText("Total Sales");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 630, 90, -1));

        allSalesTbl.setFont(new java.awt.Font("Poppins SemiBold", 1, 13)); // NOI18N
        allSalesTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Product Name", "Sold Quantity", "Total Sale", "Total Profit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(allSalesTbl);
        if (allSalesTbl.getColumnModel().getColumnCount() > 0) {
            allSalesTbl.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 1180, 470));

        iconLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\images\\All Sales.png")); // NOI18N
        getContentPane().add(iconLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comboPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comboPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String value = (String) (combo.getSelectedItem());
        fromDateTxt.setText("");
        toDateTxt.setText("");
        if (value.equals("Daily")) {
            System.out.println("1");
            daily();
        } else {
            System.out.println("2");
            monthly();
        }
    }//GEN-LAST:event_comboPopupMenuWillBecomeInvisible

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboActionPerformed

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
            java.util.logging.Logger.getLogger(AllSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AllSales(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable allSalesTbl;
    private com.zx.shopmanagementsystem.components.ComboBoxSuggestion combo;
    private com.zx.shopmanagementsystem.dateChooser.DateChooser fromDate;
    private com.zx.shopmanagementsystem.components.RoundedText fromDateTxt;
    private com.zx.shopmanagementsystem.components.Head head1;
    private javax.swing.JLabel iconLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.zx.shopmanagementsystem.dateChooser.DateChooser toDate;
    private com.zx.shopmanagementsystem.components.RoundedText toDateTxt;
    private javax.swing.JLabel totalProfitTxt;
    private javax.swing.JLabel totalSalesTxt;
    // End of variables declaration//GEN-END:variables

    private void daily() {
        tableDataClear();
        String sql = "SELECT\n"
                + "    p.product_name,\n"
                + "    SUM(s.quantity) AS total_quantity,\n"
                + "    ROUND(SUM(s.price), 2) AS total_sales_price,\n"
                + "    ROUND(SUM(s.price - p.reciving_price), 2) AS total_profit\n"
                + "FROM shopdb.sold_items s\n"
                + "JOIN shopdb.product p ON s.product_id = p.product_id\n"
                + "WHERE s.date = CURRENT_DATE\n"
                + "GROUP BY s.product_id, p.product_name;";

        String product_name;
        String total_quantity;
        String total_sales_price;
        String total_profit;

        double sumOfSales = 0.0;
        double sumOfProfit = 0.0;

        ResultSet rs;
        try {
            rs = DB.getdata(sql);
            while (rs.next()) {
                product_name = rs.getString("product_name");
                total_quantity = rs.getString("total_quantity");
                total_sales_price = rs.getString("total_sales_price");
                total_profit = rs.getString("total_profit");

                sumOfSales += Double.parseDouble(total_sales_price);
                sumOfProfit += Double.parseDouble(total_profit);
                DefaultTableModel table = (DefaultTableModel) allSalesTbl.getModel();
                table.addRow(new Object[]{table.getRowCount() + 1, product_name, total_quantity, total_sales_price, total_profit});
                DB.con().close();
            }

            totalSalesTxt.setText(String.format("%.2f/=", sumOfSales));
            totalProfitTxt.setText(String.format("%.2f/=", sumOfProfit));

        } catch (Exception ex) {
            Logger.getLogger(AllSales.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void monthly() {
        tableDataClear();
        String sql = "SELECT\n"
                + "    p.product_name,\n"
                + "    SUM(s.quantity) AS total_quantity,\n"
                + "    ROUND(SUM(s.price), 2) AS total_sales_price,\n"
                + "    ROUND(SUM(s.price - p.reciving_price), 2) AS total_profit\n"
                + "FROM shopdb.sold_items s\n"
                + "JOIN shopdb.product p ON s.product_id = p.product_id\n"
                + "WHERE MONTH(s.date) = MONTH(CURRENT_DATE) AND YEAR(s.date) = YEAR(CURRENT_DATE)\n"
                + "GROUP BY s.product_id, p.product_name;";

        String product_name;
        String total_quantity;
        String total_sales_price;
        String total_profit;

        double sumOfSales = 0.0;
        double sumOfProfit = 0.0;

        ResultSet rs;
        try {
            rs = DB.getdata(sql);
            while (rs.next()) {
                product_name = rs.getString("product_name");
                total_quantity = rs.getString("total_quantity");
                total_sales_price = rs.getString("total_sales_price");
                total_profit = rs.getString("total_profit");

                sumOfSales += Double.parseDouble(total_sales_price);
                sumOfProfit += Double.parseDouble(total_profit);
                DefaultTableModel table = (DefaultTableModel) allSalesTbl.getModel();
                table.addRow(new Object[]{table.getRowCount() + 1, product_name, total_quantity, total_sales_price, total_profit});
                DB.con().close();
            }
            totalSalesTxt.setText(String.format("%.2f/=", sumOfSales));
            totalProfitTxt.setText(String.format("%.2f/=", sumOfProfit));
        } catch (Exception ex) {
            Logger.getLogger(AllSales.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void tableDataClear() {
        try {
            while (0 <= allSalesTbl.getRowCount()) {
                DefaultTableModel table = (DefaultTableModel) allSalesTbl.getModel();
                table.removeRow(allSalesTbl.getRowCount() - 1);
            }
        } catch (Exception e) {
            System.out.println("Expire Date Table Data Clear : " + e);
        }
    }

    private void handleTextChange() {
        combo.setSelectedIndex(0);
        MessageDialog DialogBox = new MessageDialog(this);
        if (fromDateTxt.getText().equals("")) {
            DialogBox.showMessage("ERROR", "Please Select a Date in 'From Date'", 3);
        } else if (toDateTxt.getText().equals("")) {
            DialogBox.showMessage("ERROR", "Please Select a Date in 'To Date'", 3);
        } else {
            String fromDateStr = fromDateTxt.getText(); // Replace this with your from date string
            String toDateStr = toDateTxt.getText();   // Replace this with your to date string

            // Parse the strings to Date objects
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date fromDate = dateFormat.parse(fromDateStr);
                Date toDate = dateFormat.parse(toDateStr);

                // Get today's date
                Date today = new Date();

                // Compare timestamps
                if (compareDates(fromDate, today) < 0) {
                    System.out.println("From date is before today.");
                    tableDataClear();
                    tableDataLoader();
                } else {
                    System.out.println("Please Select " + LocalDate.now().minusDays(1) + " or Before");
                    DialogBox.showMessage("WARNING", "Please Select " + LocalDate.now().minusDays(1) + " or Before in \n'From Date'", 2);
                    tableDataClear();
                }

                if (compareDates(toDate, today) <= 0) {
                    if (toDate.equals(LocalDate.now())) {
                        System.out.println("Today");
                    } else {
                        System.out.println("Before");
                        tableDataClear();
                        tableDataLoader();
                    }
                } else {
                    System.out.println("To date is in the future.");
                    DialogBox.showMessage("WARNING", "Please Select " + LocalDate.now().minusDays(1) + " or Today in \n'To Date'", 2);
                    tableDataClear();

                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    }

    private static int compareDates(Date date1, Date date2) {
        // Compare timestamps
        long timestamp1 = date1.getTime();
        long timestamp2 = date2.getTime();

        return Long.compare(timestamp1, timestamp2);
    }

    private void tableDataLoader() {
        tableDataClear();
        String sql = "SELECT\n"
                + "    p.product_name,\n"
                + "    SUM(s.quantity) AS total_quantity,\n"
                + "    ROUND(SUM(s.price), 2) AS total_sales_price,\n"
                + "    ROUND(SUM(s.price - p.reciving_price), 2) AS total_profit\n"
                + "FROM\n"
                + "    shopdb.sold_items s\n"
                + "JOIN\n"
                + "    shopdb.product p ON s.product_id = p.product_id\n"
                + "WHERE\n"
                + "    s.date BETWEEN '" + fromDateTxt.getText() + "' AND '" + toDateTxt.getText() + "'  -- Replace with your desired date range\n"
                + "GROUP BY\n"
                + "    s.product_id, p.product_name;";

        String product_name;
        String total_quantity;
        String total_sales_price;
        String total_profit;

        double sumOfSales = 0.0;
        double sumOfProfit = 0.0;
        try {
            java.sql.ResultSet rs = DB.getdata(sql);
            while (rs.next()) {

                product_name = rs.getString("product_name");
                total_quantity = rs.getString("total_quantity");
                total_sales_price = rs.getString("total_sales_price");
                total_profit = rs.getString("total_profit");

                sumOfSales += Double.parseDouble(total_sales_price);
                sumOfProfit += Double.parseDouble(total_profit);
                DefaultTableModel table = (DefaultTableModel) allSalesTbl.getModel();
                table.addRow(new Object[]{table.getRowCount() + 1, product_name, total_quantity, total_sales_price, total_profit});
                DB.con().close();
            }
            totalSalesTxt.setText(String.format("%.2f/=", sumOfSales));
            totalProfitTxt.setText(String.format("%.2f/=", sumOfProfit));
        } catch (Exception ex) {
            System.out.println("Sales Report Table Data Loader : " + ex);
        }
    }
}
