package com.destructioncatalyst.einsteinspuzzle.view.swingcomponents.tables;

import com.destructioncatalyst.einsteinspuzzle.view.compatibility.tables.IFullyMutableTable;

import javax.swing.table.DefaultTableModel;

public class AttributeTable extends BasicMutableTable implements IFullyMutableTable {


    public AttributeTable(DefaultTableModel tableModel) {
        super(tableModel);
    }

    @Override
    public String[] getNames(){

        String[] res = new String[getRowCount()];

        for (int i = 0; i < getRowCount(); i++) {
            res[i] = (String) getValueAt(i, 0);
        }

        return res;
    }





}
