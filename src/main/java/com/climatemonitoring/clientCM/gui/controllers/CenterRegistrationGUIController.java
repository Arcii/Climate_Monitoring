package com.climatemonitoring.clientCM.gui.controllers;

import com.climatemonitoring.clientCM.gui.views.CenterRegistrationGUI;
import com.climatemonitoring.clientCM.gui.views.CenterSelectionGUI;
import com.climatemonitoring.clientCM.gui.views.ClientHomeGUI;
import com.climatemonitoring.clientCM.gui.views.PoiSearchForRegistrationGUI;
import com.climatemonitoring.clientCM.network.ClientManager;
import com.climatemonitoring.clientCM.utils.FieldFormatException;
import com.climatemonitoring.shared.models.MonitoringCenter;
import com.climatemonitoring.shared.models.PointOfInterest;
import com.climatemonitoring.shared.models.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Controller class for the <code>CenterRegistrationGUI</code> view.
 * Handles user interactions and manages data flow between the view and the <code>ClientManager</code>.
 *
 * @author Lorenzo Cattapan 726459 (Varese)
 * @version 0.9.0
 * @see ClientManager
 */
public class CenterRegistrationGUIController {

    //*****************FIELDS*****************//

    /**
     * Reference to the associated CenterRegistrationGUI view.
     */
    private CenterRegistrationGUI view;
    /**
     * Reference to the ClientManager instance for managing client operations.
     */
    private final ClientManager clientManager;
    /**
     * Table model for managing data displayed in the GUI table.
     */
    private DefaultTableModel tableModel;
    /**
     * User associated with the current session or operation.
     */
    private User user;
    /**
     * List of MonitoringCenter objects associated with the user.
     */
    private ArrayList<MonitoringCenter> centersList;

    //*****************CONSTRUCTOR*****************//

