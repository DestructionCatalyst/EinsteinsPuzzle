package com.destructioncatalyst.einsteinspuzzle.controller.button;

import com.destructioncatalyst.einsteinspuzzle.controller.SolutionController;
import com.destructioncatalyst.einsteinspuzzle.view.EPanels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class BasicButtonController implements ActionListener{

    protected JFrame mainFrame;

    protected static final SolutionController solutionController = new SolutionController();

    protected void nextPanel(JPanel newPanel) {

        JPanel cardPanel = (JPanel) mainFrame.getContentPane();

        cardPanel.add(EPanels.getInstance().next().toString(), newPanel);

        CardLayout layout = (CardLayout)(cardPanel.getLayout());
        layout.show(cardPanel, EPanels.getInstance().toString());
    }
}
