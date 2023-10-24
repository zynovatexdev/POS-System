/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.zx.shopmanagementsystem.ui;

import com.zx.shopmanagementsystem.assests.Func;
import com.zx.shopmanagementsystem.assests.IconLocation;
import com.zx.shopmanagementsystem.dbconnection.JDBC;
import com.zx.shopmanagementsystem.notifications.MessageDialog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class AddBarcode extends javax.swing.JFrame {

    /**
     * Creates new form AddBarcode
     */
    Func func = new Func();
    IconLocation il = new IconLocation();
    JDBC DB = new JDBC();

    int maxBarId;
    int newBarId;

    public AddBarcode() {
        initComponents();
        getMaxValue();
        Thread dataUpdateThread = new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(12345);  // Use an available port

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
                            barcodeValueTxt.setText(line);
                            //barcodeTxt.setText(line);
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
        addBarcodeBtnLbl = new javax.swing.JLabel();
        barcodeIdLbl = new javax.swing.JLabel();
        barcodeDetectorBtnLbl = new javax.swing.JLabel();
        barcodeValueTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        iconLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        head1.setHeaderTextColor("#000000");
        head1.setHeaderTitle("");
        head1.setOpaque(false);
        getContentPane().add(head1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        addBarcodeBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\AddPurpleIcon.png")); // NOI18N
        addBarcodeBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBarcodeBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addBarcodeBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addBarcodeBtnLblMouseExited(evt);
            }
        });
        getContentPane().add(addBarcodeBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 440, -1, -1));

        barcodeIdLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        barcodeIdLbl.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(barcodeIdLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 220, 70, 20));

        barcodeDetectorBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\SearchBardcodeIcon.png")); // NOI18N
        barcodeDetectorBtnLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barcodeDetectorBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barcodeDetectorBtnLblMouseClicked(evt);
            }
        });
        getContentPane().add(barcodeDetectorBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 310, -1, -1));

        barcodeValueTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        barcodeValueTxt.setHintText("Enter Barcode Value");
        barcodeValueTxt.setPreferredSize(new java.awt.Dimension(129, 50));
        getContentPane().add(barcodeValueTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 300, 280, 50));

        iconLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\images\\Add_Barcode.png")); // NOI18N
        getContentPane().add(iconLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addBarcodeBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBarcodeBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(addBarcodeBtnLbl, il.addWhiteIcon);
    }//GEN-LAST:event_addBarcodeBtnLblMouseEntered

    private void addBarcodeBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBarcodeBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(addBarcodeBtnLbl, il.addPurpleIcon);
    }//GEN-LAST:event_addBarcodeBtnLblMouseExited

    private void addBarcodeBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBarcodeBtnLblMouseClicked
        // TODO add your handling code here:
        MessageDialog DialogBox = new MessageDialog(this);
        if (barcodeValueTxt.getText().equals("")) {
            System.out.println("Text Empty");
            DialogBox.showMessage("WARNING", "Barcode Value Empty", 2);
        } else {

            if (func.barcodeChecker(barcodeValueTxt.getText()) == 1) {
                System.out.println("barcode have");
            } else {
                try {
                    DB.putdata("INSERT INTO barcode (barcode_id, barcode_value) VALUES ('" + newBarId + "','" + barcodeValueTxt.getText() + "')");
                    DialogBox.showMessage("Done", "Barcode Succussfully Added", 1);
                    barcodeValueTxt.setText("");
                    getMaxValue();
                    System.out.println(newBarId);
                    DB.con().close();
                } catch (Exception ex) {
                    Logger.getLogger(AddBarcode.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_addBarcodeBtnLblMouseClicked

    private void barcodeDetectorBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barcodeDetectorBtnLblMouseClicked
        // TODO add your handling code here:
        String pythonScript = "C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\barcode_Python\\abc.py";
        try {
            Runtime.getRuntime().exec("python " + pythonScript);
        } catch (IOException ex) {
            System.out.println("Barcode Detector Btn : " + ex.getMessage());
        }
    }//GEN-LAST:event_barcodeDetectorBtnLblMouseClicked

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
            java.util.logging.Logger.getLogger(AddBarcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddBarcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddBarcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddBarcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddBarcode().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addBarcodeBtnLbl;
    private javax.swing.JLabel barcodeDetectorBtnLbl;
    private javax.swing.JLabel barcodeIdLbl;
    private com.zx.shopmanagementsystem.components.RoundedText barcodeValueTxt;
    private com.zx.shopmanagementsystem.components.Head head1;
    private javax.swing.JLabel iconLbl;
    // End of variables declaration//GEN-END:variables

    private void getMaxValue() {
        try {
            java.sql.ResultSet rs1 = DB.getdata("SELECT MAX(barcode_id) FROM barcode");
            if (rs1.next()) {
                //System.out.println("Table not empty");
                maxBarId = rs1.getInt("max(barcode_id)");
                //System.out.println(maxCusId);
                barcodeIdLbl.setText(String.valueOf(maxBarId + 1));
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

}
