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

/**
 * GUI window for visualizing comments related to a Point of Interest (POI).
 *
 * @author Lorenzo Cattapan 726459 (Varese)
 * @version 0.9.0
 * @see CommentViewGUIController
 */
public class CommentViewGUI extends JFrame {

    //*****************FIELDS*****************//

    /**
     * Panel containing the comments GUI components.
     */
    private JPanel commentsPanel;
    /**
     * Label displaying "Climate Monitoring".
     */
    private JLabel climatemonitoringLabel;
    /**
     * Label providing information about the comments.
     */
    private JLabel commentsInfoLabel;
    /**
     * Table displaying comments.
     */
    private JTable commentsTable;
    /**
     * Panel containing the comments table.
     */
    private JPanel commentsTablePanel;
    /**
     * Scroll pane for the comments table.
     */
    private JScrollPane commentsTableScroll;
    /**
     * Button to close the comments window.
     */
    private JButton closeButton;

    //*****************CONSTRUCTOR*****************//

    /**
     * Constructs an instance of CommentViewGUI.
     *
     * @param surveysAggregate SurveysAggregate instance representing the POI and related data.
     * @param commentType      Type of comments to be displayed.
     */
    public CommentViewGUI(SurveysAggregate surveysAggregate, String commentType) {
        setTitle("Climate Monitoring");
        setContentPane(commentsPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        new CommentViewGUIController(this, surveysAggregate, commentType);
    }

    //*****************GETTER AND SETTER*****************//

    /**
     * Retrieves the comments panel.
     *
     * @return JPanel instance representing the comments panel.
     */
    public JPanel getCommentsPanel() {
        return commentsPanel;
    }

    /**
     * Sets the comments panel.
     *
     * @param commentsPanel JPanel instance representing the comments panel.
     */
    public void setCommentsPanel(JPanel commentsPanel) {
        this.commentsPanel = commentsPanel;
    }

    /**
     * Retrieves the label displaying "Climate Monitoring".
     *
     * @return JLabel instance representing the "Climate Monitoring" label.
     */
    public JLabel getClimatemonitoringLabel() {
        return climatemonitoringLabel;
    }

    /**
     * Sets the "Climate Monitoring" label.
     *
     * @param climatemonitoringLabel JLabel instance representing the "Climate Monitoring" label.
     */
    public void setClimatemonitoringLabel(JLabel climatemonitoringLabel) {
        this.climatemonitoringLabel = climatemonitoringLabel;
    }

    /**
     * Retrieves the label providing information about the comments.
     *
     * @return JLabel instance representing the comments information label.
     */
    public JLabel getCommentsInfoLabel() {
        return commentsInfoLabel;
    }

    /**
     * Sets the comments information label.
     *
     * @param commentsInfoLabel JLabel instance representing the comments information label.
     */
    public void setCommentsInfoLabel(JLabel commentsInfoLabel) {
        this.commentsInfoLabel = commentsInfoLabel;
    }

    /**
     * Retrieves the table displaying comments.
     *
     * @return JTable instance representing the comments table.
     */
    public JTable getCommentsTable() {
        return commentsTable;
    }

    /**
     * Sets the comments table.
     *
     * @param commentsTable JTable instance representing the comments table.
     */
    public void setCommentsTable(JTable commentsTable) {
        this.commentsTable = commentsTable;
    }

    /**
     * Retrieves the panel containing the comments table.
     *
     * @return JPanel instance representing the comments table panel.
     */
    public JPanel getCommentsTablePanel() {
        return commentsTablePanel;
    }

    /**
     * Sets the comments table panel.
     *
     * @param commentsTablePanel JPanel instance representing the comments table panel.
     */
    public void setCommentsTablePanel(JPanel commentsTablePanel) {
        this.commentsTablePanel = commentsTablePanel;
    }

    /**
     * Retrieves the scroll pane for the comments table.
     *
     * @return JScrollPane instance representing the comments table scroll pane.
     */
    public JScrollPane getCommentsTableScroll() {
        return commentsTableScroll;
    }

    /**
     * Sets the comments table scroll pane.
     *
     * @param commentsTableScroll JScrollPane instance representing the comments table scroll pane.
     */
    public void setCommentsTableScroll(JScrollPane commentsTableScroll) {
        this.commentsTableScroll = commentsTableScroll;
    }

    /**
     * Retrieves the button to close the comments window.
     *
     * @return JButton instance representing the close button.
     */
    public JButton getCloseButton() {
        return closeButton;
    }

    /**
     * Sets the close button.
     *
     * @param closeButton JButton instance representing the close button.
     */
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