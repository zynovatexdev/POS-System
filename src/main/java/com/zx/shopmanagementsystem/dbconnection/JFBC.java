/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zx.shopmanagementsystem.dbconnection;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author User
 */
public class JFBC {

    public static Firestore DB;

    public void connectFirebase() {
        try {
            FileInputStream sa = new FileInputStream("C:\\Users\\User\\Documents\\NetBeansProjects\\ShopManagementSystem\\shopdb.json");
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(sa))
                    .build();

            FirebaseApp.initializeApp(options);
            DB = FirestoreClient.getFirestore();
            System.out.println("Success");
        } catch (IOException ex) {
            System.err.println("connectFirebase : " + ex.getMessage());
        }

    }
}
