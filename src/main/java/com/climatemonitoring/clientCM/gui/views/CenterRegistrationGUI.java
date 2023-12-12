package com.climatemonitoring.clientCM.gui.views;

import com.climatemonitoring.clientCM.gui.controllers.CenterRegistrationGUIController;
import com.climatemonitoring.shared.models.MonitoringCenter;
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

public class CenterRegistrationGUI extends JFrame {

    //FIELDS

    private JLabel climatemonitoringLabel;
    private JLabel centerRegistrationLabel;
    private JTextField nameField;
    private JTextField addressField;
    private JTextField addressNumberFIeld;
    private JTextField capField;
    private JTextField provinceField;
    private JTextField cityField;
    private JLabel poiSelectionLabel;
    private JPanel coordinatesSearchPanel;
    private JLabel coordinatesSearchLabel;
    private JLabel latitudeLabel;
    private JTextField latitudeField;
    private JLabel longitudeLabel;
    private JTextField longitudeField;
    private JButton coordinatesSearchButton;
    private JTable addedPoiTable;
    private JLabel addedPoiLabel;
    private JPanel poiSelectionPanel;
    private JPanel addedPoiPanel;
    private JScrollPane addedPoiScroll;
    private JLabel nameLabel;
    private JLabel addressLabel;
    private JLabel addressNumberLabel;
    private JLabel capLabel;
    private JLabel cityLabel;
    private JLabel provinceLabel;
    private JPanel centerFormPanel;
    private JLabel completeCenterRegistrationLabel;
    private JButton backButton;
    private JButton completeCenterRegistrationButton;
    private JPanel centerRegistrationPanel;

    //CONSTRUCTOR

