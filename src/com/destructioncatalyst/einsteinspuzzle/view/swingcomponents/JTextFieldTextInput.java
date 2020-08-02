package com.destructioncatalyst.einsteinspuzzle.view.swingcomponents;

import com.destructioncatalyst.einsteinspuzzle.view.compatibility.ITextInput;

import javax.swing.*;
import java.awt.*;

public class JTextFieldTextInput extends JTextField implements ITextInput {


    @Override
    public void setBackground(int r, int g, int b) {
        super.setBackground(new Color(r, g, b));
    }

}
