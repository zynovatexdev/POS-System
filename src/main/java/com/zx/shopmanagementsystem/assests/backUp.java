/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zx.shopmanagementsystem.assests;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.zx.shopmanagementsystem.dbconnection.JDBC;
import java.sql.Blob;
import java.sql.ResultSet;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author User
 */
public class backUp {

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
        String time;

        try {
            ResultSet rs = DB.getdata("SELECT * FROM cash_payment");
            while (rs.next()) {
                cashInvoiceId = rs.getInt("cash_invoice_id");
                paymentMethodId = rs.getInt("payment_method_id");
                customerId = rs.getInt("customer_id");
                invoiceCategoryId = rs.getInt("invoice_category_id");
                date = rs.getString("date");
                price = rs.getString("price");
                time = rs.getString("time");

                data.put("time", time);
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

    public void backUpDiscount() {
        Map<String, Object> data = new HashMap<>();
        int discountId;
        String stratDate;
        String endDate;
        String discountPresentage;

        try {
            ResultSet rs = DB.getdata("SELECT * FROM discont");
            while (rs.next()) {
                discountId = rs.getInt("discount_id");
                stratDate = rs.getString("start_date");
                endDate = rs.getString("end_date");
                discountPresentage = rs.getString("discount_presentage");

                data.put("discount_id", discountId);
                data.put("start_date", stratDate);
                data.put("end_date", endDate);
                data.put("discount_presentage", discountPresentage);

                backUp("Discount", String.valueOf(discountId), data);

            }
        } catch (Exception e) {
            System.out.println("Backup Discount : " + e.getMessage());
        }
        System.out.println("Discount BackUp Run");
    }

    public void backUpProductCategory() {
        Map<String, Object> data = new HashMap<>();
        int categoryId;
        String categoryName;

        try {
            ResultSet rs = DB.getdata("SELECT * FROM product_category");
            while (rs.next()) {
                categoryId = rs.getInt("category_id");
                categoryName = rs.getString("category_name");

                data.put("category_id", categoryId);
                data.put("category_name", categoryName);

                backUp("Product Category", String.valueOf(categoryId), data);

            }
        } catch (Exception e) {
            System.out.println("Backup Product Category : " + e.getMessage());
        }
        System.out.println("Product Category BackUp Run");
    }

    public void backUpProductType() {
        Map<String, Object> data = new HashMap<>();
        int typeId;
        String type;
        String description;

        try {
            ResultSet rs = DB.getdata("SELECT * FROM product_type");
            while (rs.next()) {
                typeId = rs.getInt("product_type_id");
                type = rs.getString("product_type");
                description = rs.getString("product_type_description");

                data.put("product_type_id", typeId);
                data.put("product_type", type);
                data.put("product_type_description", description);

                backUp("Product Type", String.valueOf(typeId), data);

            }
        } catch (Exception e) {
            System.out.println("Backup Product Type : " + e.getMessage());
        }
        System.out.println("Product Type BackUp Run");
    }

    public void backUpCustomerCategory() {
        Map<String, Object> data = new HashMap<>();
        int categoryId;
        String type;
        String description;

        try {
            ResultSet rs = DB.getdata("SELECT * FROM customer_category");
            while (rs.next()) {
                categoryId = rs.getInt("customer_category_id");
                type = rs.getString("customer_type");
                description = rs.getString("customer_category_description");

                data.put("customer_category_id", categoryId);
                data.put("customer_type", type);
                data.put("customer_category_description", description);

                backUp("Customer Category", String.valueOf(categoryId), data);

            }
        } catch (Exception e) {
            System.out.println("Backup Customer Category : " + e.getMessage());
        }
        System.out.println("Customer Category BackUp Run");
    }

    public void backUpDebt() {
        Map<String, Object> data = new HashMap<>();
        int debtId;
        int paymentMethod;
        int customerId;
        String totalAmount;
        String installmentPayment;
        String outstandingAmount;
        String lastPayAmount;
        String stratDate;
        String nextDate;
        String lastPayDate;

        try {
            ResultSet rs = DB.getdata("SELECT * FROM debt");
            while (rs.next()) {
                debtId = rs.getInt("debt_id");
                paymentMethod = rs.getInt("payment_method");
                customerId = rs.getInt("customer_id");
                totalAmount = rs.getString("total_amount");
                installmentPayment = rs.getString("installment_payment");
                outstandingAmount = rs.getString("outstanding_amount");
                lastPayAmount = rs.getString("last_pay_amount");
                stratDate = rs.getString("start_date");
                nextDate = rs.getString("next_date");
                lastPayDate = rs.getString("last_pay_date");

                data.put("debt_id", debtId);
                data.put("payment_method", paymentMethod);
                data.put("customer_id", customerId);
                data.put("total_amount", totalAmount);
                data.put("installment_payment", installmentPayment);
                data.put("outstanding_amount", outstandingAmount);
                data.put("last_pay_amount", lastPayAmount);
                data.put("start_date", stratDate);
                data.put("next_date", nextDate);
                data.put("last_pay_date", lastPayDate);

                backUp("Debt", String.valueOf(debtId), data);

            }
        } catch (Exception e) {
            System.out.println("Backup Debt : " + e.getMessage());
        }
        System.out.println("Debt BackUp Run");
    }

    public void backUpDebtInvoice() {
        Map<String, Object> data = new HashMap<>();
        int invoiceId;
        int debtId;
        int invoiceCategoryId;
        String dateAndTime;
        String note;

        try {
            ResultSet rs = DB.getdata("SELECT * FROM debt_invoice");
            while (rs.next()) {
                invoiceId = rs.getInt("invoice_id");
                debtId = rs.getInt("debt_id");
                invoiceCategoryId = rs.getInt("invoice_category_id");
                dateAndTime = rs.getString("date_and_time");
                note = rs.getString("note");

                data.put("invoice_id", invoiceId);
                data.put("debt_id", debtId);
                data.put("invoice_category_id", invoiceCategoryId);
                data.put("date_and_time", dateAndTime);
                data.put("note", note);

                backUp("Debt Invoice", String.valueOf(invoiceId), data);

            }
        } catch (Exception e) {
            System.out.println("Backup Debt Invoice : " + e.getMessage());
        }
        System.out.println("Debt Invoice BackUp Run");
    }

    public void backUpInvoiceCategory() {
        Map<String, Object> data = new HashMap<>();
        int invoiceCategoryId;
        String invoiceCategoryType;
        String invoiceCategoryDescription;

        try {
            ResultSet rs = DB.getdata("SELECT * FROM invoice_catergory");
            while (rs.next()) {
                invoiceCategoryId = rs.getInt("invoice_category_id");
                invoiceCategoryType = rs.getString("invoice_category_type");
                invoiceCategoryDescription = rs.getString("invoice_category_description");

                data.put("invoice_category_id", invoiceCategoryId);
                data.put("invoice_category_type", invoiceCategoryType);
                data.put("invoice_category_description", invoiceCategoryDescription);

                backUp("Invoice Category", String.valueOf(invoiceCategoryId), data);

            }
        } catch (Exception e) {
            System.out.println("Backup Invoice Category : " + e.getMessage());
        }
        System.out.println("Invoice Category BackUp Run");
    }

    public void backUpPaymentMethod() {
        Map<String, Object> data = new HashMap<>();
        int id;
        String type;

        try {
            ResultSet rs = DB.getdata("SELECT * FROM payment_method");
            while (rs.next()) {
                id = rs.getInt("payment_method_id");
                type = rs.getString("payment_method_type");

                data.put("payment_method_id", id);
                data.put("payment_method_type", type);

                backUp("Payment Method", String.valueOf(id), data);

            }
        } catch (Exception e) {
            System.out.println("Backup Invoice Category : " + e.getMessage());
        }
        System.out.println("Invoice Category BackUp Run");
    }

    public void backupReceipt() {
        Map<String, Object> data = new HashMap<>();
        int receiptId;
        String date;
        String time;
        int invoiceId;
        int debtInvoiceId;

        try {
            ResultSet rs = DB.getdata("SELECT * FROM receipt");
            while (rs.next()) {
                receiptId = rs.getInt("receipt_id");
                date = rs.getString("date");
                time = rs.getString("time");
                invoiceId = rs.getInt("invoice_id");
                debtInvoiceId = rs.getInt("debt_invoice_id");

                data.put("receipt_id", receiptId);
                data.put("date", date);
                data.put("time", time);
                data.put("invoice_id", invoiceId);
                data.put("debt_invoice_id", debtInvoiceId);

                backUp("Receipt", String.valueOf(receiptId), data);
            }
        } catch (Exception e) {
            System.out.println("Backup Receipt: " + e.getMessage());
        }
        System.out.println("Receipt Backup Run");
    }

    public void backupReturnInvoice() {
        Map<String, Object> data = new HashMap<>();
        int returnId;
        String returnTime;
        String returnDate;
        String returnAmount;
        String preAmount;
        String currentAmount;
        String returnBalance;
        int invoiceId;

        try {
            ResultSet rs = DB.getdata("SELECT * FROM return_invoice");
            while (rs.next()) {
                returnId = rs.getInt("return_id");
                returnTime = rs.getString("return_time");
                returnDate = rs.getString("return_date");
                returnAmount = rs.getString("return_amount");
                preAmount = rs.getString("pre_amount");
                currentAmount = rs.getString("current_amount");
                returnBalance = rs.getString("return_balance");
                invoiceId = rs.getInt("invoice_id");

                data.put("return_id", returnId);
                data.put("return_time", returnTime);
                data.put("return_date", returnDate);
                data.put("return_amount", returnAmount);
                data.put("pre_amount", preAmount);
                data.put("current_amount", currentAmount);
                data.put("return_balance", returnBalance);
                data.put("invoice_id", invoiceId);

                backUp("Return Invoice", String.valueOf(returnId), data);
            }
        } catch (Exception e) {
            System.out.println("Backup Return Invoice: " + e.getMessage());
        }
        System.out.println("Return Invoice Backup Run");
    }

    public void backupSupplier() {
        Map<String, Object> data = new HashMap<>();
        int supplierId;
        String supplierName;
        String supplierContact;

        try {
            ResultSet rs = DB.getdata("SELECT * FROM supplier");
            while (rs.next()) {
                supplierId = rs.getInt("supplier_id");
                supplierName = rs.getString("supplier_name");
                supplierContact = rs.getString("supplier_contact");

                data.put("supplier_id", supplierId);
                data.put("supplier_name", supplierName);
                data.put("supplier_contact", supplierContact);

                backUp("Supplier", String.valueOf(supplierId), data);
            }
        } catch (Exception e) {
            System.out.println("Backup Supplier: " + e.getMessage());
        }
        System.out.println("Supplier Backup Run");
    }

    public void backupUser() {
        Map<String, Object> data = new HashMap<>();
        int userId;
        String userName;
        String password;
        String fullName;
        String profilePicBase64; // Store the profile picture as a Base64 encoded string
        int userRoleId;

        try {
            ResultSet rs = DB.getdata("SELECT * FROM user");
            while (rs.next()) {
                userId = rs.getInt("user_id");
                userName = rs.getString("user_name");
                password = rs.getString("password");
                fullName = rs.getString("full_name");

                // Read the image as a byte array
                Blob profilePic = rs.getBlob("profile_pic");
                if (profilePic != null) {
                    byte[] profilePicBytes = profilePic.getBytes(1, (int) profilePic.length());
                    profilePicBase64 = Base64.getEncoder().encodeToString(profilePicBytes);
                } else {
                    profilePicBase64 = ""; // Handle the case when no image is available
                }

                userRoleId = rs.getInt("user_role_id");

                data.put("user_id", userId);
                data.put("user_name", userName);
                data.put("password", password);
                data.put("full_name", fullName);

                // Store the profile picture as a Base64 encoded string
                data.put("profile_pic", profilePicBase64);

                data.put("user_role_id", userRoleId);

                backUp("User", String.valueOf(userId), data);
            }
        } catch (Exception e) {
            System.out.println("Backup User: " + e.getMessage());
        }
        System.out.println("User Backup Run");
    }

    public void backupUserProfile() {
        Map<String, Object> data = new HashMap<>();
        int userProfileId;
        String date;
        String time;
        String sale;
        String profit;
        int userId;

        try {
            ResultSet rs = DB.getdata("SELECT * FROM user_profile");
            while (rs.next()) {
                userProfileId = rs.getInt("user_profile_id");
                date = rs.getString("date");
                time = rs.getString("time");
                sale = rs.getString("sale");
                profit = rs.getString("profit");
                userId = rs.getInt("user_id");

                data.put("user_profile_id", userProfileId);
                data.put("date", date);
                data.put("time", time);
                data.put("sale", sale);
                data.put("profit", profit);
                data.put("user_id", userId);

                backUp("User Profile", String.valueOf(userProfileId), data);
            }
        } catch (Exception e) {
            System.out.println("Backup User Profile: " + e.getMessage());
        }
        System.out.println("User Profile Backup Run");
    }

    public void backupAll() {
        backUpUserRole();
        backUpBarcode();
        backUpCashPayment();
        backUpCustomer();
        backUpDiscount();
        backUpProduct();
        backUpProductCategory();
        backUpProductType();
        backUpCustomerCategory();
        backUpDebt();
        backUpDebtInvoice();
        backUpInvoiceCategory();
        backUpPaymentMethod();
        backupReceipt();
        backupReturnInvoice();
        backupSupplier();
        backupUser();
        backupUserProfile();
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
