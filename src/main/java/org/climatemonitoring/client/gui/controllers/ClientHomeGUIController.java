package org.climatemonitoring.client.gui.controllers;

import org.climatemonitoring.client.gui.views.ClientHomeGUI;
import org.climatemonitoring.client.gui.views.OperatorHomeGUI;
import org.climatemonitoring.client.gui.views.OperatorRegistrationGUI;
import org.climatemonitoring.client.gui.views.PoiSearchResultGUI;
import org.climatemonitoring.client.network.ClientManager;
import org.climatemonitoring.shared.models.PointOfInterest;
import org.climatemonitoring.shared.models.User;

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

        view.getSignUpButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperatorRegistrationGUI form = new OperatorRegistrationGUI();
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
                    JOptionPane.showMessageDialog(view, "I campi Nome e/o Stato dell'area che vuoi cercare non sono stati inseriti.", "Alert", JOptionPane.INFORMATION_MESSAGE);
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
                        JOptionPane.showMessageDialog(view, "Formato Nome o Stato non valido, entrambi i campi devono contenere caratteri ASCII.", "Alert", JOptionPane.INFORMATION_MESSAGE);
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
                    JOptionPane.showMessageDialog(view, "Formato coordinate non valido, ogni latitudine o longitudine deve essere indicata come un numero decimale separato da un punto (ex. 45.23456)", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        view.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userid = view.getUsernameField().getText().trim();
                if(!userid.isEmpty() && view.getPasswordField().getPassword().length != 0) {
                    if (ClientManager.isValidUtf8(userid)) {
                        String hashedpassword = ClientManager.hashPasswordSHA256(view.getPasswordField().getPassword());
                        User user =clientManager.userLogin(userid,hashedpassword);
                        if(user != null){
                            OperatorHomeGUI form = new OperatorHomeGUI();
                            form.setVisible(true);
                            view.dispose();
                        }else{
                            System.err.println("Login failed.");
                            JOptionPane.showMessageDialog(view, "Il login è fallito, controlla di aver inserito username e password corretti", "Alert", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }else{
                        System.out.println("Check UTF-8 on username failed.");
                        JOptionPane.showMessageDialog(view, "Hai inserito un username che non può essere corretto (ogni username è una stringa UTF-8 valida)", "Alert", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    System.err.println("Empty field username and/or password");
                    JOptionPane.showMessageDialog(view, "I campi username e/o password non sono stati inseriti.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

    }

}
