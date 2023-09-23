/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.zx.shopmanagementsystem.ui;

import com.zx.shopmanagementsystem.dbconnection.JDBC;
import com.zx.shopmanagementsystem.assests.Func;
import com.zx.shopmanagementsystem.assests.IconLocation;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        head1.setOpaque(false);
        head1.setHeaderTitle("Login");
        head1.setFrame(Login.this);

    }

    JDBC DB = new JDBC();
    Func func = new Func();
    IconLocation il = new IconLocation();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usernameTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        showPasswordLbl = new javax.swing.JLabel();
        passwordTxt = new com.zx.shopmanagementsystem.components.RoundedPassword();
        loginLbl = new javax.swing.JLabel();
        forgotPasswordLbl = new javax.swing.JLabel();
        head1 = new com.zx.shopmanagementsystem.components.Head();
        iconLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usernameTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        usernameTxt.setHintText("Enter your username\n");
        getContentPane().add(usernameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 480, 50));

        showPasswordLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\HidePassword.png")); // NOI18N
        showPasswordLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showPasswordLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showPasswordLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                showPasswordLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                showPasswordLblMouseExited(evt);
            }
        });
        getContentPane().add(showPasswordLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 410, -1, 30));

        passwordTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        passwordTxt.setHintText("Enter your password");
        getContentPane().add(passwordTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, 480, 50));

        loginLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\Login_Lable.png")); // NOI18N
        loginLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginLblMouseExited(evt);
            }
        });
        getContentPane().add(loginLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 490, 450, 60));

        forgotPasswordLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        forgotPasswordLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotPasswordLblMouseClicked(evt);
            }
        });
        getContentPane().add(forgotPasswordLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(577, 576, 190, 30));
        getContentPane().add(head1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, -1));

        iconLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\images\\User_Login.png")); // NOI18N
        getContentPane().add(iconLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(loginLbl, il.loginAnimationIcon);
    }//GEN-LAST:event_loginLblMouseEntered

    private void loginLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(loginLbl, il.loginNormalIcon);
    }//GEN-LAST:event_loginLblMouseExited

    private void forgotPasswordLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPasswordLblMouseClicked
        // TODO add your handling code here:
        ForgotPassword fp = new ForgotPassword();
        Login.this.dispose();
        fp.setVisible(true);

    }//GEN-LAST:event_forgotPasswordLblMouseClicked

    private void loginLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginLblMouseClicked
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_loginLblMouseClicked

    private void showPasswordLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showPasswordLblMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_showPasswordLblMouseEntered

    private void showPasswordLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showPasswordLblMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_showPasswordLblMouseExited

    private void showPasswordLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showPasswordLblMouseClicked
        // TODO add your handling code here:
        func.mouseClicked(showPasswordLbl, passwordTxt);
    }//GEN-LAST:event_showPasswordLblMouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);

            }
        });
    }

    private void login() {
        String username = usernameTxt.getText();
        String password = passwordTxt.getText();

        if (username.equals("") && password.equals("")) {
            System.out.println("All Text Empty");
            JOptionPane.showMessageDialog(rootPane, "All Text Empty", "Empty Text", JOptionPane.WARNING_MESSAGE);
        } else if (username.equals("")) {
            System.out.println("Username Empty");
            JOptionPane.showMessageDialog(rootPane, "Username Empty", "Empty Username", JOptionPane.WARNING_MESSAGE);
        } else if (password.equals("")) {
            System.out.println("Password Empty");
            JOptionPane.showMessageDialog(rootPane, "Password Empty", "Empty Password", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                java.sql.ResultSet rs = DB.getdata("SELECT * FROM user");
                while (rs.next()) {
                    String dbUsername = rs.getString("user_name");
                    String dbPassword = rs.getString("password");

                    //System.out.println("User Name : "+dbUsername+" "+"Passeord : "+dbPassword);
                    if (!(username.equals(dbUsername) || password.equals(dbPassword))) {
                        System.out.println("User Not Found");
                        JOptionPane.showMessageDialog(rootPane, "User Not Found", "ERROE!!!", JOptionPane.ERROR_MESSAGE);
                    } else if (!(username.equals(dbUsername))) {
                        System.out.println("Username Not Found");
                        JOptionPane.showMessageDialog(rootPane, "Username Not Found", "ERROE!!!", JOptionPane.ERROR_MESSAGE);
                    } else if (!(password.equals(dbPassword))) {
                        System.out.println("User Not Match");
                        JOptionPane.showMessageDialog(rootPane, "User Not Match", "ERROE!!!", JOptionPane.ERROR_MESSAGE);
                    } else {
                        System.out.println("User Match");
                        Dashboard dashboard = new Dashboard();
                        dashboard.setVisible(true);
                        Login.this.dispose();

                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel forgotPasswordLbl;
    private com.zx.shopmanagementsystem.components.Head head1;
    private javax.swing.JLabel iconLbl;
    private javax.swing.JLabel loginLbl;
    private com.zx.shopmanagementsystem.components.RoundedPassword passwordTxt;
    private javax.swing.JLabel showPasswordLbl;
    private com.zx.shopmanagementsystem.components.RoundedText usernameTxt;
    // End of variables declaration//GEN-END:variables
}
