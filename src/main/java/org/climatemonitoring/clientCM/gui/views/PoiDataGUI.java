package org.climatemonitoring.clientCM.gui.views;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import org.climatemonitoring.clientCM.gui.controllers.PoiDataGUIController;
import org.climatemonitoring.shared.models.PointOfInterest;
import org.climatemonitoring.shared.models.SurveysAggregate;
import org.climatemonitoring.shared.models.User;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.ArrayList;
import java.util.Locale;

public class PoiDataGUI extends JFrame {
    private JPanel poiDataPanel;
    private JLabel climatemonitoringLabel;
    private JLabel poi_infoLabel;
    private JPanel searchResultPanel;
    private JScrollPane searchResultScroll;
    private JTable searchResultTable;
    private JLabel countLabel;
    private JLabel centersNumberLabel;
    private JLabel oldestSurveyLabel;
    private JLabel recentSurveyLabel;
    private JPanel generalDataPanel;
    private JPanel dataPanel;
    private JPanel windDataPanel;
    private JLabel windAvgLabel;
    private JLabel windMaxLabel;
    private JLabel windMinLabel;
    private JPanel humidityDataPanel;
    private JLabel humidityAvgLabel;
    private JLabel humidityMaxLabel;
    private JLabel humidityMinLabel;
    private JPanel pressureDataLabel;
    private JLabel pressureAvgLabel;
    private JLabel pressureMaxLabel;
    private JLabel pressureMinLabel;
    private JPanel temperatureDataLabel;
    private JLabel temperatureAvgLabel;
    private JLabel temperatureMaxLabel;
    private JLabel temperatureMinLabel;
    private JPanel precipitationDataLabel;
    private JLabel precipitationAvgLabel;
    private JLabel precipitationMaxLabel;
    private JLabel precipitationMinLabel;
    private JPanel glacial_altitudeDataPanel;
    private JPanel glacial_massDataPanel;
    private JLabel glacial_altitudeMaxLabel;
    private JLabel glacial_altitudeMinLabel;
    private JLabel glacial_altitudeAvgLabel;
    private JLabel glacial_massAvgLabel;
    private JLabel glacial_massMaxLabel;
    private JLabel glacial_massMinLabel;
    private JButton windCommentButton;
    private JButton humidityCommentButton;
    private JButton pressureCommentButton;
    private JButton temperatureCommentButton;
    private JButton precipitationCommentButton;
    private JButton glacial_altitudeCommentButton;
    private JButton glacial_massCommentButton;
    private JButton backButton;
    private JPanel commentButtonsPanel;

    public PoiDataGUI(SurveysAggregate surveysAggregate, ArrayList<PointOfInterest> searchResults) {
        setTitle("Climate Monitoring");
        setContentPane(poiDataPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1024);// To set fixed dimensions
        new PoiDataGUIController(this, surveysAggregate, searchResults, null);
    }

    public PoiDataGUI(SurveysAggregate surveysAggregate, ArrayList<PointOfInterest> searchResults, User user) {
        setTitle("Climate Monitoring");
        setContentPane(poiDataPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1024);// To set fixed dimensions
        new PoiDataGUIController(this, surveysAggregate, searchResults, user);
    }

    public JPanel getPoiDataPanel() {
        return poiDataPanel;
    }

    public void setPoiDataPanel(JPanel poiDataPanel) {
        this.poiDataPanel = poiDataPanel;
    }

    public JLabel getClimatemonitoringLabel() {
        return climatemonitoringLabel;
    }

    public void setClimatemonitoringLabel(JLabel climatemonitoringLabel) {
        this.climatemonitoringLabel = climatemonitoringLabel;
    }

    public JLabel getPoi_infoLabel() {
        return poi_infoLabel;
    }

    public void setPoi_infoLabel(JLabel poi_infoLabel) {
        this.poi_infoLabel = poi_infoLabel;
    }

    public JPanel getSearchResultPanel() {
        return searchResultPanel;
    }

    public void setSearchResultPanel(JPanel searchResultPanel) {
        this.searchResultPanel = searchResultPanel;
    }

    public JScrollPane getSearchResultScroll() {
        return searchResultScroll;
    }

