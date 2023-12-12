package com.climatemonitoring.clientCM;

import com.climatemonitoring.clientCM.gui.views.ClientHomeGUI;
import com.climatemonitoring.clientCM.network.ClientManager;

public class ClientMain {

    public static void main(String[] args) {

        ClientManager clientManager = ClientManager.GetClientManager();
        ClientHomeGUI form = new ClientHomeGUI();
        form.setVisible(true);

    }

}
