package com.zx.shopmanagementsystem.assests;

import org.apache.poi.ss.usermodel.*;
import javax.swing.JTable;
import java.io.FileOutputStream;

public class ExcelExporterProduct {

    public static void exportToExcel(JTable table, String filePath) {
        Workbook workbook = null;
        FileOutputStream fileOut = null;

        try {
            workbook = WorkbookFactory.create(true);
            Sheet sheet = workbook.createSheet("Sheet1");

            for (int i = 0; i < table.getRowCount(); i++) {
                Row row = sheet.createRow(i);
                for (int j = 0; j < table.getColumnCount(); j++) {
                    Object value = table.getValueAt(i, j);
                    Cell cell = row.createCell(j);
                    if (value != null) {
                        if (value instanceof Number) {
                            cell.setCellValue(((Number) value).doubleValue());
                        } else {
                            cell.setCellValue(value.toString());
                        }
                    }
                }
            }

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
