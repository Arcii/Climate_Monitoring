package org.climatemonitoring.client.gui.views;

import org.climatemonitoring.client.gui.controllers.PoiDataGUIController;
import org.climatemonitoring.shared.models.Survey;

import javax.swing.*;
import java.util.ArrayList;

public class PoiDataGUI extends JFrame{
    private JPanel poiDataPanel;
    private JLabel climatemonitoringLabel;
    private JLabel poi_infoLabel;
    private JPanel searchResultPanel;
    private JScrollPane searchResultScroll;
    private JTable searchResultTable;
    private JLabel countLabel;

    public PoiDataGUI(ArrayList<Survey> searchResults){
        setTitle("Climate Monitoring");
        setContentPane(poiDataPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1024);// To set fixed dimensions
        new PoiDataGUIController(this, searchResults);
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

    public JLabel getCountLabel() {
        return countLabel;
    }

    public void setCountLabel(JLabel countLabel) {
        this.countLabel = countLabel;
    }

    public JTable getSearchResultTable() {
        return searchResultTable;
    }

    public void setSearchResultTable(JTable searchResultTable) {
        this.searchResultTable = searchResultTable;
    }

}
