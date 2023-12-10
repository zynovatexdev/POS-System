/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zx.shopmanagementsystem.print.model;

import java.io.InputStream;
import java.util.List;

/**
 *
 * @author aruna
 */
public class ParameterReportDebt {

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
     * @return the nxtdate
     */
    public String getNxtdate() {
        return nxtdate;
    }

    /**
     * @param nxtdate the nxtdate to set
     */
    public void setNxtdate(String nxtdate) {
        this.nxtdate = nxtdate;
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
     * @return the outstanding
     */
    public String getOutstanding() {
        return outstanding;
    }

    /**
     * @param outstanding the outstanding to set
     */
    public void setOutstanding(String outstanding) {
        this.outstanding = outstanding;
    }

    /**
     * @return the fields
     */
    public List<FieldReportDebt> getFields() {
        return fields;
    }

    /**
     * @param fields the fields to set
     */
    public void setFields(List<FieldReportDebt> fields) {
        this.fields = fields;
    }

    public ParameterReportDebt(InputStream logo, InputStream qrcode, String date, String nxtdate, String time, String customer, String total, String outstanding, List<FieldReportDebt> fields) {
        this.logo = logo;
        this.qrcode = qrcode;
        this.date = date;
        this.nxtdate = nxtdate;
        this.time = time;
        this.customer = customer;
        this.total = total;
        this.outstanding = outstanding;
        this.fields = fields;
    }

    public ParameterReportDebt() {
    }

    /**
     * @return the logo
     */
    private InputStream logo;
    private InputStream qrcode;
    private String date;
    private String nxtdate;
    private String time;
    private String customer;
    private String total;
    private String outstanding;
    private List<FieldReportDebt> fields;
}
