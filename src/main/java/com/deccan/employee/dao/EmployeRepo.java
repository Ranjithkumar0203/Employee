package com.deccan.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deccan.employee.entity.Employee;

@Repository
public interface EmployeRepo extends JpaRepository<Employee,Long>{

    
} 
