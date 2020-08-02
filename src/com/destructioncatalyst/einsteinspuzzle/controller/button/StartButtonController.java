package com.destructioncatalyst.einsteinspuzzle.controller.button;

import com.destructioncatalyst.einsteinspuzzle.view.FeaturePanelGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class StartButtonController extends BasicButtonController{

    private final JTextField dimension;
    private final JTextField numberOfElements;

    public StartButtonController(JTextField dimensionTextField,
                                 JTextField numberOfElementsTextField,
                                 JFrame mainFrame)
    {

        dimension = dimensionTextField;
        numberOfElements = numberOfElementsTextField;
        this.mainFrame = mainFrame;

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int dim;
        int num;

        dim = parse(dimension);
        num = parse(numberOfElements, false, (dim > -1));

        if((dim + num) > 0){

            solutionController.setDimensions(dim, num);
            nextPanel(new FeaturePanelGenerator(
                    solutionController.getDimension(),
                    solutionController.getObjectCount(),
                    mainFrame
                    ).getPanel()
            );

        }

    }


    private int parse(JTextField text) {
        return parse(text, true);
    }

    private int parse(JTextField text, boolean allowsZero) {
        return parse(text, allowsZero, true);
    }

    private int parse(JTextField text, boolean allowsZero, boolean showError){
        int res;
        try {
            res = Integer.parseInt(text.getText());
            if ((res < 0) || (!allowsZero && (res == 0))) throw new NumberFormatException();
            text.setBackground(Color.WHITE);
        }
        catch (NumberFormatException e){
            if(showError)
                JOptionPane.showMessageDialog(null,
                        "Некорректный ввод!",
                        "Ошибка!",
                        JOptionPane.ERROR_MESSAGE);
            text.setBackground(new Color(255,60, 60));
            return -1;
        }
        return res;
    }
}
