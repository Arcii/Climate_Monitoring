package com.climatemonitoring.clientCM.gui.views;

import com.climatemonitoring.clientCM.gui.controllers.CenterRegistrationGUIController;
import com.climatemonitoring.clientCM.gui.controllers.PoiSearchForRegistrationGUIController;
import com.climatemonitoring.shared.models.PointOfInterest;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * GUI class for Point of Interest (POI) search and creation during Monitoring Center registration.
 * Allows the operator to search and add POIs for the new Monitoring Center.
 *
 * @author Lorenzo Cattapan 726459 (Varese)
 * @version 0.9.0
 * @see PoiSearchForRegistrationGUIController
 */
public class PoiSearchForRegistrationGUI extends JFrame {

    //*****************FIELDS*****************//

    /**
     * Panel containing the main elements of the POI search GUI.
     */
    private JPanel poiSearchPanel;
    /**
     * Label providing information about the POI search.
     */
    private JLabel poiSearchLabel1;
    /**
     * Additional label providing information about the POI search.
     */
    private JLabel poiSearchLabel2;
    /**
     * Table displaying search results for Points of Interest.
     */
    private JTable poiSearchResultTable;
    /**
     * Text field for entering the name of the POI to search.
     */
    private JTextField nameField;
    /**
     * Text field for entering the country of the POI to search.
     */
    private JTextField countryField;
    /**
     * Text field for entering the latitude of the POI to search.
     */
    private JTextField latitudeField;
    /**
     * Text field for entering the longitude of the POI to search.
     */
    private JTextField longitudeField;
    /**
     * Button to navigate back to the previous screen.
     */
    private JButton backButton;
    /**
     * Button to add the selected POI to the list for the new Monitoring Center.
     */
    private JButton addButton;
    /**
     * Button to create a new POI and add it to the list for the new Monitoring Center.
     */
    private JButton createPoiButton;
    /**
     * Panel containing the search result display.
     */
    private JPanel poiSearchResultPanel;
    /**
     * Scroll pane for the POI search result table.
     */
    private JScrollPane poiSearchResultScroll;
    /**
     * Panel containing the form for adding a new POI.
     */
    private JPanel addPoiFormPanel;
    /**
     * Label for the name field in the add POI form.
     */
    private JLabel nameLabel;
    /**
     * Label for the country field in the add POI form.
     */
    private JLabel countryLabel;
    /**
     * Label for the latitude field in the add POI form.
     */
    private JLabel latitudeLabel;
    /**
     * Label for the longitude field in the add POI form.
     */
    private JLabel longitudeLabel;

    //*****************CONSTRUCTOR*****************//

    /**
     * Constructor for the PoiSearchForRegistrationGUI.
     *
     * @param centerRegistrationGUIController Controller for managing interactions with the Center Registration GUI.
     * @param searchResults List of PointOfInterest objects as search results.
     */
    public PoiSearchForRegistrationGUI(CenterRegistrationGUIController centerRegistrationGUIController, ArrayList<PointOfInterest> searchResults) {
        setTitle("Climate Monitoring");
        setContentPane(poiSearchPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);// To set fixed dimensions
        new PoiSearchForRegistrationGUIController(this, centerRegistrationGUIController, searchResults);
    }

    //*****************GETTER AND SETTER*****************//

    /**
     * Getter for the poiSearchPanel field.
     *
     * @return The JPanel containing the main elements of the POI search GUI.
     */
    public JPanel getPoiSearchPanel() {
        return poiSearchPanel;
    }

    /**
     * Setter for the poiSearchPanel field.
     *
     * @param poiSearchPanel The JPanel containing the main elements of the POI search GUI.
     */
    public void setPoiSearchPanel(JPanel poiSearchPanel) {
        this.poiSearchPanel = poiSearchPanel;
    }

    /**
     * Getter for the poiSearchLabel1 field.
     *
     * @return The JLabel providing information about the POI search.
     */
    public JLabel getPoiSearchLabel1() {
        return poiSearchLabel1;
    }

