package com.cydeo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "courses")
public class Course extends BaseEntity{
    private String name;
    private String category;
    private Integer rating;
    private String description;

}
