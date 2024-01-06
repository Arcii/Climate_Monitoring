package com.climatemonitoring.shared.models;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * The 'SurveyAggregate' class represents the aggregate information of one or more Surveys for a specific PointOfInterest.
 * It is used when a Guest or a User(operator) wants to visualize the climatic data of a Point of Interest.
 * This class implements the Serializable interface to support serialization.
 *
 * <p>
 * The class provides constructors for creating surveys aggregate objects with different sets of parameters.
 * Additionally, getter and setter methods are available for accessing and modifying the survey aggregate's attributes.
 *</p>
 *
 * <p>
 * Note: This class is an integral part of the Climate Monitoring application and is utilized on both the client and server sides.
 *</p>
 *
 * @author Lorenzo Cattapan 726459 (Varese)
 * @version 1.0
 * @serial 1L
 * @see Survey
 */
public class SurveysAggregate implements Serializable {

    //*****************FIELDS*****************//

    /**
     * The serial version UID for serialization.
     */
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * The Point of Interest ID associated with this SurveysAggregate.
     */
    private int poi_id;
    /**
     * The total count of surveys aggregated in this SurveysAggregate.
     */
    private int surveysCount;
    /**
     * The count of unique centers contributing to the surveys in this SurveysAggregate.
     */
    private int centersCount;
    /**
     * The timestamp of the oldest survey in this SurveysAggregate.
     */
    private Timestamp oldestTimestamp;
    /**
     * The timestamp of the most recent survey in this SurveysAggregate.
     */
    private Timestamp mostRecentTimestamp;
    /**
     * The average wind value in this SurveysAggregate.
     */
    private float wind_avg;
    /**
     * The average humidity value in this SurveysAggregate.
     */
    private float humidity_avg;
    /**
     * The average pressure value in this SurveysAggregate.
     */
    private float pressure_avg;
    /**
     * The average temperature value in this SurveysAggregate.
     */
    private float temperature_avg;
    /**
     * The average precipitation value in this SurveysAggregate.
     */
    private float precipitation_avg;
    /**
     * The average glacial altitude value in this SurveysAggregate.
     */
    private float glacial_altitude_avg;
    /**
     * The average glacial mass value in this SurveysAggregate.
     */
    private float glacial_mass_avg;
    /**
     * The maximum wind value in this SurveysAggregate.
     */
    private int wind_max;
    /**
     * The maximum humidity value in this SurveysAggregate.
     */
    private int humidity_max;
    /**
     * The maximum pressure value in this SurveysAggregate.
     */
    private int pressure_max;
    /**
     * The maximum temperature value in this SurveysAggregate.
     */
    private int temperature_max;
    /**
     * The maximum precipitation value in this SurveysAggregate.
     */
    private int precipitation_max;
    /**
     * The maximum glacial altitude value in this SurveysAggregate.
     */
    private int glacial_altitude_max;
    /**
     * The maximum glacial mass value in this SurveysAggregate.
     */
    private int glacial_mass_max;
    /**
     * The minimum wind value in this SurveysAggregate.
     */
    private int wind_min;
    /**
     * The minimum humidity value in this SurveysAggregate.
     */
    private int humidity_min;
    /**
     * The minimum pressure value in this SurveysAggregate.
     */
    private int pressure_min;
    /**
     * The minimum temperature value in this SurveysAggregate.
     */
    private int temperature_min;
    /**
     * The minimum precipitation value in this SurveysAggregate.
     */
    private int precipitation_min;
    /**
     * The minimum glacial altitude value in this SurveysAggregate.
     */
    private int glacial_altitude_min;
    /**
     * The minimum glacial mass value in this SurveysAggregate.
     */
    private int glacial_mass_min;
    /**
     * The notes list for wind observations in this SurveysAggregate.
     */
    private String wind_notes_list;
    /**
     * The notes list for humidity observations in this SurveysAggregate.
     */
    private String humidity_notes_list;
    /**
     * The notes list for pressure observations in this SurveysAggregate.
     */
    private String pressure_notes_list;
    /**
     * The notes list for temperature observations in this SurveysAggregate.
     */
    private String temperature_notes_list;
    /**
     * The notes list for precipitation observations in this SurveysAggregate.
     */
    private String precipitation_notes_list;
    /**
     * The notes list for glacial altitude observations in this SurveysAggregate.
     */
    private String glacial_altitude_notes_list;
    /**
     * The notes list for glacial mass observations in this SurveysAggregate.
     */
    private String glacial_mass_notes_list;

