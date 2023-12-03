package com.zx.shopmanagementsystem.assests;

import java.io.IOException;

public class EmailSender {

    private int exitCode;

    public void emailSetter(String toEmail, String subject, String message, String FilePath, String fromEmail) {
        try {
            // Provide the path to your Python executable and the path to your Python script
            String pythonExecutable = "python";
            String pythonScript = "C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\assests\\email_sender.py";

            // Provide the arguments to your Python script
//            String toEmail = "usepersonal922@gmail.com";
//            String subject = "Email Subject";
//            String message = "Email Body";
            // Build the command to execute
            ProcessBuilder processBuilder = new ProcessBuilder(pythonExecutable, pythonScript, toEmail, fromEmail, subject, message, FilePath);

            // Start the process
            Process process = processBuilder.start();

            // Wait for the process to finish
            exitCode = process.waitFor();

            // Check the exit code
//            if (exitCode == 0) {
//                System.out.println("Email sent successfully.");
//
//            } else {
//                System.out.println("Error sending email. Exit code: " + exitCode);
//            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getExitCode() {
        return exitCode;
    }

}