    public void setSearchResultScroll(JScrollPane searchResultScroll) {
        this.searchResultScroll = searchResultScroll;
    }

    public JTable getSearchResultTable() {
        return searchResultTable;
    }

    public void setSearchResultTable(JTable searchResultTable) {
        this.searchResultTable = searchResultTable;
    }

    public JLabel getCountLabel() {
        return countLabel;
    }

    public void setCountLabel(JLabel countLabel) {
        this.countLabel = countLabel;
    }

    public JLabel getCentersNumberLabel() {
        return centersNumberLabel;
    }

    public void setCentersNumberLabel(JLabel centersNumberLabel) {
        this.centersNumberLabel = centersNumberLabel;
    }

    public JLabel getOldestSurveyLabel() {
        return oldestSurveyLabel;
    }

    public void setOldestSurveyLabel(JLabel oldestSurveyLabel) {
        this.oldestSurveyLabel = oldestSurveyLabel;
    }

    public JLabel getRecentSurveyLabel() {
        return recentSurveyLabel;
    }

    public void setRecentSurveyLabel(JLabel recentSurveyLabel) {
        this.recentSurveyLabel = recentSurveyLabel;
    }

    public JPanel getGeneralDataPanel() {
        return generalDataPanel;
    }

    public void setGeneralDataPanel(JPanel generalDataPanel) {
        this.generalDataPanel = generalDataPanel;
    }

    public JPanel getDataPanel() {
        return dataPanel;
    }

    public void setDataPanel(JPanel dataPanel) {
        this.dataPanel = dataPanel;
    }

    public JPanel getWindDataPanel() {
        return windDataPanel;
    }

    public void setWindDataPanel(JPanel windDataPanel) {
        this.windDataPanel = windDataPanel;
    }

    public JLabel getWindAvgLabel() {
        return windAvgLabel;
    }

    public void setWindAvgLabel(JLabel windAvgLabel) {
        this.windAvgLabel = windAvgLabel;
    }

    public JLabel getWindMaxLabel() {
        return windMaxLabel;
    }

    public void setWindMaxLabel(JLabel windMaxLabel) {
        this.windMaxLabel = windMaxLabel;
    }

    public JLabel getWindMinLabel() {
        return windMinLabel;
    }

    public void setWindMinLabel(JLabel windMinLabel) {
        this.windMinLabel = windMinLabel;
    }

    public JPanel getHumidityDataPanel() {
        return humidityDataPanel;
    }

    public void setHumidityDataPanel(JPanel humidityDataPanel) {
        this.humidityDataPanel = humidityDataPanel;
    }

    public JLabel getHumidityAvgLabel() {
        return humidityAvgLabel;
    }

    public void setHumidityAvgLabel(JLabel humidityAvgLabel) {
        this.humidityAvgLabel = humidityAvgLabel;
    }

    public JLabel getHumidityMaxLabel() {
        return humidityMaxLabel;
    }

    public void setHumidityMaxLabel(JLabel humidityMaxLabel) {
        this.humidityMaxLabel = humidityMaxLabel;
    }

    public JLabel getHumidityMinLabel() {
        return humidityMinLabel;
    }

    public void setHumidityMinLabel(JLabel humidityMinLabel) {
        this.humidityMinLabel = humidityMinLabel;
    }

    public JPanel getPressureDataLabel() {
        return pressureDataLabel;
    }

    public void setPressureDataLabel(JPanel pressureDataLabel) {
        this.pressureDataLabel = pressureDataLabel;
    }

    public JLabel getPressureAvgLabel() {
        return pressureAvgLabel;
    }

    public void setPressureAvgLabel(JLabel pressureAvgLabel) {
        this.pressureAvgLabel = pressureAvgLabel;
    }

    public JLabel getPressureMaxLabel() {
        return pressureMaxLabel;
    }

    public void setPressureMaxLabel(JLabel pressureMaxLabel) {
        this.pressureMaxLabel = pressureMaxLabel;
    }

    public JLabel getPressureMinLabel() {
        return pressureMinLabel;
    }

    public void setPressureMinLabel(JLabel pressureMinLabel) {
        this.pressureMinLabel = pressureMinLabel;
    }

