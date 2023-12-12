package com.climatemonitoring.shared;

import com.climatemonitoring.shared.models.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RemoteDatabaseServiceInterface extends Remote {

    //RMI METHODS

    ArrayList<PointOfInterest> cercaAreaGeograficaNome(String name, String state) throws RemoteException;

    ArrayList<PointOfInterest> cercaAreaGeograficaCoordinate(float latitude, float longitude) throws RemoteException;

    SurveysAggregate visualizzaAreaGeografica(int poi_id) throws RemoteException;

    boolean registrazione(User user, int centerid) throws RemoteException;

    int registraCentroAree(MonitoringCenter center) throws RemoteException;

    int inserisciParametriClimatici(Survey survey) throws RemoteException;

    User userLogin(String userid, String hashedpassword) throws RemoteException;

    ArrayList<Survey> selectSurveysById(int poi_id) throws RemoteException;

    ArrayList<PointOfInterest> selectPoisByCenter(int centerid) throws RemoteException;

    MonitoringCenter selectCenterById(int centerid) throws RemoteException;

    int insertPoi(PointOfInterest poi) throws RemoteException;

    ArrayList<MonitoringCenter> getCentersList() throws RemoteException;

    boolean checkUserExists(String userid) throws RemoteException;

    int checkCenterExists(MonitoringCenter center) throws RemoteException;

    int checkPoiExists(PointOfInterest poi) throws RemoteException;

    void linkCenterToPois(MonitoringCenter center, ArrayList<PointOfInterest> poiList) throws RemoteException;

    void linkPoiToCenter(PointOfInterest poi,int centerid) throws RemoteException;

}
