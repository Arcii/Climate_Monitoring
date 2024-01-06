package com.climatemonitoring.clientCM.gui.controllers;

import com.climatemonitoring.clientCM.network.ClientManager;
import com.climatemonitoring.clientCM.gui.views.PoiSearchForRegistrationGUI;
import com.climatemonitoring.shared.models.PointOfInterest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Controller class for the Point of Interest (POI) search and creation GUI during Monitoring Center registration.
 * Manages interactions between the PoiSearchForRegistrationGUI view and the underlying data model.
 *
 * @author Lorenzo Cattapan 726459 (Varese)
 * @version 1.0
 * @see PoiSearchForRegistrationGUI
 */
public class PoiSearchForRegistrationGUIController {

    //*****************FIELDS*****************//

    /**
     * Reference to the CenterRegistrationGUIController for coordination with the Center Registration GUI.
     */
    private CenterRegistrationGUIController centerRegistrationGUIController;
    /**
     * Reference to the associated PoiSearchForRegistrationGUI view.
     */
    private PoiSearchForRegistrationGUI view;
    /**
     * ClientManager instance for handling network operations and data retrieval.
     */
    private final ClientManager clientManager;
    /**
     * List of PointOfInterest objects representing the search results.
     */
    private ArrayList<PointOfInterest> searchResults;

    //*****************CONSTRUCTOR*****************//

    /**
     * Constructs the PoiSearchForRegistrationGUIController.
     *
     * @param view Reference to the PoiSearchForRegistrationGUI view.
     * @param centerRegistrationGUIController Reference to the CenterRegistrationGUIController.
     * @param searchResults List of PointOfInterest objects as search results.
     */
    public PoiSearchForRegistrationGUIController(PoiSearchForRegistrationGUI view, CenterRegistrationGUIController centerRegistrationGUIController, ArrayList<PointOfInterest> searchResults){
        this.view = view;
        this.centerRegistrationGUIController = centerRegistrationGUIController;
        this.clientManager = ClientManager.GetClientManager();
        this.searchResults = searchResults;

        // Set up the table with search results
        setUpTable();

        //ADD Listeners
        AddListeners();
    }

    //*****************GETTER AND SETTER*****************//

    /**
     * Getter for the centerRegistrationGUIController field.
     *
     * @return The CenterRegistrationGUIController instance.
     */
    public CenterRegistrationGUIController getCenterRegistrationGUIController() {
        return centerRegistrationGUIController;
    }

    /**
     * Setter for the centerRegistrationGUIController field.
     *
     * @param centerRegistrationGUIController The CenterRegistrationGUIController instance to set.
     */
    public void setCenterRegistrationGUIController(CenterRegistrationGUIController centerRegistrationGUIController) {
        this.centerRegistrationGUIController = centerRegistrationGUIController;
    }

    /**
     * Getter for the view field.
     *
     * @return The associated PoiSearchForRegistrationGUI view.
     */
    public PoiSearchForRegistrationGUI getView() {
        return view;
    }

    /**
     * Setter for the view field.
     *
     * @param view The PoiSearchForRegistrationGUI view to set.
     */
    public void setView(PoiSearchForRegistrationGUI view) {
        this.view = view;
    }

    /**
     * Getter for the clientManager field.
     *
     * @return The ClientManager instance.
     */
    public ClientManager getClientManager() {
        return clientManager;
    }

    /**
     * Getter for the searchResults field.
     *
     * @return The list of PointOfInterest objects representing search results.
     */
    public ArrayList<PointOfInterest> getSearchResults() {
        return searchResults;
    }

    /**
     * Setter for the searchResults field.
     *
     * @param searchResults The list of PointOfInterest objects to set as search results.
     */
    public void setSearchResults(ArrayList<PointOfInterest> searchResults) {
        this.searchResults = searchResults;
    }

    //*****************PRIVATE ADD LISTENERS METHOD*****************//

    /**
     * Adds event listeners for GUI components.
     */
    private void AddListeners(){

        view.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve selected row information from the search result table
                int selectedRow = view.getPoiSearchResultTable().getSelectedRow();
                DefaultTableModel model = (DefaultTableModel) view.getPoiSearchResultTable().getModel();
                int poi_id;
                String name;
                String country;
                float latitude;
                float longitude;
                if (selectedRow != -1) {
                    // Extract data from the selected row
                    poi_id = (int) model.getValueAt(selectedRow, 0);
                    name = (String) model.getValueAt(selectedRow, 1);
                    country = (String) model.getValueAt(selectedRow, 2);
                    latitude = (float) model.getValueAt(selectedRow, 3);
                    longitude = (float) model.getValueAt(selectedRow, 4);
                    // Add the selected POI to the registration table and close the current window
                    getCenterRegistrationGUIController().addRowToTable(new PointOfInterest(poi_id, latitude, longitude, name, country));
                    view.dispose();
                }else{
                    // Display an alert if the "Add" button is pressed without selecting a row
                    System.err.println("Button pressed without row selected");
                    JOptionPane.showMessageDialog(view, "Prima di visualizzare i parametri climatici devi selezionare l'area geografica", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        view.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current window
                view.dispose();
            }
        });

        view.getCreatePoiButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Retrieve user input for creating a new POI
                    String latitude = view.getLatitudeField().getText().trim();
                    String longitude = view.getLongitudeField().getText().trim();
                    String name = view.getNameField().getText().trim();
                    String country = view.getCountryField().getText().trim();
                    // Validate and add the new POI to the registration table, then close the current window
                    if(!name.isEmpty() && !country.isEmpty() && !latitude.isEmpty() && !longitude.isEmpty()){
                        if(ClientManager.isAsciiString(name)){
                            if(ClientManager.isAsciiString(country)){
                                float lat = Float.parseFloat(latitude);
                                float lon = Float.parseFloat(longitude);
                                getCenterRegistrationGUIController().addRowToTable(new PointOfInterest(0, lat, lon, name, country));
                                view.dispose();
                            }else{
                                // Display an alert if the country format is not valid
                                System.err.println("Poi country format not valid.");
                                JOptionPane.showMessageDialog(view, "Lo stato dell'area che si vuole creare non ha un formato valido,può contenere solo caratteri ASCII", "Alert", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }else{
                            // Display an alert if the name format is not valid
                            System.err.println("Poi name format not valid.");
                            JOptionPane.showMessageDialog(view, "Il nome dell'area che si vuole creare non ha un formato valido, può contenere solo caratteri ASCII", "Alert", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }else{
                        // Display an alert if any required field is empty
                        System.err.println("Fields are empty.");
                        JOptionPane.showMessageDialog(view, "Prima di procedere a creare un'area devi riempire tutti i campi necessari.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch (NumberFormatException exc){
                    // Display an alert if the coordinates format is not valid
                    System.err.println("Coordinates format not valid");
                    JOptionPane.showMessageDialog(view, "Formato coordinate non valido, ogni latitudine o longitudine deve essere indicata come un numero decimale separato da un punto (ex. 45.23456)", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

    }

    //*****************PRIVATE METHODS*****************//

    /**
     * Sets up the JTable with search results.
     */
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
