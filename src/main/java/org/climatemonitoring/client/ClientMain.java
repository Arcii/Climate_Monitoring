package org.climatemonitoring.client;

import org.climatemonitoring.client.gui.views.ClientHomeGUI;
import org.climatemonitoring.client.network.ClientManager;
import org.climatemonitoring.shared.models.PointOfInterest;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;


public class ClientMain {

    public static void main(String[] args) {
        ClientHomeGUI form = new ClientHomeGUI();
        form.setVisible(true);

        //Test
        ClientManager clientManager = new ClientManager();
        Scanner scanner = new Scanner(System.in);
        ArrayList<PointOfInterest> result;
        System.out.println("Testing select query on initialized Database.");

        try{
            while (true){
                System.out.println("Input 1 to search by name and 2 to search by coordinates : ");
                String input = scanner.nextLine();
                input = input.trim();
                if(input.equals("1")){
                    System.out.println("In Which state is the city you want to search : ");
                    String state = scanner.nextLine().trim();
                    System.out.println("City to search : ");
                    String city = scanner.nextLine().trim();
                    result = clientManager.cercaAreaGeograficaNome(city, state);
                    for (PointOfInterest poi : result) {
                        System.out.println(poi.toString());
                    }
                }else if(input.equals("2")){
                    System.out.println("latitude : ");
                    float latitude = Float.parseFloat(scanner.nextLine().trim());
                    System.out.println("longitude : ");
                    float longitude = Float.parseFloat(scanner.nextLine().trim());
                    result = clientManager.cercaAreaGeograficaCoordinate(latitude,longitude);
                    System.out.println(result.size());
                    for (PointOfInterest poi : result) {
                        System.out.println(poi.toString());
                    }
                }else{
                    System.out.println("Input not valid.");
                }
            }
        }catch (RemoteException e){
            e.printStackTrace();
        }
    }

}
