/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.zx.shopmanagementsystem.ui;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zx.shopmanagementsystem.assests.IconLocation;
import com.zx.shopmanagementsystem.assests.QtyCellEditor;
import com.zx.shopmanagementsystem.dbconnection.JDBC;
import com.zx.shopmanagementsystem.notifications.MessageDialog;
import com.zx.shopmanagementsystem.table.TableCustom;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aruna
 */
public class ReturnItems extends javax.swing.JFrame {

    /**
     * Creates new form ReturnItems
     */
    IconLocation il = new IconLocation();
    JDBC DB = new JDBC();
    ArrayList<Integer> customerIdArray = new ArrayList<>();

    public ReturnItems() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(il.logo));
        head1.setFrame(this);
        dateComboLoader();
        timeComboLoader();
        table1.getColumnModel().getColumn(2).setCellEditor(new QtyCellEditor());
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        TableCustom.apply(jScrollPane2, TableCustom.TableType.MULTI_LINE);
        table1.getModel().addTableModelListener((e) -> {
            if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 2) {
                checkSpinnerValue(e.getFirstRow());
            }
        });
        tableDataClear();
        tableDataClear2();

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
        returnLbl = new javax.swing.JLabel();
        searchLbl1 = new javax.swing.JLabel();
        scanLbl = new javax.swing.JLabel();
        returnTotalLbl = new javax.swing.JLabel();
        timeCombo = new com.zx.shopmanagementsystem.components.ComboBoxSuggestion();
        customerNameCombo = new com.zx.shopmanagementsystem.components.ComboBoxSuggestion();
        dateCombo = new com.zx.shopmanagementsystem.components.ComboBoxSuggestion();
        backwardBtnLbl = new javax.swing.JLabel();
        forwardBtnLbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        iconLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        head1.setOpaque(false);
        getContentPane().add(head1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        returnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnLblMouseClicked(evt);
            }
        });
        getContentPane().add(returnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 620, 200, 50));

        searchLbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchLbl1MouseClicked(evt);
            }
        });
        getContentPane().add(searchLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1035, 165, 135, 40));

        scanLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scanLblMouseClicked(evt);
            }
        });
        getContentPane().add(scanLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 165, 135, 40));

        returnTotalLbl.setFont(new java.awt.Font("Poppins SemiBold", 1, 16)); // NOI18N
        returnTotalLbl.setForeground(new java.awt.Color(42, 44, 116));
        getContentPane().add(returnTotalLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 565, 270, 30));

        timeCombo.setFont(new java.awt.Font("Poppins SemiBold", 1, 13)); // NOI18N
        getContentPane().add(timeCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 165, 140, -1));

        customerNameCombo.setFont(new java.awt.Font("Poppins SemiBold", 1, 13)); // NOI18N
        customerNameCombo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                customerNameComboPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        getContentPane().add(customerNameCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 165, 220, -1));

        dateCombo.setFont(new java.awt.Font("Poppins SemiBold", 1, 13)); // NOI18N
        dateCombo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                dateComboPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        getContentPane().add(dateCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 165, 140, -1));

        backwardBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backwardBtnLblMouseClicked(evt);
            }
        });
        getContentPane().add(backwardBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 380, 30, 20));

        forwardBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forwardBtnLblMouseClicked(evt);
            }
        });
        getContentPane().add(forwardBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, 30, 20));

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Product Name", "Returned Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 232, 535, 302));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Product Name", "Quantity", "Return Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 232, 535, 302));

        iconLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\images\\ReturnItems.png")); // NOI18N
        getContentPane().add(iconLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dateComboPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_dateComboPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        timeComboLoader();
    }//GEN-LAST:event_dateComboPopupMenuWillBecomeInvisible

    private void scanLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scanLblMouseClicked
        // TODO add your handling code here:
        try {
            String pythonScript = "C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\barcode_Python\\abcCopy.py";
            Process process = Runtime.getRuntime().exec("python " + pythonScript);

            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    if (line.equals("Done")) {
                        System.out.println("Done");

                    } else if (line.startsWith("QRCODE")) {
                        System.out.println("it is a QR");
                        jsonRead(line.substring(6));  // Remove "QRCODE" prefix and update text
                        //System.out.println(line);
                    } else {
                        System.out.println("it is not a QR");
                        //barcodeValueTxt.setText(line);
                        // barcodeTxt.setText(line);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(AddBarcode.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_scanLblMouseClicked

    private void searchLbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchLbl1MouseClicked
        // TODO add your handling code here:
        String date = (String) dateCombo.getSelectedItem();
        String time = (String) timeCombo.getSelectedItem();

        //tableDataClear();
        //tableDataLoader(date, time);
        displayAvailableCustomers(date, time);

    }//GEN-LAST:event_searchLbl1MouseClicked

    private void forwardBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forwardBtnLblMouseClicked
        // TODO add your handling code here:
        MessageDialog DialogBox = new MessageDialog(this);
        int selectedRow = table1.getSelectedRow();

        if (selectedRow != -1) { // -1 indicates no row is selected
            // Assuming 'table' is the name of your JTable
            String value1 = (String) table1.getValueAt(selectedRow, 0); // Replace 0 with the column index you want
            String value2 = String.valueOf(table1.getValueAt(selectedRow, 2)); // Replace 1 with another column index if needed

            // Do something with the values
            System.out.println("Selected Row Values: " + value1 + ", " + value2);

            if (value2.equals("0")) {
                System.out.println("0 value");
                DialogBox.showMessage("WARNING!!!", "Please Select Return Quantity!!!", 2);
            } else {
                numberChanger();
            }

        } else {
            System.out.println("No row is selected.");
            DialogBox.showMessage("ERROR!!!", "No row is selected.", 3);
        }
    }//GEN-LAST:event_forwardBtnLblMouseClicked

    private void returnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnLblMouseClicked
        try {
            // TODO add your handling code here:
            updateSoldItemsTable();
        } catch (Exception ex) {
            Logger.getLogger(ReturnItems.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_returnLblMouseClicked

    private void backwardBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backwardBtnLblMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
        DefaultTableModel model2 = (DefaultTableModel) table2.getModel();

        int[] selectedRows = table2.getSelectedRows();

        for (int i = selectedRows.length - 1; i >= 0; i--) {
            String productName = (String) table2.getValueAt(selectedRows[i], 0);
            double returnQuantity = Double.parseDouble(table2.getValueAt(selectedRows[i], 1).toString());

            // Check if the product is already in table1
            int rowIndexInTable1 = findRowIndexInTable1(productName);

            if (rowIndexInTable1 != -1) {
                // If product is already in table1, update the quantity
                double currentQuantity = Double.parseDouble(model1.getValueAt(rowIndexInTable1, 1).toString());
                model1.setValueAt(currentQuantity + returnQuantity, rowIndexInTable1, 1);
            } else {
                // If product is not in table1, add a new row
                Object[] rowData = {productName, returnQuantity, 0};
                model1.addRow(rowData);
            }

            // Remove the row from table2
            model2.removeRow(selectedRows[i]);
        }

        // Recalculate the returnTotalLbl value
        printTable2Data();
    }//GEN-LAST:event_backwardBtnLblMouseClicked

    private void customerNameComboPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_customerNameComboPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        tableDataClear();
        tableDataLoader(dateCombo.getSelectedItem().toString(), timeCombo.getSelectedItem().toString(), customerIdArray.get(customerNameCombo.getSelectedIndex()));
    }//GEN-LAST:event_customerNameComboPopupMenuWillBecomeInvisible

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
            java.util.logging.Logger.getLogger(ReturnItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnItems().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backwardBtnLbl;
    private com.zx.shopmanagementsystem.components.ComboBoxSuggestion customerNameCombo;
    private com.zx.shopmanagementsystem.components.ComboBoxSuggestion dateCombo;
    private javax.swing.JLabel forwardBtnLbl;
    private com.zx.shopmanagementsystem.components.Head head1;
    private javax.swing.JLabel iconLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel returnLbl;
    private javax.swing.JLabel returnTotalLbl;
    private javax.swing.JLabel scanLbl;
    private javax.swing.JLabel searchLbl1;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    private com.zx.shopmanagementsystem.components.ComboBoxSuggestion timeCombo;
    // End of variables declaration//GEN-END:variables

    private void dateComboLoader() {
        try {
            String sql = "SELECT DISTINCT date\n"
                    + "FROM sold_items;";
            ResultSet rs = DB.getdata(sql);
            while (rs.next()) {
                dateCombo.addItem(rs.getString("date"));
            }
        } catch (Exception ex) {
            Logger.getLogger(ReturnItems.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void timeComboLoader() {
        timeCombo.removeAllItems();
        try {
            String sql = "SELECT DISTINCT time\n"
                    + "FROM sold_items\n"
                    + "WHERE date = '" + dateCombo.getSelectedItem() + "'";

            ResultSet rs = DB.getdata(sql);
            while (rs.next()) {
                timeCombo.addItem(rs.getString("time"));
            }
        } catch (Exception ex) {
            Logger.getLogger(ReturnItems.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void displayAvailableCustomers(String date, String time) {
        customerIdArray.clear();
        customerNameCombo.removeAllItems();
        try {
            String sql = "SELECT DISTINCT c.customer_id, c.customer_name\n"
                    + "FROM sold_items si\n"
                    + "JOIN customer c ON si.customer_id = c.customer_id\n"
                    + "WHERE si.date = ? AND si.time = ?";

            PreparedStatement preparedStatement = DB.con().prepareStatement(sql);
            preparedStatement.setString(1, date);
            preparedStatement.setString(2, time);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int customerId = rs.getInt("customer_id");
                String customerName = rs.getString("customer_name");
                customerIdArray.add(customerId);
                customerNameCombo.addItem(customerName);
                System.out.println("Customer ID: " + customerId + ", Customer Name: " + customerName);

                // You can use this information as needed, such as displaying it in a UI component.
            }

        } catch (Exception ex) {
            Logger.getLogger(ReturnItems.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jsonRead(String data) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON string into JsonNode
            JsonNode jsonNode = objectMapper.readTree(data);

            // Extract values
            String time = jsonNode.get("Time").asText();
            int customerID = jsonNode.get("CustomerID").asInt();
            String date = jsonNode.get("Date").asText();
            dateCombo.setSelectedItem(date);
            timeCombo.setSelectedItem(time);
            displayAvailableCustomers(date, time);
            tableDataClear();
            tableDataLoader(date, time, customerID);
            // Print values
            System.out.println("Time: " + time);
            System.out.println("CustomerID: " + customerID);
            System.out.println("Date: " + date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void tableDataLoader(String date, String time, int cudtomerId) {
        try {
            String sql = "SELECT\n"
                    + "    si.sold_item_id,\n"
                    + "    si.date,\n"
                    + "    si.time,\n"
                    + "    si.price,\n"
                    + "    si.profit,\n"
                    + "    si.quantity,\n"
                    + "    si.user_id,\n"
                    + "    si.customer_id,\n"
                    + "    p.product_name\n"
                    + "FROM\n"
                    + "    shopdb.sold_items si\n"
                    + "JOIN\n"
                    + "    shopdb.product p ON si.product_id = p.product_id\n"
                    + "WHERE\n"
                    + "    si.date = '" + date + "' AND si.time = '" + time + "' AND si.customer_id = '" + cudtomerId + "';";

            ResultSet rs = DB.getdata(sql);
            while (rs.next()) {
                String product_name = rs.getString("product_name");
                double quantity = Double.parseDouble(rs.getString("quantity"));
                String qyt = "0";// Round to the nearest integer

                String table_data[] = {product_name, String.valueOf(quantity), qyt};
                DefaultTableModel table = (DefaultTableModel) table1.getModel();
                table.addRow(table_data);
            }
        } catch (Exception ex) {
            Logger.getLogger(ReturnItems.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void tableDataClear() {
        try {
            while (0 <= table1.getRowCount()) {
                DefaultTableModel table = (DefaultTableModel) table1.getModel();
                table.removeRow(table1.getRowCount() - 1);
            }
        } catch (Exception e) {
            System.out.println("Return Table 1 Data Clear : " + e);
        }
    }

    private void tableDataClear2() {
        try {
            while (0 <= table2.getRowCount()) {
                DefaultTableModel table = (DefaultTableModel) table2.getModel();
                table.removeRow(table2.getRowCount() - 1);
            }
        } catch (Exception e) {
            System.out.println("Return Table 2 Data Clear : " + e);
        }
    }

    private void checkSpinnerValue(int rowIndex) {
        MessageDialog DialogBox = new MessageDialog(this);
        try {
            DefaultTableModel model = (DefaultTableModel) table1.getModel();

            // Get values as objects
            Object quantityObj = model.getValueAt(rowIndex, 1);
            Object returnQuantityObj = model.getValueAt(rowIndex, 2);

            // Check if values are not null
            if (quantityObj != null && returnQuantityObj != null) {
                // Convert values to Double
                double quantity = Double.parseDouble(quantityObj.toString());
                double returnQuantity = Double.parseDouble(returnQuantityObj.toString());

                // Compare values
                if (returnQuantity > quantity) {
                    System.out.println("Return quantity cannot be greater than quantity.");
                    DialogBox.showMessage("WARNING!!!", "Return quantity cannot be greater \nthan quantity.", 2);

                    // Set spinner value to the maximum value of the second column
                    model.setValueAt((int) quantity, rowIndex, 2);

                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ReturnItems.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void numberChanger() {
        MessageDialog DialogBox = new MessageDialog(this);
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        int selectedRow = table1.getSelectedRow();
        int selectedColumn = 1;

        if (selectedRow != -1 && selectedColumn != -1) {
            // Assuming 'table' is the name of your JTable
            // Get the current value in the selected cell
            Object quantityObj = model.getValueAt(selectedRow, 1);
            Object returnQuantityObj = model.getValueAt(selectedRow, 2);

            double quantity = Double.parseDouble(quantityObj.toString());
            double returnQuantity = Double.parseDouble(returnQuantityObj.toString());

            if (returnQuantity > quantity) {
                System.out.println("Return quantity cannot be greater than quantity.");
                DialogBox.showMessage("WARNING!!!", "Return quantity cannot be greater \nthan quantity.", 2);

                // Set spinner value to the maximum value of the second column
                model.setValueAt((int) 1, selectedRow, 2);
            } else {

                if ((quantity - returnQuantity) < 0) {
                    System.out.println("0 in there");
                    //model.removeRow(selectedRow);

                } else {
                    String newvalue = String.valueOf(quantity - returnQuantity);
                    String value1 = (String) table1.getValueAt(selectedRow, 0); // Replace 0 with the column index you want
                    System.out.println("Nothing Wrong");
                    String table_data[] = {value1, String.valueOf(returnQuantity)};
                    DefaultTableModel table = (DefaultTableModel) table2.getModel();
                    table.addRow(table_data);
                    table1.setValueAt(newvalue, selectedRow, selectedColumn);
                    printTable2Data();
                }
            }

        } else {
            System.out.println("No cell is selected.");
        }

    }

    private void printTable2Data() {
        DefaultTableModel model2 = (DefaultTableModel) table2.getModel();
        Map<String, Double> productQuantities = new HashMap<>();
        double totalReturnPrice = 0.0;

        // Iterate through each row in table2
        for (int i = 0; i < model2.getRowCount(); i++) {
            String productName = (String) model2.getValueAt(i, 0);
            double returnQuantity = Double.parseDouble(model2.getValueAt(i, 1).toString());

            // Update the quantity in the map
            productQuantities.put(productName, productQuantities.getOrDefault(productName, 0.0) + returnQuantity);
        }

        // Fetch product information from shopdb.product table and calculate profit and sales
        for (Map.Entry<String, Double> entry : productQuantities.entrySet()) {
            String productName = entry.getKey();
            double returnQuantity = entry.getValue();

            // Fetch product information from shopdb.product table
            ProductInfo productInfo = getProductInfo(productName);

            if (productInfo != null) {
                // Calculate return price
                double sellingPrice = productInfo.getSellingPrice();
                double returnPrice = sellingPrice * returnQuantity;

                // Accumulate return prices to get total return price
                totalReturnPrice += returnPrice;

                // Print or use the calculated values as needed
                System.out.println("Product Name: " + productName
                        + ", Return Quantity: " + returnQuantity
                        + ", Selling Price: " + sellingPrice
                        + ", Return Price: " + returnPrice);
            }
        }

        // Update the returnTotalLbl with the totalReturnPrice
        returnTotalLbl.setText(String.valueOf(totalReturnPrice));
    }

    private ProductInfo getProductInfo(String productName) {
        try {
            String sql = "SELECT * FROM shopdb.product WHERE product_name = '" + productName + "'";
            ResultSet rs = DB.getdata(sql);

            if (rs.next()) {
                // Extract relevant information from the ResultSet
                double receivingPrice = rs.getDouble("reciving_price");
                double sellingPrice = rs.getDouble("selling_price");

                // Create and return a ProductInfo object
                return new ProductInfo(receivingPrice, sellingPrice);
            }
        } catch (Exception ex) {
            Logger.getLogger(ReturnItems.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null; // Return null if no information is found
    }

    private int findRowIndexInTable1(String productName) {
        DefaultTableModel model1 = (DefaultTableModel) table1.getModel();

        for (int i = 0; i < model1.getRowCount(); i++) {
            String currentProductName = (String) model1.getValueAt(i, 0);
            if (productName.equals(currentProductName)) {
                return i;
            }
        }

        return -1; // Product not found in table1
    }

    private void updateSoldItemsTable() throws Exception {
        DefaultTableModel model2 = (DefaultTableModel) table2.getModel();

        for (int i = 0; i < model2.getRowCount(); i++) {
            String productName = (String) model2.getValueAt(i, 0);
            double returnQuantity = Double.parseDouble(model2.getValueAt(i, 1).toString());

            // Fetch product information from shopdb.product table
            ProductInfo productInfo = getProductInfo(productName);

            if (productInfo != null) {
                // Calculate new quantities, prices, and profits
                double sellingPrice = productInfo.getSellingPrice();
                double returnPrice = sellingPrice * returnQuantity;

                // Update the shopdb.sold_items table
                try {
                    String updateSql = "UPDATE shopdb.sold_items "
                            + "SET quantity = quantity - ?, "
                            + "price = price - ?, "
                            + "profit = profit - ? "
                            + "WHERE date = ? AND time = ? AND product_id = (SELECT product_id FROM shopdb.product WHERE product_name = ?)";
                    PreparedStatement updateStatement = DB.con().prepareStatement(updateSql);
                    updateStatement.setDouble(1, returnQuantity);
                    updateStatement.setDouble(2, returnPrice);
                    updateStatement.setDouble(3, returnPrice - (returnQuantity * productInfo.getReceivingPrice()));
                    updateStatement.setString(4, (String) dateCombo.getSelectedItem());
                    updateStatement.setString(5, (String) timeCombo.getSelectedItem());
                    updateStatement.setString(6, productName);

                    int rowsAffected = updateStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Table updated successfully.");
                    } else {
                        System.out.println("No rows updated.");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ReturnItems.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}

class ProductInfo {

    private final double receivingPrice;
    private final double sellingPrice;

    public ProductInfo(double receivingPrice, double sellingPrice) {
        this.receivingPrice = receivingPrice;
        this.sellingPrice = sellingPrice;
    }

    public double getReceivingPrice() {
        return receivingPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

}