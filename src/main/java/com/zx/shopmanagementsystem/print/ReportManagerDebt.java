/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zx.shopmanagementsystem.print;

import com.zx.shopmanagementsystem.print.model.ParameterReportDebt;
import com.zx.shopmanagementsystem.print.model.ParameterReportPayment;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Aruna Chinthaka
 */
public class ReportManagerDebt {

    private static ReportManagerDebt instance;

    JasperReport reportDebt;

    public static ReportManagerDebt getInstance() {
        if (instance == null) {
            instance = new ReportManagerDebt();
        }
        return instance;
    }

    private ReportManagerDebt() {
    }

    public void compileReportDebt() throws JRException {
        reportDebt = JasperCompileManager.compileReport("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\print\\report_debt.jrxml");
    }

    public void printReportDebt(ParameterReportDebt data) throws JRException {
        Map para = new HashMap();
        para.put("date", data.getDate());
        para.put("nxtdate", data.getNxtdate());
        para.put("time", data.getTime());
        para.put("customer", data.getCustomer());
        para.put("total", data.getTotal());
        para.put("outstanding", data.getOutstanding());
        para.put("logo", data.getLogo());
        para.put("qrcode", data.getQrcode());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data.getFields());
        JasperPrint print = JasperFillManager.fillReport(reportDebt, para, dataSource);
        view(print);

    }

    private void view(JasperPrint print) throws JRException {
        JasperViewer.viewReport(print, false);
    }

}
