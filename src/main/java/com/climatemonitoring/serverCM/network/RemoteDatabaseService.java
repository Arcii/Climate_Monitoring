package com.climatemonitoring.serverCM.network;

import com.climatemonitoring.shared.RemoteDatabaseServiceInterface;
import com.climatemonitoring.shared.models.*;
import org.apache.commons.dbcp2.BasicDataSource;
import com.climatemonitoring.serverCM.database.DbManager;
import com.climatemonitoring.serverCM.database.PredefinedQuery;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

/**
 * The <code>RemoteDatabaseService</code> class is an implementation of the Java RMI interface
 * <code>RemoteDatabaseServiceInterface</code>. It extends <code>UnicastRemoteObject</code> to facilitate
 * remote method invocation. This class provides remote communication methods for
 * various database operations related to points of interest, surveys, monitoring
 * centers, user registration, login, and other functionalities.
 *
 * <p>
 * This implementation uses RMI (Remote Method Invocation) to allow clients to invoke
 * methods on the server for interacting with the database. It serves as a bridge
 * between the client application and the class that manages database connections, providing a secure and
 * efficient means of communication.
 * </p>
 *
 * <p>
 * The class creates and utilizes the only instance of <code>DbManager</code> (that implements a Singleton pattern) to get a database connection through
 * the database connection pool managed in the DbManager class. The database connection details, such as username and password,
 * are provided during the instantiation of this class, ensuring that all the remote invocations are managed using the single instance of <code>DbManager</code>.
 * </p>
 *
 * @author Lorenzo Cattapan 726459 (Varese)
 * @version 0.9.0
 * @see UnicastRemoteObject
 * @see com.climatemonitoring.shared.RemoteDatabaseServiceInterface
 * @see DbManager
 */
public class RemoteDatabaseService extends UnicastRemoteObject implements RemoteDatabaseServiceInterface {

    //*****************FIELDS*****************//

    /**
     * The database manager responsible for handling database connections and operations.
     */
    public final DbManager dbManager;

    //*****************CONSTRUCTORS*****************//

    /**
     * Constructs a new instance of the `RemoteDatabaseService`.
     *
     * @param username The username for accessing the database.
     * @param password The password for accessing the database.
     * @throws RemoteException If a communication-related exception occurs.
     */
    public RemoteDatabaseService(String username, String password) throws RemoteException {
        super();
        //Creating and saving the DbManager singleton
        this.dbManager = DbManager.GetDbManager(username, password);
    }

    //*****************RMI METHODS*****************//

    /**
     * Searches for points of interest within a specified geographic area based on name and state.
     *
     * @param name    The name of the area.
     * @param country The state of the area.
     * @return An ArrayList of PointOfInterest objects within the specified area.
     * @throws RemoteException If a remote communication error occurs.
     */
    @Override
    public ArrayList<PointOfInterest> cercaAreaGeograficaNome(String name, String country) throws RemoteException {
        ArrayList<PointOfInterest> resultList = new ArrayList<>();
        String query = PredefinedQuery.select_queries.get(PredefinedQuery.Select.POI_BY_NAME);
        BasicDataSource dataSource = DbManager.getDataSource();
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, "%" + name + "%");
                preparedStatement.setString(2, "%" + country + "%");
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        resultList.add(getRowPointOfInterest(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Search by name failed.");
            e.printStackTrace();
            return null;
        }
        return resultList;
    }

