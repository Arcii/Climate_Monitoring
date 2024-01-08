package com.climatemonitoring.clientCM.gui.controllers;

import com.climatemonitoring.clientCM.network.ClientManager;
import com.climatemonitoring.clientCM.utils.FieldFormatException;
import com.climatemonitoring.clientCM.gui.views.CenterSelectionGUI;
import com.climatemonitoring.clientCM.gui.views.ClientHomeGUI;
import com.climatemonitoring.clientCM.gui.views.OperatorRegistrationGUI;
import com.climatemonitoring.shared.models.MonitoringCenter;
import com.climatemonitoring.shared.models.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

/**
 * The <code>OperatorRegistrationGUIController</code> class serves as the controller for the Operator <code>Registration GUI</code>.
 * It manages user interactions and communicates with the server side of the application through the <code>ClientManager</code>.
 *
 * @author Lorenzo Cattapan 726459 (Varese)
 * @version 0.9.0
 * @see OperatorRegistrationGUI
 * @see ClientManager
 */
public class OperatorRegistrationGUIController {

    //*****************FIELDS*****************//

    /**
     * The associated OperatorRegistrationGUI view.
     */
    private OperatorRegistrationGUI view;
    /**
     * The ClientManager singleton instance for handling network interactions.
     */
    private final ClientManager clientManager;

    //*****************CONSTRUCTOR*****************//

    /**
     * Constructs an instance of OperatorRegistrationGUIController.
     *
     * @param view The OperatorRegistrationGUI view to be associated with the controller.
     */
    public OperatorRegistrationGUIController(OperatorRegistrationGUI view) {
        this.view = view;
        this.clientManager = ClientManager.GetClientManager();

        //ADD Listeners
        AddListeners();
    }

    //*****************GETTER AND SETTER*****************//

    /**
     * Gets the associated OperatorRegistrationGUI view.
     *
     * @return The OperatorRegistrationGUI view.
     */
    public OperatorRegistrationGUI getView() {
        return view;
    }

    /**
     * Sets the associated OperatorRegistrationGUI view.
     *
     * @param view The OperatorRegistrationGUI view to be set.
     */
    public void setView(OperatorRegistrationGUI view) {
        this.view = view;
    }

    /**
     * Gets the ClientManager singleton instance associated with the controller.
     *
     * @return The ClientManager instance.
     */
    public ClientManager getClientManager() {
        return clientManager;
    }

    //*****************PRIVATE ADD LISTENERS METHOD*****************//

    /**
     * Adds listeners to the relevant components in the OperatorRegistrationGUI.
     */
    private void AddListeners(){

        //Continue Button Listener
        view.getContinueRegistrationButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    // Extract user input from the view
                    String name = view.getNameField().getText().trim();
                    String surname = view.getSurnameField().getText().trim();
                    String fiscalcode = view.getFiscalCodeField().getText().trim();
                    String email = view.getEmailField().getText().trim();
                    String userid = view.getUserIdField().getText().trim();

                    // Validate and process the user input
                    checkOperatorFormFields(name, surname, fiscalcode, email, userid);

                    // Retrieve the list of monitoring centers from the client manager
                    ArrayList<MonitoringCenter> centersList;
                    centersList = clientManager.getCentersList();

                    // Hash the password and create a new CenterSelectionGUI where the operator will select or create his Monitoring Center
                    String hashedpassword = ClientManager.hashPasswordSHA256(view.getPasswordField().getPassword());
                    CenterSelectionGUI form = new CenterSelectionGUI(new User(name, surname, email, userid, fiscalcode, hashedpassword), centersList);

                    // Make the new form visible and dispose of the current view
                    form.setVisible(true);
                    view.dispose();
                } catch (FieldFormatException exc){
                    // Handle field format exceptions
                    System.err.println("Catching format Exception.");
                    JOptionPane.showMessageDialog(view, exc.getMessage(), "Alert", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

        //Back Button Listener
        view.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navigate back to the ClientHomeGUI
                ClientHomeGUI form = new ClientHomeGUI();
                form.setVisible(true);
                view.dispose();
            }
        });

    }

    //*****************PRIVATE METHODS*****************//

    /**
     * Validates the operator registration form fields.
     *
     * @param name The operator's name.
     * @param surname The operator's surname.
     * @param fiscalcode The operator's fiscal code.
     * @param email The operator's email.
     * @param userid The operator's username.
     * @throws FieldFormatException If any field format is invalid.
     */
    private void checkOperatorFormFields(String name, String surname, String fiscalcode, String email, String userid) throws FieldFormatException {
        // Validate each field individually
        if(!Objects.equals(name, "") &&
                !Objects.equals(surname, "") &&
                !Objects.equals(fiscalcode, "") &&
                !Objects.equals(email, "") &&
                !Objects.equals(userid, "") &&
                view.getPasswordField().getPassword().length != 0 &&
                view.getConfirmPasswordField().getPassword().length != 0){
            //Validate if the two passwords fields are equals
            if((new String(view.getPasswordField().getPassword())).equals(new String(view.getConfirmPasswordField().getPassword()))){
                // Validate name format and length
                if(ClientManager.isOnlyLettersString(name) && name.length() <= 30){
                    // Validate surname format and length
                    if(ClientManager.isOnlyLettersString(surname) && surname.length() <= 30){
                        // Validate fiscal code format and length
                        if(ClientManager.isValidFiscalCode(fiscalcode) && fiscalcode.length() == 16){
                            // Validate email format and length
                            if(ClientManager.isValidEmail(email) && email.length() <= 80){
                                // Validate username format and length
                                if(ClientManager.isValidUtf8(userid) && userid.length() <= 30){
                                    // Check if the user already exists
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
