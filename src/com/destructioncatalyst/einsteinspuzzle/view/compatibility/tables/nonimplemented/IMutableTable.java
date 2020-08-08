package com.destructioncatalyst.einsteinspuzzle.view.compatibility.tables.nonimplemented;

public interface IMutableTable extends ITable{

    String[][] getContent();
    void finishEditing();
}
