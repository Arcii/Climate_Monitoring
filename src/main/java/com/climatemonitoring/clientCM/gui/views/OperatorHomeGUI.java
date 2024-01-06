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

/**
 * Represents the graphical user interface (GUI) view class for the home screen of a logged-in operator.
 * The OperatorHomeGUI provides various panels and components for searching points of interest (POIs), adding surveys, and managing data.
 * It is controlled by the OperatorHomeGUIController.
 *
 * @author Lorenzo Cattapan 726459 (Varese)
 * @version 1.0
 * @see OperatorHomeGUIController
 */
public class OperatorHomeGUI extends JFrame {

    //*****************FIELDS*****************//

    /**
     * The main panel of the OperatorHomeGUI that contains various subpanels and components.
     */
    private JPanel operatorHomePanel;
    /**
     * The label displaying the name of the climate monitoring application.
     */
    private JLabel climatemonitoringLabel;
    /**
     * The label displaying a greeting message.
     */
    private JLabel greetingLabel;
    /**
     * The panel for searching coordinates.
     */
    private JPanel coordinatesSearchPanel;
    /**
     * The label indicating the purpose of the coordinates search panel.
     */
    private JLabel coordinatesSearchLabel;
    /**
     * The label for latitude in the coordinates search panel.
     */
    private JLabel latitudeLabel;
    /**
     * The text field for entering latitude in the coordinates search panel.
     */
    private JTextField latitudeField;
    /**
     * The label for longitude in the coordinates search panel.
     */
    private JLabel longitudeLabel;
    /**
     * The text field for entering longitude in the coordinates search panel.
     */
    private JTextField longitudeField;
    /**
     * The button to initiate the coordinates search.
     */
    private JButton coordinatesSearchButton;
    /**
     * The panel for searching by name.
     */
    private JPanel nameSearchPanel;
    /**
     * The label indicating the purpose of the name search panel.
     */
    private JLabel nameSearchLabel;
    /**
     * The label for the name in the name search panel.
     */
    private JLabel nameLabel;
    /**
     * The text field for entering the name in the name search panel.
     */
    private JTextField nameField;
    /**
     * The label for the state in the name search panel.
     */
    private JLabel stateLabel;
    /**
     * The text field for entering the state in the name search panel.
     */
    private JTextField stateField;
    /**
     * The button to initiate the name-based POI search.
     */
    private JButton namePoiSearchButton;
    /**
     * The panel containing various search fields for surveys.
     */
    private JPanel searchPanel;
    /**
     * The text field for entering wind information in the search panel.
     */
    private JTextField windField;
    /**
     * The text field for entering humidity information in the search panel.
     */
    private JTextField humidityField;
    /**
     * The text field for entering pressure information in the search panel.
     */
    private JTextField pressureField;
    /**
     * The panel displaying surveys.
     */
    private JPanel surveysPanel;
    /**
     * The panel containing a form for survey information.
     */
    private JPanel surveyFormPanel;
    /**
     * The text field for entering temperature information in the survey form panel.
     */
    private JTextField temperatureField;
    /**
     * The text field for entering precipitation information in the survey form panel.
     */
    private JTextField precipitationField;
    /**
     * The text field for entering glacial altitude information in the survey form panel.
     */
    private JTextField glacial_altitudeField;
    /**
     * The text field for entering glacial mass information in the survey form panel.
     */
    private JTextField glacial_massField;
    /**
     * The button to log out of the application.
     */
    private JButton logoutButton;
    /**
     * The label displaying information about wind in the survey form panel.
     */
    private JLabel windLabel;
    /**
     * The label displaying information about humidity in the survey form panel.
     */
    private JLabel humidityLabel;
    /**
     * The label displaying information about pressure in the survey form panel.
     */
    private JLabel pressureLabel;
    /**
     * The label displaying information about temperature in the survey form panel.
     */
    private JLabel temperatureLabel;
    /**
     * The label displaying information about precipitation in the survey form panel.
     */
    private JLabel precipitationLabel;
    /**
     * The label displaying information about glacial altitude in the survey form panel.
     */
    private JLabel glacial_altitudeLabel;
    /**
     * The label displaying information about glacial mass in the survey form panel.
     */
    private JLabel glacial_massLabel;
    /**
     * The label displaying general survey information.
     */
    private JLabel surveyInfoLabel;
    /**
     * The label displaying the climate category in the survey form panel.
     */
    private JLabel climateCategoryLabel;
    /**
     * The label providing an explanation in the survey form panel.
     */
    private JLabel explanationLabel;
    /**
     * The label displaying the survey score in the survey form panel.
     */
    private JLabel scoreLabel;
    /**
     * The label displaying additional notes in the survey form panel.
     */
    private JLabel notesLabel;
    /**
     * The text field for entering notes about wind in the survey form panel.
     */
    private JTextField windNoteField;
    /**
     * The text field for entering notes about humidity in the survey form panel.
     */
    private JTextField humidityNoteField;
    /**
     * The text field for entering notes about pressure in the survey form panel.
     */
    private JTextField pressureNoteField;
    /**
     * The text field for entering notes about temperature in the survey form panel.
     */
    private JTextField temperatureNoteField;
    /**
     * The text field for entering notes about precipitation in the survey form panel.
     */
    private JTextField precipitationNoteField;
    /**
     * The text field for entering notes about glacial altitude in the survey form panel.
     */
    private JTextField glacial_altitudeNoteField;
    /**
     * The text field for entering notes about glacial mass in the survey form panel.
     */
    private JTextField glacial_massNoteField;
    /**
     * The label providing an explanation about wind in the survey form panel.
     */
    private JLabel windExplanationLabel;
    /**
     * The label providing an explanation about humidity in the survey form panel.
     */
    private JLabel humidityExplanationLabel;
    /**
     * The label providing an explanation about pressure in the survey form panel.
     */
    private JLabel pressureExplanationLabel;
    /**
     * The label providing an explanation about temperature in the survey form panel.
     */
    private JLabel temperatureExplanationLabel;
    /**
     * The label providing an explanation about precipitation in the survey form panel.
     */
    private JLabel precipitationExplanationLabel;
    /**
     * The label providing an explanation about glacial altitude in the survey form panel.
     */
    private JLabel glacial_altitudeExplanationLabel;
    /**
     * The label providing an explanation about glacial mass in the survey form panel.
     */
    private JLabel glacial_massExplanationLabel;
    /**
     * The panel for selecting points of interest.
     */
    private JPanel poiSelectionPanel;
    /**
     * The table displaying a list of selected points of interest.
     */
    private JTable poiSelectionTable;
    /**
     * The scroll pane for the points of interest selection table.
     */
    private JScrollPane poiSelectionScroll;
    /**
     * The button to add a new survey.
     */
    private JButton addSurveyButton;
    /**
     * The button to add a point of interest to a center.
     */
    private JButton addPoiToCenterButton;
    /**
     * The text field for entering the name of a new point of interest.
     */
    private JTextField namePoiField;
    /**
     * The text field for entering the country of a new point of interest.
     */
    private JTextField countryPoiField;
    /**
     * The text field for entering the latitude of a new point of interest.
     */
    private JTextField addLatitudeField;
    /**
     * The text field for entering the longitude of a new point of interest.
     */
    private JTextField addLongitudeField;
    /**
     * The label indicating the purpose of the name entry field in the point of interest panel.
     */
    private JLabel namePoiLabel;
    /**
     * The label indicating the purpose of the country entry field in the point of interest panel.
     */
    private JLabel countryPoiLabel;
    /**
     * The label indicating the purpose of the latitude entry field in the point of interest panel.
     */
    private JLabel addLatitudeLabel;
    /**
     * The label indicating the purpose of the longitude entry field in the point of interest panel.
     */
    private JLabel addLongitudeLabel;
    /**
     * The panel for adding a new point of interest.
     */
    private JPanel addPoiPanel;
    /**
     * The button to select a point of interest.
     */
    private JButton selectPoiButton;

