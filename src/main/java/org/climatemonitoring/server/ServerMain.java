package org.climatemonitoring.server;

import org.climatemonitoring.server.network.RemoteDatabaseService;
import org.climatemonitoring.shared.models.PointOfInterest;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ServerMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RemoteDatabaseService remoteDatabaseService;
        System.out.println("Insert your postgresql username, or press Enter to log with the default credentials : ");
        try {
            String username = scanner.nextLine();
            if (!Objects.equals(username, "")) {
                System.out.println("Insert your postgresql password : ");
                String password = scanner.nextLine();
                remoteDatabaseService = new RemoteDatabaseService(username, password);
            } else {
                remoteDatabaseService = new RemoteDatabaseService(null, null);
            }
            System.out.println("DATABASE READY.");
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("RemoteDatabaseService",remoteDatabaseService);
            System.out.println("SERVER IS READY.");
        }catch (RemoteException e){
            e.printStackTrace();
        }
    }

}