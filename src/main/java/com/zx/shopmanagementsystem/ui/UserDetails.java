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
import java.io.FileOutputStream;
import java.io.InputStream;
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
public class UserDetails extends javax.swing.JFrame {

    /**
     * Creates new form UserUpdate
     */
    JDBC DB = new JDBC();
    Func func = new Func();
    IconLocation il = new IconLocation();

    public int userID = 0;
    String path;
    FileInputStream profilePicture = null;
    private UserManagement um;

    public UserDetails(UserManagement um) {
        this.um = um;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(il.logo));
        head1.setFrame(UserDetails.this);
        updateBtnLbl.setVisible(false);
        imageAvatar.setBorderSize(5);
        formDisable();
        updateImageIconBtn.setVisible(false);
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
        fullNameTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        hidePasswordLblBtn = new javax.swing.JLabel();
        userNameTxt = new com.zx.shopmanagementsystem.components.RoundedText();
        deleteBtnLbl = new javax.swing.JLabel();
        editBtnLbl = new javax.swing.JLabel();
        updateBtnLbl = new javax.swing.JLabel();
        passwordTxt = new com.zx.shopmanagementsystem.components.RoundedPassword();
        imageAvatar = new com.zx.shopmanagementsystem.components.ImageAvatar();
        updateImageIconBtn = new javax.swing.JLabel();
        roleCombo = new com.zx.shopmanagementsystem.components.ComboBoxSuggestion();
        iconLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        head1.setHeaderTextColor("#000000");
        head1.setHeaderTitle("");
        head1.setOpaque(false);
        getContentPane().add(head1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        fullNameTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        fullNameTxt.setHintText("Full Name");
        getContentPane().add(fullNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 430, 310, 50));

