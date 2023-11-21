package org.climatemonitoring.client.gui.views;

import org.climatemonitoring.client.gui.controllers.RegistrationGUIController;

import javax.swing.*;

public class RegistrationGUI extends JFrame{
    private JLabel climateMonitoringLabel;
    private JPanel registrationPanel;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField emailField;
    private JTextField userIDField;
    private JPasswordField registrationPasswordField;
    private JPasswordField confirmationPasswordField;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel emailLabel;
    private JLabel userIDLabel;
    private JLabel registrationPasswordLabel;
    private JLabel confirmationPasswordLabel;
    private JButton gotoCenterSelectionButton;
    private JButton backHomeButton;

    public RegistrationGUI(){
        setTitle("Climate Monitoring - Registration");
        setContentPane(registrationPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1024);// To set fixed dimensions
        new RegistrationGUIController(this);
    }

    public JLabel getClimateMonitoringLabel() {
        return climateMonitoringLabel;
    }

    public void setClimateMonitoringLabel(JLabel climateMonitoringLabel) {
        this.climateMonitoringLabel = climateMonitoringLabel;
    }

    public JPanel getRegistrationPanel() {
        return registrationPanel;
    }

    public void setRegistrationPanel(JPanel registrationPanel) {
        this.registrationPanel = registrationPanel;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public JTextField getSurnameField() {
        return surnameField;
    }

    public void setSurnameField(JTextField surnameField) {
        this.surnameField = surnameField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public void setEmailField(JTextField emailField) {
        this.emailField = emailField;
    }

    public JTextField getUserIDField() {
        return userIDField;
    }

    public void setUserIDField(JTextField userIDField) {
        this.userIDField = userIDField;
    }

    public JPasswordField getRegistrationPasswordField() {
        return registrationPasswordField;
    }

    public void setRegistrationPasswordField(JPasswordField registrationPasswordField) {
        this.registrationPasswordField = registrationPasswordField;
    }

    public JPasswordField getConfirmationPasswordField() {
        return confirmationPasswordField;
    }

    public void setConfirmationPasswordField(JPasswordField confirmationPasswordField) {
        this.confirmationPasswordField = confirmationPasswordField;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    public JLabel getSurnameLabel() {
        return surnameLabel;
    }

    public void setSurnameLabel(JLabel surnameLabel) {
        this.surnameLabel = surnameLabel;
    }

    public JLabel getEmailLabel() {
        return emailLabel;
    }

    public void setEmailLabel(JLabel emailLabel) {
        this.emailLabel = emailLabel;
    }

    public JLabel getUserIDLabel() {
        return userIDLabel;
    }

    public void setUserIDLabel(JLabel userIDLabel) {
        this.userIDLabel = userIDLabel;
    }

    public JLabel getRegistrationPasswordLabel() {
        return registrationPasswordLabel;
    }

    public void setRegistrationPasswordLabel(JLabel registrationPasswordLabel) {
        this.registrationPasswordLabel = registrationPasswordLabel;
    }

    public JLabel getConfirmationPasswordLabel() {
        return confirmationPasswordLabel;
    }

    public void setConfirmationPasswordLabel(JLabel confirmationPasswordLabel) {
        this.confirmationPasswordLabel = confirmationPasswordLabel;
    }

    public JButton getGotoCenterSelectionButton() {
        return gotoCenterSelectionButton;
    }

    public void setGotoCenterSelectionButton(JButton gotoCenterSelectionButton) {
        this.gotoCenterSelectionButton = gotoCenterSelectionButton;
    }

    public JButton getBackHomeButton() {
        return backHomeButton;
    }

    public void setBackHomeButton(JButton backHomeButton) {
        this.backHomeButton = backHomeButton;
    }

}
