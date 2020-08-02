package com.destructioncatalyst.einsteinspuzzle.view.tables;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.util.ArrayList;

public class AttributeTable extends JTable {


    public AttributeTable(DefaultTableModel tableModel){
        super(tableModel);

        final int lineHeight = 30;
        final int firstColumnWidth = 125;

        setAutoResizeMode(AUTO_RESIZE_OFF);
        setRowHeight(lineHeight);

        getColumnModel().getColumn(0).setPreferredWidth(firstColumnWidth);



        setVisible(true);
    }

    private static Object[] generateHeader(int objectCount){

        Object[] header = new Object[objectCount + 1];

        header[0] = "Названия свойств";

        for(int i = 1; i <= objectCount; i++){
            header[i] = i;
        }

        return header;
    }

    public static DefaultTableModel generateTableModel(int dimension, int objectCount){

        DefaultTableModel tm = new DefaultTableModel();

        tm.setColumnIdentifiers(generateHeader(objectCount));
        tm.setRowCount(dimension);

        return tm;
    }

    /*
    @Override
    public boolean isCellEditable(int row, int column) {
        if((row == 0) || column == 0)
            return false;
        return super.isCellEditable(row, column);
    }
    */

    public String[] firstColumn(){

        String[] res = new String[getRowCount()];

        for (int i = 0; i < getRowCount(); i++) {
            res[i] = (String) getValueAt(i, 0);
        }

        return res;
    }

    public ArrayList<String> getLine(int index){

        ArrayList<String> line = new ArrayList<>();

        String tmp;

        for (int i = 1; i < getColumnCount(); i++) {
            tmp = (String) getValueAt(index, i);

            if(line.contains(tmp)){
                return null;
            }
            else
                line.add(tmp);
        }

        return line;

    }

    public ArrayList<String>[] getContent(){

        ArrayList<String>[] lines = new ArrayList[getRowCount()];

        for (int i = 0; i < getRowCount(); i++) {

            lines[i] = getLine(i);
        }

       return lines;

    }

}
