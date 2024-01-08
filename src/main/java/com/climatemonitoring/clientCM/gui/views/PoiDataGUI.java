package com.climatemonitoring.clientCM.gui.views;

import com.climatemonitoring.clientCM.gui.controllers.PoiDataGUIController;
import com.climatemonitoring.shared.models.SurveysAggregate;
import com.climatemonitoring.shared.models.PointOfInterest;
import com.climatemonitoring.shared.models.User;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.ArrayList;
import java.util.Locale;

/**
 * This class represents the GUI view where the aggregate data for a Point Of Interest (POI) is displayed.
 * It extends the <code>JFrame</code> class and is associated with the <code>PoiDataGUIController</code> for handling user interactions.
 * The GUI displays information related to <code>SurveysAggregate</code> for a specific PointOfInterest.
 *
 * @author Lorenzo Cattapan 726459 (Varese)
 * @version 0.9.0
 * @see PoiDataGUIController
 */
public class PoiDataGUI extends JFrame {

    //*****************FIELDS*****************//

    /**
     * The main panel that holds the entire Point Of Interest (POI) data.
     */
    private JPanel poiDataPanel;
    /**
     * A label displaying the title or branding for the Climate Monitoring application.
     */
    private JLabel climatemonitoringLabel;
    /**
     * A label displaying information related to the Point Of Interest (POI).
     */
    private JLabel poi_infoLabel;
    /**
     * The panel containing the search results for the POI.
     */
    private JPanel searchResultPanel;
    /**
     * The scroll pane for the search result table.
     */
    private JScrollPane searchResultScroll;
    /**
     * The table displaying search results related to the POI.
     */
    private JTable searchResultTable;
    /**
     * A label displaying the count of search results.
     */
    private JLabel countLabel;
    /**
     * A label displaying the number of climate monitoring centers related to the POI.
     */
    private JLabel centersNumberLabel;
    /**
     * A label displaying the timestamp of the oldest survey related to the POI.
     */
    private JLabel oldestSurveyLabel;
    /**
     * A label displaying the timestamp of the most recent survey related to the POI.
     */
    private JLabel recentSurveyLabel;
    /**
     * The main panel containing general data related to the POI.
     */
    private JPanel generalDataPanel;
    /**
     * The main panel containing various data panels related to the POI.
     */
    private JPanel dataPanel;
    /**
     * The panel containing wind-related data.
     */
    private JPanel windDataPanel;
    /**
     * A label displaying the average wind score.
     */
    private JLabel windAvgLabel;
    /**
     * A label displaying the maximum wind score.
     */
    private JLabel windMaxLabel;
    /**
     * A label displaying the minimum wind score.
     */
    private JLabel windMinLabel;
    /**
     * The panel containing humidity-related data.
     */
    private JPanel humidityDataPanel;
    /**
     * A label displaying the average humidity.
     */
    private JLabel humidityAvgLabel;
    /**
     * A label displaying the maximum humidity.
     */
    private JLabel humidityMaxLabel;
    /**
     * A label displaying the minimum humidity.
     */
    private JLabel humidityMinLabel;
    /**
     * The panel containing pressure-related data.
     */
    private JPanel pressureDataLabel;
    /**
     * A label displaying the average atmospheric pressure score.
     */
    private JLabel pressureAvgLabel;
    /**
     * A label displaying the maximum atmospheric pressure.
     */
    private JLabel pressureMaxLabel;
    /**
     * A label displaying the minimum atmospheric pressure.
     */
    private JLabel pressureMinLabel;
    /**
     * The panel containing temperature-related data.
     */
    private JPanel temperatureDataLabel;
    /**
     * A label displaying the average temperature.
     */
    private JLabel temperatureAvgLabel;
    /**
     * A label displaying the maximum temperature.
     */
    private JLabel temperatureMaxLabel;
    /**
     * A label displaying the minimum temperature.
     */
    private JLabel temperatureMinLabel;
    /**
     * The panel containing precipitation-related data.
     */
    private JPanel precipitationDataLabel;
    /**
     * A label displaying the average precipitation.
     */
    private JLabel precipitationAvgLabel;
    /**
     * A label displaying the maximum precipitation.
     */
    private JLabel precipitationMaxLabel;
    /**
     * A label displaying the minimum precipitation.
     */
    private JLabel precipitationMinLabel;
    /**
     * The panel containing glacial altitude-related data.
     */
    private JPanel glacial_altitudeDataPanel;
    /**
     * The panel containing glacial mass-related data.
     */
    private JPanel glacial_massDataPanel;
    /**
     * A label displaying the maximum glacial altitude.
     */
    private JLabel glacial_altitudeMaxLabel;
    /**
     * A label displaying the minimum glacial altitude.
     */
    private JLabel glacial_altitudeMinLabel;
    /**
     * A label displaying the average glacial altitude.
     */
    private JLabel glacial_altitudeAvgLabel;
    /**
     * A label displaying the average glacial mass.
     */
    private JLabel glacial_massAvgLabel;
    /**
     * A label displaying the maximum glacial mass.
     */
    private JLabel glacial_massMaxLabel;
    /**
     * A label displaying the minimum glacial mass.
     */
    private JLabel glacial_massMinLabel;
    /**
     * Button to add a comment on wind-related data.
     */
    private JButton windCommentButton;
    /**
     * Button to add a comment on humidity-related data.
     */
    private JButton humidityCommentButton;
    /**
     * Button to add a comment on pressure-related data.
     */
    private JButton pressureCommentButton;
    /**
     * Button to add a comment on temperature-related data.
     */
    private JButton temperatureCommentButton;
    /**
     * Button to add a comment on precipitation-related data.
     */
    private JButton precipitationCommentButton;
    /**
     * Button to add a comment on glacial altitude-related data.
     */
    private JButton glacial_altitudeCommentButton;
    /**
     * Button to add a comment on glacial mass-related data.
     */
    private JButton glacial_massCommentButton;
    /**
     * Button to navigate back to the previous view or screen.
     */
    private JButton backButton;
    /**
     * The panel containing buttons for adding comments on various data.
     */
    private JPanel commentButtonsPanel;

    //*****************CONSTRUCTORS*****************//

