package com.destructioncatalyst.einsteinspuzzle.view.compatibility.tables.unimplemented;

import java.util.ArrayList;

public interface IMutableTable extends ITable{

    ArrayList<String>[] getContent();
    void finishEditing();
}
