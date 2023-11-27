package org.climatemonitoring.server.network;

import org.apache.commons.dbcp2.BasicDataSource;
import org.climatemonitoring.server.database.DbManager;
import org.climatemonitoring.server.database.PredefinedQuery;
import org.climatemonitoring.shared.RemoteDatabaseServiceInterface;
import org.climatemonitoring.shared.models.MonitoringCenter;
import org.climatemonitoring.shared.models.PointOfInterest;
import org.climatemonitoring.shared.models.Survey;
import org.climatemonitoring.shared.models.User;

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
                        resultList.add(getRowPointOfInterest(resultSet));
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
                        resultList.add(getRowPointOfInterest(resultSet));
                        return resultList;
                    } else {
                        try (PreparedStatement nextPreparedStatement = connection.prepareStatement(PredefinedQuery.select_queries.get(PredefinedQuery.Select.POI));
                             ResultSet nextResultSet = nextPreparedStatement.executeQuery()) {
                            while (nextResultSet.next()) {
                                resultList.add(getRowPointOfInterest(nextResultSet));
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

    @Override
    public User userLogin(String userid, String hashedpassword) throws RemoteException {
        BasicDataSource dataSource = DbManager.getDataSource();
        String query = PredefinedQuery.select_queries.get(PredefinedQuery.Select.USER_LOGIN_INFO);
        try(Connection connection = dataSource.getConnection()){
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
                preparedStatement.setString(1, userid);
                preparedStatement.setString(2, hashedpassword);
                try(ResultSet resultSet = preparedStatement.executeQuery()){
                    if(resultSet.next()){
                        return getRowUser(resultSet);
                    }
                }
            }
        }catch (SQLException e){
            System.err.println("Exception in login, login failed.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<MonitoringCenter> getCentersList() throws RemoteException{
        BasicDataSource dataSource = DbManager.getDataSource();
        String query = PredefinedQuery.select_queries.get(PredefinedQuery.Select.CLIMATECENTER);
        ArrayList<MonitoringCenter> resultList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    resultList.add(getRowMonitoringCenter(resultSet));
                }
                return resultList;
            }
        }catch (SQLException e){
            System.err.println("Exception in getCenterList(), return null.");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public MonitoringCenter selectCenterById(int centerid) throws RemoteException{
        BasicDataSource dataSource = DbManager.getDataSource();
        String query = PredefinedQuery.select_queries.get(PredefinedQuery.Select.CLIMATECENTER_BY_ID);
        try (Connection connection = dataSource.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
                preparedStatement.setInt(1, centerid);
                try (ResultSet resultSet = preparedStatement.executeQuery()){
                    if(resultSet.next()){
                        return getRowMonitoringCenter(resultSet);
                    }
                }
            }
        }catch (SQLException e){
            System.err.println("Exception in selectCenterById(), return null.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean completeRegistrationUser(User user, int centerid) throws RemoteException {
        BasicDataSource dataSource = DbManager.getDataSource();
        String query = PredefinedQuery.insert_queries.get(PredefinedQuery.Insert.USER);
        try(Connection connection = dataSource.getConnection()){
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
                preparedStatement.setString(1, user.getUserid());
                preparedStatement.setString(2, user.getName());
                preparedStatement.setString(3, user.getSurname());
                preparedStatement.setString(4, user.getEmail());
                preparedStatement.setString(5, user.getFiscalCode());
                preparedStatement.setString(6, user.getHashedPassword());
                preparedStatement.setInt(7, centerid);
                int rowsAffected = preparedStatement.executeUpdate();
                if( rowsAffected == 1){
                    return true;
                }else{
                    System.err.println("Insertion for registration rowsAffected = " + rowsAffected);
                }
            }
        }catch (SQLException e){
            System.err.println("Exception completeRegistration(), return false.");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkUserExists(String userid){
        BasicDataSource dataSource = DbManager.getDataSource();
        String query = PredefinedQuery.select_queries.get(PredefinedQuery.Select.USER_EXISTS);
        try(Connection connection = dataSource.getConnection()){
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
                preparedStatement.setString(1,userid);
                try (ResultSet resultSet = preparedStatement.executeQuery()){
                    if (resultSet.next()) {
                        return  resultSet.getBoolean(1);
                    }
                }
            }
        }catch (SQLException e){
            System.err.println("Exception checkUserExists(), return false.");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList<Survey> selectSurveysById(int poi_id) throws RemoteException{
        ArrayList<Survey> resultList = new ArrayList<>();
        String query = PredefinedQuery.select_queries.get(PredefinedQuery.Select.SURVEY_BY_ID);
        BasicDataSource dataSource = DbManager.getDataSource();
        try(Connection connection = dataSource.getConnection()) {
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, poi_id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        resultList.add(new Survey(
                                resultSet.getInt("dataid"),
                                resultSet.getInt("poi_id"),
                                resultSet.getInt("centerid"),
                                resultSet.getTimestamp("timestamp"),
                                resultSet.getInt("wind"),
                                resultSet.getInt("humidity"),
                                resultSet.getInt("pressure"),
                                resultSet.getInt("temperature"),
                                resultSet.getInt("precipitation"),
                                resultSet.getInt("glacial_altitude"),
                                resultSet.getInt("glacial_mass"),
                                resultSet.getString("wind_notes"),
                                resultSet.getString("humidity_notes"),
                                resultSet.getString("pressure_notes"),
                                resultSet.getString("temperature_notes"),
                                resultSet.getString("precipitation_notes"),
                                resultSet.getString("glacial_altitude_notes"),
                                resultSet.getString("glacial_mass_notes")
                        ));
                    }
                    return resultList;
                }
            }
        }catch (SQLException e){
            System.err.println("Search surveys by id failed.");
            e.printStackTrace();
            return null;
        }
    }



    //PRIVATE METHODS

    private PointOfInterest getRowPointOfInterest(ResultSet rs) throws SQLException{
        return new PointOfInterest(
                rs.getInt("poi_id"),
                rs.getFloat("latitude"),
                rs.getFloat("longitude"),
                rs.getString("name"),
                rs.getString("country")
        );
    }

    private User getRowUser(ResultSet rs) throws SQLException{
        return new User(
                rs.getString("name"),
                rs.getString("surname"),
                rs.getString("email"),
                rs.getString("userid"),
                rs.getString("fiscalcode"),
                rs.getString("hashedpassword")
        );
    }

    private MonitoringCenter getRowMonitoringCenter(ResultSet rs) throws SQLException{
        return new MonitoringCenter(
                rs.getInt("centerid"),
                rs.getString("name"),
                rs.getString("address"),
                rs.getInt("addressnumber"),
                rs.getInt("cap"),
                rs.getString("city"),
                rs.getString("province")
        );
    }

}
