/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.zx.shopmanagementsystem.ui;

import com.google.cloud.ByteArray;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.zx.shopmanagementsystem.assests.Func;
import com.zx.shopmanagementsystem.assests.IconLocation;
import com.zx.shopmanagementsystem.dbconnection.JDBC;
import com.zx.shopmanagementsystem.notifications.MessageDialog;
import com.zx.shopmanagementsystem.notifications.Payment;
import com.zx.shopmanagementsystem.print.ReportManager;
import com.zx.shopmanagementsystem.print.model.FieldReportPayment;
import com.zx.shopmanagementsystem.print.model.ParameterReportPayment;
import com.zx.shopmanagementsystem.table.DeleteButtonEditorRenderer;
import com.zx.shopmanagementsystem.table.TableCustom;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author User
 */
public class NewInvoice extends javax.swing.JFrame {

    /**
     * Creates new form NewInvoice
     */
    JDBC DB = new JDBC();
    IconLocation il = new IconLocation();
    Func func = new Func();

    ArrayList<Integer> productIdArray = new ArrayList<>();
    ArrayList<Integer> customerIdArray = new ArrayList<>();
    double payment = 0;
    int paymentMethodId = 0;

    int UserID;
    String time;
    String date;

    public NewInvoice() {
        initComponents();
        readUserIdFromFile();
        setIconImage(Toolkit.getDefaultToolkit().getImage(il.logo));
        productComboLoader();
        customerComboLoader();
        onlyNumbers(priceTxt);
        onlyNumbers(quantityTxt);
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
                                System.out.println("Barcode Found");
                                getItemDetails();
                            } else {
                                System.out.println("Barcode Not Found : New Invoice");
                                DialogBox.showMessage("ERROR!!!", "Barcode Not Found in System", 3);
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
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);

