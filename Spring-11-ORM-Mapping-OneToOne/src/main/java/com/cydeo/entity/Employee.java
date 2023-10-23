package com.cydeo.entity;

import com.cydeo.enums.Gender;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    @Column (columnDefinition = "DATE")
    private Date hireDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private int salary;


}
