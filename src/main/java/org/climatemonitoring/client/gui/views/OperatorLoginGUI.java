package org.climatemonitoring.client.gui.views;

import org.climatemonitoring.client.gui.controllers.OperatorLoginGUIController;

import javax.swing.*;

public class OperatorLoginGUI extends JFrame{
    private JPanel operatorLoginPanel;
    private JLabel climatemonitoringLabel;
    private JLabel loginInfoLabel;
    private JPanel loginFormPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel registrationFormInfoLabel;
    private JButton loginButton;
    private JPanel registrationFormPanel;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField fiscalCodeField;
    private JTextField emailField;
    private JTextField userIdField;
    private JPasswordField registrationPasswordField;
    private JPasswordField confirmRegistrationPasswordField;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel fiscalCodeLabel;
    private JLabel emailLabel;
    private JLabel userIdLabel;
    private JLabel registrationPasswordLabel;
    private JLabel confirmRegistrationPasswordLabel;
    private JButton signUpButton;

    public OperatorLoginGUI(){
        setTitle("Climate Monitoring");
        setContentPane(operatorLoginPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1024);// To set fixed dimensions
        new OperatorLoginGUIController(this);
    }

    public JPanel getOperatorLoginPanel() {
        return operatorLoginPanel;
    }

    public void setOperatorLoginPanel(JPanel operatorLoginPanel) {
        this.operatorLoginPanel = operatorLoginPanel;
    }

    public JLabel getClimatemonitoringLabel() {
        return climatemonitoringLabel;
    }

    public void setClimatemonitoringLabel(JLabel climatemonitoringLabel) {
        this.climatemonitoringLabel = climatemonitoringLabel;
    }

    public JLabel getLoginInfoLabel() {
        return loginInfoLabel;
    }

    public void setLoginInfoLabel(JLabel loginInfoLabel) {
        this.loginInfoLabel = loginInfoLabel;
    }

    public JPanel getLoginFormPanel() {
        return loginFormPanel;
    }

    public void setLoginFormPanel(JPanel loginFormPanel) {
        this.loginFormPanel = loginFormPanel;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public void setUsernameField(JTextField usernameField) {
        this.usernameField = usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public JLabel getUsernameLabel() {
        return usernameLabel;
    }

    public void setUsernameLabel(JLabel usernameLabel) {
        this.usernameLabel = usernameLabel;
    }

    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    public void setPasswordLabel(JLabel passwordLabel) {
        this.passwordLabel = passwordLabel;
    }

    public JLabel getRegistrationFormInfoLabel() {
        return registrationFormInfoLabel;
    }

    public void setRegistrationFormInfoLabel(JLabel registrationFormInfoLabel) {
        this.registrationFormInfoLabel = registrationFormInfoLabel;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
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

    public JPasswordField getRegistrationPasswordField() {
        return registrationPasswordField;
    }

    public void setRegistrationPasswordField(JPasswordField registrationPasswordField) {
        this.registrationPasswordField = registrationPasswordField;
    }

    public JPasswordField getConfirmRegistrationPasswordField() {
        return confirmRegistrationPasswordField;
    }

    public void setConfirmRegistrationPasswordField(JPasswordField confirmRegistrationPasswordField) {
        this.confirmRegistrationPasswordField = confirmRegistrationPasswordField;
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

    public JLabel getRegistrationPasswordLabel() {
        return registrationPasswordLabel;
    }

    public void setRegistrationPasswordLabel(JLabel registrationPasswordLabel) {
        this.registrationPasswordLabel = registrationPasswordLabel;
    }

    public JLabel getConfirmRegistrationPasswordLabel() {
        return confirmRegistrationPasswordLabel;
    }

    public void setConfirmRegistrationPasswordLabel(JLabel confirmRegistrationPasswordLabel) {
        this.confirmRegistrationPasswordLabel = confirmRegistrationPasswordLabel;
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }

    public void setSignUpButton(JButton signUpButton) {
        this.signUpButton = signUpButton;
    }

}
