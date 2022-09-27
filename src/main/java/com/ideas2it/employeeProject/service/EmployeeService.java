package com.ideas2it.employeeProject.service;

import com.ideas2it.employeeProject.dto.EmployeeDto;
import com.ideas2it.employeeProject.exception.CustomException;
import com.ideas2it.employeeProject.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> getEmployees();

    EmployeeDto getEmployeeById(int id) throws CustomException;

    Employee addEmployee(EmployeeDto employeeDto);

    Employee updateEmployee(int id, EmployeeDto employeeDto) throws CustomException;

    ResponseEntity<HttpStatus> deleteEmployeeById(int id) throws CustomException;
}
