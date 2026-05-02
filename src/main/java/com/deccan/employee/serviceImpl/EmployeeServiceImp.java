package com.deccan.employee.serviceImpl;

import com.deccan.employee.client.AddressClient;
import com.deccan.employee.dao.EmployeRepo;
import com.deccan.employee.entity.Employee;
import com.deccan.employee.model.Address;
import com.deccan.employee.model.EmployeeDTO;
import com.deccan.employee.model.EmployeeWithAddressDTO;
import com.deccan.employee.service.EmployeeService;
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
        Employee savedEmployee = employeRepo.save(employeeEntity);
        EmployeeDTO savedEmployeeDTO = modelMapper.map(savedEmployee, EmployeeDTO.class);
        Address address = employeeDTO.getAddresses();
        if (address != null) {
            address.setEmployeeID(String.valueOf(savedEmployee.getId()));
            savedEmployeeDTO.setAddresses(addressClient.saveAddress(address));
        }
        return savedEmployeeDTO;
    }

    @Override
    public EmployeeWithAddressDTO getEmployeeWithAddresses(Long employeeId) {
        Employee employee = employeRepo.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));

        EmployeeWithAddressDTO employeeWithAddressDTO = modelMapper.map(employee, EmployeeWithAddressDTO.class);
        employeeWithAddressDTO.setAddresses(addressClient.getAddressesByEmployeeID(String.valueOf(employeeId)));
        return employeeWithAddressDTO;
    }
    
}
