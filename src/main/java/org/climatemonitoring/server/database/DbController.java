package org.climatemonitoring.server.database;

import java.io.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Properties;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.climatemonitoring.shared.models.PointOfInterest;

public class DbController {

    private static DbController controller;
    private Connection db_connection;
    private Properties props;
    private static final String db_config_path = "src/main/resources/config/DBconfig.config";
    private static final String db_name = "dbcm";

    private DbController(String username,String password) {
        BufferedReader db_Config = null;
        try {
            db_Config = new BufferedReader(new FileReader(db_config_path));
            if(username==null || password==null){
                ConnectToDb(db_Config.readLine(), db_Config.readLine(), db_Config.readLine());
            }else {
                ConnectToDb(db_Config.readLine(), username, password);
            }
            db_Config.close();
        }catch (IOException e){
            System.err.println("Reading error in db_config");
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
    public static DbController GetDbController(String username,String password){
        if(controller == null){
            controller = new DbController(username, password);
        }
        return controller;
    }

    public Connection getDb_connection() {
        return db_connection;
    }

    public void setDb_connection(Connection db_connection) {
        this.db_connection = db_connection;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public void ConnectToDb(String url, String user, String password) {
        System.out.println("Connecting to database ...");
        try {
            Properties p = new Properties();
            p.setProperty("user", user);
            p.setProperty("password", password);
            setProps(p);
            setDb_connection(DriverManager.getConnection(url, getProps()));
            System.out.println("Connection to db " + db_connection.getCatalog() + " successful.");
        }catch (SQLException e){
            System.err.println("ConnectionToDb failed to log in and connect to the database");
            e.printStackTrace();
        }
    }

    private void ReconnectToDb() {
        System.out.println("Reconnecting to database ...");
        try {
            getDb_connection().close();
            setDb_connection(DriverManager.getConnection("jdbc:postgresql://localhost/" + db_name, getProps()));
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
        try (PreparedStatement preparedStatement = getDb_connection().prepareStatement(query)) {
            preparedStatement.setString(1, db_name);
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
        try {
            Statement statement = getDb_connection().createStatement();
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
        try(Statement statement = getDb_connection().createStatement()){
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
            if(!db_connection.prepareStatement(query).executeQuery().next()){
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
                try (PreparedStatement preparedStatement = db_connection.prepareStatement(sql)) {
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
