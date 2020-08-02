package com.destructioncatalyst.einsteinspuzzle;

import com.destructioncatalyst.einsteinspuzzle.view.EPanels;
import com.destructioncatalyst.einsteinspuzzle.view.FeaturePanelGenerator;
import com.destructioncatalyst.einsteinspuzzle.view.StartPanelGenerator;

import javax.swing.*;
import java.awt.*;

public class Launcher {
    public static void main(String[] args){

        JFrame jf = new JFrame("Загадка Эйнштейна");

        JPanel cardPanel = new JPanel(new CardLayout());
        JPanel startPanel = new StartPanelGenerator(jf).getPanel();
        //JPanel featurePanel = new FeaturePanelGenerator(15, 15, jf).getPanel();

        cardPanel.add(EPanels.START.toString(), startPanel);


        CardLayout layout = (CardLayout)(cardPanel.getLayout());
        layout.show(cardPanel, EPanels.getInstance().toString());


        jf.setContentPane(cardPanel);

        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setBounds(0, 0, 1024, 768);
        jf.setVisible(true);
    }
}
