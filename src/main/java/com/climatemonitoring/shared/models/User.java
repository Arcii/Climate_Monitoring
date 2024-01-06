package com.climatemonitoring.shared.models;

import java.io.Serial;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * The `User` class represents a registered operator in the Climate Monitoring application.
 * Each user is associated with a Climate Monitoring Center and has the ability to submit
 * climate surveys for specific points of interest within the center to a database.
 *
 * <p>
 * This class implements the Serializable interface to enable object serialization.
 * </p>
 *
 * <p>
 * The `User` class encapsulates information such as the user's name, surname, email,
 * unique identifier, fiscal code, hashed password, and the center ID to which the user is associated.
 * It provides methods to set and retrieve user information, as well as secure password handling
 * through hashing using the SHA-256 algorithm. The class also includes a method to check passwords securely.
 * Additionally, custom `equals` and `toString` methods are implemented for object comparison
 * and string representation, respectively.
 * </p>
 *
 * <p>
 * Note: The hashed password is stored securely using the SHA-256 algorithm for enhanced security.
 * This class is an integral part of the Climate Monitoring application and is utilized on both the client and server sides.
 * </p>
 *
 * @author Lorenzo Cattapan 726459 (Varese)
 * @version 1.0
 * @serial 1L
 */
public class User implements Serializable {

    //*****************FIELDS*****************//

    /**
     * A unique identifier for ensuring version compatibility during object serialization.
     * It is used to control the version of the class during the deserialization process.
     * The value of this field is 1L by default.
     *
     * @serial
     */
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * A unique identifier for the user, serving as the primary key in the database.
     */
    private String userid;
    /**
     * The first name of the user.
     */
    private String name;
    /**
     * The last name of the user.
     */
    private String surname;
    /**
     * The email address associated with the user.
     */
    private String email;
    /**
     * The fiscal code, a unique identifier for tax purposes, associated with the user.
     */
    private String fiscalCode;
    /**
     * The hashed password for secure authentication.
     * The password is processed using the SHA-256 algorithm before storage.
     */
    private String hashedPassword;
    /**
     * The identifier of the Climate Monitoring Center to which the user is associated.
     */
    private int centerid;

    //*****************CONSTRUCTORS*****************//

    /**
     * Constructs an empty User object. Used when creating a new user without specific information.
     */
    public User() {
        //Empty User
    }

    /**
     * Constructs a User object with specified attributes.
     *
     * @param name           The first name of the user.
     * @param surname        The last name of the user.
     * @param email          The email address associated with the user.
     * @param userID         The unique identifier (user ID) for the user, serving as the primary key in the database.
     * @param fiscalCode     The fiscal code, a unique identifier for tax purposes, associated with the user.
     * @param hashedPassword The hashed password for secure authentication.
     *                       The password is processed using the SHA-256 algorithm before storage.
     */
    public User(String name, String surname, String email, String userID, String fiscalCode, String hashedPassword) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.userid = userID;
        this.fiscalCode = fiscalCode;
        this.hashedPassword = hashedPassword;
    }

    //*****************GETTER AND SETTER*****************//

    /**
     * Retrieves the first name of the user.
     *
     * @return The first name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the first name of the user.
     *
     * @param name The first name to be set for the user.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the last name of the user.
     *
     * @return The last name of the user.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the last name of the user.
     *
     * @param surname The last name to be set for the user.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Retrieves the email address associated with the user.
     *
     * @return The email address of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address for the user.
     *
     * @param email The email address to be set for the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the unique identifier (user ID) for the user, serving as the primary key in the database.
     *
     * @return The user ID.
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Sets the unique identifier (user ID) for the user.
     *
     * @param userid The user ID to be set.
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * Retrieves the fiscal code, a unique identifier for tax purposes, associated with the user.
     *
     * @return The fiscal code of the user.
     */
    public String getFiscalCode() {
        return fiscalCode;
    }

    /**
     * Sets the fiscal code for the user.
     *
     * @param fiscalCode The fiscal code to be set for the user.
     */
    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    /**
     * Retrieves the hashed password for secure authentication.
     *
     * @return The hashed password.
     */
    public String getHashedPassword() {
        return hashedPassword;
    }

    /**
     * Sets the hashed password for the user securely using the SHA-256 algorithm.
     *
     * @param password The password to be hashed and set.
     */
    public void setHashedPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedPasswordBytes = md.digest(password.getBytes());
            this.hashedPassword = bytesToHex(hashedPasswordBytes);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Set hashed password : NoSuchAlgorithmException");
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the identifier of the Climate Monitoring Center to which the user is associated.
     *
     * @return The center ID.
     */
    public int getCenterid() {
        return centerid;
    }

    /**
     * Sets the identifier of the Climate Monitoring Center for the user.
     *
     * @param centerid The center ID to be set.
     */
    public void setCenterid(int centerid) {
        this.centerid = centerid;
    }

    //*****************PUBLIC METHODS*****************//

    /**
     * Checks if the provided password matches the stored hashed password for the user.
     *
     * @param password The password to be checked.
     * @return True if the provided password matches the stored hashed password, false otherwise.
     */
    public boolean checkPassword(String password) {
        try {
            // Instantiate a MessageDigest with the SHA-256 algorithm
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Compute the hash of the provided password
            byte[] hashedPasswordBytes = md.digest(password.getBytes());

            // Convert the hashed password bytes to a hexadecimal string
            String hashedPassword = bytesToHex(hashedPasswordBytes);

            // Compare the computed hash with the stored hashed password
            return hashedPassword.equals(this.hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            // Handle the case where the SHA-256 algorithm is not available
            System.out.println("Check password : NoSuchAlgorithmException");
            e.printStackTrace();
            return false;
        }
    }

    //*****************PRIVATE METHODS*****************//

    /**
     * Converts an array of bytes to its hexadecimal representation.
     *
     * @param bytes The array of bytes to be converted.
     * @return A hexadecimal string representing the input array of bytes.
     */
    private static String bytesToHex(byte[] bytes) {
        // Create a StringBuilder to store the hexadecimal representation
        StringBuilder result = new StringBuilder();

        // Iterate through each byte in the array
        for (byte b : bytes) {
            // Append the two-character hexadecimal representation of the byte to the StringBuilder
            result.append(String.format("%02x", b));
        }

        // Return the final hexadecimal string
        return result.toString();
    }

    //*****************CUSTOM EQUALS AND TOSTRING METHODS*****************//

    /**
     * Checks if the current user object is equal to another object.
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

        // Cast the compared object to a User
        User user = (User) o;

        // Compare the relevant fields for equality
        return Objects.equals(getName(), user.getName()) &&
                Objects.equals(getSurname(), user.getSurname()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getUserid(), user.getUserid()) &&
                Objects.equals(getFiscalCode(), user.getFiscalCode());
    }

    /**
     * Returns a string representation of the user object.
     *
     * @return A string containing the user's attributes in a formatted manner.
     */
    @Override
    public String toString() {
        return "User{\n" +
                " userid='" + userid + '\'' + ",\n" +
                " name='" + name + '\'' + ",\n" +
                " surname='" + surname + '\'' + ",\n" +
                " email='" + email + '\'' + ",\n" +
                " fiscalCode='" + fiscalCode + '\'' + "\n" +
                " centerid='" + centerid + '\'' + "\n" +
                '}';
    }

}