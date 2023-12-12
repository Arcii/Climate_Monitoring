package com.climatemonitoring.serverCM;

import com.climatemonitoring.serverCM.network.RemoteDatabaseService;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Objects;
import java.util.Scanner;

import static com.climatemonitoring.serverCM.database.DbManager.closeDataSource;

public class ServerMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RemoteDatabaseService remoteDatabaseService;
        System.out.println("Insert your postgresql username, or press Enter to log with the default credentials (the default credentials can be found in the DBconfig.config file) : ");
        try {
            String username = scanner.nextLine().trim();
            if (!Objects.equals(username, "")) {
                System.out.println("Insert your postgresql password : ");
                String password = scanner.nextLine().trim();
                remoteDatabaseService = new RemoteDatabaseService(username, password);
            } else {
                remoteDatabaseService = new RemoteDatabaseService(null, null);
            }

            // Creating a shutdown hook to ensure cleanup when the application is closed (to close the database connections pool mainly)
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                System.out.println("Shutting down...");
                closeDataSource();
                System.out.println("Shutdown complete.");
            }));

            System.out.println("DATABASE READY.");
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("RemoteDatabaseService",remoteDatabaseService);
            System.out.println("SERVER IS READY.");
        }catch (RemoteException e){
            e.printStackTrace();
        }
    }

}