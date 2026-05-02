package com.deccan.employee.entity;


import java.util.ArrayList;
import java.util.List;

import com.deccan.employee.model.Address;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Address addresses;
    public Employee(Long id, String name, String email, Address addresses) {
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
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Employee(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public Employee() {
    }

    
}
