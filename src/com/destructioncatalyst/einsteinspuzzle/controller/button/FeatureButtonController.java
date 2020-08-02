package com.destructioncatalyst.einsteinspuzzle.controller.button;

import com.destructioncatalyst.einsteinspuzzle.model.conversion.FeatureConverter;
import com.destructioncatalyst.einsteinspuzzle.view.tables.AttributeTable;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class FeatureButtonController extends BasicButtonController{

    AttributeTable table;

    public FeatureButtonController(AttributeTable tab, JFrame frame){

        table = tab;
        mainFrame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        FeatureConverter converter = new FeatureConverter(table.firstColumn(), table.getContent());
        solutionController.addFeatureConverter(converter);

        //TODO go to next panel

    }
}
