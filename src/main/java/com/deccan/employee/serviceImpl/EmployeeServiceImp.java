package com.deccan.employee.serviceImpl;

import com.deccan.employee.client.AddressClient;
import com.deccan.employee.dao.EmployeRepo;
import com.deccan.employee.entity.Employee;
import com.deccan.employee.exception.AddressServiceException;
import com.deccan.employee.exception.EmployeeNotFoundException;
import com.deccan.employee.exception.EmployeeSaveException;
import com.deccan.employee.model.Address;
import com.deccan.employee.model.EmployeeDTO;
import com.deccan.employee.model.EmployeeWithAddressDTO;
import com.deccan.employee.service.EmployeeService;
import feign.FeignException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private final EmployeRepo employeRepo;
    private final ModelMapper modelMapper;
    private final AddressClient addressClient;

    public EmployeeServiceImp(EmployeRepo employeRepo, ModelMapper modelMapper, AddressClient addressClient) {
        this.employeRepo = employeRepo;
        this.modelMapper = modelMapper;
        this.addressClient = addressClient;
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employeeEntity =
                modelMapper.map(employeeDTO, Employee.class);
        if (employeeEntity.getId() != null && employeeEntity.getId() == 0) {
            employeeEntity.setId(null);
        }
        Employee savedEmployee;
        try {
            savedEmployee = employeRepo.save(employeeEntity);
        } catch (Exception ex) {
            throw new EmployeeSaveException("Unable to save employee", ex);
        }
        EmployeeDTO savedEmployeeDTO = modelMapper.map(savedEmployee, EmployeeDTO.class);
        Address address = employeeDTO.getAddresses();
        if (address != null) {
            address.setEmployeeID(String.valueOf(savedEmployee.getId()));
            try {
                savedEmployeeDTO.setAddresses(addressClient.saveAddress(address));
            } catch (FeignException ex) {
                throw new AddressServiceException("Unable to save address because address service is not available", ex);
            }
        }
        return savedEmployeeDTO;
    }

    @Override
    public EmployeeWithAddressDTO getEmployeeWithAddresses(Long employeeId) {
        Employee employee = employeRepo.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + employeeId));

        EmployeeWithAddressDTO employeeWithAddressDTO = modelMapper.map(employee, EmployeeWithAddressDTO.class);
        try {
            employeeWithAddressDTO.setAddresses(addressClient.getAddressesByEmployeeID(String.valueOf(employeeId)));
        } catch (FeignException ex) {
            throw new AddressServiceException("Unable to fetch addresses because address service is not available", ex);
        }
        return employeeWithAddressDTO;
    }

    @Override
    public EmployeeDTO getEmployeeWithID(Long id) {

       Employee employee =  employeRepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
       EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
       return employeeDTO;
       
    }
    
}
