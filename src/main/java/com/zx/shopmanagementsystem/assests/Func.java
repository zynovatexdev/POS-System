/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zx.shopmanagementsystem.assests;

import com.zx.shopmanagementsystem.components.Header;
import com.zx.shopmanagementsystem.dbconnection.JDBC;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

/**
 *
 * @author User
 */
public class Func {

    IconLocation il = new IconLocation();
    JDBC DB = new JDBC();

    int barcodeExist;

    public String codeValue;

    public void iconSetter(JLabel lable, String url) {
        lable.setIcon(new javax.swing.ImageIcon(url));
    }

    boolean isHide = true;

    public void mouseClicked(JLabel lable, JPasswordField password) {

        if (isHide) {
            mouseEnter(lable, password);
            isHide = false;
        } else {
            mouseExit(lable, password);
            isHide = true;
        }
    }

    private void mouseEnter(JLabel lable, JPasswordField password) {
        password.setEchoChar((char) 0);
        iconSetter(lable, il.showPassword);
    }

    private void mouseExit(JLabel lable, JPasswordField password) {
        password.setEchoChar('*');
        iconSetter(lable, il.hidePassword);
    }

    public void closeWindow(JFrame frame) {
        frame.dispose();
    }

    public void minimiseWindow(JFrame frame) {
        frame.setExtendedState(JFrame.ICONIFIED);
    }

    public int x;
    public int y;

    public void initMoving(JFrame frame, JLabel lable) {
        lable.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                frame.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }

    public void initDashboardMoving(JFrame frame, Header header) {
        header.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                frame.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }

    public void initMovingDialog(JDialog frame, JLabel lable) {
        lable.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                frame.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }

    public static boolean isValidMobileNumber(String number) {
        // Define the regular expression pattern for Sri Lankan mobile numbers
        String regex = "^(07)\\d{8}$"; // Sri Lankan mobile numbers start with 07 followed by 8 digits

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(number);

        // Check if the input matches the pattern
        return matcher.matches();
    }

    public void setForm(JComponent panal, JComponent component) {
        panal.removeAll();
        panal.add(component);
        panal.repaint();
        panal.revalidate();
    }

    String line;

    public void barcodeDetect() {

        try {
            String pythonScript = "C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\barcode_Python\\scanner.py";
            Process process = Runtime.getRuntime().exec("python " + pythonScript);

            // Read the output from the Python script
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = reader.readLine()) != null) {
                codeValue = line;
            }

            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getCode() {
        barcodeDetect();
        return codeValue;
    }

    public int barcodeChecker(String barcode) {
        String sql = "SELECT * FROM barcode WHERE barcode_value=?";
        try {
            PreparedStatement pstmt = DB.con().prepareStatement(sql);
            pstmt.setString(1, barcode);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                System.out.println("Barcode is already taken.");
                barcodeExist = 1;
            } else {
                System.out.println("Barcode is available.");
                barcodeExist = 0;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "Barcode Checker");
        }
        return barcodeExist;
    }

    public int dateValidator(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int isValid = 0;
        try {
            // Create a Date object for the selected date (replace the string with your selected date)
            Date selectedDate = dateFormat.parse(date);

            // Get the current date
            Date currentDate = new Date();

            // Compare the two dates
            if (selectedDate.after(currentDate)) {
                System.out.println("Selected date is greater than the current date.");
                isValid = 1;
            } else if (selectedDate.before(currentDate)) {
                System.out.println("Selected date is less than the current date.");
                isValid = 2;
            }
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use 'yyyy-MM-dd' format.");
        }
        return isValid;
    }

    public void QRGenerator(String data, String name) {
        // Adjust the size as needed
        int qrCodeSize = 250;

        // Define the target folder path
        String targetFolderPath = System.getProperty("user.home") + "/Pictures/POS System QR";

        // Create the target folder if it doesn't exist
        File targetFolder = new File(targetFolderPath);
        if (!targetFolder.exists()) {
            boolean folderCreated = targetFolder.mkdirs();
            if (!folderCreated) {
                System.err.println("Failed to create the target folder.");
                return;
            }
        }

        try {
            ByteArrayOutputStream out = QRCode.from(data)
                    .withSize(qrCodeSize, qrCodeSize)
                    .to(ImageType.PNG)
                    .stream();

            // Create the file for the QR code image
            File qrCodeFile = new File(targetFolderPath, name + "_product_qr_code.png");

            // Write the QR code image to the file
            Files.write(qrCodeFile.toPath(), out.toByteArray());

            System.out.println("QR code generated and saved successfully to " + qrCodeFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