    //*****************CONSTRUCTOR*****************//

    /**
     * Creates a new OperatorHomeGUI instance with the specified user.
     *
     * @param user The user associated with the operator.
     */
    public OperatorHomeGUI(User user) {
        // Set the title and content pane of the JFrame
        setTitle("Climate Monitoring");
        setContentPane(operatorHomePanel);
        // Set JFrame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setMinimumSize(new Dimension(1000, 650));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        coordinatesSearchPanel.setSize(400, 400);
        nameSearchPanel.setSize(400, 400);
        new OperatorHomeGUIController(this, user);
    }

    //*****************GETTER AND SETTER*****************//

    /**
     * Retrieves the main panel of the OperatorHomeGUI containing various subpanels and components.
     *
     * @return The main panel of the OperatorHomeGUI.
     */
    public JPanel getOperatorHomePanel() {
        return operatorHomePanel;
    }

    /**
     * Sets the main panel of the OperatorHomeGUI containing various subpanels and components.
     *
     * @param operatorHomePanel The main panel of the OperatorHomeGUI.
     */
    public void setOperatorHomePanel(JPanel operatorHomePanel) {
        this.operatorHomePanel = operatorHomePanel;
    }

    /**
     * Retrieves the label displaying the name of the climate monitoring application.
     *
     * @return The label displaying the name of the climate monitoring application.
     */
    public JLabel getClimatemonitoringLabel() {
        return climatemonitoringLabel;
    }

    /**
     * Sets the label displaying the name of the climate monitoring application.
     *
     * @param climatemonitoringLabel The label displaying the name of the climate monitoring application.
     */
    public void setClimatemonitoringLabel(JLabel climatemonitoringLabel) {
        this.climatemonitoringLabel = climatemonitoringLabel;
    }

    /**
     * Retrieves the label displaying a greeting message.
     *
     * @return The label displaying a greeting message.
     */
    public JLabel getGreetingLabel() {
        return greetingLabel;
    }

    /**
     * Sets the label displaying a greeting message.
     *
     * @param greetingLabel The label displaying a greeting message.
     */
    public void setGreetingLabel(JLabel greetingLabel) {
        this.greetingLabel = greetingLabel;
    }

