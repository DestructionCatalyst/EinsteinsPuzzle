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

    @Override
    public boolean showChoice(String message) {
        int result = JOptionPane.showConfirmDialog(null,
                message,
                "Сообщение",
                JOptionPane.YES_NO_OPTION);

        return result == JOptionPane.YES_OPTION;
    }
}
