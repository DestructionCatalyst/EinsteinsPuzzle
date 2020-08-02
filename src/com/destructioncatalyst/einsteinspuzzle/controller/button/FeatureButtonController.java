package com.destructioncatalyst.einsteinspuzzle.controller.button;

import com.destructioncatalyst.einsteinspuzzle.model.conversion.FeatureConverter;
import com.destructioncatalyst.einsteinspuzzle.view.compatibility.IAttributeTable;
import com.destructioncatalyst.einsteinspuzzle.view.compatibility.IPanelContainer;


public class FeatureButtonController extends BasicNextButtonController {

    IAttributeTable table;

    public FeatureButtonController(IAttributeTable tab, IPanelContainer frame){

        table = tab;
        mainFrame = frame;
    }

    @Override
    public void actionPerformed() {

        FeatureConverter converter = new FeatureConverter(table.firstColumn(), table.getContent());

        System.out.println(converter.toString());

        solutionController.addFeatureConverter(converter);

        //TODO go to next panel

    }
}
