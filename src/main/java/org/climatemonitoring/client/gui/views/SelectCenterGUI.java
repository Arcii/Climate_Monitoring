package org.climatemonitoring.client.gui.views;

import org.climatemonitoring.client.gui.controllers.SelectCenterGUIController;

import javax.swing.*;

public class SelectCenterGUI extends JFrame{
    private JPanel selectionCenterPanel;
    private JLabel climateMonitoringLabel;
    private JButton selectCenterButton;
    private JButton addNewClimateCenterButton;
    private JLabel selectCenterLabel;
    private JPanel selectAndCreateCenterPanel;
    private JButton backToRegistrationButton;
    private JLabel selectionCenterLabel;

    public SelectCenterGUI(){
        setTitle("Climate Monitoring - Select Center");
        setContentPane(selectionCenterPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1024);// To set fixed dimensions
        new SelectCenterGUIController(this);
    }

    public JPanel getSelectionCenterPanel() {
        return selectionCenterPanel;
    }

    public void setSelectionCenterPanel(JPanel selectionCenterPanel) {
        this.selectionCenterPanel = selectionCenterPanel;
    }

    public JLabel getClimateMonitoringLabel() {
        return climateMonitoringLabel;
    }

    public void setClimateMonitoringLabel(JLabel climateMonitoringLabel) {
        this.climateMonitoringLabel = climateMonitoringLabel;
    }

    public JButton getSelectCenterButton() {
        return selectCenterButton;
    }

    public void setSelectCenterButton(JButton selectCenterButton) {
        this.selectCenterButton = selectCenterButton;
    }

    public JButton getAddNewClimateCenterButton() {
        return addNewClimateCenterButton;
    }

    public void setAddNewClimateCenterButton(JButton addNewClimateCenterButton) {
        this.addNewClimateCenterButton = addNewClimateCenterButton;
    }

    public JLabel getSelectCenterLabel() {
        return selectCenterLabel;
    }

    public void setSelectCenterLabel(JLabel selectCenterLabel) {
        this.selectCenterLabel = selectCenterLabel;
    }

    public JPanel getSelectAndCreateCenterPanel() {
        return selectAndCreateCenterPanel;
    }

    public void setSelectAndCreateCenterPanel(JPanel selectAndCreateCenterPanel) {
        this.selectAndCreateCenterPanel = selectAndCreateCenterPanel;
    }

    public JButton getBackToRegistrationButton() {
        return backToRegistrationButton;
    }

    public void setBackToRegistrationButton(JButton backToRegistrationButton) {
        this.backToRegistrationButton = backToRegistrationButton;
    }

    public JLabel getSelectionCenterLabel() {
        return selectionCenterLabel;
    }

    public void setSelectionCenterLabel(JLabel selectionCenterLabel) {
        this.selectionCenterLabel = selectionCenterLabel;
    }

}