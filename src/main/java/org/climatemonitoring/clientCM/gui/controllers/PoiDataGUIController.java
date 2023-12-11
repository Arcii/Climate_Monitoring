package org.climatemonitoring.clientCM.gui.controllers;

import org.climatemonitoring.clientCM.gui.views.CommentViewGUI;
import org.climatemonitoring.clientCM.gui.views.PoiDataGUI;
import org.climatemonitoring.clientCM.gui.views.PoiSearchResultGUI;
import org.climatemonitoring.clientCM.network.ClientManager;
import org.climatemonitoring.shared.models.PointOfInterest;
import org.climatemonitoring.shared.models.SurveysAggregate;
import org.climatemonitoring.shared.models.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.climatemonitoring.clientCM.network.ClientManager.GetClientManager;

public class PoiDataGUIController {

    private PoiDataGUI view;
    private final ClientManager clientManager;
    private SurveysAggregate surveysAggregate;
    private ArrayList<PointOfInterest> searchResults;
    private User user;

    public PoiDataGUIController(PoiDataGUI view, SurveysAggregate surveysAggregate, ArrayList<PointOfInterest> searchResults, User user) {
        this.view = view;
        this.clientManager = GetClientManager();
        this.surveysAggregate = surveysAggregate;
        this.searchResults = searchResults;
        this.user = user;

        setupView();

        //ADD Listeners
        AddListeners();
    }

    public PoiDataGUI getView() {
        return view;
    }

    public void setView(PoiDataGUI view) {
        this.view = view;
    }

    public ClientManager getClientManager() {
        return clientManager;
    }

    public SurveysAggregate getSurveysAggregate() {
        return surveysAggregate;
    }

    public void setSurveysAggregate(SurveysAggregate surveysAggregate) {
        this.surveysAggregate = surveysAggregate;
    }

    public ArrayList<PointOfInterest> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(ArrayList<PointOfInterest> searchResults) {
        this.searchResults = searchResults;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private void AddListeners(){

        view.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(getUser() == null) {
                    PoiSearchResultGUI form = new PoiSearchResultGUI(getSearchResults());
                    form.setVisible(true);
                    view.dispose();
                }else{
                    PoiSearchResultGUI form = new PoiSearchResultGUI(getSearchResults(),getUser());
                    form.setVisible(true);
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

    //PRIVATE METHODS

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
