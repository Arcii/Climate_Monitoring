package org.climatemonitoring.client.gui.views;

import org.climatemonitoring.client.gui.controllers.ClientHomeGUIController;

import javax.swing.*;

public class ClientHomeGUI extends JFrame {
    private JPanel guestUserPanel;
    private JLabel climatemonitoringLabel;
    private JPanel coordinatesSearchPanel;
    private JLabel coordinatesSearchLabel;
    private JPanel nameSearchPanel;
    private JLabel nameSearchLabel;
    private JTextField latitudeField;
    private JTextField longitudeField;
    private JButton coordinatesSearchButton;
    private JTextField nameField;
    private JTextField stateField;
    private JButton cercaPerDenominazioneButton;
    private JButton loginOperatorButton;
    private JLabel latitudeLabel;
    private JLabel longitudeLabel;
    private JLabel nameLabel;
    private JLabel stateLabel;
    private JLabel greetingLabel;

   public ClientHomeGUI(){
       setTitle("Climate Monitoring");
       setContentPane(guestUserPanel);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(1920, 1024);// To set fixed dimensions
       coordinatesSearchPanel.setSize(400,400);
       nameSearchPanel.setSize(400,400);
       new ClientHomeGUIController(this);
   }

    public JPanel getGuestUserPanel() {
        return guestUserPanel;
    }

    public void setGuestUserPanel(JPanel guestUserPanel) {
        this.guestUserPanel = guestUserPanel;
    }

    public JLabel getClimatemonitoringLabel() {
        return climatemonitoringLabel;
    }

    public void setClimatemonitoringLabel(JLabel climatemonitoringLabel) {
        this.climatemonitoringLabel = climatemonitoringLabel;
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

    public JButton getCoordinatesSearchButton() {
        return coordinatesSearchButton;
    }

    public void setCoordinatesSearchButton(JButton coordinatesSearchButton) {
        this.coordinatesSearchButton = coordinatesSearchButton;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
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

    public JButton getLoginOperatorButton() {
        return loginOperatorButton;
    }

    public void setLoginOperatorButton(JButton loginOperatorButton) {
        this.loginOperatorButton = loginOperatorButton;
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

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    public JLabel getStateLabel() {
        return stateLabel;
    }

    public void setStateLabel(JLabel stateLabel) {
        this.stateLabel = stateLabel;
    }

    public JLabel getGreetingLabel() {
        return greetingLabel;
    }

    public void setGreetingLabel(JLabel greetingLabel) {
        this.greetingLabel = greetingLabel;
    }

}
