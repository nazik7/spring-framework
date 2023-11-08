package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    //display all departments in the furniture department
    List<Department> findByDepartment(String department);

    //display all departments in the Health Division
    List<Department> findByDivisionEquals(String division);

    List<Department> findByDivisionIs(String division);

    List<Department> findDistinctTop3ByDivisionContains(String pattern);


}