    //*****************CONSTRUCTORS*****************//

    /**
     * Constructs an empty SurveysAggregate.
     */
    public SurveysAggregate(){
        //Empty Constructor
    }

    /**
     * Constructs a SurveysAggregate with specified parameters.
     *
     * @param poi_id The Point of Interest ID.
     * @param surveysCount The total count of surveys.
     * @param centersCount The count of unique centers.
     * @param oldestTimestamp The timestamp of the oldest survey.
     * @param mostRecentTimestamp The timestamp of the most recent survey.
     * @param wind_avg The average wind value.
     * @param humidity_avg The average humidity value.
     * @param pressure_avg The average pressure value.
     * @param temperature_avg The average temperature value.
     * @param precipitation_avg The average precipitation value.
     * @param glacial_altitude_avg The average glacial altitude value.
     * @param glacial_mass_avg The average glacial mass value.
     * @param wind_max The maximum wind value.
     * @param humidity_max The maximum humidity value.
     * @param pressure_max The maximum pressure value.
     * @param temperature_max The maximum temperature value.
     * @param precipitation_max The maximum precipitation value.
     * @param glacial_altitude_max The maximum glacial altitude value.
     * @param glacial_mass_max The maximum glacial mass value.
     * @param wind_min The minimum wind value.
     * @param humidity_min The minimum humidity value.
     * @param pressure_min The minimum pressure value.
     * @param temperature_min The minimum temperature value.
     * @param precipitation_min The minimum precipitation value.
     * @param glacial_altitude_min The minimum glacial altitude value.
     * @param glacial_mass_min The minimum glacial mass value.
     * @param wind_notes_list The notes list for wind observations.
     * @param humidity_notes_list The notes list for humidity observations.
     * @param pressure_notes_list The notes list for pressure observations.
     * @param temperature_notes_list The notes list for temperature observations.
     * @param precipitation_notes_list The notes list for precipitation observations.
     * @param glacial_altitude_notes_list The notes list for glacial altitude observations.
     * @param glacial_mass_notes_list The notes list for glacial mass observations.
     */
    public SurveysAggregate(int poi_id, int surveysCount, int centersCount, Timestamp oldestTimestamp, Timestamp mostRecentTimestamp, float wind_avg, float humidity_avg, float pressure_avg, float temperature_avg, float precipitation_avg, float glacial_altitude_avg, float glacial_mass_avg, int wind_max, int humidity_max, int pressure_max, int temperature_max, int precipitation_max, int glacial_altitude_max, int glacial_mass_max, int wind_min, int humidity_min, int pressure_min, int temperature_min, int precipitation_min, int glacial_altitude_min, int glacial_mass_min, String wind_notes_list, String humidity_notes_list, String pressure_notes_list, String temperature_notes_list, String precipitation_notes_list, String glacial_altitude_notes_list, String glacial_mass_notes_list) {
        this.poi_id = poi_id;
        this.surveysCount = surveysCount;
        this.centersCount = centersCount;
        this.oldestTimestamp = oldestTimestamp;
        this.mostRecentTimestamp = mostRecentTimestamp;
        this.wind_avg = wind_avg;
        this.humidity_avg = humidity_avg;
        this.pressure_avg = pressure_avg;
        this.temperature_avg = temperature_avg;
        this.precipitation_avg = precipitation_avg;
        this.glacial_altitude_avg = glacial_altitude_avg;
        this.glacial_mass_avg = glacial_mass_avg;
        this.wind_max = wind_max;
        this.humidity_max = humidity_max;
        this.pressure_max = pressure_max;
        this.temperature_max = temperature_max;
        this.precipitation_max = precipitation_max;
        this.glacial_altitude_max = glacial_altitude_max;
        this.glacial_mass_max = glacial_mass_max;
        this.wind_min = wind_min;
        this.humidity_min = humidity_min;
        this.pressure_min = pressure_min;
        this.temperature_min = temperature_min;
        this.precipitation_min = precipitation_min;
        this.glacial_altitude_min = glacial_altitude_min;
        this.glacial_mass_min = glacial_mass_min;
        this.wind_notes_list = wind_notes_list;
        this.humidity_notes_list = humidity_notes_list;
        this.pressure_notes_list = pressure_notes_list;
        this.temperature_notes_list = temperature_notes_list;
        this.precipitation_notes_list = precipitation_notes_list;
        this.glacial_altitude_notes_list = glacial_altitude_notes_list;
        this.glacial_mass_notes_list = glacial_mass_notes_list;
    }

