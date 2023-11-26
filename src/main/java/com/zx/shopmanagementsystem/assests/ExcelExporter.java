package com.zx.shopmanagementsystem.assests;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.JTable;
import java.io.FileOutputStream;
import java.text.DecimalFormat;

public class ExcelExporter {

    public static void exportToExcel(JTable table, String filePath) {
        XSSFWorkbook workbook = null;
        FileOutputStream fileOut = null;

        try {
            workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Sheet1");

            // Set styles for bold header and bordered cells
            XSSFCellStyle boldStyle = workbook.createCellStyle();
            Font boldFont = workbook.createFont();
            boldFont.setBold(true);
            boldStyle.setFont(boldFont);

            XSSFCellStyle borderedStyle = workbook.createCellStyle();
            borderedStyle.setBorderTop(BorderStyle.THIN);
            borderedStyle.setBorderBottom(BorderStyle.THIN);
            borderedStyle.setBorderLeft(BorderStyle.THIN);
            borderedStyle.setBorderRight(BorderStyle.THIN);

            // Write headers to the first row
            Row headerRow = sheet.createRow(0);
            for (int j = 0; j < table.getColumnCount(); j++) {
                String headerValue = table.getColumnName(j);
                Cell headerCell = headerRow.createCell(j);
                headerCell.setCellValue(headerValue);
                headerCell.setCellStyle(boldStyle); // Apply bold style
                sheet.setColumnWidth(j, (headerValue.length() + 2) * 256); // Adjust column width
            }

            // Write data to the subsequent rows
            double totalProductsSold = 0.0;
            double totalSales = 0.0;

            for (int i = 0; i < table.getRowCount(); i++) {
                Row row = sheet.createRow(i + 1); // Start from the second row (index 1)
                for (int j = 0; j < table.getColumnCount(); j++) {
                    Object value = table.getValueAt(i, j);
                    Cell cell = row.createCell(j);
                    cell.setCellStyle(borderedStyle); // Apply bordered style

                    // Format third and fourth columns as numbers with two decimal points
                    if (j == 2 || j == 3) {
                        if (value instanceof Number) {
                            cell.setCellValue(((Number) value).doubleValue());
                        } else if (value instanceof String) {
                            try {
                                cell.setCellValue(Double.parseDouble((String) value));
                            } catch (NumberFormatException e) {
                                cell.setCellValue(value.toString());
                            }
                        } else {
                            cell.setCellValue(value.toString());
                        }
                    } else {
                        cell.setCellValue(value.toString());
                    }

                    // Calculate totals for the third and fourth columns
                    if (j == 2) {
                        totalProductsSold += cell.getNumericCellValue();
                    } else if (j == 3) {
                        totalSales += cell.getNumericCellValue();
                    }
                }
            }

            // Add total Products sold and sum of total sales at the end of their respective columns
            Row totalRow = sheet.createRow(table.getRowCount() + 1);
            Cell totalProductsSoldCell = totalRow.createCell(2);
            totalProductsSoldCell.setCellValue("Total Product Sold : " + totalProductsSold);
            totalProductsSoldCell.setCellStyle(borderedStyle);

            Cell totalSalesCell = totalRow.createCell(3);
            totalSalesCell.setCellValue("Total Sales : " + totalSales);
            totalSalesCell.setCellStyle(borderedStyle);

            fileOut = new FileOutputStream(filePath);
            workbook.write(fileOut);
            System.out.println("Excel file written successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (fileOut != null) {
                try {
                    fileOut.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
