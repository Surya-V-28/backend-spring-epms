package com.surya.emp.service.impl;

import com.surya.emp.Mapper.EmployeeMapper;
import com.surya.emp.dto.EmployeeDto;
import com.surya.emp.entity.Employee;
import com.surya.emp.exception.ResourceNotFoundException;
import com.surya.emp.repository.EmployeeRepository;
import com.surya.emp.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    // calling the repository to use the functions
    //Dto is a client side models to store the data we need to convert into the entity types
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmp = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmp);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
       Employee foundEmp =  employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee is not exists with the given id" + employeeId));
        return EmployeeMapper.mapToEmployeeDto(foundEmp);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
         List<Employee>   employeeLists = employeeRepository.findAll();
        return employeeLists.stream().map((employeeList)->EmployeeMapper.mapToEmployeeDto(employeeList)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedemployeeDto) {
        Employee foundEmp =  employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee is not exists with the given id" + employeeId));
        foundEmp.setEmail(updatedemployeeDto.getEmail());
        foundEmp.setFristName(updatedemployeeDto.getFristName());
        foundEmp.setLastName(updatedemployeeDto.getLastName());
         Employee updateEmp =  employeeRepository.save(foundEmp);
        return EmployeeMapper.mapToEmployeeDto(updateEmp);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee foundEmp =  employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee is not exists with the given id" + employeeId));
        employeeRepository.deleteById(employeeId);



    }
}
