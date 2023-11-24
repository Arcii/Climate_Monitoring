package org.climatemonitoring.client.gui.views;

import org.climatemonitoring.client.gui.controllers.OperatorHomeGUIController;

import javax.swing.*;

public class OperatorHomeGUI extends JFrame{
    private JPanel operatorHomePanel;
    private JLabel climatemonitoringLabel;
    private JLabel greetingLabel;
    private JPanel coordinatesSearchPanel;
    private JLabel coordinatesSearchLabel;
    private JLabel latitudeLabel;
    private JTextField latitudeField;
    private JLabel longitudeLabel;
    private JTextField longitudeField;
    private JButton coordinatesSearchButton;
    private JPanel nameSearchPanel;
    private JLabel nameSearchLabel;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel stateLabel;
    private JTextField stateField;
    private JButton cercaPerDenominazioneButton;

    public OperatorHomeGUI(){
        setTitle("Climate Monitoring");
        setContentPane(operatorHomePanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1024);// To set fixed dimensions
        coordinatesSearchPanel.setSize(400,400);
        nameSearchPanel.setSize(400,400);
        new OperatorHomeGUIController(this);
    }

    public JPanel getOperatorHomePanel() {
        return operatorHomePanel;
    }

    public void setOperatorHomePanel(JPanel operatorHomePanel) {
        this.operatorHomePanel = operatorHomePanel;
    }

    public JLabel getClimatemonitoringLabel() {
        return climatemonitoringLabel;
    }

    public void setClimatemonitoringLabel(JLabel climatemonitoringLabel) {
        this.climatemonitoringLabel = climatemonitoringLabel;
    }

    public JLabel getGreetingLabel() {
        return greetingLabel;
    }

    public void setGreetingLabel(JLabel greetingLabel) {
        this.greetingLabel = greetingLabel;
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

    public JPanel getNameSearchPanel() {
        return nameSearchPanel;
    }

    public void setNameSearchPanel(JPanel nameSearchPanel) {
        this.nameSearchPanel = nameSearchPanel;
    }

    public JLabel getNameSearchLabel() {
        return nameSearchLabel;
    }

    public void setNameSearchLabel(JLabel nameSearchLabel) {
        this.nameSearchLabel = nameSearchLabel;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public JLabel getStateLabel() {
        return stateLabel;
    }

    public void setStateLabel(JLabel stateLabel) {
        this.stateLabel = stateLabel;
    }

    public JTextField getStateField() {
        return stateField;
    }

    public void setStateField(JTextField stateField) {
        this.stateField = stateField;
    }

    public JButton getCercaPerDenominazioneButton() {
        return cercaPerDenominazioneButton;
    }

    public void setCercaPerDenominazioneButton(JButton cercaPerDenominazioneButton) {
        this.cercaPerDenominazioneButton = cercaPerDenominazioneButton;
    }

}