    public JPanel getTemperatureDataLabel() {
        return temperatureDataLabel;
    }

    public void setTemperatureDataLabel(JPanel temperatureDataLabel) {
        this.temperatureDataLabel = temperatureDataLabel;
    }

    public JLabel getTemperatureAvgLabel() {
        return temperatureAvgLabel;
    }

    public void setTemperatureAvgLabel(JLabel temperatureAvgLabel) {
        this.temperatureAvgLabel = temperatureAvgLabel;
    }

    public JLabel getTemperatureMaxLabel() {
        return temperatureMaxLabel;
    }

    public void setTemperatureMaxLabel(JLabel temperatureMaxLabel) {
        this.temperatureMaxLabel = temperatureMaxLabel;
    }

    public JLabel getTemperatureMinLabel() {
        return temperatureMinLabel;
    }

    public void setTemperatureMinLabel(JLabel temperatureMinLabel) {
        this.temperatureMinLabel = temperatureMinLabel;
    }

    public JPanel getPrecipitationDataLabel() {
        return precipitationDataLabel;
    }

    public void setPrecipitationDataLabel(JPanel precipitationDataLabel) {
        this.precipitationDataLabel = precipitationDataLabel;
    }

    public JLabel getPrecipitationAvgLabel() {
        return precipitationAvgLabel;
    }

    public void setPrecipitationAvgLabel(JLabel precipitationAvgLabel) {
        this.precipitationAvgLabel = precipitationAvgLabel;
    }

    public JLabel getPrecipitationMaxLabel() {
        return precipitationMaxLabel;
    }

    public void setPrecipitationMaxLabel(JLabel precipitationMaxLabel) {
        this.precipitationMaxLabel = precipitationMaxLabel;
    }

    public JLabel getPrecipitationMinLabel() {
        return precipitationMinLabel;
    }

    public void setPrecipitationMinLabel(JLabel precipitationMinLabel) {
        this.precipitationMinLabel = precipitationMinLabel;
    }

    public JPanel getGlacial_altitudeDataPanel() {
        return glacial_altitudeDataPanel;
    }

    public void setGlacial_altitudeDataPanel(JPanel glacial_altitudeDataPanel) {
        this.glacial_altitudeDataPanel = glacial_altitudeDataPanel;
    }

    public JPanel getGlacial_massDataPanel() {
        return glacial_massDataPanel;
    }

    public void setGlacial_massDataPanel(JPanel glacial_massDataPanel) {
        this.glacial_massDataPanel = glacial_massDataPanel;
    }

    public JLabel getGlacial_altitudeMaxLabel() {
        return glacial_altitudeMaxLabel;
    }

    public void setGlacial_altitudeMaxLabel(JLabel glacial_altitudeMaxLabel) {
        this.glacial_altitudeMaxLabel = glacial_altitudeMaxLabel;
    }

    public JLabel getGlacial_altitudeMinLabel() {
        return glacial_altitudeMinLabel;
    }

    public void setGlacial_altitudeMinLabel(JLabel glacial_altitudeMinLabel) {
        this.glacial_altitudeMinLabel = glacial_altitudeMinLabel;
    }

    public JLabel getGlacial_altitudeAvgLabel() {
        return glacial_altitudeAvgLabel;
    }

    public void setGlacial_altitudeAvgLabel(JLabel glacial_altitudeAvgLabel) {
        this.glacial_altitudeAvgLabel = glacial_altitudeAvgLabel;
    }

    public JLabel getGlacial_massAvgLabel() {
        return glacial_massAvgLabel;
    }

    public void setGlacial_massAvgLabel(JLabel glacial_massAvgLabel) {
        this.glacial_massAvgLabel = glacial_massAvgLabel;
    }

    public JLabel getGlacial_massMaxLabel() {
        return glacial_massMaxLabel;
    }

    public void setGlacial_massMaxLabel(JLabel glacial_massMaxLabel) {
        this.glacial_massMaxLabel = glacial_massMaxLabel;
    }

    public JLabel getGlacial_massMinLabel() {
        return glacial_massMinLabel;
    }

