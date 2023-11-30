package org.climatemonitoring.shared.models;

import java.io.Serial;
import java.io.Serializable;

public class PointOfInterest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private int poi_id;
    private String name;
    private String country;
    private float latitude;
    private float longitude;

    public PointOfInterest(){
        //Empty POI
    }

    public PointOfInterest(int poi_id, float latitude, float longitude, String name, String country) {
        this.poi_id = poi_id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.country = country;
    }

    public PointOfInterest(float latitude, float longitude, String name, String country) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.country = country;
    }

    public int getPoi_id() {
        return poi_id;
    }

    public void setPoi_id(int poi_id) {
        this.poi_id = poi_id;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointOfInterest that = (PointOfInterest) o;
        return getPoi_id() == that.getPoi_id();
    }

    @Override
    public String toString() {
        return "PointOfInterest{\n" +
                " poi_id = " + poi_id + ",\n" +
                " name = '" + name + '\'' + ",\n" +
                " country = '" + country + '\'' + ",\n" +
                " latitude = " + String.format("%.5f",latitude) + ",\n" +
                " longitude = " + String.format("%.5f",longitude) + ",\n" +
                '}';
    }

}
