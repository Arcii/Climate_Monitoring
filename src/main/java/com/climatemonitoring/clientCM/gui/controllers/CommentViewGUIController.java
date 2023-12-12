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
        ArrayList<String> commentsList;

        switch(getCommentType()){
            case "vento":
                getView().getCommentsInfoLabel().setText("I commenti lasciati per il " + commentType + " sono : ");
                commentsList = getListComments(getSurveysAggregate().getWind_notes_list());
                break;
            case "umidità":
                getView().getCommentsInfoLabel().setText("I commenti lasciati per l'" + commentType + " sono : ");
                commentsList = getListComments(getSurveysAggregate().getHumidity_notes_list());
                break;
            case "pressione":
                getView().getCommentsInfoLabel().setText("I commenti lasciati per la " + commentType + " sono : ");
                commentsList = getListComments(getSurveysAggregate().getPressure_notes_list());
                break;
            case "temperatura":
                getView().getCommentsInfoLabel().setText("I commenti lasciati per la " + commentType + " sono : ");
                commentsList = getListComments(getSurveysAggregate().getTemperature_notes_list());
                break;
            case "precipitazioni":
                getView().getCommentsInfoLabel().setText("I commenti lasciati per le " + commentType + " sono : ");
                commentsList = getListComments(getSurveysAggregate().getPrecipitation_notes_list());
                break;
            case "Altitudine dei ghiacciai":
                getView().getCommentsInfoLabel().setText("I commenti lasciati per l'" + commentType + " sono : ");
                commentsList = getListComments(getSurveysAggregate().getGlacial_altitude_notes_list());
                break;
            case "Massa dei ghiacciai":
                getView().getCommentsInfoLabel().setText("I commenti lasciati per la " + commentType + " sono : ");
                commentsList = getListComments(getSurveysAggregate().getGlacial_mass_notes_list());
                break;
            default:
                commentsList = new ArrayList<>();
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
