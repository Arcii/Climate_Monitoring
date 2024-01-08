package com.climatemonitoring.shared;

import com.climatemonitoring.shared.models.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * The Remote Database Service Interface provides methods for remote communication
 * between clients and the server. These methods cover various database operations
 * related to points of interest, surveys, monitoring centers, user registration,
 * login, and other functionalities.
 *
 * <p>
 * This interface extends the Remote interface, indicating its use in RMI (Remote Method Invocation).
 * The class <code>RemoteDatabaseService</code> implements this interface and is included in the {@link com.climatemonitoring.serverCM}
 * module.
 * </p>
 *
 * @author Lorenzo Cattapan 726459 (Varese)
 * @version 0.9.0
 * @see java.rmi.Remote
 * @see com.climatemonitoring.serverCM.network.RemoteDatabaseService
 */
public interface RemoteDatabaseServiceInterface extends Remote {

    //*****************RMI METHODS*****************//

    /**
     * Searches for points of interest within a specified geographic area based on name and country.
     *
     * @param name The name of the area.
     * @param country The country of the area.
     * @return An ArrayList of PointOfInterest objects within the specified area.
     * @throws RemoteException If a remote communication error occurs.
     */
    ArrayList<PointOfInterest> cercaAreaGeograficaNome(String name, String country) throws RemoteException;

    /**
     * Searches for points of interest within a specified geographic area based on coordinates.
     *
     * @param latitude The latitude of the area.
     * @param longitude The longitude of the area.
     * @return An ArrayList of PointOfInterest objects within the specified area.
     * @throws RemoteException If a remote communication error occurs.
     */
    ArrayList<PointOfInterest> cercaAreaGeograficaCoordinate(float latitude, float longitude) throws RemoteException;

    /**
     * Retrieves aggregated survey information for a specific point of interest.
     *
     * @param poi_id The Point of Interest ID.
     * @return A SurveysAggregate object containing aggregated survey information.
     * @throws RemoteException If a remote communication error occurs.
     */
    SurveysAggregate visualizzaAreaGeografica(int poi_id) throws RemoteException;

    /**
     * Registers a user with the specified user information and associates them with a monitoring center.
     *
     * @param user The User object representing the user to be registered.
     * @param centerid The ID of the monitoring center to associate the user with.
     * @return True if the registration is successful, false otherwise.
     * @throws RemoteException If a remote communication error occurs.
     */
    boolean registrazione(User user, int centerid) throws RemoteException;

    /**
     * Registers a monitoring center and returns its assigned ID.
     *
     * @param center The MonitoringCenter object representing the monitoring center to be registered.
     * @return The ID assigned to the registered monitoring center.
     * @throws RemoteException If a remote communication error occurs.
     */
    int registraCentroAree(MonitoringCenter center) throws RemoteException;

    /**
     * Inserts climatic parameters from a survey into the database and returns its assigned ID.
     *
     * @param survey The Survey object containing climatic parameter information.
     * @return The ID assigned to the inserted survey.
     * @throws RemoteException If a remote communication error occurs.
     */
    int inserisciParametriClimatici(Survey survey) throws RemoteException;

    /**
     * Validates user credentials and performs user login.
     *
     * @param userid The user ID.
     * @param hashedpassword The hashed user password.
     * @return The User object representing the logged-in user, or null if login fails.
     * @throws RemoteException If a remote communication error occurs.
     */
    User userLogin(String userid, String hashedpassword) throws RemoteException;

    /**
     * Retrieves surveys for a specific point of interest based on the Point of Interest ID.
     *
     * @param poi_id The Point of Interest ID.
     * @return An ArrayList of Survey objects for the specified Point of Interest.
     * @throws RemoteException If a remote communication error occurs.
     */
    ArrayList<Survey> selectSurveysById(int poi_id) throws RemoteException;

    /**
     * Retrieves points of interest associated with a monitoring center based on the center ID.
     *
     * @param centerid The ID of the monitoring center.
     * @return An ArrayList of PointOfInterest objects associated with the specified monitoring center.
     * @throws RemoteException If a remote communication error occurs.
     */
    ArrayList<PointOfInterest> selectPoisByCenter(int centerid) throws RemoteException;

    /**
     * Retrieves monitoring center information based on the center ID.
     *
     * @param centerid The ID of the monitoring center.
     * @return The MonitoringCenter object representing the specified monitoring center.
     * @throws RemoteException If a remote communication error occurs.
     */
    MonitoringCenter selectCenterById(int centerid) throws RemoteException;

    /**
     * Inserts a new point of interest into the database and returns its assigned ID.
     *
     * @param poi The PointOfInterest object representing the point of interest to be inserted.
     * @return The ID assigned to the inserted point of interest.
     * @throws RemoteException If a remote communication error occurs.
     */
    int insertPoi(PointOfInterest poi) throws RemoteException;

    /**
     * Retrieves the list of monitoring centers registered.
     *
     * @return An ArrayList of MonitoringCenter objects representing monitoring centers in the system.
     * @throws RemoteException If a remote communication error occurs.
     */
    ArrayList<MonitoringCenter> getCentersList() throws RemoteException;

    /**
     * Checks if a user with the specified user ID exists in the database.
     *
     * @param userid The user ID to check.
     * @return True if the user exists, false otherwise.
     * @throws RemoteException If a remote communication error occurs.
     */
    boolean checkUserExists(String userid) throws RemoteException;

    /**
     * Checks if a monitoring center with the specified information exists in the database and returns its assigned ID.
     *
     * @param center The MonitoringCenter object representing the center to check.
     * @return The ID of the existing center if it exists, or -1 if it does not.
     * @throws RemoteException If a remote communication error occurs.
     */
    int checkCenterExists(MonitoringCenter center) throws RemoteException;

    /**
     * Checks if a point of interest with the specified information exists in the database and returns its assigned ID.
     *
     * @param poi The PointOfInterest object representing the point of interest to check.
     * @return The ID of the existing point of interest if it exists, or -1 if it does not.
     * @throws RemoteException If a remote communication error occurs.
     */
    int checkPoiExists(PointOfInterest poi) throws RemoteException;

    /**
     * Links a monitoring center to a list of points of interest.
     *
     * @param center The MonitoringCenter object to link.
     * @param poiList An ArrayList of PointOfInterest objects to link to the center.
     * @throws RemoteException If a remote communication error occurs.
     */
    void linkCenterToPois(MonitoringCenter center, ArrayList<PointOfInterest> poiList) throws RemoteException;

    /**
     * Links a point of interest to a monitoring center based on center ID.
     *
     * @param poi The PointOfInterest object to link.
     * @param centerid The ID of the monitoring center to link the point of interest to.
     * @throws RemoteException If a remote communication error occurs.
     */
    void linkPoiToCenter(PointOfInterest poi,int centerid) throws RemoteException;

}
