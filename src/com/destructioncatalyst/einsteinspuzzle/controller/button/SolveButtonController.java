package com.destructioncatalyst.einsteinspuzzle.controller.button;

import com.destructioncatalyst.einsteinspuzzle.model.Solver;
import com.destructioncatalyst.einsteinspuzzle.view.compatibility.IMessagePopup;
import com.destructioncatalyst.einsteinspuzzle.view.compatibility.IPanelContainer;

public class SolveButtonController extends BasicNextButtonController {

    private final IMessagePopup messagePopup;

    public SolveButtonController(IPanelContainer frame, IMessagePopup messagePopup) {

        mainFrame = frame;
        this.messagePopup = messagePopup;
    }

    @Override
    public void actionPerformed() {

        System.out.println(
        messagePopup.showChoice("Заполнить неопределенные места в решении возможными вариантами?\n" +
                "(Внимание, если введенная задача не имеет однозначного решения, таких вариантов может быть очень много)")
        );
        System.out.println(Solver.getInstance().solve());

    }
}
