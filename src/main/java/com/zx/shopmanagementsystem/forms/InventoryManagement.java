/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.zx.shopmanagementsystem.forms;

import com.zx.shopmanagementsystem.dbconnection.JDBC;
import com.zx.shopmanagementsystem.notifications.MessageDialog;
import com.zx.shopmanagementsystem.table.TableCustom;
import com.zx.shopmanagementsystem.ui.productDetails;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class InventoryManagement extends javax.swing.JPanel {

    /**
     * Creates new form Home
     */
    JDBC DB = new JDBC();

    ArrayList<Integer> productIdArray = new ArrayList<>();

    public InventoryManagement() {
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

        panelBorder2 = new com.raven.swing.PanelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventoryTbl = new javax.swing.JTable();
        searchTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        barcodeIcon = new javax.swing.JLabel();
        iconLbl = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1116, 718));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        inventoryTbl.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        inventoryTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Product Name", "Reciving Price", "Selling Price", "Stock Quantitiy", "Manuf.Date", "Exp.Date", "Location"
            }
        ));
        inventoryTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inventoryTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(inventoryTbl);

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1058, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 136, 1070, 560));

        searchTxt.setFont(new java.awt.Font("Poppins Medium", 1, 13)); // NOI18N
        searchTxt.setHintText("Barcode or Item Name");
        searchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTxtKeyPressed(evt);
            }
        });
        add(searchTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 85, 240, -1));

        barcodeIcon.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\SearchBardcodeIcon.png")); // NOI18N
        barcodeIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barcodeIconMouseClicked(evt);
            }
        });
        add(barcodeIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 85, 40, 40));

        iconLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\images\\InventoryManagement.png")); // NOI18N
        add(iconLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void inventoryTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryTblMouseClicked
        // TODO add your handling code here:
        //System.out.println(inventoryTbl.getSelectedRow());
        //System.out.println(productIdArray.get(inventoryTbl.getSelectedRow()));
        productDetails pd = new productDetails(this);
        pd.setVisible(true);
        pd.dataLoad(productIdArray.get(inventoryTbl.getSelectedRow()));
    }//GEN-LAST:event_inventoryTblMouseClicked

    private void searchTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyPressed
        // TODO add your handling code here:
        searchTxt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkTextField();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkTextField();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkTextField();
            }

            private void checkTextField() {
                if (searchTxt.getText().isEmpty()) {
                    System.out.println("Text field is empty");
                    tableDataClear();
                    tableDataLoader();
                } else {
                    System.out.println("Text field is not empty");
                    findProductByNameOrBarcode(searchTxt.getText());
                }
            }
        });
    }//GEN-LAST:event_searchTxtKeyPressed

    private void barcodeIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barcodeIconMouseClicked
        // TODO add your handling code here:
        try {
            String pythonScript = "C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\barcode_Python\\abcCopy.py";
            Process process = Runtime.getRuntime().exec("python " + pythonScript);

            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            String prv = "";

            while ((line = reader.readLine()) != null) {
                if (line.equals(prv)) {
                    System.out.println("Same Value");
                } else if (line.equals("Done")) {
                    System.out.println("Done");
                } else if (line.startsWith("QRCODE")) {
                    System.out.println("it is a QR");
                    //jsonRead(line.substring(6));  // Remove "QRCODE" prefix and update text
                } else {
                    System.out.println("it is not a QR");
                    searchTxt.setText(line);
                }
                prv = line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_barcodeIconMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barcodeIcon;
    private javax.swing.JLabel iconLbl;
    private javax.swing.JTable inventoryTbl;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.PanelBorder panelBorder2;
    private com.zx.shopmanagementsystem.components.RoundedText searchTxt;
    // End of variables declaration//GEN-END:variables

    private void tableDataLoader() {
        productIdArray.clear();
        try {
            java.sql.ResultSet rs = DB.getdata("SELECT\n"
                    + "    p.product_id,\n"
                    + "    p.product_name,\n"
                    + "    p.reciving_price,\n"
                    + "    p.selling_price,\n"
                    + "    p.stock_quantity,\n"
                    + "    p.description,\n"
                    + "    p.brand,\n"
                    + "    p.dimensions,\n"
                    + "    p.manufacturing_date,\n"
                    + "    p.expiry_date,\n"
                    + "    p.supplier_id,\n"
                    + "    p.barcode_id,\n"
                    + "    p.category_id,\n"
                    + "    p.product_type_id,\n"
                    + "    p.discount_id,\n"
                    + "    p.store_location_id,\n"
                    + "    sl.store_location_name,\n"
                    + "    sl.store_location_description\n"
                    + "FROM\n"
                    + "    shopdb.product p\n"
                    + "JOIN\n"
                    + "    shopdb.store_location sl ON p.store_location_id = sl.store_location_id;");
            while (rs.next()) {
                int productId = (rs.getInt("product_id"));
                String productName = (rs.getString("product_name"));
                String recivingPrice = (rs.getString("reciving_price"));
                String sellingPrice = (rs.getString("selling_price"));
                String stockQuantitiy = (rs.getString("stock_quantity"));
                String manuDate = (rs.getString("manufacturing_date"));
                String expDate = (rs.getString("expiry_date"));
                String locationId = (rs.getString("store_location_name"));

//                System.out.println("Product : " + productId);
//                System.out.println("Product : " + productName);
//                System.out.println("Product : " + recivingPrice);
//                System.out.println("Product : " + sellingPrice);
//                System.out.println("Product : " + stockQuantitiy);
//                System.out.println("Product : " + manuDate);
//                System.out.println("Product : " + expDate);
//                System.out.println("Product : " + locationId);
                productIdArray.add(productId);
                String table_data[] = {productName, recivingPrice, sellingPrice, stockQuantitiy, manuDate, expDate, locationId};
                DefaultTableModel table = (DefaultTableModel) inventoryTbl.getModel();
                table.addRow(table_data);

            }
        } catch (Exception ex) {
            System.out.println("Supplier Management Table Data Loader : " + ex);
        }
    }

    private void tableDataClear() {
        try {
            while (0 <= inventoryTbl.getRowCount()) {
                DefaultTableModel table = (DefaultTableModel) inventoryTbl.getModel();
                table.removeRow(inventoryTbl.getRowCount() - 1);
            }
        } catch (Exception e) {
            System.out.println("Supplier Management Table Data Clear : " + e);
        }
    }

    private void findProductByNameOrBarcode(String searchTerm) {

        String query = "SELECT\n"
                + "    p.*,\n"
                + "    b.barcode_value,\n"
                + "    sl.store_location_id,\n"
                + "    sl.store_location_name,\n"
                + "    sl.store_location_description\n"
                + "FROM\n"
                + "    shopdb.product p\n"
                + "JOIN\n"
                + "    barcode b ON p.barcode_id = b.barcode_id\n"
                + "LEFT JOIN\n"
                + "    shopdb.store_location sl ON p.store_location_id = sl.store_location_id\n"
                + "WHERE\n"
                + "    p.product_name LIKE ? OR b.barcode_value = ?;";

        try (PreparedStatement pstmt = DB.con().prepareStatement(query)) {
            pstmt.setString(1, "%" + searchTerm + "%"); // Match partial product names
            pstmt.setString(2, searchTerm); // Match full barcode values
            ResultSet resultSet = pstmt.executeQuery();
            productIdArray.clear();
            tableDataClear();
            while (resultSet.next()) {
//                System.out.println(resultSet.getString("product_name"));
//                System.out.println(resultSet.getString("reciving_price"));
//                System.out.println(resultSet.getString("selling_price"));
//                System.out.println(resultSet.getString("stock_quantity"));
//                System.out.println(resultSet.getString("manufacturing_date"));
//                System.out.println(resultSet.getString("expiry_date"));
//                System.out.println(resultSet.getString("store_location_id"));
                int productId = (resultSet.getInt("product_id"));
                String productName = (resultSet.getString("product_name"));
                String recivingPrice = (resultSet.getString("reciving_price"));
                String sellingPrice = (resultSet.getString("selling_price"));
                String stockQuantitiy = (resultSet.getString("stock_quantity"));
                String manuDate = (resultSet.getString("manufacturing_date"));
                String expDate = (resultSet.getString("expiry_date"));
                String locationName = (resultSet.getString("store_location_name"));
                productIdArray.add(productId);
                String table_data[] = {productName, recivingPrice, sellingPrice, stockQuantitiy, manuDate, expDate, locationName};
                DefaultTableModel table = (DefaultTableModel) inventoryTbl.getModel();
                table.addRow(table_data);

                DB.con().close();
            }
        } catch (Exception ex) {
            Logger.getLogger(InventoryManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setTable() {
        tableDataClear();
        tableDataLoader();
    }

}