    public CenterRegistrationGUI(User user, ArrayList<MonitoringCenter> centersList) {
        setTitle("Climate Monitoring");
        setContentPane(centerRegistrationPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setMinimumSize(new Dimension(1000, 650));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        new CenterRegistrationGUIController(this, user, centersList);
    }

    //GETTER AND SETTER

    public JLabel getClimatemonitoringLabel() {
        return climatemonitoringLabel;
    }

    public void setClimatemonitoringLabel(JLabel climatemonitoringLabel) {
        this.climatemonitoringLabel = climatemonitoringLabel;
    }

    public JLabel getCenterRegistrationLabel() {
        return centerRegistrationLabel;
    }

    public void setCenterRegistrationLabel(JLabel centerRegistrationLabel) {
        this.centerRegistrationLabel = centerRegistrationLabel;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public JTextField getAddressField() {
        return addressField;
    }

    public void setAddressField(JTextField addressField) {
        this.addressField = addressField;
    }

    public JTextField getAddressNumberFIeld() {
        return addressNumberFIeld;
    }

    public void setAddressNumberFIeld(JTextField addressNumberFIeld) {
        this.addressNumberFIeld = addressNumberFIeld;
    }

    public JTextField getCapField() {
        return capField;
    }

    public void setCapField(JTextField capField) {
        this.capField = capField;
    }

    public JTextField getProvinceField() {
        return provinceField;
    }

    public void setProvinceField(JTextField provinceField) {
        this.provinceField = provinceField;
    }

    public JTextField getCityField() {
        return cityField;
    }

    public void setCityField(JTextField cityField) {
        this.cityField = cityField;
    }

    public JLabel getPoiSelectionLabel() {
        return poiSelectionLabel;
    }

    public void setPoiSelectionLabel(JLabel poiSelectionLabel) {
        this.poiSelectionLabel = poiSelectionLabel;
    }

    public JPanel getCoordinatesSearchPanel() {
        return coordinatesSearchPanel;
    }

    public void setCoordinatesSearchPanel(JPanel coordinatesSearchPanel) {
        this.coordinatesSearchPanel = coordinatesSearchPanel;
    }

    public JLabel getCoordinatesSearchLabel() {
        return coordinatesSearchLabel;
    }

    public void setCoordinatesSearchLabel(JLabel coordinatesSearchLabel) {
        this.coordinatesSearchLabel = coordinatesSearchLabel;
    }

    public JLabel getLatitudeLabel() {
        return latitudeLabel;
    }

    public void setLatitudeLabel(JLabel latitudeLabel) {
        this.latitudeLabel = latitudeLabel;
    }

    public JTextField getLatitudeField() {
        return latitudeField;
    }

    public void setLatitudeField(JTextField latitudeField) {
        this.latitudeField = latitudeField;
    }

    public JLabel getLongitudeLabel() {
        return longitudeLabel;
    }

    public void setLongitudeLabel(JLabel longitudeLabel) {
        this.longitudeLabel = longitudeLabel;
    }

    public JTextField getLongitudeField() {
        return longitudeField;
    }

    public void setLongitudeField(JTextField longitudeField) {
        this.longitudeField = longitudeField;
    }

    public JButton getCoordinatesSearchButton() {
        return coordinatesSearchButton;
    }

    public void setCoordinatesSearchButton(JButton coordinatesSearchButton) {
        this.coordinatesSearchButton = coordinatesSearchButton;
    }

    public JTable getAddedPoiTable() {
        return addedPoiTable;
    }

    public void setAddedPoiTable(JTable addedPoiTable) {
        this.addedPoiTable = addedPoiTable;
    }

    public JLabel getAddedPoiLabel() {
        return addedPoiLabel;
    }

    public void setAddedPoiLabel(JLabel addedPoiLabel) {
        this.addedPoiLabel = addedPoiLabel;
    }

    public JPanel getPoiSelectionPanel() {
        return poiSelectionPanel;
    }

    public void setPoiSelectionPanel(JPanel poiSelectionPanel) {
        this.poiSelectionPanel = poiSelectionPanel;
    }

    public JPanel getAddedPoiPanel() {
        return addedPoiPanel;
    }

    public void setAddedPoiPanel(JPanel addedPoiPanel) {
        this.addedPoiPanel = addedPoiPanel;
    }

    public JScrollPane getAddedPoiScroll() {
        return addedPoiScroll;
    }

    public void setAddedPoiScroll(JScrollPane addedPoiScroll) {
        this.addedPoiScroll = addedPoiScroll;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    public JLabel getAddressLabel() {
        return addressLabel;
    }

    public void setAddressLabel(JLabel addressLabel) {
        this.addressLabel = addressLabel;
    }

    public JLabel getAddressNumberLabel() {
        return addressNumberLabel;
    }

    public void setAddressNumberLabel(JLabel addressNumberLabel) {
        this.addressNumberLabel = addressNumberLabel;
    }

    public JLabel getCapLabel() {
        return capLabel;
    }

    public void setCapLabel(JLabel capLabel) {
        this.capLabel = capLabel;
    }

    public JLabel getCityLabel() {
        return cityLabel;
    }

    public void setCityLabel(JLabel cityLabel) {
        this.cityLabel = cityLabel;
    }

    public JLabel getProvinceLabel() {
        return provinceLabel;
    }

    public void setProvinceLabel(JLabel provinceLabel) {
        this.provinceLabel = provinceLabel;
    }

    public JPanel getCenterFormPanel() {
        return centerFormPanel;
    }

    public void setCenterFormPanel(JPanel centerFormPanel) {
        this.centerFormPanel = centerFormPanel;
    }

    public JLabel getCompleteCenterRegistrationLabel() {
        return completeCenterRegistrationLabel;
    }

    public void setCompleteCenterRegistrationLabel(JLabel completeCenterRegistrationLabel) {
        this.completeCenterRegistrationLabel = completeCenterRegistrationLabel;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public JButton getCompleteCenterRegistrationButton() {
        return completeCenterRegistrationButton;
    }

    public void setCompleteCenterRegistrationButton(JButton completeCenterRegistrationButton) {
        this.completeCenterRegistrationButton = completeCenterRegistrationButton;
    }

    public JPanel getCenterRegistrationPanel() {
        return centerRegistrationPanel;
    }

    public void setCenterRegistrationPanel(JPanel centerRegistrationPanel) {
        this.centerRegistrationPanel = centerRegistrationPanel;
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
        centerRegistrationPanel = new JPanel();
        centerRegistrationPanel.setLayout(new GridLayoutManager(13, 4, new Insets(0, 0, 0, 0), -1, -1));
        centerRegistrationPanel.setBackground(new Color(-9473675));
        centerRegistrationPanel.setForeground(new Color(-9473675));
        climatemonitoringLabel = new JLabel();
        climatemonitoringLabel.setBackground(new Color(-1));
        Font climatemonitoringLabelFont = this.$$$getFont$$$("JetBrains Mono ExtraBold", Font.BOLD, 72, climatemonitoringLabel.getFont());
        if (climatemonitoringLabelFont != null) climatemonitoringLabel.setFont(climatemonitoringLabelFont);
        climatemonitoringLabel.setForeground(new Color(-1));
        climatemonitoringLabel.setText("Climate Monitoring");
        centerRegistrationPanel.add(climatemonitoringLabel, new GridConstraints(0, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        centerRegistrationPanel.add(spacer1, new GridConstraints(1, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        centerRegistrationLabel = new JLabel();
        centerRegistrationLabel.setBackground(new Color(-1));
        Font centerRegistrationLabelFont = this.$$$getFont$$$(null, -1, 16, centerRegistrationLabel.getFont());
        if (centerRegistrationLabelFont != null) centerRegistrationLabel.setFont(centerRegistrationLabelFont);
        centerRegistrationLabel.setForeground(new Color(-1));
        centerRegistrationLabel.setText("Inserisci qui sotto i dati necessari per la registrazione del centro di monitoraggio");
        centerRegistrationPanel.add(centerRegistrationLabel, new GridConstraints(2, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        centerFormPanel = new JPanel();
        centerFormPanel.setLayout(new GridLayoutManager(3, 4, new Insets(0, 0, 0, 0), -1, -1));
        centerFormPanel.setBackground(new Color(-9473675));
        centerFormPanel.setForeground(new Color(-9473675));
        centerRegistrationPanel.add(centerFormPanel, new GridConstraints(3, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        nameLabel = new JLabel();
        nameLabel.setBackground(new Color(-1));
        nameLabel.setForeground(new Color(-1));
        nameLabel.setText("Nome Centro : ");
        centerFormPanel.add(nameLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nameField = new JTextField();
        centerFormPanel.add(nameField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        addressLabel = new JLabel();
        addressLabel.setBackground(new Color(-1));
        addressLabel.setForeground(new Color(-1));
        addressLabel.setText("Indirizzo : ");
        centerFormPanel.add(addressLabel, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addressField = new JTextField();
        centerFormPanel.add(addressField, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        addressNumberLabel = new JLabel();
        addressNumberLabel.setBackground(new Color(-1));
        addressNumberLabel.setForeground(new Color(-1));
        addressNumberLabel.setText("Numero Civico : ");
        centerFormPanel.add(addressNumberLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        capLabel = new JLabel();
        capLabel.setBackground(new Color(-1));
        capLabel.setForeground(new Color(-1));
        capLabel.setText("CAP : ");
        centerFormPanel.add(capLabel, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addressNumberFIeld = new JTextField();
        centerFormPanel.add(addressNumberFIeld, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        capField = new JTextField();
        centerFormPanel.add(capField, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        cityLabel = new JLabel();
        cityLabel.setBackground(new Color(-1));
        cityLabel.setForeground(new Color(-1));
        cityLabel.setText("Città : ");
        centerFormPanel.add(cityLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        provinceLabel = new JLabel();
        provinceLabel.setBackground(new Color(-1));
        provinceLabel.setForeground(new Color(-1));
        provinceLabel.setText("Provincia : ");
        centerFormPanel.add(provinceLabel, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        provinceField = new JTextField();
        centerFormPanel.add(provinceField, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        cityField = new JTextField();
        centerFormPanel.add(cityField, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        poiSelectionLabel = new JLabel();
        poiSelectionLabel.setBackground(new Color(-1));
        Font poiSelectionLabelFont = this.$$$getFont$$$(null, -1, 16, poiSelectionLabel.getFont());
        if (poiSelectionLabelFont != null) poiSelectionLabel.setFont(poiSelectionLabelFont);
        poiSelectionLabel.setForeground(new Color(-1));
        poiSelectionLabel.setText("Cerca le aree di interesse che il tuo Centro di Monitoraggio monitora, se non presenti sarà possibile crearle");
        centerRegistrationPanel.add(poiSelectionLabel, new GridConstraints(5, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        poiSelectionPanel = new JPanel();
        poiSelectionPanel.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        poiSelectionPanel.setBackground(new Color(-9473675));
        poiSelectionPanel.setForeground(new Color(-9473675));
        centerRegistrationPanel.add(poiSelectionPanel, new GridConstraints(7, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        coordinatesSearchPanel = new JPanel();
        coordinatesSearchPanel.setLayout(new GridLayoutManager(9, 1, new Insets(0, 0, 0, 0), -1, -1));
        coordinatesSearchPanel.setBackground(new Color(-9473675));
        coordinatesSearchPanel.setForeground(new Color(-9473675));
        poiSelectionPanel.add(coordinatesSearchPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        coordinatesSearchLabel = new JLabel();
        coordinatesSearchLabel.setBackground(new Color(-1));
        coordinatesSearchLabel.setForeground(new Color(-1));
        coordinatesSearchLabel.setText("Ricerca area per coordinate");
        coordinatesSearchPanel.add(coordinatesSearchLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        latitudeLabel = new JLabel();
        latitudeLabel.setBackground(new Color(-1));
        latitudeLabel.setForeground(new Color(-1));
        latitudeLabel.setText("Latitudine");
        coordinatesSearchPanel.add(latitudeLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        coordinatesSearchPanel.add(spacer2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(-1, 20), null, null, 0, false));
        latitudeField = new JTextField();
        coordinatesSearchPanel.add(latitudeField, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        longitudeLabel = new JLabel();
        longitudeLabel.setBackground(new Color(-1));
        longitudeLabel.setForeground(new Color(-1));
        longitudeLabel.setText("Longitudine");
        coordinatesSearchPanel.add(longitudeLabel, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        coordinatesSearchPanel.add(spacer3, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(-1, 20), null, null, 0, false));
        longitudeField = new JTextField();
        coordinatesSearchPanel.add(longitudeField, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        coordinatesSearchButton = new JButton();
        coordinatesSearchButton.setBackground(new Color(-13947600));
        coordinatesSearchButton.setForeground(new Color(-1));
        coordinatesSearchButton.setText("Cerca per coordinate");
        coordinatesSearchPanel.add(coordinatesSearchButton, new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        coordinatesSearchPanel.add(spacer4, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(-1, 20), null, null, 0, false));
        addedPoiPanel = new JPanel();
        addedPoiPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        addedPoiPanel.setBackground(new Color(-9473675));
        addedPoiPanel.setForeground(new Color(-9473675));
        poiSelectionPanel.add(addedPoiPanel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        addedPoiLabel = new JLabel();
        addedPoiLabel.setBackground(new Color(-1));
        addedPoiLabel.setForeground(new Color(-1));
        addedPoiLabel.setText("Aree aggiunte al Centro di Monitoraggio");
        addedPoiPanel.add(addedPoiLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addedPoiScroll = new JScrollPane();
        addedPoiPanel.add(addedPoiScroll, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        addedPoiTable = new JTable();
        addedPoiScroll.setViewportView(addedPoiTable);
        completeCenterRegistrationLabel = new JLabel();
        completeCenterRegistrationLabel.setBackground(new Color(-1));
        Font completeCenterRegistrationLabelFont = this.$$$getFont$$$(null, -1, 16, completeCenterRegistrationLabel.getFont());
        if (completeCenterRegistrationLabelFont != null)
            completeCenterRegistrationLabel.setFont(completeCenterRegistrationLabelFont);
        completeCenterRegistrationLabel.setForeground(new Color(-1));
        completeCenterRegistrationLabel.setText("Quando la lista visualizzata comprende tutte le aree necessarie clicca su \"Completa Registrazione\"");
        centerRegistrationPanel.add(completeCenterRegistrationLabel, new GridConstraints(9, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        backButton = new JButton();
        backButton.setBackground(new Color(-13947600));
        backButton.setForeground(new Color(-1));
        backButton.setText("Indietro");
        centerRegistrationPanel.add(backButton, new GridConstraints(11, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        completeCenterRegistrationButton = new JButton();
        completeCenterRegistrationButton.setBackground(new Color(-13947600));
        completeCenterRegistrationButton.setForeground(new Color(-1));
        completeCenterRegistrationButton.setText("Completa Registrazione");
        centerRegistrationPanel.add(completeCenterRegistrationButton, new GridConstraints(11, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer5 = new Spacer();
        centerRegistrationPanel.add(spacer5, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer6 = new Spacer();
        centerRegistrationPanel.add(spacer6, new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer7 = new Spacer();
        centerRegistrationPanel.add(spacer7, new GridConstraints(10, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer8 = new Spacer();
        centerRegistrationPanel.add(spacer8, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer9 = new Spacer();
        centerRegistrationPanel.add(spacer9, new GridConstraints(12, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer10 = new Spacer();
        centerRegistrationPanel.add(spacer10, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer11 = new Spacer();
        centerRegistrationPanel.add(spacer11, new GridConstraints(3, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
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
        return centerRegistrationPanel;
    }

}
