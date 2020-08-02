package com.destructioncatalyst.einsteinspuzzle.view.swingcomponents;

import com.destructioncatalyst.einsteinspuzzle.view.compatibility.IMessagePopup;

import javax.swing.*;

public class JOptionPaneMessagePopup implements IMessagePopup {


    @Override
    public void showMessage(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void showError(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }
}
