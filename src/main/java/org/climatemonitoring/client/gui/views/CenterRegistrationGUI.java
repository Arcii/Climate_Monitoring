package org.climatemonitoring.client.gui.views;

import org.climatemonitoring.client.gui.controllers.CenterRegistrationGUIController;
import org.climatemonitoring.shared.models.MonitoringCenter;
import org.climatemonitoring.shared.models.User;

import javax.swing.*;
import java.util.ArrayList;

public class CenterRegistrationGUI extends JFrame{
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

    public CenterRegistrationGUI(User user, ArrayList<MonitoringCenter> centersList){
        setTitle("Climate Monitoring");
        setContentPane(centerRegistrationPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1024);// To set fixed dimensions
        new CenterRegistrationGUIController(this, user, centersList);
    }

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

}
