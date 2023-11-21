package org.climatemonitoring.shared;

import org.climatemonitoring.shared.models.PointOfInterest;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RemoteDatabaseServiceInterface extends Remote {

    ArrayList<PointOfInterest> cercaAreaGeograficaNome(String name,String state) throws RemoteException;

    ArrayList<PointOfInterest> cercaAreaGeograficaCoordinate(float latitude, float longitude) throws RemoteException;

}
