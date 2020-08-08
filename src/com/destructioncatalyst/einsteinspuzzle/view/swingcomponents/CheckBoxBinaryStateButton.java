package com.destructioncatalyst.einsteinspuzzle.view.swingcomponents;

import com.destructioncatalyst.einsteinspuzzle.view.compatibility.IBinaryStateButton;

import javax.swing.*;
import java.awt.event.ItemEvent;

public class CheckBoxBinaryStateButton extends JCheckBox implements IBinaryStateButton {

    boolean isChecked = false;

    public CheckBoxBinaryStateButton() {
        super();

        addItemListener(
                (e) -> isChecked = (e.getStateChange() == ItemEvent.SELECTED)
        );
    }

    @Override
    public boolean isSelected() {
        return isChecked;
    }
}
