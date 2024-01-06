package com.climatemonitoring.clientCM.gui.controllers;

import com.climatemonitoring.clientCM.network.ClientManager;
import com.climatemonitoring.clientCM.gui.views.CenterRegistrationGUI;
import com.climatemonitoring.clientCM.gui.views.CenterSelectionGUI;
import com.climatemonitoring.clientCM.gui.views.ClientHomeGUI;
import com.climatemonitoring.clientCM.gui.views.OperatorRegistrationGUI;
import com.climatemonitoring.shared.models.MonitoringCenter;
import com.climatemonitoring.shared.models.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The `CenterSelectionGUIController` class serves as the controller for the `CenterSelectionGUI` view.
 * It manages user interactions and communicates with the server through the `ClientManager`.
 *
 * @author Lorenzo Cattapan 726459 (Varese)
 * @version 1.0
 * @see CenterSelectionGUI
 */
public class CenterSelectionGUIController {

    //*****************FIELDS*****************//

    /**
     * The associated view for center selection.
     */
    private CenterSelectionGUI view;
    /**
     * The client manager for communication with the server.
     */
    private final ClientManager clientManager;
    /**
     * The user associated with the registration process.
     */
    private User user;
    /**
     * The list of available monitoring centers.
     */
    private ArrayList<MonitoringCenter> centersList;

    //*****************CONSTRUCTOR*****************//

    /**
     * Constructs an instance of the `CenterSelectionGUIController`.
     *
     * @param view        The associated view for center selection.
     * @param user        The user associated with the registration process.
     * @param centersList The list of available monitoring centers.
     */
    public CenterSelectionGUIController(CenterSelectionGUI view, User user, ArrayList<MonitoringCenter> centersList) {
        this.view = view;
        this.clientManager = ClientManager.GetClientManager();
        this.user = user;
        this.centersList = centersList;

        setUpTable();

        //ADD Listeners
        AddListeners();
    }

    //*****************GETTER AND SETTER*****************//

    /**
     * Gets the associated view for center selection.
     *
     * @return The associated view for center selection.
     */
    public CenterSelectionGUI getView() {
        return view;
    }

    /**
     * Sets the associated view for center selection.
     *
     * @param view The associated view to set.
     */
    public void setView(CenterSelectionGUI view) {
        this.view = view;
    }

    /**
     * Gets the client manager for communication with the server.
     *
     * @return The client manager.
     */
    public ClientManager getClientManager() {
        return clientManager;
    }

    /**
     * Gets the user associated with the registration process.
     *
     * @return The user associated with the registration process.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user associated with the registration process.
     *
     * @param user The user to set.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the list of available monitoring centers.
     *
     * @return The list of available monitoring centers.
     */
    public ArrayList<MonitoringCenter> getCentersList() {
        return centersList;
    }

    /**
     * Sets the list of available monitoring centers.
     *
     * @param centersList The list of monitoring centers to set.
     */
    public void setCentersList(ArrayList<MonitoringCenter> centersList) {
        this.centersList = centersList;
    }

    //*****************PRIVATE ADD LISTENERS METHOD*****************//

    /**
     * Adds action listeners to the buttons in the view.
     */
    private void AddListeners(){

        //Register center button
        view.getCenterRegistrationButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the CenterRegistrationGUI form with user and centers list and makes it visible
                CenterRegistrationGUI form = new CenterRegistrationGUI(getUser(),getCentersList());
                form.setVisible(true);
                // Close the current CenterSelectionGUI view
                view.dispose();
            }
        });

        //Complete Registration button
        view.getCompleteRegistrationButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected row in the centers table
                int selectedRow = view.getCentersTable().getSelectedRow();
                if (selectedRow != -1) {
                    // Get the center ID from the selected row
                    Object selectedCenterId = view.getCentersTable().getValueAt(selectedRow, 0);
                    // Attempt to register the user with the selected monitoring center
                    if (clientManager.registrazione(getUser(), (Integer)selectedCenterId)){
                        // Registration successful
                        System.err.println("Registration Completed with success user : " + getUser().getUserid());
                        // Show a success message dialog
                        int clicked = JOptionPane.showOptionDialog(
                                view,
                                "Registrazione completata con successo. Benvenuto in Climate Monitoring operatore : " + getUser().getUserid(),
                                "Alert",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.INFORMATION_MESSAGE,
                                null,
                                new Object[]{"OK"},
                                "OK"
                        );
                        // If the OK button is clicked or the dialog is closed, open the ClientHomeGUI view
                        if(clicked == JOptionPane.OK_OPTION || clicked == JOptionPane.CLOSED_OPTION) {
                            ClientHomeGUI form = new ClientHomeGUI();
                            form.setVisible(true);
                            // Close the current CenterSelectionGUI view
                            view.dispose();
                        }else{
                            // An unexpected situation occurred
                            System.err.println("The user successfully registered but something happened with the JOptionPane.showOptionDialog that should not be possible");
                        }
                    }else {
                        // Registration failed, show an error message dialog
                        System.err.println("Registration Failed");
                        JOptionPane.showMessageDialog(view, "Registrazione Fallita, provare a ricominciare la procedura di registrazione.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    // No row selected, show an alert
                    System.err.println("Button pressed without row selected");
                    JOptionPane.showMessageDialog(view, "Prima di visualizzare i parametri climatici devi selezionare l'area geografica", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        //Back Button
        view.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the OperatorRegistrationGUI form with the current user
                OperatorRegistrationGUI form = new OperatorRegistrationGUI(getUser());
                form.setVisible(true);
                // Close the current CenterSelectionGUI view
                view.dispose();
            }
        });

    }

    //*****************PRIVATE METHODS*****************//

    /**
     * Sets up the JTable displaying available monitoring centers.
     */
    private void setUpTable(){
        // Create a DefaultTableModel with column names
        String[] columnNames = {"ID", "Nome", "Via", "Numero Civico", "CAP", "Città", "Provincia"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Populate the model with PointOfInterest data
        for (MonitoringCenter center : getCentersList()) {
            Object[] rowData = {center.getCenterid(), center.getName(), center.getAddress(), center.getAddressNumber(), center.getCap(), center.getCity(), center.getProvince()};
            model.addRow(rowData);
        }
        view.getCentersTable().setModel(model);
        view.getCentersTable().setDefaultEditor(Object.class,null);
        view.getCentersTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

}
