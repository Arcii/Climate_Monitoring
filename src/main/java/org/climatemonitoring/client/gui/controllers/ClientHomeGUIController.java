package org.climatemonitoring.client.gui.controllers;

import org.climatemonitoring.client.gui.views.ClientHomeGUI;
import org.climatemonitoring.client.gui.views.RegistrationGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientHomeGUIController {

    private ClientHomeGUI view;

    public ClientHomeGUIController(ClientHomeGUI view) {
        this.view = view;

        //ADD Listeners
        AddListeners();
    }

    private void AddListeners(){

        view.getLoginOperatorButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationGUI form = new RegistrationGUI();
                form.setVisible(true);
                view.dispose();
            }
        });

    }

    public ClientHomeGUI getView() {
        return view;
    }

    public void setView(ClientHomeGUI view) {
        this.view = view;
    }

}