    /**
     * Searches for points of interest within a specified geographic area based on coordinates.
     *
     * @param latitude  The latitude of the area.
     * @param longitude The longitude of the area.
     * @return An ArrayList of PointOfInterest objects within the specified area.
     * @throws RemoteException If a remote communication error occurs.
     */
    @Override
    public ArrayList<PointOfInterest> cercaAreaGeograficaCoordinate(float latitude, float longitude) throws RemoteException {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("0.#####", symbols);
        latitude = Float.parseFloat(df.format(latitude));
        longitude = Float.parseFloat(df.format(longitude));
        ArrayList<PointOfInterest> resultList = new ArrayList<>();
        String query = PredefinedQuery.select_queries.get(PredefinedQuery.Select.POI_BY_COORDINATES);
        BasicDataSource dataSource = DbManager.getDataSource();
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setDouble(1, latitude - 0.00001);
                preparedStatement.setDouble(2, latitude + 0.00001);
                preparedStatement.setDouble(3, longitude - 0.00001);
                preparedStatement.setDouble(4, longitude + 0.00001);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        resultList.add(getRowPointOfInterest(resultSet));
                        return resultList;
                    } else {
                        try (PreparedStatement nextPreparedStatement = connection.prepareStatement(PredefinedQuery.select_queries.get(PredefinedQuery.Select.POI));
                             ResultSet nextResultSet = nextPreparedStatement.executeQuery()) {
                            while (nextResultSet.next()) {
                                resultList.add(getRowPointOfInterest(nextResultSet));
                            }
                            return resultList;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Search by coordinates failed.");
            e.printStackTrace();
            return null;
        }

    }

