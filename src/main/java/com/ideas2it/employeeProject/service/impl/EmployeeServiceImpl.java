package com.ideas2it.employeeProject.service.impl;

import com.ideas2it.employeeProject.dto.EmployeeDto;
import com.ideas2it.employeeProject.exception.CustomException;
import com.ideas2it.employeeProject.mapper.EmployeeMapper;
import com.ideas2it.employeeProject.model.Employee;
import com.ideas2it.employeeProject.repo.EmployeeRepository;
import com.ideas2it.employeeProject.service.EmployeeService;
import com.ideas2it.employeeProject.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("userDetailsService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee addEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeMapper.fromDto(employeeDto);
        return employeeRepository.save(employee);
    }


    @Override
    public Employee updateEmployee(int id, EmployeeDto employeeDto) throws CustomException {
        if (getEmployeeById(id) != null) {
            Employee employee = employeeMapper.fromDto(employeeDto);
            return employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public ResponseEntity<HttpStatus> deleteEmployeeById(int id) throws CustomException {
        Optional<Employee> employee = employeeRepository.findByIdAndStatus(id, "active");
        if (employee.isPresent()) {
            Employee empObj = employee.get();
            empObj.setStatus(Constants.INACTIVE);
            employeeRepository.save(empObj);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
                throw new CustomException("user not found with id : "+id);
            }
    }

    @Override
    public EmployeeDto getEmployeeById(int id) throws CustomException {
        Optional<Employee> employee = employeeRepository.findByIdAndStatus(id, Constants.ACTIVE);
        if (employee.isPresent()) {
            return employeeMapper.toDto(employee.get());
        } else {
            throw new CustomException("user not found with id : "+id);
        }
    }

    @Override
    public List<EmployeeDto> getEmployees() {
        List<Employee> employees = employeeRepository.findByStatus(Constants.ACTIVE);
        return employees
                .stream()
                .map(employee -> employeeMapper.toDto(employee))
                .collect(Collectors.toList());
    }
}
