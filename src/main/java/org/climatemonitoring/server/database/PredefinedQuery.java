package org.climatemonitoring.server.database;

import java.util.Hashtable;

public class PredefinedQuery {

    //INSERT QUERIES
    public enum Insert{USER, CLIMATECENTER, POI, SURVEY, CENTER_POI}
    public static final Hashtable<Insert, String> insert_queries = new Hashtable<Insert, String>(){

        private static final long serialVersionUID = 1L;

        {

            //Put Insert User
            put(
                    Insert.USER,
                    "INSERT INTO operatoriregistrati ( " +
                            " userid, " +
                            " name, " +
                            " surname, " +
                            " email, " +
                            " fiscalcode, " +
                            " hashedpassword, " +
                            " centerid) " +
                            " VALUES (?,?,?,?,?,?,?); "
            );

            //Put Insert ClimateMonitoringCenter
            put(
                    Insert.CLIMATECENTER,
                    "INSERT INTO centrimonitoraggio ( " +
                            " name, " +
                            " address, " +
                            " addressnumber, " +
                            " cap, " +
                            " city, " +
                            " province) " +
                            " VALUES (?,?,?,?,?,?); "
            );

            //Put Insert POI
            put(
                    Insert.POI,
                    "INSERT INTO coordinatemonitoraggio ( " +
                            " name, " +
                            " country, " +
                            " latitude, " +
                            " longitude) " +
                            " VALUES (?,?,?,?); "
            );

            //Put Insert Survey
            //TODO

            //Put Insert Center-POI reference
            put(
                    Insert.CENTER_POI,
                    "INSERT INTO coordinate_centri ( " +
                            " centerid, " +
                            " poi_id) " +
                            " VALUES (?,?); "
            );

        }
    };

    //SELECT QUERIES
    public  enum Select{USER, USER_LOGIN_INFO, USER_EXISTS, USER_EMAIL_EXISTS, CLIMATECENTER, CLIMATECENTER_BY_ID, CLIMATECENTER_BY_ATTRIBUTES, POI, POI_BY_DATA, POI_BY_NAME, POI_BY_COORDINATES, SURVEY_BY_ID, POIS_FOR_CENTER, CENTERS_FOR_POI, SURVEYs, USERS_FOR_CENTER,DATABASE,TABLE_FROM_DATABASE}
    public static final Hashtable<Select, String> select_queries = new Hashtable<Select, String>(){

        private static final long serialVersionUID = 1L;

        {
            //Put Select User
            put(
                    Select.USER,
                    "SELECT * " +
                            " FROM operatoriregistrati " +
                            " WHERE userid = ? ; "
            );

            //Put Select User for login
            put(
                    Select.USER_LOGIN_INFO,
                    "SELECT * " +
                            "FROM operatoriregistrati " +
                            " WHERE userid = ? AND hashedpassword = ? ;"
            );

            //Put Select User to check Existence
            put(
                    Select.USER_EXISTS,
                    "SELECT EXISTS " +
                            " (SELECT 1 FROM operatoriregistrati " +
                            " WHERE userid = ?); "

            );

            //Put Select User email to check Existence
            put(
                    Select.USER_EMAIL_EXISTS,
                    "SELECT EXISTS " +
                            " (SELECT 1 FROM operatoriregistrati " +
                            " WHERE email = ?); "
            );

            //Put Select ClimateMonitoringCenter
            put(
                    Select.CLIMATECENTER,
                    "SELECT * " +
                            " FROM centrimonitoraggio ; "
            );

            //Put Select ClimateMonitoringCenter by centerid
            put(
                    Select.CLIMATECENTER_BY_ID,
                    "SELECT * " +
                            " FROM centrimonitoraggio " +
                            " WHERE centerid = ? ; "
            );

            //Put Select ClimateMonitoringCenter By all fields except id to check existence
            put(
                    Select.CLIMATECENTER_BY_ATTRIBUTES,
                    "SELECT * " +
                            " FROM centrimonitoraggio " +
                            " WHERE name = ? AND address = ? AND addressnumber = ? AND cap = ? AND city = ? AND province = ? ;"
            );

            //Put Select POI
            put(
                    Select.POI,
                    "SELECT * " +
                            " FROM coordinatemonitoraggio; "
            );

            put(
                    Select.POI_BY_DATA,
                    "SELECT * " +
                            " FROM coordinatemonitoraggio " +
                            " WHERE name = ? AND country = ? AND latitude = ? AND longitude = ? ; "
            );

            put(
                    Select.POI_BY_NAME,
                    "SELECT * " +
                            " FROM coordinatemonitoraggio " +
                            " WHERE name ILIKE lower(?) AND country ILIKE lower(?); "
            );

            put(
                    Select.POI_BY_COORDINATES,
                    "SELECT * FROM coordinatemonitoraggio " +
                            " WHERE latitude > ? AND latitude < ? " +
                            " AND longitude > ? AND longitude < ?; "
            );

            //Put Select SURVEYS
            //TODO

            //Put Select POIS_FOR_CENTER
            //TODO

            //Put Select CENTERS_FOR_POI
            //TODO

            //Put Select SURVEYS_BY_ID
            put(
                    Select.SURVEY_BY_ID,
                    "SELECT * FROM parametriclimatici " +
                            " WHERE poi_id = ? ; "
            );

            //Put Select USERS_FOR_CENTER
            //TODO

            put(
                    Select.DATABASE,
                    "SELECT datname " +
                            " FROM pg_database " +
                            " WHERE datname = ? ; "
            );

            put(
                    Select.TABLE_FROM_DATABASE,
                    "SELECT table_name " +
                            " FROM information_schema.tables " +
                            " WHERE table_name = ? ; "

            );

        }
    };

