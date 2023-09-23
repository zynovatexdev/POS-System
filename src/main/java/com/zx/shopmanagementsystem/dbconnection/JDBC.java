/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zx.shopmanagementsystem.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {

    static String url = "jdbc:mysql://localhost:3306/shopdb";

    public static Connection con() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, "root", "1234");
        return con;
    }

    public void putdata(String sql) throws Exception {
        Statement st = con().createStatement();
        st.executeUpdate(sql);

    }

    public ResultSet getdata(String sql) throws Exception {
        Statement st = con().createStatement();
        ResultSet r = st.executeQuery(sql);
        return r;

    }
}
