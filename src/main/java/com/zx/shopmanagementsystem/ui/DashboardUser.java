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
import com.zx.shopmanagementsystem.forms.ProductPerformance;
import com.zx.shopmanagementsystem.forms.ReportGeneration;
import com.zx.shopmanagementsystem.forms.Settings;
import com.zx.shopmanagementsystem.forms.SupplierManagement;
import com.zx.shopmanagementsystem.forms.UserManagement;
import com.zx.shopmanagementsystem.menu.ui.MenuEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.Properties;
import javax.swing.ImageIcon;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author User
 */
public class DashboardUser extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    IconLocation il = new IconLocation();
    Func func = new Func();
    backUp backup = new backUp();
    JFBC FB = new JFBC();

    public int UseriD;
    String path;
    long backuptime;

    public DashboardUser() {
        initComponents();
        showForm(new HomeAdmin());
        menu1.setEvent(new MenuEvent() {
            @Override
            public void selected(int index, int subIndex) {
                if (index == 0) {
                    showForm(new HomeAdmin());
                } else if (index == 1) {
                    showForm(new InvoiceCreation());
                } else if (index == 2) {
                    showForm(new DebtManagement());
                } else if (index == 3) {
                    showForm(new CustomerManagement());
                } else if (index == 4) {
                    showForm(new Help());
                } else if (index == 5) {
                    new LogOut().setVisible(true);
                    close();
                }
            }
        });
        jsonRead();
        FB.connectFirebase();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTask(), 0, backuptime);
        setBackground(new Color(255, 255, 255));
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

        jPanel1 = new javax.swing.JPanel();
        header1 = new com.zx.shopmanagementsystem.components.Header();
        imageAvatar = new com.zx.shopmanagementsystem.components.ImageAvatar();
        closeBtnLbl = new javax.swing.JLabel();
        minimizeBtnLbl = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        scrollPaneWin111 = new com.zx.shopmanagementsystem.menu.scroll.win11.ScrollPaneWin11();
        menu1 = new com.zx.shopmanagementsystem.menu.ui.MenuUser();
        body = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 768));

        header1.setPreferredSize(new java.awt.Dimension(167, 50));
        header1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                header1MousePressed(evt);
            }
        });

        closeBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\Close_Black.png")); // NOI18N
        closeBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeBtnLblMouseExited(evt);
            }
        });

        minimizeBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\Minimise_Black.png")); // NOI18N
        minimizeBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeBtnLblMouseExited(evt);
            }
        });

        nameLbl.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        nameLbl.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout header1Layout = new javax.swing.GroupLayout(header1);
        header1.setLayout(header1Layout);
        header1Layout.setHorizontalGroup(
            header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(minimizeBtnLbl)
                .addGap(18, 18, 18)
                .addComponent(closeBtnLbl)
                .addGap(15, 15, 15))
        );
        header1Layout.setVerticalGroup(
            header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header1Layout.createSequentialGroup()
                .addGroup(header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(header1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(header1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(minimizeBtnLbl)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(imageAvatar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)))
                    .addGroup(header1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(closeBtnLbl)))
                .addContainerGap())
        );

        scrollPaneWin111.setBorder(null);
        scrollPaneWin111.setViewportView(menu1);

        body.setPreferredSize(new java.awt.Dimension(1116, 718));
        body.setLayout(new javax.swing.BoxLayout(body, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 1116, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneWin111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(closeBtnLbl, il.closeRedIcon);
    }//GEN-LAST:event_closeBtnLblMouseEntered

    private void closeBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(closeBtnLbl, il.closeBlackIcon);
    }//GEN-LAST:event_closeBtnLblMouseExited

    private void minimizeBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(minimizeBtnLbl, il.minimiseGreenIcon);
    }//GEN-LAST:event_minimizeBtnLblMouseEntered

    private void minimizeBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(minimizeBtnLbl, il.minimiseBlackIcon);
    }//GEN-LAST:event_minimizeBtnLblMouseExited

    private void closeBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnLblMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeBtnLblMouseClicked

    private void minimizeBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeBtnLblMouseClicked
        // TODO add your handling code here:
        func.minimiseWindow(this);
    }//GEN-LAST:event_minimizeBtnLblMouseClicked

    private void header1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_header1MousePressed
        // TODO add your handling code here:
        func.x = evt.getX();
        func.y = evt.getY();
        func.initDashboardMoving(this, header1);
    }//GEN-LAST:event_header1MousePressed

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
            java.util.logging.Logger.getLogger(DashboardUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new SplashPanal(null, true).setVisible(true);
                new DashboardUser().setVisible(true);
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
    private javax.swing.JPanel body;
    private javax.swing.JLabel closeBtnLbl;
    private com.zx.shopmanagementsystem.components.Header header1;
    private com.zx.shopmanagementsystem.components.ImageAvatar imageAvatar;
    private javax.swing.JPanel jPanel1;
    private com.zx.shopmanagementsystem.menu.ui.MenuUser menu1;
    private javax.swing.JLabel minimizeBtnLbl;
    private javax.swing.JLabel nameLbl;
    private com.zx.shopmanagementsystem.menu.scroll.win11.ScrollPaneWin11 scrollPaneWin111;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(il.logo));
    }

    public void getUserImage() {
        JDBC DB = new JDBC();
        InputStream input;
        String userName;
        String Name;
        FileOutputStream output;

        System.out.println("Data Load UserID : " + UseriD);
        try {
            ResultSet rs = DB.getdata("SELECT * FROM user WHERE user_id = " + UseriD + ";");
            while (rs.next()) {

                File file = new File("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\DBProfileImages\\img" + UseriD + "_Dash_" + ".png");
                output = new FileOutputStream(file);
                input = rs.getBinaryStream("profile_pic");
                userName = rs.getString("user_name");
                Name = rs.getString("full_name");
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
                nameLbl.setText("Hello, " + userName + " (" + Name + ")");

                break;
            }
        } catch (Exception ex) {
            System.out.println("Data Load Function (User Details): " + ex.getMessage());
        }
    }

    private void jsonRead() {
        Properties properties = new Properties();
        Properties properties2 = new Properties();

        // Load properties from the file
        try (FileInputStream fileInputStream = new FileInputStream("user.properties")) {
            properties.load(fileInputStream);
            System.out.println("user loaded successfully.");

            // Access individual properties
            UseriD = Integer.parseInt(properties.getProperty("UserID"));

            System.out.println("User ID: " + UseriD);
            getUserImage();

        } catch (Exception eb) {
            System.err.println("Dashboard Admin jsonRead UserId: " + eb);
        }

        try (FileInputStream fileInputStream = new FileInputStream("Settings.properties")) {
            properties2.load(fileInputStream);
            System.out.println("Settings loaded successfully.");

            // Access individual properties
            int backupTime = Integer.parseInt((properties2.getProperty("BackupTime")));
            backuptime = backupTime * 60 * 1000;
            System.out.println("Backup Time : " + backuptime + " - " + backupTime);

        } catch (Exception en) {
            System.err.println("Dashboard Admin Backup Time : " + en);
        }
    }

    private void showForm(Component com) {
        body.removeAll();
        body.add(com);
        body.repaint();
        body.revalidate();
    }

    private void close() {
        this.dispose();
    }

}