    /**
     * Setter for the poiSearchLabel1 field.
     *
     * @param poiSearchLabel1 The JLabel providing information about the POI search.
     */
    public void setPoiSearchLabel1(JLabel poiSearchLabel1) {
        this.poiSearchLabel1 = poiSearchLabel1;
    }

    /**
     * Getter for the poiSearchLabel2 field.
     *
     * @return The additional JLabel providing information about the POI search.
     */
    public JLabel getPoiSearchLabel2() {
        return poiSearchLabel2;
    }

    /**
     * Setter for the poiSearchLabel2 field.
     *
     * @param poiSearchLabel2 The additional JLabel providing information about the POI search.
     */
    public void setPoiSearchLabel2(JLabel poiSearchLabel2) {
        this.poiSearchLabel2 = poiSearchLabel2;
    }

    /**
     * Getter for the poiSearchResultTable field.
     *
     * @return The JTable displaying search results for Points of Interest.
     */
    public JTable getPoiSearchResultTable() {
        return poiSearchResultTable;
    }

    /**
     * Setter for the poiSearchResultTable field.
     *
     * @param poiSearchResultTable The JTable displaying search results for Points of Interest.
     */
    public void setPoiSearchResultTable(JTable poiSearchResultTable) {
        this.poiSearchResultTable = poiSearchResultTable;
    }

    /**
     * Getter for the nameField field.
     *
     * @return The JTextField for entering the name of the POI to search.
     */
    public JTextField getNameField() {
        return nameField;
    }

    /**
     * Setter for the nameField field.
     *
     * @param nameField The JTextField for entering the name of the POI to search.
     */
    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    /**
     * Getter for the countryField field.
     *
     * @return The JTextField for entering the country of the POI to search.
     */
    public JTextField getCountryField() {
        return countryField;
    }

    /**
     * Setter for the countryField field.
     *
     * @param countryField The JTextField for entering the country of the POI to search.
     */
    public void setCountryField(JTextField countryField) {
        this.countryField = countryField;
    }

    /**
     * Getter for the latitudeField field.
     *
     * @return The JTextField for entering the latitude of the POI to search.
     */
    public JTextField getLatitudeField() {
        return latitudeField;
    }

    /**
     * Setter for the latitudeField field.
     *
     * @param latitudeField The JTextField for entering the latitude of the POI to search.
     */
    public void setLatitudeField(JTextField latitudeField) {
        this.latitudeField = latitudeField;
    }

    /**
     * Getter for the longitudeField field.
     *
     * @return The JTextField for entering the longitude of the POI to search.
     */
    public JTextField getLongitudeField() {
        return longitudeField;
    }

    /**
     * Setter for the longitudeField field.
     *
     * @param longitudeField The JTextField for entering the latitude of the POI to search.
     */
    public void setLongitudeField(JTextField longitudeField) {
        this.longitudeField = longitudeField;
    }

    /**
     * Getter for the backButton field.
     *
     * @return The JButton to navigate back to the previous screen.
     */
    public JButton getBackButton() {
        return backButton;
    }

    /**
     * Setter for the backButton field.
     *
     * @param backButton The JButton to navigate back to the previous screen.
     */
    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    /**
     * Getter for the addButton field.
     *
     * @return The JButton to add the selected POI to the list for the new Monitoring Center.
     */
    public JButton getAddButton() {
        return addButton;
    }

    /**
     * Setter for the addButton field.
     *
     * @param addButton The JButton to add the selected POI to the list for the new Monitoring Center.
     */
    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    /**
     * Getter for the createPoiButton field.
     *
     * @return The JButton to create a new POI and add it to the list for the new Monitoring Center.
     */
    public JButton getCreatePoiButton() {
        return createPoiButton;
    }

    /**
     * Setter for the createPoiButton field.
     *
     * @param createPoiButton The JButton to create a new POI and add it to the list for the new Monitoring Center.
     */
    public void setCreatePoiButton(JButton createPoiButton) {
        this.createPoiButton = createPoiButton;
    }

