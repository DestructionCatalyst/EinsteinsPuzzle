package com.destructioncatalyst.einsteinspuzzle.view.swingcomponents.tables;

import com.destructioncatalyst.einsteinspuzzle.view.compatibility.tables.IImmutableTable;

import javax.swing.table.DefaultTableModel;

public class ResultTable extends BasicTable implements IImmutableTable {

    public ResultTable(DefaultTableModel tableModel) {
        super(tableModel);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    private void setLine(int index, String[] line){

        if (line.length != getColumnCount() - 1)
            throw new IllegalArgumentException();

        for (int i = 1; i < line.length; i++) {

            setValueAt(line[i], index, i);
        }
    }

    @Override
    public void setNames(String[] names) {

        for (int i = 0; i < getRowCount(); i++) {

            setValueAt(names[i], i, 0);
        }
    }

    @Override
    public void setContent(String[][] content) {

        for (int i = 0; i < getRowCount(); i++) {

            setLine(i, content[i]);
        }

    }
}
