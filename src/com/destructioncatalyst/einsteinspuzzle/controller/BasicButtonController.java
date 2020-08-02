package com.destructioncatalyst.einsteinspuzzle.controller;

import com.destructioncatalyst.einsteinspuzzle.view.EPanels;
import com.destructioncatalyst.einsteinspuzzle.view.FeaturePanelGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class BasicButtonController implements ActionListener{

    protected JFrame mainFrame;

    protected void nextPanel(JPanel newPanel) {

        JPanel cardPanel = (JPanel) mainFrame.getContentPane();

        cardPanel.add(EPanels.getInstance().next().toString(), newPanel);

        CardLayout layout = (CardLayout)(cardPanel.getLayout());
        layout.show(cardPanel, EPanels.getInstance().toString());
    }
}
