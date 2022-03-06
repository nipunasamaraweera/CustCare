package com.example.custcare;

public class AddL {

    String Latitude,Longitude,Country,Locality,Address,AccouuntNo;

    public AddL() {
    }

    public AddL(String latitude, String longitude, String country, String locality, String address, String accouuntNo) {
        Latitude = latitude;
        Longitude = longitude;
        Country = country;
        Locality = locality;
        Address = address;
        AccouuntNo = accouuntNo;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getLocality() {
        return Locality;
    }

    public void setLocality(String locality) {
        Locality = locality;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAccouuntNo() {
        return AccouuntNo;
    }

    public void setAccouuntNo(String accouuntNo) {
        AccouuntNo = accouuntNo;
    }
}
