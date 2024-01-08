package com.climatemonitoring.shared.models;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * The <code>Survey</code> class models a survey containing climatic data inserted by users (operators) of a climate center for a specific point of interest monitored by the user's center.
 * This class implements the <code>Serializable</code> interface to support serialization.
 *
 * <p>
 * The class provides constructors for creating surveys with different sets of parameters.
 * Additionally, getter and setter methods are available for accessing and modifying the survey's attributes.
 * </p>
 *
 * <p>
 * The <code>Survey</code> class also implements custom <code>equals</code> and <code>toString</code> methods for object comparison
 * and string representation, respectively. The <code>equals</code> method compares centers based on their unique identifier (<code>dataid</code>).
 * </p>
 *
 * <p>
 * Note: This class is an integral part of the Climate Monitoring application and is utilized on both the client and server sides.
 * </p>
 *
 * @author Lorenzo Cattapan 726459 (Varese)
 * @version 0.9.0
 * @serial 1L
 * @see SurveysAggregate
 */
public class Survey implements Serializable {

    //*****************FIELDS*****************//

    /**
     * The serial version UID for serialization.
     */
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * The unique identifier for the survey data.
     */
    private int dataid;
    /**
     * The unique identifier for the point of interest associated with the survey.
     */
    private int poi_id;
    /**
     * The unique identifier for the monitoring center associated with the survey.
     */
    private int centerid;
    /**
     * The timestamp when the survey data was recorded.
     */
    private Timestamp timestamp;
    /**
     * The wind data recorded in the survey.
     */
    private int wind;
    /**
     * The humidity data recorded in the survey.
     */
    private int humidity;
    /**
     * The pressure data recorded in the survey.
     */
    private int pressure;
    /**
     * The temperature data recorded in the survey.
     */
    private int temperature;
    /**
     * The precipitation data recorded in the survey.
     */
    private int precipitation;
    /**
     * The glacial altitude data recorded in the survey.
     */
    private int glacial_altitude;
    /**
     * The glacial mass data recorded in the survey.
     */
    private int glacial_mass;
    /**
     * Additional notes or comments related to the wind data.
     */
    private String wind_notes;
    /**
     * Additional notes or comments related to the humidity data.
     */
    private String humidity_notes;
    /**
     * Additional notes or comments related to the pressure data.
     */
    private String pressure_notes;
    /**
     * Additional notes or comments related to the temperature data.
     */
    private String temperature_notes;
    /**
     * Additional notes or comments related to the precipitation data.
     */
    private String precipitation_notes;
    /**
     * Additional notes or comments related to the glacial altitude data.
     */
    private String glacial_altitude_notes;
    /**
     * Additional notes or comments related to the glacial mass data.
     */
    private String glacial_mass_notes;

    //*****************CONSTRUCTORS*****************//

    /**
     * Constructs an empty Survey.
     */
    public Survey (){
        //Empty Survey
    }

