package com.destructioncatalyst.einsteinspuzzle.view.swingcomponents;

import com.destructioncatalyst.einsteinspuzzle.view.compatibility.ITextInput;

import javax.swing.*;
import java.awt.*;

public class JTextFieldTextInput extends JTextField implements ITextInput {

    private final Color LIGHT_RED = new Color(255, 60, 60);

    @Override
    public void showError() {
        setBackground(LIGHT_RED);
    }

    @Override
    public void showCorrect() {
        setBackground(Color.WHITE);
    }
}
