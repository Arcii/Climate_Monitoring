package org.climatemonitoring.server.database;

import java.io.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.commons.dbcp2.BasicDataSource;

public class DbManager {

    private static DbManager controller;
    private Connection db_server_connection;
    private static final String DB_CONFIG_PATH = "src/main/resources/config/DBconfig.config";
    private static final String DB_NAME = "dbcm";
    private static final String JDBC_URL = "jdbc:postgresql://localhost/dbcm";
    private static String jdbcUser;
    private static String jdbcPassword;
    private static BasicDataSource dataSource;


    // Initialize the DBCP DataSource
    static {
        dataSource = new BasicDataSource();
        dataSource.setUrl(JDBC_URL);
        dataSource.setUsername(jdbcUser);
        dataSource.setPassword(jdbcPassword);
        // Configure other DBCP settings as needed
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxOpenPreparedStatements(100);
    }

    private DbManager(String username, String password) {
        BufferedReader db_Config;
        try {
            db_Config = new BufferedReader(new FileReader(DB_CONFIG_PATH));
            if(username==null || password==null){
                ConnectToDb(db_Config.readLine(), db_Config.readLine(), db_Config.readLine());
            }else {
                ConnectToDb(db_Config.readLine(), username, password);
            }
            db_Config.close();
        }catch (IOException e){
            System.err.println("Reading error in db_config, DbController not set up.");
            e.printStackTrace();
        }
        if(!CheckDbExists()) {
            System.out.println("Database dbcm does not exist, starting the create process ...");
            DbCreate();
            DbCreateTables();
            DbInitialize();
            System.out.println("Database ready.");
        }else{
            System.out.println("Database dbcm already exists, reconnecting ...");
            ReconnectToDb();
        }
    }

    //SINGLETON
    public static DbManager GetDbManager(String username, String password){
        if(controller == null){
            controller = new DbManager(username, password);
        }
        return controller;
    }

    public Connection getDb_server_connection() {
        return db_server_connection;
    }

    public void setDb_server_connection(Connection db_server_connection) {
        this.db_server_connection = db_server_connection;
    }

    public Connection getDb_connection() throws SQLException{
        return dataSource.getConnection();
    }

    public static String getJdbcUser() {
        return jdbcUser;
    }

    public static void setJdbcUser(String jdbcUser) {
        DbManager.jdbcUser = jdbcUser;
        dataSource.setUsername(jdbcUser);
    }

    public static String getJdbcPassword() {
        return jdbcPassword;
    }

    public static void setJdbcPassword(String jdbcPassword) {
        DbManager.jdbcPassword = jdbcPassword;
        dataSource.setPassword(jdbcPassword);
    }

    public static BasicDataSource getDataSource() {
        return dataSource;
    }

    public static void setDataSource(BasicDataSource dataSource) {
        DbManager.dataSource = dataSource;
    }

    public void ConnectToDb(String url, String username, String password) {
        System.out.println("Connecting to database ...");
        try {
            setJdbcUser(username);
            setJdbcPassword(password);
            setDb_server_connection(DriverManager.getConnection(url, username, password));
            System.out.println("Connection to db " + db_server_connection.getCatalog() + " successful.");
        }catch (SQLException e){
            System.err.println("ConnectionToDb failed to log in and connect to the database");
            e.printStackTrace();
        }
    }

    private void ReconnectToDb() {
        System.out.println("Reconnecting to database ...");
        try {
            getDb_server_connection().close();
            setDb_server_connection(DriverManager.getConnection(JDBC_URL, getJdbcUser(),getJdbcPassword()));
            System.out.println("Reconnection successful, connection ready.");
        }catch (SQLException e){
            System.err.println("Error in the reconnection to the db");
            e.printStackTrace();
        }
    }

