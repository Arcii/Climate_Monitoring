package org.climatemonitoring.client.gui.views;

import org.climatemonitoring.client.gui.controllers.PoiSearchResultGUIController;
import org.climatemonitoring.shared.models.PointOfInterest;

import javax.swing.*;
import java.util.ArrayList;

public class PoiSearchResultGUI extends JFrame{

    private JPanel poiSearchResultPanel;
    private JLabel climatemonitoringLabel;
    private JLabel searchInfoLabel;
    private JTable searchResultTable;
    private JPanel searchResultPanel;
    private JButton backButton;
    private JButton selectPoiButton;
    private JScrollPane searchResultScroll;

    public PoiSearchResultGUI(ArrayList<PointOfInterest> searchResults){
        setTitle("Climate Monitoring");
        setContentPane(poiSearchResultPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1024);// To set fixed dimensions
        new PoiSearchResultGUIController(this, searchResults);
    }

    public JPanel getPoiSearchResultPanel() {
        return poiSearchResultPanel;
    }

    public void setPoiSearchResultPanel(JPanel poiSearchResultPanel) {
        this.poiSearchResultPanel = poiSearchResultPanel;
    }

    public JLabel getClimatemonitoringLabel() {
        return climatemonitoringLabel;
    }

    public void setClimatemonitoringLabel(JLabel climatemonitoringLabel) {
        this.climatemonitoringLabel = climatemonitoringLabel;
    }

    public JLabel getSearchInfoLabel() {
        return searchInfoLabel;
    }

    public void setSearchInfoLabel(JLabel searchInfoLabel) {
        this.searchInfoLabel = searchInfoLabel;
    }

    public JPanel getSearchResultPanel() {
        return searchResultPanel;
    }

    public void setSearchResultPanel(JPanel searchResultPanel) {
        this.searchResultPanel = searchResultPanel;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public JButton getSelectPoiButton() {
        return selectPoiButton;
    }

    public void setSelectPoiButton(JButton selectPoiButton) {
        this.selectPoiButton = selectPoiButton;
    }

    public JTable getSearchResultTable() {
        return searchResultTable;
    }

    public void setSearchResultTable(JTable searchResultsTable) {
        this.searchResultTable = searchResultsTable;
    }

    public JScrollPane getSearchResultsScroll() {
        return searchResultScroll;
    }

    public void setSearchResultsScroll(JScrollPane searchResultsScroll) {
        this.searchResultScroll = searchResultsScroll;
    }

}
