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
    private JPanel searchPanel;
    private JTextField windField;
    private JTextField humidityField;
    private JTextField pressureField;
    private JPanel surveysPanel;
    private JPanel surveyFormPanel;
    private JTextField temperatureField;
    private JTextField precipitationField;
    private JTextField glacial_altitudeField;
    private JTextField glacial_massField;
    private JButton logoutButton;
    private JLabel windLabel;
    private JLabel humidityLabel;
    private JLabel pressureLabel;
    private JLabel temperatureLabel;
    private JLabel precipitationLabel;
    private JLabel glacial_altitudeLabel;
    private JLabel glacial_massLabel;
    private JLabel surveyInfoLabel;
    private JLabel climateCategoryLabel;
    private JLabel explanationLabel;
    private JLabel scoreLabel;
    private JLabel notesLabel;
    private JTextField windNoteField;
    private JTextField humidityNoteField;
    private JTextField pressureNoteField;
    private JTextField temperatureNoteField;
    private JTextField precipitationNoteField;
    private JTextField glacial_altitudeNoteField;
    private JTextField glacial_massNoteField;
    private JLabel windExplanationLabel;
    private JLabel humidityExplanationLabel;
    private JLabel pressureExplanationLabel;
    private JLabel temperatureExplanationLabel;
    private JLabel precipitationExplanationLabel;
    private JLabel glacial_altitudeExplanationLabel;
    private JLabel glacial_massExplanationLabel;
    private JPanel poiSelectionPanel;
    private JTable poiSelectionTable;
    private JScrollPane poiSelectionScroll;
    private JButton addSurveyButton;
    private JButton addPoiToCenterButton;

    public OperatorHomeGUI(){
        setTitle("Climate Monitoring");
        setContentPane(operatorHomePanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1024);// To set fixed dimensions
        coordinatesSearchPanel.setSize(400,400);
        nameSearchPanel.setSize(400,400);
        new OperatorHomeGUIController(this);
    }

}
