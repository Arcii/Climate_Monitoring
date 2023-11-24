package org.climatemonitoring.client.gui.controllers;

import org.climatemonitoring.client.gui.views.OperatorLoginGUI;
import org.climatemonitoring.client.network.ClientManager;

public class OperatorLoginGUIController {

    private OperatorLoginGUI view;
    private final ClientManager clientManager;

    public OperatorLoginGUIController(OperatorLoginGUI view) {
        this.view = view;
        this.clientManager = ClientManager.GetClientManager();

        //ADD Listeners
        AddListeners();
    }

    private void AddListeners(){

    }

    public OperatorLoginGUI getView() {
        return view;
    }

    public void setView(OperatorLoginGUI view) {
        this.view = view;
    }

    public ClientManager getClientManager() {
        return clientManager;
    }

}