    private boolean CheckDbExists() {
        System.out.println("Checking if database dbcm already exists ...");
        String query = PredefinedQuery.select_queries.get(PredefinedQuery.Select.DATABASE);
        boolean db_exists = false;
        try (PreparedStatement preparedStatement = getDb_server_connection().prepareStatement(query)) {
            preparedStatement.setString(1, DB_NAME);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                db_exists = resultSet.next(); // Returns true if the database exists
            }catch (SQLException e){
                System.err.println("Error in db_exists check");
                e.printStackTrace();
            }
        }catch (SQLException e){
            System.err.println("Error in setting string to check db_exists");
            e.printStackTrace();
        }
        return db_exists;
    }

    private void DbCreate(){
        System.out.println("Creating database ...");
        try (Statement statement = getDb_server_connection().createStatement()){
            statement.executeUpdate(PredefinedQuery.create_queries.get(PredefinedQuery.Create.CREATE_DB));
            System.out.println("Database created succesfully.");
            System.out.println("Switching to database dbcm ...");
            ReconnectToDb();
        } catch (SQLException e) {
            System.err.println("Error in the creation of the database");
            e.printStackTrace();
        }
    }

    private void DbCreateTables(){
        System.out.println("Creating Tables ...");
        try(Statement statement = getDb_server_connection().createStatement()){
            statement.executeUpdate(PredefinedQuery.create_queries.get(PredefinedQuery.Create.POIS_TABLE));
            statement.executeUpdate(PredefinedQuery.create_queries.get(PredefinedQuery.Create.MONITORING_CENTERS_TABLE));
            statement.executeUpdate(PredefinedQuery.create_queries.get(PredefinedQuery.Create.USERS_TABLE));
            statement.executeUpdate(PredefinedQuery.create_queries.get(PredefinedQuery.Create.SURVEY_TABLE));
            statement.executeUpdate(PredefinedQuery.create_queries.get(PredefinedQuery.Create.MONITORING_CENTERS_POIS_TABLE));
            System.out.println("Tables created successfully.");
        }catch (SQLException e){
            System.err.println("Error in the tables creation");
            e.printStackTrace();
        }
    }

    private void DbInitialize(){
        System.out.println("Initializing Database ...");
        String query = PredefinedQuery.select_queries.get(PredefinedQuery.Select.POI);
        try {
            if(!db_server_connection.prepareStatement(query).executeQuery().next()){
                DbPopulate();
            }else{
                System.out.println("Database already initialized.");
            }
        } catch (SQLException e) {
            System.err.println("Error in DbInitialize");
            e.printStackTrace();
        }
    }

    private void DbPopulate(){
        System.out.println("Populating table \"coordinatemonitoraggio\" ...");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("0.#####", symbols);
        try {
            // Read Excel file
            FileInputStream file = new FileInputStream("src/main/resources/config/geonames-and-coordinates.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet

            // Iterate through rows and columns
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                // Assuming your Excel file has seven columns: geonameID, name, ascii_name, country_code, country_name, latitude, longitude
                String geonameID = cellIterator.next().getStringCellValue();
                String name = cellIterator.next().getStringCellValue();
                String ascii_name = cellIterator.next().getStringCellValue();
                String country_code = cellIterator.next().getStringCellValue();
                String country_name = cellIterator.next().getStringCellValue();
                float latitude = (float) cellIterator.next().getNumericCellValue();
                float longitude = (float) cellIterator.next().getNumericCellValue();

                latitude = Float.parseFloat(df.format(latitude));
                longitude = Float.parseFloat(df.format(longitude));

                // Insert data into PostgreSQL table
                String sql = PredefinedQuery.insert_queries.get(PredefinedQuery.Insert.POI);
                try (PreparedStatement preparedStatement = db_server_connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, ascii_name.trim());
                    preparedStatement.setString(2, country_name.trim());
                    preparedStatement.setDouble(3, latitude);
                    preparedStatement.setDouble(4, longitude);
                    preparedStatement.executeUpdate();
                }
            }
            System.out.println("Data inserted successfully.");
        } catch (SQLException e) {
            System.err.println("****Error in DbPopulate - SQLException****");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.err.println("****Error in DbPopulate - FileNotFoundException****");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("****Error in DbPopulate - IOException****");
            e.printStackTrace();
        }
    }

    public static void closeDataSource() {
        System.out.println("Closing database connection pool ...");
        if (dataSource != null) {
            try {
                dataSource.close();
                System.out.println("Database connection pool closed successfully.");
                System.out.flush();
            } catch (SQLException e) {
                System.err.println("SQLException thrown closing the connections pool");
                e.printStackTrace();
            }
        }
    }

}
