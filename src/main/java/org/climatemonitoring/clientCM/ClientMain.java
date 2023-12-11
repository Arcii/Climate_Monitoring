package org.climatemonitoring.clientCM;

import org.climatemonitoring.clientCM.gui.views.ClientHomeGUI;
import org.climatemonitoring.clientCM.network.ClientManager;

public class ClientMain {

    public static void main(String[] args) {
        ClientManager clientManager = new ClientManager();
        ClientHomeGUI form = new ClientHomeGUI();
        form.setVisible(true);

    }

}
