package com.destructioncatalyst.einsteinspuzzle.view.compatibility;

public interface IMessagePopup {

    void showMessage(String message, String title);
    void showError(String message, String title);
    //TODO showChoice
}