        clear();
        tableDataClear();
        invoiceTbl.getColumnModel().getColumn(4).setCellRenderer(new DeleteButtonEditorRenderer());
        invoiceTbl.getColumnModel().getColumn(4).setCellEditor(new DeleteButtonEditorRenderer());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        invoiceCategoryCombo = new com.zx.shopmanagementsystem.components.ComboBoxSuggestion();
        batcodeIconLbl = new javax.swing.JLabel();
        productNameCombo = new com.zx.shopmanagementsystem.components.ComboBoxSuggestion();
        customerCombo = new com.zx.shopmanagementsystem.components.ComboBoxSuggestion();
        quantityTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        discountSpinner = new com.zx.shopmanagementsystem.components.Spinner();
        head1 = new com.zx.shopmanagementsystem.components.Head();
        priceTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        paymentBtn = new javax.swing.JLabel();
        addInvoiceBtn = new javax.swing.JLabel();
        clearBtn = new javax.swing.JLabel();
        priceLbl = new javax.swing.JLabel();
        editPriceLbl = new javax.swing.JLabel();
        selectBtnIcon = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoiceTbl = new javax.swing.JTable();
        imageLbl = new javax.swing.JLabel();
        idLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        invoiceCategoryCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Regular", "Retail" }));
        invoiceCategoryCombo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        invoiceCategoryCombo.setPreferredSize(new java.awt.Dimension(163, 50));
        invoiceCategoryCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                invoiceCategoryComboItemStateChanged(evt);
            }
        });
        invoiceCategoryCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invoiceCategoryComboMouseClicked(evt);
            }
        });
        invoiceCategoryCombo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                invoiceCategoryComboPropertyChange(evt);
            }
        });
        invoiceCategoryCombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                invoiceCategoryComboKeyPressed(evt);
            }
        });
        getContentPane().add(invoiceCategoryCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 300, 40));

        batcodeIconLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\SearchBardcodeIcon.png")); // NOI18N
        batcodeIconLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        batcodeIconLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                batcodeIconLblMouseClicked(evt);
            }
        });
        getContentPane().add(batcodeIconLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, 40, 40));

        productNameCombo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        productNameCombo.setPreferredSize(new java.awt.Dimension(163, 50));
        productNameCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                productNameComboItemStateChanged(evt);
            }
        });
        productNameCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productNameComboMouseClicked(evt);
            }
        });
        productNameCombo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                productNameComboPropertyChange(evt);
            }
        });
        productNameCombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                productNameComboKeyPressed(evt);
            }
        });
        getContentPane().add(productNameCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 300, 40));

        customerCombo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        customerCombo.setPreferredSize(new java.awt.Dimension(163, 50));
        customerCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerComboActionPerformed(evt);
            }
        });
        getContentPane().add(customerCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 300, 40));

        quantityTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        quantityTxt.setHintText("Enter Quantity");
        quantityTxt.setPreferredSize(new java.awt.Dimension(300, 50));
        quantityTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityTxtActionPerformed(evt);
            }
        });
        getContentPane().add(quantityTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, 180, 40));

        discountSpinner.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        discountSpinner.setPreferredSize(new java.awt.Dimension(65, 50));
        discountSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                discountSpinnerStateChanged(evt);
            }
        });
        discountSpinner.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                discountSpinnerMouseClicked(evt);
            }
        });
        discountSpinner.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                discountSpinnerInputMethodTextChanged(evt);
            }
        });
        discountSpinner.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                discountSpinnerPropertyChange(evt);
            }
        });
        discountSpinner.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                discountSpinnerVetoableChange(evt);
            }
        });
        getContentPane().add(discountSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 470, 180, 40));

        head1.setHeaderTitle("");
        head1.setOpaque(false);
        getContentPane().add(head1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        priceTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        priceTxt.setHintText("Enter Price");
        priceTxt.setPreferredSize(new java.awt.Dimension(300, 50));
        getContentPane().add(priceTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 550, 300, 40));

        paymentBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        paymentBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paymentBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paymentBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paymentBtnMouseExited(evt);
            }
        });
        getContentPane().add(paymentBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 610, 200, 40));

        addInvoiceBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addInvoiceBtn.setPreferredSize(new java.awt.Dimension(217, 49));
        addInvoiceBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addInvoiceBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addInvoiceBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addInvoiceBtnMouseExited(evt);
            }
        });
        getContentPane().add(addInvoiceBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(577, 610, 200, 40));

        clearBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearBtnMouseExited(evt);
            }
        });
        getContentPane().add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 605, 200, 50));

        priceLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        priceLbl.setForeground(new java.awt.Color(0, 51, 204));
        priceLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        priceLbl.setText("10000/=");
        getContentPane().add(priceLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 610, 140, 40));

        editPriceLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editPriceLbl.setForeground(new java.awt.Color(0, 51, 102));
        editPriceLbl.setText("Edit Price");
        editPriceLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editPriceLblMouseClicked(evt);
            }
        });
        getContentPane().add(editPriceLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 555, 70, -1));

        selectBtnIcon.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\SelectIcon.png")); // NOI18N
        selectBtnIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectBtnIconMouseClicked(evt);
            }
        });
        getContentPane().add(selectBtnIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, -1, 30));

        invoiceTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Product Name", "Quantitiy", "Price", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        invoiceTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invoiceTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(invoiceTbl);
        if (invoiceTbl.getColumnModel().getColumnCount() > 0) {
            invoiceTbl.getColumnModel().getColumn(0).setResizable(false);
            invoiceTbl.getColumnModel().getColumn(0).setPreferredWidth(1);
            invoiceTbl.getColumnModel().getColumn(4).setResizable(false);
            invoiceTbl.getColumnModel().getColumn(4).setPreferredWidth(3);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 157, 630, 410));

        imageLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\images\\AddNewInvoiceScreen.png")); // NOI18N
        getContentPane().add(imageLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        idLbl.setText("jLabel1");
        getContentPane().add(idLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 610, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void quantityTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityTxtActionPerformed

    private void discountSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_discountSpinnerStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_discountSpinnerStateChanged

    private void discountSpinnerPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_discountSpinnerPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_discountSpinnerPropertyChange

    private void discountSpinnerInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_discountSpinnerInputMethodTextChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_discountSpinnerInputMethodTextChanged

    private void discountSpinnerVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_discountSpinnerVetoableChange
        // TODO add your handling code here:

    }//GEN-LAST:event_discountSpinnerVetoableChange

    private void discountSpinnerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_discountSpinnerMouseClicked
        // TODO add your handling code here:
        System.out.println(discountSpinner.getLabelText());
    }//GEN-LAST:event_discountSpinnerMouseClicked

    private void clearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBtnMouseClicked
        // TODO add your handling code here:
        //clear();

    }//GEN-LAST:event_clearBtnMouseClicked

    private void invoiceTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceTblMouseClicked
        // TODO add your handling code here
        int selectedRow = invoiceTbl.getSelectedRow();
        int selectedColumn = invoiceTbl.getSelectedColumn();

        if (selectedRow != -1 && selectedColumn == 4) { // Check if the "Delete" button column is clicked
            DefaultTableModel model = (DefaultTableModel) invoiceTbl.getModel();
            model.removeRow(selectedRow);
            updateIndexNumbers(model); // Update the index numbers
            model.fireTableDataChanged();
            updatePriceLabel();
        }
    }//GEN-LAST:event_invoiceTblMouseClicked

    private void addInvoiceBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addInvoiceBtnMouseClicked
        // TODO add your handling code here:
        MessageDialog DialogBox = new MessageDialog(this);
        DefaultTableModel model = (DefaultTableModel) invoiceTbl.getModel();
        if (quantityTxt.getText().equals("")) {
            System.out.println("Quantitiy Empty");
            DialogBox.showMessage("WARNING", "Enter Quantitiy", 2);
        } else if (priceTxt.getText().equals("")) {
            System.out.println("Price Empty");
            DialogBox.showMessage("ERROR!!!", "Please !!! Enter Price", 3);
        } else {
            double quantity = Double.parseDouble(quantityTxt.getText());
            double price = Double.parseDouble(priceTxt.getText());
            String name = (String) productNameCombo.getSelectedItem();
            if (model.getRowCount() == 0) {
                if (getAvailableQuantityFromDatabase(name) < quantity) {
                    System.out.println("High");
                    DialogBox.showMessage("Error", "Quantity for product " + name + " \nexceeds available quantity.", 3);
                } else {
                    tableDataLoader(name, String.valueOf(quantity), String.valueOf(price * quantity));
                    updatePriceLabel();
                }
            } else {
                if (checkQuantities()) {
                    DialogBox.showMessage("Error", "Quantity for product " + name + " \nexceeds available quantity.", 3);
                } else {
                    tableDataLoader(name, String.valueOf(quantity), String.valueOf(price * quantity));
                    updatePriceLabel();
                }

            }

        }
    }//GEN-LAST:event_addInvoiceBtnMouseClicked

    private void batcodeIconLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_batcodeIconLblMouseClicked
        // TODO add your handling code here:
        String pythonScript = "C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\barcode_Python\\abc.py";
        try {
            Runtime.getRuntime().exec("python " + pythonScript);
        } catch (IOException ex) {
            System.out.println("Barcode Detector Btn : " + ex.getMessage());
        }
    }//GEN-LAST:event_batcodeIconLblMouseClicked

    private void productNameComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productNameComboMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_productNameComboMouseClicked

    private void productNameComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_productNameComboItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_productNameComboItemStateChanged

    private void productNameComboPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_productNameComboPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_productNameComboPropertyChange

    private void productNameComboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productNameComboKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_productNameComboKeyPressed

    private void selectBtnIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectBtnIconMouseClicked
        // TODO add your handling code here:
        getItemDetails();
    }//GEN-LAST:event_selectBtnIconMouseClicked

    private void editPriceLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editPriceLblMouseClicked
        // TODO add your handling code here:
        priceTxt.setEditable(true);
    }//GEN-LAST:event_editPriceLblMouseClicked

    private void addInvoiceBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addInvoiceBtnMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_addInvoiceBtnMouseEntered

    private void addInvoiceBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addInvoiceBtnMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_addInvoiceBtnMouseExited

    private void clearBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBtnMouseEntered
        // TODO add your handling code here:
        // func.iconSetter(clearBtn, il.ClearDetails2Icon);
    }//GEN-LAST:event_clearBtnMouseEntered

    private void clearBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBtnMouseExited
        // TODO add your handling code here:
        //func.iconSetter(clearBtn, il.ClearDetails1Icon);
    }//GEN-LAST:event_clearBtnMouseExited

    private void paymentBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentBtnMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_paymentBtnMouseEntered

    private void paymentBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentBtnMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_paymentBtnMouseExited

    private void paymentBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentBtnMouseClicked
        // TODO add your handling code here:
        // Get the JSON data
        MessageDialog DialogBox = new MessageDialog(this);
        DefaultTableModel model = (DefaultTableModel) invoiceTbl.getModel();

        JSONObject invoiceData = collectInvoiceData();
        String totalPriceStr = invoiceData.getString("TotalPrice");

        // Clean the TotalPrice string to remove non-numeric characters
        totalPriceStr = totalPriceStr.replaceAll("[^\\d.]", "");

        double totalPrice = Double.parseDouble(totalPriceStr);

        Payment pay = new Payment(this);
        pay.showMessage(totalPrice);

        if (pay.getMessageType() == Payment.MessageType.YES) {
            System.out.println("Yes");
            try {
                payment = Double.parseDouble(pay.getPaymentValue());
                paymentMethodId = pay.getPaymentMethodId();
                System.out.println("payid : " + paymentMethodId);
                System.out.println("pay : " + payment);
            } catch (NumberFormatException e) {
                System.err.println("Invalid number format: " + e.getMessage());
            }

            if (totalPrice > payment) {
                System.out.println("Not Enough");
                DialogBox.showMessage("ERROR !!!", "Payment Not Enough For Pay", 3);
            } else {
                double balance = payment - totalPrice;
                String balancePrice = String.format("%.2f", balance);
                generateInvoiceBill(invoiceData, balancePrice);
                generateBill(invoiceData);
                DialogBox.showMessage("Payment Successfull !!!", "Payment Successfull\nGive Balance : " + balancePrice, 1);
                updateStockAndCalculateProfit(model);
                clear();
                tableDataClear();

            }
        } else {
            System.out.println("No");
        }
    }//GEN-LAST:event_paymentBtnMouseClicked

    private void customerComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerComboActionPerformed

    private void invoiceCategoryComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_invoiceCategoryComboItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_invoiceCategoryComboItemStateChanged

    private void invoiceCategoryComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceCategoryComboMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_invoiceCategoryComboMouseClicked

    private void invoiceCategoryComboPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_invoiceCategoryComboPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_invoiceCategoryComboPropertyChange

    private void invoiceCategoryComboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_invoiceCategoryComboKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_invoiceCategoryComboKeyPressed

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
            java.util.logging.Logger.getLogger(NewInvoice.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewInvoice.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewInvoice.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewInvoice.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new NewInvoice().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addInvoiceBtn;
    private javax.swing.JLabel batcodeIconLbl;
    private javax.swing.JLabel clearBtn;
    private com.zx.shopmanagementsystem.components.ComboBoxSuggestion customerCombo;
    private com.zx.shopmanagementsystem.components.Spinner discountSpinner;
    private javax.swing.JLabel editPriceLbl;
    private com.zx.shopmanagementsystem.components.Head head1;
    private javax.swing.JLabel idLbl;
    private javax.swing.JLabel imageLbl;
    private com.zx.shopmanagementsystem.components.ComboBoxSuggestion invoiceCategoryCombo;
    private javax.swing.JTable invoiceTbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel paymentBtn;
    private javax.swing.JLabel priceLbl;
    private com.zx.shopmanagementsystem.components.RoundedText priceTxt;
    private com.zx.shopmanagementsystem.components.ComboBoxSuggestion productNameCombo;
    private com.zx.shopmanagementsystem.components.RoundedText quantityTxt;
    private javax.swing.JLabel selectBtnIcon;
    // End of variables declaration//GEN-END:variables

    private void customerComboLoader() {
        try {
            ResultSet rs = DB.getdata("SELECT * FROM customer");
            while (rs.next()) {
                String customerName = rs.getString("customer_name");
                int customerId = rs.getInt("customer_id");
                System.out.println("Customer ID : " + customerId);
                customerCombo.addItem(customerName);
                customerIdArray.add(customerId);
            }
        } catch (Exception ex) {
            System.out.println("Customer Combo Loader : " + ex);
        }
    }

    private void productComboLoader() {
        try {
            ResultSet rs = DB.getdata("SELECT * FROM product");
            productIdArray.clear(); // Clear the array before adding new elements
            while (rs.next()) {
                String customerName = rs.getString("product_name");
                int productId = rs.getInt("product_id");
                productNameCombo.addItem(customerName);
                productIdArray.add(productId);
            }
        } catch (Exception ex) {
            System.out.println("Product Combo Loader: " + ex);
        }
    }

    private void clear() {
        //customerCombo.setSelectedIndex(0);
        productNameCombo.setSelectedIndex(0);
        quantityTxt.setText("");
        discountSpinner.setLabelText("0");
        priceTxt.setText("");
        priceTxt.setEditable(false);
        priceLbl.setText("0.00/=");
    }

    private void tableDataLoader(String name, String quantity, String price) {
        DefaultTableModel model = (DefaultTableModel) invoiceTbl.getModel();
        int discount = (int) (discountSpinner.getValue());

        double discountedPrice;
        if (discount == 0) {
            discountedPrice = Double.parseDouble(price);
        } else {
            double discountAmount = (discount / 100.0) * Double.parseDouble(price);
            discountedPrice = Double.parseDouble(price) - discountAmount;
        }

        model.addRow(new Object[]{model.getRowCount() + 1, name, quantity, discountedPrice}); // Add a new row with the updated index number
        updateIndexNumbers(model); // Update the index numbers
        model.fireTableDataChanged();

    }

    private void tableDataClear() {
        try {
            while (0 <= invoiceTbl.getRowCount()) {
                DefaultTableModel table = (DefaultTableModel) invoiceTbl.getModel();
                table.removeRow(invoiceTbl.getRowCount() - 1);
            }
        } catch (Exception e) {
            System.out.println("New Invoice Table Data Clear : " + e);
        }

    }

    private void updateIndexNumbers(DefaultTableModel model) {
        for (int row = 0; row < model.getRowCount(); row++) {
            model.setValueAt(row + 1, row, 0); // Update the first column with the new index number
        }
    }

    private boolean barcodeChecker(String barcode) {
        String sql = "SELECT p.* "
                + "FROM product p "
                + "JOIN barcode b ON p.barcode_id = b.barcode_id "
                + "WHERE b.barcode_value = ?";
        boolean Exist = false;
        try {
            PreparedStatement pstmt = JDBC.con().prepareStatement(sql);
            pstmt.setString(1, barcode);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                //System.out.println("Barcode Found.");
                Exist = true;
                productNameCombo.setSelectedItem(resultSet.getString("product_name"));
            } else {
                //System.out.println("Barcode Not Found.");
                Exist = false;
            }
        } catch (Exception ex) {
            System.out.println("Barcode Checker : " + ex.getMessage());
        }
        return Exist;
    }

    private void getItemDetails() {
        int id = productIdArray.get(productNameCombo.getSelectedIndex());
        try {
            ResultSet rs = DB.getdata("SELECT * FROM product WHERE product_id = '" + id + "'");
            if (rs.next()) {
                priceTxt.setText(rs.getString("selling_price"));

            }
        } catch (Exception ex) {
            Logger.getLogger(NewInvoice.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void onlyNumbers(com.zx.shopmanagementsystem.components.RoundedText text) {
        PlainDocument doc = (PlainDocument) text.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            private final Pattern pattern = Pattern.compile("\\d*");

            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                Matcher matcher = pattern.matcher(string);
                if (!matcher.matches()) {
                    return;
                }
                super.insertString(fb, offset, string, attr);
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                Matcher matcher = pattern.matcher(text);
                if (!matcher.matches()) {
                    return;
                }
                super.replace(fb, offset, length, text, attrs);
            }
        });
    }

    private Map<String, Double> calculateTotalQuantities(DefaultTableModel model) {
        Map<String, Double> totalQuantities = new HashMap<>();
        for (int row = 0; row < model.getRowCount(); row++) {
            String productName = model.getValueAt(row, 1).toString(); // Assuming the product name is in the second column
            double quantity = Double.parseDouble(model.getValueAt(row, 2).toString()); // Assuming the quantity is in the third column

            if (totalQuantities.containsKey(productName)) {
                double currentTotal = totalQuantities.get(productName);
                totalQuantities.put(productName, currentTotal + quantity);
            } else {
                totalQuantities.put(productName, quantity);
            }
        }
        return totalQuantities;
    }

    private boolean checkQuantities() {
        boolean value = false;
        DefaultTableModel model = (DefaultTableModel) invoiceTbl.getModel();
        Map<String, Double> totalQuantities = calculateTotalQuantities(model);

        for (Map.Entry<String, Double> entry : totalQuantities.entrySet()) {
            String productName = entry.getKey();
            double totalQuantity = entry.getValue();

            // Query the database to get the available quantity for this product
            int availableQuantity = getAvailableQuantityFromDatabase(productName);

            if (totalQuantity > availableQuantity) {
                // Show an error message indicating that the quantity exceeds the available quantity
                // You can use a MessageDialog or any other method you prefer.
                value = true;
            } else {
                value = availableQuantity - totalQuantity < Double.parseDouble(quantityTxt.getText());
            }
        }
        return value;
    }

    private int getAvailableQuantityFromDatabase(String productName) {
        int availableQuantity = 0;
        try {

            // Query the database to get the available quantity for the product with the given name
            // Set the result to the availableQuantity variable
            // You can use your JDBC class to execute this query and retrieve the value from the database.
            // Example:
            ResultSet rs = DB.getdata("SELECT stock_quantity FROM product WHERE product_name = '" + productName + "'");
            if (rs.next()) {
                availableQuantity = rs.getInt("stock_quantity");

            }

        } catch (Exception ex) {
            Logger.getLogger(NewInvoice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return availableQuantity;
    }

    private void updatePriceLabel() {
        DefaultTableModel model = (DefaultTableModel) invoiceTbl.getModel();
        double totalPrice = 0.0;

        for (int row = 0; row < model.getRowCount(); row++) {
            //double quantity = Double.parseDouble(model.getValueAt(row, 2).toString());
            double price = Double.parseDouble(model.getValueAt(row, 3).toString());
            totalPrice += (price);
        }

        priceLbl.setText(String.format("%.2f/=", totalPrice));
    }

    private JSONObject collectInvoiceData() {
        DefaultTableModel model = (DefaultTableModel) invoiceTbl.getModel();
        JSONArray invoiceItems = new JSONArray();

        for (int row = 0; row < model.getRowCount(); row++) {
            String productName = (String) model.getValueAt(row, 1);
            String quantity = (String) model.getValueAt(row, 2);
            Double priceValue = (Double) model.getValueAt(row, 3);
            String price = priceValue.toString();

            JSONObject item = new JSONObject();
            item.put("ProductName", productName);
            item.put("Quantity", quantity);
            item.put("Price", price);

            invoiceItems.put(item);
        }

        JSONObject invoiceData = new JSONObject();
        invoiceData.put("Customer Name", customerCombo.getSelectedItem());
        invoiceData.put("InvoiceItems", invoiceItems);
        invoiceData.put("TotalPrice", priceLbl.getText());
        // Add the current date and time
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        invoiceData.put("Date", dateFormat.format(currentDate));
        invoiceData.put("Time", timeFormat.format(currentDate));

        return invoiceData;
    }

    public void generateInvoiceBill(JSONObject invoiceData, String balance) {
        try {
            // Extract customer name, time, and date
            String customerName = invoiceData.getString("Customer Name");
            time = invoiceData.getString("Time");
            date = invoiceData.getString("Date");

            // Extract invoice items
            JSONArray invoiceItems = invoiceData.getJSONArray("InvoiceItems");

            // Calculate the width of columns
            int productNameColumnWidth = 20;
            int quantityColumnWidth = 5;
            int priceColumnWidth = 12;

            // Create a bill header
            System.out.println("----------------------------------------");
            System.out.println("                Invoice");
            System.out.println("----------------------------------------");
            System.out.printf("Date: %16s\n", date);
            System.out.printf("Time: %16s\n", time);
            System.out.printf("Customer: %12s\n", customerName);
            System.out.println("----------------------------------------");

            // Create column headers
            System.out.printf("%-" + productNameColumnWidth + "s %" + quantityColumnWidth + "s %" + priceColumnWidth + "s\n",
                    "Product", "Qty", "Price");
            System.out.println("----------------------------------------");

            // Extract and display invoice items
            for (int i = 0; i < invoiceItems.length(); i++) {
                JSONObject item = invoiceItems.getJSONObject(i);
                String productName = item.getString("ProductName");
                String quantity = item.getString("Quantity");
                String price = item.getString("Price");

                System.out.printf("%-" + productNameColumnWidth + "s %" + quantityColumnWidth + "s %" + priceColumnWidth + "s\n",
                        productName, quantity, price + "0/=");
            }

            // Extract and display the total price
            String totalPrice = invoiceData.getString("TotalPrice");
            System.out.println("----------------------------------------");
            System.out.printf("Total Price: %25s\n", totalPrice);
            System.out.printf("Payment: %29s\n", payment + "0/=");
            System.out.printf("Balance Price: %23s\n", balance + "/=");
            System.out.println("----------------------------------------");
            System.out.println("             Thank You");
            System.out.println("             Come Again");
            System.out.println("----------------------------------------");

        } catch (JSONException e) {
            System.out.println("generateInvoiceBill: " + e.getMessage());
        }
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public void updateProductStock(String productName, double quantity) {
        try {
            // Update stock quantity in the database.
            // Replace this with your database update code.

            ResultSet rs = DB.getdata("SELECT stock_quantity FROM product WHERE product_name = '" + productName + "'");
            if (rs.next()) {
                double dbQuantity = Double.parseDouble(rs.getString("stock_quantity"));
                String newQuantity = String.valueOf(dbQuantity - quantity);
                DB.putdata("UPDATE product SET stock_quantity = '" + newQuantity + "' WHERE product_name = '" + productName + "'");
            } else {

            }
        } catch (Exception ex) {
            System.out.println("Update Product Stock : " + ex.getMessage());
        }
    }

    public void updateStockAndCalculateProfit(DefaultTableModel model) {
        String productName = "";
        double quantity = 0.0;
        double soldPrice = 0;
        double costPrice;
        double profit;
        double totalProfit = 0;
        double totalsold = 0;
        for (int row = 0; row < model.getRowCount(); row++) {
            productName = model.getValueAt(row, 1).toString();
            quantity = Double.parseDouble(model.getValueAt(row, 2).toString());
            soldPrice = Double.parseDouble(model.getValueAt(row, 3).toString());

            costPrice = getProductCostPrice(productName) * quantity;
            profit = (soldPrice - costPrice);
            totalProfit += profit;
            totalsold += soldPrice;
            System.out.println("Product Name : " + productName);
            System.out.println("Sold : " + soldPrice);
            System.out.println("Cost : " + costPrice);
            System.out.println("Profit : " + profit);
            updateSoldItem(date, time, soldPrice, profit, String.valueOf(quantity), productName, UserID, customerIdArray.get(customerCombo.getSelectedIndex()));
            // Update stock quantity and calculate profit in the database
            updateProductStock(productName, quantity);

        }

        System.out.println("Total Profit : " + totalProfit);
        System.out.println("Total Sold : " + totalsold);

        if (UserID != -1) {
            updateUserProfile(date, time, String.valueOf(totalProfit), String.valueOf(totalsold), UserID);
            updateCashPayment(time, date, String.valueOf(totalsold), paymentMethodId, customerIdArray.get(customerCombo.getSelectedIndex()), invoiceCategoryCombo.getSelectedIndex());

        }
    }

    public double getProductCostPrice(String productName) {
        double costPrice = 0.0;
        try {
            ResultSet rs = DB.getdata("SELECT reciving_price FROM product WHERE product_name = '" + productName + "'");
            if (rs.next()) {
                costPrice = Double.parseDouble(rs.getString("reciving_price"));
            }
        } catch (Exception ex) {
            System.out.println("Get Product Cost Price : " + ex.getMessage());
        }

        return costPrice;
    }

    public void updateUserProfile(String date, String time, String profit, String sale, int userId) {
        try {
            DB.putdata("INSERT INTO user_profile (date, time, sale, profit, user_id) VALUES ('" + date + "','" + time + "','" + sale + "','" + profit + "','" + userId + "')");
        } catch (Exception ex) {
            System.out.println("updateUserProfile : " + ex.getMessage());
        }
    }

    public void updateCashPayment(String time, String date, String price, int payment_method_id, int customer_id, int invoice_category_id) {
        try {
            DB.putdata("INSERT INTO cash_payment (date, time, price, payment_method_id, customer_id, invoice_category_id) VALUES ('" + date + "','" + time + "','" + price + "','" + payment_method_id + "','" + customer_id + "','" + invoice_category_id + "')");
        } catch (Exception ex) {
            System.out.println("updateCashPaymentProfile : " + ex.getMessage());
        }
    }

    public void readUserIdFromFile() {
        try {
            ReportManager.getInstance().compileReport();
        } catch (Exception e) {
            System.out.println("Report Manager Compile : " + e.getMessage());
        }
        Properties properties = new Properties();

        // Load properties from the file
        try (FileInputStream fileInputStream = new FileInputStream("user.properties")) {
            properties.load(fileInputStream);
            System.out.println("user loaded successfully.");

            // Access individual properties
            String userIdString = properties.getProperty("UserID");
            if (userIdString != null) {
                UserID = Integer.parseInt(userIdString);
                System.out.println("User ID -> New Invoice: " + UserID);
            } else {
                UserID = -1;
                System.out.println("User ID -> New Invoice: " + UserID);
            }

        } catch (IOException e) {
            System.err.println("New Invoice readUserIdFromFile : " + e);
        }
    }

    private void updateSoldItem(String Date, String Time, double soldPrice, double profit, String quantity, String productName, int userID, int customerId) {
        int productId = 0;
        String sql = "SELECT product_id FROM product WHERE product_name = '" + productName + "'";

        try {
            ResultSet rs = DB.getdata(sql);
            if (rs.next()) {
                productId = rs.getInt("product_id");

            }
        } catch (Exception ex) {
            System.out.println("updateSoldItem(Get Product Id) -> New Invoice : " + ex.getMessage());
        }
        try {
            DB.putdata("INSERT INTO sold_items (date, time, price, profit, quantity, product_id, user_id, customer_id) VALUES ('" + Date + "','" + Time + "','" + soldPrice + "','" + profit + "','" + quantity + "','" + productId + "','" + userID + "','" + customerId + "')");
        } catch (Exception ex) {
            System.out.println("updateSoldItem(Save Data) -> New Invoice : " + ex.getMessage());
        }
    }

    private void generateBill(JSONObject invoiceData) {
        JSONArray invoiceItems = invoiceData.getJSONArray("InvoiceItems");
        String Date = invoiceData.getString("Date");
        String Time = invoiceData.getString("Time");
        String CustomerName = invoiceData.getString("Customer Name");
        try {
            List<FieldReportPayment> fields = new ArrayList<>();
            for (int i = 0; i < invoiceItems.length(); i++) {
                JSONObject item = invoiceItems.getJSONObject(i);
                String productName = item.getString("ProductName");
                double quantity = Double.parseDouble(item.getString("Quantity"));
                double price = Double.parseDouble(item.getString("Price"));
                fields.add(new FieldReportPayment(productName, quantity, price));
            }
            ParameterReportPayment dataPrint = new ParameterReportPayment(Date, Time, CustomerName, invoiceData.getString("TotalPrice"), getLogo(), getQrCode(Time, Date), fields);
            ReportManager.getInstance().printReportPayment(dataPrint);
        } catch (Exception e) {
        }
    }

    private InputStream getQrCode(String Time, String Date) throws IOException, WriterException {
        JSONObject qrData = new JSONObject();
        qrData.put("Date", Date);
        qrData.put("Time", Time);
        qrData.put("CustomerID", customerIdArray.get(customerCombo.getSelectedIndex()));

        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.MARGIN, 0);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(qrData.toString(), BarcodeFormat.QR_CODE, 80, 80, hints);
        BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", outputStream);
        return new ByteArrayInputStream(outputStream.toByteArray());

    }

    private InputStream getLogo() {
        try {
            String imageUrl = "file:" + il.logo_1;
            URL url = new URL(imageUrl);
            return url.openStream();
        } catch (MalformedURLException e) {
            e.printStackTrace(); // Handle the URL format exception
        } catch (IOException e) {
            e.printStackTrace(); // Handle the IO exception
        }
        return null;
    }

}
