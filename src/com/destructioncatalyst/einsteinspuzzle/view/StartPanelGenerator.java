package com.destructioncatalyst.einsteinspuzzle.view;

import com.destructioncatalyst.einsteinspuzzle.controller.button.StartButtonController;
import com.destructioncatalyst.einsteinspuzzle.view.compatibility.IPanelContainer;
import com.destructioncatalyst.einsteinspuzzle.view.swingcomponents.IPanelGenerator;
import com.destructioncatalyst.einsteinspuzzle.view.swingcomponents.JOptionPaneMessagePopup;
import com.destructioncatalyst.einsteinspuzzle.view.swingcomponents.JTextFieldTextInput;

import javax.swing.*;
import java.awt.*;

public class StartPanelGenerator implements IPanelGenerator {

    private JPanel panel1;
    private JLabel welcomeLabel;
    private JLabel dimensionEnterLabel;
    private JTextField dimensionEnterField;
    private JButton startButton;
    private JButton helpButton;
    private JButton exitButton;
    private JLabel numberOfElementsEnterLabel;
    private JTextField numberOfElementsEnterField;

    public StartPanelGenerator(IPanelContainer containerFrame) {

        $$$setupUI$$$();

        startButton.addActionListener(
                e -> new StartButtonController(
                        (JTextFieldTextInput) dimensionEnterField,
                        (JTextFieldTextInput) numberOfElementsEnterField,
                        containerFrame,
                        new JOptionPaneMessagePopup()
                ).actionPerformed()
        );

        exitButton.addActionListener((event) -> System.exit(0));
    }

    @Override
    public JPanel getPanel() {
        return panel1;
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        final JScrollPane scrollPane1 = new JScrollPane();
        panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(10, 1, new Insets(5, 5, 5, 5), 0, 0));
        panel1.setAlignmentY(0.0f);
        panel1.setAutoscrolls(true);
        panel1.setDoubleBuffered(true);
        scrollPane1.setViewportView(panel1);
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        welcomeLabel = new JLabel();
        Font welcomeLabelFont = this.$$$getFont$$$(null, -1, 28, welcomeLabel.getFont());
        if (welcomeLabelFont != null) welcomeLabel.setFont(welcomeLabelFont);
        welcomeLabel.setHorizontalAlignment(0);
        welcomeLabel.setText("Добро пожаловать в программу для решения загадки Эйнштейна!");
        welcomeLabel.setVerticalAlignment(1);
        welcomeLabel.setVerticalTextPosition(1);
        panel1.add(welcomeLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        Font dimensionEnterFieldFont = this.$$$getFont$$$(null, -1, 16, dimensionEnterField.getFont());
        if (dimensionEnterFieldFont != null) dimensionEnterField.setFont(dimensionEnterFieldFont);
        dimensionEnterField.setMargin(new Insets(2, 6, 2, 6));
        panel1.add(dimensionEnterField, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        startButton = new JButton();
        startButton.setMargin(new Insets(0, 10, 0, 10));
        startButton.setText("Начать");
        startButton.setVerticalAlignment(0);
        panel1.add(startButton, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(300, 50), new Dimension(300, 50), new Dimension(300, 50), 0, false));
        helpButton = new JButton();
        helpButton.setMargin(new Insets(0, 10, 0, 10));
        helpButton.setText("Помощь");
        helpButton.setVerticalAlignment(0);
        panel1.add(helpButton, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(300, 50), new Dimension(300, 50), new Dimension(300, 50), 0, false));
        exitButton = new JButton();
        exitButton.setMargin(new Insets(0, 10, 0, 10));
        exitButton.setText("Выйти");
        exitButton.setVerticalAlignment(0);
        panel1.add(exitButton, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(300, 50), new Dimension(300, 50), new Dimension(300, 50), 0, false));
        dimensionEnterLabel = new JLabel();
        dimensionEnterLabel.setAlignmentX(0.5f);
        Font dimensionEnterLabelFont = this.$$$getFont$$$(null, -1, 16, dimensionEnterLabel.getFont());
        if (dimensionEnterLabelFont != null) dimensionEnterLabel.setFont(dimensionEnterLabelFont);
        dimensionEnterLabel.setHorizontalAlignment(0);
        dimensionEnterLabel.setHorizontalTextPosition(0);
        dimensionEnterLabel.setText(" Введите количество параметров элементов (кроме положения):");
        dimensionEnterLabel.setVerticalAlignment(1);
        dimensionEnterLabel.setVerticalTextPosition(1);
        panel1.add(dimensionEnterLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        numberOfElementsEnterLabel = new JLabel();
        numberOfElementsEnterLabel.setAlignmentX(0.5f);
        Font numberOfElementsEnterLabelFont = this.$$$getFont$$$(null, -1, 16, numberOfElementsEnterLabel.getFont());
        if (numberOfElementsEnterLabelFont != null) numberOfElementsEnterLabel.setFont(numberOfElementsEnterLabelFont);
        numberOfElementsEnterLabel.setHorizontalAlignment(0);
        numberOfElementsEnterLabel.setHorizontalTextPosition(0);
        numberOfElementsEnterLabel.setText(" Введите количество элементов:");
        numberOfElementsEnterLabel.setVerticalAlignment(1);
        numberOfElementsEnterLabel.setVerticalTextPosition(1);
        panel1.add(numberOfElementsEnterLabel, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        Font numberOfElementsEnterFieldFont = this.$$$getFont$$$(null, -1, 16, numberOfElementsEnterField.getFont());
        if (numberOfElementsEnterFieldFont != null) numberOfElementsEnterField.setFont(numberOfElementsEnterFieldFont);
        numberOfElementsEnterField.setMargin(new Insets(2, 6, 2, 6));
        panel1.add(numberOfElementsEnterField, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(9, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 400), new Dimension(-1, 400), new Dimension(-1, 400), 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    private void createUIComponents() {

        dimensionEnterField = new JTextFieldTextInput();
        numberOfElementsEnterField = new JTextFieldTextInput();
    }
}
