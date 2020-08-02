package com.destructioncatalyst.einsteinspuzzle.controller.button;

import com.destructioncatalyst.einsteinspuzzle.controller.IListener;
import com.destructioncatalyst.einsteinspuzzle.controller.SolutionController;
import com.destructioncatalyst.einsteinspuzzle.view.compatibility.IPanelContainer;

public abstract class BasicNextButtonController implements IListener {

    protected IPanelContainer mainFrame;

    protected static final SolutionController solutionController = new SolutionController();

    protected void nextPanel() {

        mainFrame.nextPanel(solutionController);
    }
}
