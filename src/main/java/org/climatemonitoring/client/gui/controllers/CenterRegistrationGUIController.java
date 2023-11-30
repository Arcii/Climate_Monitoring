package org.climatemonitoring.client.gui.controllers;

import org.climatemonitoring.client.gui.views.*;
import org.climatemonitoring.client.network.ClientManager;
import org.climatemonitoring.client.utils.FieldFormatException;
import org.climatemonitoring.shared.models.MonitoringCenter;
import org.climatemonitoring.shared.models.PointOfInterest;
import org.climatemonitoring.shared.models.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class CenterRegistrationGUIController {

    private CenterRegistrationGUI view;
    private final ClientManager clientManager;
    private DefaultTableModel tableModel;
    private User user;
    private ArrayList<MonitoringCenter> centersList;

    public CenterRegistrationGUIController(CenterRegistrationGUI view, User user, ArrayList<MonitoringCenter> centersList) {
        this.view = view;
        this.clientManager = ClientManager.GetClientManager();
        this.user = user;
        this.centersList = centersList;

        setUpTable();

        //ADD Listeners
        AddListeners();
    }

    public CenterRegistrationGUI getView() {
        return view;
    }

    public void setView(CenterRegistrationGUI view) {
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

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public CenterRegistrationGUIController getController(){
        return this;
    }

    private void AddListeners(){

        //Search Poi Button
        view.getCoordinatesSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float latitude;
                float longitude;
                try {
                    latitude = Float.parseFloat(view.getLatitudeField().getText().trim());
                    longitude = Float.parseFloat(view.getLongitudeField().getText().trim());
                    ArrayList<PointOfInterest> result = clientManager.cercaAreaGeograficaCoordinate(latitude, longitude);
                    PoiSearchForRegistrationGUI form = new PoiSearchForRegistrationGUI(getController(), result);
                    form.setVisible(true);
                }catch (NumberFormatException exc){
                    System.err.println("Coordinates format not valid");
                    JOptionPane.showMessageDialog(view, "Formato coordinate non valido, ogni latitudine o longitudine deve essere indicata come un numero decimale separato da un punto (ex. 45.23456)", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        //Complete Center Registration button
        view.getCompleteCenterRegistrationButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = view.getNameField().getText().trim();
                String address = view.getAddressField().getText().trim();
                String addressnumber = view.getAddressNumberFIeld().getText().trim();
                String cap = view.getCapField().getText().trim();
                String city = view.getCityField().getText().trim();
                String province = view.getProvinceField().getText().trim();
                try{
                    Integer.parseInt(addressnumber);
                    Integer.parseInt(cap);
                    checkCenterFormFields(name,address,addressnumber,cap,city,province);
                    if(getClientManager().checkCenterExists(name,address,addressnumber,cap,city,province)<0){
                        if(getTableModel().getRowCount() != 0){
                            try{
                                //INSERT POI LIST
                                ArrayList<PointOfInterest> poiList = getPoiList();
                                poiList = getClientManager().insertPois(poiList);
                                updateTable(poiList);

                                //INSERT CENTER
                                MonitoringCenter center = new MonitoringCenter(name,address,Integer.parseInt(addressnumber),Integer.parseInt(cap),city,province);
                                int createdCenterId = getClientManager().completeRegistrationCenter(center);
                                if(createdCenterId<=0){
                                    System.err.println("Exception in ClientManager completeRegistrationCenter().");
                                    throw new Exception("Si è riscontrato un problema con la creazione del centro, riprovare a confermare o iniziare dall'inizio la procedura di registrazione.");
                                }
                                center.setCenterid(createdCenterId);

                                //INSERT CENTER_POIS LINKS
                                getClientManager().linkCenterToPois(center, poiList);

                                //INSERT NEW USER AND COMPLETE REGISTRATION
                                boolean userCreated = getClientManager().completeRegistrationUser(getUser(),createdCenterId);
                                if(userCreated) {
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
                                        ClientHomeGUI form = new ClientHomeGUI();
                                        form.setVisible(true);
                                        view.dispose();
                                    }else{
                                        System.err.println("The user successfully registered but something happened with the JOptionPane.showOptionDialog that should not be possible");
                                    }
                                }else {
                                    System.err.println("Registration Failed");
                                    JOptionPane.showMessageDialog(view, "Il centro è stato registrato correttamente ma si è verificato un errore nella registrazione dell'operatore, provare a ricominciare la procedura di registrazione e selezionare il centro creato nella lista dei centri registrati.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }catch (Exception exc){
                                System.err.println("Exception in completion of center registration.");
                                JOptionPane.showMessageDialog(view, exc.getMessage(), "Alert", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }else{
                            System.err.println("POIs list empty, can't create a center without pois.");
                            JOptionPane.showMessageDialog(view, "Non hai aggiunto nessuna Area nella lista delle aree che il centro vuole monitorare, non è possibile completare la registrazione di un centro senza almeno un area da monitorare.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }else{
                        System.err.println("Monitoring Center with exact same info already exists.");
                        JOptionPane.showMessageDialog(view, "Un centro con le stesse esatte informazioni è già registrato, controlla di aver inserito i dati corretti per il centro oppure se sono corretti torna alla pagina precedente e cercalo nella lista dei centri già registrati per registrarti ad esso.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch (FieldFormatException exception){
                    JOptionPane.showMessageDialog(view, exception.getMessage(), "Alert", JOptionPane.INFORMATION_MESSAGE);
                }catch (NumberFormatException exception){
                    JOptionPane.showMessageDialog(view,"Il campo del numero civico e/o quello del cap possono contenere solo numeri. Numeri civici maggiori di 1000 non verranno accettati ed il CAP è di 5 cifre.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        //Back Button
        view.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CenterSelectionGUI form = new CenterSelectionGUI(getUser(),getCentersList());
                form.setVisible(true);
                view.dispose();
            }
        });

    }

    private void setUpTable(){
        String[] columnNames = {"ID", "Nome", "Stato", "Latitudine", "Longitudine"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        view.getAddedPoiTable().setModel(model);
        view.getAddedPoiTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setTableModel(model);
    }

    private void updateTable(ArrayList<PointOfInterest> pois){
        String[] columnNames = {"ID", "Nome", "Stato", "Latitudine", "Longitudine"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        Object[] rowData;
        for (PointOfInterest poi : pois) {
            rowData = new Object[]{poi.getPoi_id(), poi.getName(), poi.getCountry(), poi.getLatitude(), poi.getLongitude()};
            model.addRow(rowData);
        }
        view.getAddedPoiTable().setModel(model);
        view.getAddedPoiTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setTableModel(model);
    }

    public void addRowToTable(PointOfInterest poi){
        Object[] rowData = {poi.getPoi_id(), poi.getName(), poi.getCountry(), poi.getLatitude(), poi.getLongitude()};
        DefaultTableModel model = getTableModel();
        model.addRow(rowData);
        view.getAddedPoiTable().setModel(model);
    }

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

    private void checkCenterFormFields(String name, String address, String addressnumber, String cap, String city, String province) throws FieldFormatException {
        if(Objects.equals(name, "") ||
                Objects.equals(address, "") ||
                Objects.equals(addressnumber, "") ||
                Objects.equals(cap, "") ||
                Objects.equals(city, "") ||
                Objects.equals(province, "")){
            System.err.println("Registration Center Form fields not filled.");
            throw new FieldFormatException("Prima di continuare con la registrazione devi inserire tutti i campi.");
        }else {
            if (!ClientManager.isOnlyLettersAndSpacesString(name) && name.length() <= 50) {
                System.err.println("Center name format not valid.");
                throw new FieldFormatException("Il Nome del centro contiene caratteri non validi, deve essere una stringa di sole lettere.");
            } else {
                if (!ClientManager.isValidUtf8(address) && address.length() <= 50) {
                    System.err.println("Center Address format not UTF-8 valid.");
                    throw new FieldFormatException("L'indirizzo del centro contiene caratteri non validi, deve essere una stringa UTF-8 valida.");
                } else {
                    if (!ClientManager.isOnlyLettersAndSpacesString(city) && city.length() <= 30) {
                        System.err.println("Center city format not valid.");
                        throw new FieldFormatException("La città del centro contiene caratteri non validi, deve essere una stringa di lettere.");
                    } else {
                        if (!ClientManager.isOnlyLettersString(province) && province.length() <= 30) {
                            System.err.println("Center province format not valid.");
                            throw new FieldFormatException("La province del centro contiene caratteri non validi deve essere una stringa di lettere senza spazi.");
                        } else {
                            if (!ClientManager.isOnlyNumbersString(addressnumber) && Integer.parseInt(addressnumber)<=1000) {
                                System.err.println("Center address number format not valid.");
                                throw new FieldFormatException("Il numero civico ha un formato non oorretto, deve essere un numero intero (MAX accettato 1000).");
                            } else {
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
