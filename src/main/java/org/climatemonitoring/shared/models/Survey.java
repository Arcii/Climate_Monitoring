package org.climatemonitoring.shared.models;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

public class Survey implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private int dataid;
    private int poi_id;
    private int centerid;
    private Timestamp timestamp;
    private int wind;
    private int humidity;
    private int pressure;
    private int temperature;
    private int precipitation;
    private int glacial_altitude;
    private int glacial_mass;
    private String wind_notes;
    private String humidity_notes;
    private String pressure_notes;
    private String temperature_notes;
    private String precipitation_notes;
    private String glacial_altitude_notes;
    private String glacial_mass_notes;

    public Survey (){
        //Empty Survey
    }

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

    public int getDataid() {
        return dataid;
    }

    public void setDataid(int dataid) {
        this.dataid = dataid;
    }

    public int getPoi_id() {
        return poi_id;
    }

    public void setPoi_id(int poi_id) {
        this.poi_id = poi_id;
    }

    public int getCenterid() {
        return centerid;
    }

    public void setCenterid(int centerid) {
        this.centerid = centerid;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getWind() {
        return wind;
    }

    public void setWind(int wind) {
        this.wind = wind;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(int precipitation) {
        this.precipitation = precipitation;
    }

    public int getGlacial_altitude() {
        return glacial_altitude;
    }

    public void setGlacial_altitude(int glacial_altitude) {
        this.glacial_altitude = glacial_altitude;
    }

    public int getGlacial_mass() {
        return glacial_mass;
    }

    public void setGlacial_mass(int glacial_mass) {
        this.glacial_mass = glacial_mass;
    }

    public String getWind_notes() {
        return wind_notes;
    }

    public void setWind_notes(String wind_notes) {
        this.wind_notes = wind_notes;
    }

    public String getHumidity_notes() {
        return humidity_notes;
    }

    public void setHumidity_notes(String humidity_notes) {
        this.humidity_notes = humidity_notes;
    }

    public String getPressure_notes() {
        return pressure_notes;
    }

    public void setPressure_notes(String pressure_notes) {
        this.pressure_notes = pressure_notes;
    }

    public String getTemperature_notes() {
        return temperature_notes;
    }

    public void setTemperature_notes(String temperature_notes) {
        this.temperature_notes = temperature_notes;
    }

    public String getPrecipitation_notes() {
        return precipitation_notes;
    }

    public void setPrecipitation_notes(String precipitation_notes) {
        this.precipitation_notes = precipitation_notes;
    }

    public String getGlacial_altitude_notes() {
        return glacial_altitude_notes;
    }

    public void setGlacial_altitude_notes(String glacial_altitude_notes) {
        this.glacial_altitude_notes = glacial_altitude_notes;
    }

    public String getGlacial_mass_notes() {
        return glacial_mass_notes;
    }

    public void setGlacial_mass_notes(String glacial_mass_notes) {
        this.glacial_mass_notes = glacial_mass_notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Survey survey = (Survey) o;
        return getDataid() == survey.getDataid();
    }

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
