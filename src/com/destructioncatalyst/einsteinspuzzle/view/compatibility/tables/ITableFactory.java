package com.destructioncatalyst.einsteinspuzzle.view.compatibility.tables;

import java.util.ArrayList;

public interface ITableFactory {

    IFullyMutableTable getAttributeTable();
    IFixedNamesMutableTable getRuleTable(String[] names);
    IImmutableTable getResultTable(String[] names, ArrayList<String>[] content);
}
