package com.climatemonitoring.clientCM.gui.views;

import com.climatemonitoring.clientCM.gui.controllers.OperatorHomeGUIController;
import com.climatemonitoring.shared.models.User;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

public class OperatorHomeGUI extends JFrame {

    //FIELDS

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
    private JButton namePoiSearchButton;
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
    private JTextField namePoiField;
    private JTextField countryPoiField;
    private JTextField addLatitudeField;
    private JTextField addLongitudeField;
    private JLabel namePoiLabel;
    private JLabel countryPoiLabel;
    private JLabel addLatitudeLabel;
    private JLabel addLongitudeLabel;
    private JPanel addPoiPanel;
    private JButton selectPoiButton;

    //CONSTRUCTOR

    public OperatorHomeGUI(User user) {
        setTitle("Climate Monitoring");
        setContentPane(operatorHomePanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setSize(1920, 1024);// To set fixed dimensions
        coordinatesSearchPanel.setSize(400, 400);
        nameSearchPanel.setSize(400, 400);
        new OperatorHomeGUIController(this, user);
    }

    //GETTER AND SETTER

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

    public JButton getNamePoiSearchButton() {
        return namePoiSearchButton;
    }

    public void setNamePoiSearchButton(JButton namePoiSearchButton) {
        this.namePoiSearchButton = namePoiSearchButton;
    }

    public JPanel getSearchPanel() {
        return searchPanel;
    }

    public void setSearchPanel(JPanel searchPanel) {
        this.searchPanel = searchPanel;
    }

    public JTextField getWindField() {
        return windField;
    }

    public void setWindField(JTextField windField) {
        this.windField = windField;
    }

    public JTextField getHumidityField() {
        return humidityField;
    }

    public void setHumidityField(JTextField humidityField) {
        this.humidityField = humidityField;
    }

    public JTextField getPressureField() {
        return pressureField;
    }

    public void setPressureField(JTextField pressureField) {
        this.pressureField = pressureField;
    }

    public JPanel getSurveysPanel() {
        return surveysPanel;
    }

    public void setSurveysPanel(JPanel surveysPanel) {
        this.surveysPanel = surveysPanel;
    }

    public JPanel getSurveyFormPanel() {
        return surveyFormPanel;
    }

    public void setSurveyFormPanel(JPanel surveyFormPanel) {
        this.surveyFormPanel = surveyFormPanel;
    }

    public JTextField getTemperatureField() {
        return temperatureField;
    }

    public void setTemperatureField(JTextField temperatureField) {
        this.temperatureField = temperatureField;
    }

    public JTextField getPrecipitationField() {
        return precipitationField;
    }

    public void setPrecipitationField(JTextField precipitationField) {
        this.precipitationField = precipitationField;
    }

    public JTextField getGlacial_altitudeField() {
        return glacial_altitudeField;
    }

    public void setGlacial_altitudeField(JTextField glacial_altitudeField) {
        this.glacial_altitudeField = glacial_altitudeField;
    }

    public JTextField getGlacial_massField() {
        return glacial_massField;
    }

    public void setGlacial_massField(JTextField glacial_massField) {
        this.glacial_massField = glacial_massField;
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }

    public void setLogoutButton(JButton logoutButton) {
        this.logoutButton = logoutButton;
    }

    public JLabel getWindLabel() {
        return windLabel;
    }

    public void setWindLabel(JLabel windLabel) {
        this.windLabel = windLabel;
    }

    public JLabel getHumidityLabel() {
        return humidityLabel;
    }

    public void setHumidityLabel(JLabel humidityLabel) {
        this.humidityLabel = humidityLabel;
    }

    public JLabel getPressureLabel() {
        return pressureLabel;
    }

    public void setPressureLabel(JLabel pressureLabel) {
        this.pressureLabel = pressureLabel;
    }

    public JLabel getTemperatureLabel() {
        return temperatureLabel;
    }

    public void setTemperatureLabel(JLabel temperatureLabel) {
        this.temperatureLabel = temperatureLabel;
    }

    public JLabel getPrecipitationLabel() {
        return precipitationLabel;
    }

    public void setPrecipitationLabel(JLabel precipitationLabel) {
        this.precipitationLabel = precipitationLabel;
    }

    public JLabel getGlacial_altitudeLabel() {
        return glacial_altitudeLabel;
    }

    public void setGlacial_altitudeLabel(JLabel glacial_altitudeLabel) {
        this.glacial_altitudeLabel = glacial_altitudeLabel;
    }

    public JLabel getGlacial_massLabel() {
        return glacial_massLabel;
    }

    public void setGlacial_massLabel(JLabel glacial_massLabel) {
        this.glacial_massLabel = glacial_massLabel;
    }

    public JLabel getSurveyInfoLabel() {
        return surveyInfoLabel;
    }

    public void setSurveyInfoLabel(JLabel surveyInfoLabel) {
        this.surveyInfoLabel = surveyInfoLabel;
    }

    public JLabel getClimateCategoryLabel() {
        return climateCategoryLabel;
    }

    public void setClimateCategoryLabel(JLabel climateCategoryLabel) {
        this.climateCategoryLabel = climateCategoryLabel;
    }

    public JLabel getExplanationLabel() {
        return explanationLabel;
    }

    public void setExplanationLabel(JLabel explanationLabel) {
        this.explanationLabel = explanationLabel;
    }

    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    public void setScoreLabel(JLabel scoreLabel) {
        this.scoreLabel = scoreLabel;
    }

    public JLabel getNotesLabel() {
        return notesLabel;
    }

    public void setNotesLabel(JLabel notesLabel) {
        this.notesLabel = notesLabel;
    }

    public JTextField getWindNoteField() {
        return windNoteField;
    }

    public void setWindNoteField(JTextField windNoteField) {
        this.windNoteField = windNoteField;
    }

    public JTextField getHumidityNoteField() {
        return humidityNoteField;
    }

    public void setHumidityNoteField(JTextField humidityNoteField) {
        this.humidityNoteField = humidityNoteField;
    }

    public JTextField getPressureNoteField() {
        return pressureNoteField;
    }

    public void setPressureNoteField(JTextField pressureNoteField) {
        this.pressureNoteField = pressureNoteField;
    }

    public JTextField getTemperatureNoteField() {
        return temperatureNoteField;
    }

    public void setTemperatureNoteField(JTextField temperatureNoteField) {
        this.temperatureNoteField = temperatureNoteField;
    }

    public JTextField getPrecipitationNoteField() {
        return precipitationNoteField;
    }

    public void setPrecipitationNoteField(JTextField precipitationNoteField) {
        this.precipitationNoteField = precipitationNoteField;
    }

    public JTextField getGlacial_altitudeNoteField() {
        return glacial_altitudeNoteField;
    }

    public void setGlacial_altitudeNoteField(JTextField glacial_altitudeNoteField) {
        this.glacial_altitudeNoteField = glacial_altitudeNoteField;
    }

    public JTextField getGlacial_massNoteField() {
        return glacial_massNoteField;
    }

    public void setGlacial_massNoteField(JTextField glacial_massNoteField) {
        this.glacial_massNoteField = glacial_massNoteField;
    }

    public JLabel getWindExplanationLabel() {
        return windExplanationLabel;
    }

    public void setWindExplanationLabel(JLabel windExplanationLabel) {
        this.windExplanationLabel = windExplanationLabel;
    }

    public JLabel getHumidityExplanationLabel() {
        return humidityExplanationLabel;
    }

    public void setHumidityExplanationLabel(JLabel humidityExplanationLabel) {
        this.humidityExplanationLabel = humidityExplanationLabel;
    }

    public JLabel getPressureExplanationLabel() {
        return pressureExplanationLabel;
    }

    public void setPressureExplanationLabel(JLabel pressureExplanationLabel) {
        this.pressureExplanationLabel = pressureExplanationLabel;
    }

    public JLabel getTemperatureExplanationLabel() {
        return temperatureExplanationLabel;
    }

    public void setTemperatureExplanationLabel(JLabel temperatureExplanationLabel) {
        this.temperatureExplanationLabel = temperatureExplanationLabel;
    }

    public JLabel getPrecipitationExplanationLabel() {
        return precipitationExplanationLabel;
    }

    public void setPrecipitationExplanationLabel(JLabel precipitationExplanationLabel) {
        this.precipitationExplanationLabel = precipitationExplanationLabel;
    }

    public JLabel getGlacial_altitudeExplanationLabel() {
        return glacial_altitudeExplanationLabel;
    }

    public void setGlacial_altitudeExplanationLabel(JLabel glacial_altitudeExplanationLabel) {
        this.glacial_altitudeExplanationLabel = glacial_altitudeExplanationLabel;
    }

    public JLabel getGlacial_massExplanationLabel() {
        return glacial_massExplanationLabel;
    }

    public void setGlacial_massExplanationLabel(JLabel glacial_massExplanationLabel) {
        this.glacial_massExplanationLabel = glacial_massExplanationLabel;
    }

    public JPanel getPoiSelectionPanel() {
        return poiSelectionPanel;
    }

    public void setPoiSelectionPanel(JPanel poiSelectionPanel) {
        this.poiSelectionPanel = poiSelectionPanel;
    }

    public JTable getPoiSelectionTable() {
        return poiSelectionTable;
    }

    public void setPoiSelectionTable(JTable poiSelectionTable) {
        this.poiSelectionTable = poiSelectionTable;
    }

    public JScrollPane getPoiSelectionScroll() {
        return poiSelectionScroll;
    }

    public void setPoiSelectionScroll(JScrollPane poiSelectionScroll) {
        this.poiSelectionScroll = poiSelectionScroll;
    }

    public JButton getAddSurveyButton() {
        return addSurveyButton;
    }

    public void setAddSurveyButton(JButton addSurveyButton) {
        this.addSurveyButton = addSurveyButton;
    }

    public JButton getAddPoiToCenterButton() {
        return addPoiToCenterButton;
    }

    public void setAddPoiToCenterButton(JButton addPoiToCenterButton) {
        this.addPoiToCenterButton = addPoiToCenterButton;
    }

    public JTextField getNamePoiField() {
        return namePoiField;
    }

    public void setNamePoiField(JTextField namePoiField) {
        this.namePoiField = namePoiField;
    }

    public JTextField getCountryPoiField() {
        return countryPoiField;
    }

    public void setCountryPoiField(JTextField countryPoiField) {
        this.countryPoiField = countryPoiField;
    }

    public JTextField getAddLatitudeField() {
        return addLatitudeField;
    }

    public void setAddLatitudeField(JTextField addLatitudeField) {
        this.addLatitudeField = addLatitudeField;
    }

    public JTextField getAddLongitudeField() {
        return addLongitudeField;
    }

    public void setAddLongitudeField(JTextField addLongitudeField) {
        this.addLongitudeField = addLongitudeField;
    }

    public JLabel getNamePoiLabel() {
        return namePoiLabel;
    }

    public void setNamePoiLabel(JLabel namePoiLabel) {
        this.namePoiLabel = namePoiLabel;
    }

    public JLabel getCountryPoiLabel() {
        return countryPoiLabel;
    }

    public void setCountryPoiLabel(JLabel countryPoiLabel) {
        this.countryPoiLabel = countryPoiLabel;
    }

    public JLabel getAddLatitudeLabel() {
        return addLatitudeLabel;
    }

    public void setAddLatitudeLabel(JLabel addLatitudeLabel) {
        this.addLatitudeLabel = addLatitudeLabel;
    }

    public JLabel getAddLongitudeLabel() {
        return addLongitudeLabel;
    }

    public void setAddLongitudeLabel(JLabel addLongitudeLabel) {
        this.addLongitudeLabel = addLongitudeLabel;
    }

    public JPanel getAddPoiPanel() {
        return addPoiPanel;
    }

    public void setAddPoiPanel(JPanel addPoiPanel) {
        this.addPoiPanel = addPoiPanel;
    }

    public JButton getSelectPoiButton() {
        return selectPoiButton;
    }

    public void setSelectPoiButton(JButton selectPoiButton) {
        this.selectPoiButton = selectPoiButton;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        operatorHomePanel = new JPanel();
        operatorHomePanel.setLayout(new GridLayoutManager(17, 4, new Insets(0, 0, 0, 0), -1, -1));
        operatorHomePanel.setBackground(new Color(-9473675));
        operatorHomePanel.setForeground(new Color(-9473675));
        climatemonitoringLabel = new JLabel();
        climatemonitoringLabel.setBackground(new Color(-1));
        Font climatemonitoringLabelFont = this.$$$getFont$$$("JetBrains Mono ExtraBold", Font.BOLD, 72, climatemonitoringLabel.getFont());
        if (climatemonitoringLabelFont != null) climatemonitoringLabel.setFont(climatemonitoringLabelFont);
        climatemonitoringLabel.setForeground(new Color(-1));
        climatemonitoringLabel.setText("Climate Monitoring");
        operatorHomePanel.add(climatemonitoringLabel, new GridConstraints(0, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        greetingLabel = new JLabel();
        greetingLabel.setBackground(new Color(-1));
        Font greetingLabelFont = this.$$$getFont$$$(null, -1, 16, greetingLabel.getFont());
        if (greetingLabelFont != null) greetingLabel.setFont(greetingLabelFont);
        greetingLabel.setForeground(new Color(-1));
        greetingLabel.setText("Benvenuti in Climate Monitoring, inserite i dati dell'area geografica di cui volete visualizzare le rilevazioni :");
        operatorHomePanel.add(greetingLabel, new GridConstraints(2, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        operatorHomePanel.add(spacer1, new GridConstraints(1, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        searchPanel.setBackground(new Color(-9473675));
        searchPanel.setForeground(new Color(-9473675));
        operatorHomePanel.add(searchPanel, new GridConstraints(3, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        coordinatesSearchPanel = new JPanel();
        coordinatesSearchPanel.setLayout(new GridLayoutManager(9, 1, new Insets(0, 0, 0, 0), -1, -1));
        coordinatesSearchPanel.setBackground(new Color(-9473675));
        coordinatesSearchPanel.setForeground(new Color(-9473675));
        searchPanel.add(coordinatesSearchPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        coordinatesSearchLabel = new JLabel();
        coordinatesSearchLabel.setBackground(new Color(-1));
        coordinatesSearchLabel.setForeground(new Color(-1));
        coordinatesSearchLabel.setText("Ricerca area per coordinate");
        coordinatesSearchPanel.add(coordinatesSearchLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        latitudeLabel = new JLabel();
        latitudeLabel.setBackground(new Color(-1));
        latitudeLabel.setForeground(new Color(-1));
        latitudeLabel.setText("Latitudine");
        coordinatesSearchPanel.add(latitudeLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        coordinatesSearchPanel.add(spacer2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(-1, 20), null, null, 0, false));
        latitudeField = new JTextField();
        coordinatesSearchPanel.add(latitudeField, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        longitudeLabel = new JLabel();
        longitudeLabel.setBackground(new Color(-1));
        longitudeLabel.setForeground(new Color(-1));
        longitudeLabel.setText("Longitudine");
        coordinatesSearchPanel.add(longitudeLabel, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        coordinatesSearchPanel.add(spacer3, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(-1, 20), null, null, 0, false));
        longitudeField = new JTextField();
        coordinatesSearchPanel.add(longitudeField, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        coordinatesSearchButton = new JButton();
        coordinatesSearchButton.setBackground(new Color(-13947600));
        coordinatesSearchButton.setForeground(new Color(-1));
        coordinatesSearchButton.setText("Cerca per coordinate");
        coordinatesSearchPanel.add(coordinatesSearchButton, new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        coordinatesSearchPanel.add(spacer4, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(-1, 20), null, null, 0, false));
        nameSearchPanel = new JPanel();
        nameSearchPanel.setLayout(new GridLayoutManager(9, 1, new Insets(0, 0, 0, 0), -1, -1));
        nameSearchPanel.setBackground(new Color(-9473675));
        nameSearchPanel.setForeground(new Color(-9473675));
        searchPanel.add(nameSearchPanel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        nameSearchLabel = new JLabel();
        nameSearchLabel.setBackground(new Color(-1));
        nameSearchLabel.setForeground(new Color(-1));
        nameSearchLabel.setText("Ricerca per denominazione");
        nameSearchPanel.add(nameSearchLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer5 = new Spacer();
        nameSearchPanel.add(spacer5, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(-1, 20), null, null, 0, false));
        nameLabel = new JLabel();
        nameLabel.setBackground(new Color(-1));
        nameLabel.setForeground(new Color(-1));
        nameLabel.setText("Nome area");
        nameSearchPanel.add(nameLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nameField = new JTextField();
        nameSearchPanel.add(nameField, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final Spacer spacer6 = new Spacer();
        nameSearchPanel.add(spacer6, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(-1, 20), null, null, 0, false));
        stateLabel = new JLabel();
        stateLabel.setBackground(new Color(-1));
        stateLabel.setForeground(new Color(-1));
        stateLabel.setText("Stato");
        nameSearchPanel.add(stateLabel, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        stateField = new JTextField();
        nameSearchPanel.add(stateField, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final Spacer spacer7 = new Spacer();
        nameSearchPanel.add(spacer7, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(-1, 20), null, null, 0, false));
        namePoiSearchButton = new JButton();
        namePoiSearchButton.setBackground(new Color(-13947600));
        namePoiSearchButton.setForeground(new Color(-1));
        namePoiSearchButton.setText("Cerca per denominazione");
        nameSearchPanel.add(namePoiSearchButton, new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer8 = new Spacer();
        operatorHomePanel.add(spacer8, new GridConstraints(4, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        surveysPanel = new JPanel();
        surveysPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        surveysPanel.setBackground(new Color(-9473675));
        surveysPanel.setForeground(new Color(-9473675));
        operatorHomePanel.add(surveysPanel, new GridConstraints(7, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        surveyFormPanel = new JPanel();
        surveyFormPanel.setLayout(new GridLayoutManager(8, 4, new Insets(0, 0, 0, 0), -1, -1));
        surveyFormPanel.setBackground(new Color(-9473675));
        surveyFormPanel.setForeground(new Color(-9473675));
        surveysPanel.add(surveyFormPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        windLabel = new JLabel();
        windLabel.setForeground(new Color(-1));
        windLabel.setText("Vento");
        surveyFormPanel.add(windLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        humidityLabel = new JLabel();
        humidityLabel.setForeground(new Color(-1));
        humidityLabel.setText("Umidità");
        surveyFormPanel.add(humidityLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pressureLabel = new JLabel();
        pressureLabel.setForeground(new Color(-1));
        pressureLabel.setText("Pressione");
        surveyFormPanel.add(pressureLabel, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        temperatureLabel = new JLabel();
        temperatureLabel.setForeground(new Color(-1));
        temperatureLabel.setText("Temperatura");
        surveyFormPanel.add(temperatureLabel, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        precipitationLabel = new JLabel();
        precipitationLabel.setForeground(new Color(-1));
        precipitationLabel.setText("Precipitazioni");
        surveyFormPanel.add(precipitationLabel, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        glacial_altitudeLabel = new JLabel();
        glacial_altitudeLabel.setForeground(new Color(-1));
        glacial_altitudeLabel.setText("Altitudine dei ghiacciai");
        surveyFormPanel.add(glacial_altitudeLabel, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        glacial_massLabel = new JLabel();
        glacial_massLabel.setForeground(new Color(-1));
        glacial_massLabel.setText("Massa dei ghiacciai");
        surveyFormPanel.add(glacial_massLabel, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        climateCategoryLabel = new JLabel();
        climateCategoryLabel.setForeground(new Color(-1));
        climateCategoryLabel.setText("Categoria Climatica");
        surveyFormPanel.add(climateCategoryLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        explanationLabel = new JLabel();
        explanationLabel.setForeground(new Color(-1));
        explanationLabel.setText("Spiegazione");
        surveyFormPanel.add(explanationLabel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        scoreLabel = new JLabel();
        scoreLabel.setForeground(new Color(-1));
        scoreLabel.setText("Score (da 1-critico a 5-ottimale)");
        surveyFormPanel.add(scoreLabel, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        notesLabel = new JLabel();
        notesLabel.setForeground(new Color(-1));
        notesLabel.setText("Note(massimo 256 caratteri)");
        surveyFormPanel.add(notesLabel, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        windField = new JTextField();
        surveyFormPanel.add(windField, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        humidityField = new JTextField();
        surveyFormPanel.add(humidityField, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pressureField = new JTextField();
        surveyFormPanel.add(pressureField, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        temperatureField = new JTextField();
        surveyFormPanel.add(temperatureField, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        precipitationField = new JTextField();
        surveyFormPanel.add(precipitationField, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        glacial_altitudeField = new JTextField();
        surveyFormPanel.add(glacial_altitudeField, new GridConstraints(6, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        glacial_massField = new JTextField();
        surveyFormPanel.add(glacial_massField, new GridConstraints(7, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        windNoteField = new JTextField();
        surveyFormPanel.add(windNoteField, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        humidityNoteField = new JTextField();
        surveyFormPanel.add(humidityNoteField, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pressureNoteField = new JTextField();
        surveyFormPanel.add(pressureNoteField, new GridConstraints(3, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        temperatureNoteField = new JTextField();
        surveyFormPanel.add(temperatureNoteField, new GridConstraints(4, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        precipitationNoteField = new JTextField();
        surveyFormPanel.add(precipitationNoteField, new GridConstraints(5, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        glacial_altitudeNoteField = new JTextField();
        surveyFormPanel.add(glacial_altitudeNoteField, new GridConstraints(6, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        glacial_massNoteField = new JTextField();
        surveyFormPanel.add(glacial_massNoteField, new GridConstraints(7, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        windExplanationLabel = new JLabel();
        windExplanationLabel.setForeground(new Color(-1));
        windExplanationLabel.setText("Velocità del vento (km/h), suddivisa in fasce");
        surveyFormPanel.add(windExplanationLabel, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        humidityExplanationLabel = new JLabel();
        humidityExplanationLabel.setForeground(new Color(-1));
        humidityExplanationLabel.setText("% di Umidità, suddivisa in fasce");
        surveyFormPanel.add(humidityExplanationLabel, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pressureExplanationLabel = new JLabel();
        pressureExplanationLabel.setForeground(new Color(-1));
        pressureExplanationLabel.setText("In hPa, suddivisa in fasce");
        surveyFormPanel.add(pressureExplanationLabel, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        temperatureExplanationLabel = new JLabel();
        temperatureExplanationLabel.setForeground(new Color(-1));
        temperatureExplanationLabel.setText("In C°, suddivisa in fasce");
        surveyFormPanel.add(temperatureExplanationLabel, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        precipitationExplanationLabel = new JLabel();
        precipitationExplanationLabel.setForeground(new Color(-1));
        precipitationExplanationLabel.setText("In mm di pioggia, suddivisa in fasce");
        surveyFormPanel.add(precipitationExplanationLabel, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        glacial_altitudeExplanationLabel = new JLabel();
        glacial_altitudeExplanationLabel.setForeground(new Color(-1));
        glacial_altitudeExplanationLabel.setText("In m, suddivisa in piogge");
        surveyFormPanel.add(glacial_altitudeExplanationLabel, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        glacial_massExplanationLabel = new JLabel();
        glacial_massExplanationLabel.setForeground(new Color(-1));
        glacial_massExplanationLabel.setText("In kg, suddivisa in fasce");
        surveyFormPanel.add(glacial_massExplanationLabel, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        surveyInfoLabel = new JLabel();
        surveyInfoLabel.setBackground(new Color(-1));
        Font surveyInfoLabelFont = this.$$$getFont$$$(null, -1, 16, surveyInfoLabel.getFont());
        if (surveyInfoLabelFont != null) surveyInfoLabel.setFont(surveyInfoLabelFont);
        surveyInfoLabel.setForeground(new Color(-1));
        surveyInfoLabel.setText("Se desideri inserire i Parametri Climatici di una rilevazione completa il form sottostante, seleziona l'Area Geografica di appartenenza e clicca su \"Aggiungi Parametri\".");
        operatorHomePanel.add(surveyInfoLabel, new GridConstraints(5, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        logoutButton = new JButton();
        logoutButton.setBackground(new Color(-13947600));
        logoutButton.setForeground(new Color(-1));
        logoutButton.setText("Logout");
        operatorHomePanel.add(logoutButton, new GridConstraints(15, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        poiSelectionPanel = new JPanel();
        poiSelectionPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        operatorHomePanel.add(poiSelectionPanel, new GridConstraints(9, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        poiSelectionScroll = new JScrollPane();
        poiSelectionPanel.add(poiSelectionScroll, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        poiSelectionTable = new JTable();
        poiSelectionScroll.setViewportView(poiSelectionTable);
        addSurveyButton = new JButton();
        addSurveyButton.setBackground(new Color(-13947600));
        addSurveyButton.setForeground(new Color(-1));
        addSurveyButton.setText("Aggiungi Parametri");
        operatorHomePanel.add(addSurveyButton, new GridConstraints(11, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer9 = new Spacer();
        operatorHomePanel.add(spacer9, new GridConstraints(14, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer10 = new Spacer();
        operatorHomePanel.add(spacer10, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer11 = new Spacer();
        operatorHomePanel.add(spacer11, new GridConstraints(10, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer12 = new Spacer();
        operatorHomePanel.add(spacer12, new GridConstraints(9, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, new Dimension(10, 10), new Dimension(10, 10), new Dimension(10, 10), 0, false));
        final Spacer spacer13 = new Spacer();
        operatorHomePanel.add(spacer13, new GridConstraints(9, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, new Dimension(10, 10), 0, false));
        final Spacer spacer14 = new Spacer();
        operatorHomePanel.add(spacer14, new GridConstraints(16, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer15 = new Spacer();
        operatorHomePanel.add(spacer15, new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        addPoiPanel = new JPanel();
        addPoiPanel.setLayout(new GridLayoutManager(2, 4, new Insets(0, 0, 0, 0), -1, -1));
        addPoiPanel.setBackground(new Color(-9473675));
        addPoiPanel.setForeground(new Color(-9473675));
        operatorHomePanel.add(addPoiPanel, new GridConstraints(11, 2, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        namePoiLabel = new JLabel();
        namePoiLabel.setBackground(new Color(-1));
        namePoiLabel.setForeground(new Color(-1));
        namePoiLabel.setText("Nome Area");
        addPoiPanel.add(namePoiLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        namePoiField = new JTextField();
        namePoiField.setText("");
        addPoiPanel.add(namePoiField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        countryPoiLabel = new JLabel();
        countryPoiLabel.setBackground(new Color(-1));
        countryPoiLabel.setForeground(new Color(-1));
        countryPoiLabel.setText("Stato");
        addPoiPanel.add(countryPoiLabel, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        countryPoiField = new JTextField();
        addPoiPanel.add(countryPoiField, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        addLatitudeLabel = new JLabel();
        addLatitudeLabel.setBackground(new Color(-1));
        addLatitudeLabel.setForeground(new Color(-1));
        addLatitudeLabel.setText("Latitudine");
        addPoiPanel.add(addLatitudeLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addLatitudeField = new JTextField();
        addPoiPanel.add(addLatitudeField, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        addLongitudeField = new JTextField();
        addPoiPanel.add(addLongitudeField, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        addLongitudeLabel = new JLabel();
        addLongitudeLabel.setBackground(new Color(-1));
        addLongitudeLabel.setForeground(new Color(-1));
        addLongitudeLabel.setText("Longitudine");
        addPoiPanel.add(addLongitudeLabel, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addPoiToCenterButton = new JButton();
        addPoiToCenterButton.setBackground(new Color(-13947600));
        addPoiToCenterButton.setForeground(new Color(-1));
        addPoiToCenterButton.setText("Aggiungi Area");
        operatorHomePanel.add(addPoiToCenterButton, new GridConstraints(13, 2, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        selectPoiButton = new JButton();
        selectPoiButton.setBackground(new Color(-13947600));
        selectPoiButton.setForeground(new Color(-1));
        selectPoiButton.setText("Visualizza Aggregato Parametri Climatici");
        operatorHomePanel.add(selectPoiButton, new GridConstraints(12, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return operatorHomePanel;
    }

}
