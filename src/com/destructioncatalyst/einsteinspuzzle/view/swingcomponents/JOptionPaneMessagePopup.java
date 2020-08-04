package com.destructioncatalyst.einsteinspuzzle.view.swingcomponents;

import com.destructioncatalyst.einsteinspuzzle.view.compatibility.IMessagePopup;

import javax.swing.*;

public class JOptionPaneMessagePopup implements IMessagePopup {


    @Override
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Сообщение", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Ошибка!", JOptionPane.ERROR_MESSAGE);
    }
}
