package org.climatemonitoring.client.gui.controllers;

import org.climatemonitoring.client.gui.views.PoiDataGUI;
import org.climatemonitoring.client.network.ClientManager;
import org.climatemonitoring.shared.models.Survey;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

import static org.climatemonitoring.client.network.ClientManager.GetClientManager;

public class PoiDataGUIController {

    private PoiDataGUI view;
    private final ClientManager clientManager;
    private ArrayList<Survey> searchResults;

    public PoiDataGUIController(PoiDataGUI view, ArrayList<Survey> searchResults) {
        this.view = view;
        this.clientManager = GetClientManager();
        this.searchResults = searchResults;

        for (Survey survey : searchResults) {
            System.out.println(survey.toString());
        }

        setUpTable();

        //ADD Listeners
        AddListeners();
    }

    private void AddListeners(){

    }

    public PoiDataGUI getView() {
        return view;
    }

    public void setView(PoiDataGUI view) {
        this.view = view;
    }

    public ClientManager getClientManager() {
        return clientManager;
    }

    public ArrayList<Survey> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(ArrayList<Survey> searchResults) {
        this.searchResults = searchResults;
    }

    private void setUpTable(){
        // Create a DefaultTableModel with column names
        String[] columnNames = {"ID", "ID Centro di Monitoraggio", "Timestamp", "Vento", "Umidità", "Pressione", "Temperatura", "Precipitazioni", "Altitudine dei ghiacciai", "Massa dei ghiacciai"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Populate the model with Surveys data
        for (Survey survey : getSearchResults()) {
            Object[] rowData = {
                    survey.getDataid(),
                    survey.getCenterid(),
                    survey.getTimestamp(),
                    survey.getWind(),
                    survey.getHumidity(),
                    survey.getPressure(),
                    survey.getTemperature(),
                    survey.getPrecipitation(),
                    survey.getGlacial_altitude(),
                    survey.getGlacial_mass(),
            };
            model.addRow(rowData);
        }
        view.getSearchResultTable().setModel(model);
        view.getSearchResultTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

}
