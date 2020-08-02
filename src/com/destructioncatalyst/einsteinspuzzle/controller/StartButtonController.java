package com.destructioncatalyst.einsteinspuzzle.controller;

import com.destructioncatalyst.einsteinspuzzle.view.EPanels;
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
        int dim = -1;
        int num = -1;

        dim = parse(dimension);
        num = parse(numberOfElements, false, (dim > -1));

        if((dim + num) > 0){

            nextPanel(new FeaturePanelGenerator(dim, num, mainFrame).getPanel());

            /*
            JPanel cardPanel = (JPanel) mainFrame.getContentPane();

            JPanel featurePanel = new FeaturePanelGenerator(dim, num, mainFrame).getPanel();
            cardPanel.add(EPanels.FEATURE.toString(), featurePanel);

            CardLayout layout = (CardLayout)(cardPanel.getLayout());
            layout.show(cardPanel, EPanels.getInstance().next().toString());
            */


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
