package com.destructioncatalyst.einsteinspuzzle.controller.button;

import com.destructioncatalyst.einsteinspuzzle.controller.SolutionController;
import com.destructioncatalyst.einsteinspuzzle.model.conversion.FeatureConverter;
import com.destructioncatalyst.einsteinspuzzle.view.compatibility.IMessagePopup;
import com.destructioncatalyst.einsteinspuzzle.view.compatibility.IPanelContainer;
import com.destructioncatalyst.einsteinspuzzle.view.compatibility.ITable;


public class FeatureButtonController extends BasicNextButtonController {

    private final ITable table;
    private final IMessagePopup messagePopup;

    public FeatureButtonController(ITable tab, IPanelContainer frame, IMessagePopup messagePopup){

        table = tab;
        this.messagePopup = messagePopup;
        mainFrame = frame;
    }

    @Override
    public void actionPerformed() {

        table.finishEditing();

        boolean success = false;

        try {
            FeatureConverter converter = new FeatureConverter(table.firstColumn(), table.getContent());

            SolutionController.getInstance().addFeatureConverter(converter);
        }
        catch (IllegalArgumentException e){
            messagePopup.showError("Таблица не должна содержать пустых или повторяющихся значений",
                    "Ошибка");
        }

        //TODO go to next panel
        nextPanel();

    }
}
