package com.destructioncatalyst.einsteinspuzzle.view.swingcomponents.tables;

import com.destructioncatalyst.einsteinspuzzle.controller.SolutionController;

import javax.swing.table.DefaultTableModel;

public abstract class TableWithHeaders extends AttributeTable{

    public TableWithHeaders(DefaultTableModel tableModel) {
        super(tableModel);

        loadHeaders();
    }

    private void loadHeaders(){

        String[] headers = SolutionController.getInstance().getFeatureHeaders();

        for (int i = 0; i < getRowCount(); i++) {

            setValueAt(headers[i], i, 0);
        }

    }
}
