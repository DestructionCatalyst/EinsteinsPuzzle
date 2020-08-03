package com.destructioncatalyst.einsteinspuzzle.view.compatibility.tables;

import com.destructioncatalyst.einsteinspuzzle.view.compatibility.tables.unimplemented.IFixedNamesTable;

import java.util.ArrayList;

public interface IImmutableTable extends IFixedNamesTable {

    void setNames(String[] names);
    void setContent(ArrayList<String>[] content);
}