    /**
     * Retrieves the panel for searching coordinates.
     *
     * @return The panel for searching coordinates.
     */
    public JPanel getCoordinatesSearchPanel() {
        return coordinatesSearchPanel;
    }

    /**
     * Sets the panel for searching coordinates.
     *
     * @param coordinatesSearchPanel The panel for searching coordinates.
     */
    public void setCoordinatesSearchPanel(JPanel coordinatesSearchPanel) {
        this.coordinatesSearchPanel = coordinatesSearchPanel;
    }

    /**
     * Retrieves the label indicating the purpose of the coordinates search panel.
     *
     * @return The label indicating the purpose of the coordinates search panel.
     */
    public JLabel getCoordinatesSearchLabel() {
        return coordinatesSearchLabel;
    }

    /**
     * Sets the label indicating the purpose of the coordinates search panel.
     *
     * @param coordinatesSearchLabel The label indicating the purpose of the coordinates search panel.
     */
    public void setCoordinatesSearchLabel(JLabel coordinatesSearchLabel) {
        this.coordinatesSearchLabel = coordinatesSearchLabel;
    }

    /**
     * Retrieves the label for latitude in the coordinates search panel.
     *
     * @return The label for latitude in the coordinates search panel.
     */
    public JLabel getLatitudeLabel() {
        return latitudeLabel;
    }

    /**
     * Sets the label for latitude in the coordinates search panel.
     *
     * @param latitudeLabel The label for latitude in the coordinates search panel.
     */
    public void setLatitudeLabel(JLabel latitudeLabel) {
        this.latitudeLabel = latitudeLabel;
    }

    /**
     * Retrieves the text field for entering latitude in the coordinates search panel.
     *
     * @return The text field for entering latitude in the coordinates search panel.
     */
    public JTextField getLatitudeField() {
        return latitudeField;
    }

    /**
     * Sets the text field for entering latitude in the coordinates search panel.
     *
     * @param latitudeField The text field for entering latitude in the coordinates search panel.
     */
    public void setLatitudeField(JTextField latitudeField) {
        this.latitudeField = latitudeField;
    }

    /**
     * Retrieves the label for longitude in the coordinates search panel.
     *
     * @return The label for longitude in the coordinates search panel.
     */
    public JLabel getLongitudeLabel() {
        return longitudeLabel;
    }

    /**
     * Sets the label for longitude in the coordinates search panel.
     *
     * @param longitudeLabel The label for longitude in the coordinates search panel.
     */
    public void setLongitudeLabel(JLabel longitudeLabel) {
        this.longitudeLabel = longitudeLabel;
    }

    /**
     * Retrieves the text field for entering longitude in the coordinates search panel.
     *
     * @return The text field for entering longitude in the coordinates search panel.
     */
    public JTextField getLongitudeField() {
        return longitudeField;
    }

    /**
     * Sets the text field for entering longitude in the coordinates search panel.
     *
     * @param longitudeField The text field for entering longitude in the coordinates search panel.
     */
    public void setLongitudeField(JTextField longitudeField) {
        this.longitudeField = longitudeField;
    }

    /**
     * Retrieves the button to initiate the coordinates search.
     *
     * @return The button to initiate the coordinates search.
     */
    public JButton getCoordinatesSearchButton() {
        return coordinatesSearchButton;
    }

    /**
     * Sets the button to initiate the coordinates search.
     *
     * @param coordinatesSearchButton The button to initiate the coordinates search.
     */
    public void setCoordinatesSearchButton(JButton coordinatesSearchButton) {
        this.coordinatesSearchButton = coordinatesSearchButton;
    }

    /**
     * Retrieves the panel for searching by name.
     *
     * @return The panel for searching by name.
     */
    public JPanel getNameSearchPanel() {
        return nameSearchPanel;
    }

    /**
     * Sets the panel for searching by name.
     *
     * @param nameSearchPanel The panel for searching by name.
     */
    public void setNameSearchPanel(JPanel nameSearchPanel) {
        this.nameSearchPanel = nameSearchPanel;
    }

    /**
     * Retrieves the label indicating the purpose of the name search panel.
     *
     * @return The label indicating the purpose of the name search panel.
     */
    public JLabel getNameSearchLabel() {
        return nameSearchLabel;
    }

    /**
     * Sets the label indicating the purpose of the name search panel.
     *
     * @param nameSearchLabel The label indicating the purpose of the name search panel.
     */
    public void setNameSearchLabel(JLabel nameSearchLabel) {
        this.nameSearchLabel = nameSearchLabel;
    }

    /**
     * Retrieves the label for entering the name in the search panel.
     *
     * @return The label for entering the name in the search panel.
     */
    public JLabel getNameLabel() {
        return nameLabel;
    }

    /**
     * Sets the label for entering the name in the search panel.
     *
     * @param nameLabel The label for entering the name in the search panel.
     */
    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    /**
     * Retrieves the text field for entering the name in the search panel.
     *
     * @return The text field for entering the name in the search panel.
     */
    public JTextField getNameField() {
        return nameField;
    }

