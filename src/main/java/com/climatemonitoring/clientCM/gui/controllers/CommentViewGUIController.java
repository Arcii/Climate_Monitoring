package com.climatemonitoring.clientCM.gui.controllers;

import com.climatemonitoring.clientCM.gui.views.CommentViewGUI;
import com.climatemonitoring.clientCM.network.ClientManager;
import com.climatemonitoring.shared.models.SurveysAggregate;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static com.climatemonitoring.clientCM.network.ClientManager.GetClientManager;

public class CommentViewGUIController {

    //FIELDS

    private CommentViewGUI view;
    private final ClientManager clientManager;
    private SurveysAggregate surveysAggregate;
    private String commentType;

    //CONSTRUCTOR

    public CommentViewGUIController(CommentViewGUI view, SurveysAggregate surveysAggregate, String commentType){
        this.view = view;
        this.clientManager = GetClientManager();
        this.surveysAggregate = surveysAggregate;
        this.commentType = commentType;

        setUpViewAndTable();

        //ADD Listeners
        AddListeners();
    }

    //GETTER AND SETTER

    public CommentViewGUI getView() {
        return view;
    }

    public void setView(CommentViewGUI view) {
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

    public String getCommentType() {
        return commentType;
    }

    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

    //PRIVATE ADD LISTENERS METHOD

    private void AddListeners(){

        view.getCloseButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });

    }

    //PRIVATE METHODS

    private ArrayList<String> getListComments(String commentsAggregate){
        String[] splitArray = commentsAggregate.split("\\|");
        return new ArrayList<>(Arrays.asList(splitArray));
    }

    private void setUpViewAndTable(){
        String[] columnNames = {"Operatore", "Commenti"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        ArrayList<String> commentsList = new ArrayList<>();

        switch(getCommentType()){
            case "vento":
                getView().getCommentsInfoLabel().setText("I commenti lasciati per il " + commentType + " sono : ");
                if(getSurveysAggregate().getWind_notes_list() != null && !Objects.equals(getSurveysAggregate().getWind_notes_list(), "")) {
                    commentsList.addAll(getListComments(getSurveysAggregate().getWind_notes_list()));
                }
                break;
            case "umidità":
                getView().getCommentsInfoLabel().setText("I commenti lasciati per l'" + commentType + " sono : ");
                if(getSurveysAggregate().getHumidity_notes_list() != null && !Objects.equals(getSurveysAggregate().getHumidity_notes_list(), "")) {
                    commentsList.addAll(getListComments(getSurveysAggregate().getHumidity_notes_list()));
                }
                break;
            case "pressione":
                getView().getCommentsInfoLabel().setText("I commenti lasciati per la " + commentType + " sono : ");
                if(getSurveysAggregate().getPressure_notes_list() != null && !Objects.equals(getSurveysAggregate().getPressure_notes_list(), "")) {
                    commentsList.addAll(getListComments(getSurveysAggregate().getPressure_notes_list()));
                }
                break;
            case "temperatura":
                getView().getCommentsInfoLabel().setText("I commenti lasciati per la " + commentType + " sono : ");
                if(getSurveysAggregate().getTemperature_notes_list() != null && !Objects.equals(getSurveysAggregate().getTemperature_notes_list(), "")) {
                    commentsList.addAll(getListComments(getSurveysAggregate().getTemperature_notes_list()));
                }
                break;
            case "precipitazioni":
                getView().getCommentsInfoLabel().setText("I commenti lasciati per le " + commentType + " sono : ");
                if(getSurveysAggregate().getPrecipitation_notes_list() != null && !Objects.equals(getSurveysAggregate().getPrecipitation_notes_list(),"")) {
                    commentsList.addAll(getListComments(getSurveysAggregate().getPrecipitation_notes_list()));
                }
                break;
            case "Altitudine dei ghiacciai":
                getView().getCommentsInfoLabel().setText("I commenti lasciati per l'" + commentType + " sono : ");
                if(getSurveysAggregate().getGlacial_altitude_notes_list() != null && !Objects.equals(getSurveysAggregate().getGlacial_altitude_notes_list(), "")) {
                    commentsList.addAll(getListComments(getSurveysAggregate().getGlacial_altitude_notes_list()));
                }
                break;
            case "Massa dei ghiacciai":
                getView().getCommentsInfoLabel().setText("I commenti lasciati per la " + commentType + " sono : ");
                if(getSurveysAggregate().getGlacial_mass_notes_list() != null && !Objects.equals(getSurveysAggregate().getGlacial_mass_notes_list(), "")) {
                    commentsList.addAll(getListComments(getSurveysAggregate().getGlacial_mass_notes_list()));
                }
                break;
        }

        int count = 1;
        for (String comment : commentsList) {
            Object[] rowData = {"Operatore " + count + " : ", comment.trim()};
            model.addRow(rowData);
            count++;
        }

        view.getCommentsTable().setModel(model);
        view.getCommentsTable().setDefaultEditor(Object.class,null);
        view.getCommentsTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

}
