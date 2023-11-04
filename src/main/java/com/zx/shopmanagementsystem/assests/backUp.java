/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zx.shopmanagementsystem.assests;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.zx.shopmanagementsystem.dbconnection.JDBC;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author User
 */
public class backUp {

    CollectionReference reference;

    static Firestore FB;
    JDBC DB = new JDBC();

    public void backUpProduct() {
        Map<String, Object> data = new HashMap<>();
        int productId;
        String productName;
        String recivingPrice;
        String sellingPrice;
        String stockQuantity;
        String description;
        String brand;
        String dimentions;
        String manufDate;
        String expDate;
        int suplierId;
        int barcodeId;
        int categoryId;
        int typeId;
        int discountId;
        int locationId;
        try {
            ResultSet rs = DB.getdata("SELECT * FROM product");
            while (rs.next()) {
                productId = rs.getInt("product_id");
                suplierId = rs.getInt("supplier_id");
                barcodeId = rs.getInt("barcode_id");
                categoryId = rs.getInt("category_id");
                typeId = rs.getInt("product_type_id");
                discountId = rs.getInt("discount_id");
                locationId = rs.getInt("store_location_id");
                productName = rs.getString("product_name");
                recivingPrice = rs.getString("reciving_price");
                sellingPrice = rs.getString("selling_price");
                stockQuantity = rs.getString("stock_quantity");
                description = rs.getString("description");
                brand = rs.getString("brand");
                dimentions = rs.getString("dimensions");
                manufDate = rs.getString("manufacturing_date");
                expDate = rs.getString("expiry_date");

                data.put("product_id", productId);
                data.put("product_name", productName);
                data.put("reciving_price", recivingPrice);
                data.put("selling_price", sellingPrice);
                data.put("stock_quantity", stockQuantity);
                data.put("description", description);
                data.put("brand", brand);
                data.put("dimensions", dimentions);
                data.put("manufacturing_date", manufDate);
                data.put("expiry_date", expDate);
                data.put("supplier_id", suplierId);
                data.put("barcode_id", barcodeId);
                data.put("category_id", categoryId);
                data.put("product_type_id", typeId);
                data.put("discount_id", discountId);
                data.put("store_location_id", locationId);

                backUp("Product", String.valueOf(productId), data);

            }
        } catch (Exception e) {
            System.out.println("BackupProduct : " + e.getMessage());
        }
        System.out.println("Product BackUp Run");
    }

    public void backUpUserRole() {
        Map<String, Object> data = new HashMap<>();
        int roleId;
        String roleName;
        String roleDescription;

        try {
            ResultSet rs = DB.getdata("SELECT * FROM user_role");
            while (rs.next()) {
                roleId = rs.getInt("role_id");
                roleName = rs.getString("role_name");
                roleDescription = rs.getString("role_description");

                data.put("role_id", roleId);
                data.put("role_name", roleName);
                data.put("role_description", roleDescription);

                backUp("User_Role", String.valueOf(roleId), data);

            }
        } catch (Exception e) {
            System.out.println("Backup User Role : " + e.getMessage());
        }
        System.out.println("User Role BackUp Run");
    }

    public void backUpBarcode() {
        Map<String, Object> data = new HashMap<>();
        int barcodeId;
        String barcodeValue;

        try {
            ResultSet rs = DB.getdata("SELECT * FROM barcode");
            while (rs.next()) {
                barcodeId = rs.getInt("barcode_id");
                barcodeValue = rs.getString("barcode_value");

                data.put("barcode_id", barcodeId);
                data.put("barcode_value", barcodeValue);

                backUp("Barcode", String.valueOf(barcodeId), data);

            }
        } catch (Exception e) {
            System.out.println("Backup Barcode : " + e.getMessage());
        }
        System.out.println("Barcode BackUp Run");
    }

    public void backUpCashPayment() {
        Map<String, Object> data = new HashMap<>();
        int cashInvoiceId;
        int paymentMethodId;
        int customerId;
        int invoiceCategoryId;
        String date;
        String price;

        try {
            ResultSet rs = DB.getdata("SELECT * FROM cash_payment");
            while (rs.next()) {
                cashInvoiceId = rs.getInt("cash_invoice_id");
                paymentMethodId = rs.getInt("payment_method_id");
                customerId = rs.getInt("customer_id");
                invoiceCategoryId = rs.getInt("invoice_category_id");
                date = rs.getString("date");
                price = rs.getString("price");

                data.put("cash_invoice_id", cashInvoiceId);
                data.put("date", date);
                data.put("price", price);
                data.put("payment_method_id", paymentMethodId);
                data.put("customer_id", customerId);
                data.put("invoice_category_id", invoiceCategoryId);

                backUp("Cash_Payment", String.valueOf(cashInvoiceId), data);

            }
        } catch (Exception e) {
            System.out.println("Backup Cash_Payment : " + e.getMessage());
        }
        System.out.println("Cash Payment BackUp Run");
    }

    public void backUpCustomer() {
        Map<String, Object> data = new HashMap<>();
        int customerId;
        int categoryId;
        String customerName;
        String address;
        String phoneNo;

        try {
            ResultSet rs = DB.getdata("SELECT * FROM customer");
            while (rs.next()) {
                customerId = rs.getInt("customer_id");
                categoryId = rs.getInt("category_id");
                customerName = rs.getString("customer_name");
                address = rs.getString("customer_address");
                phoneNo = rs.getString("customer_phone");

                data.put("customer_id", customerId);
                data.put("category_id", categoryId);
                data.put("customer_name", customerName);
                data.put("customer_address", address);
                data.put("customer_phone", phoneNo);

                backUp("Customer", String.valueOf(customerId), data);

            }
        } catch (Exception e) {
            System.out.println("Backup Customer : " + e.getMessage());
        }
        System.out.println("Customer BackUp Run");
    }

    public void backupAll() {
        backUpProduct();
        backUpUserRole();
        backUpBarcode();
        backUpCashPayment();
        backUpCustomer();
        System.out.println("Backup All Runs");

    }

    public boolean backUp(String collection, String document, Map<String, Object> data) {
        FB = FirestoreClient.getFirestore();

        try {
            DocumentReference docRef = FB.collection(collection).document(document);
            ApiFuture<WriteResult> result = docRef.set(data);
            System.out.println("Data Saved");
            return true;
        } catch (Exception e) {
            System.err.println("backUp : " + e.getMessage());
        }
        return false;
    }
}
