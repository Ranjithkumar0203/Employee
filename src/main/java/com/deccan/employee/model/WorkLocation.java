package com.deccan.employee.model;

public class WorkLocation {

    private Long id;
    private String locationName;
    private String city;
    private String state;
    private String country;
    private String pincode;
    private String employeeId;

    public WorkLocation() {
    }

    // public WorkLocation(Long id, String locationName, String city, String state,
    // String country, String pincode, String employeeId) {
    // this.id = id;
    // this.locationName = locationName;
    // this.city = city;
    // this.state = state;
    // this.country = country;
    // this.pincode = pincode;
    // this.employeeId = employeeId;
    // }

    public WorkLocation(Long id, String locationName, String city, String state,
            String country, String pincode, String employeeId) {
        this.id = id;
        this.locationName = locationName;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
        this.employeeId = employeeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
