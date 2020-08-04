package com.destructioncatalyst.einsteinspuzzle.view.swingcomponents.tables;

import com.destructioncatalyst.einsteinspuzzle.view.compatibility.tables.unimplemented.ITable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public abstract class BasicTable extends JTable implements ITable {

    public BasicTable(DefaultTableModel tableModel){
        super(tableModel);

        final int lineHeight = 30;
        final int firstColumnWidth = 125;

        setAutoResizeMode(AUTO_RESIZE_OFF);
        setRowHeight(lineHeight);

        getColumnModel().getColumn(0).setPreferredWidth(firstColumnWidth);

        getTableHeader().setReorderingAllowed(false);

        setVisible(true);
    }
    
}
