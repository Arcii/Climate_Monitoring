package com.climatemonitoring.shared.models;

import java.io.Serial;
import java.io.Serializable;

/**
 * The PointOfInterest class represents a location or point of interest that is monitored by Climate Monitoring Centers.
 * Users, who are operators of these centers, can add climatic data through surveys for each PointOfInterest.
 * This class implements the Serializable interface to support serialization.
 *
 * <p>
 * The class provides constructors for creating points of interest with different sets of parameters.
 * Additionally, getter and setter methods are available for accessing and modifying the point of interest's attributes.
 * </p>
 *
 * <p>
 * The `PointOfInterest` class also implements custom `equals` and `toString` methods for object comparison
 * and string representation, respectively. The `equals` method compares points based on their unique identifier (`poi_id`).
 * </p>
 *
 * <p>
 * Note: This class is an integral part of the Climate Monitoring application and is utilized on both the client and server sides.
 * </p>
 *
 * @author Lorenzo Cattapan 726459 (Varese)
 * @version 1.0
 * @serial 1L
 */
public class PointOfInterest implements Serializable {

    //*****************FIELDS*****************//

    /**
     * The serial version UID for serialization.
     */
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * The unique identifier for the PointOfInterest.
     */
    private int poi_id;
    /**
     * The name or label of the PointOfInterest.
     */
    private String name;
    /**
     * The country where the PointOfInterest is located.
     */
    private String country;
    /**
     * The latitude of the PointOfInterest's location.
     */
    private float latitude;
    /**
     * The longitude of the PointOfInterest's location.
     */
    private float longitude;

    //*****************CONSTRUCTORS*****************//

    /**
     * Constructs an empty PointOfInterest.
     */
    public PointOfInterest(){
        //Empty POI
    }

    /**
     * Constructs a PointOfInterest with specified attributes.
     *
     * @param poi_id The unique identifier for the PointOfInterest.
     * @param latitude The latitude of the PointOfInterest's location.
     * @param longitude The longitude of the PointOfInterest's location.
     * @param name The name or label of the PointOfInterest.
     * @param country The country where the PointOfInterest is located.
     */
    public PointOfInterest(int poi_id, float latitude, float longitude, String name, String country) {
        this.poi_id = poi_id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.country = country;
    }

    /**
     * Constructs a PointOfInterest with specified attributes, excluding the unique identifier.
     *
     * @param latitude The latitude of the PointOfInterest's location.
     * @param longitude The longitude of the PointOfInterest's location.
     * @param name The name or label of the PointOfInterest.
     * @param country The country where the PointOfInterest is located.
     */
    public PointOfInterest(float latitude, float longitude, String name, String country) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.country = country;
    }

    //*****************GETTER AND SETTER*****************//

    /**
     * Gets the unique identifier for the PointOfInterest.
     *
     * @return The unique identifier.
     */
    public int getPoi_id() {
        return poi_id;
    }

    /**
     * Sets the unique identifier for the PointOfInterest.
     *
     * @param poi_id The new unique identifier.
     */
    public void setPoi_id(int poi_id) {
        this.poi_id = poi_id;
    }

    /**
     * Gets the latitude of the PointOfInterest's location.
     *
     * @return The latitude.
     */
    public float getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude of the PointOfInterest's location.
     *
     * @param latitude The new latitude.
     */
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    /**
     * Gets the longitude of the PointOfInterest's location.
     *
     * @return The longitude.
     */
    public float getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude of the PointOfInterest's location.
     *
     * @param longitude The new longitude.
     */
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    /**
     * Gets the name or label of the PointOfInterest.
     *
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name or label of the PointOfInterest.
     *
     * @param name The new name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the country where the PointOfInterest is located.
     *
     * @return The country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country where the PointOfInterest is located.
     *
     * @param country The new country.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    //*****************CUSTOM EQUALS AND TOSTRING METHODS*****************//

    /**
     * Compares this `PointOfInterest` object with another object to check for equality.
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

        // Cast the compared object to a PointOfInterest
        PointOfInterest that = (PointOfInterest) o;

        // Compare the unique identifier for equality
        return getPoi_id() == that.getPoi_id();
    }

    /**
     * Returns a string representation of the `PointOfInterest` object.
     *
     * @return A string containing the attributes of the point of interest in a formatted manner.
     */
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
