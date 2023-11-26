package com.zx.shopmanagementsystem.assests;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import javax.swing.JTable;
import java.io.FileOutputStream;
import java.text.DecimalFormat;

public class PdfExporter {

    public static void exportToPdf(JTable table, String filePath) {
        Document document = new Document();
        FileOutputStream fileOut = null;
        PdfWriter writer = null;

        try {
            fileOut = new FileOutputStream(filePath);
            writer = PdfWriter.getInstance(document, fileOut);

            document.open();

            // Add table
            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
            pdfTable.setWidthPercentage(100); // Set table width to 100%
            addTableHeader(pdfTable, table);
            addRows(pdfTable, table);
            addTotalRow(pdfTable, table);

            document.add(pdfTable);

            System.out.println("PDF file written successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (document != null) {
                document.close();
            }
            if (fileOut != null) {
                try {
                    fileOut.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                writer.close();
            }
        }
    }

    private static void addTableHeader(PdfPTable pdfTable, JTable table) {
        Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        for (int column = 0; column < table.getColumnCount(); column++) {
            PdfPCell cell = new PdfPCell(new Phrase(table.getColumnName(column), headerFont));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfTable.addCell(cell);
        }
    }

    private static void addRows(PdfPTable pdfTable, JTable table) {
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                Object value = table.getValueAt(i, j);
                PdfPCell cell = new PdfPCell(new Phrase(value != null ? value.toString() : ""));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfTable.addCell(cell);
            }
        }
    }

    private static void addTotalRow(PdfPTable pdfTable, JTable table) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        Font totalFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

        // Add empty cells for the first two columns
        pdfTable.addCell("");
        pdfTable.addCell("");

        // Calculate and add the sum of total products sold (third column)
        double totalProductsSold = 0;
        for (int i = 0; i < table.getRowCount(); i++) {
            double value = Double.parseDouble((String) table.getValueAt(i, 2));
            totalProductsSold += value;
        }

        PdfPCell totalProductsSoldValueCell = new PdfPCell(new Phrase("Total Product Sold : " + decimalFormat.format(totalProductsSold), totalFont));
        totalProductsSoldValueCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfTable.addCell(totalProductsSoldValueCell);

        // Calculate and add the sum of total sales (fourth column)
        double totalSales = 0;
        for (int i = 0; i < table.getRowCount(); i++) {
            double value = Double.parseDouble((String) table.getValueAt(i, 3));
            totalSales += value;
        }

        PdfPCell totalSalesValueCell = new PdfPCell(new Phrase("Total Sales : " + decimalFormat.format(totalSales), totalFont));
        totalSalesValueCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfTable.addCell(totalSalesValueCell);
    }

}
