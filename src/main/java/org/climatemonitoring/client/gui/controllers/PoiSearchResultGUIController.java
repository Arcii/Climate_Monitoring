package org.climatemonitoring.client.gui.controllers;

import org.climatemonitoring.client.gui.views.ClientHomeGUI;
import org.climatemonitoring.client.gui.views.PoiSearchResultGUI;
import org.climatemonitoring.client.network.ClientManager;
import org.climatemonitoring.shared.models.PointOfInterest;

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

    }

    public PoiSearchResultGUI getView() {
        return view;
    }

    public void setView(PoiSearchResultGUI view) {
        this.view = view;
    }

    public ArrayList<PointOfInterest> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(ArrayList<PointOfInterest> searchResults) {
        this.searchResults = searchResults;
    }

}
