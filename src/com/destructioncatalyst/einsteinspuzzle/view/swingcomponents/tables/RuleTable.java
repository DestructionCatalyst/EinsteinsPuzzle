package com.destructioncatalyst.einsteinspuzzle.view.swingcomponents.tables;

import com.destructioncatalyst.einsteinspuzzle.view.compatibility.tables.IFixedNamesMutableTable;

import javax.swing.table.DefaultTableModel;

public class RuleTable extends BasicMutableTable implements IFixedNamesMutableTable {

    public RuleTable(DefaultTableModel tableModel) {
        super(tableModel);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        if(column == 0)
            return false;
        return super.isCellEditable(row, column);
    }


    @Override
    public void setNames(String[] names) {

        for (int i = 0; i < getRowCount(); i++) {

            setValueAt(names[i], i, 0);
        }
    }
}
