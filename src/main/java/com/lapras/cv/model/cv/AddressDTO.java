package com.lapras.cv.model.cv;


public class AddressDTO {

    private String name;
    private String currentCity;
    private String mobile;
    private String email;

    public AddressDTO() {
    }

    public AddressDTO(String name, String currentCity, String mobile, String email) {
        this.name = name;
        this.currentCity = currentCity;
        this.mobile = mobile;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
