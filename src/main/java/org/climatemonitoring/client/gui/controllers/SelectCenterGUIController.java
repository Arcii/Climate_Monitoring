package org.climatemonitoring.client.gui.controllers;

import org.climatemonitoring.client.gui.views.ConfirmRegistrationGUI;
import org.climatemonitoring.client.gui.views.RegistrationGUI;
import org.climatemonitoring.client.gui.views.SelectCenterGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectCenterGUIController {

    private SelectCenterGUI view;

    public SelectCenterGUIController(SelectCenterGUI view) {
        this.view = view;
    }

    private void AddListeners(){

        view.getSelectCenterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Add selected climate center to user data
                //TODO

                ConfirmRegistrationGUI form = new ConfirmRegistrationGUI();
                form.setVisible(true);
                view.dispose();
            }
        });

        view.getBackToRegistrationButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Go back to user registration data
                RegistrationGUI form = new RegistrationGUI();
                form.setVisible(true);
                view.dispose();
            }
        });

    }

}
