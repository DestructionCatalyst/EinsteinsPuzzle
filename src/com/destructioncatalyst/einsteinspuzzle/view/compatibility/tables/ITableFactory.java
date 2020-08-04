package com.destructioncatalyst.einsteinspuzzle.view.compatibility.tables;

import java.util.ArrayList;

public interface ITableFactory {

    void addNames(String[] names);

    IFullyMutableTable getAttributeTable();
    IFixedNamesMutableTable getRuleTable();
    IImmutableTable getResultTable(ArrayList<String>[] content);
}
