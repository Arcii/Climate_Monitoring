package com.climatemonitoring.shared.models;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class SurveysAggregate implements Serializable {

    //FIELDS

    @Serial
    private static final long serialVersionUID = 1L;
    private int poi_id;
    private int surveysCount;
    private int centersCount;
    private Timestamp oldestTimestamp;
    private Timestamp mostRecentTimestamp;
    private float wind_avg;
    private float humidity_avg;
    private float pressure_avg;
    private float temperature_avg;
    private float precipitation_avg;
    private float glacial_altitude_avg;
    private float glacial_mass_avg;
    private int wind_max;
    private int humidity_max;
    private int pressure_max;
    private int temperature_max;
    private int precipitation_max;
    private int glacial_altitude_max;
    private int glacial_mass_max;
    private int wind_min;
    private int humidity_min;
    private int pressure_min;
    private int temperature_min;
    private int precipitation_min;
    private int glacial_altitude_min;
    private int glacial_mass_min;
    private String wind_notes_list;
    private String humidity_notes_list;
    private String pressure_notes_list;
    private String temperature_notes_list;
    private String precipitation_notes_list;
    private String glacial_altitude_notes_list;
    private String glacial_mass_notes_list;

    //CONSTRUCTORS

    public SurveysAggregate(){
        //Empty Constructor
    }

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

    //GETTER AND SETTER

    public int getPoi_id() {
        return poi_id;
    }

    public void setPoi_id(int poi_id) {
        this.poi_id = poi_id;
    }

    public int getSurveysCount() {
        return surveysCount;
    }

    public void setSurveysCount(int surveysCount) {
        this.surveysCount = surveysCount;
    }

    public int getCentersCount() {
        return centersCount;
    }

    public void setCentersCount(int centersCount) {
        this.centersCount = centersCount;
    }

    public Timestamp getOldestTimestamp() {
        return oldestTimestamp;
    }

    public void setOldestTimestamp(Timestamp oldestTimestamp) {
        this.oldestTimestamp = oldestTimestamp;
    }

    public Timestamp getMostRecentTimestamp() {
        return mostRecentTimestamp;
    }

    public void setMostRecentTimestamp(Timestamp mostRecentTimestamp) {
        this.mostRecentTimestamp = mostRecentTimestamp;
    }

    public float getWind_avg() {
        return wind_avg;
    }

    public void setWind_avg(float wind_avg) {
        this.wind_avg = wind_avg;
    }

    public float getHumidity_avg() {
        return humidity_avg;
    }

    public void setHumidity_avg(float humidity_avg) {
        this.humidity_avg = humidity_avg;
    }

    public float getPressure_avg() {
        return pressure_avg;
    }

    public void setPressure_avg(float pressure_avg) {
        this.pressure_avg = pressure_avg;
    }

    public float getTemperature_avg() {
        return temperature_avg;
    }

    public void setTemperature_avg(float temperature_avg) {
        this.temperature_avg = temperature_avg;
    }

    public float getPrecipitation_avg() {
        return precipitation_avg;
    }

    public void setPrecipitation_avg(float precipitation_avg) {
        this.precipitation_avg = precipitation_avg;
    }

    public float getGlacial_altitude_avg() {
        return glacial_altitude_avg;
    }

    public void setGlacial_altitude_avg(float glacial_altitude_avg) {
        this.glacial_altitude_avg = glacial_altitude_avg;
    }

    public float getGlacial_mass_avg() {
        return glacial_mass_avg;
    }

    public void setGlacial_mass_avg(float glacial_mass_avg) {
        this.glacial_mass_avg = glacial_mass_avg;
    }

    public int getWind_max() {
        return wind_max;
    }

    public void setWind_max(int wind_max) {
        this.wind_max = wind_max;
    }

    public int getHumidity_max() {
        return humidity_max;
    }

    public void setHumidity_max(int humidity_max) {
        this.humidity_max = humidity_max;
    }

    public int getPressure_max() {
        return pressure_max;
    }

    public void setPressure_max(int pressure_max) {
        this.pressure_max = pressure_max;
    }

    public int getTemperature_max() {
        return temperature_max;
    }

    public void setTemperature_max(int temperature_max) {
        this.temperature_max = temperature_max;
    }

    public int getPrecipitation_max() {
        return precipitation_max;
    }

    public void setPrecipitation_max(int precipitation_max) {
        this.precipitation_max = precipitation_max;
    }

    public int getGlacial_altitude_max() {
        return glacial_altitude_max;
    }

    public void setGlacial_altitude_max(int glacial_altitude_max) {
        this.glacial_altitude_max = glacial_altitude_max;
    }

    public int getGlacial_mass_max() {
        return glacial_mass_max;
    }

    public void setGlacial_mass_max(int glacial_mass_max) {
        this.glacial_mass_max = glacial_mass_max;
    }

    public int getWind_min() {
        return wind_min;
    }

    public void setWind_min(int wind_min) {
        this.wind_min = wind_min;
    }

    public int getHumidity_min() {
        return humidity_min;
    }

    public void setHumidity_min(int humidity_min) {
        this.humidity_min = humidity_min;
    }

    public int getPressure_min() {
        return pressure_min;
    }

    public void setPressure_min(int pressure_min) {
        this.pressure_min = pressure_min;
    }

    public int getTemperature_min() {
        return temperature_min;
    }

    public void setTemperature_min(int temperature_min) {
        this.temperature_min = temperature_min;
    }

    public int getPrecipitation_min() {
        return precipitation_min;
    }

    public void setPrecipitation_min(int precipitation_min) {
        this.precipitation_min = precipitation_min;
    }

    public int getGlacial_altitude_min() {
        return glacial_altitude_min;
    }

    public void setGlacial_altitude_min(int glacial_altitude_min) {
        this.glacial_altitude_min = glacial_altitude_min;
    }

    public int getGlacial_mass_min() {
        return glacial_mass_min;
    }

    public void setGlacial_mass_min(int glacial_mass_min) {
        this.glacial_mass_min = glacial_mass_min;
    }

    public String getWind_notes_list() {
        return wind_notes_list;
    }

    public void setWind_notes_list(String wind_notes_list) {
        this.wind_notes_list = wind_notes_list;
    }

    public String getHumidity_notes_list() {
        return humidity_notes_list;
    }

    public void setHumidity_notes_list(String humidity_notes_list) {
        this.humidity_notes_list = humidity_notes_list;
    }

    public String getPressure_notes_list() {
        return pressure_notes_list;
    }

    public void setPressure_notes_list(String pressure_notes_list) {
        this.pressure_notes_list = pressure_notes_list;
    }

    public String getTemperature_notes_list() {
        return temperature_notes_list;
    }

    public void setTemperature_notes_list(String temperature_notes_list) {
        this.temperature_notes_list = temperature_notes_list;
    }

    public String getPrecipitation_notes_list() {
        return precipitation_notes_list;
    }

    public void setPrecipitation_notes_list(String precipitation_notes_list) {
        this.precipitation_notes_list = precipitation_notes_list;
    }

    public String getGlacial_altitude_notes_list() {
        return glacial_altitude_notes_list;
    }

    public void setGlacial_altitude_notes_list(String glacial_altitude_notes_list) {
        this.glacial_altitude_notes_list = glacial_altitude_notes_list;
    }

    public String getGlacial_mass_notes_list() {
        return glacial_mass_notes_list;
    }

    public void setGlacial_mass_notes_list(String glacial_mass_notes_list) {
        this.glacial_mass_notes_list = glacial_mass_notes_list;
    }

}
