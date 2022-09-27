package com.ideas2it.employeeProject.mapper;

import com.ideas2it.employeeProject.dto.EmployeeDto;
import com.ideas2it.employeeProject.model.Employee;
import com.ideas2it.employeeProject.utils.Constants;
import org.springframework.stereotype.Component;

/**
 * The {@code EmployeeMapper} has methods to convert Employee dto to Employee model and vice versa.
 *
 * @author Gunaseelan K
 * since 1.0
 * jls Advanced logics+
 */

@Component
public class EmployeeMapper {

    /**
     * <p>
     * This method is used to convert Employee dto to Employee model
     * </p>
     */
    public Employee fromDto(EmployeeDto employeeDto) {
        return new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(),
                employeeDto.getDateOfBirth(), employeeDto.getGender(), employeeDto.getDateOfJoining(),
                employeeDto.getBatch(), employeeDto.getDesignation(), employeeDto.getCity(), employeeDto.getFatherName(),
                employeeDto.getEmail(), employeeDto.getPhoneNumber(), employeeDto.getCreatedAt(),
                employeeDto.getUpdatedAt(), Constants.ACTIVE);
    }

    /**
     * <p>
     * This method is used to convert Employee model to Employee dto
     * </p>
     */
    public EmployeeDto toDto(Employee employee) {
        return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getDateOfBirth(),
                employee.getGender(), employee.getDateOfJoining(), employee.getBatch(), employee.getDesignation(),
                employee.getCity(), employee.getFatherName(), employee.getEmail(), employee.getPhoneNumber(),
                employee.getCreatedAt(), employee.getUpdatedAt(), employee.getStatus());
    }
}