    /**
     * Constructor for PoiDataGUI.
     *
     * @param surveysAggregate The SurveysAggregate object containing aggregate data for the Point Of Interest (POI).
     * @param searchResults An ArrayList of PointOfInterest used when going back to previous views.
     */
    public PoiDataGUI(SurveysAggregate surveysAggregate, ArrayList<PointOfInterest> searchResults) {
        setTitle("Climate Monitoring");
        setContentPane(poiDataPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setMinimumSize(new Dimension(1000, 650));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        new PoiDataGUIController(this, surveysAggregate, searchResults, null);
    }

    /**
     * Constructor for PoiDataGUI for a logged in user(Operator).
     *
     * @param surveysAggregate The SurveysAggregate object containing aggregate data for the Point Of Interest (POI).
     * @param searchResults An ArrayList of PointOfInterest used when going back to previous views.
     * @param user The User object representing the current user.
     */
    public PoiDataGUI(SurveysAggregate surveysAggregate, ArrayList<PointOfInterest> searchResults, User user) {
        setTitle("Climate Monitoring");
        setContentPane(poiDataPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1024);// To set fixed dimensions
        new PoiDataGUIController(this, surveysAggregate, searchResults, user);
    }

    /**
     * Constructor for PoiDataGUI with a user and no search results.
     *
     * <p>
     * Note: not used in the application.
     * </p>
     *
     * @param surveysAggregate The SurveysAggregate object containing aggregate data for the Point Of Interest (POI).
     * @param user The User object representing the current user.
     */
    public PoiDataGUI(SurveysAggregate surveysAggregate, User user) {
        setTitle("Climate Monitoring");
        setContentPane(poiDataPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1024);// To set fixed dimensions
        new PoiDataGUIController(this, surveysAggregate, null, user);
    }

    //*****************GETTER AND SETTER*****************//

    /**
     * Gets the main panel containing Point Of Interest (POI) data.
     *
     * @return The JPanel representing the POI data panel.
     */
    public JPanel getPoiDataPanel() {
        return poiDataPanel;
    }

    /**
     * Sets the main panel containing Point Of Interest (POI) data.
     *
     * @param poiDataPanel The JPanel representing the POI data panel to be set.
     */
    public void setPoiDataPanel(JPanel poiDataPanel) {
        this.poiDataPanel = poiDataPanel;
    }

    /**
     * Gets the label displaying the title or branding for the Climate Monitoring application.
     *
     * @return The JLabel representing the branding label.
     */
    public JLabel getClimatemonitoringLabel() {
        return climatemonitoringLabel;
    }

    /**
     * Sets the label displaying the title or branding for the Climate Monitoring application.
     *
     * @param climatemonitoringLabel The JLabel representing the branding label to be set.
     */
    public void setClimatemonitoringLabel(JLabel climatemonitoringLabel) {
        this.climatemonitoringLabel = climatemonitoringLabel;
    }

    /**
     * Gets the label displaying information related to the Point Of Interest (POI).
     *
     * @return The JLabel representing the information label for the POI.
     */
    public JLabel getPoi_infoLabel() {
        return poi_infoLabel;
    }

    /**
     * Sets the label displaying information related to the Point Of Interest (POI).
     *
     * @param poi_infoLabel The JLabel representing the information label for the POI to be set.
     */
    public void setPoi_infoLabel(JLabel poi_infoLabel) {
        this.poi_infoLabel = poi_infoLabel;
    }

    /**
     * Gets the panel containing search results for the Point Of Interest (POI).
     *
     * @return The JPanel representing the search result panel.
     */
    public JPanel getSearchResultPanel() {
        return searchResultPanel;
    }

    /**
     * Sets the panel containing search results for the Point Of Interest (POI).
     *
     * @param searchResultPanel The JPanel representing the search result panel to be set.
     */
    public void setSearchResultPanel(JPanel searchResultPanel) {
        this.searchResultPanel = searchResultPanel;
    }

    /**
     * Gets the scroll pane for the search result table.
     *
     * @return The JScrollPane representing the search result scroll pane.
     */
    public JScrollPane getSearchResultScroll() {
        return searchResultScroll;
    }

    /**
     * Sets the scroll pane for the search result table.
     *
     * @param searchResultScroll The JScrollPane representing the search result scroll pane to be set.
     */
    public void setSearchResultScroll(JScrollPane searchResultScroll) {
        this.searchResultScroll = searchResultScroll;
    }

    /**
     * Gets the table displaying search results for the Point Of Interest (POI).
     *
     * @return The JTable representing the search result table.
     */
    public JTable getSearchResultTable() {
        return searchResultTable;
    }

    /**
     * Sets the table displaying search results for the Point Of Interest (POI).
     *
     * @param searchResultTable The JTable representing the search result table to be set.
     */
    public void setSearchResultTable(JTable searchResultTable) {
        this.searchResultTable = searchResultTable;
    }

    /**
     * Gets the label displaying the count of search results.
     *
     * @return The JLabel representing the count label.
     */
    public JLabel getCountLabel() {
        return countLabel;
    }

    /**
     * Sets the label displaying the count of search results.
     *
     * @param countLabel The JLabel representing the count label to be set.
     */
    public void setCountLabel(JLabel countLabel) {
        this.countLabel = countLabel;
    }

    /**
     * Gets the label displaying the number of climate monitoring centers related to the POI.
     *
     * @return The JLabel representing the centers number label.
     */
    public JLabel getCentersNumberLabel() {
        return centersNumberLabel;
    }

    /**
     * Sets the label displaying the number of climate monitoring centers related to the POI.
     *
     * @param centersNumberLabel The JLabel representing the centers number label to be set.
     */
    public void setCentersNumberLabel(JLabel centersNumberLabel) {
        this.centersNumberLabel = centersNumberLabel;
    }

    /**
     * Gets the label displaying the timestamp of the oldest survey related to the POI.
     *
     * @return The JLabel representing the oldest survey timestamp label.
     */
    public JLabel getOldestSurveyLabel() {
        return oldestSurveyLabel;
    }

    /**
     * Sets the label displaying the timestamp of the oldest survey related to the POI.
     *
     * @param oldestSurveyLabel The JLabel representing the oldest survey timestamp label to be set.
     */
    public void setOldestSurveyLabel(JLabel oldestSurveyLabel) {
        this.oldestSurveyLabel = oldestSurveyLabel;
    }

    /**
     * Gets the label displaying the timestamp of the most recent survey related to the POI.
     *
     * @return The JLabel representing the recent survey timestamp label.
     */
    public JLabel getRecentSurveyLabel() {
        return recentSurveyLabel;
    }

    /**
     * Sets the label displaying the timestamp of the most recent survey related to the POI.
     *
     * @param recentSurveyLabel The JLabel representing the recent survey timestamp label to be set.
     */
    public void setRecentSurveyLabel(JLabel recentSurveyLabel) {
        this.recentSurveyLabel = recentSurveyLabel;
    }

    /**
     * Gets the main panel containing general data related to the POI.
     *
     * @return The JPanel representing the general data panel.
     */
    public JPanel getGeneralDataPanel() {
        return generalDataPanel;
    }

    /**
     * Sets the main panel containing general data related to the POI.
     *
     * @param generalDataPanel The JPanel representing the general data panel to be set.
     */
    public void setGeneralDataPanel(JPanel generalDataPanel) {
        this.generalDataPanel = generalDataPanel;
    }

    /**
     * Gets the main panel containing various data panels related to the POI.
     *
     * @return The JPanel representing the data panel.
     */
    public JPanel getDataPanel() {
        return dataPanel;
    }

    /**
     * Sets the main panel containing various data panels related to the POI.
     *
     * @param dataPanel The JPanel representing the data panel to be set.
     */
    public void setDataPanel(JPanel dataPanel) {
        this.dataPanel = dataPanel;
    }

    /**
     * Gets the panel containing wind-related data.
     *
     * @return The JPanel representing the wind data panel.
     */
    public JPanel getWindDataPanel() {
        return windDataPanel;
    }

    /**
     * Sets the panel containing wind-related data.
     *
     * @param windDataPanel The JPanel representing the wind data panel to be set.
     */
    public void setWindDataPanel(JPanel windDataPanel) {
        this.windDataPanel = windDataPanel;
    }

    /**
     * Gets the label displaying the average wind speed.
     *
     * @return The JLabel representing the wind average label.
     */
    public JLabel getWindAvgLabel() {
        return windAvgLabel;
    }

    /**
     * Sets the label displaying the average wind speed.
     *
     * @param windAvgLabel The JLabel representing the wind average label to be set.
     */
    public void setWindAvgLabel(JLabel windAvgLabel) {
        this.windAvgLabel = windAvgLabel;
    }

    /**
     * Gets the label displaying the maximum wind speed.
     *
     * @return The JLabel representing the wind maximum label.
     */
    public JLabel getWindMaxLabel() {
        return windMaxLabel;
    }

    /**
     * Sets the label displaying the maximum wind speed.
     *
     * @param windMaxLabel The JLabel representing the wind maximum label to be set.
     */
    public void setWindMaxLabel(JLabel windMaxLabel) {
        this.windMaxLabel = windMaxLabel;
    }

    /**
     * Gets the label displaying the minimum wind speed.
     *
     * @return The JLabel representing the wind minimum label.
     */
    public JLabel getWindMinLabel() {
        return windMinLabel;
    }

    /**
     * Sets the label displaying the minimum wind speed.
     *
     * @param windMinLabel The JLabel representing the wind minimum label to be set.
     */
    public void setWindMinLabel(JLabel windMinLabel) {
        this.windMinLabel = windMinLabel;
    }

    /**
     * Gets the panel containing humidity-related data.
     *
     * @return The JPanel representing the humidity data panel.
     */
    public JPanel getHumidityDataPanel() {
        return humidityDataPanel;
    }

    /**
     * Sets the panel containing humidity-related data.
     *
     * @param humidityDataPanel The JPanel representing the humidity data panel to be set.
     */
    public void setHumidityDataPanel(JPanel humidityDataPanel) {
        this.humidityDataPanel = humidityDataPanel;
    }

    /**
     * Gets the label displaying the average humidity.
     *
     * @return The JLabel representing the humidity average label.
     */
    public JLabel getHumidityAvgLabel() {
        return humidityAvgLabel;
    }

    /**
     * Sets the label displaying the average humidity.
     *
     * @param humidityAvgLabel The JLabel representing the humidity average label to be set.
     */
    public void setHumidityAvgLabel(JLabel humidityAvgLabel) {
        this.humidityAvgLabel = humidityAvgLabel;
    }

    /**
     * Gets the label displaying the maximum humidity.
     *
     * @return The JLabel representing the humidity maximum label.
     */
    public JLabel getHumidityMaxLabel() {
        return humidityMaxLabel;
    }

    /**
     * Sets the label displaying the maximum humidity.
     *
     * @param humidityMaxLabel The JLabel representing the humidity maximum label to be set.
     */
    public void setHumidityMaxLabel(JLabel humidityMaxLabel) {
        this.humidityMaxLabel = humidityMaxLabel;
    }

    /**
     * Gets the label displaying the minimum humidity.
     *
     * @return The JLabel representing the humidity minimum label.
     */
    public JLabel getHumidityMinLabel() {
        return humidityMinLabel;
    }

    /**
     * Sets the label displaying the minimum humidity.
     *
     * @param humidityMinLabel The JLabel representing the humidity minimum label to be set.
     */
    public void setHumidityMinLabel(JLabel humidityMinLabel) {
        this.humidityMinLabel = humidityMinLabel;
    }

    /**
     * Gets the panel containing pressure-related data.
     *
     * @return The JPanel representing the pressure data panel.
     */
    public JPanel getPressureDataLabel() {
        return pressureDataLabel;
    }

    /**
     * Sets the panel containing pressure-related data.
     *
     * @param pressureDataLabel The JPanel representing the pressure data panel to be set.
     */
    public void setPressureDataLabel(JPanel pressureDataLabel) {
        this.pressureDataLabel = pressureDataLabel;
    }

    /**
     * Gets the label displaying the average pressure.
     *
     * @return The JLabel representing the pressure average label.
     */
    public JLabel getPressureAvgLabel() {
        return pressureAvgLabel;
    }

    /**
     * Sets the label displaying the average pressure.
     *
     * @param pressureAvgLabel The JLabel representing the pressure average label to be set.
     */
    public void setPressureAvgLabel(JLabel pressureAvgLabel) {
        this.pressureAvgLabel = pressureAvgLabel;
    }

    /**
     * Gets the label displaying the maximum pressure.
     *
     * @return The JLabel representing the pressure maximum label.
     */
    public JLabel getPressureMaxLabel() {
        return pressureMaxLabel;
    }

    /**
     * Sets the label displaying the maximum pressure.
     *
     * @param pressureMaxLabel The JLabel representing the pressure maximum label to be set.
     */
    public void setPressureMaxLabel(JLabel pressureMaxLabel) {
        this.pressureMaxLabel = pressureMaxLabel;
    }

    /**
     * Gets the label displaying the minimum pressure.
     *
     * @return The JLabel representing the pressure minimum label.
     */
    public JLabel getPressureMinLabel() {
        return pressureMinLabel;
    }

    /**
     * Sets the label displaying the minimum pressure.
     *
     * @param pressureMinLabel The JLabel representing the pressure minimum label to be set.
     */
    public void setPressureMinLabel(JLabel pressureMinLabel) {
        this.pressureMinLabel = pressureMinLabel;
    }

    /**
     * Gets the panel containing temperature-related data.
     *
     * @return The JPanel representing the temperature data panel.
     */
    public JPanel getTemperatureDataLabel() {
        return temperatureDataLabel;
    }

    /**
     * Sets the panel containing temperature-related data.
     *
     * @param temperatureDataLabel The JPanel representing the temperature data panel to be set.
     */
    public void setTemperatureDataLabel(JPanel temperatureDataLabel) {
        this.temperatureDataLabel = temperatureDataLabel;
    }

    /**
     * Gets the label displaying the average temperature.
     *
     * @return The JLabel representing the temperature average label.
     */
    public JLabel getTemperatureAvgLabel() {
        return temperatureAvgLabel;
    }

    /**
     * Sets the label displaying the average temperature.
     *
     * @param temperatureAvgLabel The JLabel representing the temperature average label to be set.
     */
    public void setTemperatureAvgLabel(JLabel temperatureAvgLabel) {
        this.temperatureAvgLabel = temperatureAvgLabel;
    }

    /**
     * Gets the label displaying the maximum temperature.
     *
     * @return The JLabel representing the temperature maximum label.
     */
    public JLabel getTemperatureMaxLabel() {
        return temperatureMaxLabel;
    }

    /**
     * Sets the label displaying the maximum temperature.
     *
     * @param temperatureMaxLabel The JLabel representing the temperature maximum label to be set.
     */
    public void setTemperatureMaxLabel(JLabel temperatureMaxLabel) {
        this.temperatureMaxLabel = temperatureMaxLabel;
    }

    /**
     * Gets the label displaying the minimum temperature.
     *
     * @return The JLabel representing the temperature minimum label.
     */
    public JLabel getTemperatureMinLabel() {
        return temperatureMinLabel;
    }

    /**
     * Sets the label displaying the minimum temperature.
     *
     * @param temperatureMinLabel The JLabel representing the temperature minimum label to be set.
     */
    public void setTemperatureMinLabel(JLabel temperatureMinLabel) {
        this.temperatureMinLabel = temperatureMinLabel;
    }

    /**
     * Gets the panel containing precipitation-related data.
     *
     * @return The JPanel representing the precipitation data panel.
     */
    public JPanel getPrecipitationDataLabel() {
        return precipitationDataLabel;
    }

    /**
     * Sets the panel containing precipitation-related data.
     *
     * @param precipitationDataLabel The JPanel representing the precipitation data panel to be set.
     */
    public void setPrecipitationDataLabel(JPanel precipitationDataLabel) {
        this.precipitationDataLabel = precipitationDataLabel;
    }

    /**
     * Gets the label displaying the average precipitation.
     *
     * @return The JLabel representing the precipitation average label.
     */
    public JLabel getPrecipitationAvgLabel() {
        return precipitationAvgLabel;
    }

    /**
     * Sets the label displaying the average precipitation.
     *
     * @param precipitationAvgLabel The JLabel representing the precipitation average label to be set.
     */
    public void setPrecipitationAvgLabel(JLabel precipitationAvgLabel) {
        this.precipitationAvgLabel = precipitationAvgLabel;
    }

    /**
     * Gets the label displaying the maximum precipitation.
     *
     * @return The JLabel representing the precipitation maximum label.
     */
    public JLabel getPrecipitationMaxLabel() {
        return precipitationMaxLabel;
    }

    /**
     * Sets the label displaying the maximum precipitation.
     *
     * @param precipitationMaxLabel The JLabel representing the precipitation maximum label to be set.
     */
    public void setPrecipitationMaxLabel(JLabel precipitationMaxLabel) {
        this.precipitationMaxLabel = precipitationMaxLabel;
    }

    /**
     * Gets the label displaying the minimum precipitation.
     *
     * @return The JLabel representing the precipitation minimum label.
     */
    public JLabel getPrecipitationMinLabel() {
        return precipitationMinLabel;
    }

    /**
     * Sets the label displaying the minimum precipitation.
     *
     * @param precipitationMinLabel The JLabel representing the precipitation minimum label to be set.
     */
    public void setPrecipitationMinLabel(JLabel precipitationMinLabel) {
        this.precipitationMinLabel = precipitationMinLabel;
    }

    /**
     * Gets the panel containing glacial altitude-related data.
     *
     * @return The JPanel representing the glacial altitude data panel.
     */
    public JPanel getGlacial_altitudeDataPanel() {
        return glacial_altitudeDataPanel;
    }

    /**
     * Sets the panel containing glacial altitude-related data.
     *
     * @param glacial_altitudeDataPanel The JPanel representing the glacial altitude data panel to be set.
     */
    public void setGlacial_altitudeDataPanel(JPanel glacial_altitudeDataPanel) {
        this.glacial_altitudeDataPanel = glacial_altitudeDataPanel;
    }

    /**
     * Gets the panel containing glacial mass-related data.
     *
     * @return The JPanel representing the glacial mass data panel.
     */
    public JPanel getGlacial_massDataPanel() {
        return glacial_massDataPanel;
    }

    /**
     * Sets the panel containing glacial mass-related data.
     *
     * @param glacial_massDataPanel The JPanel representing the glacial mass data panel to be set.
     */
    public void setGlacial_massDataPanel(JPanel glacial_massDataPanel) {
        this.glacial_massDataPanel = glacial_massDataPanel;
    }

    /**
     * Gets the label displaying the maximum glacial altitude.
     *
     * @return The JLabel representing the glacial altitude maximum label.
     */
    public JLabel getGlacial_altitudeMaxLabel() {
        return glacial_altitudeMaxLabel;
    }

    /**
     * Sets the label displaying the maximum glacial altitude.
     *
     * @param glacial_altitudeMaxLabel The JLabel representing the glacial altitude maximum label to be set.
     */
    public void setGlacial_altitudeMaxLabel(JLabel glacial_altitudeMaxLabel) {
        this.glacial_altitudeMaxLabel = glacial_altitudeMaxLabel;
    }

    /**
     * Gets the label displaying the minimum glacial altitude.
     *
     * @return The JLabel representing the glacial altitude minimum label.
     */
    public JLabel getGlacial_altitudeMinLabel() {
        return glacial_altitudeMinLabel;
    }

    /**
     * Sets the label displaying the minimum glacial altitude.
     *
     * @param glacial_altitudeMinLabel The JLabel representing the glacial altitude minimum label to be set.
     */
    public void setGlacial_altitudeMinLabel(JLabel glacial_altitudeMinLabel) {
        this.glacial_altitudeMinLabel = glacial_altitudeMinLabel;
    }

    /**
     * Gets the label displaying the average glacial altitude.
     *
     * @return The JLabel representing the glacial altitude average label.
     */
    public JLabel getGlacial_altitudeAvgLabel() {
        return glacial_altitudeAvgLabel;
    }

    /**
     * Sets the label displaying the average glacial altitude.
     *
     * @param glacial_altitudeAvgLabel The JLabel representing the glacial altitude average label to be set.
     */
    public void setGlacial_altitudeAvgLabel(JLabel glacial_altitudeAvgLabel) {
        this.glacial_altitudeAvgLabel = glacial_altitudeAvgLabel;
    }

    /**
     * Gets the label displaying the average glacial mass.
     *
     * @return The JLabel representing the glacial mass average label.
     */
    public JLabel getGlacial_massAvgLabel() {
        return glacial_massAvgLabel;
    }

    /**
     * Sets the label displaying the average glacial mass.
     *
     * @param glacial_massAvgLabel The JLabel representing the glacial mass average label to be set.
     */
    public void setGlacial_massAvgLabel(JLabel glacial_massAvgLabel) {
        this.glacial_massAvgLabel = glacial_massAvgLabel;
    }

    /**
     * Gets the label displaying the maximum glacial mass.
     *
     * @return The JLabel representing the glacial mass maximum label.
     */
    public JLabel getGlacial_massMaxLabel() {
        return glacial_massMaxLabel;
    }

    /**
     * Sets the label displaying the maximum glacial mass.
     *
     * @param glacial_massMaxLabel The JLabel representing the glacial mass maximum label to be set.
     */
    public void setGlacial_massMaxLabel(JLabel glacial_massMaxLabel) {
        this.glacial_massMaxLabel = glacial_massMaxLabel;
    }

    /**
     * Gets the label displaying the minimum glacial mass.
     *
     * @return The JLabel representing the glacial mass minimum label.
     */
    public JLabel getGlacial_massMinLabel() {
        return glacial_massMinLabel;
    }

    /**
     * Sets the label displaying the minimum glacial mass.
     *
     * @param glacial_massMinLabel The JLabel representing the glacial mass minimum label to be set.
     */
    public void setGlacial_massMinLabel(JLabel glacial_massMinLabel) {
        this.glacial_massMinLabel = glacial_massMinLabel;
    }

    /**
     * Gets the button to view comments on wind-related data.
     *
     * @return The JButton representing the wind comment button.
     */
    public JButton getWindCommentButton() {
        return windCommentButton;
    }

    /**
     * Sets the button to view comments on wind-related data.
     *
     * @param windCommentButton The JButton representing the wind comment button to be set.
     */
    public void setWindCommentButton(JButton windCommentButton) {
        this.windCommentButton = windCommentButton;
    }

    /**
     * Gets the button to view comments on humidity-related data.
     *
     * @return The JButton representing the humidity comment button.
     */
    public JButton getHumidityCommentButton() {
        return humidityCommentButton;
    }

    /**
     * Sets the button to view comments on humidity-related data.
     *
     * @param humidityCommentButton The JButton representing the humidity comment button to be set.
     */
    public void setHumidityCommentButton(JButton humidityCommentButton) {
        this.humidityCommentButton = humidityCommentButton;
    }

    /**
     * Gets the button to view comments on pressure-related data.
     *
     * @return The JButton representing the pressure comment button.
     */
    public JButton getPressureCommentButton() {
        return pressureCommentButton;
    }

    /**
     * Sets the button to view comments on pressure-related data.
     *
     * @param pressureCommentButton The JButton representing the pressure comment button to be set.
     */
    public void setPressureCommentButton(JButton pressureCommentButton) {
        this.pressureCommentButton = pressureCommentButton;
    }

    /**
     * Gets the button to view comments on temperature-related data.
     *
     * @return The JButton representing the temperature comment button.
     */
    public JButton getTemperatureCommentButton() {
        return temperatureCommentButton;
    }

    /**
     * Sets the button to view comments on temperature-related data.
     *
     * @param temperatureCommentButton The JButton representing the temperature comment button to be set.
     */
    public void setTemperatureCommentButton(JButton temperatureCommentButton) {
        this.temperatureCommentButton = temperatureCommentButton;
    }

    /**
     * Gets the button to view comments on precipitation-related data.
     *
     * @return The JButton representing the precipitation comment button.
     */
    public JButton getPrecipitationCommentButton() {
        return precipitationCommentButton;
    }

    /**
     * Sets the button to view comments on precipitation-related data.
     *
     * @param precipitationCommentButton The JButton representing the precipitation comment button to be set.
     */
    public void setPrecipitationCommentButton(JButton precipitationCommentButton) {
        this.precipitationCommentButton = precipitationCommentButton;
    }

    /**
     * Gets the button to view comments on glacial altitude-related data.
     *
     * @return The JButton representing the glacial altitude comment button.
     */
    public JButton getGlacial_altitudeCommentButton() {
        return glacial_altitudeCommentButton;
    }

    /**
     * Sets the button to view comments on glacial altitude-related data.
     *
     * @param glacial_altitudeCommentButton The JButton representing the glacial altitude comment button to be set.
     */
    public void setGlacial_altitudeCommentButton(JButton glacial_altitudeCommentButton) {
        this.glacial_altitudeCommentButton = glacial_altitudeCommentButton;
    }

    /**
     * Gets the button to view comments on glacial mass-related data.
     *
     * @return The JButton representing the glacial mass comment button.
     */
    public JButton getGlacial_massCommentButton() {
        return glacial_massCommentButton;
    }

    /**
     * Sets the button to view comments on glacial mass-related data.
     *
     * @param glacial_massCommentButton The JButton representing the glacial mass comment button to be set.
     */
    public void setGlacial_massCommentButton(JButton glacial_massCommentButton) {
        this.glacial_massCommentButton = glacial_massCommentButton;
    }

    /**
     * Gets the button for navigating back.
     *
     * @return The JButton representing the back button.
     */
    public JButton getBackButton() {
        return backButton;
    }

    /**
     * Sets the button for navigating back.
     *
     * @param backButton The JButton representing the back button to be set.
     */
    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    /**
     * Gets the panel containing various comment-related buttons.
     *
     * @return The JPanel representing the comment buttons panel.
     */
    public JPanel getCommentButtonsPanel() {
        return commentButtonsPanel;
    }

    /**
     * Sets the panel containing various comment-related buttons.
     *
     * @param commentButtonsPanel The JPanel representing the comment buttons panel to be set.
     */
    public void setCommentButtonsPanel(JPanel commentButtonsPanel) {
        this.commentButtonsPanel = commentButtonsPanel;
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
        poiDataPanel = new JPanel();
        poiDataPanel.setLayout(new GridLayoutManager(10, 3, new Insets(0, 0, 0, 0), -1, -1));
        poiDataPanel.setBackground(new Color(-9473675));
        poiDataPanel.setForeground(new Color(-9473675));
        climatemonitoringLabel = new JLabel();
        climatemonitoringLabel.setBackground(new Color(-1));
        Font climatemonitoringLabelFont = this.$$$getFont$$$("JetBrains Mono ExtraBold", Font.BOLD, 72, climatemonitoringLabel.getFont());
        if (climatemonitoringLabelFont != null) climatemonitoringLabel.setFont(climatemonitoringLabelFont);
        climatemonitoringLabel.setForeground(new Color(-1));
        climatemonitoringLabel.setText("Climate Monitoring");
        poiDataPanel.add(climatemonitoringLabel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        poiDataPanel.add(spacer1, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        poi_infoLabel = new JLabel();
        Font poi_infoLabelFont = this.$$$getFont$$$(null, -1, 24, poi_infoLabel.getFont());
        if (poi_infoLabelFont != null) poi_infoLabel.setFont(poi_infoLabelFont);
        poi_infoLabel.setForeground(new Color(-1));
        poi_infoLabel.setText("I dati Aggregati per questa Area Geografica sono :");
        poiDataPanel.add(poi_infoLabel, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        dataPanel = new JPanel();
        dataPanel.setLayout(new GridLayoutManager(9, 3, new Insets(0, 0, 0, 0), -1, -1));
        dataPanel.setBackground(new Color(-9473675));
        dataPanel.setForeground(new Color(-9473675));
        poiDataPanel.add(dataPanel, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        generalDataPanel = new JPanel();
        generalDataPanel.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        generalDataPanel.setBackground(new Color(-9473675));
        generalDataPanel.setForeground(new Color(-9473675));
        dataPanel.add(generalDataPanel, new GridConstraints(0, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        countLabel = new JLabel();
        countLabel.setBackground(new Color(-1));
        Font countLabelFont = this.$$$getFont$$$(null, -1, 16, countLabel.getFont());
        if (countLabelFont != null) countLabel.setFont(countLabelFont);
        countLabel.setForeground(new Color(-1));
        countLabel.setText("Numero Rilevazioni Area : ");
        generalDataPanel.add(countLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        centersNumberLabel = new JLabel();
        centersNumberLabel.setBackground(new Color(-1));
        Font centersNumberLabelFont = this.$$$getFont$$$(null, -1, 16, centersNumberLabel.getFont());
        if (centersNumberLabelFont != null) centersNumberLabel.setFont(centersNumberLabelFont);
        centersNumberLabel.setForeground(new Color(-1));
        centersNumberLabel.setText("Numero Centri con Rilevazioni per quest'area : ");
        generalDataPanel.add(centersNumberLabel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        oldestSurveyLabel = new JLabel();
        oldestSurveyLabel.setBackground(new Color(-1));
        Font oldestSurveyLabelFont = this.$$$getFont$$$(null, -1, 16, oldestSurveyLabel.getFont());
        if (oldestSurveyLabelFont != null) oldestSurveyLabel.setFont(oldestSurveyLabelFont);
        oldestSurveyLabel.setForeground(new Color(-1));
        oldestSurveyLabel.setText("Timestamp della Rilevazione più vecchia : ");
        generalDataPanel.add(oldestSurveyLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        recentSurveyLabel = new JLabel();
        recentSurveyLabel.setBackground(new Color(-1));
        Font recentSurveyLabelFont = this.$$$getFont$$$(null, -1, 16, recentSurveyLabel.getFont());
        if (recentSurveyLabelFont != null) recentSurveyLabel.setFont(recentSurveyLabelFont);
        recentSurveyLabel.setForeground(new Color(-1));
        recentSurveyLabel.setText("Timestamp della Rilevazione più recente : ");
        generalDataPanel.add(recentSurveyLabel, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        dataPanel.add(spacer2, new GridConstraints(1, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(20, 20), new Dimension(20, 20), new Dimension(20, 20), 0, false));
        windAvgLabel = new JLabel();
        windAvgLabel.setBackground(new Color(-1));
        Font windAvgLabelFont = this.$$$getFont$$$(null, -1, 16, windAvgLabel.getFont());
        if (windAvgLabelFont != null) windAvgLabel.setFont(windAvgLabelFont);
        windAvgLabel.setForeground(new Color(-1));
        windAvgLabel.setText("Media score vento : ");
        dataPanel.add(windAvgLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        windMaxLabel = new JLabel();
        windMaxLabel.setBackground(new Color(-1));
        Font windMaxLabelFont = this.$$$getFont$$$(null, -1, 16, windMaxLabel.getFont());
        if (windMaxLabelFont != null) windMaxLabel.setFont(windMaxLabelFont);
        windMaxLabel.setForeground(new Color(-1));
        windMaxLabel.setText("Score vento massimo : ");
        dataPanel.add(windMaxLabel, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        windMinLabel = new JLabel();
        windMinLabel.setBackground(new Color(-1));
        Font windMinLabelFont = this.$$$getFont$$$(null, -1, 16, windMinLabel.getFont());
        if (windMinLabelFont != null) windMinLabel.setFont(windMinLabelFont);
        windMinLabel.setForeground(new Color(-1));
        windMinLabel.setText("Score vento minimo : ");
        dataPanel.add(windMinLabel, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        humidityAvgLabel = new JLabel();
        humidityAvgLabel.setBackground(new Color(-1));
        Font humidityAvgLabelFont = this.$$$getFont$$$(null, -1, 16, humidityAvgLabel.getFont());
        if (humidityAvgLabelFont != null) humidityAvgLabel.setFont(humidityAvgLabelFont);
        humidityAvgLabel.setForeground(new Color(-1));
        humidityAvgLabel.setText("Media score umidità : ");
        dataPanel.add(humidityAvgLabel, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        humidityMaxLabel = new JLabel();
        humidityMaxLabel.setBackground(new Color(-1));
        Font humidityMaxLabelFont = this.$$$getFont$$$(null, -1, 16, humidityMaxLabel.getFont());
        if (humidityMaxLabelFont != null) humidityMaxLabel.setFont(humidityMaxLabelFont);
        humidityMaxLabel.setForeground(new Color(-1));
        humidityMaxLabel.setText("Score umidità massimo : ");
        dataPanel.add(humidityMaxLabel, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        humidityMinLabel = new JLabel();
        humidityMinLabel.setBackground(new Color(-1));
        Font humidityMinLabelFont = this.$$$getFont$$$(null, -1, 16, humidityMinLabel.getFont());
        if (humidityMinLabelFont != null) humidityMinLabel.setFont(humidityMinLabelFont);
        humidityMinLabel.setForeground(new Color(-1));
        humidityMinLabel.setText("Score umidità minimo : ");
        dataPanel.add(humidityMinLabel, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pressureAvgLabel = new JLabel();
        pressureAvgLabel.setBackground(new Color(-1));
        Font pressureAvgLabelFont = this.$$$getFont$$$(null, -1, 16, pressureAvgLabel.getFont());
        if (pressureAvgLabelFont != null) pressureAvgLabel.setFont(pressureAvgLabelFont);
        pressureAvgLabel.setForeground(new Color(-1));
        pressureAvgLabel.setText("Media score pressione : ");
        dataPanel.add(pressureAvgLabel, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pressureMaxLabel = new JLabel();
        pressureMaxLabel.setBackground(new Color(-1));
        Font pressureMaxLabelFont = this.$$$getFont$$$(null, -1, 16, pressureMaxLabel.getFont());
        if (pressureMaxLabelFont != null) pressureMaxLabel.setFont(pressureMaxLabelFont);
        pressureMaxLabel.setForeground(new Color(-1));
        pressureMaxLabel.setText("Score pressione massimo : ");
        dataPanel.add(pressureMaxLabel, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pressureMinLabel = new JLabel();
        pressureMinLabel.setBackground(new Color(-1));
        Font pressureMinLabelFont = this.$$$getFont$$$(null, -1, 16, pressureMinLabel.getFont());
        if (pressureMinLabelFont != null) pressureMinLabel.setFont(pressureMinLabelFont);
        pressureMinLabel.setForeground(new Color(-1));
        pressureMinLabel.setText("Score pressione minimo : ");
        dataPanel.add(pressureMinLabel, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        temperatureAvgLabel = new JLabel();
        temperatureAvgLabel.setBackground(new Color(-1));
        Font temperatureAvgLabelFont = this.$$$getFont$$$(null, -1, 16, temperatureAvgLabel.getFont());
        if (temperatureAvgLabelFont != null) temperatureAvgLabel.setFont(temperatureAvgLabelFont);
        temperatureAvgLabel.setForeground(new Color(-1));
        temperatureAvgLabel.setText("Media score temperatura : ");
        dataPanel.add(temperatureAvgLabel, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        temperatureMaxLabel = new JLabel();
        temperatureMaxLabel.setBackground(new Color(-1));
        Font temperatureMaxLabelFont = this.$$$getFont$$$(null, -1, 16, temperatureMaxLabel.getFont());
        if (temperatureMaxLabelFont != null) temperatureMaxLabel.setFont(temperatureMaxLabelFont);
        temperatureMaxLabel.setForeground(new Color(-1));
        temperatureMaxLabel.setText("Score temperatura massimo : ");
        dataPanel.add(temperatureMaxLabel, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        temperatureMinLabel = new JLabel();
        temperatureMinLabel.setBackground(new Color(-1));
        Font temperatureMinLabelFont = this.$$$getFont$$$(null, -1, 16, temperatureMinLabel.getFont());
        if (temperatureMinLabelFont != null) temperatureMinLabel.setFont(temperatureMinLabelFont);
        temperatureMinLabel.setForeground(new Color(-1));
        temperatureMinLabel.setText("Score temperatura minimo : ");
        dataPanel.add(temperatureMinLabel, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        precipitationAvgLabel = new JLabel();
        precipitationAvgLabel.setBackground(new Color(-1));
        Font precipitationAvgLabelFont = this.$$$getFont$$$(null, -1, 16, precipitationAvgLabel.getFont());
        if (precipitationAvgLabelFont != null) precipitationAvgLabel.setFont(precipitationAvgLabelFont);
        precipitationAvgLabel.setForeground(new Color(-1));
        precipitationAvgLabel.setText("Media score precipitazioni : ");
        dataPanel.add(precipitationAvgLabel, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        precipitationMaxLabel = new JLabel();
        precipitationMaxLabel.setBackground(new Color(-1));
        Font precipitationMaxLabelFont = this.$$$getFont$$$(null, -1, 16, precipitationMaxLabel.getFont());
        if (precipitationMaxLabelFont != null) precipitationMaxLabel.setFont(precipitationMaxLabelFont);
        precipitationMaxLabel.setForeground(new Color(-1));
        precipitationMaxLabel.setText("Score precipitazioni massimo : ");
        dataPanel.add(precipitationMaxLabel, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        precipitationMinLabel = new JLabel();
        precipitationMinLabel.setBackground(new Color(-1));
        Font precipitationMinLabelFont = this.$$$getFont$$$(null, -1, 16, precipitationMinLabel.getFont());
        if (precipitationMinLabelFont != null) precipitationMinLabel.setFont(precipitationMinLabelFont);
        precipitationMinLabel.setForeground(new Color(-1));
        precipitationMinLabel.setText("Score precipitazioni minimo : ");
        dataPanel.add(precipitationMinLabel, new GridConstraints(6, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        glacial_altitudeAvgLabel = new JLabel();
        glacial_altitudeAvgLabel.setBackground(new Color(-1));
        Font glacial_altitudeAvgLabelFont = this.$$$getFont$$$(null, -1, 16, glacial_altitudeAvgLabel.getFont());
        if (glacial_altitudeAvgLabelFont != null) glacial_altitudeAvgLabel.setFont(glacial_altitudeAvgLabelFont);
        glacial_altitudeAvgLabel.setForeground(new Color(-1));
        glacial_altitudeAvgLabel.setText("Media score Altitudine ghiacciai : ");
        dataPanel.add(glacial_altitudeAvgLabel, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        glacial_altitudeMaxLabel = new JLabel();
        glacial_altitudeMaxLabel.setBackground(new Color(-1));
        Font glacial_altitudeMaxLabelFont = this.$$$getFont$$$(null, -1, 16, glacial_altitudeMaxLabel.getFont());
        if (glacial_altitudeMaxLabelFont != null) glacial_altitudeMaxLabel.setFont(glacial_altitudeMaxLabelFont);
        glacial_altitudeMaxLabel.setForeground(new Color(-1));
        glacial_altitudeMaxLabel.setText("Score Altitudine ghiacciai massimo : ");
        dataPanel.add(glacial_altitudeMaxLabel, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        glacial_altitudeMinLabel = new JLabel();
        glacial_altitudeMinLabel.setBackground(new Color(-1));
        Font glacial_altitudeMinLabelFont = this.$$$getFont$$$(null, -1, 16, glacial_altitudeMinLabel.getFont());
        if (glacial_altitudeMinLabelFont != null) glacial_altitudeMinLabel.setFont(glacial_altitudeMinLabelFont);
        glacial_altitudeMinLabel.setForeground(new Color(-1));
        glacial_altitudeMinLabel.setText("Score Altitudine ghiacciai minimo : ");
        dataPanel.add(glacial_altitudeMinLabel, new GridConstraints(7, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        glacial_massAvgLabel = new JLabel();
        glacial_massAvgLabel.setBackground(new Color(-1));
        Font glacial_massAvgLabelFont = this.$$$getFont$$$(null, -1, 16, glacial_massAvgLabel.getFont());
        if (glacial_massAvgLabelFont != null) glacial_massAvgLabel.setFont(glacial_massAvgLabelFont);
        glacial_massAvgLabel.setForeground(new Color(-1));
        glacial_massAvgLabel.setText("Media Massa ghiacciai : ");
        dataPanel.add(glacial_massAvgLabel, new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        glacial_massMaxLabel = new JLabel();
        glacial_massMaxLabel.setBackground(new Color(-1));
        Font glacial_massMaxLabelFont = this.$$$getFont$$$(null, -1, 16, glacial_massMaxLabel.getFont());
        if (glacial_massMaxLabelFont != null) glacial_massMaxLabel.setFont(glacial_massMaxLabelFont);
        glacial_massMaxLabel.setForeground(new Color(-1));
        glacial_massMaxLabel.setText("Score Massa ghiacciai massimo : ");
        dataPanel.add(glacial_massMaxLabel, new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        glacial_massMinLabel = new JLabel();
        glacial_massMinLabel.setBackground(new Color(-1));
        Font glacial_massMinLabelFont = this.$$$getFont$$$(null, -1, 16, glacial_massMinLabel.getFont());
        if (glacial_massMinLabelFont != null) glacial_massMinLabel.setFont(glacial_massMinLabelFont);
        glacial_massMinLabel.setForeground(new Color(-1));
        glacial_massMinLabel.setText("Score Massa ghiacciai minimo : ");
        dataPanel.add(glacial_massMinLabel, new GridConstraints(8, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        commentButtonsPanel = new JPanel();
        commentButtonsPanel.setLayout(new GridLayoutManager(2, 4, new Insets(0, 0, 0, 0), -1, -1));
        commentButtonsPanel.setBackground(new Color(-9473675));
        commentButtonsPanel.setForeground(new Color(-9473675));
        poiDataPanel.add(commentButtonsPanel, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        windCommentButton = new JButton();
        windCommentButton.setBackground(new Color(-13947600));
        windCommentButton.setForeground(new Color(-1));
        windCommentButton.setText("Visualizza commenti Vento");
        commentButtonsPanel.add(windCommentButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        humidityCommentButton = new JButton();
        humidityCommentButton.setBackground(new Color(-13947600));
        humidityCommentButton.setForeground(new Color(-1));
        humidityCommentButton.setText("Visualizza commenti Umidità");
        commentButtonsPanel.add(humidityCommentButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pressureCommentButton = new JButton();
        pressureCommentButton.setBackground(new Color(-13947600));
        pressureCommentButton.setForeground(new Color(-1));
        pressureCommentButton.setText("Visualizza commenti Pressione");
        commentButtonsPanel.add(pressureCommentButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        temperatureCommentButton = new JButton();
        temperatureCommentButton.setBackground(new Color(-13947600));
        temperatureCommentButton.setForeground(new Color(-1));
        temperatureCommentButton.setText("Visualizza commenti Temperatura");
        commentButtonsPanel.add(temperatureCommentButton, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        precipitationCommentButton = new JButton();
        precipitationCommentButton.setBackground(new Color(-13947600));
        precipitationCommentButton.setForeground(new Color(-1));
        precipitationCommentButton.setText("Visualizza commenti Precipitazioni");
        commentButtonsPanel.add(precipitationCommentButton, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        glacial_altitudeCommentButton = new JButton();
        glacial_altitudeCommentButton.setBackground(new Color(-13947600));
        glacial_altitudeCommentButton.setForeground(new Color(-1));
        glacial_altitudeCommentButton.setText("Visualizza commenti Massa Ghiacciai");
        commentButtonsPanel.add(glacial_altitudeCommentButton, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        glacial_massCommentButton = new JButton();
        glacial_massCommentButton.setBackground(new Color(-13947600));
        glacial_massCommentButton.setForeground(new Color(-1));
        glacial_massCommentButton.setText("Visualizza commenti Altitudine Ghiacciai");
        commentButtonsPanel.add(glacial_massCommentButton, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        backButton = new JButton();
        backButton.setBackground(new Color(-13947600));
        backButton.setForeground(new Color(-1));
        backButton.setText("Indietro");
        poiDataPanel.add(backButton, new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        poiDataPanel.add(spacer3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        poiDataPanel.add(spacer4, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer5 = new Spacer();
        poiDataPanel.add(spacer5, new GridConstraints(9, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(10, 10), new Dimension(10, 10), new Dimension(10, 10), 0, false));
        final Spacer spacer6 = new Spacer();
        poiDataPanel.add(spacer6, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer7 = new Spacer();
        poiDataPanel.add(spacer7, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer8 = new Spacer();
        poiDataPanel.add(spacer8, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
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
        return poiDataPanel;
    }

}
