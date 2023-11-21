package org.climatemonitoring.shared.models;

import java.io.Serial;
import java.io.Serializable;

public class MonitoringCenter implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private int centerid;
    private String name;
    private String address;
    private int addressNumber;
    private int cap;
    private String city;
    private String province;

    public MonitoringCenter() {
        //Empty
    }

    public MonitoringCenter(int centerid, String name, String address, int addressNumber, int cap, String city, String province) {
        this.centerid = centerid;
        this.name = name;
        this.address = address;
        this.addressNumber = addressNumber;
        this.cap = cap;
        this.city = city;
        this.province = province;
    }

    public long getCenterid() {
        return centerid;
    }

    public void setCenterid(int centerid) {
        this.centerid = centerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(int addressNumber) {
        this.addressNumber = addressNumber;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonitoringCenter that = (MonitoringCenter) o;
        return getCenterid() == that.getCenterid();
    }

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
