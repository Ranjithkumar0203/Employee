package com.deccan.employee.serviceImpl;

import com.deccan.employee.dao.EmployeRepo;
import com.deccan.employee.entity.Employee;
import com.deccan.employee.model.EmployeeDTO;
import com.deccan.employee.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private final EmployeRepo employeRepo;
    private final ModelMapper modelMapper;

    public EmployeeServiceImp(EmployeRepo employeRepo, ModelMapper modelMapper) {
        this.employeRepo = employeRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employeeEntity =
                modelMapper.map(employeeDTO, Employee.class);
        if (employeeEntity.getId() != null && employeeEntity.getId() == 0) {
            employeeEntity.setId(null);
        }
        Employee savedEmployee = employeRepo.save(employeeEntity);
        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }
    
}
