package com.climatemonitoring.serverCM.database;

import java.io.*;
import java.sql.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * The `DbManager` class is responsible for managing the connection pool and
 * executing various database operations on a PostgreSQL database. It follows
 * the Singleton design pattern to ensure a single instance is created for the
 * entire application, providing a centralized point for managing the database
 * connections.
 *
 * <p>
 * This class initializes and maintains a connection pool using Apache DBCP (Database
 * Connection Pooling) to efficiently handle database connections and improve
 * performance. It also performs operations such as creating the database, creating
 * tables, initializing the database with data, and reconnecting to the database
 * when needed.
 * </p>
 *
 * @author Lorenzo Cattapan 726459 (Varese)
 * @version 1.0
 * @see PredefinedQuery
 * @see com.climatemonitoring.serverCM.network.RemoteDatabaseService
 */
public class DbManager {

    //*****************FIELDS*****************//

    /**
     * Singleton instance of the DbManager
     */
    private static DbManager controller;
    /**
     * Connection to the PostgreSQL server
     */
    private Connection db_server_connection;
    /**
     * Database name
     */
    private static final String DB_NAME = "dbcm";
    /**
     * JDBC URL for connecting to the PostgreSQL database
     */
    private static final String JDBC_URL = "jdbc:postgresql://localhost/dbcm";
    /**
     * JDBC username
     */
    private static String jdbcUser;
    /**
     * JDBC password
     */
    private static String jdbcPassword;
    /**
     * DBCP DataSource for connection pooling
     */
    private static BasicDataSource dataSource;


    // Initialize DBCP DataSource
    static {
        dataSource = new BasicDataSource();
        dataSource.setUrl(JDBC_URL);
        dataSource.setUsername(jdbcUser);
        dataSource.setPassword(jdbcPassword);
        dataSource.setMinIdle(10);
        dataSource.setMaxIdle(20);
        dataSource.setMaxTotal(200);
        dataSource.setMaxOpenPreparedStatements(400);
    }

    //*****************PRIVATE CONSTRUCTOR FOR SINGLETON DESIGN PATTERN*****************//

    /**
     * Private constructor for the singleton pattern. It reads database configuration
     * from a file, establishes a connection to the database, and performs necessary
     * setup operations such as creating the database and tables if they do not exist.
     *
     * @param username The username for accessing the database.
     * @param password The password for accessing the database.
     * @throws FileNotFoundException If the database configuration file is not found.
     */
    private DbManager(String username, String password) throws FileNotFoundException{
        BufferedReader db_Config;
        InputStream db_ConfigStream = getClass().getClassLoader().getResourceAsStream("config/DBconfig.config");
        if (db_ConfigStream != null) {
            try {
                db_Config = new BufferedReader(new InputStreamReader(db_ConfigStream));
                if (username == null || password == null) {
                    ConnectToDb(db_Config.readLine(), db_Config.readLine(), db_Config.readLine());
                } else {
                    ConnectToDb(db_Config.readLine(), username, password);
                }
                db_Config.close();
            } catch (IOException e) {
                System.err.println("Reading error in db_config, DbController not set up.");
                e.printStackTrace();
            }
            if (!CheckDbExists()) {
                System.out.println("Database dbcm does not exist, starting the create process ...");
                DbCreate();
                DbCreateTables();
                DbInitialize();
                System.out.println("Database ready.");
            } else {
                System.out.println("Database dbcm already exists, reconnecting ...");
                ReconnectToDb();
            }
        }else{
            throw new FileNotFoundException("Resource not found : config/DBconfig.config");
        }
    }

    //*****************SINGLETON*****************//

    /**
     * Returns the singleton instance of the `DbManager`. If the instance does not
     * exist, it creates a new one with the provided username and password.
     *
     * @param username The username for accessing the database.
     * @param password The password for accessing the database.
     * @return The singleton instance of the `DbManager`.
     */
    public static DbManager GetDbManager(String username, String password){
        if(controller == null){
            try {
                controller = new DbManager(username, password);
            }catch (FileNotFoundException e){
                System.err.println(e.getMessage());
                System.err.println("Closing Program...");
                System.exit(0);
            }
        }
        return controller;
    }

