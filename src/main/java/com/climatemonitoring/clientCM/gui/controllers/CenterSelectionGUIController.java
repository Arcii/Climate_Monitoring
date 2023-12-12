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

public class CenterSelectionGUIController {

    //FIELDS

    private CenterSelectionGUI view;
    private final ClientManager clientManager;
    private User user;
    private ArrayList<MonitoringCenter> centersList;

    //CONSTRUCTOR

    public CenterSelectionGUIController(CenterSelectionGUI view, User user, ArrayList<MonitoringCenter> centersList) {
        this.view = view;
        this.clientManager = ClientManager.GetClientManager();
        this.user = user;
        this.centersList = centersList;

        setUpTable();

        //ADD Listeners
        AddListeners();
    }

    //GETTER AND SETTER

    public CenterSelectionGUI getView() {
        return view;
    }

    public void setView(CenterSelectionGUI view) {
        this.view = view;
    }

    public ClientManager getClientManager() {
        return clientManager;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<MonitoringCenter> getCentersList() {
        return centersList;
    }

    public void setCentersList(ArrayList<MonitoringCenter> centersList) {
        this.centersList = centersList;
    }

    //PRIVATE ADD LISTENERS METHOD

    private void AddListeners(){

        //Register center button
        view.getCenterRegistrationButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CenterRegistrationGUI form = new CenterRegistrationGUI(getUser(),getCentersList());
                form.setVisible(true);
                view.dispose();
            }
        });

        //Complete Registration button
        view.getCompleteRegistrationButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = view.getCentersTable().getSelectedRow();
                if (selectedRow != -1) {
                    Object selectedCenterId = view.getCentersTable().getValueAt(selectedRow, 0);
                    if (clientManager.registrazione(getUser(), (Integer)selectedCenterId)){
                        System.err.println("Registration Completed with success user : " + getUser().getUserid());
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
                        if(clicked == JOptionPane.OK_OPTION || clicked == JOptionPane.CLOSED_OPTION) {
                            ClientHomeGUI form = new ClientHomeGUI();
                            form.setVisible(true);
                            view.dispose();
                        }else{
                            System.err.println("The user successfully registered but something happened with the JOptionPane.showOptionDialog that should not be possible");
                        }
                    }else {
                        System.err.println("Registration Failed");
                        JOptionPane.showMessageDialog(view, "Registrazione Fallita, provare a ricominciare la procedura di registrazione.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    System.err.println("Button pressed without row selected");
                    JOptionPane.showMessageDialog(view, "Prima di visualizzare i parametri climatici devi selezionare l'area geografica", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        //Back Button
        view.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperatorRegistrationGUI form = new OperatorRegistrationGUI(getUser());
                form.setVisible(true);
                view.dispose();
            }
        });

    }

    //PRIVATE METHODS

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