    /**
     * Sets the text field for entering the name in the search panel.
     *
     * @param nameField The text field for entering the name in the search panel.
     */
    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    /**
     * Retrieves the label for entering the state in the search panel.
     *
     * @return The label for entering the state in the search panel.
     */
    public JLabel getStateLabel() {
        return stateLabel;
    }

    /**
     * Sets the label for entering the state in the search panel.
     *
     * @param stateLabel The label for entering the state in the search panel.
     */
    public void setStateLabel(JLabel stateLabel) {
        this.stateLabel = stateLabel;
    }

    /**
     * Retrieves the text field for entering the state in the search panel.
     *
     * @return The text field for entering the state in the search panel.
     */
    public JTextField getStateField() {
        return stateField;
    }

    /**
     * Sets the text field for entering the state in the search panel.
     *
     * @param stateField The text field for entering the state in the search panel.
     */
    public void setStateField(JTextField stateField) {
        this.stateField = stateField;
    }

    /**
     * Retrieves the button to initiate the name-based POI search.
     *
     * @return The button to initiate the name-based POI search.
     */
    public JButton getNamePoiSearchButton() {
        return namePoiSearchButton;
    }

    /**
     * Sets the button to initiate the name-based POI search.
     *
     * @param namePoiSearchButton The button to initiate the name-based POI search.
     */
    public void setNamePoiSearchButton(JButton namePoiSearchButton) {
        this.namePoiSearchButton = namePoiSearchButton;
    }

    /**
     * Retrieves the panel containing search-related components.
     *
     * @return The panel containing search-related components.
     */
    public JPanel getSearchPanel() {
        return searchPanel;
    }

    /**
     * Sets the panel containing search-related components.
     *
     * @param searchPanel The panel containing search-related components.
     */
    public void setSearchPanel(JPanel searchPanel) {
        this.searchPanel = searchPanel;
    }

    /**
     * Retrieves the text field for entering wind data.
     *
     * @return The text field for entering wind data.
     */
    public JTextField getWindField() {
        return windField;
    }

    /**
     * Sets the text field for entering wind data.
     *
     * @param windField The text field for entering wind data.
     */
    public void setWindField(JTextField windField) {
        this.windField = windField;
    }

    /**
     * Retrieves the text field for entering humidity data.
     *
     * @return The text field for entering humidity data.
     */
    public JTextField getHumidityField() {
        return humidityField;
    }

    /**
     * Sets the text field for entering humidity data.
     *
     * @param humidityField The text field for entering humidity data.
     */
    public void setHumidityField(JTextField humidityField) {
        this.humidityField = humidityField;
    }

    /**
     * Retrieves the text field for entering pressure data.
     *
     * @return The text field for entering pressure data.
     */
    public JTextField getPressureField() {
        return pressureField;
    }

    /**
     * Sets the text field for entering pressure data.
     *
     * @param pressureField The text field for entering pressure data.
     */
    public void setPressureField(JTextField pressureField) {
        this.pressureField = pressureField;
    }

    /**
     * Retrieves the panel containing survey-related components.
     *
     * @return The panel containing survey-related components.
     */
    public JPanel getSurveysPanel() {
        return surveysPanel;
    }

    /**
     * Sets the panel containing survey-related components.
     *
     * @param surveysPanel The panel containing survey-related components.
     */
    public void setSurveysPanel(JPanel surveysPanel) {
        this.surveysPanel = surveysPanel;
    }

    /**
     * Retrieves the panel containing survey form components.
     *
     * @return The panel containing survey form components.
     */
    public JPanel getSurveyFormPanel() {
        return surveyFormPanel;
    }

    /**
     * Sets the panel containing survey form components.
     *
     * @param surveyFormPanel The panel containing survey form components.
     */
    public void setSurveyFormPanel(JPanel surveyFormPanel) {
        this.surveyFormPanel = surveyFormPanel;
    }

    /**
     * Retrieves the text field for entering temperature data.
     *
     * @return The text field for entering temperature data.
     */
    public JTextField getTemperatureField() {
        return temperatureField;
    }

    /**
     * Sets the text field for entering temperature data.
     *
     * @param temperatureField The text field for entering temperature data.
     */
    public void setTemperatureField(JTextField temperatureField) {
        this.temperatureField = temperatureField;
    }

    /**
     * Retrieves the text field for entering precipitation data.
     *
     * @return The text field for entering precipitation data.
     */
    public JTextField getPrecipitationField() {
        return precipitationField;
    }

    /**
     * Sets the text field for entering precipitation data.
     *
     * @param precipitationField The text field for entering precipitation data.
     */
    public void setPrecipitationField(JTextField precipitationField) {
        this.precipitationField = precipitationField;
    }

    /**
     * Retrieves the text field for entering glacial altitude data.
     *
     * @return The text field for entering glacial altitude data.
     */
    public JTextField getGlacial_altitudeField() {
        return glacial_altitudeField;
    }

    /**
     * Sets the text field for entering glacial altitude data.
     *
     * @param glacial_altitudeField The text field for entering glacial altitude data.
     */
    public void setGlacial_altitudeField(JTextField glacial_altitudeField) {
        this.glacial_altitudeField = glacial_altitudeField;
    }

