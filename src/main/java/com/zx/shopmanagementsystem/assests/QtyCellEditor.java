package com.zx.shopmanagementsystem.assests;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.DefaultFormatter;

public class QtyCellEditor extends DefaultCellEditor {

    private JSpinner input;

    public QtyCellEditor() {
        super(new JCheckBox());
        input = new JSpinner();
        input.setUI(new CustomSpinnerUI()); // Set the custom spinner UI
        SpinnerNumberModel numberModel = (SpinnerNumberModel) input.getModel();
        numberModel.setMinimum(0);
        JSpinner.NumberEditor editor = (JSpinner.NumberEditor) input.getEditor();
        DefaultFormatter formatter = (DefaultFormatter) editor.getTextField().getFormatter();
        formatter.setCommitsOnValidEdit(true);

        // Set the UI to the system look and feel
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
