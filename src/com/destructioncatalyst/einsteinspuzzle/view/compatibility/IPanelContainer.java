package com.destructioncatalyst.einsteinspuzzle.view.compatibility;

public interface IPanelContainer {

    void initializeTableFactory(int rowCount, int colCount);
    void addNames(String[] names);

    void nextPanel();
}