    //UPDATE QUERIES
    public enum Update{USER, CLIMATECENTER, POI, SURVEY}
    public static final Hashtable<Update, String> update_queries = new Hashtable<Update, String>(){

        //Put Update User
        //TODO

        //Put Update ClimateMonitoringCenter
        //TODO

        //Put Update POI
        //TODO

        //Put Update Survey
        //TODO

    };

    //DELETE QUERIES
    public enum Delete{USER, CLIMATECENTER, POI, SURVEY}
    public static final Hashtable<Delete, String> delete_queries = new Hashtable<Delete, String>(){

        //Put Delete User
        //TODO

        //Put Delete ClimateMonitoringCenter
        //TODO

        //Put Delete POI
        //TODO

        //Put Delete Survey
        //TODO

    };

    public enum Create{CREATE_DB, USERS_TABLE, MONITORING_CENTERS_TABLE, POIS_TABLE, SURVEY_TABLE, MONITORING_CENTERS_POIS_TABLE}
    public static final Hashtable<Create, String> create_queries = new Hashtable<Create, String>(){

        private static final long serialVersionUID = 1L;

        {
            put(
                    Create.CREATE_DB,
                    "CREATE DATABASE dbCM;"
            );

            put(
                    Create.USERS_TABLE,
                    "CREATE TABLE operatoriregistrati( " +
                            " userid VARCHAR(30) PRIMARY KEY NOT NULL, " +
                            " name VARCHAR(30) NOT NULL, " +
                            " surname VARCHAR(30) NOT NULL, " +
                            " email VARCHAR(80) UNIQUE NOT NULL, " +
                            " fiscalcode VARCHAR(16) NOT NULL CHECK (LENGTH(fiscalcode) = 16), " +
                            " hashedpassword VARCHAR(64) NOT NULL CHECK (LENGTH(hashedpassword) = 64), " +
                            " centerid INTEGER NOT NULL REFERENCES CentriMonitoraggio(centerid) " +
                            " ); "
            );

            put(Create.MONITORING_CENTERS_TABLE,
                    "CREATE TABLE centrimonitoraggio( " +
                            " centerid SERIAL PRIMARY KEY, " +
                            " name VARCHAR(50) NOT NULL, " +
                            " address VARCHAR(50) NOT NULL, " +
                            " addressnumber INTEGER NOT NULL, " +
                            " cap INTEGER NOT NULL CHECK (LENGTH(cap::TEXT) = 5), " +
                            " city VARCHAR(30) NOT NULL, " +
                            " province VARCHAR(30) NOT NULL " +
                            " ); "
            );

            put(Create.POIS_TABLE,
                    "CREATE TABLE coordinatemonitoraggio( " +
                            " poi_id SERIAL PRIMARY KEY, " +
                            " name VARCHAR(100) NOT NULL, " +
                            " country VARCHAR(100) NOT NULL, " +
                            " latitude NUMERIC(8,5) NOT NULL, " +
                            " longitude NUMERIC(8,5) NOT NULL " +
                            " ); "
            );

            put(Create.SURVEY_TABLE,
                    "CREATE TABLE parametriclimatici( " +
                            " dataid SERIAL PRIMARY KEY, " +
                            " poi_id INTEGER NOT NULL REFERENCES CoordinateMonitoraggio(poi_id), " +
                            " centerid INTEGER NOT NULL REFERENCES CentriMonitoraggio(centerid), " +
                            " timestamp TIMESTAMP WITHOUT TIME ZONE NOT NULL, " +
                            " wind INTEGER NOT NULL CHECK (wind IN (1,2,3,4,5)), " +
                            " humidity INTEGER NOT NULL CHECK (wind IN (1,2,3,4,5)), " +
                            " pressure INTEGER NOT NULL CHECK (wind IN (1,2,3,4,5)), " +
                            " temperature INTEGER NOT NULL CHECK (wind IN (1,2,3,4,5)), " +
                            " precipitation INTEGER NOT NULL CHECK (wind IN (1,2,3,4,5)), " +
                            " glacial_altitude INTEGER NOT NULL CHECK (wind IN (1,2,3,4,5)), " +
                            " glacial_mass INTEGER NOT NULL CHECK (wind IN (1,2,3,4,5)), " +
                            " wind_notes VARCHAR(256), " +
                            " humidity_notes VARCHAR(256), " +
                            " pressure_notes VARCHAR(256), " +
                            " temperature_notes VARCHAR(256), " +
                            " precipitation_notes VARCHAR(256), " +
                            " glacial_altitude_notes VARCHAR(256), " +
                            " glacial_mass_notes VARCHAR(256) " +
                            " ); "
            );

            put(Create.MONITORING_CENTERS_POIS_TABLE,
                    "CREATE TABLE coordinate_centri ( " +
                            " centerid INTEGER REFERENCES CentriMonitoraggio(centerid) ON DELETE CASCADE, " +
                            " poi_id INTEGER REFERENCES CoordinateMonitoraggio(poi_id) ON DELETE CASCADE, " +
                            " PRIMARY KEY (centerid, poi_id) " +
                            " ); "
            );
        }

    };

}
