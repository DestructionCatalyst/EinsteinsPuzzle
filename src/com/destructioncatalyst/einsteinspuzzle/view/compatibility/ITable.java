package com.destructioncatalyst.einsteinspuzzle.view.compatibility;

import java.util.ArrayList;

public interface ITable {

    String[] firstColumn();
    ArrayList<String>[] getContent();
    void finishEditing();
}
