package com.climatemonitoring.serverCM.database;

import java.io.Serial;
import java.util.Hashtable;

public class PredefinedQuery {

    //INSERT QUERIES

    public enum Insert{USER, CLIMATECENTER, POI, SURVEY, CENTER_POI}
    public static final Hashtable<Insert, String> insert_queries = new Hashtable<>(){

        @Serial
        private static final long serialVersionUID = 1L;

        {

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

            put(
                    Insert.POI,
                    "INSERT INTO coordinatemonitoraggio ( " +
                            " name, " +
                            " country, " +
                            " latitude, " +
                            " longitude) " +
                            " VALUES (?,?,?,?); "
            );

            put(
                    Insert.SURVEY,
                    "INSERT INTO parametriclimatici ( " +
                            " poi_id, " +
                            " centerid, " +
                            " timestamp, " +
                            " wind, " +
                            " humidity, " +
                            " pressure, " +
                            " temperature, " +
                            " precipitation, " +
                            " glacial_altitude, " +
                            " glacial_mass, " +
                            " wind_notes, " +
                            " humidity_notes, " +
                            " pressure_notes, " +
                            " temperature_notes, " +
                            " precipitation_notes, " +
                            " glacial_altitude_notes, " +
                            " glacial_mass_notes) " +
                            " VALUES (?,?,CURRENT_TIMESTAMP,?,?,?,?,?,?,?,?,?,?,?,?,?,?) " +
                            " RETURNING dataid;"
            );

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

    public  enum Select{USER, USER_LOGIN_INFO, USER_EXISTS, USER_EMAIL_EXISTS, CLIMATECENTER, CLIMATECENTER_BY_ID, CLIMATECENTER_BY_ATTRIBUTES, POI, POI_BY_DATA, POI_BY_NAME, POI_BY_COORDINATES, SURVEY_BY_ID, POIS_BY_CENTER, POI_SURVEYS_AGGREGATE,DATABASE,TABLE_FROM_DATABASE}
    public static final Hashtable<Select, String> select_queries = new Hashtable<>(){

        @Serial
        private static final long serialVersionUID = 1L;

        {

            put(
                    Select.USER,
                    "SELECT * " +
                            " FROM operatoriregistrati " +
                            " WHERE userid = ? ; "
            );

            put(
                    Select.USER_LOGIN_INFO,
                    "SELECT * " +
                            "FROM operatoriregistrati " +
                            " WHERE userid = ? AND hashedpassword = ? ;"
            );

            put(
                    Select.USER_EXISTS,
                    "SELECT EXISTS " +
                            " (SELECT 1 FROM operatoriregistrati " +
                            " WHERE userid = ?); "

            );

            put(
                    Select.USER_EMAIL_EXISTS,
                    "SELECT EXISTS " +
                            " (SELECT 1 FROM operatoriregistrati " +
                            " WHERE email = ?); "
            );

            put(
                    Select.CLIMATECENTER,
                    "SELECT * " +
                            " FROM centrimonitoraggio ; "
            );

            put(
                    Select.CLIMATECENTER_BY_ID,
                    "SELECT * " +
                            " FROM centrimonitoraggio " +
                            " WHERE centerid = ? ; "
            );

            put(
                    Select.CLIMATECENTER_BY_ATTRIBUTES,
                    "SELECT * " +
                            " FROM centrimonitoraggio " +
                            " WHERE name = ? AND address = ? AND addressnumber = ? AND cap = ? AND city = ? AND province = ? ;"
            );

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

            put(
                    Select.POI_SURVEYS_AGGREGATE,
                    "SELECT " +
                            " poi_id, " +
                            " COUNT(*) AS survey_count, " +
                            " COUNT(DISTINCT centerid) AS number_of_centers, " +
                            " MIN(DATE_TRUNC('second', timestamp)) AS oldest_timestamp, " +
                            " MAX(DATE_TRUNC('second', timestamp)) AS most_recent_timestamp, " +
                            " ROUND(AVG(wind), 2) AS avg_wind, " +
                            " ROUND(AVG(humidity), 2) AS avg_humidity, " +
                            " ROUND(AVG(pressure), 2) AS avg_pressure, " +
                            " ROUND(AVG(temperature), 2) AS avg_temperature, " +
                            " ROUND(AVG(precipitation), 2) AS avg_precipitation, " +
                            " ROUND(AVG(glacial_altitude), 2) AS avg_glacial_altitude, " +
                            " ROUND(AVG(glacial_mass), 2) AS avg_glacial_mass, " +
                            " MAX(wind) AS max_wind, " +
                            " MAX(humidity) AS max_humidity, " +
                            " MAX(pressure) AS max_pressure, " +
                            " MAX(temperature) AS max_temperature, " +
                            " MAX(precipitation) AS max_precipitation, " +
                            " MAX(glacial_altitude) AS max_glacial_altitude, " +
                            " MAX(glacial_mass) AS max_glacial_mass, " +
                            " MIN(wind) AS min_wind, " +
                            " MIN(humidity) AS min_humidity, " +
                            " MIN(pressure) AS min_pressure, " +
                            " MIN(temperature) AS min_temperature, " +
                            " MIN(precipitation) AS min_precipitation, " +
                            " MIN(glacial_altitude) AS min_glacial_altitude, " +
                            " MIN(glacial_mass) AS min_glacial_mass, " +
                            " STRING_AGG(CASE WHEN wind_notes IS NOT NULL AND wind_notes <> '' THEN wind_notes ELSE NULL END,'| ') AS wind_notes_list, " +
                            " STRING_AGG(CASE WHEN humidity_notes IS NOT NULL AND humidity_notes <> '' THEN humidity_notes ELSE NULL END,'|') AS humidity_notes_list, " +
                            " STRING_AGG(CASE WHEN pressure_notes IS NOT NULL AND pressure_notes <> '' THEN pressure_notes ELSE NULL END,'|') AS pressure_notes_list, " +
                            " STRING_AGG(CASE WHEN temperature_notes IS NOT NULL AND temperature_notes <> '' THEN temperature_notes ELSE NULL END,'|') AS temperature_notes_list, " +
                            " STRING_AGG(CASE WHEN precipitation_notes IS NOT NULL AND precipitation_notes <> '' THEN precipitation_notes ELSE NULL END,'|') AS precipitation_notes_list, " +
                            " STRING_AGG(CASE WHEN glacial_altitude_notes IS NOT NULL AND glacial_altitude_notes <> '' THEN glacial_altitude_notes ELSE NULL END,'|') AS glacial_altitude_notes_list, " +
                            " STRING_AGG(CASE WHEN glacial_mass_notes IS NOT NULL AND glacial_mass_notes <> '' THEN glacial_mass_notes ELSE NULL END,'|') AS glacial_mass_notes_list " +
                            " FROM parametriclimatici " +
                            " WHERE poi_id = ? " +
                            " GROUP BY poi_id ; "
            );

            put(
                    Select.POIS_BY_CENTER,
                    "SELECT * FROM coordinatemonitoraggio " +
                            " JOIN coordinate_centri ON coordinatemonitoraggio.poi_id = coordinate_centri.poi_id " +
                            " WHERE coordinate_centri.centerid = ? ; "
            );

            put(
                    Select.SURVEY_BY_ID,
                    "SELECT * FROM parametriclimatici " +
                            " WHERE poi_id = ? ; "
            );

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

    //CREATE DATABASE AND TABLES QUERIES

    public enum Create{CREATE_DB, USERS_TABLE, MONITORING_CENTERS_TABLE, POIS_TABLE, SURVEY_TABLE, MONITORING_CENTERS_POIS_TABLE}
    public static final Hashtable<Create, String> create_queries = new Hashtable<>(){

        @Serial
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