    public void setGlacial_massMinLabel(JLabel glacial_massMinLabel) {
        this.glacial_massMinLabel = glacial_massMinLabel;
    }

    public JButton getWindCommentButton() {
        return windCommentButton;
    }

    public void setWindCommentButton(JButton windCommentButton) {
        this.windCommentButton = windCommentButton;
    }

    public JButton getHumidityCommentButton() {
        return humidityCommentButton;
    }

    public void setHumidityCommentButton(JButton humidityCommentButton) {
        this.humidityCommentButton = humidityCommentButton;
    }

    public JButton getPressureCommentButton() {
        return pressureCommentButton;
    }

    public void setPressureCommentButton(JButton pressureCommentButton) {
        this.pressureCommentButton = pressureCommentButton;
    }

    public JButton getTemperatureCommentButton() {
        return temperatureCommentButton;
    }

    public void setTemperatureCommentButton(JButton temperatureCommentButton) {
        this.temperatureCommentButton = temperatureCommentButton;
    }

    public JButton getPrecipitationCommentButton() {
        return precipitationCommentButton;
    }

    public void setPrecipitationCommentButton(JButton precipitationCommentButton) {
        this.precipitationCommentButton = precipitationCommentButton;
    }

    public JButton getGlacial_altitudeCommentButton() {
        return glacial_altitudeCommentButton;
    }

    public void setGlacial_altitudeCommentButton(JButton glacial_altitudeCommentButton) {
        this.glacial_altitudeCommentButton = glacial_altitudeCommentButton;
    }

    public JButton getGlacial_massCommentButton() {
        return glacial_massCommentButton;
    }

