package org.climatemonitoring.client.gui.views;

import org.climatemonitoring.client.gui.controllers.CenterRegistrationGUIController;
import org.climatemonitoring.client.gui.controllers.PoiSearchForRegistrationGUIController;
import org.climatemonitoring.shared.models.PointOfInterest;

import javax.swing.*;
import java.util.ArrayList;

public class PoiSearchForRegistrationGUI extends JFrame{
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

    public PoiSearchForRegistrationGUI(CenterRegistrationGUIController centerRegistrationGUIController, ArrayList<PointOfInterest> searchResults){
        setTitle("Climate Monitoring");
        setContentPane(poiSearchPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);// To set fixed dimensions
        new PoiSearchForRegistrationGUIController(this, centerRegistrationGUIController, searchResults);
    }

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

}
