package org.climatemonitoring.client.gui.controllers;

import org.climatemonitoring.client.gui.views.ClientHomeGUI;
import org.climatemonitoring.client.gui.views.PoiSearchResultGUI;
import org.climatemonitoring.client.gui.views.RegistrationGUI;
import org.climatemonitoring.client.network.ClientManager;
import org.climatemonitoring.shared.models.PointOfInterest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class ClientHomeGUIController {

    private ClientHomeGUI view;
    private final ClientManager clientManager;

    public ClientHomeGUIController(ClientHomeGUI view) {
        this.view = view;
        this.clientManager = ClientManager.GetClientManager();

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

        view.getCercaPerDenominazioneButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = view.getNameField().getText().trim();
                String country = view.getStateField().getText().trim();
                if(name.isEmpty() || country.isEmpty()){
                    System.err.println("No input for Name or Country");
                    JOptionPane.showMessageDialog(view, "No input for Name or Country", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }else {
                    String asciiRegex = "\\A\\p{ASCII}*\\z";
                    Pattern pattern = Pattern.compile(asciiRegex);
                    if (pattern.matcher(name).matches() && pattern.matcher(country).matches()) {
                        ArrayList<PointOfInterest> result = clientManager.cercaAreaGeograficaNome(name, country);
                        PoiSearchResultGUI form = new PoiSearchResultGUI(result);
                        form.setVisible(true);
                        view.dispose();
                    } else {
                        System.err.println("Name or Country format not valid");
                        JOptionPane.showMessageDialog(view, "Name or Country format not valid", "Alert", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        view.getCoordinatesSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float latitude;
                float longitude;
                try {
                    latitude = Float.parseFloat(view.getLatitudeField().getText().trim());
                    longitude = Float.parseFloat(view.getLongitudeField().getText().trim());
                    ArrayList<PointOfInterest> result = clientManager.cercaAreaGeograficaCoordinate(latitude, longitude);
                    PoiSearchResultGUI form = new PoiSearchResultGUI(result);
                    form.setVisible(true);
                    view.dispose();
                }catch (NumberFormatException exc){
                    System.err.println("Coordinates format not valid");
                    JOptionPane.showMessageDialog(view, "Coordinates format not valid", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
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
