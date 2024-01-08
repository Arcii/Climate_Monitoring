package com.climatemonitoring.clientCM.gui.views;

import com.climatemonitoring.clientCM.gui.controllers.PoiSearchResultGUIController;
import com.climatemonitoring.shared.models.PointOfInterest;
import com.climatemonitoring.shared.models.User;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Represents the window where the results of Points of Interests searches are visualized.
 *
 * <p>
 * This class extends <code>JFrame</code> and provides a graphical user interface for displaying
 * search results related to Points of Interests (POI). It includes a table to show
 * the details of the search results and buttons for user interactions.
 * </p>
 *
 * @author Lorenzo Cattapan 726459 (Varese)
 * @version 0.9.0
 * @see PoiSearchResultGUIController
 */
public class PoiSearchResultGUI extends JFrame {

    //*****************FIELDS*****************//

    /**
     * The main panel containing the elements of the POI search result window.
     */
    private JPanel poiSearchResultPanel;
    /**
     * Label displaying the title of the application.
     */
    private JLabel climatemonitoringLabel;
    /**
     * Label displaying information about the search results.
     */
    private JLabel searchInfoLabel;
    /**
     * Table displaying the search results in a tabular format.
     */
    private JTable searchResultTable;
    /**
     * Panel containing the search results.
     */
    private JPanel searchResultPanel;
    /**
     * Button to navigate back to the previous screen.
     */
    private JButton backButton;
    /**
     * Button to select a Point of Interest from the search results.
     */
    private JButton selectPoiButton;
    /**
     * Scroll pane for the search result table.
     */
    private JScrollPane searchResultScroll;

    //*****************CONSTRUCTOR*****************//

