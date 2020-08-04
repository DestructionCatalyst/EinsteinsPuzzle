package com.destructioncatalyst.einsteinspuzzle.view;

import com.destructioncatalyst.einsteinspuzzle.view.compatibility.IPanelContainer;
import com.destructioncatalyst.einsteinspuzzle.view.swingcomponents.IPanelGenerator;
import com.destructioncatalyst.einsteinspuzzle.view.swingcomponents.tables.SwingTableFactory;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame implements IPanelContainer {

    private EPanels panelNames;

    private SwingTableFactory factory;

    public MyFrame() throws HeadlessException {
        super("Загадка Эйнштейна");

        panelNames = EPanels.START;

        JPanel cardPanel = new JPanel(new CardLayout());
        JPanel startPanel = new StartPanelGenerator(this).getPanel();

        cardPanel.add(panelNames.toString(), startPanel);

        CardLayout layout = (CardLayout)(cardPanel.getLayout());
        layout.show(cardPanel, panelNames.toString());

        setContentPane(cardPanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(0, 0, 1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    @Override
    public void initializeTableFactory(int rowCount, int colCount) {

        factory = new SwingTableFactory(rowCount, colCount);
    }

    @Override
    public void addNames(String[] names) {

        factory.addNames(names);
    }

    @Override
    public void nextPanel(){

        IPanelGenerator myPanelGenerator;

        panelNames = panelNames.next();

        switch (panelNames){
            case START:
                myPanelGenerator = new StartPanelGenerator(this);
                break;
            case FEATURE:
                myPanelGenerator = new FeaturePanelGenerator(factory, this);
                break;
            case RULE:
                myPanelGenerator = new RulePanelGenerator(factory, this);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + panelNames);
        }

        JPanel cardPanel = (JPanel) getContentPane();

        cardPanel.add(panelNames.toString(), myPanelGenerator.getPanel());

        CardLayout layout = (CardLayout)(cardPanel.getLayout());
        layout.show(cardPanel, panelNames.toString());
    }
}
