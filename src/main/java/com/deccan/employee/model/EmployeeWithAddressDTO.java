package com.deccan.employee.model;

import java.util.List;

public class EmployeeWithAddressDTO {
    private Long id;
    private String name;
    private String email;
    private List<Address> addresses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public EmployeeWithAddressDTO(Long id, String name, String email, List<Address> addresses) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.addresses = addresses;
    }

    public EmployeeWithAddressDTO() {
    }
}
