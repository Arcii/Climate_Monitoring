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

/**
 * Controller class for managing the behavior of the <code>CommentViewGUI</code> .
 * This class handles the interaction between the <code>CommentViewGUI</code>  and the <code>ClientManager</code> .
 *
 * @author Lorenzo Cattapan 726459 (Varese)
 * @version 0.9.0
 * @see CommentViewGUI
 * @see ClientManager
 */
public class CommentViewGUIController {

    //*****************FIELDS*****************//

    /**
     * Reference to the CommentViewGUI.
     */
    private CommentViewGUI view;
    /**
     * Instance of the ClientManager for data management.
     */
    private final ClientManager clientManager;
    /**
     * SurveysAggregate containing data related to surveys.
     */
    private SurveysAggregate surveysAggregate;
    /**
     * Type of comments to be displayed.
     */
    private String commentType;

    //*****************CONSTRUCTOR*****************//

    /**
     * Constructs an instance of CommentViewGUIController.
     *
     * @param view              Reference to the CommentViewGUI.
     * @param surveysAggregate  SurveysAggregate containing data related to surveys.
     * @param commentType       Type of comments to be displayed.
     */
    public CommentViewGUIController(CommentViewGUI view, SurveysAggregate surveysAggregate, String commentType){
        this.view = view;
        this.clientManager = GetClientManager();
        this.surveysAggregate = surveysAggregate;
        this.commentType = commentType;

        setUpViewAndTable();

        //ADD Listeners
        AddListeners();
    }

    //*****************GETTER AND SETTER*****************//

    /**
     * Retrieves the reference to the CommentViewGUI.
     *
     * @return CommentViewGUI instance representing the view.
     */
    public CommentViewGUI getView() {
        return view;
    }

    /**
     * Sets the reference to the CommentViewGUI.
     *
     * @param view CommentViewGUI instance representing the view.
     */
    public void setView(CommentViewGUI view) {
        this.view = view;
    }

    /**
     * Retrieves the instance of the ClientManager.
     *
     * @return ClientManager instance for data management.
     */
    public ClientManager getClientManager() {
        return clientManager;
    }

    /**
     * Retrieves the SurveysAggregate containing data related to surveys.
     *
     * @return SurveysAggregate instance representing survey data.
     */
    public SurveysAggregate getSurveysAggregate() {
        return surveysAggregate;
    }

    /**
     * Sets the SurveysAggregate containing data related to surveys.
     *
     * @param surveysAggregate SurveysAggregate instance representing survey data.
     */
    public void setSurveysAggregate(SurveysAggregate surveysAggregate) {
        this.surveysAggregate = surveysAggregate;
    }

    /**
     * Retrieves the type of comments to be displayed.
     *
     * @return String representing the comment type.
     */
    public String getCommentType() {
        return commentType;
    }

    /**
     * Sets the type of comments to be displayed.
     *
     * @param commentType String representing the comment type.
     */
    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

    //*****************PRIVATE ADD LISTENERS METHOD*****************//

    /**
     * Adds listeners to GUI components.
     */
    private void AddListeners(){

        //Close Button listener

        view.getCloseButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });

    }

    //*****************PRIVATE METHODS*****************//

    /**
     * Extracts a list of comments from the aggregated comments string.
     *
     * @param commentsAggregate Aggregated comments string.
     * @return ArrayList of comments.
     */
    private ArrayList<String> getListComments(String commentsAggregate){
        String[] splitArray = commentsAggregate.split("\\|");
        return new ArrayList<>(Arrays.asList(splitArray));
    }

    /**
     * Sets up the CommentViewGUI and the associated comments table.
     */
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
