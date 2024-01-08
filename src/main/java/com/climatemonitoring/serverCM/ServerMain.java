package com.climatemonitoring.serverCM;

import com.climatemonitoring.serverCM.network.RemoteDatabaseService;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Objects;
import java.util.Scanner;

import static com.climatemonitoring.serverCM.database.DbManager.closeDataSource;

/**
 * The main class for the server side of the Climate Monitoring application.
 * This class initializes and starts the server, allowing remote access to the database service.
 *
 * @author Lorenzo Cattapan 726459 (Varese)
 * @version 0.9.0
 * @see com.climatemonitoring.serverCM
 */
public class ServerMain {

    /**
     * The entry point for starting the Climate Monitoring server.
     *
     * <p>
     * If a username and password is provided for the database connection it calls the necessary methods to connect to it, if no input is provided as an username
     * it calls the necessary methods to connect to a database with the username and password stored in the DBconfig.config file stored inside the 'resources/config'
     * folder.
     * </p>
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RemoteDatabaseService remoteDatabaseService;

        //Asking the user for username and password for the PostgreSQL connection or using the default credentials in DBconfig.config
        //Creating the RemoteDatabaseService skeleton
        System.out.println("Insert your postgresql username, or press Enter to log with the default credentials (the default credentials can be found in the DBconfig.config file inside the jar launched) : ");
        try {
            String username = scanner.nextLine().trim();
            if (!Objects.equals(username, "")) {
                System.out.println("Insert your postgresql password : ");
                String password = scanner.nextLine().trim();
                remoteDatabaseService = new RemoteDatabaseService(username, password);
            } else {
                remoteDatabaseService = new RemoteDatabaseService(null, null);
            }

            // Creating a shutdown hook to ensure cleanup when the application is closed
            // (to close the database connections pool mainly)
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                System.out.println("Shutting down...");
                closeDataSource();
                System.out.println("Shutdown complete.");
            }));

            System.out.println("DATABASE READY.");

            //Starting RemoteDatabaseService service on the RMI Registry on the default port 1099
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("RemoteDatabaseService",remoteDatabaseService);
            System.out.println("SERVER IS READY.");
        }catch (RemoteException e){
            e.printStackTrace();
        }
    }

}