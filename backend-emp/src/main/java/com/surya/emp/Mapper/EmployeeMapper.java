package com.surya.emp.Mapper;

import com.surya.emp.dto.EmployeeDto;
import com.surya.emp.entity.Employee;

public class EmployeeMapper {

    public  static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFristName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public  static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFristName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }

}
