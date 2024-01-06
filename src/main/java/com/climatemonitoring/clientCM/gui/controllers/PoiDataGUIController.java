package com.climatemonitoring.clientCM.gui.controllers;

import com.climatemonitoring.clientCM.gui.views.CommentViewGUI;
import com.climatemonitoring.clientCM.gui.views.OperatorHomeGUI;
import com.climatemonitoring.clientCM.network.ClientManager;
import com.climatemonitoring.shared.models.SurveysAggregate;
import com.climatemonitoring.clientCM.gui.views.PoiDataGUI;
import com.climatemonitoring.clientCM.gui.views.PoiSearchResultGUI;
import com.climatemonitoring.shared.models.PointOfInterest;
import com.climatemonitoring.shared.models.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Controller class for the PoiDataGUI view.
 * Manages the interaction between the PoiDataGUI view and the underlying data model.
 * Handles button actions and updates the view based on the data model.
 *
 * @author Lorenzo Cattapan 726459 (Varese)
 * @version 1.0
 * @see PoiDataGUI
 * @see ClientManager
 */
public class PoiDataGUIController {

    //*****************FIELDS*****************//

    /**
     * The associated PoiDataGUI view.
     */
    private PoiDataGUI view;
    /**
     * The ClientManager singleton instance responsible for handling network communication.
     */
    private final ClientManager clientManager;
    /**
     * The aggregated surveys data.
     */
    private SurveysAggregate surveysAggregate;
    /**
     * The list of search results (Points of Interest) needed for previous views.
     */
    private ArrayList<PointOfInterest> searchResults;
    /**
     * The user associated with the view.
     */
    private User user;

    //*****************CONSTRUCTOR*****************//

    /**
     * Constructs a PoiDataGUIController.
     *
     * @param view The associated PoiDataGUI view.
     * @param surveysAggregate The aggregated surveys data.
     * @param searchResults The list of search results (Points of Interest) needed for previous views.
     * @param user The user associated with the view.
     */
    public PoiDataGUIController(PoiDataGUI view, SurveysAggregate surveysAggregate, ArrayList<PointOfInterest> searchResults, User user) {
        this.view = view;
        this.clientManager = ClientManager.GetClientManager();
        this.surveysAggregate = surveysAggregate;
        this.searchResults = searchResults;
        this.user = user;

        view.getPoi_infoLabel().setText("I dati Aggregati per L'Area Geografica con id " + "\"" + surveysAggregate.getPoi_id() + "\"" + " sono :");

        // Set up the view
        setupView();

        //ADD Listeners
        AddListeners();
    }

    //*****************GETTER AND SETTER*****************//

    /**
     * Gets the associated PoiDataGUI view.
     *
     * @return The PoiDataGUI view.
     */
    public PoiDataGUI getView() {
        return view;
    }

    /**
     * Sets the associated PoiDataGUI view.
     *
     * @param view The PoiDataGUI view to set.
     */
    public void setView(PoiDataGUI view) {
        this.view = view;
    }

    /**
     * Gets the client manager responsible for handling network communication.
     *
     * @return The ClientManager.
     */
    public ClientManager getClientManager() {
        return clientManager;
    }

    /**
     * Gets the aggregated surveys data.
     *
     * @return The SurveysAggregate.
     */
    public SurveysAggregate getSurveysAggregate() {
        return surveysAggregate;
    }

    /**
     * Sets the aggregated surveys data.
     *
     * @param surveysAggregate The SurveysAggregate to set.
     */
    public void setSurveysAggregate(SurveysAggregate surveysAggregate) {
        this.surveysAggregate = surveysAggregate;
    }

    /**
     * Gets the list of search results (Points of Interest).
     *
     * @return The list of search results.
     */
    public ArrayList<PointOfInterest> getSearchResults() {
        return searchResults;
    }

    /**
     * Sets the list of search results (Points of Interest).
     *
     * @param searchResults The list of search results to set.
     */
    public void setSearchResults(ArrayList<PointOfInterest> searchResults) {
        this.searchResults = searchResults;
    }

    /**
     * Gets the user associated with the view.
     *
     * @return The User.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user associated with the view.
     *
     * @param user The User to set.
     */
    public void setUser(User user) {
        this.user = user;
    }

    //*****************PRIVATE ADD LISTENERS METHOD*****************//

