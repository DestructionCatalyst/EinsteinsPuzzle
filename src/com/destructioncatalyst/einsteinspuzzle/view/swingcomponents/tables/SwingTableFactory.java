package com.destructioncatalyst.einsteinspuzzle.view.swingcomponents.tables;

import com.destructioncatalyst.einsteinspuzzle.view.compatibility.tables.IFixedNamesMutableTable;
import com.destructioncatalyst.einsteinspuzzle.view.compatibility.tables.IFullyMutableTable;
import com.destructioncatalyst.einsteinspuzzle.view.compatibility.tables.IImmutableTable;
import com.destructioncatalyst.einsteinspuzzle.view.compatibility.tables.ITableFactory;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class SwingTableFactory implements ITableFactory {

    private static SwingTableFactory instance = null;

    private int mRowCount;
    private int mRolCount;

    private SwingTableFactory(int rowCount, int colCount) {
        this.mRowCount = rowCount;
        this.mRolCount = colCount;
    }

    private static void initialize(int dimension, int objectCount){

        instance = new SwingTableFactory(dimension, objectCount);

    }

    public static SwingTableFactory getInstance(){

        if (instance == null) {
            throw new NullPointerException
                    ("Table Factory has not been initialized yet, use initialize(int, int) first");
        }

        return instance;
    }


    @Override
    public IFullyMutableTable getAttributeTable() {

        return new AttributeTable(generateTableModel(mRowCount, mRolCount));
    }

    @Override
    public IFixedNamesMutableTable getRuleTable(String[] names) {

        RuleTable table = new RuleTable(generateTableModel(mRowCount, mRolCount));

        table.setNames(names);

        return table;
    }

    @Override
    public IImmutableTable getResultTable(String[] names, ArrayList<String>[] content) {

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
