package org.climatemonitoring.client.gui.controllers;

import org.climatemonitoring.client.gui.views.ClientHomeGUI;
import org.climatemonitoring.client.gui.views.RegistrationGUI;
import org.climatemonitoring.client.gui.views.SelectCenterGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationGUIController {

    private RegistrationGUI view;

    public RegistrationGUIController(RegistrationGUI view) {
        this.view = view;
    }

    private void AddListeners(){

        view.getBackHomeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Open ClimateMonitoring Home Window
                ClientHomeGUI form = new ClientHomeGUI();
                form.setVisible(true);
                view.dispose();
            }
        });

        view.getGotoCenterSelectionButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Save inserted data
                //TODO

                //Open SelectCentre Window
                SelectCenterGUI form = new SelectCenterGUI();
                form.setVisible(true);
                view.dispose();
            }
        });

    }

}