    /**
     * Constructs a new instance of PoiSearchResultGUI for guest searches with the given search results.
     *
     * @param searchResults The list of PointOfInterest objects representing the search results.
     */
    public PoiSearchResultGUI(ArrayList<PointOfInterest> searchResults) {
        setTitle("Climate Monitoring");
        setContentPane(poiSearchResultPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setMinimumSize(new Dimension(1000, 650));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        new PoiSearchResultGUIController(this, searchResults, null);
    }

    /**
     * Constructs a new instance of PoiSearchResultGUI for a logged-in user (operator) with the given search results.
     *
     * @param searchResults The list of PointOfInterest objects representing the search results.
     * @param user The User object representing the current user.
     */
    public PoiSearchResultGUI(ArrayList<PointOfInterest> searchResults, User user) {
        setTitle("Climate Monitoring");
        setContentPane(poiSearchResultPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1024);// To set fixed dimensions
        new PoiSearchResultGUIController(this, searchResults, user);
    }

    //*****************GETTER AND SETTER*****************//

    /**
     * Getter for the poiSearchResultPanel.
     *
     * @return The main panel of the POI search result window.
     */
    public JPanel getPoiSearchResultPanel() {
        return poiSearchResultPanel;
    }

    /**
     * Setter for the poiSearchResultPanel.
     *
     * @param poiSearchResultPanel The main panel to set.
     */
    public void setPoiSearchResultPanel(JPanel poiSearchResultPanel) {
        this.poiSearchResultPanel = poiSearchResultPanel;
    }

    /**
     * Getter for the climatemonitoringLabel.
     *
     * @return The JLabel representing the title label in the POI search result window.
     */
    public JLabel getClimatemonitoringLabel() {
        return climatemonitoringLabel;
    }

    /**
     * Setter for the climatemonitoringLabel.
     *
     * @param climatemonitoringLabel The JLabel to set as the title label.
     */
    public void setClimatemonitoringLabel(JLabel climatemonitoringLabel) {
        this.climatemonitoringLabel = climatemonitoringLabel;
    }

    /**
     * Getter for the searchInfoLabel.
     *
     * @return The JLabel displaying information about the search results.
     */
    public JLabel getSearchInfoLabel() {
        return searchInfoLabel;
    }

    /**
     * Setter for the searchInfoLabel.
     *
     * @param searchInfoLabel The JLabel to set as the information label for search results.
     */
    public void setSearchInfoLabel(JLabel searchInfoLabel) {
        this.searchInfoLabel = searchInfoLabel;
    }

    /**
     * Getter for the searchResultPanel.
     *
     * @return The JPanel containing the search results in the POI search result window.
     */
    public JPanel getSearchResultPanel() {
        return searchResultPanel;
    }

    /**
     * Setter for the searchResultPanel.
     *
     * @param searchResultPanel The JPanel to set as the panel containing search results.
     */
    public void setSearchResultPanel(JPanel searchResultPanel) {
        this.searchResultPanel = searchResultPanel;
    }

    /**
     * Getter for the backButton.
     *
     * @return The JButton representing the back button in the POI search result window.
     */
    public JButton getBackButton() {
        return backButton;
    }

    /**
     * Setter for the backButton.
     *
     * @param backButton The JButton to set as the back button.
     */
    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    /**
     * Getter for the selectPoiButton.
     *
     * @return The JButton representing the select POI button in the POI search result window.
     */
    public JButton getSelectPoiButton() {
        return selectPoiButton;
    }

    /**
     * Setter for the selectPoiButton.
     *
     * @param selectPoiButton The JButton to set as the select POI button.
     */
    public void setSelectPoiButton(JButton selectPoiButton) {
        this.selectPoiButton = selectPoiButton;
    }

    /**
     * Getter for the searchResultTable.
     *
     * @return The JTable displaying search results in a tabular format.
     */
    public JTable getSearchResultTable() {
        return searchResultTable;
    }

    /**
     * Setter for the searchResultTable.
     *
     * @param searchResultsTable The JTable to set as the table for displaying search results.
     */
    public void setSearchResultTable(JTable searchResultsTable) {
        this.searchResultTable = searchResultsTable;
    }

    /**
     * Getter for the searchResultScroll.
     *
     * @return The JScrollPane for scrolling through the search result table.
     */
    public JScrollPane getSearchResultScroll() {
        return searchResultScroll;
    }

    /**
     * Setter for the searchResultScroll.
     *
     * @param searchResultScroll The JScrollPane to set for scrolling through search results.
     */
    public void setSearchResultScroll(JScrollPane searchResultScroll) {
        this.searchResultScroll = searchResultScroll;
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
        poiSearchResultPanel = new JPanel();
        poiSearchResultPanel.setLayout(new GridLayoutManager(8, 5, new Insets(0, 0, 0, 0), -1, -1));
        poiSearchResultPanel.setBackground(new Color(-9473675));
        poiSearchResultPanel.setForeground(new Color(-9473675));
        climatemonitoringLabel = new JLabel();
        climatemonitoringLabel.setBackground(new Color(-1));
        Font climatemonitoringLabelFont = this.$$$getFont$$$("JetBrains Mono ExtraBold", Font.BOLD, 72, climatemonitoringLabel.getFont());
        if (climatemonitoringLabelFont != null) climatemonitoringLabel.setFont(climatemonitoringLabelFont);
        climatemonitoringLabel.setForeground(new Color(-1));
        climatemonitoringLabel.setText("Climate Monitoring");
        poiSearchResultPanel.add(climatemonitoringLabel, new GridConstraints(0, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        searchResultPanel = new JPanel();
        searchResultPanel.setLayout(new BorderLayout(0, 0));
        searchResultPanel.setBackground(new Color(-9473675));
        searchResultPanel.setForeground(new Color(-9473675));
        poiSearchResultPanel.add(searchResultPanel, new GridConstraints(4, 2, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        searchResultScroll = new JScrollPane();
        searchResultPanel.add(searchResultScroll, BorderLayout.CENTER);
        searchResultTable = new JTable();
        searchResultTable.setBackground(new Color(-1));
        searchResultTable.setForeground(new Color(-16777216));
        searchResultTable.setRowSelectionAllowed(true);
        searchResultScroll.setViewportView(searchResultTable);
        backButton = new JButton();
        backButton.setBackground(new Color(-13947600));
        backButton.setForeground(new Color(-1));
        backButton.setText("Indietro");
        poiSearchResultPanel.add(backButton, new GridConstraints(6, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        selectPoiButton = new JButton();
        selectPoiButton.setBackground(new Color(-13947600));
        selectPoiButton.setForeground(new Color(-1));
        selectPoiButton.setText("Visualizza Aggregato Parametri Climatici");
        poiSearchResultPanel.add(selectPoiButton, new GridConstraints(6, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        searchInfoLabel = new JLabel();
        searchInfoLabel.setBackground(new Color(-1));
        Font searchInfoLabelFont = this.$$$getFont$$$(null, -1, 26, searchInfoLabel.getFont());
        if (searchInfoLabelFont != null) searchInfoLabel.setFont(searchInfoLabelFont);
        searchInfoLabel.setForeground(new Color(-1));
        searchInfoLabel.setText("Aree trovate :");
        poiSearchResultPanel.add(searchInfoLabel, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        poiSearchResultPanel.add(spacer1, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, new Dimension(20, 20), new Dimension(20, 20), new Dimension(20, 20), 0, false));
        final Spacer spacer2 = new Spacer();
        poiSearchResultPanel.add(spacer2, new GridConstraints(4, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, new Dimension(20, 20), new Dimension(20, 20), new Dimension(20, 20), 0, false));
        final Spacer spacer3 = new Spacer();
        poiSearchResultPanel.add(spacer3, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(20, 20), new Dimension(20, 20), new Dimension(20, 20), 0, false));
        final Spacer spacer4 = new Spacer();
        poiSearchResultPanel.add(spacer4, new GridConstraints(7, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(20, 20), new Dimension(20, 20), new Dimension(20, 20), 0, false));
        final Spacer spacer5 = new Spacer();
        poiSearchResultPanel.add(spacer5, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(20, 20), new Dimension(20, 20), new Dimension(20, 20), 0, false));
        final Spacer spacer6 = new Spacer();
        poiSearchResultPanel.add(spacer6, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(20, 20), new Dimension(20, 20), new Dimension(20, 20), 0, false));
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
        return poiSearchResultPanel;
    }

}
