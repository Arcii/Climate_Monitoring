package org.climatemonitoring.client.gui.views;

import org.climatemonitoring.client.gui.controllers.OperatorRegistrationGUIController;

import javax.swing.*;

public class OperatorRegistrationGUI extends JFrame{
    private JPanel operatorRegistrationPanel;
    private JLabel climatemonitoringLabel;
    private JLabel registrationFormInfoLabel;
    private JPanel registrationFormPanel;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField fiscalCodeField;
    private JTextField emailField;
    private JTextField userIdField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel fiscalCodeLabel;
    private JLabel emailLabel;
    private JLabel userIdLabel;
    private JLabel passwordLabel;
    private JLabel confirmPasswordLabel;
    private JButton continueRegistrationButton;
    private JButton backButton;

    public OperatorRegistrationGUI(){
        setTitle("Climate Monitoring");
        setContentPane(operatorRegistrationPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1024);// To set fixed dimensions
        new OperatorRegistrationGUIController(this);
    }

    public JPanel getOperatorRegistrationPanel() {
        return operatorRegistrationPanel;
    }

    public void setOperatorRegistrationPanel(JPanel operatorRegistrationPanel) {
        this.operatorRegistrationPanel = operatorRegistrationPanel;
    }

    public JLabel getClimatemonitoringLabel() {
        return climatemonitoringLabel;
    }

    public void setClimatemonitoringLabel(JLabel climatemonitoringLabel) {
        this.climatemonitoringLabel = climatemonitoringLabel;
    }

    public JLabel getRegistrationFormInfoLabel() {
        return registrationFormInfoLabel;
    }

    public void setRegistrationFormInfoLabel(JLabel registrationFormInfoLabel) {
        this.registrationFormInfoLabel = registrationFormInfoLabel;
    }

    public JPanel getRegistrationFormPanel() {
        return registrationFormPanel;
    }

    public void setRegistrationFormPanel(JPanel registrationFormPanel) {
        this.registrationFormPanel = registrationFormPanel;
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

    public JTextField getFiscalCodeField() {
        return fiscalCodeField;
    }

    public void setFiscalCodeField(JTextField fiscalCodeField) {
        this.fiscalCodeField = fiscalCodeField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public void setEmailField(JTextField emailField) {
        this.emailField = emailField;
    }

    public JTextField getUserIdField() {
        return userIdField;
    }

    public void setUserIdField(JTextField userIdField) {
        this.userIdField = userIdField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public JPasswordField getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public void setConfirmPasswordField(JPasswordField confirmPasswordField) {
        this.confirmPasswordField = confirmPasswordField;
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

    public JLabel getFiscalCodeLabel() {
        return fiscalCodeLabel;
    }

    public void setFiscalCodeLabel(JLabel fiscalCodeLabel) {
        this.fiscalCodeLabel = fiscalCodeLabel;
    }

    public JLabel getEmailLabel() {
        return emailLabel;
    }

    public void setEmailLabel(JLabel emailLabel) {
        this.emailLabel = emailLabel;
    }

    public JLabel getUserIdLabel() {
        return userIdLabel;
    }

    public void setUserIdLabel(JLabel userIdLabel) {
        this.userIdLabel = userIdLabel;
    }

    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    public void setPasswordLabel(JLabel passwordLabel) {
        this.passwordLabel = passwordLabel;
    }

    public JLabel getConfirmPasswordLabel() {
        return confirmPasswordLabel;
    }

    public void setConfirmPasswordLabel(JLabel confirmPasswordLabel) {
        this.confirmPasswordLabel = confirmPasswordLabel;
    }

    public JButton getContinueRegistrationButton() {
        return continueRegistrationButton;
    }

    public void setContinueRegistrationButton(JButton continueRegistrationButton) {
        this.continueRegistrationButton = continueRegistrationButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

}
