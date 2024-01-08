package com.climatemonitoring.shared.models;

import java.io.Serial;
import java.io.Serializable;

/**
 * The <code>MonitoringCenter</code> class represents a Climate Monitoring Center in the Climate Monitoring application.
 * Each center is associated with a unique identifier (<code>centerid</code>) and includes information such as its name,
 * address, address number, CAP (Postal Code), city, and province.
 * This class implements the <code>Serializable</code> interface to support serialization.
 *
 * <p>
 * The class provides constructors for creating monitoring centers with different sets of parameters.
 * Additionally, getter and setter methods are available for accessing and modifying the center's attributes.
 * </p>
 *
 * <p>
 * The <code>MonitoringCenter</code> class also implements custom <code>equals</code> and <code>toString</code> methods for object comparison
 * and string representation, respectively. The <code>equals</code> method compares centers based on their unique identifier (<code>centerid</code>).
 * </p>
 *
 * <p>
 * Note: This class is an integral part of the Climate Monitoring application and is utilized on both the client and server sides.
 * It is used to represent Climate Monitoring Centers where each user, acting as an operator, is associated with a specific center.
 * The <code>MonitoringCenter</code> class plays a crucial role in the overall architecture, facilitating the submission of surveys containing
 * climatic data and comments for each Point of Interest within the associated center.
 * </p>
 *
 * @author Lorenzo Cattapan 726459 (Varese)
 * @version 0.9.0
 * @serial 1L
 */
public class MonitoringCenter implements Serializable {

    //*****************FIELDS*****************//

    /**
     * A unique identifier for ensuring version compatibility during object serialization.
     * It is used to control the version of the class during the deserialization process.
     *
     * @serial
     */
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * The unique identifier for the Climate Monitoring Center.
     */
    private int centerid;
    /**
     * The name of the Climate Monitoring Center.
     */
    private String name;
    /**
     * The address of the Climate Monitoring Center.
     */
    private String address;
    /**
     * The address number of the Climate Monitoring Center.
     */
    private int addressNumber;
    /**
     * The CAP (Postal Code) of the Climate Monitoring Center's address.
     */
    private int cap;
    /**
     * The city where the Climate Monitoring Center is located.
     */
    private String city;
    /**
     * The province where the Climate Monitoring Center is located.
     */
    private String province;

    //*****************CONSTRUCTORS*****************//

    /**
     * Constructs an empty `MonitoringCenter` object. Used when creating a new monitoring center without specific information.
     */
    public MonitoringCenter() {
        //Empty
    }

    /**
     * Constructs a `MonitoringCenter` object with specified attributes.
     *
     * @param centerid       The unique identifier for the Climate Monitoring Center.
     * @param name           The name of the Climate Monitoring Center.
     * @param address        The address of the Climate Monitoring Center.
     * @param addressNumber  The address number of the Climate Monitoring Center.
     * @param cap            The CAP (Postal Code) of the Climate Monitoring Center's address.
     * @param city           The city where the Climate Monitoring Center is located.
     * @param province       The province where the Climate Monitoring Center is located.
     */
    public MonitoringCenter(int centerid, String name, String address, int addressNumber, int cap, String city, String province) {
        this.centerid = centerid;
        this.name = name;
        this.address = address;
        this.addressNumber = addressNumber;
        this.cap = cap;
        this.city = city;
        this.province = province;
    }

    /**
     * Constructs a `MonitoringCenter` object with specified attributes, excluding the unique identifier.
     * This constructor is typically used when creating a new monitoring center without a pre-assigned ID.
     *
     * @param name           The name of the Climate Monitoring Center.
     * @param address        The address of the Climate Monitoring Center.
     * @param addressNumber  The address number of the Climate Monitoring Center.
     * @param cap            The CAP (Postal Code) of the Climate Monitoring Center's address.
     * @param city           The city where the Climate Monitoring Center is located.
     * @param province       The province where the Climate Monitoring Center is located.
     */
    public MonitoringCenter(String name, String address, int addressNumber, int cap, String city, String province) {
        this.name = name;
        this.address = address;
        this.addressNumber = addressNumber;
        this.cap = cap;
        this.city = city;
        this.province = province;
    }

    //*****************GETTER AND SETTER*****************//

    /**
     * Gets the unique identifier of the Climate Monitoring Center.
     *
     * @return The center's unique identifier.
     */
    public int getCenterid() {
        return centerid;
    }

    /**
     * Sets the unique identifier of the Climate Monitoring Center.
     *
     * @param centerid The new unique identifier for the center.
     */
    public void setCenterid(int centerid) {
        this.centerid = centerid;
    }

    /**
     * Gets the name of the Climate Monitoring Center.
     *
     * @return The name of the center.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Climate Monitoring Center.
     *
     * @param name The new name for the center.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the address of the Climate Monitoring Center.
     *
     * @return The address of the center.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the Climate Monitoring Center.
     *
     * @param address The new address for the center.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the address number of the Climate Monitoring Center.
     *
     * @return The address number of the center.
     */
    public int getAddressNumber() {
        return addressNumber;
    }

    /**
     * Sets the address number of the Climate Monitoring Center.
     *
     * @param addressNumber The new address number for the center.
     */
    public void setAddressNumber(int addressNumber) {
        this.addressNumber = addressNumber;
    }

    /**
     * Gets the CAP (Postal Code) of the Climate Monitoring Center.
     *
     * @return The CAP of the center's address.
     */
    public int getCap() {
        return cap;
    }

    /**
     * Sets the CAP (Postal Code) of the Climate Monitoring Center.
     *
     * @param cap The new CAP for the center's address.
     */
    public void setCap(int cap) {
        this.cap = cap;
    }

    /**
     * Gets the city where the Climate Monitoring Center is located.
     *
     * @return The city where the center is located.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city where the Climate Monitoring Center is located.
     *
     * @param city The new city for the center.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the province where the Climate Monitoring Center is located.
     *
     * @return The province where the center is located.
     */
    public String getProvince() {
        return province;
    }

    /**
     * Sets the province where the Climate Monitoring Center is located.
     *
     * @param province The new province for the center.
     */
    public void setProvince(String province) {
        this.province = province;
    }

    //*****************CUSTOM EQUALS AND TOSTRING*****************//

    /**
     * Compares this `MonitoringCenter` object with another object to check for equality.
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

        // Cast the compared object to a MonitoringCenter
        MonitoringCenter that = (MonitoringCenter) o;

        // Compare the unique identifier for equality
        return getCenterid() == that.getCenterid();
    }

    /**
     * Returns a string representation of the `MonitoringCenter` object.
     *
     * @return A string containing the attributes of the center in a formatted manner.
     */
    @Override
    public String toString() {
        return "MonitoringCenter{\n" +
                " centerid=" + centerid + ",\n" +
                " name='" + name + '\'' + ",\n" +
                " address='" + address + '\'' + ",\n" +
                " addressNumber=" + addressNumber + ",\n" +
                " cap=" + cap + ",\n" +
                " city='" + city + '\'' + ",\n" +
                " province='" + province + '\'' + "\n" +
                '}';
    }

}
