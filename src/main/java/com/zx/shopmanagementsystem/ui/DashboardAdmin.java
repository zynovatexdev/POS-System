/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.zx.shopmanagementsystem.ui;

import com.zx.shopmanagementsystem.assests.Func;
import com.zx.shopmanagementsystem.assests.IconLocation;
import com.zx.shopmanagementsystem.assests.backUp;
import com.zx.shopmanagementsystem.dbconnection.JDBC;
import com.zx.shopmanagementsystem.dbconnection.JFBC;
import com.zx.shopmanagementsystem.forms.Analysis;
import com.zx.shopmanagementsystem.forms.CustomerManagement;
import com.zx.shopmanagementsystem.forms.DebtManagement;
import com.zx.shopmanagementsystem.forms.Help;
import com.zx.shopmanagementsystem.forms.HomeAdmin;
import com.zx.shopmanagementsystem.forms.InventoryManagement;
import com.zx.shopmanagementsystem.forms.InvoiceCreation;
import com.zx.shopmanagementsystem.forms.ProductManagement;
import com.zx.shopmanagementsystem.forms.ReportGeneration;
import com.zx.shopmanagementsystem.forms.SupplierManagement;
import com.zx.shopmanagementsystem.forms.UserManagement;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author User
 */
public class DashboardAdmin extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    IconLocation il = new IconLocation();
    Func func = new Func();
    backUp backup = new backUp();
    JFBC FB = new JFBC();

    public int UseriD;
    String path;

    public DashboardAdmin() {
        initComponents();
        FB.connectFirebase();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTask(), 0, 600000);
        setBackground(new Color(255, 255, 255, 0));
        head1.setOpaque(true);
        head1.setHeaderTitle("Dashboard Admin");
        head1.setHeaderTextColor("#ffffff");
        head1.setFrame(this);
        func.setForm(mainPanal, new HomeAdmin());
        setIcon();
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
        menu1 = new com.raven.component.Menu();
        customerManagementBtnLbl = new javax.swing.JLabel();
        dashboardBtnLbl = new javax.swing.JLabel();
        userManagementBtnLbl = new javax.swing.JLabel();
        debtManagementBtnLbl = new javax.swing.JLabel();
        productManagementBtnLbl = new javax.swing.JLabel();
        inventoryManagementBtnLbl = new javax.swing.JLabel();
        invoiceCreationBtnLbl = new javax.swing.JLabel();
        AnalysisBtnLbl = new javax.swing.JLabel();
        reportGenerationBtnLbl = new javax.swing.JLabel();
        supplierManagmentBtnLbl = new javax.swing.JLabel();
        helpBtnLbl = new javax.swing.JLabel();
        imageAvatar = new com.zx.shopmanagementsystem.components.ImageAvatar();
        logoutBtnLbl = new javax.swing.JLabel();
        mainPanal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        head1.setHeaderTextColor("#FFFFFF");
        getContentPane().add(head1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 1370, -1));

        menu1.setPreferredSize(new java.awt.Dimension(351, 544));
        menu1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        customerManagementBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\CustomerManagementPurple.png")); // NOI18N
        customerManagementBtnLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        customerManagementBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerManagementBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                customerManagementBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                customerManagementBtnLblMouseExited(evt);
            }
        });
        menu1.add(customerManagementBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 550, 339, 39));

        dashboardBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\DashboardPurple.png")); // NOI18N
        dashboardBtnLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashboardBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashboardBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashboardBtnLblMouseExited(evt);
            }
        });
        menu1.add(dashboardBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 230, 339, 39));

        userManagementBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\UserManagementPurple.png")); // NOI18N
        userManagementBtnLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        userManagementBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userManagementBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userManagementBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userManagementBtnLblMouseExited(evt);
            }
        });
        menu1.add(userManagementBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 590, 339, 39));

        debtManagementBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\DebtManagementPurple.png")); // NOI18N
        debtManagementBtnLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        debtManagementBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                debtManagementBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                debtManagementBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                debtManagementBtnLblMouseExited(evt);
            }
        });
        menu1.add(debtManagementBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 390, 339, 39));

        productManagementBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\ProductManagementPurple.png")); // NOI18N
        productManagementBtnLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        productManagementBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productManagementBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                productManagementBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                productManagementBtnLblMouseExited(evt);
            }
        });
        menu1.add(productManagementBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 350, 339, 39));

        inventoryManagementBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\InventoryManagementPurple.png")); // NOI18N
        inventoryManagementBtnLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inventoryManagementBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inventoryManagementBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inventoryManagementBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inventoryManagementBtnLblMouseExited(evt);
            }
        });
        menu1.add(inventoryManagementBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 310, 339, 39));

        invoiceCreationBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\InvoiceCreationPurple.png")); // NOI18N
        invoiceCreationBtnLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        invoiceCreationBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invoiceCreationBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                invoiceCreationBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                invoiceCreationBtnLblMouseExited(evt);
            }
        });
        menu1.add(invoiceCreationBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 270, 339, 39));

        AnalysisBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\AnalysisPurple.png")); // NOI18N
        AnalysisBtnLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AnalysisBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AnalysisBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AnalysisBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AnalysisBtnLblMouseExited(evt);
            }
        });
        menu1.add(AnalysisBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 430, 339, 39));

        reportGenerationBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\ReportGenerationPurple.png")); // NOI18N
        reportGenerationBtnLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reportGenerationBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportGenerationBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reportGenerationBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reportGenerationBtnLblMouseExited(evt);
            }
        });
        menu1.add(reportGenerationBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 470, 339, 39));

        supplierManagmentBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\SupplierManagementPurple.png")); // NOI18N
        supplierManagmentBtnLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        supplierManagmentBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supplierManagmentBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                supplierManagmentBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                supplierManagmentBtnLblMouseExited(evt);
            }
        });
        menu1.add(supplierManagmentBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 510, 339, 39));

        helpBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\HelpPurple.png")); // NOI18N
        helpBtnLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        helpBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                helpBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                helpBtnLblMouseExited(evt);
            }
        });
        menu1.add(helpBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 630, 339, 39));
        menu1.add(imageAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 160, 150));

        logoutBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\LogoutPurple.png")); // NOI18N
        logoutBtnLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutBtnLblMouseExited(evt);
            }
        });
        menu1.add(logoutBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 686, -1, -1));

        getContentPane().add(menu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 350, 770));

        mainPanal.setBackground(new java.awt.Color(255, 255, 255));
        mainPanal.setPreferredSize(new java.awt.Dimension(1015, 738));
        mainPanal.setLayout(new java.awt.BorderLayout());
        getContentPane().add(mainPanal, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dashboardBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(dashboardBtnLbl, il.dashboardWhiteIcon);
    }//GEN-LAST:event_dashboardBtnLblMouseEntered

    private void dashboardBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(dashboardBtnLbl, il.dashboardPurpleIcon);
    }//GEN-LAST:event_dashboardBtnLblMouseExited

    private void userManagementBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userManagementBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(userManagementBtnLbl, il.userManagementWhiteIcon);
    }//GEN-LAST:event_userManagementBtnLblMouseEntered

    private void userManagementBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userManagementBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(userManagementBtnLbl, il.userManagementPurpleIcon);
    }//GEN-LAST:event_userManagementBtnLblMouseExited

    private void customerManagementBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerManagementBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(customerManagementBtnLbl, il.customerManagementWhiteIcon);
    }//GEN-LAST:event_customerManagementBtnLblMouseEntered

    private void customerManagementBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerManagementBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(customerManagementBtnLbl, il.customerManagementPurpleIcon);
    }//GEN-LAST:event_customerManagementBtnLblMouseExited

    private void supplierManagmentBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierManagmentBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(supplierManagmentBtnLbl, il.supplierManagementWhiteIcon);
    }//GEN-LAST:event_supplierManagmentBtnLblMouseEntered

    private void supplierManagmentBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierManagmentBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(supplierManagmentBtnLbl, il.supplierManagementPurpleIcon);
    }//GEN-LAST:event_supplierManagmentBtnLblMouseExited

    private void debtManagementBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_debtManagementBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(debtManagementBtnLbl, il.debtManagemetWhiteIcon);
    }//GEN-LAST:event_debtManagementBtnLblMouseEntered

    private void debtManagementBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_debtManagementBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(debtManagementBtnLbl, il.debtManagemetPurpleIcon);
    }//GEN-LAST:event_debtManagementBtnLblMouseExited

    private void productManagementBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productManagementBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(productManagementBtnLbl, il.productManagementWhiteIcon);
    }//GEN-LAST:event_productManagementBtnLblMouseEntered

    private void productManagementBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productManagementBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(productManagementBtnLbl, il.productManagementPurpleIcon);
    }//GEN-LAST:event_productManagementBtnLblMouseExited

    private void inventoryManagementBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryManagementBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(inventoryManagementBtnLbl, il.inventoryManagementWhiteIcon);
    }//GEN-LAST:event_inventoryManagementBtnLblMouseEntered

    private void inventoryManagementBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryManagementBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(inventoryManagementBtnLbl, il.inventoryManagementPurpleIcon);
    }//GEN-LAST:event_inventoryManagementBtnLblMouseExited

    private void invoiceCreationBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceCreationBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(invoiceCreationBtnLbl, il.invoiceCreationWhiteIcon);
    }//GEN-LAST:event_invoiceCreationBtnLblMouseEntered

    private void invoiceCreationBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceCreationBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(invoiceCreationBtnLbl, il.invoiceCreationPurpleIcon);

    }//GEN-LAST:event_invoiceCreationBtnLblMouseExited

    private void reportGenerationBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportGenerationBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(reportGenerationBtnLbl, il.reportGenerationWhiteIcon);
    }//GEN-LAST:event_reportGenerationBtnLblMouseEntered

    private void reportGenerationBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportGenerationBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(reportGenerationBtnLbl, il.reportGenerationPurpleIcon);
    }//GEN-LAST:event_reportGenerationBtnLblMouseExited

    private void AnalysisBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AnalysisBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(AnalysisBtnLbl, il.analysisWhiteIcon);
    }//GEN-LAST:event_AnalysisBtnLblMouseEntered

    private void AnalysisBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AnalysisBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(AnalysisBtnLbl, il.analysisPurpleIcon);
    }//GEN-LAST:event_AnalysisBtnLblMouseExited

    private void helpBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(helpBtnLbl, il.helpWhiteIcon);
    }//GEN-LAST:event_helpBtnLblMouseEntered

    private void helpBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(helpBtnLbl, il.helpPurpleIcon);
    }//GEN-LAST:event_helpBtnLblMouseExited

    private void logoutBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(logoutBtnLbl, il.logoutWhiteIcon);
    }//GEN-LAST:event_logoutBtnLblMouseEntered

    private void logoutBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(logoutBtnLbl, il.logoutPurpleIcon);
    }//GEN-LAST:event_logoutBtnLblMouseExited

    private void dashboardBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardBtnLblMouseClicked
        // TODO add your handling code here:
        func.setForm(mainPanal, new HomeAdmin());
        head1.setHeaderTitle("Admin Dashboard");
    }//GEN-LAST:event_dashboardBtnLblMouseClicked

    private void userManagementBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userManagementBtnLblMouseClicked
        // TODO add your handling code here:
        func.setForm(mainPanal, new UserManagement());
        head1.setHeaderTitle("User Management");
    }//GEN-LAST:event_userManagementBtnLblMouseClicked

    private void customerManagementBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerManagementBtnLblMouseClicked
        // TODO add your handling code here:
        func.setForm(mainPanal, new CustomerManagement());
        head1.setHeaderTitle("Customer Management");
    }//GEN-LAST:event_customerManagementBtnLblMouseClicked

    private void supplierManagmentBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierManagmentBtnLblMouseClicked
        // TODO add your handling code here:
        func.setForm(mainPanal, new SupplierManagement());
        head1.setHeaderTitle("Supplier Management");
    }//GEN-LAST:event_supplierManagmentBtnLblMouseClicked

    private void debtManagementBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_debtManagementBtnLblMouseClicked
        // TODO add your handling code here:
        func.setForm(mainPanal, new DebtManagement());
        head1.setHeaderTitle("Debt Management");
    }//GEN-LAST:event_debtManagementBtnLblMouseClicked

    private void productManagementBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productManagementBtnLblMouseClicked
        // TODO add your handling code here:
        func.setForm(mainPanal, new ProductManagement());
        head1.setHeaderTitle("Product Management");
    }//GEN-LAST:event_productManagementBtnLblMouseClicked

    private void inventoryManagementBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryManagementBtnLblMouseClicked
        // TODO add your handling code here:
        func.setForm(mainPanal, new InventoryManagement());
        head1.setHeaderTitle("Inventory Management");
    }//GEN-LAST:event_inventoryManagementBtnLblMouseClicked

    private void invoiceCreationBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceCreationBtnLblMouseClicked
        // TODO add your handling code here:
        func.setForm(mainPanal, new InvoiceCreation());
        head1.setHeaderTitle("Invoice Management");
        System.out.println("DB ID : " + UseriD);
        InvoiceCreation ic = new InvoiceCreation();
        ic.uid = UseriD;
    }//GEN-LAST:event_invoiceCreationBtnLblMouseClicked

    private void reportGenerationBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportGenerationBtnLblMouseClicked
        // TODO add your handling code here:
        func.setForm(mainPanal, new ReportGeneration());
        head1.setHeaderTitle("Report Generation");
    }//GEN-LAST:event_reportGenerationBtnLblMouseClicked

    private void AnalysisBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AnalysisBtnLblMouseClicked
        // TODO add your handling code here:
        func.setForm(mainPanal, new Analysis());
        head1.setHeaderTitle("Analysis");
    }//GEN-LAST:event_AnalysisBtnLblMouseClicked

    private void helpBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpBtnLblMouseClicked
        // TODO add your handling code here:
        func.setForm(mainPanal, new Help());
        head1.setHeaderTitle("Help and Documentation");
    }//GEN-LAST:event_helpBtnLblMouseClicked

    private void logoutBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnLblMouseClicked
        // TODO add your handling code here:
        LogOut logout = new LogOut();
        this.dispose();
        logout.setVisible(true);
    }//GEN-LAST:event_logoutBtnLblMouseClicked

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
            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new SplashPanal(null, true).setVisible(true);
                new DashboardAdmin().setVisible(true);
            }
        });
    }

    private class MyTask extends TimerTask {

        @Override
        public void run() {
            // Place your code here to execute every 10 minutes
            System.out.println("Task executed at: " + System.currentTimeMillis());

            //backup.backupAll();
        }
    }

    public void customerPanalRefresh() {

        //func.setForm(mainPanal, new CustomerManagement());
        // head1.setHeaderTitle("Customer Management");
        System.out.println("Panal Refreshed");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AnalysisBtnLbl;
    private javax.swing.JLabel customerManagementBtnLbl;
    private javax.swing.JLabel dashboardBtnLbl;
    private javax.swing.JLabel debtManagementBtnLbl;
    private com.zx.shopmanagementsystem.components.Head head1;
    private javax.swing.JLabel helpBtnLbl;
    private com.zx.shopmanagementsystem.components.ImageAvatar imageAvatar;
    private javax.swing.JLabel inventoryManagementBtnLbl;
    private javax.swing.JLabel invoiceCreationBtnLbl;
    private javax.swing.JLabel logoutBtnLbl;
    private javax.swing.JPanel mainPanal;
    private com.raven.component.Menu menu1;
    private javax.swing.JLabel productManagementBtnLbl;
    private javax.swing.JLabel reportGenerationBtnLbl;
    private javax.swing.JLabel supplierManagmentBtnLbl;
    private javax.swing.JLabel userManagementBtnLbl;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(il.logo));
    }

    public void getUserId(int UserID) {
        this.UseriD = UserID;
        JDBC DB = new JDBC();
        InputStream input;
        FileOutputStream output;
        System.out.println("Data Load UserID : " + UserID);
        try {
            FileWriter writer = new FileWriter("C:\\ShopManagementSystem\\userId.txt");
            writer.write(Integer.toString(UserID));
            writer.close();
            System.out.println("UserID written to the file.");
        } catch (IOException e) {
            System.err.println("Error writing UserID to the file: " + e.getMessage());
        }
        try {
            ResultSet rs = DB.getdata("SELECT * FROM user WHERE user_id = " + UserID + ";");
            while (rs.next()) {

                File file = new File("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\DBProfileImages\\img" + UserID + "_Dash_" + ".png");
                output = new FileOutputStream(file);
                input = rs.getBinaryStream("profile_pic");
                byte buffer[] = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }
                path = file.getAbsolutePath();
                System.out.println("Path : " + path);
                ImageIcon image = new ImageIcon(path);
                Image img = image.getImage();
                ImageIcon imageIcon = new ImageIcon(img);
                imageAvatar.setIcon(imageIcon);
                imageAvatar.setVisible(false);
                imageAvatar.setVisible(true);

                break;
            }
        } catch (Exception ex) {
            System.out.println("Data Load Function (User Details): " + ex.getMessage());
        }
    }

}
