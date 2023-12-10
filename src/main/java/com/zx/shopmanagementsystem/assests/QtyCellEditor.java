package com.zx.shopmanagementsystem.assests;

import com.zx.shopmanagementsystem.components.Spinner;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.text.DefaultFormatter;

public class QtyCellEditor extends DefaultCellEditor {

    private JSpinner input;

    public QtyCellEditor() {
        super(new JCheckBox());
        input = new JSpinner();
        SpinnerNumberModel numberModel = (SpinnerNumberModel) input.getModel();
        numberModel.setMinimum(0);
        JSpinner.NumberEditor editor = (JSpinner.NumberEditor) input.getEditor();
        DefaultFormatter formatter = (DefaultFormatter) editor.getTextField().getFormatter();
        formatter.setCommitsOnValidEdit(true);

        // Set the UI to the system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        super.getTableCellEditorComponent(table, value, isSelected, row, column);
        double qyt = Double.parseDouble(value.toString());
        input.setValue(qyt);
        return input;
    }

    @Override
    public Object getCellEditorValue() {
        return input.getValue();
    }
}
