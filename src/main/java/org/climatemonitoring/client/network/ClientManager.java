package org.climatemonitoring.client.network;

import org.climatemonitoring.shared.RemoteDatabaseServiceInterface;
import org.climatemonitoring.shared.models.PointOfInterest;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

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