    /**
     * Retrieves the text field for entering glacial mass data.
     *
     * @return The text field for entering glacial mass data.
     */
    public JTextField getGlacial_massField() {
        return glacial_massField;
    }

    /**
     * Sets the text field for entering glacial mass data.
     *
     * @param glacial_massField The text field for entering glacial mass data.
     */
    public void setGlacial_massField(JTextField glacial_massField) {
        this.glacial_massField = glacial_massField;
    }

    /**
     * Retrieves the button to initiate the logout process.
     *
     * @return The button to initiate the logout process.
     */
    public JButton getLogoutButton() {
        return logoutButton;
    }

    /**
     * Sets the button to initiate the logout process.
     *
     * @param logoutButton The button to initiate the logout process.
     */
    public void setLogoutButton(JButton logoutButton) {
        this.logoutButton = logoutButton;
    }

    /**
     * Retrieves the label indicating wind data.
     *
     * @return The label indicating wind data.
     */
    public JLabel getWindLabel() {
        return windLabel;
    }

    /**
     * Sets the label indicating wind data.
     *
     * @param windLabel The label indicating wind data.
     */
    public void setWindLabel(JLabel windLabel) {
        this.windLabel = windLabel;
    }

    /**
     * Retrieves the label indicating humidity data.
     *
     * @return The label indicating humidity data.
     */
    public JLabel getHumidityLabel() {
        return humidityLabel;
    }

    /**
     * Sets the label indicating humidity data.
     *
     * @param humidityLabel The label indicating humidity data.
     */
    public void setHumidityLabel(JLabel humidityLabel) {
        this.humidityLabel = humidityLabel;
    }

    /**
     * Retrieves the label indicating pressure data.
     *
     * @return The label indicating pressure data.
     */
    public JLabel getPressureLabel() {
        return pressureLabel;
    }

    /**
     * Sets the label indicating pressure data.
     *
     * @param pressureLabel The label indicating pressure data.
     */
    public void setPressureLabel(JLabel pressureLabel) {
        this.pressureLabel = pressureLabel;
    }

    /**
     * Retrieves the label indicating temperature data.
     *
     * @return The label indicating temperature data.
     */
    public JLabel getTemperatureLabel() {
        return temperatureLabel;
    }

    /**
     * Sets the label indicating temperature data.
     *
     * @param temperatureLabel The label indicating temperature data.
     */
    public void setTemperatureLabel(JLabel temperatureLabel) {
        this.temperatureLabel = temperatureLabel;
    }

    /**
     * Retrieves the label indicating precipitation data.
     *
     * @return The label indicating precipitation data.
     */
    public JLabel getPrecipitationLabel() {
        return precipitationLabel;
    }

    /**
     * Sets the label indicating precipitation data.
     *
     * @param precipitationLabel The label indicating precipitation data.
     */
    public void setPrecipitationLabel(JLabel precipitationLabel) {
        this.precipitationLabel = precipitationLabel;
    }

    /**
     * Retrieves the label indicating glacial altitude data.
     *
     * @return The label indicating glacial altitude data.
     */
    public JLabel getGlacial_altitudeLabel() {
        return glacial_altitudeLabel;
    }

    /**
     * Sets the label indicating glacial altitude data.
     *
     * @param glacial_altitudeLabel The label indicating glacial altitude data.
     */
    public void setGlacial_altitudeLabel(JLabel glacial_altitudeLabel) {
        this.glacial_altitudeLabel = glacial_altitudeLabel;
    }

    /**
     * Retrieves the label indicating glacial mass data.
     *
     * @return The label indicating glacial mass data.
     */
    public JLabel getGlacial_massLabel() {
        return glacial_massLabel;
    }

    /**
     * Sets the label indicating glacial mass data.
     *
     * @param glacial_massLabel The label indicating glacial mass data.
     */
    public void setGlacial_massLabel(JLabel glacial_massLabel) {
        this.glacial_massLabel = glacial_massLabel;
    }

    /**
     * Retrieves the label indicating survey information.
     *
     * @return The label indicating survey information.
     */
    public JLabel getSurveyInfoLabel() {
        return surveyInfoLabel;
    }

    /**
     * Sets the label indicating survey information.
     *
     * @param surveyInfoLabel The label indicating survey information.
     */
    public void setSurveyInfoLabel(JLabel surveyInfoLabel) {
        this.surveyInfoLabel = surveyInfoLabel;
    }

    /**
     * Retrieves the label indicating climate category.
     *
     * @return The label indicating climate category.
     */
    public JLabel getClimateCategoryLabel() {
        return climateCategoryLabel;
    }

    /**
     * Sets the label indicating climate category.
     *
     * @param climateCategoryLabel The label indicating climate category.
     */
    public void setClimateCategoryLabel(JLabel climateCategoryLabel) {
        this.climateCategoryLabel = climateCategoryLabel;
    }

    /**
     * Retrieves the label providing an explanation.
     *
     * @return The label providing an explanation.
     */
    public JLabel getExplanationLabel() {
        return explanationLabel;
    }

    /**
     * Sets the label providing an explanation.
     *
     * @param explanationLabel The label providing an explanation.
     */
    public void setExplanationLabel(JLabel explanationLabel) {
        this.explanationLabel = explanationLabel;
    }

