package org.climatemonitoring.shared.models;

import java.io.Serial;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private String userid;
    private String name;
    private String surname;
    private String email;
    private String fiscalCode;
    private String hashedPassword;
    private int center_id;

    public User() {
        //Empty User
    }

    public User(String name, String surname, String email, String userID, String fiscalCode, String hashedPassword) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.userid = userID;
        this.fiscalCode = fiscalCode;
        this.hashedPassword = hashedPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedPasswordBytes = md.digest(password.getBytes());
            this.hashedPassword = bytesToHex(hashedPasswordBytes);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Set hashed password : NoSuchAlgorithmException");
            e.printStackTrace(); // Handle exception
        }
    }

    public int getCenter_id() {
        return center_id;
    }

    public void setCenter_id(int center_id) {
        this.center_id = center_id;
    }

    public boolean checkPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedPasswordBytes = md.digest(password.getBytes());
            String hashedPassword = bytesToHex(hashedPasswordBytes);
            return hashedPassword.equals(this.hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Check password : NoSuchAlgorithmException");
            e.printStackTrace(); // Handle exception
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName()) && Objects.equals(getSurname(), user.getSurname()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getUserid(), user.getUserid()) && Objects.equals(getFiscalCode(), user.getFiscalCode());
    }

    @Override
    public String toString() {
        return "User{\n" +
                " userid='" + userid + '\'' + ",\n" +
                " name='" + name + '\'' + ",\n" +
                " surname='" + surname + '\'' + ",\n" +
                " email='" + email + '\'' + ",\n" +
                " fiscalCode='" + fiscalCode + '\'' + "\n" +
                " centerid='" + center_id + '\'' + "\n" +
                '}';
    }

    //PRIVATE METHODS

    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }

}