package com.zx.shopmanagementsystem.table;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class DeleteButtonEditorRenderer extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
    
    private JButton deleteButton;
    private JTable table;
    private int selectedRow = -1;
    private int selectedColumn = -1;
    
    public DeleteButtonEditorRenderer() {
        // Create a JButton with an icon
        ImageIcon deleteIcon = new ImageIcon("C:\\ShopManagementSystem\\src\\main\\java\\com\\zx\\shopmanagementsystem\\icons\\deleteIcon.png");
        deleteButton = new JButton(deleteIcon);
        
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the delete button click event here
                if (selectedRow != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.removeRow(selectedRow);
                    fireEditingStopped();
                }
            }
        });
        deleteButton.setBackground(Color.red);
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.table = table;
        this.selectedRow = row;
        this.selectedColumn = column;
        return deleteButton;
    }
    
    @Override
    public Object getCellEditorValue() {
        return deleteButton;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return deleteButton;
    }
}
