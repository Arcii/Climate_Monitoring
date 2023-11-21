package org.climatemonitoring.server.network;

import org.climatemonitoring.server.database.DbController;
import org.climatemonitoring.server.database.PredefinedQuery;
import org.climatemonitoring.shared.RemoteDatabaseServiceInterface;
import org.climatemonitoring.shared.models.PointOfInterest;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

public class RemoteDatabaseService extends UnicastRemoteObject implements RemoteDatabaseServiceInterface {

    private final DbController dbController;

    public RemoteDatabaseService() throws RemoteException {
        super();
        this.dbController = DbController.GetDbController(null,null);
    }

    public RemoteDatabaseService(String username, String password) throws RemoteException{
        super();
        this.dbController = DbController.GetDbController(username, password);
    }

    @Override
    public ArrayList<PointOfInterest> cercaAreaGeograficaNome(String name, String country) throws RemoteException{
        ArrayList<PointOfInterest> resultList = new ArrayList<>();
        String query = PredefinedQuery.select_queries.get(PredefinedQuery.Select.POI_BY_NAME);
        try (PreparedStatement preparedStatement = dbController.getDb_connection().prepareStatement(query)){
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.setString(2, "%" + country + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                resultList.add(new PointOfInterest(resultSet.getInt("poi_id"),resultSet.getFloat("latitude"),resultSet.getFloat("longitude"),resultSet.getString("name"),resultSet.getString("country")));
            }
        }catch (SQLException e){
            System.err.println("Search by name failed.");
            e.printStackTrace();
            return null;
        }
        return resultList;
    }

    @Override
    public ArrayList<PointOfInterest> cercaAreaGeograficaCoordinate(float latitude, float longitude) throws RemoteException{
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("0.#####", symbols);
        latitude = Float.parseFloat(df.format(latitude));
        longitude = Float.parseFloat(df.format(longitude));
        ArrayList<PointOfInterest> resultList = new ArrayList<>();
        String query = PredefinedQuery.select_queries.get(PredefinedQuery.Select.POI_BY_COORDINATES);
        ResultSet resultSet;
        try(PreparedStatement preparedStatement = dbController.getDb_connection().prepareStatement(query)){
            preparedStatement.setDouble(1, latitude - 0.00001);
            preparedStatement.setDouble(2, latitude + 0.00001);
            preparedStatement.setDouble(3, longitude - 0.00001);
            preparedStatement.setDouble(4, longitude + 0.00001);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                resultList.add(new PointOfInterest(resultSet.getInt("poi_id"),resultSet.getFloat("latitude"),resultSet.getFloat("longitude"),resultSet.getString("name"),resultSet.getString("country")));
                return resultList;
            }else{
                try(PreparedStatement nextPreparedStatement = dbController.getDb_connection().prepareStatement(PredefinedQuery.select_queries.get(PredefinedQuery.Select.POI))) {
                    resultSet = nextPreparedStatement.executeQuery();
                    while (resultSet.next()) {
                        resultList.add(new PointOfInterest(resultSet.getInt("poi_id"), resultSet.getFloat("latitude"), resultSet.getFloat("longitude"), resultSet.getString("name"), resultSet.getString("country")));
                    }
                    return resultList;
                }
            }
        }catch (SQLException e){
            System.err.println("Search by coordinates failed.");
            e.printStackTrace();
            return null;
        }
    }

}
