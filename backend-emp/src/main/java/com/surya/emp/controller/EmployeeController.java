package com.surya.emp.controller;


import com.surya.emp.dto.EmployeeDto;
import com.surya.emp.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public  ResponseEntity<EmployeeDto> createEmployee(@RequestBody  EmployeeDto employeeDto){
        EmployeeDto savedEmp = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
     public ResponseEntity<EmployeeDto> findEmployeeById(@PathVariable("id")  Long employeeId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return  ResponseEntity.ok(employeeDto);
    }


    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
         List<EmployeeDto> gotAllEmp = employeeService.getAllEmployees();
         return ResponseEntity.ok(gotAllEmp);
    }

    @PutMapping("{id}")
    public   ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeid,@RequestBody EmployeeDto updatedEmployeeDto){
       EmployeeDto updatedEmp =  employeeService.updateEmployee(employeeid, updatedEmployeeDto);
        return ResponseEntity.ok(updatedEmp);
    }


    @DeleteMapping("{id}")
    public  ResponseEntity delete(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee Deteled Succesfully");

    }








}




