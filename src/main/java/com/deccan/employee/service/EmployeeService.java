package com.deccan.employee.service;

import com.deccan.employee.model.EmployeeDTO;
import com.deccan.employee.model.EmployeeWithAddressDTO;

public interface EmployeeService {

    EmployeeDTO saveEmployee (EmployeeDTO employeeDTO);

    EmployeeWithAddressDTO getEmployeeWithAddresses(Long employeeId);

    EmployeeDTO getEmployeeWithID(Long id);
    
} 