    /**
     * Constructs a Survey with specified attributes.
     *
     * @param dataid The unique identifier for the survey data.
     * @param poi_id The unique identifier for the point of interest associated with the survey.
     * @param centerid The unique identifier for the monitoring center associated with the survey.
     * @param timestamp The timestamp when the survey data was recorded.
     * @param wind The wind data recorded in the survey.
     * @param humidity The humidity data recorded in the survey.
     * @param pressure The pressure data recorded in the survey.
     * @param temperature The temperature data recorded in the survey.
     * @param precipitation The precipitation data recorded in the survey.
     * @param glacial_altitude The glacial altitude data recorded in the survey.
     * @param glacial_mass The glacial mass data recorded in the survey.
     * @param wind_notes Additional notes or comments related to the wind data.
     * @param humidity_notes Additional notes or comments related to the humidity data.
     * @param pressure_notes Additional notes or comments related to the pressure data.
     * @param temperature_notes Additional notes or comments related to the temperature data.
     * @param precipitation_notes Additional notes or comments related to the precipitation data.
     * @param glacial_altitude_notes Additional notes or comments related to the glacial altitude data.
     * @param glacial_mass_notes Additional notes or comments related to the glacial mass data.
     */
    public Survey(int dataid, int poi_id, int centerid, Timestamp timestamp, int wind, int humidity, int pressure, int temperature, int precipitation, int glacial_altitude, int glacial_mass, String wind_notes, String humidity_notes, String pressure_notes, String temperature_notes, String precipitation_notes, String glacial_altitude_notes, String glacial_mass_notes) {
        this.dataid = dataid;
        this.poi_id = poi_id;
        this.centerid = centerid;
        this.timestamp = timestamp;
        this.wind = wind;
        this.humidity = humidity;
        this.pressure = pressure;
        this.temperature = temperature;
        this.precipitation = precipitation;
        this.glacial_altitude = glacial_altitude;
        this.glacial_mass = glacial_mass;
        this.wind_notes = wind_notes;
        this.humidity_notes = humidity_notes;
        this.pressure_notes = pressure_notes;
        this.temperature_notes = temperature_notes;
        this.precipitation_notes = precipitation_notes;
        this.glacial_altitude_notes = glacial_altitude_notes;
        this.glacial_mass_notes = glacial_mass_notes;
    }

    /**
     * Constructs a Survey with specified attributes, excluding the unique identifier for survey data.
     *
     * @param poi_id The unique identifier for the point of interest associated with the survey.
     * @param centerid The unique identifier for the monitoring center associated with the survey.
     * @param wind The wind data recorded in the survey.
     * @param humidity The humidity data recorded in the survey.
     * @param pressure The pressure data recorded in the survey.
     * @param temperature The temperature data recorded in the survey.
     * @param precipitation The precipitation data recorded in the survey.
     * @param glacial_altitude The glacial altitude data recorded in the survey.
     * @param glacial_mass The glacial mass data recorded in the survey.
     * @param wind_notes Additional notes or comments related to the wind data.
     * @param humidity_notes Additional notes or comments related to the humidity data.
     * @param pressure_notes Additional notes or comments related to the pressure data.
     * @param temperature_notes Additional notes or comments related to the temperature data.
     * @param precipitation_notes Additional notes or comments related to the precipitation data.
     * @param glacial_altitude_notes Additional notes or comments related to the glacial altitude data.
     * @param glacial_mass_notes Additional notes or comments related to the glacial mass data.
     */
    public Survey(int poi_id, int centerid, int wind, int humidity, int pressure, int temperature, int precipitation, int glacial_altitude, int glacial_mass, String wind_notes, String humidity_notes, String pressure_notes, String temperature_notes, String precipitation_notes, String glacial_altitude_notes, String glacial_mass_notes){
        this.poi_id = poi_id;
        this.centerid = centerid;
        this.wind = wind;
        this.humidity = humidity;
        this.pressure = pressure;
        this.temperature = temperature;
        this.precipitation = precipitation;
        this.glacial_altitude = glacial_altitude;
        this.glacial_mass = glacial_mass;
        this.wind_notes = wind_notes;
        this.humidity_notes = humidity_notes;
        this.pressure_notes = pressure_notes;
        this.temperature_notes = temperature_notes;
        this.precipitation_notes = precipitation_notes;
        this.glacial_altitude_notes = glacial_altitude_notes;
        this.glacial_mass_notes = glacial_mass_notes;
    }

    //*****************GETTER AND SETTER*****************//

    /**
     * Gets the unique identifier for the survey data.
     *
     * @return The unique identifier.
     */
    public int getDataid() {
        return dataid;
    }

    /**
     * Sets the unique identifier for the survey data.
     *
     * @param dataid The new unique identifier.
     */
    public void setDataid(int dataid) {
        this.dataid = dataid;
    }

    /**
     * Gets the unique identifier for the point of interest associated with the survey.
     *
     * @return The unique identifier.
     */
    public int getPoi_id() {
        return poi_id;
    }

    /**
     * Sets the unique identifier for the point of interest associated with the survey.
     *
     * @param poi_id The new unique identifier.
     */
    public void setPoi_id(int poi_id) {
        this.poi_id = poi_id;
    }