    /**
     * Retrieves the label indicating a score.
     *
     * @return The label indicating a score.
     */
    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    /**
     * Sets the label indicating a score.
     *
     * @param scoreLabel The label indicating a score.
     */
    public void setScoreLabel(JLabel scoreLabel) {
        this.scoreLabel = scoreLabel;
    }

    /**
     * Retrieves the label indicating notes.
     *
     * @return The label indicating notes.
     */
    public JLabel getNotesLabel() {
        return notesLabel;
    }

    /**
     * Sets the label indicating notes.
     *
     * @param notesLabel The label indicating notes.
     */
    public void setNotesLabel(JLabel notesLabel) {
        this.notesLabel = notesLabel;
    }

    /**
     * Retrieves the text field for entering wind notes.
     *
     * @return The text field for entering wind notes.
     */
    public JTextField getWindNoteField() {
        return windNoteField;
    }

    /**
     * Sets the text field for entering wind notes.
     *
     * @param windNoteField The text field for entering wind notes.
     */
    public void setWindNoteField(JTextField windNoteField) {
        this.windNoteField = windNoteField;
    }

    /**
     * Retrieves the text field for entering humidity notes.
     *
     * @return The text field for entering humidity notes.
     */
    public JTextField getHumidityNoteField() {
        return humidityNoteField;
    }

    /**
     * Sets the text field for entering humidity notes.
     *
     * @param humidityNoteField The text field for entering humidity notes.
     */
    public void setHumidityNoteField(JTextField humidityNoteField) {
        this.humidityNoteField = humidityNoteField;
    }

    /**
     * Retrieves the text field for entering pressure notes.
     *
     * @return The text field for entering pressure notes.
     */
    public JTextField getPressureNoteField() {
        return pressureNoteField;
    }

    /**
     * Sets the text field for entering pressure notes.
     *
     * @param pressureNoteField The text field for entering pressure notes.
     */
    public void setPressureNoteField(JTextField pressureNoteField) {
        this.pressureNoteField = pressureNoteField;
    }

    /**
     * Retrieves the text field for entering temperature notes.
     *
     * @return The text field for entering temperature notes.
     */
    public JTextField getTemperatureNoteField() {
        return temperatureNoteField;
    }

    /**
     * Sets the text field for entering temperature notes.
     *
     * @param temperatureNoteField The text field for entering temperature notes.
     */
    public void setTemperatureNoteField(JTextField temperatureNoteField) {
        this.temperatureNoteField = temperatureNoteField;
    }

    /**
     * Retrieves the text field for entering precipitation notes.
     *
     * @return The text field for entering precipitation notes.
     */
    public JTextField getPrecipitationNoteField() {
        return precipitationNoteField;
    }

    /**
     * Sets the text field for entering precipitation notes.
     *
     * @param precipitationNoteField The text field for entering precipitation notes.
     */
    public void setPrecipitationNoteField(JTextField precipitationNoteField) {
        this.precipitationNoteField = precipitationNoteField;
    }

    /**
     * Retrieves the text field for entering glacial altitude notes.
     *
     * @return The text field for entering glacial altitude notes.
     */
    public JTextField getGlacial_altitudeNoteField() {
        return glacial_altitudeNoteField;
    }

    /**
     * Sets the text field for entering glacial altitude notes.
     *
     * @param glacial_altitudeNoteField The text field for entering glacial altitude notes.
     */
    public void setGlacial_altitudeNoteField(JTextField glacial_altitudeNoteField) {
        this.glacial_altitudeNoteField = glacial_altitudeNoteField;
    }

    /**
     * Retrieves the text field for entering glacial mass notes.
     *
     * @return The text field for entering glacial mass notes.
     */
    public JTextField getGlacial_massNoteField() {
        return glacial_massNoteField;
    }

    /**
     * Sets the text field for entering glacial mass notes.
     *
     * @param glacial_massNoteField The text field for entering glacial mass notes.
     */
    public void setGlacial_massNoteField(JTextField glacial_massNoteField) {
        this.glacial_massNoteField = glacial_massNoteField;
    }

    /**
     * Retrieves the label for explaining wind data.
     *
     * @return The label for explaining wind data.
     */
    public JLabel getWindExplanationLabel() {
        return windExplanationLabel;
    }

    /**
     * Sets the label for explaining wind data.
     *
     * @param windExplanationLabel The label for explaining wind data.
     */
    public void setWindExplanationLabel(JLabel windExplanationLabel) {
        this.windExplanationLabel = windExplanationLabel;
    }

    /**
     * Retrieves the label for explaining humidity data.
     *
     * @return The label for explaining humidity data.
     */
    public JLabel getHumidityExplanationLabel() {
        return humidityExplanationLabel;
    }

    /**
     * Sets the label for explaining humidity data.
     *
     * @param humidityExplanationLabel The label for explaining humidity data.
     */
    public void setHumidityExplanationLabel(JLabel humidityExplanationLabel) {
        this.humidityExplanationLabel = humidityExplanationLabel;
    }