    //*****************GETTER AND SETTER*****************//

    /**
     * Gets the Point of Interest ID associated with this SurveysAggregate.
     *
     * @return The Point of Interest ID.
     */
    public int getPoi_id() {
        return poi_id;
    }

    /**
     * Sets the Point of Interest ID for this SurveysAggregate.
     *
     * @param poi_id The Point of Interest ID to set.
     */
    public void setPoi_id(int poi_id) {
        this.poi_id = poi_id;
    }

    /**
     * Gets the total count of surveys aggregated in this SurveysAggregate.
     *
     * @return The total count of surveys.
     */
    public int getSurveysCount() {
        return surveysCount;
    }

    /**
     * Sets the total count of surveys for this SurveysAggregate.
     *
     * @param surveysCount The total count of surveys to set.
     */
    public void setSurveysCount(int surveysCount) {
        this.surveysCount = surveysCount;
    }

    /**
     * Gets the count of unique centers contributing to the surveys in this SurveysAggregate.
     *
     * @return The count of unique centers.
     */
    public int getCentersCount() {
        return centersCount;
    }

    /**
     * Sets the count of unique centers for this SurveysAggregate.
     *
     * @param centersCount The count of unique centers to set.
     */
    public void setCentersCount(int centersCount) {
        this.centersCount = centersCount;
    }

    /**
     * Gets the timestamp of the oldest survey in this SurveysAggregate.
     *
     * @return The timestamp of the oldest survey.
     */
    public Timestamp getOldestTimestamp() {
        return oldestTimestamp;
    }

    /**
     * Sets the timestamp of the oldest survey for this SurveysAggregate.
     *
     * @param oldestTimestamp The timestamp of the oldest survey to set.
     */
    public void setOldestTimestamp(Timestamp oldestTimestamp) {
        this.oldestTimestamp = oldestTimestamp;
    }

    /**
     * Gets the timestamp of the most recent survey in this SurveysAggregate.
     *
     * @return The timestamp of the most recent survey.
     */
    public Timestamp getMostRecentTimestamp() {
        return mostRecentTimestamp;
    }

    /**
     * Sets the timestamp of the most recent survey for this SurveysAggregate.
     *
     * @param mostRecentTimestamp The timestamp of the most recent survey to set.
     */
    public void setMostRecentTimestamp(Timestamp mostRecentTimestamp) {
        this.mostRecentTimestamp = mostRecentTimestamp;
    }

    /**
     * Gets the average wind value in this SurveysAggregate.
     *
     * @return The average wind value.
     */
    public float getWind_avg() {
        return wind_avg;
    }

    /**
     * Sets the average wind value for this SurveysAggregate.
     *
     * @param wind_avg The average wind value to set.
     */
    public void setWind_avg(float wind_avg) {
        this.wind_avg = wind_avg;
    }

    /**
     * Gets the average humidity value in this SurveysAggregate.
     *
     * @return The average humidity value.
     */
    public float getHumidity_avg() {
        return humidity_avg;
    }

    /**
     * Sets the average humidity value for this SurveysAggregate.
     *
     * @param humidity_avg The average humidity value to set.
     */
    public void setHumidity_avg(float humidity_avg) {
        this.humidity_avg = humidity_avg;
    }

