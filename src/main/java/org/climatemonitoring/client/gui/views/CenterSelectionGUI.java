package org.climatemonitoring.client.gui.views;

import org.climatemonitoring.shared.models.MonitoringCenter;
import org.climatemonitoring.shared.models.User;
import org.climatemonitoring.client.gui.controllers.CenterSelectionGUIController;

import javax.swing.*;
import java.util.ArrayList;

public class CenterSelectionGUI extends JFrame{
    private JPanel centerRegistrationPanel;
    private JLabel climatemonitoringLabel;
    private JLabel centerRegistrationLabel;
    private JLabel centerRegistrationLabel2;
    private JButton completeRegistrationButton;
    private JLabel centerRegisrationLabel3;
    private JTable centersTable;
    private JPanel centersSelectionPanel;
    private JButton centerRegistrationButton;
    private JButton backButton;
    private JScrollPane centersScroll;

    public CenterSelectionGUI(User user, ArrayList<MonitoringCenter> centersList){
        setTitle("Climate Monitoring");
        setContentPane(centerRegistrationPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1024);// To set fixed dimensions
        new CenterSelectionGUIController(this, user, centersList);
    }

    public JPanel getCenterRegistrationPanel() {
        return centerRegistrationPanel;
    }

    public void setCenterRegistrationPanel(JPanel centerRegistrationPanel) {
        this.centerRegistrationPanel = centerRegistrationPanel;
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

    public JLabel getCenterRegistrationLabel2() {
        return centerRegistrationLabel2;
    }

    public void setCenterRegistrationLabel2(JLabel centerRegistrationLabel2) {
        this.centerRegistrationLabel2 = centerRegistrationLabel2;
    }

    public JButton getCompleteRegistrationButton() {
        return completeRegistrationButton;
    }

    public void setCompleteRegistrationButton(JButton completeRegistrationButton) {
        this.completeRegistrationButton = completeRegistrationButton;
    }

    public JLabel getCenterRegisrationLabel3() {
        return centerRegisrationLabel3;
    }

    public void setCenterRegisrationLabel3(JLabel centerRegisrationLabel3) {
        this.centerRegisrationLabel3 = centerRegisrationLabel3;
    }

    public JTable getCentersTable() {
        return centersTable;
    }

    public void setCentersTable(JTable centersTable) {
        this.centersTable = centersTable;
    }

    public JPanel getCentersSelectionPanel() {
        return centersSelectionPanel;
    }

    public void setCentersSelectionPanel(JPanel centersSelectionPanel) {
        this.centersSelectionPanel = centersSelectionPanel;
    }

    public JButton getCenterRegistrationButton() {
        return centerRegistrationButton;
    }

    public void setCenterRegistrationButton(JButton centerRegistrationButton) {
        this.centerRegistrationButton = centerRegistrationButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

}
