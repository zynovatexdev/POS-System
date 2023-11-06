/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zx.shopmanagementsystem.chart;

/**
 *
 * @author User
 */
public class ModelData {

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
     * @return the sale
     */
    public double getSale() {
        return sale;
    }

    /**
     * @param sale the sale to set
     */
    public void setSale(double sale) {
        this.sale = sale;
    }

    /**
     * @return the profit
     */
    public double getProfit() {
        return profit;
    }

    /**
     * @param profit the profit to set
     */
    public void setProfit(double profit) {
        this.profit = profit;
    }

    public ModelData(String date, double sale, double profit) {
        this.date = date;
        this.sale = sale;
        this.profit = profit;
    }

    private String date;
    private double sale;
    private double profit;
}
