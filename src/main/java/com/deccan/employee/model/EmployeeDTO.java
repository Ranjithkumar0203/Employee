package com.deccan.employee.model;



public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private Address addresses;
    public Long getId() {
        return id;
    }
    public EmployeeDTO(Long id, String name, String email, Address addresses) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.addresses = addresses;
    }
    public Address getAddresses() {
        return addresses;
    }
    public void setAddresses(Address addresses) {
        this.addresses = addresses;
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
    public EmployeeDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public EmployeeDTO() {
    }
}
