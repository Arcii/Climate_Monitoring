package org.climatemonitoring.client;

import org.climatemonitoring.client.gui.views.ClientHomeGUI;
import org.climatemonitoring.client.network.ClientManager;

public class ClientMain {

    public static void main(String[] args) {
        ClientManager clientManager = new ClientManager();
        ClientHomeGUI form = new ClientHomeGUI();
        form.setVisible(true);

    }

}
