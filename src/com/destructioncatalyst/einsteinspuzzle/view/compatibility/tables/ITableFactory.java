package com.destructioncatalyst.einsteinspuzzle.view.compatibility.tables;

public interface ITableFactory {

    void addNames(String[] names);

    IFullyMutableTable getAttributeTable();
    IFixedNamesMutableTable getRuleTable();
    IImmutableTable getResultTable(String[][] content);
}