    /**
     * Retrieves aggregated survey information for a specific point of interest.
     *
     * @param poi_id The Point of Interest ID.
     * @return A SurveysAggregate object containing aggregated survey information.
     * @throws RemoteException If a remote communication error occurs.
     */
    @Override
    public SurveysAggregate visualizzaAreaGeografica(int poi_id) throws RemoteException {
        String query = PredefinedQuery.select_queries.get(PredefinedQuery.Select.POI_SURVEYS_AGGREGATE);
        BasicDataSource dataSource = DbManager.getDataSource();
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, poi_id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return new SurveysAggregate(
                                poi_id,
                                resultSet.getInt("survey_count"),
                                resultSet.getInt("number_of_centers"),
                                resultSet.getTimestamp("oldest_timestamp"),
                                resultSet.getTimestamp("most_recent_timestamp"),
                                resultSet.getFloat("avg_wind"),
                                resultSet.getFloat("avg_humidity"),
                                resultSet.getFloat("avg_pressure"),
                                resultSet.getFloat("avg_temperature"),
                                resultSet.getFloat("avg_precipitation"),
                                resultSet.getFloat("avg_glacial_altitude"),
                                resultSet.getFloat("avg_glacial_mass"),
                                resultSet.getInt("max_wind"),
                                resultSet.getInt("max_humidity"),
                                resultSet.getInt("max_pressure"),
                                resultSet.getInt("max_temperature"),
                                resultSet.getInt("max_precipitation"),
                                resultSet.getInt("max_glacial_altitude"),
                                resultSet.getInt("max_glacial_mass"),
                                resultSet.getInt("min_wind"),
                                resultSet.getInt("min_humidity"),
                                resultSet.getInt("min_pressure"),
                                resultSet.getInt("min_temperature"),
                                resultSet.getInt("min_precipitation"),
                                resultSet.getInt("min_glacial_altitude"),
                                resultSet.getInt("min_glacial_mass"),
                                resultSet.getString("wind_notes_list"),
                                resultSet.getString("humidity_notes_list"),
                                resultSet.getString("pressure_notes_list"),
                                resultSet.getString("temperature_notes_list"),
                                resultSet.getString("precipitation_notes_list"),
                                resultSet.getString("glacial_altitude_notes_list"),
                                resultSet.getString("glacial_mass_notes_list")
                        );
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Selecting surveys aggregate failed.");
            e.printStackTrace();
            return null;
        }
        return null;
    }

    /**
     * Registers a user with the specified user information and associates them with a monitoring center.
     *
     * @param user     The User object representing the user to be registered.
     * @param centerid The ID of the monitoring center to associate the user with.
     * @return True if the registration is successful, false otherwise.
     * @throws RemoteException If a remote communication error occurs.
     */
    @Override
    public boolean registrazione(User user, int centerid) throws RemoteException {
        BasicDataSource dataSource = DbManager.getDataSource();
        String query = PredefinedQuery.insert_queries.get(PredefinedQuery.Insert.USER);
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, user.getUserid());
                preparedStatement.setString(2, user.getName());
                preparedStatement.setString(3, user.getSurname());
                preparedStatement.setString(4, user.getEmail());
                preparedStatement.setString(5, user.getFiscalCode());
                preparedStatement.setString(6, user.getHashedPassword());
                preparedStatement.setInt(7, centerid);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected == 1) {
                    return true;
                } else {
                    System.err.println("Insertion for registration User rowsAffected = " + rowsAffected);
                }
            }
        } catch (SQLException e) {
            System.err.println("Exception completeRegistrationUser(), return false.");
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Registers a monitoring center and returns its assigned ID.
     *
     * @param center The MonitoringCenter object representing the monitoring center to be registered.
     * @return The ID assigned to the registered monitoring center.
     * @throws RemoteException If a remote communication error occurs.
     */
    @Override
    public int registraCentroAree(MonitoringCenter center) throws RemoteException {
        BasicDataSource dataSource = DbManager.getDataSource();
        String query = PredefinedQuery.insert_queries.get(PredefinedQuery.Insert.CLIMATECENTER);
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, center.getName());
                preparedStatement.setString(2, center.getAddress());
                preparedStatement.setInt(3, center.getAddressNumber());
                preparedStatement.setInt(4, center.getCap());
                preparedStatement.setString(5, center.getCity());
                preparedStatement.setString(6, center.getProvince());
                try {
                    connection.setAutoCommit(false);
                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected == 1) {
                        connection.commit();
                        connection.setAutoCommit(true);
                        return checkCenterExists(center);
                    }
                } catch (SQLException e) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    System.err.println("Exception in insertion transaction of new Center, rolling back database.");
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            System.err.println("Exception completeRegistrationCenter(), return -1.");
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * Inserts climatic parameters from a survey into the database and returns its assigned ID.
     *
     * @param survey The Survey object containing climatic parameter information.
     * @return The ID assigned to the inserted survey.
     * @throws RemoteException If a remote communication error occurs.
     */
    @Override
    public int inserisciParametriClimatici(Survey survey) throws RemoteException {
        BasicDataSource dataSource = DbManager.getDataSource();
        String query = PredefinedQuery.insert_queries.get(PredefinedQuery.Insert.SURVEY);
        try (Connection connection = dataSource.getConnection()) {
            System.err.println(connection);
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, survey.getPoi_id());
                preparedStatement.setInt(2, survey.getCenterid());
                preparedStatement.setInt(3, survey.getWind());
                preparedStatement.setInt(4, survey.getHumidity());
                preparedStatement.setInt(5, survey.getPressure());
                preparedStatement.setInt(6, survey.getTemperature());
                preparedStatement.setInt(7, survey.getPrecipitation());
                preparedStatement.setInt(8, survey.getGlacial_altitude());
                preparedStatement.setInt(9, survey.getGlacial_mass());
                preparedStatement.setString(10, survey.getWind_notes());
                preparedStatement.setString(11, survey.getHumidity_notes());
                preparedStatement.setString(12, survey.getPressure_notes());
                preparedStatement.setString(13, survey.getTemperature_notes());
                preparedStatement.setString(14, survey.getPrecipitation_notes());
                preparedStatement.setString(15, survey.getGlacial_altitude_notes());
                preparedStatement.setString(16, survey.getGlacial_mass_notes());
                try {
                    connection.setAutoCommit(false);
                    ResultSet generatedKey = preparedStatement.executeQuery();
                    if (generatedKey.next()) {
                        connection.commit();
                        connection.setAutoCommit(true);
                        return generatedKey.getInt("dataid");
                    }
                } catch (SQLException e) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    System.err.println("Exception in insertion transaction of new Survey, rolling back database.");
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            System.err.println("Exception in insertSurvey(), return false.");
        }
        return -1;
    }

    /**
     * Validates user credentials and performs user login.
     *
     * @param userid         The user ID.
     * @param hashedpassword The hashed user password.
     * @return The User object representing the logged-in user, or null if login fails.
     * @throws RemoteException If a remote communication error occurs.
     */
    @Override
    public User userLogin(String userid, String hashedpassword) throws RemoteException {
        BasicDataSource dataSource = DbManager.getDataSource();
        String query = PredefinedQuery.select_queries.get(PredefinedQuery.Select.USER_LOGIN_INFO);
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, userid);
                preparedStatement.setString(2, hashedpassword);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return getRowUser(resultSet);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Exception in login, login failed.");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Retrieves surveys for a specific point of interest based on the Point of Interest ID.
     *
     * @param poi_id The Point of Interest ID.
     * @return An ArrayList of Survey objects for the specified Point of Interest.
     * @throws RemoteException If a remote communication error occurs.
     */
    @Override
    public ArrayList<Survey> selectSurveysById(int poi_id) throws RemoteException {
        ArrayList<Survey> resultList = new ArrayList<>();
        String query = PredefinedQuery.select_queries.get(PredefinedQuery.Select.SURVEY_BY_ID);
        BasicDataSource dataSource = DbManager.getDataSource();
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, poi_id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        resultList.add(new Survey(
                                resultSet.getInt("dataid"),
                                resultSet.getInt("poi_id"),
                                resultSet.getInt("centerid"),
                                resultSet.getTimestamp("timestamp"),
                                resultSet.getInt("wind"),
                                resultSet.getInt("humidity"),
                                resultSet.getInt("pressure"),
                                resultSet.getInt("temperature"),
                                resultSet.getInt("precipitation"),
                                resultSet.getInt("glacial_altitude"),
                                resultSet.getInt("glacial_mass"),
                                resultSet.getString("wind_notes"),
                                resultSet.getString("humidity_notes"),
                                resultSet.getString("pressure_notes"),
                                resultSet.getString("temperature_notes"),
                                resultSet.getString("precipitation_notes"),
                                resultSet.getString("glacial_altitude_notes"),
                                resultSet.getString("glacial_mass_notes")
                        ));
                    }
                    return resultList;
                }
            }
        } catch (SQLException e) {
            System.err.println("Search surveys by id failed.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Retrieves points of interest associated with a monitoring center based on the center ID.
     *
     * @param centerid The ID of the monitoring center.
     * @return An ArrayList of PointOfInterest objects associated with the specified monitoring center.
     * @throws RemoteException If a remote communication error occurs.
     */
    @Override
    public ArrayList<PointOfInterest> selectPoisByCenter(int centerid) throws RemoteException {
        BasicDataSource dataSource = DbManager.getDataSource();
        String query = PredefinedQuery.select_queries.get(PredefinedQuery.Select.POIS_BY_CENTER);
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, centerid);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return getPointOfInterestList(resultSet);
                }
            }
        } catch (SQLException e) {
            System.err.println("Exception in selectPoisByCenter(), return null");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Retrieves monitoring center information based on the center ID.
     *
     * @param centerid The ID of the monitoring center.
     * @return The MonitoringCenter object representing the specified monitoring center.
     * @throws RemoteException If a remote communication error occurs.
     */
    @Override
    public MonitoringCenter selectCenterById(int centerid) throws RemoteException {
        BasicDataSource dataSource = DbManager.getDataSource();
        String query = PredefinedQuery.select_queries.get(PredefinedQuery.Select.CLIMATECENTER_BY_ID);
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, centerid);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return getRowMonitoringCenter(resultSet);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Exception in selectCenterById(), return null.");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Inserts a new point of interest into the database and returns its assigned ID.
     *
     * @param poi The PointOfInterest object representing the point of interest to be inserted.
     * @return The ID assigned to the inserted point of interest.
     * @throws RemoteException If a remote communication error occurs.
     */
    @Override
    public int insertPoi(PointOfInterest poi) throws RemoteException {
        BasicDataSource dataSource = DbManager.getDataSource();
        String query = PredefinedQuery.insert_queries.get(PredefinedQuery.Insert.POI);
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, poi.getName());
                preparedStatement.setString(2, poi.getCountry());
                preparedStatement.setDouble(3, poi.getLatitude());
                preparedStatement.setDouble(4, poi.getLongitude());
                try {
                    connection.setAutoCommit(false);
                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        connection.commit();
                        connection.setAutoCommit(true);
                        return checkPoiExists(poi);
                    }
                } catch (SQLException e) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    System.err.println("Exception in insertion transaction of new POI, rolling back database.");
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            System.err.println("Exception in insertPoi(), return -1.");
        }
        return -1;
    }

    /**
     * Retrieves the list of monitoring centers registered.
     *
     * @return An ArrayList of MonitoringCenter objects representing monitoring centers in the system.
     * @throws RemoteException If a remote communication error occurs.
     */
    @Override
    public ArrayList<MonitoringCenter> getCentersList() throws RemoteException {
        BasicDataSource dataSource = DbManager.getDataSource();
        String query = PredefinedQuery.select_queries.get(PredefinedQuery.Select.CLIMATECENTER);
        ArrayList<MonitoringCenter> resultList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    resultList.add(getRowMonitoringCenter(resultSet));
                }
                return resultList;
            }
        } catch (SQLException e) {
            System.err.println("Exception in getCenterList(), return null.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Checks if a user with the specified user ID exists in the database.
     *
     * @param userid The user ID to check.
     * @return True if the user exists, false otherwise.
     * @throws RemoteException If a remote communication error occurs.
     */
    @Override
    public boolean checkUserExists(String userid) throws RemoteException {
        boolean exists = false;
        BasicDataSource dataSource = DbManager.getDataSource();
        String query = PredefinedQuery.select_queries.get(PredefinedQuery.Select.USER_EXISTS);
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, userid);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        exists = resultSet.getBoolean(1);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Exception in checkUserExists(), return false.");
            e.printStackTrace();
        }
        return exists;
    }

    /**
     * Checks if a monitoring center with the specified information exists in the database and returns its assigned ID.
     *
     * @param center The MonitoringCenter object representing the center to check.
     * @return The ID of the existing center if it exists, or -1 if it does not.
     * @throws RemoteException If a remote communication error occurs.
     */
    public int checkCenterExists(MonitoringCenter center) throws RemoteException {
        BasicDataSource dataSource = DbManager.getDataSource();
        String query = PredefinedQuery.select_queries.get(PredefinedQuery.Select.CLIMATECENTER_BY_ATTRIBUTES);
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, center.getName());
                preparedStatement.setString(2, center.getAddress());
                preparedStatement.setInt(3, center.getAddressNumber());
                preparedStatement.setInt(4, center.getCap());
                preparedStatement.setString(5, center.getCity());
                preparedStatement.setString(6, center.getProvince());
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getInt("centerid");
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Exception checkCenterExists(), return -1.");
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * Checks if a point of interest with the specified information exists in the database and returns its assigned ID.
     *
     * @param poi The PointOfInterest object representing the point of interest to check.
     * @return The ID of the existing point of interest if it exists, or -1 if it does not.
     * @throws RemoteException If a remote communication error occurs.
     */
    @Override
    public int checkPoiExists(PointOfInterest poi) throws RemoteException {
        BasicDataSource dataSource = DbManager.getDataSource();
        String query = PredefinedQuery.select_queries.get(PredefinedQuery.Select.POI_BY_DATA);
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, poi.getName());
                preparedStatement.setString(2, poi.getCountry());
                preparedStatement.setDouble(3, poi.getLatitude());
                preparedStatement.setDouble(4, poi.getLongitude());
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        System.out.println(resultSet.getInt("poi_id"));
                        System.out.println(resultSet.getString("name"));
                        System.out.println(resultSet.getString("country"));
                        return resultSet.getInt("poi_id");
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Exception in checkPoiExists(), return -1");
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * Links a monitoring center to a list of points of interest.
     *
     * @param center  The MonitoringCenter object to link.
     * @param poiList An ArrayList of PointOfInterest objects to link to the center.
     * @throws RemoteException If a remote communication error occurs.
     */
    @Override
    public void linkCenterToPois(MonitoringCenter center, ArrayList<PointOfInterest> poiList) throws RemoteException {
        BasicDataSource dataSource = DbManager.getDataSource();
        String query = PredefinedQuery.insert_queries.get(PredefinedQuery.Insert.CENTER_POI);
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try {
                    int rowsAffected;
                    connection.setAutoCommit(false);
                    for (PointOfInterest poi : poiList) {
                        preparedStatement.setInt(1, center.getCenterid());
                        preparedStatement.setInt(2, poi.getPoi_id());
                        rowsAffected = preparedStatement.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Insert for center " + center.getCenterid() + " and poi " + poi.getPoi_id() + " completed succesfully.");
                        } else {
                            System.out.println("Insert for center " + center.getCenterid() + " and poi " + poi.getPoi_id() + " failed.");
                        }
                    }
                    connection.commit();
                    connection.setAutoCommit(true);
                } catch (SQLException e) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    System.err.println("Exception in insertion transaction in linkCenterToPois(), rolling back database.");
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            System.err.println("Exception in insertion of Center_Pois relations, rolling back database.");
            e.printStackTrace();
        }
    }

    /**
     * Links a point of interest to a monitoring center based on center ID.
     *
     * @param poi      The PointOfInterest object to link.
     * @param centerid The ID of the monitoring center to link the point of interest to.
     * @throws RemoteException If a remote communication error occurs.
     */
    @Override
    public void linkPoiToCenter(PointOfInterest poi, int centerid) throws RemoteException {
        BasicDataSource dataSource = DbManager.getDataSource();
        String query = PredefinedQuery.insert_queries.get(PredefinedQuery.Insert.CENTER_POI);
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try {
                    int rowsAffected;
                    connection.setAutoCommit(false);
                    preparedStatement.setInt(1, centerid);
                    preparedStatement.setInt(2, poi.getPoi_id());
                    rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Insert for center " + centerid + " and poi " + poi.getPoi_id() + " completed succesfully.");
                    } else {
                        System.out.println("Insert for center " + centerid + " and poi " + poi.getPoi_id() + " failed.");
                    }
                    connection.commit();
                    connection.setAutoCommit(true);
                } catch (SQLException e) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    System.err.println("Exception in insertion transaction in linkPoiToCenter(), rolling back database.");
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            System.err.println("Exception in insertion of Poi to center, rolling back database.");
            e.printStackTrace();
        }
    }

    //*****************PRIVATE METHODS*****************//

    /**
     * Builds a list of PointOfInterest objects from the provided ResultSet.
     *
     * @param rs The ResultSet containing data retrieved from the database.
     * @return An ArrayList of PointOfInterest objects.
     * @throws SQLException If a database access error occurs.
     */
    private ArrayList<PointOfInterest> getPointOfInterestList(ResultSet rs) throws SQLException{
        ArrayList<PointOfInterest> resultList = new ArrayList<>();
        while(rs.next()){
            resultList.add(new PointOfInterest(
                    rs.getInt("poi_id"),
                    rs.getFloat("latitude"),
                    rs.getFloat("longitude"),
                    rs.getString("name"),
                    rs.getString("country")
            ));
        }
        return resultList;
    }

    /**
     * Builds a single PointOfInterest object from the provided ResultSet.
     *
     * @param rs The ResultSet containing data retrieved from the database.
     * @return A PointOfInterest object.
     * @throws SQLException If a database access error occurs.
     */
    private PointOfInterest getRowPointOfInterest(ResultSet rs) throws SQLException{
        return new PointOfInterest(
                rs.getInt("poi_id"),
                rs.getFloat("latitude"),
                rs.getFloat("longitude"),
                rs.getString("name"),
                rs.getString("country")
        );
    }

    /**
     * Builds a single User object from the provided ResultSet.
     *
     * @param rs The ResultSet containing data retrieved from the database.
     * @return A User object.
     * @throws SQLException If a database access error occurs.
     */
    private User getRowUser(ResultSet rs) throws SQLException{
        User user = new User(
                rs.getString("name"),
                rs.getString("surname"),
                rs.getString("email"),
                rs.getString("userid"),
                rs.getString("fiscalcode"),
                rs.getString("hashedpassword")
        );
        user.setCenterid(rs.getInt("centerid"));
        return user;
    }

    /**
     * Builds a single MonitoringCenter object from the provided ResultSet.
     *
     * @param rs The ResultSet containing data retrieved from the database.
     * @return A MonitoringCenter object.
     * @throws SQLException If a database access error occurs.
     */
    private MonitoringCenter getRowMonitoringCenter(ResultSet rs) throws SQLException{
        return new MonitoringCenter(
                rs.getInt("centerid"),
                rs.getString("name"),
                rs.getString("address"),
                rs.getInt("addressnumber"),
                rs.getInt("cap"),
                rs.getString("city"),
                rs.getString("province")
        );
    }

}
