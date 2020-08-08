package com.destructioncatalyst.einsteinspuzzle.view.swingcomponents.tables;

import com.destructioncatalyst.einsteinspuzzle.view.compatibility.tables.IFixedNamesMutableTable;
import com.destructioncatalyst.einsteinspuzzle.view.compatibility.tables.IFullyMutableTable;
import com.destructioncatalyst.einsteinspuzzle.view.compatibility.tables.IImmutableTable;
import com.destructioncatalyst.einsteinspuzzle.view.compatibility.tables.ITableFactory;

import javax.swing.table.DefaultTableModel;

public class SwingTableFactory implements ITableFactory {

    private final int mRowCount;
    private final int mRolCount;

    private String[] names;

    public SwingTableFactory(int rowCount, int colCount) {

        this.mRowCount = rowCount;
        this.mRolCount = colCount;
    }

    @Override
    public void addNames(String[] names){

        this.names = names;
    }

    @Override
    public IFullyMutableTable getAttributeTable() {

        return new AttributeTable(generateTableModel(mRowCount, mRolCount));
    }

    @Override
    public IFixedNamesMutableTable getRuleTable() {

        RuleTable table = new RuleTable(generateTableModel(mRowCount, mRolCount));

        table.setNames(names);

        return table;
    }

    @Override
    public IImmutableTable getResultTable(String[][] content) {

        ResultTable table = new ResultTable(generateTableModel(mRowCount, mRolCount));

        table.setNames(names);
        table.setContent(content);

        return table;
    }

    private Object[] generateHeader(int rowCount){

        Object[] header = new Object[rowCount + 1];

        header[0] = "Названия свойств";

        for(int i = 1; i <= rowCount; i++){
            header[i] = i;
        }

        return header;
    }

    private DefaultTableModel generateTableModel(int rowCount, int colCount){

        DefaultTableModel tm = new DefaultTableModel();

        tm.setColumnIdentifiers(generateHeader(colCount));
        tm.setRowCount(rowCount);

        return tm;
    }
}
