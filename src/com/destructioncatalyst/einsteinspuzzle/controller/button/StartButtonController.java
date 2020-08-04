package com.destructioncatalyst.einsteinspuzzle.controller.button;

import com.destructioncatalyst.einsteinspuzzle.model.Solver;
import com.destructioncatalyst.einsteinspuzzle.view.compatibility.IMessagePopup;
import com.destructioncatalyst.einsteinspuzzle.view.compatibility.IPanelContainer;
import com.destructioncatalyst.einsteinspuzzle.view.compatibility.ITextInput;

public class StartButtonController extends BasicNextButtonController {

    private final ITextInput dimension;
    private final ITextInput numberOfElements;
    private final IMessagePopup messagePopup;

    public StartButtonController(ITextInput dimensionTextField,
                                 ITextInput numberOfElementsTextField,
                                 IPanelContainer mainFrame, IMessagePopup messagePopup)
    {

        dimension = dimensionTextField;
        numberOfElements = numberOfElementsTextField;
        this.messagePopup = messagePopup;
        this.mainFrame = mainFrame;

    }


    @Override
    public void actionPerformed() {
        int dim;
        int num;

        dim = parse(dimension, false);
        num = parse(numberOfElements, false, (dim > -1));

        if((dim > 0) && (num > 0)){

            Solver.getInstance().setDimensions(dim, num);
            mainFrame.initializeTableFactory(dim, num);

            nextPanel();

        }

    }


    private int parse(ITextInput text) {
        return parse(text, true);
    }

    private int parse(ITextInput text, boolean allowsZero) {
        return parse(text, allowsZero, true);
    }

    private int parse(ITextInput text, boolean allowsZero, boolean showError){
        int res;
        try {
            res = Integer.parseInt(text.getText());
            if ((res < 0) || (!allowsZero && (res == 0))) throw new NumberFormatException();
            text.setBackground(255, 255, 255);
        }
        catch (NumberFormatException e){
            if(showError)
                messagePopup.showError(
                        "Некорректный ввод!",
                        "Ошибка!");
            text.setBackground(255,60, 60);
            return -1;
        }
        return res;
    }
}
