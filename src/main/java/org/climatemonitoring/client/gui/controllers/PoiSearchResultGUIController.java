package org.climatemonitoring.client.gui.controllers;

import org.climatemonitoring.client.gui.views.ClientHomeGUI;
import org.climatemonitoring.client.gui.views.PoiDataGUI;
import org.climatemonitoring.client.gui.views.PoiSearchResultGUI;
import org.climatemonitoring.client.network.ClientManager;
import org.climatemonitoring.shared.models.PointOfInterest;
import org.climatemonitoring.shared.models.Survey;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.climatemonitoring.client.network.ClientManager.GetClientManager;

public class PoiSearchResultGUIController {

    private PoiSearchResultGUI view;
    private final ClientManager clientManager;
    private ArrayList<PointOfInterest> searchResults;

    public PoiSearchResultGUIController(PoiSearchResultGUI view, ArrayList<PointOfInterest> searchResults) {
        this.view = view;
        this.clientManager = GetClientManager();
        this.searchResults = searchResults;

        for (PointOfInterest poi : searchResults) {
            System.out.println(poi.toString());
        }

        setUpTable();

        //ADD Listeners
        AddListeners();
    }

    private void AddListeners(){

        view.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientHomeGUI form = new ClientHomeGUI();
                form.setVisible(true);
                view.dispose();
            }
        });

        view.getSelectPoiButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = view.getSearchResultTable().getSelectedRow();
                if (selectedRow != -1) {
                    Object selectedPoi = view.getSearchResultTable().getValueAt(selectedRow, 0);
                    ArrayList<Survey> result = clientManager.selectSurveysById((Integer)selectedPoi);
                    PoiDataGUI form = new PoiDataGUI(result);
                    form.setVisible(true);
                    view.dispose();
                }else{
                    System.err.println("Button pressed without row selected");
                    JOptionPane.showMessageDialog(view, "Prima di visualizzare i parametri climatici devi selezionare l'area geografica", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    public PoiSearchResultGUI getView() {
        return view;
    }

    public void setView(PoiSearchResultGUI view) {
        this.view = view;
    }

    public ClientManager getClientManager() {
        return clientManager;
    }

    public ArrayList<PointOfInterest> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(ArrayList<PointOfInterest> searchResults) {
        this.searchResults = searchResults;
    }

    private void setUpTable(){
        // Create a DefaultTableModel with column names
        String[] columnNames = {"ID", "Name", "Country", "Latitude", "Longitude"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Populate the model with PointOfInterest data
        for (PointOfInterest poi : getSearchResults()) {
            Object[] rowData = {poi.getPoi_id(), poi.getName(), poi.getCountry(), poi.getLatitude(), poi.getLongitude()};
            model.addRow(rowData);
        }
        view.getSearchResultTable().setModel(model);
        view.getSearchResultTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

}
