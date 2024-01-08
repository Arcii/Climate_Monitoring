package com.climatemonitoring.clientCM.network;

import com.climatemonitoring.shared.RemoteDatabaseServiceInterface;
import com.climatemonitoring.shared.models.*;

import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.*;
import static java.lang.Math.sqrt;

/**
 * The <code>ClientManager</code> class manages RMI communication with the server and provides utility
 * methods for the client side of the Climate Monitoring application.
 *
 * <p>
 * This class implements the Singleton pattern to ensure that only one instance of the
 * <code>ClientManager</code> is created for the entire client application. It handles the initialization
 * of the RMI service connection to the server and provides methods for various operations
 * such as searching for geographical areas, managing user registration, and interacting with
 * the remote database service.
 * </p>
 *
 * <p>
 * It also implements utility methods like calculation of the distance between two geographical coordinates
 * with the Haversine function and hashing of password input with SHA-256.
 * </p>
 *
 * @author Lorenzo Cattapan 726459 (Varese)
 * @version 0.9.0
 * @see RemoteDatabaseServiceInterface
 */
public class ClientManager {

    //*****************FIELDS*****************//

    /**
     * The singleton instance of the `ClientManager`.
     */
    private static ClientManager clientManager;
    /**
     * The default IP address of the server.
     */
    private final String defaultServerIpAddress = "localhost";
    /**
     * The RMI service interface for communication with the remote database service.
     */
    private RemoteDatabaseServiceInterface rmiService;

    //*****************PRIVATE CONSTRUCTORS FOR SINGLETON PATTERN*****************//

    /**
     * Private constructor to create a new `ClientManager` instance.
     * Initializes the RMI service connection to the default server.
     */
    private ClientManager(){
        try {
            Registry registry = LocateRegistry.getRegistry(defaultServerIpAddress, 1099);
            this.rmiService = (RemoteDatabaseServiceInterface) registry.lookup("RemoteDatabaseService");
        }catch (RemoteException e){
            System.err.println("The Climate Monitoring Server is not running");
            System.err.println("Make sure the Climate Monitoring server is up and running before launching the client");
            System.err.println("Closing Client...");
            System.exit(0);
        } catch (NotBoundException e) {
            System.err.println("NotBoundException in ClientManager constructor");
            e.printStackTrace();
        }
    }

    /**
     * Private constructor to create a new `ClientManager` instance with a specified server IP address.
     * Initializes the RMI service connection to the specified server.
     *
     * @param serverIpAddress The IP address of the server.
     */
    private ClientManager(String serverIpAddress) {
        try {
            Registry registry = LocateRegistry.getRegistry(serverIpAddress, 1099);
            this.rmiService = (RemoteDatabaseServiceInterface) registry.lookup("RemoteDatabaseService");
        }catch (RemoteException e){
            System.err.println("RemoteException in ClientManager constructor");
            e.printStackTrace();
        } catch (NotBoundException e) {
            System.err.println("NotBoundException in ClientManager constructor");
            e.printStackTrace();
        }
    }

    //*****************SINGLETON*****************//

    /**
     * Gets the singleton instance of the `ClientManager`. If an instance
     * does not exist, a new one is created.
     *
     * @return The singleton instance of the `ClientManager`.
     */
    public static ClientManager GetClientManager(){
        if( clientManager == null){
            clientManager = new ClientManager();
        }
        return clientManager;
    }

    //*****************GETTER AND SETTER*****************//

    /**
     * Gets the RMI service interface.
     *
     * @return The RMI service interface.
     */
    public RemoteDatabaseServiceInterface getRmiService() {
        return rmiService;
    }

    /**
     * Sets the RMI service interface.
     *
     * @param rmiService The RMI service interface to set.
     */
    public void setRmiService(RemoteDatabaseServiceInterface rmiService) {
        this.rmiService = rmiService;
    }

    //*****************PUBLIC METHODS*****************//

