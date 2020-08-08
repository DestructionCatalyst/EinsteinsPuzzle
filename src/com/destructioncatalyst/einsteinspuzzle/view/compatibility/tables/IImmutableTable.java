package com.destructioncatalyst.einsteinspuzzle.view.compatibility.tables;

import com.destructioncatalyst.einsteinspuzzle.view.compatibility.tables.nonimplemented.IFixedNamesTable;

public interface IImmutableTable extends IFixedNamesTable {

    void setNames(String[] names);
    void setContent(String[][] content);
}
