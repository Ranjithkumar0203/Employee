package com.deccan.employee.controller;

import com.deccan.employee.model.EmployeeDTO;
import com.deccan.employee.model.EmployeeWithAddressDTO;
import com.deccan.employee.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String hello(){
        return "Hello from Hell";
    }

    @PostMapping("/save")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.saveEmployee(employeeDTO);
    }

    @PutMapping("/update")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.saveEmployee(employeeDTO);
    }

    @GetMapping("/{id}/with-addresses")
    public EmployeeWithAddressDTO getEmployeeWithAddresses(@PathVariable Long id) {
        return employeeService.getEmployeeWithAddresses(id);
    }

     @GetMapping("/{id}")
    public EmployeeDTO getEmployeeWithID(@PathVariable Long id) {
        return employeeService.getEmployeeWithID(id);
    }
    
}