    /**
     * Gets the average pressure value in this SurveysAggregate.
     *
     * @return The average pressure value.
     */
    public float getPressure_avg() {
        return pressure_avg;
    }

    /**
     * Sets the average pressure value for this SurveysAggregate.
     *
     * @param pressure_avg The average pressure value to set.
     */
    public void setPressure_avg(float pressure_avg) {
        this.pressure_avg = pressure_avg;
    }

    /**
     * Gets the average temperature value in this SurveysAggregate.
     *
     * @return The average temperature value.
     */
    public float getTemperature_avg() {
        return temperature_avg;
    }

    /**
     * Sets the average temperature value for this SurveysAggregate.
     *
     * @param temperature_avg The average temperature value to set.
     */
    public void setTemperature_avg(float temperature_avg) {
        this.temperature_avg = temperature_avg;
    }

    /**
     * Gets the average precipitation value in this SurveysAggregate.
     *
     * @return The average precipitation value.
     */
    public float getPrecipitation_avg() {
        return precipitation_avg;
    }

    /**
     * Sets the average precipitation value for this SurveysAggregate.
     *
     * @param precipitation_avg The average precipitation value to set.
     */
    public void setPrecipitation_avg(float precipitation_avg) {
        this.precipitation_avg = precipitation_avg;
    }

    /**
     * Gets the average glacial altitude value in this SurveysAggregate.
     *
     * @return The average glacial altitude value.
     */
    public float getGlacial_altitude_avg() {
        return glacial_altitude_avg;
    }

    /**
     * Sets the average glacial altitude value for this SurveysAggregate.
     *
     * @param glacial_altitude_avg The average glacial altitude value to set.
     */
    public void setGlacial_altitude_avg(float glacial_altitude_avg) {
        this.glacial_altitude_avg = glacial_altitude_avg;
    }

    /**
     * Gets the average glacial mass value in this SurveysAggregate.
     *
     * @return The average glacial mass value.
     */
    public float getGlacial_mass_avg() {
        return glacial_mass_avg;
    }

    /**
     * Sets the average glacial mass value for this SurveysAggregate.
     *
     * @param glacial_mass_avg The average glacial mass value to set.
     */
    public void setGlacial_mass_avg(float glacial_mass_avg) {
        this.glacial_mass_avg = glacial_mass_avg;
    }

    /**
     * Gets the maximum wind value in this SurveysAggregate.
     *
     * @return The maximum wind value.
     */
    public int getWind_max() {
        return wind_max;
    }

    /**
     * Sets the maximum wind value for this SurveysAggregate.
     *
     * @param wind_max The maximum wind value to set.
     */
    public void setWind_max(int wind_max) {
        this.wind_max = wind_max;
    }

    /**
     * Gets the maximum humidity value in this SurveysAggregate.
     *
     * @return The maximum humidity value.
     */
    public int getHumidity_max() {
        return humidity_max;
    }

    /**
     * Sets the maximum humidity value for this SurveysAggregate.
     *
     * @param humidity_max The maximum humidity value to set.
     */
    public void setHumidity_max(int humidity_max) {
        this.humidity_max = humidity_max;
    }

    /**
     * Gets the maximum pressure value in this SurveysAggregate.
     *
     * @return The maximum pressure value.
     */
    public int getPressure_max() {
        return pressure_max;
    }

    /**
     * Sets the maximum pressure value for this SurveysAggregate.
     *
     * @param pressure_max The maximum pressure value to set.
     */
    public void setPressure_max(int pressure_max) {
        this.pressure_max = pressure_max;
    }

    /**
     * Gets the maximum temperature value in this SurveysAggregate.
     *
     * @return The maximum temperature value.
     */
    public int getTemperature_max() {
        return temperature_max;
    }

    /**
     * Sets the maximum temperature value for this SurveysAggregate.
     *
     * @param temperature_max The maximum temperature value to set.
     */
    public void setTemperature_max(int temperature_max) {
        this.temperature_max = temperature_max;
    }

    /**
     * Gets the maximum precipitation value in this SurveysAggregate.
     *
     * @return The maximum precipitation value.
     */
    public int getPrecipitation_max() {
        return precipitation_max;
    }