    /**
     * Retrieves the label for explaining pressure data.
     *
     * @return The label for explaining pressure data.
     */
    public JLabel getPressureExplanationLabel() {
        return pressureExplanationLabel;
    }

    /**
     * Sets the label for explaining pressure data.
     *
     * @param pressureExplanationLabel The label for explaining pressure data.
     */
    public void setPressureExplanationLabel(JLabel pressureExplanationLabel) {
        this.pressureExplanationLabel = pressureExplanationLabel;
    }

    /**
     * Retrieves the label for explaining temperature data.
     *
     * @return The label for explaining temperature data.
     */
    public JLabel getTemperatureExplanationLabel() {
        return temperatureExplanationLabel;
    }

    /**
     * Sets the label for explaining temperature data.
     *
     * @param temperatureExplanationLabel The label for explaining temperature data.
     */
    public void setTemperatureExplanationLabel(JLabel temperatureExplanationLabel) {
        this.temperatureExplanationLabel = temperatureExplanationLabel;
    }

    /**
     * Retrieves the label for explaining precipitation data.
     *
     * @return The label for explaining precipitation data.
     */
    public JLabel getPrecipitationExplanationLabel() {
        return precipitationExplanationLabel;
    }

    /**
     * Sets the label for explaining precipitation data.
     *
     * @param precipitationExplanationLabel The label for explaining precipitation data.
     */
    public void setPrecipitationExplanationLabel(JLabel precipitationExplanationLabel) {
        this.precipitationExplanationLabel = precipitationExplanationLabel;
    }

    /**
     * Retrieves the label for explaining glacial altitude data.
     *
     * @return The label for explaining glacial altitude data.
     */
    public JLabel getGlacial_altitudeExplanationLabel() {
        return glacial_altitudeExplanationLabel;
    }

    /**
     * Sets the label for explaining glacial altitude data.
     *
     * @param glacial_altitudeExplanationLabel The label for explaining glacial altitude data.
     */
    public void setGlacial_altitudeExplanationLabel(JLabel glacial_altitudeExplanationLabel) {
        this.glacial_altitudeExplanationLabel = glacial_altitudeExplanationLabel;
    }

    /**
     * Retrieves the label for explaining glacial mass data.
     *
     * @return The label for explaining glacial mass data.
     */
    public JLabel getGlacial_massExplanationLabel() {
        return glacial_massExplanationLabel;
    }

    /**
     * Sets the label for explaining glacial mass data.
     *
     * @param glacial_massExplanationLabel The label for explaining glacial mass data.
     */
    public void setGlacial_massExplanationLabel(JLabel glacial_massExplanationLabel) {
        this.glacial_massExplanationLabel = glacial_massExplanationLabel;
    }

    /**
     * Retrieves the panel for selecting points of interest (POI).
     *
     * @return The panel for selecting points of interest (POI).
     */
    public JPanel getPoiSelectionPanel() {
        return poiSelectionPanel;
    }

    /**
     * Sets the panel for selecting points of interest (POI).
     *
     * @param poiSelectionPanel The panel for selecting points of interest (POI).
     */
    public void setPoiSelectionPanel(JPanel poiSelectionPanel) {
        this.poiSelectionPanel = poiSelectionPanel;
    }

    /**
     * Retrieves the table for selecting points of interest (POI).
     *
     * @return The table for selecting points of interest (POI).
     */
    public JTable getPoiSelectionTable() {
        return poiSelectionTable;
    }

    /**
     * Sets the table for selecting points of interest (POI).
     *
     * @param poiSelectionTable The table for selecting points of interest (POI).
     */
    public void setPoiSelectionTable(JTable poiSelectionTable) {
        this.poiSelectionTable = poiSelectionTable;
    }

    /**
     * Retrieves the scroll pane for selecting points of interest (POI).
     *
     * @return The scroll pane for selecting points of interest (POI).
     */
    public JScrollPane getPoiSelectionScroll() {
        return poiSelectionScroll;
    }

    /**
     * Sets the scroll pane for selecting points of interest (POI).
     *
     * @param poiSelectionScroll The scroll pane for selecting points of interest (POI).
     */
    public void setPoiSelectionScroll(JScrollPane poiSelectionScroll) {
        this.poiSelectionScroll = poiSelectionScroll;
    }

    /**
     * Retrieves the button for adding a survey.
     *
     * @return The button for adding a survey.
     */
    public JButton getAddSurveyButton() {
        return addSurveyButton;
    }

    /**
     * Sets the button for adding a survey.
     *
     * @param addSurveyButton The button for adding a survey.
     */
    public void setAddSurveyButton(JButton addSurveyButton) {
        this.addSurveyButton = addSurveyButton;
    }

    /**
     * Retrieves the button for adding a point of interest (POI) to the center.
     *
     * @return The button for adding a point of interest (POI) to the center.
     */
    public JButton getAddPoiToCenterButton() {
        return addPoiToCenterButton;
    }

    /**
     * Sets the button for adding a point of interest (POI) to the center.
     *
     * @param addPoiToCenterButton The button for adding a point of interest (POI) to the center.
     */
    public void setAddPoiToCenterButton(JButton addPoiToCenterButton) {
        this.addPoiToCenterButton = addPoiToCenterButton;
    }

