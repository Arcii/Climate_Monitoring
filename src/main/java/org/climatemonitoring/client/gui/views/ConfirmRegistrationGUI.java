package org.climatemonitoring.client.gui.views;

import org.climatemonitoring.client.gui.controllers.ConfirmRegistrationGUIController;

import javax.swing.*;

public class ConfirmRegistrationGUI extends JFrame{
    private JPanel signupConfirmationPanel;
    private JLabel climateMonitoringLabel;
    private JLabel signupConfirmationLabel1;
    private JLabel sugnupConfirmationLabel2;
    private JButton backToSelectCenterButton;
    private JButton confirmRegistrationButton;
    private JPanel confirmationButtonsPanel;
    private JPanel userDataPanel;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel emailLabel;
    private JLabel userIDLabel;
    private JLabel climateCenterLabel;

    public ConfirmRegistrationGUI(){
        setTitle("Climate Monitoring - Confirm Registration");
        setContentPane(signupConfirmationPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1024);// To set fixed dimensions
        new ConfirmRegistrationGUIController(this);
    }

    public JPanel getSignupConfirmationPanel() {
        return signupConfirmationPanel;
    }

    public void setSignupConfirmationPanel(JPanel signupConfirmationPanel) {
        this.signupConfirmationPanel = signupConfirmationPanel;
    }

    public JLabel getClimateMonitoringLabel() {
        return climateMonitoringLabel;
    }

    public void setClimateMonitoringLabel(JLabel climateMonitoringLabel) {
        this.climateMonitoringLabel = climateMonitoringLabel;
    }

    public JLabel getSignupConfirmationLabel1() {
        return signupConfirmationLabel1;
    }

    public void setSignupConfirmationLabel1(JLabel signupConfirmationLabel1) {
        this.signupConfirmationLabel1 = signupConfirmationLabel1;
    }

    public JLabel getSugnupConfirmationLabel2() {
        return sugnupConfirmationLabel2;
    }

    public void setSugnupConfirmationLabel2(JLabel sugnupConfirmationLabel2) {
        this.sugnupConfirmationLabel2 = sugnupConfirmationLabel2;
    }

    public JButton getBackToSelectCenterButton() {
        return backToSelectCenterButton;
    }

    public void setBackToSelectCenterButton(JButton backToSelectCenterButton) {
        this.backToSelectCenterButton = backToSelectCenterButton;
    }

    public JButton getConfirmRegistrationButton() {
        return confirmRegistrationButton;
    }

    public void setConfirmRegistrationButton(JButton confirmRegistrationButton) {
        this.confirmRegistrationButton = confirmRegistrationButton;
    }

    public JPanel getConfirmationButtonsPanel() {
        return confirmationButtonsPanel;
    }

    public void setConfirmationButtonsPanel(JPanel confirmationButtonsPanel) {
        this.confirmationButtonsPanel = confirmationButtonsPanel;
    }

    public JPanel getUserDataPanel() {
        return userDataPanel;
    }

    public void setUserDataPanel(JPanel userDataPanel) {
        this.userDataPanel = userDataPanel;
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

    public JLabel getClimateCenterLabel() {
        return climateCenterLabel;
    }

    public void setClimateCenterLabel(JLabel climateCenterLabel) {
        this.climateCenterLabel = climateCenterLabel;
    }

}
