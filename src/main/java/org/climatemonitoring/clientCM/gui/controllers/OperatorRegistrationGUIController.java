package org.climatemonitoring.clientCM.gui.controllers;

import org.climatemonitoring.clientCM.gui.views.CenterSelectionGUI;
import org.climatemonitoring.clientCM.gui.views.ClientHomeGUI;
import org.climatemonitoring.clientCM.gui.views.OperatorRegistrationGUI;
import org.climatemonitoring.clientCM.network.ClientManager;
import org.climatemonitoring.clientCM.utils.FieldFormatException;
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

    public OperatorRegistrationGUI getView() {
        return view;
    }

    public void setView(OperatorRegistrationGUI view) {
        this.view = view;
    }

    public ClientManager getClientManager() {
        return clientManager;
    }

    private void AddListeners(){

        //Continue button
        view.getContinueRegistrationButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String name = view.getNameField().getText().trim();
                    String surname = view.getSurnameField().getText().trim();
                    String fiscalcode = view.getFiscalCodeField().getText().trim();
                    String email = view.getEmailField().getText().trim();
                    String userid = view.getUserIdField().getText().trim();
                    checkOperatorFormFields(name, surname, fiscalcode, email, userid);
                    ArrayList<MonitoringCenter> centersList;
                    centersList = clientManager.getCentersList();
                    String hashedpassword = ClientManager.hashPasswordSHA256(view.getPasswordField().getPassword());
                    CenterSelectionGUI form = new CenterSelectionGUI(new User(name, surname, email, userid, fiscalcode, hashedpassword), centersList);
                    form.setVisible(true);
                    view.dispose();
                } catch (FieldFormatException exc){
                    System.err.println("Catching format Exception.");
                    JOptionPane.showMessageDialog(view, exc.getMessage(), "Alert", JOptionPane.INFORMATION_MESSAGE);
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

    //PRIVATE METHODS

    private void checkOperatorFormFields(String name, String surname, String fiscalcode, String email, String userid) throws FieldFormatException {
        if(!Objects.equals(name, "") &&
                !Objects.equals(surname, "") &&
                !Objects.equals(fiscalcode, "") &&
                !Objects.equals(email, "") &&
                !Objects.equals(userid, "") &&
                view.getPasswordField().getPassword().length != 0 &&
                view.getConfirmPasswordField().getPassword().length != 0){
            if((new String(view.getPasswordField().getPassword())).equals(new String(view.getConfirmPasswordField().getPassword()))){
                if(ClientManager.isOnlyLettersString(name) && name.length() <= 30){
                    if(ClientManager.isOnlyLettersString(surname) && surname.length() <= 30){
                        if(ClientManager.isValidFiscalCode(fiscalcode) && fiscalcode.length() == 16){
                            if(ClientManager.isValidEmail(email) && email.length() <= 80){
                                if(ClientManager.isValidUtf8(userid) && userid.length() <= 30){
                                    if(!clientManager.checkUserExists(userid)) {
                                        System.err.println("Check User fields passed.");
                                    }else{
                                        System.err.println("The Userid is already used by another user in he database.");
                                        throw new FieldFormatException("L'Username che hai inserito è già in utilizzo da un altro operatore, prova a cambiarlo.");
                                    }
                                }else{
                                    System.err.println("Userid inserted has a non valid format or is longer than 30 characters.");
                                    throw new FieldFormatException("L'Username che hai inserito non ha un formato valido, deve essere una stringa UTF-8 valida di massimo 30 caratteri.");
                                }
                            }else{
                                System.err.println("Email inserted has a non valid format or is longer than the maximum (80 char).");
                                throw new FieldFormatException("La mail che hai inserito non ha un formato valido, deve essere del tipo \"user@example.com\" o \"user@example.it\" e massimo di 80 caratteri.");
                            }
                        }else{
                            System.err.println("FiscalCode inserted has a non valid format.");
                            throw new FieldFormatException("Il Codice Fiscale che hai inserito non ha un formato valido, deve contenere solo lettere e/o numeri e deve essere di 16 caratteri.");
                        }
                    }else{
                        System.err.println("Surname inserted has a non valid format.");
                        throw new FieldFormatException("Il Cognome che hai inserito non ha un formato valido, deve contenere solo lettere e un massimo di 30 caratteri.");
                    }
                }else {
                    System.err.println("Name inserted has a non valid format.");
                    throw new FieldFormatException("Il Nome che hai inserito non ha un formato valido, deve contenere solo lettere e un massimo di 30 caratteri.");
                }
            }else{
                System.err.println("Password and ConfirmationPassword not equal.");
                throw new FieldFormatException("I campi Password e Conferma Password contengono due stringhe differenti, controlla di aver inserito la stessa password in entrambi i campi.");
            }
        }else{
            System.err.println("Registration User Form fields not filled.");
            throw new FieldFormatException("Prima di continuare con la registrazione devi inserire tutti i campi.");
        }
    }

}
