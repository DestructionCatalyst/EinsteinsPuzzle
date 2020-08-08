package com.destructioncatalyst.einsteinspuzzle.view.swingcomponents.tables;

import com.destructioncatalyst.einsteinspuzzle.view.compatibility.tables.nonimplemented.IMutableTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public abstract class BasicMutableTable extends BasicTable implements IMutableTable {

    public BasicMutableTable(DefaultTableModel tableModel) {
        super(tableModel);
    }

    private String[] getLine(int index){

        String[] line = new String[getColumnCount() - 1];

        for (int i = 1; i < getColumnCount(); i++) {

            line[i - 1] = ((String) getValueAt(index, i));

        }

        return line;

    }

    @Override
    public String[][] getContent(){

        String[][] lines = new String[getColumnCount()][getRowCount()];

        for (int i = 0; i < getRowCount(); i++) {

            lines[i] = getLine(i);
        }

        return lines;

    }

    @Override
    public void finishEditing(){

        CellEditor editor = getCellEditor();

        if (editor != null) {
            editor.stopCellEditing();
        }

    }
}
