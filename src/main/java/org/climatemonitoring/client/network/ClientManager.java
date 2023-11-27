package org.climatemonitoring.client.network;

import org.climatemonitoring.shared.RemoteDatabaseServiceInterface;
import org.climatemonitoring.shared.models.MonitoringCenter;
import org.climatemonitoring.shared.models.PointOfInterest;
import org.climatemonitoring.shared.models.Survey;
import org.climatemonitoring.shared.models.User;

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

public class ClientManager {

    private static ClientManager clientManager;
    private final String defaultServerIpAddress = "localhost";
    private RemoteDatabaseServiceInterface rmiService;

    public ClientManager(){
        try {
            Registry registry = LocateRegistry.getRegistry(defaultServerIpAddress, 1099);
            this.rmiService = (RemoteDatabaseServiceInterface) registry.lookup("RemoteDatabaseService");
        }catch (RemoteException e){
            System.err.println("RemoteException in ClientManager constructor");
            e.printStackTrace();
        } catch (NotBoundException e) {
            System.err.println("NotBoundException in ClientManager constructor");
            e.printStackTrace();
        }
    }

    public ClientManager(String serverIpAddress) {
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

    //SINGLETON
    public static ClientManager GetClientManager(){
        if( clientManager== null){
            clientManager = new ClientManager();
        }
        return clientManager;
    }

    public RemoteDatabaseServiceInterface getRmiService() {
        return rmiService;
    }

    public void setRmiService(RemoteDatabaseServiceInterface rmiService) {
        this.rmiService = rmiService;
    }

    public ArrayList<PointOfInterest> cercaAreaGeograficaNome(String name, String country) {
        try {
            return rmiService.cercaAreaGeograficaNome(name, country);
        }catch (RemoteException e){
            System.err.println("Remote Exception in cercaAreaGeograficaNome() remote call.");
            e.printStackTrace();
            return null;
        }
    }

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

    public ArrayList<Survey> selectSurveysById(int poi_id){
        try {
            return rmiService.selectSurveysById(poi_id);
        }catch (RemoteException e){
            System.err.println("Remote Exception in selectSurveys() remote call.");
            e.printStackTrace();
            return null;
        }
    }

    public User userLogin(String userid, String hashedpassword){
        try {
            return rmiService.userLogin(userid, hashedpassword);
        }catch (RemoteException e){
            System.err.println("Remote Exception in userLogin() remote call.");
            e.printStackTrace();
            return null;
        }
    }

    public boolean checkUserExists(String userid){
        try {
            return rmiService.checkUserExists(userid);
        }catch (RemoteException e){
            System.err.println("Remote Exception in checkUserExists() remote call.");
            e.printStackTrace();
            return false;
        }
    }

    public boolean completeRegistrationUser(User user, int centerid){
        try {
            return rmiService.completeRegistrationUser(user, centerid);
        }catch (RemoteException e){
            System.err.println("Remote Exception in completeRegistration() remote call.");
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<MonitoringCenter> getCentersList(){
        try {
            return rmiService.getCentersList();
        }catch (RemoteException e){
            System.err.println("Remote Exception in getCenterList() remote call.");
            e.printStackTrace();
            return null;
        }
    }

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

    public static boolean isOnlyLettersString(String string){
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static boolean isOnlyLettersOrNumbersString(String string){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public  static boolean isValidEmail(String email){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    //PRIVATE METHODS

    private ArrayList<PointOfInterest> getListClosest(ArrayList<PointOfInterest> results, float latitude, float longitude){
        ArrayList<PointOfInterest> resultList = new ArrayList<>();
        float maxDistance = 10.0f;
        float distance;
        for(PointOfInterest poi : results){
            distance = haversine(poi.getLatitude(),poi.getLongitude(),latitude,longitude);
            if(distance<maxDistance){
                resultList.add(poi);
            }
        }
        return resultList;
    }

    private static float haversine(float lat1, float lon1, float lat2, float lon2) {
        // Convert latitude and longitude from degrees to radians
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
