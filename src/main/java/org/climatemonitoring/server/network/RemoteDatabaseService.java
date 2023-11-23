package org.climatemonitoring.server.network;

import org.apache.commons.dbcp2.BasicDataSource;
import org.climatemonitoring.server.database.DbManager;
import org.climatemonitoring.server.database.PredefinedQuery;
import org.climatemonitoring.shared.RemoteDatabaseServiceInterface;
import org.climatemonitoring.shared.models.PointOfInterest;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

public class RemoteDatabaseService extends UnicastRemoteObject implements RemoteDatabaseServiceInterface {

    public final DbManager dbManager;

    public RemoteDatabaseService() throws RemoteException {
        super();
        this.dbManager = DbManager.GetDbManager(null,null);
    }

    public RemoteDatabaseService(String username, String password) throws RemoteException{
        super();
        this.dbManager = DbManager.GetDbManager(username, password);
    }

    public DbManager getDbManager() {
        return dbManager;
    }

    @Override
    public ArrayList<PointOfInterest> cercaAreaGeograficaNome(String name, String country) throws RemoteException{
        ArrayList<PointOfInterest> resultList = new ArrayList<>();
        String query = PredefinedQuery.select_queries.get(PredefinedQuery.Select.POI_BY_NAME);
        BasicDataSource dataSource = DbManager.getDataSource();
        try(Connection connection= dataSource.getConnection()){
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, "%" + name + "%");
                preparedStatement.setString(2, "%" + country + "%");
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        resultList.add(new PointOfInterest(
                                resultSet.getInt("poi_id"),
                                resultSet.getFloat("latitude"),
                                resultSet.getFloat("longitude"),
                                resultSet.getString("name"),
                                resultSet.getString("country")
                        ));
                    }
                }
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

        BasicDataSource dataSource = DbManager.getDataSource();
        try(Connection connection = dataSource.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setDouble(1, latitude - 0.00001);
                preparedStatement.setDouble(2, latitude + 0.00001);
                preparedStatement.setDouble(3, longitude - 0.00001);
                preparedStatement.setDouble(4, longitude + 0.00001);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        resultList.add(new PointOfInterest(
                                resultSet.getInt("poi_id"),
                                resultSet.getFloat("latitude"),
                                resultSet.getFloat("longitude"),
                                resultSet.getString("name"),
                                resultSet.getString("country")
                        ));
                        return resultList;
                    } else {
                        try (PreparedStatement nextPreparedStatement = connection.prepareStatement(PredefinedQuery.select_queries.get(PredefinedQuery.Select.POI));
                             ResultSet nextResultSet = nextPreparedStatement.executeQuery()) {
                            while (nextResultSet.next()) {
                                resultList.add(new PointOfInterest(
                                        nextResultSet.getInt("poi_id"),
                                        nextResultSet.getFloat("latitude"),
                                        nextResultSet.getFloat("longitude"),
                                        nextResultSet.getString("name"),
                                        nextResultSet.getString("country")
                                ));
                            }
                            return resultList;
                        }
                    }
                }
            }
        }catch (SQLException e){
            System.err.println("Search by coordinates failed.");
            e.printStackTrace();
            return null;
        }

    }

}