        hidePasswordLblBtn.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\HidePassword.png")); // NOI18N
        hidePasswordLblBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hidePasswordLblBtnMouseClicked(evt);
            }
        });
        getContentPane().add(hidePasswordLblBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 380, 35, 30));

        userNameTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        userNameTxt.setHintText("User Name");
        getContentPane().add(userNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 310, 310, 50));

        deleteBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\DeleteRedIcon.png")); // NOI18N
        deleteBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteBtnLblMouseExited(evt);
            }
        });
        getContentPane().add(deleteBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 610, -1, 54));

        editBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\EditPurpleIcon.png")); // NOI18N
        editBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editBtnLblMouseExited(evt);
            }
        });
        getContentPane().add(editBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 610, 170, 54));

        updateBtnLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\UpdatePurpleIcon.png")); // NOI18N
        updateBtnLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateBtnLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateBtnLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateBtnLblMouseExited(evt);
            }
        });
        getContentPane().add(updateBtnLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 600, -1, -1));

        passwordTxt.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        passwordTxt.setPreferredSize(new java.awt.Dimension(157, 50));
        getContentPane().add(passwordTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 370, 310, -1));

        imageAvatar.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Pictures\\image.jpg")); // NOI18N

        updateImageIconBtn.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\EditImageIcon.png")); // NOI18N
        updateImageIconBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateImageIconBtnMouseClicked(evt);
            }
        });
        imageAvatar.add(updateImageIconBtn);
        updateImageIconBtn.setBounds(150, 150, 50, 50);

        getContentPane().add(imageAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 70, 200, 200));

        roleCombo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        roleCombo.setMinimumSize(new java.awt.Dimension(163, 50));
        roleCombo.setPreferredSize(new java.awt.Dimension(163, 50));
        getContentPane().add(roleCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 490, 310, -1));

        iconLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\images\\User_Details.png")); // NOI18N
        getContentPane().add(iconLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void editBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(editBtnLbl, il.editDetailsWhiteIcon);
    }//GEN-LAST:event_editBtnLblMouseEntered

    private void editBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(editBtnLbl, il.editDetailsPurpleIcon);
    }//GEN-LAST:event_editBtnLblMouseExited

    private void deleteBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(deleteBtnLbl, il.deleteWhiteIcon);
    }//GEN-LAST:event_deleteBtnLblMouseEntered

    private void deleteBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(deleteBtnLbl, il.deleteRedIcon);
    }//GEN-LAST:event_deleteBtnLblMouseExited

    private void updateBtnLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnLblMouseEntered
        // TODO add your handling code here:
        func.iconSetter(updateBtnLbl, il.updateWhiteIcon);
    }//GEN-LAST:event_updateBtnLblMouseEntered

    private void updateBtnLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnLblMouseExited
        // TODO add your handling code here:
        func.iconSetter(updateBtnLbl, il.UpdatePurpleIcon);
    }//GEN-LAST:event_updateBtnLblMouseExited

    private void editBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnLblMouseClicked
        // TODO add your handling code here:
        deleteBtnLbl.setVisible(false);
        editBtnLbl.setVisible(false);
        updateBtnLbl.setVisible(true);
        func.iconSetter(iconLbl, il.editUserScreen);
        formEnable();
        updateImageIconBtn.setVisible(true);
    }//GEN-LAST:event_editBtnLblMouseClicked

    private void hidePasswordLblBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hidePasswordLblBtnMouseClicked
        // TODO add your handling code here:
        func.mouseClicked(hidePasswordLblBtn, passwordTxt);
    }//GEN-LAST:event_hidePasswordLblBtnMouseClicked

    private void deleteBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnLblMouseClicked
        // TODO add your handling code here:
        MessageDialog DialogBox = new MessageDialog(this);
        ConfirmDialog confrim = new ConfirmDialog(this);
        confrim.showMessage("Delete", "Do you want to Delete ?");
        if (confrim.getMessageType() == ConfirmDialog.MessageType.YES) {
            System.out.println("Yes");
            try {
                DB.putdata("DELETE FROM user WHERE user_id = '" + userID + "';");
                System.out.println("Data Deleted");
                DialogBox.showMessage("Deleted", "User Deleted", 1);
                um.setTable();
                this.dispose();

            } catch (Exception ex) {
                System.out.println("Delete Button Mouse Clicked (User Details) : " + ex.getMessage());
            }
        } else {
            System.out.println("No");
        }

    }//GEN-LAST:event_deleteBtnLblMouseClicked

    private void updateBtnLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnLblMouseClicked
        // TODO add your handling code here:
        updateUser();
        um.setTable();

    }//GEN-LAST:event_updateBtnLblMouseClicked

    private void updateImageIconBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateImageIconBtnMouseClicked
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
                //Image newImage = img.getScaledInstance(imageAvatar.getWidth(), imageAvatar.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(img);

                //profileImageLbl.setIcon(icon);
                imageAvatar.setIcon(icon);
                imageAvatar.setVisible(false);
                imageAvatar.setVisible(true);
            }
        } else {
            DialogBox.showMessage("Error !!! ", "Please Select a Image File", 3);
        }

    }//GEN-LAST:event_updateImageIconBtnMouseClicked

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
            java.util.logging.Logger.getLogger(UserDetails.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserDetails.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserDetails.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserDetails.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        UserManagement um = new UserManagement();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserDetails ud = new UserDetails(um);
                ud.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel deleteBtnLbl;
    private javax.swing.JLabel editBtnLbl;
    private com.zx.shopmanagementsystem.components.RoundedText fullNameTxt;
    private com.zx.shopmanagementsystem.components.Head head1;
    private javax.swing.JLabel hidePasswordLblBtn;
    private javax.swing.JLabel iconLbl;
    private com.zx.shopmanagementsystem.components.ImageAvatar imageAvatar;
    private com.zx.shopmanagementsystem.components.RoundedPassword passwordTxt;
    private com.zx.shopmanagementsystem.components.ComboBoxSuggestion roleCombo;
    private javax.swing.JLabel updateBtnLbl;
    private javax.swing.JLabel updateImageIconBtn;
    private com.zx.shopmanagementsystem.components.RoundedText userNameTxt;
    // End of variables declaration//GEN-END:variables
    /* public void setUserId(int uid) {
        this.userID = uid;
    }*/

    public void dataLoad(int userid) {
        InputStream input;
        FileOutputStream output;
        System.out.println("Data Load UserID : " + userid);
        userID = userid;
        try {
            ResultSet rs = DB.getdata("SELECT * FROM user WHERE user_id = " + userid + ";");
            while (rs.next()) {
                String userName = rs.getString("user_name");
                String fullName = rs.getString("full_name");
                String password = rs.getString("password");
                int userRoleId = rs.getInt("user_role_id");
                comboLoader(userRoleId);

                File file = new File("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\DBProfileImages\\img" + userid + ".png");
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

                userNameTxt.setText(userName);
                fullNameTxt.setText(fullName);
                passwordTxt.setText(password);
                break;
            }
        } catch (Exception ex) {
            System.out.println("Data Load Function (User Details): " + ex.getMessage());
        }
    }

    private void comboLoader(int index) {
        try {
            ResultSet rs = DB.getdata("SELECT * FROM user_role ;");
            roleCombo.addItem("Select Role");
            while (rs.next()) {
                String roleName = rs.getString("role_name");
                roleCombo.addItem(roleName);
            }
            roleCombo.setSelectedIndex(index);
        } catch (Exception ex) {
            System.out.println("Combo Loader Function (User Details) : " + ex.getMessage());
        }
    }

    private void formDisable() {
        userNameTxt.setEditable(false);
        passwordTxt.setEditable(false);
        fullNameTxt.setEditable(false);
        roleCombo.setEnabled(false);
    }

    private void formEnable() {
        //userNameTxt.setEditable(true);
        passwordTxt.setEditable(true);
        fullNameTxt.setEditable(true);
        roleCombo.setEnabled(true);

    }

    private void updateUser() {
        MessageDialog DialogBox = new MessageDialog(this);
        String userName = userNameTxt.getText();
        String password = passwordTxt.getText();
        String fullName = fullNameTxt.getText();
        int roleId = roleCombo.getSelectedIndex();

        try {
            profilePicture = new FileInputStream(path);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (userName.equals("")) {
            System.out.println("User Name Empty");
            DialogBox.showMessage("WARNING", "User Name Empty", 2);
        } else if (password.equals("")) {
            System.out.println("User Password Empty");
            DialogBox.showMessage("WARNING", "User Password Empty", 2);
        } else if (fullName.equals("")) {
            System.out.println("Full Name Empty");
            DialogBox.showMessage("WARNING", "Full Name Empty", 2);
        } else if (roleId == 0) {
            System.out.println("Select User Role");
            DialogBox.showMessage("WARNING", "Select User Role", 2);
        } else {
            ConfirmDialog confrim = new ConfirmDialog(this);
            confrim.showMessage("Update", "Do you want to Update ?");
            if (confrim.getMessageType() == ConfirmDialog.MessageType.YES) {
                System.out.println("Yes");
                try {
                    PreparedStatement pst = DB.con().prepareStatement("UPDATE user SET user_name = ?, password = ?, full_name = ?, profile_pic = ?, user_role_id = ? WHERE user_id = ?");

                    pst.setString(1, userName);
                    pst.setString(2, password);
                    pst.setString(3, fullName);
                    pst.setBinaryStream(4, profilePicture);
                    pst.setInt(5, roleId);
                    pst.setInt(6, userID); // Assuming you have a variable 'userId' for specifying which user to update

                    pst.executeUpdate();
                    System.out.println("Data Updated");
                    DialogBox.showMessage("Done", "User Updated", 1);
                    File file = new File("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\DBProfileImages\\img" + userID + ".png");
                    System.out.println("user id : " + userID);
                    file.delete();
                    formDisable();
                    updateBtnLbl.setVisible(false);
                    updateImageIconBtn.setVisible(false);
                    editBtnLbl.setVisible(true);
                    deleteBtnLbl.setVisible(true);
                    func.iconSetter(iconLbl, il.userDetailsScreen);

                } catch (Exception ex) {
                    System.out.println("User Details Update Button : " + ex.getMessage());
                }
            } else {
                System.out.println("No");
            }

        }

    }

}
