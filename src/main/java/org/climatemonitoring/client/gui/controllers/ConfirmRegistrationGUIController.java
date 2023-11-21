package org.climatemonitoring.client.gui.controllers;

import org.climatemonitoring.client.gui.views.ConfirmRegistrationGUI;
import org.climatemonitoring.client.gui.views.SelectCenterGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmRegistrationGUIController {

    private ConfirmRegistrationGUI view;

    public ConfirmRegistrationGUIController(ConfirmRegistrationGUI view){
        this.view = view;
    }

    private void AddListeners(){

        view.getBackToSelectCenterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Go back to select climate center
                SelectCenterGUI form = new SelectCenterGUI();
                form.setVisible(true);
                view.dispose();
            }
        });

        view.getConfirmRegistrationButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Complete the registration
                //TODO


            }
        });

    }

}
