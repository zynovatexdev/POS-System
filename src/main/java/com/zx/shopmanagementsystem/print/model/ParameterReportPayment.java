/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zx.shopmanagementsystem.print.model;

import java.io.InputStream;
import java.util.List;

/**
 *
 * @author Aruna Chinthaka
 */
public class ParameterReportPayment {

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the customer
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    /**
     * @return the total
     */
    public String getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(String total) {
        this.total = total;
    }

    /**
     * @return the logo
     */
    public InputStream getLogo() {
        return logo;
    }

    /**
     * @param logo the logo to set
     */
    public void setLogo(InputStream logo) {
        this.logo = logo;
    }

    /**
     * @return the qrcode
     */
    public InputStream getQrcode() {
        return qrcode;
    }

    /**
     * @param qrcode the qrcode to set
     */
    public void setQrcode(InputStream qrcode) {
        this.qrcode = qrcode;
    }

    /**
     * @return the fields
     */
    public List<FieldReportPayment> getFields() {
        return fields;
    }

    /**
     * @param fields the fields to set
     */
    public void setFields(List<FieldReportPayment> fields) {
        this.fields = fields;
    }

    public ParameterReportPayment(String date, String time, String customer, String total, InputStream logo, InputStream qrcode, List<FieldReportPayment> fields) {
        this.date = date;
        this.time = time;
        this.customer = customer;
        this.total = total;
        this.logo = logo;
        this.qrcode = qrcode;
        this.fields = fields;
    }

    public ParameterReportPayment() {
    }

    private String date;
    private String time;
    private String customer;
    private String total;
    private InputStream logo;
    private InputStream qrcode;
    private List<FieldReportPayment> fields;
}
