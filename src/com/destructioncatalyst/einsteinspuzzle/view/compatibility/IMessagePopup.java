package com.destructioncatalyst.einsteinspuzzle.view.compatibility;

public interface IMessagePopup {

    void showMessage(String message);
    void showError(String message);
    boolean showChoice(String message);
}