    /**
     * Gets the unique identifier for the monitoring center associated with the survey.
     *
     * @return The unique identifier.
     */
    public int getCenterid() {
        return centerid;
    }

    /**
     * Sets the unique identifier for the monitoring center associated with the survey.
     *
     * @param centerid The new unique identifier.
     */
    public void setCenterid(int centerid) {
        this.centerid = centerid;
    }

    /**
     * Gets the timestamp when the survey data was recorded.
     *
     * @return The timestamp.
     */
    public Timestamp getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the timestamp when the survey data was recorded.
     *
     * @param timestamp The new timestamp.
     */
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Gets the wind data recorded in the survey.
     *
     * @return The wind data.
     */
    public int getWind() {
        return wind;
    }

    /**
     * Sets the wind data recorded in the survey.
     *
     * @param wind The new wind data.
     */
    public void setWind(int wind) {
        this.wind = wind;
    }

    /**
     * Gets the humidity data recorded in the survey.
     *
     * @return The humidity data.
     */
    public int getHumidity() {
        return humidity;
    }

    /**
     * Sets the humidity data recorded in the survey.
     *
     * @param humidity The new humidity data.
     */
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    /**
     * Gets the pressure data recorded in the survey.
     *
     * @return The pressure data.
     */
    public int getPressure() {
        return pressure;
    }

    /**
     * Sets the pressure data recorded in the survey.
     *
     * @param pressure The new pressure data.
     */
    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    /**
     * Gets the temperature data recorded in the survey.
     *
     * @return The temperature data.
     */
    public int getTemperature() {
        return temperature;
    }

    /**
     * Sets the temperature data recorded in the survey.
     *
     * @param temperature The new temperature data.
     */
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    /**
     * Gets the precipitation data recorded in the survey.
     *
     * @return The precipitation data.
     */
    public int getPrecipitation() {
        return precipitation;
    }

    /**
     * Sets the precipitation data recorded in the survey.
     *
     * @param precipitation The new precipitation data.
     */
    public void setPrecipitation(int precipitation) {
        this.precipitation = precipitation;
    }

    /**
     * Gets the glacial altitude data recorded in the survey.
     *
     * @return The glacial altitude data.
     */
    public int getGlacial_altitude() {
        return glacial_altitude;
    }

    /**
     * Sets the glacial altitude data recorded in the survey.
     *
     * @param glacial_altitude The new glacial altitude data.
     */
    public void setGlacial_altitude(int glacial_altitude) {
        this.glacial_altitude = glacial_altitude;
    }

    /**
     * Gets the glacial mass data recorded in the survey.
     *
     * @return The glacial mass data.
     */
    public int getGlacial_mass() {
        return glacial_mass;
    }

    /**
     * Sets the glacial mass data recorded in the survey.
     *
     * @param glacial_mass The new glacial mass data.
     */
    public void setGlacial_mass(int glacial_mass) {
        this.glacial_mass = glacial_mass;
    }

    /**
     * Gets additional notes or comments related to the wind data.
     *
     * @return Additional notes or comments.
     */
    public String getWind_notes() {
        return wind_notes;
    }

    /**
     * Sets additional notes or comments related to the wind data.
     *
     * @param wind_notes The new wind notes or comments.
     */
    public void setWind_notes(String wind_notes) {
        this.wind_notes = wind_notes;
    }

    /**
     * Gets additional notes or comments related to the humidity data.
     *
     * @return Additional notes or comments.
     */
    public String getHumidity_notes() {
        return humidity_notes;
    }

    /**
     * Sets additional notes or comments related to the humidity data.
     *
     * @param humidity_notes The new humidity notes or comments.
     */
    public void setHumidity_notes(String humidity_notes) {
        this.humidity_notes = humidity_notes;
    }

    /**
     * Gets additional notes or comments related to the pressure data.
     *
     * @return Additional notes or comments.
     */
    public String getPressure_notes() {
        return pressure_notes;
    }

