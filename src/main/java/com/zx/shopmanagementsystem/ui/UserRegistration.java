/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.zx.shopmanagementsystem.ui;

import com.zx.shopmanagementsystem.assests.Func;
import com.zx.shopmanagementsystem.assests.IconLocation;
import com.zx.shopmanagementsystem.dbconnection.JDBC;
import com.zx.shopmanagementsystem.forms.UserManagement;
import com.zx.shopmanagementsystem.notifications.ConfirmDialog;
import com.zx.shopmanagementsystem.notifications.MessageDialog;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author User
 */
public class UserRegistration extends javax.swing.JFrame {

    /**
     * Creates new form UserRegistration
     */
    Func func = new Func();
    IconLocation il = new IconLocation();
    JDBC DB = new JDBC();

    String path = il.profileIcon;
    File file = null;
    FileInputStream profilePicture = null;
    int userRoleId;
    int usernameExist = 0;
    private UserManagement um;

    public UserRegistration(UserManagement um) {
        this.um = um;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(il.logo));
        head1.setFrame(UserRegistration.this);
        ImageIcon image = new ImageIcon(path);
        Image img = image.getImage();
        ImageIcon icon = new ImageIcon(img);
        imageAvatar.setIcon(icon);
        comboLoader();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hidePasswordLblBtn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        chooseProPicBtnLbl = new javax.swing.JLabel();
        registerBtnLbl = new javax.swing.JLabel();
        usernameTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        passwordTxt = new com.zx.shopmanagementsystem.components.RoundedPassword();
        fullNameTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        head1 = new com.zx.shopmanagementsystem.components.Head();
        imageAvatar = new com.zx.shopmanagementsystem.components.ImageAvatar();
        userRoleCombo = new com.zx.shopmanagementsystem.components.ComboBoxSuggestion();
        iconLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hidePasswordLblBtn.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\HidePassword.png")); // NOI18N
        hidePasswordLblBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hidePasswordLblBtnMouseClicked(evt);
            }
        });
        getContentPane().add(hidePasswordLblBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 200, 35, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\upload_icon.png")); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(32, 15));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 553, -1, -1));

        chooseProPicBtnLbl.setFont(new java.awt.Font("Noto Sans Light", 1, 18)); // NOI18N
        chooseProPicBtnLbl.setForeground(new java.awt.Color(255, 255, 255));
        chooseProPicBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\Upload_Purple.png")); // NOI18N
        chooseProPicBtnLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chooseProPicBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chooseProPicBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                chooseProPicBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                chooseProPicBtnLblMouseExited(evt);
            }
        });
        getContentPane().add(chooseProPicBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 540, 200, 40));

        registerBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\RegisterPurpleIcon.png")); // NOI18N
        registerBtnLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerBtnLblMouseExited(evt);
            }
        });
        getContentPane().add(registerBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 630, 450, 58));

        usernameTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        usernameTxt.setHintText("Enter User Name");
        getContentPane().add(usernameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 90, 480, 50));

        passwordTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        getContentPane().add(passwordTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, 480, 50));

        fullNameTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        fullNameTxt.setHintText("Enter Full Name");
        getContentPane().add(fullNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 290, 480, 50));

        head1.setFrame(null);
        head1.setHeaderTitle("");
        head1.setOpaque(false);
        getContentPane().add(head1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));
        getContentPane().add(imageAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 490, 140, 130));

        userRoleCombo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        userRoleCombo.setPreferredSize(new java.awt.Dimension(185, 50));
        getContentPane().add(userRoleCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 390, 290, -1));

        iconLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\images\\User_Registration.png")); // NOI18N
        getContentPane().add(iconLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        iconLbl.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void chooseProPicBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chooseProPicBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(chooseProPicBtnLbl, il.uploadWhiteIcon);
    }//GEN-LAST:event_chooseProPicBtnLblMouseEntered

    private void chooseProPicBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chooseProPicBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(chooseProPicBtnLbl, il.uploadPurpleIcon);
    }//GEN-LAST:event_chooseProPicBtnLblMouseExited

    private void chooseProPicBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chooseProPicBtnLblMouseClicked
        // TODO add your handling code here:
        MessageDialog DialogBox = new MessageDialog(this);
        JFileChooser jFile = new JFileChooser();
        jFile.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Image", "jpg", "png");
        jFile.addChoosableFileFilter(filter);

        int result = jFile.showSaveDialog(null);
        //System.out.println(result);

        File selectedFile = jFile.getSelectedFile();
        String fileName = selectedFile.getName();
        //System.out.println("File Name : " + fileName);

        if (fileName.endsWith(".jpg") || fileName.endsWith(".JPG") || fileName.endsWith(".png") || fileName.endsWith(".PNG")) {
            if (result == JFileChooser.APPROVE_OPTION) {
                path = selectedFile.getAbsolutePath();
                ImageIcon image = new ImageIcon(path);
                Image img = image.getImage();
                //Image newImage = img.getScaledInstance(profileImageLbl.getWidth(), profileImageLbl.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(img);

                //profileImageLbl.setIcon(icon);
                imageAvatar.setIcon(icon);
                imageAvatar.setVisible(false);
                imageAvatar.setVisible(true);
            }
        } else {
            DialogBox.showMessage("Error !!! ", "Please Select a Image File", 3);
        }

    }//GEN-LAST:event_chooseProPicBtnLblMouseClicked

    private void registerBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(registerBtnLbl, il.RegisterWhiteIcon);
    }//GEN-LAST:event_registerBtnLblMouseEntered

    private void registerBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(registerBtnLbl, il.RegisterPurpleIcon);
    }//GEN-LAST:event_registerBtnLblMouseExited

    private void registerBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerBtnLblMouseClicked
        // TODO add your handling code here:
        addUser();
        um.setTable();
    }//GEN-LAST:event_registerBtnLblMouseClicked

    private void hidePasswordLblBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hidePasswordLblBtnMouseClicked
        // TODO add your handling code here:
        func.mouseClicked(hidePasswordLblBtn, passwordTxt);
    }//GEN-LAST:event_hidePasswordLblBtnMouseClicked

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
            java.util.logging.Logger.getLogger(UserRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        UserManagement um = new UserManagement();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserRegistration ur = new UserRegistration(um);
                ur.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel chooseProPicBtnLbl;
    private com.zx.shopmanagementsystem.components.RoundedText fullNameTxt;
    private com.zx.shopmanagementsystem.components.Head head1;
    private javax.swing.JLabel hidePasswordLblBtn;
    private javax.swing.JLabel iconLbl;
    private com.zx.shopmanagementsystem.components.ImageAvatar imageAvatar;
    private javax.swing.JLabel jLabel1;
    private com.zx.shopmanagementsystem.components.RoundedPassword passwordTxt;
    private javax.swing.JLabel registerBtnLbl;
    private com.zx.shopmanagementsystem.components.ComboBoxSuggestion userRoleCombo;
    private com.zx.shopmanagementsystem.components.RoundedText usernameTxt;
    // End of variables declaration//GEN-END:variables

    private void addUser() {
        MessageDialog DialogBox = new MessageDialog(this);
        String Username = usernameTxt.getText();
        String Password = passwordTxt.getText();
        String fullName = fullNameTxt.getText();
        String userRole = userRoleCombo.getSelectedItem().toString();
        usernameChecker(Username);

        try {
            profilePicture = new FileInputStream(path);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (Username.equals("")) {
            System.out.println("User Name Empty");
            DialogBox.showMessage("WARNING", "User Name Empty", 2);
        } else if (Password.equals("")) {
            System.out.println("Password Empty");
            DialogBox.showMessage("WARNING", "Password Empty", 2);
        } else if (fullName.equals("")) {
            System.out.println("Full Name Empty");
            DialogBox.showMessage("WARNING", "Full Name Empty", 2);
        } else if (userRole.equals("Select Role")) {
            System.out.println("Select User Role");
            DialogBox.showMessage("WARNING", "Select a User Role", 2);
        } else if (usernameExist == 1) {
            System.out.println("User name exsist");
            DialogBox.showMessage("ERROR", "User name exsist", 3);
        } else {
            ConfirmDialog confrim = new ConfirmDialog(this);
            confrim.showMessage("Register", "Do you want to Register ?");
            if (confrim.getMessageType() == ConfirmDialog.MessageType.YES) {
                System.out.println("Yes");
                try {
                    ResultSet rs = DB.getdata("SELECT role_id FROM user_role WHERE role_name = '" + userRole + "'");
                    if (rs.next()) {
                        while (true) {
                            userRoleId = rs.getInt("role_id");
                            PreparedStatement pst = DB.con().prepareStatement("INSERT INTO user (user_name, password, full_name, profile_pic, user_role_id) VALUES (?,?,?,?,?)");

                            pst.setString(1, Username);
                            pst.setString(2, Password);
                            pst.setString(3, fullName);
                            pst.setBinaryStream(4, profilePicture);
                            pst.setInt(5, userRoleId);
                            pst.executeUpdate();
                            System.out.println("Data Written");
                            DialogBox.showMessage("Success", "User Successfully Saved", 1);
                            clear();
                            break;
                        }
                    }
                } catch (Exception ex) {
                    Logger.getLogger(UserRegistration.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println("No");
            }

        }
    }

    private void comboLoader() {
        userRoleCombo.addItem("Select Role");
        try {
            java.sql.ResultSet rs = DB.getdata("SELECT * FROM user_role");
            while (rs.next()) {
                String userRole = rs.getString("role_name");
                userRoleCombo.addItem(userRole);
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void usernameChecker(String username) {
        String sql = "SELECT * FROM user WHERE user_name=?";
        try {
            PreparedStatement pstmt = DB.con().prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                System.out.println("Username is already taken.");
                usernameExist = 1;
            } else {
                System.out.println("Username is available.");
                usernameExist = 0;
            }
        } catch (Exception ex) {
            Logger.getLogger(UserRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void clear() {
        usernameTxt.setText("");
        passwordTxt.setText("");
        fullNameTxt.setText("");
        userRoleCombo.setSelectedIndex(0);
        path = il.profileIcon;
        ImageIcon image = new ImageIcon(path);
        Image img = image.getImage();
        ImageIcon icon = new ImageIcon(img);
        imageAvatar.setIcon(icon);
        imageAvatar.setVisible(false);
        imageAvatar.setVisible(true);
    }

}
