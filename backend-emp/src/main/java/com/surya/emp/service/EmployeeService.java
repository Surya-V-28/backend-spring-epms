package com.surya.emp.service;

import com.surya.emp.dto.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedemployeeDto);

    void deleteEmployee(Long employeeId);
}
