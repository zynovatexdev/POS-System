/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.zx.shopmanagementsystem.ui;

import com.zx.shopmanagementsystem.assests.Func;
import com.zx.shopmanagementsystem.assests.IconLocation;
import com.zx.shopmanagementsystem.components.ScrollBarCustom;
import com.zx.shopmanagementsystem.dbconnection.JDBC;
import com.zx.shopmanagementsystem.forms.InventoryManagement;
import com.zx.shopmanagementsystem.notifications.ConfirmDialog;
import com.zx.shopmanagementsystem.notifications.MessageDialog;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class productDetails extends javax.swing.JFrame {

    /**
     * Creates new form AddProduct
     */
    Func func = new Func();
    IconLocation il = new IconLocation();
    JDBC DB = new JDBC();
    
    private InventoryManagement im;
    int ProductID;
    ArrayList<Integer> discountIdArray = new ArrayList<>();
    ArrayList<Integer> supplierIdArray = new ArrayList<>();
    ArrayList<Integer> categoryIdArray = new ArrayList<>();
    ArrayList<Integer> barcodeIdArray = new ArrayList<>();
    ArrayList<Integer> productTypeIdArray = new ArrayList<>();
    ArrayList<Integer> productLoactionIdArray = new ArrayList<>();
    
    public productDetails(InventoryManagement im) {
        this.im = im;
        initComponents();
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        Thread dataUpdateThread = new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(12345);  // Use an available port
                MessageDialog DialogBox = new MessageDialog(this);
                while (true) {
                    Socket socket = serverSocket.accept();
                    InputStream inputStream = socket.getInputStream();
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
                            
                            if (barcodeChecker(line)) {
                                barcodeCombo.setSelectedItem(line);
                            } else {
                                System.out.println("Barcode Not Found : Add Product");
                                DialogBox.showMessage("ERROR!!!", "Barcode Not Found in System\n Add Barcode First", 3);
                            }
                        }
                        prv = line;
                    }
                    
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        dataUpdateThread.start();
        head1.setFrame(this);
        setIconImage(Toolkit.getDefaultToolkit().getImage(il.logo));
        supplierComboLoader();
        categoryComboLoader();
        discountComboLoader();
        barcodeComboLoader();
        productTypeComboLoader();
        productLocationComboLoader();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        date1 = new com.zx.shopmanagementsystem.dateChooser.DateChooser();
        date2 = new com.zx.shopmanagementsystem.dateChooser.DateChooser();
        updateProductBtnLbl = new javax.swing.JLabel();
        head1 = new com.zx.shopmanagementsystem.components.Head();
        productIdLbl = new javax.swing.JLabel();
        sellingPriceTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        dimentionTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        stockQuantityTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        productNameTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        brandTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        manufactureDateTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        expireDateTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        recivingPriceTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        productLocationIdCombo = new com.zx.shopmanagementsystem.components.ComboBoxSuggestion();
        productTypeIdCombo = new com.zx.shopmanagementsystem.components.ComboBoxSuggestion();
        discountIdCombo = new com.zx.shopmanagementsystem.components.ComboBoxSuggestion();
        categoryIdCombo = new com.zx.shopmanagementsystem.components.ComboBoxSuggestion();
        supplierIdCombo = new com.zx.shopmanagementsystem.components.ComboBoxSuggestion();
        barcodeCombo = new com.zx.shopmanagementsystem.components.ComboBoxSuggestion();
        barcodeScannerLbl = new javax.swing.JLabel();
        panelBorder1 = new com.raven.swing.PanelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        productDescriptionTxt = new javax.swing.JTextArea();
        iconLbl = new javax.swing.JLabel();

        date1.setForeground(new java.awt.Color(204, 0, 255));
        date1.setDateFormat("yyyy-MM-dd");
        date1.setTextRefernce(manufactureDateTxt);

        date2.setForeground(new java.awt.Color(204, 0, 255));
        date2.setDateFormat("yyyy-MM-dd");
        date2.setTextRefernce(expireDateTxt);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        updateProductBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\UpdatePurpleIcon.png")); // NOI18N
        updateProductBtnLbl.setPreferredSize(new java.awt.Dimension(406, 56));
        updateProductBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateProductBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateProductBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateProductBtnLblMouseExited(evt);
            }
        });
        getContentPane().add(updateProductBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 630, 450, 60));

        head1.setHeaderTextColor("#000000");
        head1.setHeaderTitle("");
        head1.setOpaque(false);
        getContentPane().add(head1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        productIdLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        productIdLbl.setForeground(new java.awt.Color(255, 255, 255));
        productIdLbl.setText("0");
        getContentPane().add(productIdLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 102, 240, 20));

        sellingPriceTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        sellingPriceTxt.setPreferredSize(new java.awt.Dimension(139, 50));
        getContentPane().add(sellingPriceTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, 190, -1));

        dimentionTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        dimentionTxt.setPreferredSize(new java.awt.Dimension(139, 50));
        getContentPane().add(dimentionTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, 390, -1));

        stockQuantityTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        stockQuantityTxt.setPreferredSize(new java.awt.Dimension(139, 50));
        getContentPane().add(stockQuantityTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 550, 190, -1));

        productNameTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        productNameTxt.setPreferredSize(new java.awt.Dimension(139, 50));
        getContentPane().add(productNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 340, -1));

        brandTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        brandTxt.setPreferredSize(new java.awt.Dimension(139, 50));
        getContentPane().add(brandTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 550, 180, -1));

        manufactureDateTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        manufactureDateTxt.setPreferredSize(new java.awt.Dimension(139, 50));
        getContentPane().add(manufactureDateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, 190, -1));

        expireDateTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        expireDateTxt.setPreferredSize(new java.awt.Dimension(139, 50));
        getContentPane().add(expireDateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 230, 200, -1));

        recivingPriceTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        recivingPriceTxt.setPreferredSize(new java.awt.Dimension(139, 50));
        getContentPane().add(recivingPriceTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 180, -1));

        productLocationIdCombo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        productLocationIdCombo.setPreferredSize(new java.awt.Dimension(139, 50));
        getContentPane().add(productLocationIdCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 560, 190, -1));

        productTypeIdCombo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        productTypeIdCombo.setPreferredSize(new java.awt.Dimension(139, 50));
        getContentPane().add(productTypeIdCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 450, 190, -1));

        discountIdCombo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        discountIdCombo.setPreferredSize(new java.awt.Dimension(139, 50));
        getContentPane().add(discountIdCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 560, 190, -1));

        categoryIdCombo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        categoryIdCombo.setPreferredSize(new java.awt.Dimension(139, 50));
        getContentPane().add(categoryIdCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 450, 190, -1));

        supplierIdCombo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        supplierIdCombo.setPreferredSize(new java.awt.Dimension(139, 50));
        getContentPane().add(supplierIdCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 340, 190, -1));

        barcodeCombo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        barcodeCombo.setPreferredSize(new java.awt.Dimension(139, 50));
        getContentPane().add(barcodeCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 340, 190, -1));

        barcodeScannerLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\SearchBardcodeIcon.png")); // NOI18N
        getContentPane().add(barcodeScannerLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 350, 40, 40));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        productDescriptionTxt.setColumns(20);
        productDescriptionTxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        productDescriptionTxt.setRows(5);
        productDescriptionTxt.setBorder(null);
        jScrollPane1.setViewportView(productDescriptionTxt);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 330, -1));

        iconLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\images\\EditProduct.png")); // NOI18N
        getContentPane().add(iconLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void updateProductBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateProductBtnLblMouseClicked
        // TODO add your handling code here:
        updateProduct();
        im.setTable();
    }//GEN-LAST:event_updateProductBtnLblMouseClicked
    
    private void updateProductBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateProductBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(updateProductBtnLbl, il.updateWhiteIcon);
    }//GEN-LAST:event_updateProductBtnLblMouseEntered
    
    private void updateProductBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateProductBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(updateProductBtnLbl, il.UpdatePurpleIcon);
    }//GEN-LAST:event_updateProductBtnLblMouseExited

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
            java.util.logging.Logger.getLogger(productDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(productDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(productDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(productDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        InventoryManagement im = new InventoryManagement();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                productDetails pd = new productDetails(im);
                pd.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.zx.shopmanagementsystem.components.ComboBoxSuggestion barcodeCombo;
    private javax.swing.JLabel barcodeScannerLbl;
    private com.zx.shopmanagementsystem.components.RoundedText brandTxt;
    private com.zx.shopmanagementsystem.components.ComboBoxSuggestion categoryIdCombo;
    private com.zx.shopmanagementsystem.dateChooser.DateChooser date1;
    private com.zx.shopmanagementsystem.dateChooser.DateChooser date2;
    private com.zx.shopmanagementsystem.components.RoundedText dimentionTxt;
    private com.zx.shopmanagementsystem.components.ComboBoxSuggestion discountIdCombo;
    private com.zx.shopmanagementsystem.components.RoundedText expireDateTxt;
    private com.zx.shopmanagementsystem.components.Head head1;
    private javax.swing.JLabel iconLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private com.zx.shopmanagementsystem.components.RoundedText manufactureDateTxt;
    private com.raven.swing.PanelBorder panelBorder1;
    private javax.swing.JTextArea productDescriptionTxt;
    private javax.swing.JLabel productIdLbl;
    private com.zx.shopmanagementsystem.components.ComboBoxSuggestion productLocationIdCombo;
    private com.zx.shopmanagementsystem.components.RoundedText productNameTxt;
    private com.zx.shopmanagementsystem.components.ComboBoxSuggestion productTypeIdCombo;
    private com.zx.shopmanagementsystem.components.RoundedText recivingPriceTxt;
    private com.zx.shopmanagementsystem.components.RoundedText sellingPriceTxt;
    private com.zx.shopmanagementsystem.components.RoundedText stockQuantityTxt;
    private com.zx.shopmanagementsystem.components.ComboBoxSuggestion supplierIdCombo;
    private javax.swing.JLabel updateProductBtnLbl;
    // End of variables declaration//GEN-END:variables

    private void updateProduct() {
        MessageDialog DialogBox = new MessageDialog(this);
        String productName = productNameTxt.getText();
        String recivingPrice = recivingPriceTxt.getText();
        String sellingPrice = sellingPriceTxt.getText();
        String stockQuantity = stockQuantityTxt.getText();
        String description = productDescriptionTxt.getText();
        String brand = brandTxt.getText();
        String dimention = dimentionTxt.getText();
        String manufactureDate = manufactureDateTxt.getText();
        String expDate = expireDateTxt.getText();
        int supplierId = supplierIdArray.get(supplierIdCombo.getSelectedIndex());
        int barcodeValue = barcodeIdArray.get(barcodeCombo.getSelectedIndex());
        int categoryId = categoryIdArray.get(categoryIdCombo.getSelectedIndex());
        int typeId = productTypeIdArray.get(productTypeIdCombo.getSelectedIndex());
        int discoundId = discountIdArray.get(discountIdCombo.getSelectedIndex());
        int locationId = productLoactionIdArray.get(productLocationIdCombo.getSelectedIndex());
        
        if (productName.equals("")) {
            System.out.println("Product Name Empty");
            DialogBox.showMessage("WARNING!!!", "Product Name Empty", 2);
        } else if (recivingPrice.equals("")) {
            System.out.println("Reciving Price Empty");
            DialogBox.showMessage("WARNING!!!", "Reciving Price Empty", 2);
        } else if (sellingPrice.equals("")) {
            System.out.println("Selling Price Empty");
            DialogBox.showMessage("WARNING!!!", "Selling Price Empty", 2);
        } else if (stockQuantity.equals("")) {
            System.out.println("Stock Quantity Empty");
            DialogBox.showMessage("WARNING!!!", "Stock Quantity Empty", 2);
        } else {
            if (manufactureDate.equals("") || expDate.equals("")) {
                System.out.println("Date Empty");
                try {
                    PreparedStatement pst = DB.con().prepareStatement("UPDATE product SET product_name = ?, reciving_price = ?, selling_price = ?, stock_quantity = ?, description = ?, brand = ?, dimensions = ?, manufacturing_date = ?, expiry_date = ?, supplier_id = ?, barcode_id = ?, category_id = ?, product_type_id = ?, discount_id = ?, store_location_id = ? WHERE product_id = ?");
                    pst.setString(1, productName);
                    pst.setString(2, recivingPrice);
                    pst.setString(3, sellingPrice);
                    pst.setString(4, stockQuantity);
                    pst.setString(5, description);
                    pst.setString(6, brand);
                    pst.setString(7, dimention);
                    pst.setString(8, manufactureDate);
                    pst.setString(9, expDate);
                    pst.setInt(10, supplierId);
                    pst.setInt(11, barcodeValue);
                    pst.setInt(12, categoryId);
                    pst.setInt(13, typeId);
                    pst.setInt(14, discoundId);
                    pst.setInt(15, locationId);
                    pst.setInt(16, ProductID); // Set the ProductID as the last parameter
                    // Execute the update query
                    int rowsUpdated = pst.executeUpdate();
                    
                    if (rowsUpdated > 0) {
                        System.out.println("Update successful");
                        String code = "{\"barcode\":\"" + barcodeCombo.getSelectedItem() + "\"}";
                        func.QRGenerator(code, productName);
                        DialogBox.showMessage("Saved", "Update successful\nQR Code Updated.", 1);
                        DB.con().close();
                    } else {
                        System.out.println("Update failed");
                    }
                    
                } catch (Exception ex) {
                    System.out.println("Data Save Without Date : " + ex.getMessage());
                }
            } else {
                ConfirmDialog confrim = new ConfirmDialog(this);
                confrim.showMessage("Delete", "Do you want to Delete ?");
                if (confrim.getMessageType() == ConfirmDialog.MessageType.YES) {
                    System.out.println("Yes");
                    if ((manufacDateVali(manufactureDate))) {
                        System.out.println("Manufacture Date Not Valid");
                        DialogBox.showMessage("WARNING!!!", "Manufacture Date Not Valid", 2);
                    } else {
                        if (expDateVali(manufactureDate, expDate)) {
                            System.out.println("Date Valid");
                            try {
                                PreparedStatement pst = DB.con().prepareStatement("UPDATE product SET product_name = ?, reciving_price = ?, selling_price = ?, stock_quantity = ?, description = ?, brand = ?, dimensions = ?, manufacturing_date = ?, expiry_date = ?, supplier_id = ?, barcode_id = ?, category_id = ?, product_type_id = ?, discount_id = ?, store_location_id = ? WHERE product_id = ?");
                                pst.setString(1, productName);
                                pst.setString(2, recivingPrice);
                                pst.setString(3, sellingPrice);
                                pst.setString(4, stockQuantity);
                                pst.setString(5, description);
                                pst.setString(6, brand);
                                pst.setString(7, dimention);
                                pst.setString(8, manufactureDate);
                                pst.setString(9, expDate);
                                pst.setInt(10, supplierId);
                                pst.setInt(11, barcodeValue);
                                pst.setInt(12, categoryId);
                                pst.setInt(13, typeId);
                                pst.setInt(14, discoundId);
                                pst.setInt(15, locationId);
                                pst.setInt(16, ProductID); // Set the ProductID as the last parameter
                                // Execute the update query
                                int rowsUpdated = pst.executeUpdate();
                                
                                if (rowsUpdated > 0) {
                                    System.out.println("Update successful");
                                    String code = "{\"barcode\":\"" + barcodeCombo.getSelectedItem() + "\"}";
                                    func.QRGenerator(code, productName);
                                    DialogBox.showMessage("Saved", "Update successful\nQR Code Updated.", 1);
                                    DB.con().close();
                                } else {
                                    System.out.println("Update failed");
                                }
                                
                            } catch (Exception ex) {
                                System.out.println("Data Save With Date : " + ex.getMessage());
                            }
                            
                        } else {
                            System.out.println("Expire Date Not Valid");
                            DialogBox.showMessage("WARNING!!!", "Expire Date Not Valid", 2);
                        }
                    }
                } else {
                    System.out.println("No");
                }
            }
            
        }
    }
    
    public void dataLoad(int productId) {
        this.ProductID = productId;
        try {
            //System.out.println("Product ID : " + productId);
            ResultSet rs = DB.getdata("SELECT * FROM product WHERE product_id = '" + productId + "'");
            while (rs.next()) {
                String productName = (rs.getString("product_name"));
                String recivingPrice = (rs.getString("reciving_price"));
                String sellingPrice = (rs.getString("selling_price"));
                String stockQuantitiy = (rs.getString("stock_quantity"));
                String manuDate = (rs.getString("manufacturing_date"));
                String expDate = (rs.getString("expiry_date"));
                int locationId = (rs.getInt("store_location_id"));
                String description = (rs.getString("description"));
                String brand = (rs.getString("brand"));
                String dimentions = (rs.getString("dimensions"));
                int supId = (rs.getInt("supplier_id"));
                int barcodeId = (rs.getInt("barcode_id"));
                int caregoryId = (rs.getInt("category_id"));
                int Typeid = (rs.getInt("product_type_id"));
                int discountid = (rs.getInt("discount_id"));
                
                productIdLbl.setText(String.valueOf(productId));
                productNameTxt.setText(productName);
                productDescriptionTxt.setText(description);
                recivingPriceTxt.setText(recivingPrice);
                sellingPriceTxt.setText(sellingPrice);
                brandTxt.setText(brand);
                stockQuantityTxt.setText(stockQuantitiy);
                dimentionTxt.setText(dimentions);
                manufactureDateTxt.setText(manuDate);
                expireDateTxt.setText(expDate);
                supplierIdCombo.setSelectedIndex(supplierIdArray.indexOf(supId));
                barcodeCombo.setSelectedIndex(barcodeIdArray.indexOf(barcodeId));
                categoryIdCombo.setSelectedIndex(categoryIdArray.indexOf(caregoryId));
                productTypeIdCombo.setSelectedIndex(productTypeIdArray.indexOf(Typeid));
                discountIdCombo.setSelectedIndex(discountIdArray.indexOf(discountid));
                productLocationIdCombo.setSelectedIndex(productLoactionIdArray.indexOf(locationId));
            }
            
        } catch (Exception ex) {
            System.out.println("Product Details -> DataLoad : " + ex.getMessage());
        }
    }
    
    private void supplierComboLoader() {
        try {
            ResultSet rs = DB.getdata("SELECT * FROM supplier");
            while (rs.next()) {
                String supplierName = rs.getString("supplier_name");
                int supplierId = rs.getInt("supplier_id");
                supplierIdCombo.addItem(supplierName);
                supplierIdArray.add(supplierId);
            }
        } catch (Exception ex) {
            System.out.println("Supplier Combo Loader : " + ex);
        }
    }
    
    private void categoryComboLoader() {
        try {
            ResultSet rs = DB.getdata("SELECT * FROM product_category");
            while (rs.next()) {
                String supplierName = rs.getString("category_name");
                int categoryId = rs.getInt("category_id");
                categoryIdCombo.addItem(supplierName);
                categoryIdArray.add(categoryId);
            }
        } catch (Exception ex) {
            System.out.println("Product Category Combo Loader : " + ex);
        }
    }
    
    private void discountComboLoader() {
        try {
            ResultSet rs = DB.getdata("SELECT * FROM discont");
            while (rs.next()) {
                String supplierName = rs.getString("discount_presentage");
                String endDate = rs.getString("end_date");
                int disId = rs.getInt("discount_id");
                System.out.println(endDate);
                if (func.dateValidator(endDate) == 1) {
                    discountIdCombo.addItem(supplierName + "%");
                    discountIdArray.add(disId);
                } else {
                    System.out.println("Day Before");
                }
                
            }
        } catch (Exception ex) {
            System.out.println("Discount Combo Loader : " + ex);
        }
    }
    
    private void barcodeComboLoader() {
        try {
            ResultSet rs = DB.getdata("SELECT * FROM barcode");
            while (rs.next()) {
                String barcodeValue = rs.getString("barcode_value");
                int barcodeId = rs.getInt("barcode_id");
                barcodeCombo.addItem(barcodeValue);
                barcodeIdArray.add(barcodeId);
            }
        } catch (Exception ex) {
            System.out.println("Barcode Combo Loader : " + ex);
        }
    }
    
    private void productTypeComboLoader() {
        try {
            ResultSet rs = DB.getdata("SELECT * FROM product_type");
            while (rs.next()) {
                String productType = rs.getString("product_type");
                int typeId = rs.getInt("product_type_id");
                productTypeIdCombo.addItem(productType);
                productTypeIdArray.add(typeId);
            }
        } catch (Exception ex) {
            System.out.println("Product Type Combo Loader : " + ex);
        }
    }
    
    private void productLocationComboLoader() {
        try {
            ResultSet rs = DB.getdata("SELECT * FROM store_location");
            while (rs.next()) {
                String storeLocation = rs.getString("store_location_name");
                int locationId = rs.getInt("store_location_id");
                productLocationIdCombo.addItem(storeLocation);
                productLoactionIdArray.add(locationId);
            }
        } catch (Exception ex) {
            System.out.println("Product Type Combo Loader : " + ex);
        }
    }
    
    private boolean barcodeChecker(String barcode) {
        String sql = "SELECT * FROM barcode WHERE barcode_value=?";
        boolean Exist = false;
        try {
            PreparedStatement pstmt = DB.con().prepareStatement(sql);
            pstmt.setString(1, barcode);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                System.out.println("Barcode Found.");
                Exist = true;
            } else {
                System.out.println("Barcode Not Found.");
                Exist = false;
            }
        } catch (Exception ex) {
            System.out.println("Barcode Checker : " + ex.getMessage());
        }
        return Exist;
    }
    
    private boolean manufacDateVali(String manuDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date(); // Current date
        String manufactureDateStr = manuDate;
        boolean date = false;
        try {
            Date manufactureDate = sdf.parse(manufactureDateStr);
            Date validStartDate = currentDate;
            
            date = !manufactureDate.before(validStartDate);
            //System.out.println("Manufacture date is valid.");
            //System.out.println("Manufacture date is not valid.");
        } catch (ParseException ex) {
            System.out.println("Manu date validator : " + ex.getMessage());
        }
        return date;
    }
    
    private boolean expDateVali(String manuDate, String expireDateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date(); // Current date
        String manufactureDateStr = manuDate;
        String expirationDateStr = expireDateStr;
        boolean date = false;
        try {
            Date manufactureDate = sdf.parse(manufactureDateStr);
            Date expirationDate = sdf.parse(expirationDateStr);
            Date validStartDate = currentDate;
            
            date = expirationDate.after(manufactureDate) && expirationDate.after(validStartDate);
            //System.out.println("Expiration date is valid.");
            //System.out.println("Expiration date is not valid.");
        } catch (ParseException ex) {
            System.out.println("Exp date validator : " + ex.getMessage());
        }
        return date;
    }
}
