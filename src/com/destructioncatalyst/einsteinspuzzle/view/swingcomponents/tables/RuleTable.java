package com.destructioncatalyst.einsteinspuzzle.view.swingcomponents.tables;

import javax.swing.table.DefaultTableModel;

public class RuleTable extends TableWithHeaders{

    public RuleTable(DefaultTableModel tableModel) {
        super(tableModel);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        if(column == 0)
            return false;
        return super.isCellEditable(row, column);
    }


}
