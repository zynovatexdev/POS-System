/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.zx.shopmanagementsystem.forms;

import com.zx.shopmanagementsystem.chart.ModelChart;
import com.zx.shopmanagementsystem.chart.ModelData;
import com.zx.shopmanagementsystem.dbconnection.JDBC;
import java.awt.Color;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Analysis extends javax.swing.JPanel {

    /**
     * Creates new form Home
     */
    JDBC DB = new JDBC();

    public Analysis() {
        initComponents();
        setChart();
        setData();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chart = new com.zx.shopmanagementsystem.chart.CurveLineChart();
        noticeTxt = new javax.swing.JLabel();
        iconLbl = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1116, 718));
        setPreferredSize(new java.awt.Dimension(1015, 738));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chart.setBackground(new java.awt.Color(0, 51, 51));
        chart.setForeground(new java.awt.Color(0, 0, 0));
        chart.setFont(new java.awt.Font("Poppins Medium", 1, 13)); // NOI18N
        add(chart, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 75, 1050, 610));

        noticeTxt.setFont(new java.awt.Font("Poppins Medium", 1, 24)); // NOI18N
        noticeTxt.setForeground(new java.awt.Color(42, 44, 116));
        noticeTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noticeTxt.setText("Not Enough Data.");
        add(noticeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 80, 1050, 600));

        iconLbl.setIcon(new javax.swing.ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\images\\Analysis.png")); // NOI18N
        add(iconLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.zx.shopmanagementsystem.chart.CurveLineChart chart;
    private javax.swing.JLabel iconLbl;
    private javax.swing.JLabel noticeTxt;
    // End of variables declaration//GEN-END:variables

    private void setData() {
        String sql = "SELECT\n"
                + "    month,\n"
                + "    COALESCE(ROUND(SUM(total_sales), 2), 0) AS total_sales,\n"
                + "    COALESCE(ROUND(SUM(total_profit), 2), 0) AS total_profit,\n"
                + "    COALESCE(ROUND(SUM(total_expenses), 2), 0) AS total_expenses\n"
                + "FROM (\n"
                + "    -- Subquery for total sales and profit\n"
                + "    SELECT\n"
                + "        DATE_FORMAT(date, '%Y-%m') AS month,\n"
                + "        SUM(price) AS total_sales,\n"
                + "        SUM(profit) AS total_profit,\n"
                + "        0 AS total_expenses\n"
                + "    FROM\n"
                + "        shopdb.sold_items\n"
                + "    WHERE\n"
                + "        date BETWEEN CURDATE() - INTERVAL 7 MONTH AND CURDATE()\n"
                + "    GROUP BY\n"
                + "        month\n"
                + "\n"
                + "    UNION ALL\n"
                + "\n"
                + "    -- Subquery for total expenses\n"
                + "    SELECT\n"
                + "        DATE_FORMAT(expenses_date, '%Y-%m') AS month,\n"
                + "        0 AS total_sales,\n"
                + "        0 AS total_profit,\n"
                + "        SUM(expenses_amount) AS total_expenses\n"
                + "    FROM\n"
                + "        shopdb.expenses\n"
                + "    WHERE\n"
                + "        expenses_date BETWEEN CURDATE() - INTERVAL 7 MONTH AND CURDATE()\n"
                + "    GROUP BY\n"
                + "        month\n"
                + ") AS combined_data\n"
                + "GROUP BY\n"
                + "    month\n"
                + "ORDER BY\n"
                + "    month DESC;";
        try {
            ResultSet resultSet = DB.getdata(sql);
            int rowCount = 0;
            while (resultSet.next()) {
                rowCount++;
            }
            if (rowCount >= 3) {
                noticeTxt.setVisible(false);
                chart.setVisible(true);
                try {
                    List<ModelData> list = new ArrayList<>();
                    ResultSet rs = DB.getdata(sql); // Convert to date for sorting
                    while (rs.next()) {
                        String date = rs.getString("month");
                        double sale = Double.parseDouble(rs.getString("total_sales"));
                        double profit = Double.parseDouble(rs.getString("total_profit"));
                        double expenses = Double.parseDouble(rs.getString("total_expenses"));
                        list.add(new ModelData(date, sale, profit, expenses));
                    }
                    rs.close();

                    for (ModelData d : list) {
                        chart.addData(new ModelChart(d.getDate(), new double[]{d.getProfit(), d.getSale(), d.getExpenses()}));
                    }
                    chart.start();
                } catch (Exception ex) {
                    System.err.println("Analisis SetData : " + ex.getMessage());
                }
            } else {
                noticeTxt.setVisible(true);
                chart.setVisible(false);
                System.out.println("The result set has 3 > rows.");
            }
        } catch (Exception ex) {
            System.err.println("Analysis -> Set Data (Row Check) : " + ex.getMessage());
        }

    }

    private void setChart() {
        chart.setTitle("Sales and Profit");
        chart.addLegend("Profit", Color.decode("#f56942"), Color.decode("#fafa00"));
        chart.addLegend("Sales", Color.decode("#00fa21"), Color.decode("#0021fa"));
        chart.addLegend("Expenses", Color.decode("#6441A5"), Color.decode("#2a0845"));
    }

}
