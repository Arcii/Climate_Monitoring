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

public class PoiSearchForRegistrationGUI extends JFrame {

    //FIELDS

    private JPanel poiSearchPanel;
    private JLabel poiSearchLabel1;
    private JLabel poiSearchLabel2;
    private JTable poiSearchResultTable;
    private JTextField nameField;
    private JTextField countryField;
    private JTextField latitudeField;
    private JTextField longitudeField;
    private JButton backButton;
    private JButton addButton;
    private JButton createPoiButton;
    private JPanel poiSearchResultPanel;
    private JScrollPane poiSearchResultScroll;
    private JPanel addPoiFormPanel;
    private JLabel nameLabel;
    private JLabel countryLabel;
    private JLabel latitudeLabel;
    private JLabel longitudeLabel;

    //CONSTRUCTOR

    public PoiSearchForRegistrationGUI(CenterRegistrationGUIController centerRegistrationGUIController, ArrayList<PointOfInterest> searchResults) {
        setTitle("Climate Monitoring");
        setContentPane(poiSearchPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);// To set fixed dimensions
        new PoiSearchForRegistrationGUIController(this, centerRegistrationGUIController, searchResults);
    }

    //GETTER AND SETTER

    public JPanel getPoiSearchPanel() {
        return poiSearchPanel;
    }

    public void setPoiSearchPanel(JPanel poiSearchPanel) {
        this.poiSearchPanel = poiSearchPanel;
    }

    public JLabel getPoiSearchLabel1() {
        return poiSearchLabel1;
    }

    public void setPoiSearchLabel1(JLabel poiSearchLabel1) {
        this.poiSearchLabel1 = poiSearchLabel1;
    }

    public JLabel getPoiSearchLabel2() {
        return poiSearchLabel2;
    }

    public void setPoiSearchLabel2(JLabel poiSearchLabel2) {
        this.poiSearchLabel2 = poiSearchLabel2;
    }

    public JTable getPoiSearchResultTable() {
        return poiSearchResultTable;
    }

    public void setPoiSearchResultTable(JTable poiSearchResultTable) {
        this.poiSearchResultTable = poiSearchResultTable;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public JTextField getCountryField() {
        return countryField;
    }

    public void setCountryField(JTextField countryField) {
        this.countryField = countryField;
    }

    public JTextField getLatitudeField() {
        return latitudeField;
    }

    public void setLatitudeField(JTextField latitudeField) {
        this.latitudeField = latitudeField;
    }

    public JTextField getLongitudeField() {
        return longitudeField;
    }

    public void setLongitudeField(JTextField longitudeField) {
        this.longitudeField = longitudeField;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public JButton getCreatePoiButton() {
        return createPoiButton;
    }

    public void setCreatePoiButton(JButton createPoiButton) {
        this.createPoiButton = createPoiButton;
    }

    public JPanel getPoiSearchResultPanel() {
        return poiSearchResultPanel;
    }

    public void setPoiSearchResultPanel(JPanel poiSearchResultPanel) {
        this.poiSearchResultPanel = poiSearchResultPanel;
    }

    public JScrollPane getPoiSearchResultScroll() {
        return poiSearchResultScroll;
    }

    public void setPoiSearchResultScroll(JScrollPane poiSearchResultScroll) {
        this.poiSearchResultScroll = poiSearchResultScroll;
    }

    public JPanel getAddPoiFormPanel() {
        return addPoiFormPanel;
    }

    public void setAddPoiFormPanel(JPanel addPoiFormPanel) {
        this.addPoiFormPanel = addPoiFormPanel;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    public JLabel getCountryLabel() {
        return countryLabel;
    }

    public void setCountryLabel(JLabel countryLabel) {
        this.countryLabel = countryLabel;
    }

    public JLabel getLatitudeLabel() {
        return latitudeLabel;
    }

    public void setLatitudeLabel(JLabel latitudeLabel) {
        this.latitudeLabel = latitudeLabel;
    }

    public JLabel getLongitudeLabel() {
        return longitudeLabel;
    }

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
