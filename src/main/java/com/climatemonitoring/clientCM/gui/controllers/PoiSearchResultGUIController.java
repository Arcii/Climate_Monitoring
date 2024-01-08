package com.climatemonitoring.clientCM.gui.controllers;

import com.climatemonitoring.clientCM.network.ClientManager;
import com.climatemonitoring.shared.models.SurveysAggregate;
import com.climatemonitoring.clientCM.gui.views.ClientHomeGUI;
import com.climatemonitoring.clientCM.gui.views.OperatorHomeGUI;
import com.climatemonitoring.clientCM.gui.views.PoiDataGUI;
import com.climatemonitoring.clientCM.gui.views.PoiSearchResultGUI;
import com.climatemonitoring.shared.models.PointOfInterest;
import com.climatemonitoring.shared.models.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Controller class for managing the interaction between the <code>PoiSearchResultGUI</code> view and the underlying data.
 * Handles the display of search results, user actions, and navigation.
 *
 * @author Lorenzo Cattapan 726459 (Varese)
 * @version 0.9.0
 * @see PoiSearchResultGUI
 */
public class PoiSearchResultGUIController {

    //*****************FIELDS*****************//

    /**
     * The associated PoiSearchResultGUI view.
     */
    private PoiSearchResultGUI view;
    /**
     * The client manager responsible for communication with the server.
     */
    private final ClientManager clientManager;
    /**
     * The list of PointOfInterest objects representing the search results.
     */
    private ArrayList<PointOfInterest> searchResults;
    /**
     * The User object representing the current user. Null if the user is a guest.
     */
    private User user;

    //*****************CONSTRUCTOR*****************//

    /**
     * Constructs a new instance of PoiSearchResultGUIController.
     *
     * @param view          The PoiSearchResultGUI view associated with this controller.
     * @param searchResults The list of PointOfInterest objects representing the search results.
     * @param user          The User object representing the current user. Null for guest users.
     */
    public PoiSearchResultGUIController(PoiSearchResultGUI view, ArrayList<PointOfInterest> searchResults, User user) {
        this.view = view;
        this.clientManager = ClientManager.GetClientManager();
        this.searchResults = searchResults;
        this.user = user;

        // Set up the table with search results.
        setUpTable();

        //ADD Listeners
        AddListeners();
    }

    //*****************GETTER AND SETTER*****************//

    /**
     * Gets the associated PoiSearchResultGUI view.
     *
     * @return The PoiSearchResultGUI view.
     */
    public PoiSearchResultGUI getView() {
        return view;
    }

    /**
     * Sets the associated PoiSearchResultGUI view.
     *
     * @param view The PoiSearchResultGUI view to set.
     */
    public void setView(PoiSearchResultGUI view) {
        this.view = view;
    }

    /**
     * Gets the client manager responsible for communication with the server.
     *
     * @return The ClientManager object.
     */
    public ClientManager getClientManager() {
        return clientManager;
    }

    /**
     * Gets the list of PointOfInterest objects representing the search results.
     *
     * @return The list of PointOfInterest objects.
     */
    public ArrayList<PointOfInterest> getSearchResults() {
        return searchResults;
    }

    /**
     * Sets the list of PointOfInterest objects representing the search results.
     *
     * @param searchResults The list of PointOfInterest objects to set.
     */
    public void setSearchResults(ArrayList<PointOfInterest> searchResults) {
        this.searchResults = searchResults;
    }

    /**
     * Gets the User object representing the current user. Null if the user is a guest.
     *
     * @return The User object.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the User object representing the current user. Null for guest users.
     *
     * @param user The User object to set.
     */
    public void setUser(User user) {
        this.user = user;
    }

    //*****************PRIVATE ADD LISTENERS METHOD*****************//

    /**
     * Adds listeners for user actions on the PoiSearchResultGUI view.
     */
    private void AddListeners(){

        // Add listener for the "Back" button.
        view.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navigate back to the appropriate home screen based on the user type.
                if(getUser() == null) {
                    ClientHomeGUI form = new ClientHomeGUI();
                    form.setVisible(true);
                    view.dispose();
                }else{
                    OperatorHomeGUI form = new OperatorHomeGUI(getUser());
                    form.setVisible(true);
                    view.dispose();
                }
            }
        });

        // Add listener for the "Select POI" button.
        view.getSelectPoiButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = view.getSearchResultTable().getSelectedRow();
                if (selectedRow != -1) {
                    Object selectedPoi = view.getSearchResultTable().getValueAt(selectedRow, 0);
                    SurveysAggregate result = clientManager.visualizzaAreaGeografica((Integer)selectedPoi);
                    if(result != null) {
                        if (getUser() == null) {
                            PoiDataGUI form = new PoiDataGUI(result, searchResults);
                            form.setVisible(true);
                            view.dispose();
                        } else {
                            PoiDataGUI form = new PoiDataGUI(result, searchResults, getUser());
                            form.setVisible(true);
                            view.dispose();
                        }
                    }else{
                        System.err.println("No surveys for Poi selected");
                        JOptionPane.showMessageDialog(view, "Non sono presenti parametri climatici per quest'area.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    System.err.println("Button pressed without row selected");
                    JOptionPane.showMessageDialog(view, "Non hai selezionato l'area che vuoi aggiungere, selezionala nella tabella prima di premere \"Aggiungi Area\".", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    //*****************PRIVATE METHODS*****************//

    /**
     * Sets up the JTable with search results in the PoiSearchResultGUI view.
     */
    private void setUpTable(){
        String[] columnNames = {"ID", "Nome", "Stato", "Latitudine", "Longitudine"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (PointOfInterest poi : getSearchResults()) {
            Object[] rowData = {poi.getPoi_id(), poi.getName(), poi.getCountry(), poi.getLatitude(), poi.getLongitude()};
            model.addRow(rowData);
        }
        view.getSearchResultTable().setModel(model);
        view.getSearchResultTable().setDefaultEditor(Object.class,null);
        view.getSearchResultTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

}
