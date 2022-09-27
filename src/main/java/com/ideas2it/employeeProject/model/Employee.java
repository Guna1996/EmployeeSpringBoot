/*
 * Copyright (c) 2022, ideas2it and/or its affiliates. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 */
package com.ideas2it.employeeProject.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * The {@code Employee} has data members and its getter setters, where annotations is used to create table using hibernate.
 *
 * @author Gunaseelan K
 * since 1.0
 * jls Advanced logics+
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "gender")
    private String gender;

    @Column(name = "date_of_joining")
    private LocalDate dateOfJoining;

    @Column(name = "batch")
    private int batch;

    @Column(name = "designation")
    private String designation;

    @Column(name = "city")
    private String city;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @CreationTimestamp
    @Column(name = "created_date")
    private LocalDate createdAt;

    @UpdateTimestamp
    @Column(name = "updated_date")
    private LocalDate updatedAt;

    @Column(name = "status", columnDefinition = "varchar(30) default 'active'")
    private String status;
}