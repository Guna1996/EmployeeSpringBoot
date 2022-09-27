package com.ideas2it.employeeProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.time.LocalDate;
/**
 * The {@code Employee} has data members and its getter setters, where annotations is used to create table using hibernate.
 *
 * @author  Gunaseelan K
 * since 1.0
 * jls Advanced logics+
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private int id;

    @NotNull(message = "first name shouldn't be null")
    private String firstName;

    private String lastName;

    @Past(message = "Date input is invalid for a birth date.")
    private LocalDate dateOfBirth;

    @Pattern(regexp = "^Male|Female|male|female$", message = "invalid gender choice! choose again")
    private String gender;

    private LocalDate dateOfJoining;

    @Min(value = 0, message = "batch cannot be negative")
    @Max(value = 10, message = "choose batch number below 10")
    private int batch;

    private String designation;

    @NotNull(message = "city shouldn't be null")
    private String city;

    private String fatherName;

    @NotNull(message = "email shouldn't be null")
    @Email(message = "invalid email")
    private String email;

    @Pattern(regexp = "^(0/91)?[7-9][0-9]{9}$", message = "type only 10 numbers")
    @NotNull(message = "phone number shouldn't be null")
    private String phoneNumber;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private String status;
}