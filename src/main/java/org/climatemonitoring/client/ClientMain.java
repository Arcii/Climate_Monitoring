package org.climatemonitoring.client;

import org.climatemonitoring.client.gui.views.ClientHomeGUI;
import org.climatemonitoring.client.network.ClientController;
import org.climatemonitoring.server.network.RemoteDatabaseService;
import org.climatemonitoring.shared.models.PointOfInterest;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class ClientMain {

    public static void main(String[] args) {
        ClientHomeGUI form = new ClientHomeGUI();
        form.setVisible(true);

        //Test
        ClientController clientController = new ClientController();
        Scanner scanner = new Scanner(System.in);
        ArrayList<PointOfInterest> result;
        System.out.println("Testing select query on initialized Database.");
        /*
        try {
            while (true) {
                System.out.println("In Which state is the city you want to search : ");
                String state = scanner.nextLine().trim();
                System.out.println("City to search : ");
                String city = scanner.nextLine().trim();
                result = remoteDatabaseService.cercaAreaGeograficaNome(city, state);
                for (PointOfInterest poi : result) {
                    System.out.println(poi.toString());
                }
            }
        }
        */
        try{
            while (true){
                System.out.println("latitude : ");
                float latitude = Float.parseFloat(scanner.nextLine().trim());
                System.out.println("longitude : ");
                float longitude = Float.parseFloat(scanner.nextLine().trim());
                result = clientController.cercaAreaGeograficaCoordinate(latitude,longitude);
                System.out.println(result.size());
                for (PointOfInterest poi : result) {
                    System.out.println(poi.toString());
                }
            }
        }catch (RemoteException e){
            e.printStackTrace();
        }
    }

}
