package com.destructioncatalyst.einsteinspuzzle.view.swingcomponents.tables;

import javax.swing.table.DefaultTableModel;

public class ResultTable extends TableWithHeaders{

    public ResultTable(DefaultTableModel tableModel) {
        super(tableModel);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
