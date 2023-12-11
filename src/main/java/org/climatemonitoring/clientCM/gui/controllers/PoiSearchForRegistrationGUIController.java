package org.climatemonitoring.clientCM.gui.controllers;

import org.climatemonitoring.clientCM.gui.views.PoiSearchForRegistrationGUI;
import org.climatemonitoring.clientCM.network.ClientManager;
import org.climatemonitoring.shared.models.PointOfInterest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PoiSearchForRegistrationGUIController {

    private CenterRegistrationGUIController centerRegistrationGUIController;
    private PoiSearchForRegistrationGUI view;
    private final ClientManager clientManager;
    private ArrayList<PointOfInterest> searchResults;

    public PoiSearchForRegistrationGUIController(PoiSearchForRegistrationGUI view, CenterRegistrationGUIController centerRegistrationGUIController, ArrayList<PointOfInterest> searchResults){
        this.view = view;
        this.centerRegistrationGUIController = centerRegistrationGUIController;
        this.clientManager = ClientManager.GetClientManager();
        this.searchResults = searchResults;

        setUpTable();

        //ADD Listeners
        AddListeners();
    }

    public CenterRegistrationGUIController getCenterRegistrationGUIController() {
        return centerRegistrationGUIController;
    }

    public void setCenterRegistrationGUIController(CenterRegistrationGUIController centerRegistrationGUIController) {
        this.centerRegistrationGUIController = centerRegistrationGUIController;
    }

    public PoiSearchForRegistrationGUI getView() {
        return view;
    }

    public void setView(PoiSearchForRegistrationGUI view) {
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

    private void AddListeners(){

        view.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = view.getPoiSearchResultTable().getSelectedRow();
                DefaultTableModel model = (DefaultTableModel) view.getPoiSearchResultTable().getModel();
                int poi_id;
                String name;
                String country;
                float latitude;
                float longitude;
                if (selectedRow != -1) {
                    poi_id = (int) model.getValueAt(selectedRow, 0);
                    name = (String) model.getValueAt(selectedRow, 1);
                    country = (String) model.getValueAt(selectedRow, 2);
                    latitude = (float) model.getValueAt(selectedRow, 3);
                    longitude = (float) model.getValueAt(selectedRow, 4);
                    getCenterRegistrationGUIController().addRowToTable(new PointOfInterest(poi_id, latitude, longitude, name, country));
                    view.dispose();
                }else{
                    System.err.println("Button pressed without row selected");
                    JOptionPane.showMessageDialog(view, "Prima di visualizzare i parametri climatici devi selezionare l'area geografica", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        view.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });

        view.getCreatePoiButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String latitude = view.getLatitudeField().getText().trim();
                    String longitude = view.getLongitudeField().getText().trim();
                    String name = view.getNameField().getText().trim();
                    String country = view.getCountryField().getText().trim();
                    if(!name.isEmpty() && !country.isEmpty() && !latitude.isEmpty() && !longitude.isEmpty()){
                        if(ClientManager.isAsciiString(name)){
                            if(ClientManager.isAsciiString(country)){
                                float lat = Float.parseFloat(latitude);
                                float lon = Float.parseFloat(longitude);
                                getCenterRegistrationGUIController().addRowToTable(new PointOfInterest(0, lat, lon, name, country));
                                view.dispose();
                            }else{
                                System.err.println("Poi country format not valid.");
                                JOptionPane.showMessageDialog(view, "Lo stato dell'area che si vuole creare non ha un formato valido,può contenere solo caratteri ASCII", "Alert", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }else{
                            System.err.println("Poi name format not valid.");
                            JOptionPane.showMessageDialog(view, "Il nome dell'area che si vuole creare non ha un formato valido, può contenere solo caratteri ASCII", "Alert", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }else{
                        System.err.println("Fields are empty.");
                        JOptionPane.showMessageDialog(view, "Prima di procedere a creare un'area devi riempire tutti i campi necessari.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch (NumberFormatException exc){
                    System.err.println("Coordinates format not valid");
                    JOptionPane.showMessageDialog(view, "Formato coordinate non valido, ogni latitudine o longitudine deve essere indicata come un numero decimale separato da un punto (ex. 45.23456)", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

    }

    //PRIVATE METHODS

    private void setUpTable(){
        String[] columnNames = {"ID", "Nome", "Stato", "Latitudine", "Longitudine"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (PointOfInterest poi : getSearchResults()) {
            Object[] rowData = {poi.getPoi_id(), poi.getName(), poi.getCountry(), poi.getLatitude(), poi.getLongitude()};
            model.addRow(rowData);
        }
        view.getPoiSearchResultTable().setModel(model);
        view.getPoiSearchResultTable().setDefaultEditor(Object.class,null);
        view.getPoiSearchResultTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

}
