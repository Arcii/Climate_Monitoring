package com.climatemonitoring.clientCM.gui.views;

import com.climatemonitoring.clientCM.gui.controllers.CommentViewGUIController;
import com.climatemonitoring.shared.models.SurveysAggregate;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

public class CommentViewGUI extends JFrame {

    //FIELDS

    private JPanel commentsPanel;
    private JLabel climatemonitoringLabel;
    private JLabel commentsInfoLabel;
    private JTable commentsTable;
    private JPanel commentsTablePanel;
    private JScrollPane commentsTableScroll;
    private JButton closeButton;

    //CONSTRUCTOR

    public CommentViewGUI(SurveysAggregate surveysAggregate, String commentType) {
        setTitle("Climate Monitoring");
        setContentPane(commentsPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        new CommentViewGUIController(this, surveysAggregate, commentType);
    }

    //GETTER AND SETTER

    public JPanel getCommentsPanel() {
        return commentsPanel;
    }

    public void setCommentsPanel(JPanel commentsPanel) {
        this.commentsPanel = commentsPanel;
    }

    public JLabel getClimatemonitoringLabel() {
        return climatemonitoringLabel;
    }

    public void setClimatemonitoringLabel(JLabel climatemonitoringLabel) {
        this.climatemonitoringLabel = climatemonitoringLabel;
    }

    public JLabel getCommentsInfoLabel() {
        return commentsInfoLabel;
    }

    public void setCommentsInfoLabel(JLabel commentsInfoLabel) {
        this.commentsInfoLabel = commentsInfoLabel;
    }

    public JTable getCommentsTable() {
        return commentsTable;
    }

    public void setCommentsTable(JTable commentsTable) {
        this.commentsTable = commentsTable;
    }

    public JPanel getCommentsTablePanel() {
        return commentsTablePanel;
    }

    public void setCommentsTablePanel(JPanel commentsTablePanel) {
        this.commentsTablePanel = commentsTablePanel;
    }

    public JScrollPane getCommentsTableScroll() {
        return commentsTableScroll;
    }

    public void setCommentsTableScroll(JScrollPane commentsTableScroll) {
        this.commentsTableScroll = commentsTableScroll;
    }

    public JButton getCloseButton() {
        return closeButton;
    }

    public void setCloseButton(JButton closeButton) {
        this.closeButton = closeButton;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        commentsPanel = new JPanel();
        commentsPanel.setLayout(new GridLayoutManager(4, 3, new Insets(0, 0, 0, 0), -1, -1));
        commentsPanel.setBackground(new Color(-9473675));
        commentsPanel.setForeground(new Color(-9473675));
        commentsInfoLabel = new JLabel();
        commentsInfoLabel.setBackground(new Color(-1));
        Font commentsInfoLabelFont = this.$$$getFont$$$(null, -1, 18, commentsInfoLabel.getFont());
        if (commentsInfoLabelFont != null) commentsInfoLabel.setFont(commentsInfoLabelFont);
        commentsInfoLabel.setForeground(new Color(-1));
        commentsInfoLabel.setText("Label");
        commentsPanel.add(commentsInfoLabel, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        commentsTablePanel = new JPanel();
        commentsTablePanel.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        commentsTablePanel.setBackground(new Color(-9473675));
        commentsTablePanel.setForeground(new Color(-9473675));
        commentsPanel.add(commentsTablePanel, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        commentsTableScroll = new JScrollPane();
        commentsTablePanel.add(commentsTableScroll, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        commentsTable = new JTable();
        commentsTableScroll.setViewportView(commentsTable);
        final Spacer spacer1 = new Spacer();
        commentsTablePanel.add(spacer1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(20, 20), new Dimension(20, 20), new Dimension(20, 20), 1, false));
        closeButton = new JButton();
        closeButton.setBackground(new Color(-13947600));
        closeButton.setForeground(new Color(-1));
        closeButton.setText("Chiudi");
        commentsTablePanel.add(closeButton, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        commentsPanel.add(spacer2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, new Dimension(20, 20), new Dimension(20, 20), new Dimension(20, 20), 0, false));
        final Spacer spacer3 = new Spacer();
        commentsPanel.add(spacer3, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, new Dimension(20, 20), new Dimension(20, 20), new Dimension(20, 20), 0, false));
        final Spacer spacer4 = new Spacer();
        commentsPanel.add(spacer4, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(20, 20), new Dimension(20, 20), new Dimension(20, 20), 0, false));
        final Spacer spacer5 = new Spacer();
        commentsPanel.add(spacer5, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(20, 20), new Dimension(20, 20), new Dimension(20, 20), 0, false));
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
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return commentsPanel;
    }

}