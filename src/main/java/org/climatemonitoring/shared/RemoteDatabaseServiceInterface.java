package org.climatemonitoring.shared;

import org.climatemonitoring.shared.models.MonitoringCenter;
import org.climatemonitoring.shared.models.PointOfInterest;
import org.climatemonitoring.shared.models.Survey;
import org.climatemonitoring.shared.models.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RemoteDatabaseServiceInterface extends Remote {

    ArrayList<PointOfInterest> cercaAreaGeograficaNome(String name,String state) throws RemoteException;

    ArrayList<PointOfInterest> cercaAreaGeograficaCoordinate(float latitude, float longitude) throws RemoteException;

    ArrayList<Survey> selectSurveysById(int poi_id) throws RemoteException;

    User userLogin(String userid, String hashedpassword) throws RemoteException;

    ArrayList<MonitoringCenter> getCentersList() throws RemoteException;

    MonitoringCenter selectCenterById(int centerid) throws RemoteException;

    boolean completeRegistrationUser(User user, int centerid) throws RemoteException;

    boolean checkUserExists(String userid) throws RemoteException;

}