    /**
     * Sets additional notes or comments related to the pressure data.
     *
     * @param pressure_notes The new pressure notes or comments.
     */
    public void setPressure_notes(String pressure_notes) {
        this.pressure_notes = pressure_notes;
    }

    /**
     * Gets additional notes or comments related to the temperature data.
     *
     * @return Additional notes or comments.
     */
    public String getTemperature_notes() {
        return temperature_notes;
    }

    /**
     * Sets additional notes or comments related to the temperature data.
     *
     * @param temperature_notes The new temperature notes or comments.
     */
    public void setTemperature_notes(String temperature_notes) {
        this.temperature_notes = temperature_notes;
    }

    /**
     * Gets additional notes or comments related to the precipitation data.
     *
     * @return Additional notes or comments.
     */
    public String getPrecipitation_notes() {
        return precipitation_notes;
    }

    /**
     * Sets additional notes or comments related to the precipitation data.
     *
     * @param precipitation_notes The new precipitation notes or comments.
     */
    public void setPrecipitation_notes(String precipitation_notes) {
        this.precipitation_notes = precipitation_notes;
    }

    /**
     * Gets additional notes for glacial altitude data.
     *
     * @return The glacial altitude notes.
     */
    public String getGlacial_altitude_notes() {
        return glacial_altitude_notes;
    }

    /**
     * Sets additional notes for glacial altitude data.
     *
     * @param glacial_altitude_notes The new glacial altitude notes or comments.
     */
    public void setGlacial_altitude_notes(String glacial_altitude_notes) {
        this.glacial_altitude_notes = glacial_altitude_notes;
    }

    /**
     * Gets additional notes for glacial mass data.
     *
     * @return The glacial mass notes.
     */
    public String getGlacial_mass_notes() {
        return glacial_mass_notes;
    }

    /**
     * Sets additional notes for glacial mass data.
     *
     * @param glacial_mass_notes The new glacial mass notes or comments.
     */
    public void setGlacial_mass_notes(String glacial_mass_notes) {
        this.glacial_mass_notes = glacial_mass_notes;
    }

    //*****************CUSTOM EQUALS AND TOSTRING METHODS*****************//

    /**
     * Checks if this Survey object is equal to another object. Two surveys are considered equal if they have the same dataid.
     *
     * @param o The object to compare to.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        // Check if the compared object is the same instance
        if (this == o) return true;

        // Check if the compared object is null or belongs to a different class
        if (o == null || getClass() != o.getClass()) return false;

        // Cast the compared object to a Survey
        Survey survey = (Survey) o;

        // Compare the relevant fields for equality
        return getDataid() == survey.getDataid();
    }

    /**
     * Generates a string representation of the Survey object. The string includes detailed information about the survey,
     * such as dataid, poi_id, centerid, timestamp, and various climatic data along with any notes.
     *
     * @return A string representation of the Survey object.
     */
    @Override
    public String toString() {
        return "Survey{\n" +
                " dataid = " + dataid + ",\n" +
                " poi_id = " + poi_id + ",\n" +
                " centerid = " + centerid + "\n" +
                " timestamp = " + timestamp + ",\n" +
                " wind = " + wind + ",\n" +
                " humidity = " + humidity + ",\n" +
                " pressure = " + pressure + ",\n" +
                " temperature = " + temperature + ",\n" +
                " precipitation = " + precipitation + ",\n" +
                " glacial_altitude = " + glacial_altitude + ",\n" +
                " glacial_mass = " + glacial_mass + ",\n" +
                " wind_notes = " + wind_notes + ",\n" +
                " humidity_notes = " + humidity_notes + ",\n" +
                " pressure_notes = " + pressure_notes + ",\n" +
                " temperature_notes = " + temperature_notes + ",\n" +
                " precipitation_notes = " + pressure_notes + ",\n" +
                " glacial_altitude_notes = " + glacial_altitude_notes + ",\n" +
                " glacial_mass_notes = " + glacial_mass_notes + ",\n" +
                '}';
    }

}
