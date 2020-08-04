package com.destructioncatalyst.einsteinspuzzle.controller.button;

import com.destructioncatalyst.einsteinspuzzle.exceptions.EmptyRuleException;
import com.destructioncatalyst.einsteinspuzzle.model.Solver;
import com.destructioncatalyst.einsteinspuzzle.view.compatibility.IMessagePopup;
import com.destructioncatalyst.einsteinspuzzle.view.compatibility.IPanelContainer;
import com.destructioncatalyst.einsteinspuzzle.view.compatibility.tables.IBinaryStateButton;
import com.destructioncatalyst.einsteinspuzzle.view.compatibility.tables.IFixedNamesMutableTable;

public class NextRuleButtonController extends BasicNextButtonController{


    private final IFixedNamesMutableTable table;
    private final IBinaryStateButton checkButton;
    private final IMessagePopup messagePopup;

    public NextRuleButtonController(IFixedNamesMutableTable tab,
                                    IBinaryStateButton checkButton,
                                    IPanelContainer frame,
                                    IMessagePopup messagePopup){

        table = tab;
        this.checkButton = checkButton;
        this.messagePopup = messagePopup;
        mainFrame = frame;
    }

    @Override
    public void actionPerformed() {

        table.finishEditing();

        try {
            Solver.getInstance().addRule(table.getContent(), checkButton.isSelected());
            nextPanel();
        }
        catch (IllegalArgumentException e){
            messagePopup.showError("Некорректное значение!");
        }
        catch (EmptyRuleException e){
            messagePopup.showError("Нельзя добавить пустое правило!");
        }



    }
}