    /**
     * Retrieves the text field for entering the name of a point of interest (POI).
     *
     * @return The text field for entering the name of a point of interest (POI).
     */
    public JTextField getNamePoiField() {
        return namePoiField;
    }

    /**
     * Sets the text field for entering the name of a point of interest (POI).
     *
     * @param namePoiField The text field for entering the name of a point of interest (POI).
     */
    public void setNamePoiField(JTextField namePoiField) {
        this.namePoiField = namePoiField;
    }

    /**
     * Retrieves the text field for entering the country of a point of interest (POI).
     *
     * @return The text field for entering the country of a point of interest (POI).
     */
    public JTextField getCountryPoiField() {
        return countryPoiField;
    }

    /**
     * Sets the text field for entering the country of a point of interest (POI).
     *
     * @param countryPoiField The text field for entering the country of a point of interest (POI).
     */
    public void setCountryPoiField(JTextField countryPoiField) {
        this.countryPoiField = countryPoiField;
    }

    /**
     * Retrieves the text field for entering the latitude of a point of interest (POI).
     *
     * @return The text field for entering the latitude of a point of interest (POI).
     */
    public JTextField getAddLatitudeField() {
        return addLatitudeField;
    }

    /**
     * Sets the text field for entering the latitude of a point of interest (POI).
     *
     * @param addLatitudeField The text field for entering the latitude of a point of interest (POI).
     */
    public void setAddLatitudeField(JTextField addLatitudeField) {
        this.addLatitudeField = addLatitudeField;
    }

    /**
     * Retrieves the text field for entering the longitude of a point of interest (POI).
     *
     * @return The text field for entering the longitude of a point of interest (POI).
     */
    public JTextField getAddLongitudeField() {
        return addLongitudeField;
    }

    /**
     * Sets the text field for entering the longitude of a point of interest (POI).
     *
     * @param addLongitudeField The text field for entering the longitude of a point of interest (POI).
     */
    public void setAddLongitudeField(JTextField addLongitudeField) {
        this.addLongitudeField = addLongitudeField;
    }

    /**
     * Retrieves the label for the name of a point of interest (POI).
     *
     * @return The label for the name of a point of interest (POI).
     */
    public JLabel getNamePoiLabel() {
        return namePoiLabel;
    }

    /**
     * Sets the label for the name of a point of interest (POI).
     *
     * @param namePoiLabel The label for the name of a point of interest (POI).
     */
    public void setNamePoiLabel(JLabel namePoiLabel) {
        this.namePoiLabel = namePoiLabel;
    }

    /**
     * Retrieves the label for the country of a point of interest (POI).
     *
     * @return The label for the country of a point of interest (POI).
     */
    public JLabel getCountryPoiLabel() {
        return countryPoiLabel;
    }

    /**
     * Sets the label for displaying the country associated with a point of interest (POI).
     *
     * @param countryPoiLabel The label for displaying the country associated with a POI.
     */
    public void setCountryPoiLabel(JLabel countryPoiLabel) {
        this.countryPoiLabel = countryPoiLabel;
    }

    /**
     * Retrieves the label for displaying the latitude of a point of interest (POI) to be added.
     *
     * @return The label for displaying the latitude of a POI to be added.
     */
    public JLabel getAddLatitudeLabel() {
        return addLatitudeLabel;
    }

    /**
     * Sets the label for displaying the latitude of a point of interest (POI) to be added.
     *
     * @param addLatitudeLabel The label for displaying the latitude of a POI to be added.
     */
    public void setAddLatitudeLabel(JLabel addLatitudeLabel) {
        this.addLatitudeLabel = addLatitudeLabel;
    }

    /**
     * Retrieves the label for displaying the longitude of a point of interest (POI) to be added.
     *
     * @return The label for displaying the longitude of a POI to be added.
     */
    public JLabel getAddLongitudeLabel() {
        return addLongitudeLabel;
    }

    /**
     * Sets the label for displaying the longitude of a point of interest (POI) to be added.
     *
     * @param addLongitudeLabel The label for displaying the longitude of a POI to be added.
     */
    public void setAddLongitudeLabel(JLabel addLongitudeLabel) {
        this.addLongitudeLabel = addLongitudeLabel;
    }

    /**
     * Retrieves the panel for adding a new point of interest (POI).
     *
     * @return The panel for adding a new POI.
     */
    public JPanel getAddPoiPanel() {
        return addPoiPanel;
    }

    /**
     * Sets the panel for adding a new point of interest (POI).
     *
     * @param addPoiPanel The panel for adding a new POI.
     */
    public void setAddPoiPanel(JPanel addPoiPanel) {
        this.addPoiPanel = addPoiPanel;
    }

    /**
     * Retrieves the button for selecting a point of interest (POI).
     *
     * @return The button for selecting a POI.
     */
    public JButton getSelectPoiButton() {
        return selectPoiButton;
    }

    /**
     * Sets the button for selecting a point of interest (POI).
     *
     * @param selectPoiButton The button for selecting a POI.
     */
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