    /**
     * Getter for the poiSearchResultPanel field.
     *
     * @return The JPanel containing the search result display.
     */
    public JPanel getPoiSearchResultPanel() {
        return poiSearchResultPanel;
    }

    /**
     * Setter for the poiSearchResultPanel field.
     *
     * @param poiSearchResultPanel The JPanel containing the search result display.
     */
    public void setPoiSearchResultPanel(JPanel poiSearchResultPanel) {
        this.poiSearchResultPanel = poiSearchResultPanel;
    }

    /**
     * Getter for the poiSearchResultScroll field.
     *
     * @return The JScrollPane for the POI search result table.
     */
    public JScrollPane getPoiSearchResultScroll() {
        return poiSearchResultScroll;
    }

    /**
     * Setter for the poiSearchResultScroll field.
     *
     * @param poiSearchResultScroll The JScrollPane for the POI search result table.
     */
    public void setPoiSearchResultScroll(JScrollPane poiSearchResultScroll) {
        this.poiSearchResultScroll = poiSearchResultScroll;
    }

    /**
     * Getter for the addPoiFormPanel field.
     *
     * @return The JPanel containing the form for adding a new POI.
     */
    public JPanel getAddPoiFormPanel() {
        return addPoiFormPanel;
    }

    /**
     * Setter for the addPoiFormPanel field.
     *
     * @param addPoiFormPanel The JPanel containing the form for adding a new POI.
     */
    public void setAddPoiFormPanel(JPanel addPoiFormPanel) {
        this.addPoiFormPanel = addPoiFormPanel;
    }

    /**
     * Getter for the nameLabel field.
     *
     * @return The JLabel for the name field in the add POI form.
     */
    public JLabel getNameLabel() {
        return nameLabel;
    }

    /**
     * Setter for the nameLabel field.
     *
     * @param nameLabel The JLabel for the name field in the add POI form.
     */
    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    /**
     * Getter for the countryLabel field.
     *
     * @return The JLabel for the country field in the add POI form.
     */
    public JLabel getCountryLabel() {
        return countryLabel;
    }

    /**
     * Setter for the countryLabel field.
     *
     * @param countryLabel The JLabel for the country field in the add POI form.
     */
    public void setCountryLabel(JLabel countryLabel) {
        this.countryLabel = countryLabel;
    }

    /**
     * Getter for the latitudeLabel field.
     *
     * @return The JLabel for the latitude field in the add POI form.
     */
    public JLabel getLatitudeLabel() {
        return latitudeLabel;
    }

    /**
     * Setter for the latitudeLabel field.
     *
     * @param latitudeLabel The JLabel for the latitude field in the add POI form.
     */
    public void setLatitudeLabel(JLabel latitudeLabel) {
        this.latitudeLabel = latitudeLabel;
    }

    /**
     * Getter for the longitudeLabel field.
     *
     * @return The JLabel for the longitude field in the add POI form.
     */
    public JLabel getLongitudeLabel() {
        return longitudeLabel;
    }

