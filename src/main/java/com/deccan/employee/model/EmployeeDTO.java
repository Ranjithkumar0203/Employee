package com.deccan.employee.model;



public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private Address addresses;
    private WorkLocation workLocation;
    public EmployeeDTO(Long id, String name, String email, Address addresses, WorkLocation workLocation) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.addresses = addresses;
        this.workLocation = workLocation;
    }
    public Long getId() {
        return id;
    }
   
    public WorkLocation getWorkLocation() {
        return workLocation;
    }
    public void setWorkLocation(WorkLocation workLocation) {
        this.workLocation = workLocation;
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
