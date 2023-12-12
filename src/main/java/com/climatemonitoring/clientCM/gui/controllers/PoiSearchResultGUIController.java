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

public class PoiSearchResultGUIController {

    //FIELDS

    private PoiSearchResultGUI view;
    private final ClientManager clientManager;
    private ArrayList<PointOfInterest> searchResults;
    private User user;

    //CONSTRUCTOR

    public PoiSearchResultGUIController(PoiSearchResultGUI view, ArrayList<PointOfInterest> searchResults, User user) {
        this.view = view;
        this.clientManager = ClientManager.GetClientManager();
        this.searchResults = searchResults;
        this.user = user;

        setUpTable();

        //ADD Listeners
        AddListeners();
    }

    //GETTER AND SETTER

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //PRIVATE ADD LISTENERS METHOD

    private void AddListeners(){

        view.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

    //PRIVATE METHODS

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
