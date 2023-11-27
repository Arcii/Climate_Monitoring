package org.climatemonitoring.client.gui.controllers;

import org.climatemonitoring.client.gui.views.CenterSelectionGUI;
import org.climatemonitoring.client.gui.views.ClientHomeGUI;
import org.climatemonitoring.client.gui.views.OperatorRegistrationGUI;
import org.climatemonitoring.client.network.ClientManager;
import org.climatemonitoring.shared.models.MonitoringCenter;
import org.climatemonitoring.shared.models.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class OperatorRegistrationGUIController {

    private OperatorRegistrationGUI view;
    private final ClientManager clientManager;

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
                String name = view.getNameField().getText();
                String surname = view.getSurnameField().getText();
                String fiscalcode = view.getFiscalCodeField().getText();
                String email = view.getEmailField().getText();
                String userid = view.getUserIdField().getText();
                if(!Objects.equals(name, "") &&
                        !Objects.equals(surname, "") &&
                        !Objects.equals(fiscalcode, "") &&
                        !Objects.equals(email, "") &&
                        !Objects.equals(userid, "") &&
                        view.getPasswordField().getPassword().length != 0 &&
                        view.getConfirmPasswordField().getPassword().length != 0){
                    if((new String(view.getPasswordField().getPassword())).equals(new String(view.getConfirmPasswordField().getPassword()))){
                        if(ClientManager.isOnlyLettersString(name)){
                            if(ClientManager.isOnlyLettersString(surname)){
                                if(ClientManager.isOnlyLettersOrNumbersString(fiscalcode)){
                                    if(ClientManager.isValidEmail(email)){
                                        if(ClientManager.isValidUtf8(userid)){
                                            if(!clientManager.checkUserExists(userid)) {
                                                ArrayList<MonitoringCenter> centersList;
                                                centersList = clientManager.getCentersList();
                                                String hashedpassword = ClientManager.hashPasswordSHA256(view.getPasswordField().getPassword());
                                                CenterSelectionGUI form = new CenterSelectionGUI(new User(name, surname, email, userid, fiscalcode, hashedpassword), centersList);
                                                form.setVisible(true);
                                                view.dispose();
                                            }else{
                                                System.err.println("The Userid is already used by another user in he database.");
                                                JOptionPane.showMessageDialog(view, "L'Username che hai inserito è già in utilizzo da un altro operatore, prova a cambiarlo.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        }else{
                                            System.err.println("Userid inserted has a non valid format.");
                                            JOptionPane.showMessageDialog(view, "L'Username che hai inserito non ha un formato valido, deve essere una stringa UTF-8 valida.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    }else{
                                        System.err.println("Email inserted has a non valid format.");
                                        JOptionPane.showMessageDialog(view, "La mail che hai inserito non ha un formato valido, deve essere del tipo \"user@example.com\" o \"user@example.it\".", "Alert", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }else{
                                    System.err.println("FiscalCode inserted has a non valid format.");
                                    JOptionPane.showMessageDialog(view, "Il Codice Fiscale che hai inserito non ha un formato valido, deve contenere solo lettere e/o numeri.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }else{
                                System.err.println("Surname inserted has a non valid format.");
                                JOptionPane.showMessageDialog(view, "Il Cognome che hai inserito non ha un formato valido, deve contenere solo lettere.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }else {
                            System.err.println("Name inserted has a non valid format.");
                            JOptionPane.showMessageDialog(view, "Il Nome che hai inserito non ha un formato valido, deve contenere solo lettere.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }else{
                        System.err.println("Password and ConfirmationPassword not equal.");
                        JOptionPane.showMessageDialog(view, "I campi Password e Conferma Password contengono due stringhe differenti, controlla di aver inserito la stessa password in entrambi i campi.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    System.err.println("Registration Form fields not filled.");
                    JOptionPane.showMessageDialog(view, "Prima di continuare con la registrazione devi inserire tutti i campi.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
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