    /**
     * Query the database through the RMI connection and returns the result, which contains
     * the Point of Interest searched by name and country.
     *
     * <p>
     * It may return more than one Point of Interest, that is because the query used on the server side contains
     * the 'LIKE' operator on the name and country parameter.
     * </p>
     *
     * @param name The name of the Point of Interest.
     * @param country The country of Point of Interest.
     * @return An ArrayList of PointOfInterest objects representing the search results.
     */
    public ArrayList<PointOfInterest> cercaAreaGeograficaNome(String name, String country) {
        try {
            return rmiService.cercaAreaGeograficaNome(name, country);
        }catch (RemoteException e){
            System.err.println("Remote Exception in cercaAreaGeograficaNome() remote call.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Query the database through the RMI connection and returns the result, which contains
     * the Point of Interest searched by coordinates.
     *
     * <p>
     * If no Point of Interest is found at the specified coordinates it returns a list of the closest Points of
     * Interest
     * </p>
     *
     * @param latitude The latitude of the location.
     * @param longitude The longitude of the location.
     * @return An ArrayList of PointOfInterest objects representing the search results.
     */
    public ArrayList<PointOfInterest> cercaAreaGeograficaCoordinate(float latitude, float longitude) {
        try {
            DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
            DecimalFormat df = new DecimalFormat("0.#####", symbols);
            latitude = Float.parseFloat(df.format(latitude));
            longitude = Float.parseFloat(df.format(longitude));
            ArrayList<PointOfInterest> pointOfInterests = rmiService.cercaAreaGeograficaCoordinate(latitude, longitude);
            if (pointOfInterests.size() == 1) {
                return pointOfInterests;
            } else {
                return getListClosest(pointOfInterests, latitude, longitude);
            }
        }catch (RemoteException e){
            System.err.println("Remote Exception in cercaAreaGeograficaCoordinate() remote call.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Query the database through the RMI connection and return the result, which contains aggregate informations about a Point of Interest.
     *
     * @param poi_id The ID of the PointOfInterest.
     * @return A SurveysAggregate object containing information about the geographical area.
     */
    public SurveysAggregate visualizzaAreaGeografica(int poi_id){
        try{
            return rmiService.visualizzaAreaGeografica(poi_id);
        }catch (RemoteException e){
            System.err.println("Remote Exception in getSurveysAggregate() remote call.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Registers a new User using the RMI connection and returns if the registration is successful.
     *
     * <p>
     * In the server side of the application a new user with the specified information is added to
     * the appropriate table of the database.
     * </p>
     *
     * @param user The User object representing the new user.
     * @param centerid The ID of the monitoring center of the new user.
     * @return true if registration is successful, false otherwise.
     */
    public boolean registrazione(User user, int centerid){
        try {
            return rmiService.registrazione(user, centerid);
        }catch (RemoteException e){
            System.err.println("Remote Exception in completeRegistration() remote call.");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Registers a new Monitoring Center using the RMI connection and returns the id given to it.
     *
     * <p>
     * In the server side of the application a new Monitoring Center with the specified information is added to
     * the appropriate table of the database.
     * </p>
     *
     * @param center The MonitoringCenter object representing the new monitoring center.
     * @return The ID of the registered monitoring center, or -1 if registration fails.
     */
    public int registraCentroAree(MonitoringCenter center){
        try {
            return rmiService.registraCentroAree(center);
        }catch (RemoteException e){
            System.err.println("Remote Exception in completeRegistrationCenter() remote call.");
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Inserts a survey containing climatic parameters for a specific Point Of Interest using the RMI connection in the database.
     *
     * @param survey The Survey object containing climatic parameters and the id of the Point Of Interest to which the survey refers.
     * @return The ID of the inserted survey, or -1 if insertion fails.
     */
    public int inserisciParametriClimatici(Survey survey){
        try{
            return rmiService.inserisciParametriClimatici(survey);
        }catch (RemoteException e){
            System.err.println("Remote Exception insertSurvey() remote call.");
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Logs in a user as an operator for his Monitoring Center in the Climate Monitoring application using the RMI connection.
     *
     * @param userid The user ID.
     * @param hashedpassword The hashed password.
     * @return The User object representing the logged-in user, or null if login fails.
     */
    public User userLogin(String userid, String hashedpassword){
        try {
            return rmiService.userLogin(userid, hashedpassword);
        }catch (RemoteException e){
            System.err.println("Remote Exception in userLogin() remote call.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Query the database through the RMI connection and retrieves a list of geographical areas associated with a monitoring center.
     *
     * @param centerid The ID of the monitoring center.
     * @return An ArrayList of PointOfInterest objects associated with the monitoring center.
     */
    public ArrayList<PointOfInterest> selectPoisByCenter(int centerid){
        try {
            return rmiService.selectPoisByCenter(centerid);
        }catch (RemoteException e){
            System.err.println("Remote Exception in selectPoisByCenter() remote call.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Takes a list of Points Of Interest and calls insertPoi() method for each one.
     *
     * @param poiList The ArrayList of PointOfInterest objects to insert.
     * @return The ArrayList of PointOfInterest objects with updated IDs.
     * @throws Exception If there is an issue with the insertion.
     */
    public ArrayList<PointOfInterest> insertPois(ArrayList<PointOfInterest> poiList) throws Exception{
        for (PointOfInterest poi : poiList) {
            if(poi.getPoi_id()<=0){
                int createdPoi_id = insertPoi(poi);
                if(createdPoi_id<=0){
                    throw new Exception("Si è riscontrato un problema con l'inserimento di uno o più Aree aggiunte e non già presenti, riprova o cancella le Aree nella lista (solo quelle con ID = 0) e reinseriscile");
                }
                poi.setPoi_id(createdPoi_id);
            }
        }
        return poiList;
    }

    /**
     * Inserts a Point Of Interest into the database through the RMI connection and returns the id given to it or -1 if the insertion fails.
     *
     * @param poi The PointOfInterest object to insert.
     * @return The ID of the inserted geographical area, or -1 if insertion fails.
     */
    public int insertPoi(PointOfInterest poi){
        try{
            return rmiService.insertPoi(poi);
        }catch (RemoteException e){
            System.err.println("Remote Exception in insertPoi() remote call.");
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Query the database through the RMI connection and retrieves a list of monitoring centers from the server.
     *
     * @return An ArrayList of MonitoringCenter objects representing monitoring centers.
     */
    public ArrayList<MonitoringCenter> getCentersList(){
        try {
            return rmiService.getCentersList();
        }catch (RemoteException e){
            System.err.println("Remote Exception in getCenterList() remote call.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Query the database through the RMI connection and checks if a user with the specified ID exists.
     *
     * @param userid The user ID to check.
     * @return true if the user exists, false otherwise.
     */
    public boolean checkUserExists(String userid){
        try {
            return rmiService.checkUserExists(userid);
        }catch (RemoteException e){
            System.err.println("Remote Exception in checkUserExists() remote call.");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Query the database through the RMI connection and checks if a monitoring center with the specified details exists.
     *
     * @param name The name of the monitoring center.
     * @param address The address of the monitoring center.
     * @param addressnumber The address number of the monitoring center.
     * @param cap The postal code of the monitoring center.
     * @param city The city of the monitoring center.
     * @param province The province of the monitoring center.
     * @return The ID of the monitoring center if it exists, or -1 otherwise.
     */
    public int checkCenterExists(String name,String address, String addressnumber, String cap, String city, String province){
        try {
            return rmiService.checkCenterExists(new MonitoringCenter(0,name,address,Integer.parseInt(addressnumber),Integer.parseInt(cap),city,province));
        }catch (RemoteException e){
            System.err.println("Remote Exception in checkCenterExists() remote call.");
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Query the database through the RMI connection and checks if a geographical area exists in the database.
     *
     * @param poi The PointOfInterest object representing the geographical area.
     * @return The ID of the Point Of Interest if it exists, or -1 otherwise.
     */
    public int checkPoiExists(PointOfInterest poi){
        try {
            return rmiService.checkPoiExists(poi);
        }catch (RemoteException e){
            System.err.println("Remote Exception in checkPoiExists() remote call.");
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Links a monitoring center to a list of Points Of Interest using the RMI connection in the database.
     *
     * @param center The MonitoringCenter object to link.
     * @param poiList The ArrayList of PointOfInterest objects to link.
     */
    public void linkCenterToPois(MonitoringCenter center, ArrayList<PointOfInterest> poiList){
        try {
            rmiService.linkCenterToPois(center,poiList);
        }catch (RemoteException e){
            System.err.println("Remote Exception in linkCenterToPois() remote call.");
            e.printStackTrace();
        }
    }

    /**
     * Links a Point Of Interest to a Monitoring Center using the RMI connection in the database.
     *
     * @param poi The PointOfInterest object to link.
     * @param centerid The ID of the monitoring center.
     */
    public void linkPoiToCenter(PointOfInterest poi, int centerid){
        try {
            rmiService.linkPoiToCenter(poi,centerid);
        }catch (RemoteException e){
            System.err.println("Remote Exception in linkPoiToCenter() remote call.");
            e.printStackTrace();
        }
    }

    //*****************STATIC METHODS*****************//

    /**
     * Computes the SHA-256 hash of the given password.
     *
     * @param password The character array representing the password.
     * @return The hexadecimal representation of the hashed password.
     */
    public static String hashPasswordSHA256(char[] password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(new String(password).getBytes());
            Arrays.fill(password, '\0');

            // Convert bytes to hexadecimal representation
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : hashedBytes) {
                stringBuilder.append(String.format("%02x", b));
            }

            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Checks if the input string is a valid UTF-8 encoded string.
     *
     * @param input The input string to check.
     * @return true if the string is a valid UTF-8 encoded string; false otherwise.
     */
    public static boolean isValidUtf8(String input) {
        CharsetDecoder utf8Decoder = StandardCharsets.UTF_8.newDecoder();
        utf8Decoder.onMalformedInput(CodingErrorAction.REPORT);
        utf8Decoder.onUnmappableCharacter(CodingErrorAction.REPORT);
        try {
            utf8Decoder.decode(java.nio.ByteBuffer.wrap(input.getBytes(StandardCharsets.UTF_8)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if the input string contains only letters.
     *
     * @param string The input string to check.
     * @return true if the string contains only letters; false otherwise.
     */
    public static boolean isOnlyLettersString(String string){
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    /**
     * Checks if the input string contains only letters and spaces.
     *
     * @param string The input string to check.
     * @return true if the string contains only letters and spaces; false otherwise.
     */
    public static boolean isOnlyLettersAndSpacesString(String string){
        Pattern pattern = Pattern.compile("^[a-zA-Z\\s]+$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    /**
     * Checks if the input string contains only numbers.
     *
     * @param string The input string to check.
     * @return true if the string contains only numbers; false otherwise.
     */
    public static boolean isOnlyNumbersString(String string){
        try {
            Integer.parseInt(string);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    /**
     * Checks if the input string contains only letters or numbers.
     *
     * @param string The input string to check.
     * @return true if the string contains only letters or numbers; false otherwise.
     */
    public static boolean isOnlyLettersOrNumbersString(String string){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    /**
     * Validates the format of the input email address.
     *
     * @param email The email address to validate.
     * @return true if the email address is valid; false otherwise.
     */
    public  static boolean isValidEmail(String email){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * Validates the format of the input postal code (CAP).
     *
     * @param cap The postal code to validate.
     * @return true if the postal code is valid; false otherwise.
     */
    public static boolean isValidCap(String cap) {
        return Pattern.matches("\\d{5}", cap);
    }

    /**
     * Checks if the input string contains only ASCII characters.
     *
     * @param string The input string to check.
     * @return true if the string contains only ASCII characters; false otherwise.
     */
    public static boolean isAsciiString(String string){
        return Pattern.matches("\\A\\p{ASCII}*\\z",string);
    }

    /**
     * Validates the format of the input fiscal code.
     *
     * @param fiscalCode The fiscal code to validate.
     * @return true if the fiscal code is valid; false otherwise.
     */
    public static boolean isValidFiscalCode(String fiscalCode){
        return Pattern.matches("^[A-Z]{6}\\d{2}[ABCDEHLMPRST]\\d{2}[A-Z]\\d{3}[A-Z]$", fiscalCode);
    }

    /**
     * Validates the input score to be within the range of 1 to 5.
     *
     * @param score The score to validate.
     * @return true if the score is valid; false otherwise.
     */
    public static boolean isValidScore(int score){
        return score <= 5 && score >= 1;
    }

    //*****************PRIVATE METHODS*****************//

    /**
     * Retrieves a list of points of interest that are within a specified maximum distance (10 km hardcoded in the method)
     * from a given coordinate.
     *
     * @param results   The list of points of interest to filter.
     * @param latitude  The latitude of the reference point.
     * @param longitude The longitude of the reference point.
     * @return An ArrayList containing points of interest within the specified maximum distance.
     */
    private ArrayList<PointOfInterest> getListClosest(ArrayList<PointOfInterest> results, float latitude, float longitude){
        ArrayList<PointOfInterest> resultList = new ArrayList<>();
        float maxDistance = 10.0f; // Maximum distance in kilometers
        float distance;
        for(PointOfInterest poi : results){
            distance = haversine(poi.getLatitude(),poi.getLongitude(),latitude,longitude);
            if(distance<maxDistance){
                resultList.add(poi);
            }
        }
        return resultList;
    }

    /**
     * Calculates the Haversine distance between two geographical coordinates.
     *
     * @param lat1 The latitude of the first point.
     * @param lon1 The longitude of the first point.
     * @param lat2 The latitude of the second point.
     * @param lon2 The longitude of the second point.
     * @return The Haversine distance between the two points in kilometers.
     */
    private static float haversine(float lat1, float lon1, float lat2, float lon2) {
        lat1 = (float) toRadians(lat1);
        lon1 = (float) toRadians(lon1);
        lat2 = (float) toRadians(lat2);
        lon2 = (float) toRadians(lon2);

        // Haversine formula
        float dlat = lat2 - lat1;
        float dlon = lon2 - lon1;
        float a = (float) (sin(dlat / 2) * sin(dlat / 2) + cos(lat1) * cos(lat2) * sin(dlon / 2) * sin(dlon / 2));
        float c = 2 * (float) atan2(sqrt(a), sqrt(1 - a));

        // Radius of the Earth in kilometers (mean value)
        float radius = 6371.0f;

        // Calculate the distance
        return radius * c;
    }

}