    /**
     * Setter for the longitudeLabel field.
     *
     * @param longitudeLabel The JLabel for the longitude field in the add POI form.
     */
    public void setLongitudeLabel(JLabel longitudeLabel) {
        this.longitudeLabel = longitudeLabel;
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
        poiSearchPanel = new JPanel();
        poiSearchPanel.setLayout(new GridLayoutManager(11, 5, new Insets(0, 0, 0, 0), -1, -1));
        poiSearchPanel.setBackground(new Color(-9473675));
        poiSearchPanel.setForeground(new Color(-9473675));
        poiSearchLabel1 = new JLabel();
        poiSearchLabel1.setBackground(new Color(-1));
        poiSearchLabel1.setForeground(new Color(-1));
        poiSearchLabel1.setText("Se l'area che volete aggiungere è stata trovata, selezionatela nella tabella sottostante e cliccate su \"Aggiungi Area\"");
        poiSearchPanel.add(poiSearchLabel1, new GridConstraints(1, 1, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        poiSearchLabel2 = new JLabel();
        poiSearchLabel2.setBackground(new Color(-1));
        poiSearchLabel2.setForeground(new Color(-1));
        poiSearchLabel2.setText("Se l'area che volete aggiungere non è presente compilate i campi sottostanti e cliccate su \"Crea e Aggiungi Area\"");
        poiSearchPanel.add(poiSearchLabel2, new GridConstraints(6, 1, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        poiSearchResultPanel = new JPanel();
        poiSearchResultPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        poiSearchResultPanel.setBackground(new Color(-9473675));
        poiSearchPanel.add(poiSearchResultPanel, new GridConstraints(3, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        poiSearchResultScroll = new JScrollPane();
        poiSearchResultPanel.add(poiSearchResultScroll, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        poiSearchResultTable = new JTable();
        poiSearchResultScroll.setViewportView(poiSearchResultTable);
        addPoiFormPanel = new JPanel();
        addPoiFormPanel.setLayout(new GridLayoutManager(2, 4, new Insets(0, 0, 0, 0), -1, -1));
        addPoiFormPanel.setBackground(new Color(-9473675));
        poiSearchPanel.add(addPoiFormPanel, new GridConstraints(8, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        nameLabel = new JLabel();
        nameLabel.setBackground(new Color(-1));
        nameLabel.setForeground(new Color(-1));
        nameLabel.setText("Nome");
        addPoiFormPanel.add(nameLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nameField = new JTextField();
        addPoiFormPanel.add(nameField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        countryLabel = new JLabel();
        countryLabel.setBackground(new Color(-1));
        countryLabel.setForeground(new Color(-1));
        countryLabel.setText("Stato");
        addPoiFormPanel.add(countryLabel, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        countryField = new JTextField();
        addPoiFormPanel.add(countryField, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        latitudeLabel = new JLabel();
        latitudeLabel.setBackground(new Color(-1));
        latitudeLabel.setForeground(new Color(-1));
        latitudeLabel.setText("Latitudine");
        addPoiFormPanel.add(latitudeLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        latitudeField = new JTextField();
        addPoiFormPanel.add(latitudeField, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        longitudeLabel = new JLabel();
        longitudeLabel.setBackground(new Color(-1));
        longitudeLabel.setForeground(new Color(-1));
        longitudeLabel.setText("Longitudine");
        addPoiFormPanel.add(longitudeLabel, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        longitudeField = new JTextField();
        addPoiFormPanel.add(longitudeField, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        backButton = new JButton();
        backButton.setBackground(new Color(-13947600));
        backButton.setForeground(new Color(-1));
        backButton.setText("Annulla");
        poiSearchPanel.add(backButton, new GridConstraints(9, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        createPoiButton = new JButton();
        createPoiButton.setBackground(new Color(-13947600));
        createPoiButton.setForeground(new Color(-1));
        createPoiButton.setText("Crea e Aggiungi Area");
        poiSearchPanel.add(createPoiButton, new GridConstraints(9, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addButton = new JButton();
        addButton.setBackground(new Color(-13947600));
        addButton.setForeground(new Color(-1));
        addButton.setText("Aggiungi Area");
        poiSearchPanel.add(addButton, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        poiSearchPanel.add(spacer1, new GridConstraints(3, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, new Dimension(10, 10), 0, false));
        final Spacer spacer2 = new Spacer();
        poiSearchPanel.add(spacer2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, new Dimension(10, 10), 0, false));
        final Spacer spacer3 = new Spacer();
        poiSearchPanel.add(spacer3, new GridConstraints(10, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, new Dimension(10, 10), 0, false));
        final Spacer spacer4 = new Spacer();
        poiSearchPanel.add(spacer4, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, new Dimension(10, 10), 0, false));
        final Spacer spacer5 = new Spacer();
        poiSearchPanel.add(spacer5, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer6 = new Spacer();
        poiSearchPanel.add(spacer6, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer7 = new Spacer();
        poiSearchPanel.add(spacer7, new GridConstraints(7, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return poiSearchPanel;
    }

}
