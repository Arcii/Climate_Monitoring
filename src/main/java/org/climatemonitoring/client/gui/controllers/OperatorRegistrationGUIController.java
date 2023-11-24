package org.climatemonitoring.client.gui.controllers;

import org.climatemonitoring.client.gui.views.ClientHomeGUI;
import org.climatemonitoring.client.gui.views.OperatorRegistrationGUI;
import org.climatemonitoring.client.network.ClientManager;
import org.climatemonitoring.shared.models.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class OperatorRegistrationGUIController {

    private OperatorRegistrationGUI view;
    private final ClientManager clientManager;

    private static final Pattern UTF8_PATTERN = Pattern.compile(
            "([\\x09\\x0A\\x0D\\x20-\\x7E]" +                   // ASCII
                    "|[\\xC2-\\xDF][\\x80-\\xBF]" +                   // non-overlong 2-byte
                    "|\\xE0[\\xA0-\\xBF][\\x80-\\xBF]" +              // excluding overlongs
                    "|[\\xE1-\\xEC\\xEE\\xEF][\\x80-\\xBF]{2}" +      // straight 3-byte
                    "|\\xED[\\x80-\\x9F][\\x80-\\xBF]" +              // excluding surrogates
                    "|\\xF0[\\x90-\\xBF][\\x80-\\xBF]{2}" +           // planes 1-3
                    "|[\\xF1-\\xF3][\\x80-\\xBF]{3}" +                // planes 4-15
                    "|\\xF4[\\x80-\\x8F][\\x80-\\xBF]{2})"
    );

    public OperatorRegistrationGUIController(OperatorRegistrationGUI view) {
        this.view = view;
        this.clientManager = ClientManager.GetClientManager();

        //ADD Listeners
        AddListeners();
    }

    private void AddListeners(){

        //Continue button
        view.getContinueRegistrationButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });

        //Back Button
        view.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientHomeGUI form = new ClientHomeGUI();
                form.setVisible(true);
                view.dispose();
            }
        });

    }

    public OperatorRegistrationGUI getView() {
        return view;
    }

    public void setView(OperatorRegistrationGUI view) {
        this.view = view;
    }

    public ClientManager getClientManager() {
        return clientManager;
    }

}