    /**
     * Adds action listeners to various buttons in the view.
     */
    private void AddListeners(){

        // Add action listener to the "Back" button in the PoiDataGUI view.
        view.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    // Check if the user is a guest
                    if (getUser() == null) {
                        // Create a new PoiSearchResultGUI form with search results and display it
                        PoiSearchResultGUI form = new PoiSearchResultGUI(getSearchResults());
                        form.setVisible(true);
                        // Close the current PoiDataGUI view
                        view.dispose();
                    }
                    // Check if there are search results available
                    else if (searchResults != null) {
                        // Create a new PoiSearchResultGUI form with search results and user, and display it
                        PoiSearchResultGUI form = new PoiSearchResultGUI(getSearchResults(), getUser());
                        form.setVisible(true);
                        // Close the current PoiDataGUI view
                        view.dispose();
                    } else {
                        // User is logged in, but no search results
                        OperatorHomeGUI form = new OperatorHomeGUI(getUser());
                        form.setVisible(true);
                        // Close the current PoiDataGUI view
                        view.dispose();
                    }
            }
        });

        view.getWindCommentButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CommentViewGUI form = new CommentViewGUI(getSurveysAggregate(), "vento");
                form.setVisible(true);
            }
        });

        view.getHumidityCommentButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CommentViewGUI form = new CommentViewGUI(getSurveysAggregate(), "umidità");
                form.setVisible(true);
            }
        });

        view.getPressureCommentButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CommentViewGUI form = new CommentViewGUI(getSurveysAggregate(), "pressione");
                form.setVisible(true);
            }
        });

        view.getTemperatureCommentButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CommentViewGUI form = new CommentViewGUI(getSurveysAggregate(), "temperatura");
                form.setVisible(true);
            }
        });

        view.getPrecipitationCommentButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CommentViewGUI form = new CommentViewGUI(getSurveysAggregate(), "precipitazioni");
                form.setVisible(true);
            }
        });

        view.getGlacial_altitudeCommentButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CommentViewGUI form = new CommentViewGUI(getSurveysAggregate(), "Altitudine dei ghiacciai");
                form.setVisible(true);
            }
        });

        view.getGlacial_massCommentButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CommentViewGUI form = new CommentViewGUI(getSurveysAggregate(), "Massa dei ghiacciai");
                form.setVisible(true);
            }
        });

    }

    //*****************PRIVATE METHODS*****************//

    /**
     * Sets up the view by updating its components based on the surveysAggregate data.
     */
    private void setupView(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        view.getCountLabel().setText(view.getCountLabel().getText() + surveysAggregate.getSurveysCount());
        view.getCentersNumberLabel().setText(view.getCentersNumberLabel().getText() + surveysAggregate.getCentersCount());
        view.getOldestSurveyLabel().setText(view.getOldestSurveyLabel().getText() + surveysAggregate.getOldestTimestamp().toLocalDateTime().format(formatter));
        view.getRecentSurveyLabel().setText(view.getRecentSurveyLabel().getText() + surveysAggregate.getMostRecentTimestamp().toLocalDateTime().format(formatter));

        view.getWindAvgLabel().setText(view.getWindAvgLabel().getText() + surveysAggregate.getWind_avg());
        view.getWindMaxLabel().setText(view.getWindMaxLabel().getText() + surveysAggregate.getWind_max());
        view.getWindMinLabel().setText(view.getWindMinLabel().getText() + surveysAggregate.getWind_min());

        view.getHumidityAvgLabel().setText(view.getHumidityAvgLabel().getText() + surveysAggregate.getHumidity_avg());
        view.getHumidityMaxLabel().setText(view.getHumidityMaxLabel().getText() + surveysAggregate.getHumidity_max());
        view.getHumidityMinLabel().setText(view.getHumidityMinLabel().getText() + surveysAggregate.getHumidity_min());

        view.getPressureAvgLabel().setText(view.getPressureAvgLabel().getText() + surveysAggregate.getPressure_avg());
        view.getPressureMaxLabel().setText(view.getPressureMaxLabel().getText() + surveysAggregate.getPressure_max());
        view.getPressureMinLabel().setText(view.getPressureMinLabel().getText() + surveysAggregate.getPressure_min());

        view.getTemperatureAvgLabel().setText(view.getTemperatureAvgLabel().getText() + surveysAggregate.getTemperature_avg());
        view.getTemperatureMaxLabel().setText(view.getTemperatureMaxLabel().getText() + surveysAggregate.getTemperature_max());
        view.getTemperatureMinLabel().setText(view.getTemperatureMinLabel().getText() + surveysAggregate.getTemperature_min());

        view.getPrecipitationAvgLabel().setText(view.getPrecipitationAvgLabel().getText() + surveysAggregate.getPrecipitation_avg());
        view.getPrecipitationMaxLabel().setText(view.getPrecipitationMaxLabel().getText() + surveysAggregate.getPrecipitation_max());
        view.getPrecipitationMinLabel().setText(view.getPrecipitationMinLabel().getText() + surveysAggregate.getPrecipitation_min());

        view.getGlacial_altitudeAvgLabel().setText(view.getGlacial_altitudeAvgLabel().getText() + surveysAggregate.getGlacial_altitude_avg());
        view.getGlacial_altitudeMaxLabel().setText(view.getGlacial_altitudeMaxLabel().getText() + surveysAggregate.getGlacial_altitude_max());
        view.getGlacial_altitudeMinLabel().setText(view.getGlacial_altitudeMinLabel().getText() + surveysAggregate.getGlacial_altitude_min());

        view.getGlacial_massAvgLabel().setText(view.getGlacial_massAvgLabel().getText() + surveysAggregate.getGlacial_mass_avg());
        view.getGlacial_massMaxLabel().setText(view.getGlacial_massMaxLabel().getText() + surveysAggregate.getGlacial_mass_max());
        view.getGlacial_massMinLabel().setText(view.getGlacial_massMinLabel().getText() + surveysAggregate.getGlacial_mass_min());
    }

}