    /**
     * Sets the maximum precipitation value for this SurveysAggregate.
     *
     * @param precipitation_max The maximum precipitation value to set.
     */
    public void setPrecipitation_max(int precipitation_max) {
        this.precipitation_max = precipitation_max;
    }

    /**
     * Gets the maximum glacial altitude value in this SurveysAggregate.
     *
     * @return The maximum glacial altitude value.
     */
    public int getGlacial_altitude_max() {
        return glacial_altitude_max;
    }

    /**
     * Sets the maximum glacial altitude value for this SurveysAggregate.
     *
     * @param glacial_altitude_max The maximum glacial altitude value to set.
     */
    public void setGlacial_altitude_max(int glacial_altitude_max) {
        this.glacial_altitude_max = glacial_altitude_max;
    }

    /**
     * Gets the maximum glacial mass value in this SurveysAggregate.
     *
     * @return The maximum glacial mass value.
     */
    public int getGlacial_mass_max() {
        return glacial_mass_max;
    }

    /**
     * Sets the maximum glacial mass value for this SurveysAggregate.
     *
     * @param glacial_mass_max The maximum glacial mass value to set.
     */
    public void setGlacial_mass_max(int glacial_mass_max) {
        this.glacial_mass_max = glacial_mass_max;
    }

    /**
     * Gets the minimum wind value in this SurveysAggregate.
     *
     * @return The minimum wind value.
     */
    public int getWind_min() {
        return wind_min;
    }

    /**
     * Sets the minimum wind value for this SurveysAggregate.
     *
     * @param wind_min The minimum wind value to set.
     */
    public void setWind_min(int wind_min) {
        this.wind_min = wind_min;
    }

    /**
     * Gets the minimum humidity value in this SurveysAggregate.
     *
     * @return The minimum humidity value.
     */
    public int getHumidity_min() {
        return humidity_min;
    }

    /**
     * Sets the minimum humidity value for this SurveysAggregate.
     *
     * @param humidity_min The minimum humidity value to set.
     */
    public void setHumidity_min(int humidity_min) {
        this.humidity_min = humidity_min;
    }

    /**
     * Gets the minimum pressure value in this SurveysAggregate.
     *
     * @return The minimum pressure value.
     */
    public int getPressure_min() {
        return pressure_min;
    }

    /**
     * Sets the minimum pressure value for this SurveysAggregate.
     *
     * @param pressure_min The minimum pressure value to set.
     */
    public void setPressure_min(int pressure_min) {
        this.pressure_min = pressure_min;
    }

    /**
     * Gets the minimum temperature value in this SurveysAggregate.
     *
     * @return The minimum temperature value.
     */
    public int getTemperature_min() {
        return temperature_min;
    }

    /**
     * Sets the minimum temperature value for this SurveysAggregate.
     *
     * @param temperature_min The minimum temperature value to set.
     */
    public void setTemperature_min(int temperature_min) {
        this.temperature_min = temperature_min;
    }

    /**
     * Gets the minimum precipitation value in this SurveysAggregate.
     *
     * @return The minimum precipitation value.
     */
    public int getPrecipitation_min() {
        return precipitation_min;
    }

    /**
     * Sets the minimum precipitation value for this SurveysAggregate.
     *
     * @param precipitation_min The minimum precipitation value to set.
     */
    public void setPrecipitation_min(int precipitation_min) {
        this.precipitation_min = precipitation_min;
    }

    /**
     * Gets the minimum glacial altitude value in this SurveysAggregate.
     *
     * @return The minimum glacial altitude value.
     */
    public int getGlacial_altitude_min() {
        return glacial_altitude_min;
    }

    /**
     * Sets the minimum glacial altitude value for this SurveysAggregate.
     *
     * @param glacial_altitude_min The minimum glacial altitude value to set.
     */
    public void setGlacial_altitude_min(int glacial_altitude_min) {
        this.glacial_altitude_min = glacial_altitude_min;
    }

