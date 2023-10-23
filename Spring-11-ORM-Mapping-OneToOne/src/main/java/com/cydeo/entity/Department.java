package com.cydeo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="departments")
@Data
@NoArgsConstructor
public class Department extends BaseEntity{
    private String department;
    private String division;
    @OneToOne(mappedBy = "department")//has to match with the name in Employee class,
    // do not create "employee" foreign key in departments table
    private Employee employee;

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
