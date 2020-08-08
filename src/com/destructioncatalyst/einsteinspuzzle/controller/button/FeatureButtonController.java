package com.destructioncatalyst.einsteinspuzzle.controller.button;

import com.destructioncatalyst.einsteinspuzzle.model.Solver;
import com.destructioncatalyst.einsteinspuzzle.model.conversion.FeatureConverter;
import com.destructioncatalyst.einsteinspuzzle.view.compatibility.IMessagePopup;
import com.destructioncatalyst.einsteinspuzzle.view.compatibility.IPanelContainer;
import com.destructioncatalyst.einsteinspuzzle.view.compatibility.tables.IFullyMutableTable;


public class FeatureButtonController extends BasicNextButtonController {

    private final IFullyMutableTable table;
    private final IMessagePopup messagePopup;

    public FeatureButtonController(IFullyMutableTable tab, IPanelContainer frame, IMessagePopup messagePopup){

        table = tab;
        this.messagePopup = messagePopup;
        mainFrame = frame;
    }

    @Override
    public void actionPerformed() {

        table.finishEditing();

        try {

            FeatureConverter converter = new FeatureConverter(table.getNames(), table.getContent());
            Solver.getInstance().addFeatureConverter(converter);

            mainFrame.addNames(table.getNames());

            nextPanel();
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
            messagePopup.showError("Таблица не должна содержать пустых или повторяющихся значений");
        }


    }
}
