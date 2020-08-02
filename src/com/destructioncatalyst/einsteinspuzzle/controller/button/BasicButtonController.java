package com.destructioncatalyst.einsteinspuzzle.controller.button;

import com.destructioncatalyst.einsteinspuzzle.controller.SolutionController;
import com.destructioncatalyst.einsteinspuzzle.view.EPanels;
import com.destructioncatalyst.einsteinspuzzle.view.PanelGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class BasicButtonController implements ActionListener{

    protected JFrame mainFrame;

    protected static final SolutionController solutionController = new SolutionController();

    protected void nextPanel(PanelGenerator panelGenerator) {

        JPanel cardPanel = (JPanel) mainFrame.getContentPane();

        cardPanel.add(EPanels.getInstance().next().toString(), panelGenerator.getPanel());

        CardLayout layout = (CardLayout)(cardPanel.getLayout());
        layout.show(cardPanel, EPanels.getInstance().toString());
    }
}