    public void setGlacial_massCommentButton(JButton glacial_massCommentButton) {
        this.glacial_massCommentButton = glacial_massCommentButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public JPanel getCommentButtonsPanel() {
        return commentButtonsPanel;
    }

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
        poiDataPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(10, 3, new Insets(0, 0, 0, 0), -1, -1));
        poiDataPanel.setBackground(new Color(-9473675));
        poiDataPanel.setForeground(new Color(-9473675));
        climatemonitoringLabel = new JLabel();
        climatemonitoringLabel.setBackground(new Color(-1));
        Font climatemonitoringLabelFont = this.$$$getFont$$$("JetBrains Mono ExtraBold", Font.BOLD, 72, climatemonitoringLabel.getFont());
        if (climatemonitoringLabelFont != null) climatemonitoringLabel.setFont(climatemonitoringLabelFont);
        climatemonitoringLabel.setForeground(new Color(-1));
        climatemonitoringLabel.setText("Climate Monitoring");
        poiDataPanel.add(climatemonitoringLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        poiDataPanel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        poi_infoLabel = new JLabel();
        Font poi_infoLabelFont = this.$$$getFont$$$(null, -1, 24, poi_infoLabel.getFont());
        if (poi_infoLabelFont != null) poi_infoLabel.setFont(poi_infoLabelFont);
        poi_infoLabel.setForeground(new Color(-1));
        poi_infoLabel.setText("I dati Aggregati per questa Area Geografica sono :");
        poiDataPanel.add(poi_infoLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        dataPanel = new JPanel();
        dataPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(9, 3, new Insets(0, 0, 0, 0), -1, -1));
        dataPanel.setBackground(new Color(-9473675));
        dataPanel.setForeground(new Color(-9473675));
        poiDataPanel.add(dataPanel, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        generalDataPanel = new JPanel();
        generalDataPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        generalDataPanel.setBackground(new Color(-9473675));
        generalDataPanel.setForeground(new Color(-9473675));
        dataPanel.add(generalDataPanel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        countLabel = new JLabel();
        countLabel.setBackground(new Color(-1));
        Font countLabelFont = this.$$$getFont$$$(null, -1, 16, countLabel.getFont());
        if (countLabelFont != null) countLabel.setFont(countLabelFont);
        countLabel.setForeground(new Color(-1));
        countLabel.setText("Numero Rilevazioni Area : ");
        generalDataPanel.add(countLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        centersNumberLabel = new JLabel();
        centersNumberLabel.setBackground(new Color(-1));
        Font centersNumberLabelFont = this.$$$getFont$$$(null, -1, 16, centersNumberLabel.getFont());
        if (centersNumberLabelFont != null) centersNumberLabel.setFont(centersNumberLabelFont);
        centersNumberLabel.setForeground(new Color(-1));
        centersNumberLabel.setText("Numero Centri con Rilevazioni per quest'area : ");
        generalDataPanel.add(centersNumberLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        oldestSurveyLabel = new JLabel();
        oldestSurveyLabel.setBackground(new Color(-1));
        Font oldestSurveyLabelFont = this.$$$getFont$$$(null, -1, 16, oldestSurveyLabel.getFont());
        if (oldestSurveyLabelFont != null) oldestSurveyLabel.setFont(oldestSurveyLabelFont);
        oldestSurveyLabel.setForeground(new Color(-1));
        oldestSurveyLabel.setText("Timestamp della Rilevazione più vecchia : ");
        generalDataPanel.add(oldestSurveyLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        recentSurveyLabel = new JLabel();
        recentSurveyLabel.setBackground(new Color(-1));
        Font recentSurveyLabelFont = this.$$$getFont$$$(null, -1, 16, recentSurveyLabel.getFont());
        if (recentSurveyLabelFont != null) recentSurveyLabel.setFont(recentSurveyLabelFont);
        recentSurveyLabel.setForeground(new Color(-1));
        recentSurveyLabel.setText("Timestamp della Rilevazione più recente : ");
        generalDataPanel.add(recentSurveyLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        dataPanel.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(20, 20), new Dimension(20, 20), new Dimension(20, 20), 0, false));
        windAvgLabel = new JLabel();
        windAvgLabel.setBackground(new Color(-1));
        Font windAvgLabelFont = this.$$$getFont$$$(null, -1, 16, windAvgLabel.getFont());
        if (windAvgLabelFont != null) windAvgLabel.setFont(windAvgLabelFont);
        windAvgLabel.setForeground(new Color(-1));
        windAvgLabel.setText("Media score vento : ");
        dataPanel.add(windAvgLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        windMaxLabel = new JLabel();
        windMaxLabel.setBackground(new Color(-1));
        Font windMaxLabelFont = this.$$$getFont$$$(null, -1, 16, windMaxLabel.getFont());
        if (windMaxLabelFont != null) windMaxLabel.setFont(windMaxLabelFont);
        windMaxLabel.setForeground(new Color(-1));
        windMaxLabel.setText("Score vento massimo : ");
        dataPanel.add(windMaxLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        windMinLabel = new JLabel();
        windMinLabel.setBackground(new Color(-1));
        Font windMinLabelFont = this.$$$getFont$$$(null, -1, 16, windMinLabel.getFont());
        if (windMinLabelFont != null) windMinLabel.setFont(windMinLabelFont);
        windMinLabel.setForeground(new Color(-1));
        windMinLabel.setText("Score vento minimo : ");
        dataPanel.add(windMinLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        humidityAvgLabel = new JLabel();
        humidityAvgLabel.setBackground(new Color(-1));
        Font humidityAvgLabelFont = this.$$$getFont$$$(null, -1, 16, humidityAvgLabel.getFont());
        if (humidityAvgLabelFont != null) humidityAvgLabel.setFont(humidityAvgLabelFont);
        humidityAvgLabel.setForeground(new Color(-1));
        humidityAvgLabel.setText("Media score umidità : ");
        dataPanel.add(humidityAvgLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        humidityMaxLabel = new JLabel();
        humidityMaxLabel.setBackground(new Color(-1));
        Font humidityMaxLabelFont = this.$$$getFont$$$(null, -1, 16, humidityMaxLabel.getFont());
        if (humidityMaxLabelFont != null) humidityMaxLabel.setFont(humidityMaxLabelFont);
        humidityMaxLabel.setForeground(new Color(-1));
        humidityMaxLabel.setText("Score umidità massimo : ");
        dataPanel.add(humidityMaxLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        humidityMinLabel = new JLabel();
        humidityMinLabel.setBackground(new Color(-1));
        Font humidityMinLabelFont = this.$$$getFont$$$(null, -1, 16, humidityMinLabel.getFont());
        if (humidityMinLabelFont != null) humidityMinLabel.setFont(humidityMinLabelFont);
        humidityMinLabel.setForeground(new Color(-1));
        humidityMinLabel.setText("Score umidità minimo : ");
        dataPanel.add(humidityMinLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pressureAvgLabel = new JLabel();
        pressureAvgLabel.setBackground(new Color(-1));
        Font pressureAvgLabelFont = this.$$$getFont$$$(null, -1, 16, pressureAvgLabel.getFont());
        if (pressureAvgLabelFont != null) pressureAvgLabel.setFont(pressureAvgLabelFont);
        pressureAvgLabel.setForeground(new Color(-1));
        pressureAvgLabel.setText("Media score pressione : ");
        dataPanel.add(pressureAvgLabel, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pressureMaxLabel = new JLabel();
        pressureMaxLabel.setBackground(new Color(-1));
        Font pressureMaxLabelFont = this.$$$getFont$$$(null, -1, 16, pressureMaxLabel.getFont());
        if (pressureMaxLabelFont != null) pressureMaxLabel.setFont(pressureMaxLabelFont);
        pressureMaxLabel.setForeground(new Color(-1));
        pressureMaxLabel.setText("Score pressione massimo : ");
        dataPanel.add(pressureMaxLabel, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pressureMinLabel = new JLabel();
        pressureMinLabel.setBackground(new Color(-1));
        Font pressureMinLabelFont = this.$$$getFont$$$(null, -1, 16, pressureMinLabel.getFont());
        if (pressureMinLabelFont != null) pressureMinLabel.setFont(pressureMinLabelFont);
        pressureMinLabel.setForeground(new Color(-1));
        pressureMinLabel.setText("Score pressione minimo : ");
        dataPanel.add(pressureMinLabel, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        temperatureAvgLabel = new JLabel();
        temperatureAvgLabel.setBackground(new Color(-1));
        Font temperatureAvgLabelFont = this.$$$getFont$$$(null, -1, 16, temperatureAvgLabel.getFont());
        if (temperatureAvgLabelFont != null) temperatureAvgLabel.setFont(temperatureAvgLabelFont);
        temperatureAvgLabel.setForeground(new Color(-1));
        temperatureAvgLabel.setText("Media score temperatura : ");
        dataPanel.add(temperatureAvgLabel, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        temperatureMaxLabel = new JLabel();
        temperatureMaxLabel.setBackground(new Color(-1));
        Font temperatureMaxLabelFont = this.$$$getFont$$$(null, -1, 16, temperatureMaxLabel.getFont());
        if (temperatureMaxLabelFont != null) temperatureMaxLabel.setFont(temperatureMaxLabelFont);
        temperatureMaxLabel.setForeground(new Color(-1));
        temperatureMaxLabel.setText("Score temperatura massimo : ");
        dataPanel.add(temperatureMaxLabel, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        temperatureMinLabel = new JLabel();
        temperatureMinLabel.setBackground(new Color(-1));
        Font temperatureMinLabelFont = this.$$$getFont$$$(null, -1, 16, temperatureMinLabel.getFont());
        if (temperatureMinLabelFont != null) temperatureMinLabel.setFont(temperatureMinLabelFont);
        temperatureMinLabel.setForeground(new Color(-1));
        temperatureMinLabel.setText("Score temperatura minimo : ");
        dataPanel.add(temperatureMinLabel, new com.intellij.uiDesigner.core.GridConstraints(5, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        precipitationAvgLabel = new JLabel();
        precipitationAvgLabel.setBackground(new Color(-1));
        Font precipitationAvgLabelFont = this.$$$getFont$$$(null, -1, 16, precipitationAvgLabel.getFont());
        if (precipitationAvgLabelFont != null) precipitationAvgLabel.setFont(precipitationAvgLabelFont);
        precipitationAvgLabel.setForeground(new Color(-1));
        precipitationAvgLabel.setText("Media score precipitazioni : ");
        dataPanel.add(precipitationAvgLabel, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        precipitationMaxLabel = new JLabel();
        precipitationMaxLabel.setBackground(new Color(-1));
        Font precipitationMaxLabelFont = this.$$$getFont$$$(null, -1, 16, precipitationMaxLabel.getFont());
        if (precipitationMaxLabelFont != null) precipitationMaxLabel.setFont(precipitationMaxLabelFont);
        precipitationMaxLabel.setForeground(new Color(-1));
        precipitationMaxLabel.setText("Score precipitazioni massimo : ");
        dataPanel.add(precipitationMaxLabel, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        precipitationMinLabel = new JLabel();
        precipitationMinLabel.setBackground(new Color(-1));
        Font precipitationMinLabelFont = this.$$$getFont$$$(null, -1, 16, precipitationMinLabel.getFont());
        if (precipitationMinLabelFont != null) precipitationMinLabel.setFont(precipitationMinLabelFont);
        precipitationMinLabel.setForeground(new Color(-1));
        precipitationMinLabel.setText("Score precipitazioni minimo : ");
        dataPanel.add(precipitationMinLabel, new com.intellij.uiDesigner.core.GridConstraints(6, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        glacial_altitudeAvgLabel = new JLabel();
        glacial_altitudeAvgLabel.setBackground(new Color(-1));
        Font glacial_altitudeAvgLabelFont = this.$$$getFont$$$(null, -1, 16, glacial_altitudeAvgLabel.getFont());
        if (glacial_altitudeAvgLabelFont != null) glacial_altitudeAvgLabel.setFont(glacial_altitudeAvgLabelFont);
        glacial_altitudeAvgLabel.setForeground(new Color(-1));
        glacial_altitudeAvgLabel.setText("Media score Altitudine ghiacciai : ");
        dataPanel.add(glacial_altitudeAvgLabel, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        glacial_altitudeMaxLabel = new JLabel();
        glacial_altitudeMaxLabel.setBackground(new Color(-1));
        Font glacial_altitudeMaxLabelFont = this.$$$getFont$$$(null, -1, 16, glacial_altitudeMaxLabel.getFont());
        if (glacial_altitudeMaxLabelFont != null) glacial_altitudeMaxLabel.setFont(glacial_altitudeMaxLabelFont);
        glacial_altitudeMaxLabel.setForeground(new Color(-1));
        glacial_altitudeMaxLabel.setText("Score Altitudine ghiacciai massimo : ");
        dataPanel.add(glacial_altitudeMaxLabel, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        glacial_altitudeMinLabel = new JLabel();
        glacial_altitudeMinLabel.setBackground(new Color(-1));
        Font glacial_altitudeMinLabelFont = this.$$$getFont$$$(null, -1, 16, glacial_altitudeMinLabel.getFont());
        if (glacial_altitudeMinLabelFont != null) glacial_altitudeMinLabel.setFont(glacial_altitudeMinLabelFont);
        glacial_altitudeMinLabel.setForeground(new Color(-1));
        glacial_altitudeMinLabel.setText("Score Altitudine ghiacciai minimo : ");
        dataPanel.add(glacial_altitudeMinLabel, new com.intellij.uiDesigner.core.GridConstraints(7, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        glacial_massAvgLabel = new JLabel();
        glacial_massAvgLabel.setBackground(new Color(-1));
        Font glacial_massAvgLabelFont = this.$$$getFont$$$(null, -1, 16, glacial_massAvgLabel.getFont());
        if (glacial_massAvgLabelFont != null) glacial_massAvgLabel.setFont(glacial_massAvgLabelFont);
        glacial_massAvgLabel.setForeground(new Color(-1));
        glacial_massAvgLabel.setText("Media Massa ghiacciai : ");
        dataPanel.add(glacial_massAvgLabel, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        glacial_massMaxLabel = new JLabel();
        glacial_massMaxLabel.setBackground(new Color(-1));
        Font glacial_massMaxLabelFont = this.$$$getFont$$$(null, -1, 16, glacial_massMaxLabel.getFont());
        if (glacial_massMaxLabelFont != null) glacial_massMaxLabel.setFont(glacial_massMaxLabelFont);
        glacial_massMaxLabel.setForeground(new Color(-1));
        glacial_massMaxLabel.setText("Score Massa ghiacciai massimo : ");
        dataPanel.add(glacial_massMaxLabel, new com.intellij.uiDesigner.core.GridConstraints(8, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        glacial_massMinLabel = new JLabel();
        glacial_massMinLabel.setBackground(new Color(-1));
        Font glacial_massMinLabelFont = this.$$$getFont$$$(null, -1, 16, glacial_massMinLabel.getFont());
        if (glacial_massMinLabelFont != null) glacial_massMinLabel.setFont(glacial_massMinLabelFont);
        glacial_massMinLabel.setForeground(new Color(-1));
        glacial_massMinLabel.setText("Score Massa ghiacciai minimo : ");
        dataPanel.add(glacial_massMinLabel, new com.intellij.uiDesigner.core.GridConstraints(8, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        commentButtonsPanel = new JPanel();
        commentButtonsPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 4, new Insets(0, 0, 0, 0), -1, -1));
        commentButtonsPanel.setBackground(new Color(-9473675));
        commentButtonsPanel.setForeground(new Color(-9473675));
        poiDataPanel.add(commentButtonsPanel, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        windCommentButton = new JButton();
        windCommentButton.setBackground(new Color(-13947600));
        windCommentButton.setForeground(new Color(-1));
        windCommentButton.setText("Visualizza commenti Vento");
        commentButtonsPanel.add(windCommentButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        humidityCommentButton = new JButton();
        humidityCommentButton.setBackground(new Color(-13947600));
        humidityCommentButton.setForeground(new Color(-1));
        humidityCommentButton.setText("Visualizza commenti Umidità");
        commentButtonsPanel.add(humidityCommentButton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pressureCommentButton = new JButton();
        pressureCommentButton.setBackground(new Color(-13947600));
        pressureCommentButton.setForeground(new Color(-1));
        pressureCommentButton.setText("Visualizza commenti Pressione");
        commentButtonsPanel.add(pressureCommentButton, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        temperatureCommentButton = new JButton();
        temperatureCommentButton.setBackground(new Color(-13947600));
        temperatureCommentButton.setForeground(new Color(-1));
        temperatureCommentButton.setText("Visualizza commenti Temperatura");
        commentButtonsPanel.add(temperatureCommentButton, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        precipitationCommentButton = new JButton();
        precipitationCommentButton.setBackground(new Color(-13947600));
        precipitationCommentButton.setForeground(new Color(-1));
        precipitationCommentButton.setText("Visualizza commenti Precipitazioni");
        commentButtonsPanel.add(precipitationCommentButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        glacial_altitudeCommentButton = new JButton();
        glacial_altitudeCommentButton.setBackground(new Color(-13947600));
        glacial_altitudeCommentButton.setForeground(new Color(-1));
        glacial_altitudeCommentButton.setText("Visualizza commenti Massa Ghiacciai");
        commentButtonsPanel.add(glacial_altitudeCommentButton, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        glacial_massCommentButton = new JButton();
        glacial_massCommentButton.setBackground(new Color(-13947600));
        glacial_massCommentButton.setForeground(new Color(-1));
        glacial_massCommentButton.setText("Visualizza commenti Altitudine Ghiacciai");
        commentButtonsPanel.add(glacial_massCommentButton, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        backButton = new JButton();
        backButton.setBackground(new Color(-13947600));
        backButton.setForeground(new Color(-1));
        backButton.setText("Indietro");
        poiDataPanel.add(backButton, new com.intellij.uiDesigner.core.GridConstraints(8, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        poiDataPanel.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        poiDataPanel.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer5 = new com.intellij.uiDesigner.core.Spacer();
        poiDataPanel.add(spacer5, new com.intellij.uiDesigner.core.GridConstraints(9, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(10, 10), new Dimension(10, 10), new Dimension(10, 10), 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer6 = new com.intellij.uiDesigner.core.Spacer();
        poiDataPanel.add(spacer6, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer7 = new com.intellij.uiDesigner.core.Spacer();
        poiDataPanel.add(spacer7, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer8 = new com.intellij.uiDesigner.core.Spacer();
        poiDataPanel.add(spacer8, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
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
