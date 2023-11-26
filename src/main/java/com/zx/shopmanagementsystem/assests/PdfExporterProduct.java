package com.zx.shopmanagementsystem.assests;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import javax.swing.JTable;
import java.io.FileOutputStream;

public class PdfExporterProduct {

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
            addTableHeader(pdfTable, table);
            addRows(pdfTable, table);

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
        for (int column = 0; column < table.getColumnCount(); column++) {
            pdfTable.addCell(new Phrase(table.getColumnName(column)));
        }
    }

    private static void addRows(PdfPTable pdfTable, JTable table) {
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                Object value = table.getValueAt(i, j);
                pdfTable.addCell(new Phrase(value != null ? value.toString() : ""));
            }
        }
    }
}
