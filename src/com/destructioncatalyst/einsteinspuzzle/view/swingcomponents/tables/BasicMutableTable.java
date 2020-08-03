package com.destructioncatalyst.einsteinspuzzle.view.swingcomponents.tables;

import com.destructioncatalyst.einsteinspuzzle.view.compatibility.tables.unimplemented.IMutableTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public abstract class BasicMutableTable extends BasicTable implements IMutableTable {

    public BasicMutableTable(DefaultTableModel tableModel) {
        super(tableModel);
    }

    private ArrayList<String> getLine(int index){

        ArrayList<String> line = new ArrayList<>();

        for (int i = 1; i < getColumnCount(); i++) {

            line.add((String) getValueAt(index, i));

        }

        return line;

    }

    @Override
    public ArrayList<String>[] getContent(){

        ArrayList<String>[] lines = new ArrayList[getRowCount()];

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
