package com.climatemonitoring.clientCM.gui.controllers;

import com.climatemonitoring.clientCM.gui.views.PoiDataGUI;
import com.climatemonitoring.clientCM.network.ClientManager;
import com.climatemonitoring.clientCM.utils.FieldFormatException;
import com.climatemonitoring.clientCM.gui.views.ClientHomeGUI;
import com.climatemonitoring.clientCM.gui.views.OperatorHomeGUI;
import com.climatemonitoring.clientCM.gui.views.PoiSearchResultGUI;
import com.climatemonitoring.shared.models.PointOfInterest;
import com.climatemonitoring.shared.models.Survey;
import com.climatemonitoring.shared.models.SurveysAggregate;
import com.climatemonitoring.shared.models.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class OperatorHomeGUIController {

    //FIELDS

    private OperatorHomeGUI view;
    private final ClientManager clientManager;
    private DefaultTableModel poiTable;
    private User user;

    //CONSTRUCTOR

    public OperatorHomeGUIController(OperatorHomeGUI view, User user) {
        this.view = view;
        this.clientManager = ClientManager.GetClientManager();
        this.user = user;

        view.getGreetingLabel().setText("Benvenuto " + user.getUserid() + " del centro oon id " + user.getCenterid() + " inserisci i dati dell'area geografica di cui vuoi visualizzare le rilevazioni :");

        setUpTable(user);

        //ADD Listeners
        AddListeners();

    }

    //GETTER AND SETTER

    public OperatorHomeGUI getView() {
        return view;
    }

    public void setView(OperatorHomeGUI view) {
        this.view = view;
    }

    public ClientManager getClientManager() {
        return clientManager;
    }

    public DefaultTableModel getPoiTable() {
        return poiTable;
    }

    public void setPoiTable(DefaultTableModel poiTable) {
        this.poiTable = poiTable;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //PRIVATE ADD LISTENERS METHOD

    private void AddListeners() {

        view.getCoordinatesSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float latitude;
                float longitude;
                try {
                    latitude = Float.parseFloat(view.getLatitudeField().getText().trim());
                    longitude = Float.parseFloat(view.getLongitudeField().getText().trim());
                    ArrayList<PointOfInterest> result = clientManager.cercaAreaGeograficaCoordinate(latitude, longitude);
                    PoiSearchResultGUI form = new PoiSearchResultGUI(result, getUser());
                    form.setVisible(true);
                    view.dispose();
                }catch (NumberFormatException exc){
                    System.err.println("Coordinates format not valid");
                    JOptionPane.showMessageDialog(view, "Formato coordinate non valido, ogni latitudine o longitudine deve essere indicata come un numero decimale separato da un punto (ex. 45.23456)", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        view.getNamePoiSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = view.getNameField().getText().trim();
                String country = view.getStateField().getText().trim();
                if (name.isEmpty() || country.isEmpty()) {
                    System.err.println("No input for Name or Country");
                    JOptionPane.showMessageDialog(view, "I campi Nome e/o Stato dell'area che vuoi cercare non sono stati inseriti.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    if(name.length() <= 100 && country.length() <= 100) {
                        String asciiRegex = "\\A\\p{ASCII}*\\z";
                        Pattern pattern = Pattern.compile(asciiRegex);
                        if (pattern.matcher(name).matches() && pattern.matcher(country).matches()) {
                            ArrayList<PointOfInterest> result = clientManager.cercaAreaGeograficaNome(name, country);
                            PoiSearchResultGUI form = new PoiSearchResultGUI(result, getUser());
                            form.setVisible(true);
                            view.dispose();
                        } else {
                            System.err.println("Name or Country format not valid");
                            JOptionPane.showMessageDialog(view, "Formato Nome o Stato non valido, entrambi i campi devono contenere caratteri ASCII.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }else{
                        System.err.println("Name or Country string inserted too long");
                        JOptionPane.showMessageDialog(view, "Il nome o lo stato forniti sono stringhe troppo lunghe.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        view.getAddSurveyButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int selectedRow = view.getPoiSelectionTable().getSelectedRow();
                    if (selectedRow != -1) {
                        int windScore = Integer.parseInt(view.getWindField().getText());
                        int humidityScore = Integer.parseInt(view.getHumidityField().getText());
                        int pressureScore = Integer.parseInt(view.getPressureField().getText());
                        int temperatureScore = Integer.parseInt(view.getTemperatureField().getText());
                        int precipitationScore = Integer.parseInt(view.getPrecipitationField().getText());
                        int glacial_altitudeScore = Integer.parseInt(view.getGlacial_altitudeField().getText());
                        int glacial_massScore = Integer.parseInt(view.getGlacial_massField().getText());
                        String windNotes = view.getWindNoteField().getText();
                        String humidityNotes = view.getHumidityNoteField().getText();
                        String pressureNotes = view.getPressureNoteField().getText();
                        String temperatureNotes = view.getTemperatureNoteField().getText();
                        String precipitationNotes = view.getPrecipitationNoteField().getText();
                        String glacial_altitudeNotes = view.getGlacial_altitudeNoteField().getText();
                        String glacial_massNotes = view.getGlacial_massNoteField().getText();
                        checkSurveyFields(windScore, humidityScore, pressureScore, temperatureScore, precipitationScore, glacial_altitudeScore, glacial_massScore, windNotes, humidityNotes, pressureNotes, temperatureNotes, precipitationNotes, glacial_altitudeNotes, glacial_massNotes);
                        int selectedPoiId = (Integer)view.getPoiSelectionTable().getValueAt(selectedRow, 0);
                        Survey survey = new Survey(
                                selectedPoiId,
                                getUser().getCenterid(),
                                windScore,
                                humidityScore,
                                pressureScore,
                                temperatureScore,
                                precipitationScore,
                                glacial_altitudeScore,
                                glacial_massScore,
                                windNotes,
                                humidityNotes,
                                pressureNotes,
                                temperatureNotes,
                                precipitationNotes,
                                glacial_altitudeNotes,
                                glacial_massNotes
                        );
                        int surveyId = getClientManager().inserisciParametriClimatici(survey);
                        if(surveyId > 0){
                            JOptionPane.showMessageDialog(view, "Parametri inseriti con successo, creata rilevazione " + surveyId + " per area " + selectedPoiId, "Alert", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(view, "Inserimento parametri fallito, riprovare. ", "Alert", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }else{
                        System.err.println("Button pressed without poi selected.");
                        JOptionPane.showMessageDialog(view, "Prima di inserire i parametri climatici devi selezionare l'Area geografica a cui si riferiscono.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch (FieldFormatException exc){
                    System.err.println("Catching format Exception.");
                    JOptionPane.showMessageDialog(view, exc.getMessage(), "Alert", JOptionPane.INFORMATION_MESSAGE);
                }catch (NumberFormatException exc){
                    System.err.println("Catching string score Exception.");
                    JOptionPane.showMessageDialog(view, "I valori dello score non sono stati inseriti o non sono numeri.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        view.getAddPoiToCenterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String latitude = view.getAddLatitudeField().getText().trim();
                    String longitude = view.getAddLongitudeField().getText().trim();
                    String name = view.getNamePoiField().getText().trim();
                    String country = view.getCountryPoiField().getText().trim();
                    System.out.println(name);
                    System.out.println(country);
                    System.out.println(latitude);
                    System.out.println(longitude);
                    if(!name.isEmpty() && !country.isEmpty() && !latitude.isEmpty() && !longitude.isEmpty()){
                        if(ClientManager.isAsciiString(name)){
                            if(ClientManager.isAsciiString(country)){
                                float lat = Float.parseFloat(latitude);
                                float lon = Float.parseFloat(longitude);
                                PointOfInterest poi = new PointOfInterest(lat,lon,name,country);
                                int poi_id = getClientManager().insertPoi(poi);
                                poi.setPoi_id(poi_id);
                                getClientManager().linkPoiToCenter(poi, getUser().getCenterid());
                                addRowToTable(poi);
                            }else{
                                System.err.println("Poi country format not valid.");
                                JOptionPane.showMessageDialog(view, "Lo stato dell'area che si vuole creare non ha un formato valido,può contenere solo caratteri ASCII", "Alert", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }else{
                            System.err.println("Poi name format not valid.");
                            JOptionPane.showMessageDialog(view, "Il nome dell'area che si vuole creare non ha un formato valido, può contenere solo caratteri ASCII", "Alert", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }else{
                        System.err.println("Fields are empty.");
                        JOptionPane.showMessageDialog(view, "Prima di procedere a creare un'area devi riempire tutti i campi necessari.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch (NumberFormatException exc){
                    System.err.println("Coordinates format not valid");
                    JOptionPane.showMessageDialog(view, "Formato coordinate non valido, ogni latitudine o longitudine deve essere indicata come un numero decimale separato da un punto (ex. 45.23456)", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        view.getSelectPoiButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = view.getPoiSelectionTable().getSelectedRow();
                if (selectedRow != -1) {
                    Object selectedPoi = view.getPoiSelectionTable().getValueAt(selectedRow, 0);
                    SurveysAggregate result = clientManager.visualizzaAreaGeografica((Integer)selectedPoi);
                    if(result != null) {
                        PoiDataGUI form = new PoiDataGUI(result, null, getUser());
                        form.setVisible(true);
                        view.dispose();
                    }else{
                        System.err.println("No surveys for Poi selected");
                        JOptionPane.showMessageDialog(view, "Non sono presenti parametri climatici per quest'area.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    System.err.println("Button pressed without row selected");
                    JOptionPane.showMessageDialog(view, "Non hai selezionato l'area di cui vuoi visualizzare i parametri climatici, prima di procedere devi selezionarla nella tabella qui sopra.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        view.getLogoutButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientHomeGUI form = new ClientHomeGUI();
                form.setVisible(true);
                view.dispose();
            }
        });

    }

    //PRIVATE METHODS

    private void checkSurveyFields(int windScore, int humidityScore, int pressureScore, int temperatureScore, int precipitationScore, int glacial_altitudeScore, int glacial_massScore, String windNotes, String humidityNotes, String pressureNotes, String temperatureNotes, String precipitationNotes, String glacial_altitudeNotes, String glacial_massNotes) throws FieldFormatException{
        if(ClientManager.isValidScore(windScore) &&
                ClientManager.isValidScore(humidityScore) &&
                ClientManager.isValidScore(pressureScore) &&
                ClientManager.isValidScore(temperatureScore) &&
                ClientManager.isValidScore(precipitationScore) &&
                ClientManager.isValidScore(glacial_altitudeScore) &&
                ClientManager.isValidScore(glacial_massScore)){
            if(ClientManager.isValidUtf8(windNotes) &&
                    ClientManager.isValidUtf8(humidityNotes) &&
                    ClientManager.isValidUtf8(pressureNotes) &&
                    ClientManager.isValidUtf8(temperatureNotes) &&
                    ClientManager.isValidUtf8(precipitationNotes) &&
                    ClientManager.isValidUtf8(glacial_altitudeNotes) &&
                    ClientManager.isValidUtf8(glacial_massNotes)){
                if(windNotes.codePointCount(0,windNotes.length()) <= 256 &&
                        humidityNotes.codePointCount(0,humidityNotes.length()) <= 256 &&
                        pressureNotes.codePointCount(0,pressureNotes.length()) <= 256 &&
                        temperatureNotes.codePointCount(0,temperatureNotes.length()) <= 256 &&
                        precipitationNotes.codePointCount(0,precipitationNotes.length()) <= 256 &&
                        glacial_altitudeNotes.codePointCount(0,glacial_altitudeNotes.length()) <= 256 &&
                        glacial_massNotes.codePointCount(0,glacial_massNotes.length()) <= 256 ){
                    System.err.println("Check Survey fields passed.");
                }else{
                    System.err.println("A Note string is longer than 256 characters.");
                    throw new FieldFormatException("Le note devono contenere al massimo 256 caratteri.");
                }
            }else{
                System.err.println("Not a valid note.");
                throw new FieldFormatException("Le note possono contenere solo caratteri UTF-8.");
            }
        }else {
            System.err.println("Not a valid survey score.");
            throw new FieldFormatException("Uno o più score non sono numeri interi compresi tra 1 e 5.");
        }
    }

    private void setUpTable(User user){
        String[] columnNames = {"ID", "Nome", "Stato", "Latitudine", "Longitudine"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (PointOfInterest poi : getClientManager().selectPoisByCenter(user.getCenterid())) {
            Object[] rowData = {poi.getPoi_id(), poi.getName(), poi.getCountry(), poi.getLatitude(), poi.getLongitude()};
            model.addRow(rowData);
        }

        view.getPoiSelectionTable().setModel(model);
        view.getPoiSelectionTable().setDefaultEditor(Object.class,null);
        view.getPoiSelectionTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setPoiTable(model);
    }

    private void addRowToTable(PointOfInterest poi){
        Object[] rowData = {poi.getPoi_id(), poi.getName(), poi.getCountry(), poi.getLatitude(), poi.getLongitude()};
        DefaultTableModel model = getPoiTable();
        model.addRow(rowData);
        view.getPoiSelectionTable().setModel(model);
        view.getPoiSelectionTable().setDefaultEditor(Object.class,null);
        view.getPoiSelectionTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

}