    /**
     * Gets the minimum glacial mass value in this SurveysAggregate.
     *
     * @return The minimum glacial mass value.
     */
    public int getGlacial_mass_min() {
        return glacial_mass_min;
    }

    /**
     * Sets the minimum glacial mass value for this SurveysAggregate.
     *
     * @param glacial_mass_min The minimum glacial mass value to set.
     */
    public void setGlacial_mass_min(int glacial_mass_min) {
        this.glacial_mass_min = glacial_mass_min;
    }

    /**
     * Gets the notes list for wind observations in this SurveysAggregate.
     *
     * @return The notes list for wind observations.
     */
    public String getWind_notes_list() {
        return wind_notes_list;
    }

    /**
     * Sets the notes list for wind observations for this SurveysAggregate.
     *
     * @param wind_notes_list The notes list for wind observations to set.
     */
    public void setWind_notes_list(String wind_notes_list) {
        this.wind_notes_list = wind_notes_list;
    }

    /**
     * Gets the notes list for humidity observations in this SurveysAggregate.
     *
     * @return The notes list for humidity observations.
     */
    public String getHumidity_notes_list() {
        return humidity_notes_list;
    }

    /**
     * Sets the notes list for humidity observations for this SurveysAggregate.
     *
     * @param humidity_notes_list The notes list for humidity observations to set.
     */
    public void setHumidity_notes_list(String humidity_notes_list) {
        this.humidity_notes_list = humidity_notes_list;
    }

    /**
     * Gets the notes list for pressure observations in this SurveysAggregate.
     *
     * @return The notes list for pressure observations.
     */
    public String getPressure_notes_list() {
        return pressure_notes_list;
    }

    /**
     * Sets the notes list for pressure observations for this SurveysAggregate.
     *
     * @param pressure_notes_list The notes list for pressure observations to set.
     */
    public void setPressure_notes_list(String pressure_notes_list) {
        this.pressure_notes_list = pressure_notes_list;
    }

    /**
     * Gets the notes list for temperature observations in this SurveysAggregate.
     *
     * @return The notes list for temperature observations.
     */
    public String getTemperature_notes_list() {
        return temperature_notes_list;
    }

    /**
     * Sets the notes list for temperature observations for this SurveysAggregate.
     *
     * @param temperature_notes_list The notes list for temperature observations to set.
     */
    public void setTemperature_notes_list(String temperature_notes_list) {
        this.temperature_notes_list = temperature_notes_list;
    }

    /**
     * Gets the notes list for precipitation observations in this SurveysAggregate.
     *
     * @return The notes list for precipitation observations.
     */
    public String getPrecipitation_notes_list() {
        return precipitation_notes_list;
    }

    /**
     * Sets the notes list for precipitation observations for this SurveysAggregate.
     *
     * @param precipitation_notes_list The notes list for precipitation observations to set.
     */
    public void setPrecipitation_notes_list(String precipitation_notes_list) {
        this.precipitation_notes_list = precipitation_notes_list;
    }

    /**
     * Gets the notes list for glacial altitude observations in this SurveysAggregate.
     *
     * @return The notes list for glacial altitude observations.
     */
    public String getGlacial_altitude_notes_list() {
        return glacial_altitude_notes_list;
    }

    /**
     * Sets the notes list for glacial altitude observations for this SurveysAggregate.
     *
     * @param glacial_altitude_notes_list The notes list for glacial altitude observations to set.
     */
    public void setGlacial_altitude_notes_list(String glacial_altitude_notes_list) {
        this.glacial_altitude_notes_list = glacial_altitude_notes_list;
    }

    /**
     * Gets the notes list for glacial mass observations in this SurveysAggregate.
     *
     * @return The notes list for glacial mass observations.
     */
    public String getGlacial_mass_notes_list() {
        return glacial_mass_notes_list;
    }

    /**
     * Sets the notes list for glacial mass observations for this SurveysAggregate.
     *
     * @param glacial_mass_notes_list The notes list for glacial mass observations to set.
     */
    public void setGlacial_mass_notes_list(String glacial_mass_notes_list) {
        this.glacial_mass_notes_list = glacial_mass_notes_list;
    }

}
