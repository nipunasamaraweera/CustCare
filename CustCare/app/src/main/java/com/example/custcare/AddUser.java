package com.example.custcare;

public class AddUser {

    String name, phonenumber, email, MID, password, area;

    public AddUser(){}

    public AddUser(String name, String phonenumber, String email, String MID, String password, String area) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.email = email;
        this.MID = MID;
        this.password = password;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMID() {
        return MID;
    }

    public void setMID(String MID) {
        this.MID = MID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