    /**
     * Constructor for the CenterRegistrationGUIController.
     *
     * @param view The associated CenterRegistrationGUI view.
     * @param user The user associated with the registration process.
     * @param centersList The list of monitoring centers.
     */
    public CenterRegistrationGUIController(CenterRegistrationGUI view, User user, ArrayList<MonitoringCenter> centersList) {
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
     * Getter for the associated CenterRegistrationGUI view.
     *
     * @return The CenterRegistrationGUI view.
     */
    public CenterRegistrationGUI getView() {
        return view;
    }

    /**
     * Setter for the associated CenterRegistrationGUI view.
     *
     * @param view The CenterRegistrationGUI view to set.
     */
    public void setView(CenterRegistrationGUI view) {
        this.view = view;
    }

    /**
     * Getter for the client manager.
     *
     * @return The client manager.
     */
    public ClientManager getClientManager() {
        return clientManager;
    }

    /**
     * Getter for the user associated with the registration process.
     *
     * @return The user.
     */
    public User getUser() {
        return user;
    }

    /**
     * Setter for the user associated with the registration process.
     *
     * @param user The user to set.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Getter for the list of monitoring centers.
     *
     * @return The list of monitoring centers.
     */
    public ArrayList<MonitoringCenter> getCentersList() {
        return centersList;
    }

    /**
     * Setter for the list of monitoring centers.
     *
     * @param centersList The list of monitoring centers to set.
     */
    public void setCentersList(ArrayList<MonitoringCenter> centersList) {
        this.centersList = centersList;
    }

    /**
     * Getter for the table model.
     *
     * @return The table model.
     */
    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    /**
     * Setter for the table model.
     *
     * @param tableModel The table model to set.
     */
    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    /**
     * Getter for the CenterRegistrationGUIController itself.
     *
     * @return The CenterRegistrationGUIController instance.
     */
    public CenterRegistrationGUIController getController(){
        return this;
    }

    //*****************PRIVATE ADD LISTENERS METHOD*****************//

    /**
     * Adds listeners for the GUI components.
     */
    private void AddListeners(){

        //Search Poi Button
        view.getCoordinatesSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float latitude;
                float longitude;
                try {
                    // Get latitude and longitude from input fields
                    latitude = Float.parseFloat(view.getLatitudeField().getText().trim());
                    longitude = Float.parseFloat(view.getLongitudeField().getText().trim());

                    // Call clientManager to search for Points of Interest based on coordinates
                    ArrayList<PointOfInterest> result = clientManager.cercaAreaGeograficaCoordinate(latitude, longitude);

                    // Open a new window to display search results
                    PoiSearchForRegistrationGUI form = new PoiSearchForRegistrationGUI(getController(), result);
                    form.setVisible(true);
                }catch (NumberFormatException exc){
                    // Handle invalid coordinates format
                    System.err.println("Coordinates format not valid");
                    JOptionPane.showMessageDialog(view, "Formato coordinate non valido, ogni latitudine o longitudine deve essere indicata come un numero decimale separato da un punto (ex. 45.23456)", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        //Complete Center Registration button
        view.getCompleteCenterRegistrationButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve input data for center registration
                String name = view.getNameField().getText().trim();
                String address = view.getAddressField().getText().trim();
                String addressnumber = view.getAddressNumberFIeld().getText().trim();
                String cap = view.getCapField().getText().trim();
                String city = view.getCityField().getText().trim();
                String province = view.getProvinceField().getText().trim();
                try{
                    // Validate numeric fields
                    Integer.parseInt(addressnumber);
                    Integer.parseInt(cap);

                    // Check the validity of the center registration form fields
                    checkCenterFormFields(name,address,addressnumber,cap,city,province);

                    // Check if the center with the same information already exists
                    if(getClientManager().checkCenterExists(name,address,addressnumber,cap,city,province)<0){
                        if(getTableModel().getRowCount() != 0){
                            try{
                                //INSERT POI LIST
                                ArrayList<PointOfInterest> poiList = getPoiList();
                                poiList = getClientManager().insertPois(poiList);
                                updateTable(poiList);

                                //INSERT CENTER
                                MonitoringCenter center = new MonitoringCenter(name,address,Integer.parseInt(addressnumber),Integer.parseInt(cap),city,province);
                                int createdCenterId = getClientManager().registraCentroAree(center);
                                if(createdCenterId<=0){
                                    // Handle center creation failure
                                    System.err.println("Exception in ClientManager completeRegistrationCenter().");
                                    throw new Exception("Si è riscontrato un problema con la creazione del centro, riprovare a confermare o iniziare dall'inizio la procedura di registrazione.");
                                }
                                center.setCenterid(createdCenterId);

                                //INSERT CENTER_POIS LINKS
                                getClientManager().linkCenterToPois(center, poiList);

                                //INSERT NEW USER AND COMPLETE REGISTRATION
                                boolean userCreated = getClientManager().registrazione(getUser(),createdCenterId);
                                if(userCreated) {
                                    // Handle successful registration
                                    System.err.println("Registration Completed with success user : " + getUser().getUserid());
                                    int clicked = JOptionPane.showOptionDialog(
                                            view,
                                            "Registrazione del centro e dell'operatore completata con successo. Benvenuto in Climate Monitoring operatore : " + getUser().getUserid(),
                                            "Alert",
                                            JOptionPane.DEFAULT_OPTION,
                                            JOptionPane.INFORMATION_MESSAGE,
                                            null,
                                            new Object[]{"OK"},
                                            "OK"
                                    );
                                    if (clicked == JOptionPane.OK_OPTION || clicked == JOptionPane.CLOSED_OPTION) {
                                        // Navigate to the home screen
                                        ClientHomeGUI form = new ClientHomeGUI();
                                        form.setVisible(true);
                                        view.dispose();
                                    }else{
                                        System.err.println("The user successfully registered but something happened with the JOptionPane.showOptionDialog that should not be possible");
                                    }
                                }else {
                                    // Handle user registration failure
                                    System.err.println("Registration Failed");
                                    JOptionPane.showMessageDialog(view, "Il centro è stato registrato correttamente ma si è verificato un errore nella registrazione dell'operatore, provare a ricominciare la procedura di registrazione e selezionare il centro creato nella lista dei centri registrati.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }catch (Exception exc){
                                // Handle exceptions during center registration completion
                                System.err.println("Exception in completion of center registration.");
                                JOptionPane.showMessageDialog(view, exc.getMessage(), "Alert", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }else{
                            // Handle empty POIs list
                            System.err.println("POIs list empty, can't create a center without pois.");
                            JOptionPane.showMessageDialog(view, "Non hai aggiunto nessuna Area nella lista delle aree che il centro vuole monitorare, non è possibile completare la registrazione di un centro senza almeno un area da monitorare.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }else{
                        // Handle existing monitoring center with the same info
                        System.err.println("Monitoring Center with exact same info already exists.");
                        JOptionPane.showMessageDialog(view, "Un centro con le stesse esatte informazioni è già registrato, controlla di aver inserito i dati corretti per il centro oppure se sono corretti torna alla pagina precedente e cercalo nella lista dei centri già registrati per registrarti ad esso.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch (FieldFormatException exception){
                    // Handle field format exceptions
                    JOptionPane.showMessageDialog(view, exception.getMessage(), "Alert", JOptionPane.INFORMATION_MESSAGE);
                }catch (NumberFormatException exception){
                    // Handle number format exceptions
                    JOptionPane.showMessageDialog(view,"Il campo del numero civico e/o quello del cap possono contenere solo numeri. Numeri civici maggiori di 1000 non verranno accettati ed il CAP è di 5 cifre.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        //Back Button
        view.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navigate back to the CenterSelectionGUI
                CenterSelectionGUI form = new CenterSelectionGUI(getUser(),getCentersList());
                form.setVisible(true);
                view.dispose();
            }
        });

    }

    //*****************PRIVATE METHODS*****************//

    /**
     * Sets up the table with the necessary column names.
     */
    private void setUpTable(){
        String[] columnNames = {"ID", "Nome", "Stato", "Latitudine", "Longitudine"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        view.getAddedPoiTable().setModel(model);
        view.getAddedPoiTable().setDefaultEditor(Object.class,null);
        view.getAddedPoiTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setTableModel(model);
    }

    /**
     * Updates the table with the provided list of Points of Interest (POIs).
     *
     * @param pois The list of POIs to update the table with.
     */
    private void updateTable(ArrayList<PointOfInterest> pois){
        String[] columnNames = {"ID", "Nome", "Stato", "Latitudine", "Longitudine"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        Object[] rowData;
        for (PointOfInterest poi : pois) {
            rowData = new Object[]{poi.getPoi_id(), poi.getName(), poi.getCountry(), poi.getLatitude(), poi.getLongitude()};
            model.addRow(rowData);
        }
        view.getAddedPoiTable().setModel(model);
        view.getAddedPoiTable().setDefaultEditor(Object.class,null);
        view.getAddedPoiTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setTableModel(model);
    }

    /**
     * Adds a row to the table for the given Point of Interest (POI).
     *
     * @param poi The POI to add to the table.
     */
    public void addRowToTable(PointOfInterest poi){
        Object[] rowData = {poi.getPoi_id(), poi.getName(), poi.getCountry(), poi.getLatitude(), poi.getLongitude()};
        DefaultTableModel model = getTableModel();
        model.addRow(rowData);
        view.getAddedPoiTable().setModel(model);
        view.getAddedPoiTable().setDefaultEditor(Object.class,null);
        view.getAddedPoiTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * Retrieves the list of Points of Interest (POIs) from the table.
     *
     * @return The list of POIs from the table.
     */
    private ArrayList<PointOfInterest> getPoiList(){
        ArrayList<PointOfInterest> poiList = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) view.getAddedPoiTable().getModel();
        int rowCount = model.getRowCount();
        int poi_id;
        String name;
        String city;
        float latitude;
        float longitude;
        for (int i = 0; i < rowCount; i++) {
            poi_id = (int) model.getValueAt(i, 0);
            name = (String) model.getValueAt(i, 1);
            city = (String) model.getValueAt(i, 2);
            latitude = (float) model.getValueAt(i, 3);
            longitude = (float) model.getValueAt(i, 4);
            poiList.add(new PointOfInterest(poi_id, latitude, longitude, name, city));
        }
        return poiList;
    }

    /**
     * Checks the validity of the center registration form fields.
     *
     * @param name The name of the center.
     * @param address The address of the center.
     * @param addressnumber The address number of the center.
     * @param cap The CAP of the center.
     * @param city The city of the center.
     * @param province The province of the center.
     * @throws FieldFormatException If any form field is invalid.
     */
    private void checkCenterFormFields(String name, String address, String addressnumber, String cap, String city, String province) throws FieldFormatException {
        //Validate each input field individually
        if(Objects.equals(name, "") ||
                Objects.equals(address, "") ||
                Objects.equals(addressnumber, "") ||
                Objects.equals(cap, "") ||
                Objects.equals(city, "") ||
                Objects.equals(province, "")){
            System.err.println("Registration Center Form fields not filled.");
            throw new FieldFormatException("Prima di continuare con la registrazione devi inserire tutti i campi.");
        }else {
            //Validate name input
            if (!ClientManager.isOnlyLettersAndSpacesString(name) && name.length() <= 50) {
                System.err.println("Center name format not valid.");
                throw new FieldFormatException("Il Nome del centro contiene caratteri non validi, deve essere una stringa di sole lettere.");
            } else {
                //Validate address input
                if (!ClientManager.isValidUtf8(address) && address.length() <= 50) {
                    System.err.println("Center Address format not UTF-8 valid.");
                    throw new FieldFormatException("L'indirizzo del centro contiene caratteri non validi, deve essere una stringa UTF-8 valida.");
                } else {
                    //Validate city input
                    if (!ClientManager.isOnlyLettersAndSpacesString(city) && city.length() <= 30) {
                        System.err.println("Center city format not valid.");
                        throw new FieldFormatException("La città del centro contiene caratteri non validi, deve essere una stringa di lettere.");
                    } else {
                        //Validate province input
                        if (!ClientManager.isOnlyLettersString(province) && province.length() <= 30) {
                            System.err.println("Center province format not valid.");
                            throw new FieldFormatException("La province del centro contiene caratteri non validi deve essere una stringa di lettere senza spazi.");
                        } else {
                            //Validate addressnumber input
                            if (!ClientManager.isOnlyNumbersString(addressnumber) && Integer.parseInt(addressnumber)<=1000) {
                                System.err.println("Center address number format not valid.");
                                throw new FieldFormatException("Il numero civico ha un formato non oorretto, deve essere un numero intero (MAX accettato 1000).");
                            } else {
                                //Validate cap input
                                if (!ClientManager.isValidCap(cap)) {
                                    System.err.println("Center cap format not valid.");
                                    throw new FieldFormatException("Il Cap ha un formato non corretto, deve essere un numero intero di 5 cifre.");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