    //*****************GETTER AND SETTER*****************//

    /**
     * Retrieves the connection to the PostgreSQL database.
     * This connection is a connection not in the pool and used only by the server to create and initialize
     * the database.
     *
     * @return The connection to the PostgreSQL database used by the server.
     */
    public Connection getDb_server_connection() {
        return db_server_connection;
    }

    /**
     * Sets the connection to the PostgreSQL database.
     * This connection is a connection not in the pool and used only by the server to create and initialize
     * the database.
     *
     * @param db_server_connection The new connection to the PostgreSQL database used by the server.
     */
    public void setDb_server_connection(Connection db_server_connection) {
        this.db_server_connection = db_server_connection;
    }

    /**
     * Retrieves a connection to the PostgreSQL database from the connection pool.
     *
     * @return A connection to the PostgreSQL database.
     * @throws SQLException If a SQL exception occurs while getting the connection.
     */
    public Connection getDb_connection() throws SQLException{
        return dataSource.getConnection();
    }

    /**
     * Retrieves the JDBC username used for connecting to the database.
     *
     * @return The JDBC username.
     */
    public static String getJdbcUser() {
        return jdbcUser;
    }

    /**
     * Sets the JDBC username used for connecting to the database.
     *
     * @param jdbcUser The new JDBC username.
     */
    public static void setJdbcUser(String jdbcUser) {
        DbManager.jdbcUser = jdbcUser;
        dataSource.setUsername(jdbcUser);
    }

    /**
     * Retrieves the JDBC password used for connecting to the database.
     *
     * @return The JDBC password.
     */
    public static String getJdbcPassword() {
        return jdbcPassword;
    }

    /**
     * Sets the JDBC password used for connecting to the database.
     *
     * @param jdbcPassword The new JDBC password.
     */
    public static void setJdbcPassword(String jdbcPassword) {
        DbManager.jdbcPassword = jdbcPassword;
        dataSource.setPassword(jdbcPassword);
    }

    /**
     * Retrieves the Apache DBCP DataSource used for connection pooling.
     *
     * @return The Apache DBCP DataSource.
     */
    public static BasicDataSource getDataSource() {
        return dataSource;
    }

    /**
     * Sets the Apache DBCP DataSource used for connection pooling.
     *
     * @param dataSource The new Apache DBCP DataSource.
     */
    public static void setDataSource(BasicDataSource dataSource) {
        DbManager.dataSource = dataSource;
    }

    //*****************PUBLIC METHODS*****************//

    /**
     * Establishes a connection to the database using the provided URL, username, and password.
     *
     * @param url      The URL of the database server.
     * @param username The username for accessing the database.
     * @param password The password for accessing the database.
     */
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

    /**
     * Closes the database connection pool.
     */
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

    //*****************PRIVATE METHODS*****************//

    /**
     * Reconnects to the PostgreSQL database by closing the existing connection and
     * establishing a new one using the JDBC URL, username, and password.
     */
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

    /**
     * Checks if the database with the specified name already exists.
     *
     * @return True if the database exists; false otherwise.
     */
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

    /**
     * Creates the main database if it does not already exist.
     */
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

    /**
     * Creates the necessary tables within the database.
     */
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

    /**
     * Initializes the database by checking if the Point of Interest (POI) table
     * contains any data. If not, it populates the table with data.
     */
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

    /**
     * Populates the "coordinatemonitoraggio" table in the database with data from
     * an Excel file containing geonames and coordinates.
     */
    private void DbPopulate(){
        System.out.println("Populating table \"coordinatemonitoraggio\" ...");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("0.#####", symbols);
        try {
            // Read Excel file
            InputStream inputStream = getClass().getResourceAsStream("/config/geonames-and-coordinates.xlsx");
            assert inputStream != null;
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
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

}
