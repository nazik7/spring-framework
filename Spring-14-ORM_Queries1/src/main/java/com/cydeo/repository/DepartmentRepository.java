package com.cydeo.repository;

import com.cydeo.entity.Department;
import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    //display all departments in the furniture department
    List<Department> findByDepartment(String department);

    //display all departments in the Health Division
    List<Department> findByDivisionEquals(String division);

    List<Department> findByDivisionIs(String division);

    List<Department> findDistinctTop3ByDivisionContains(String pattern);
    @Query("select d from Department d where d.division IN ?1")
    List<Department> getDepartmentDivision(List<String> division);

    List<Department> retrieveDepartmentByDivision(String division); //method defined in META-INF file in 'resources' folder
    @Query(nativeQuery = true)
    List<Department> retrieveDepartmentByDivisionContain(String pattern);


}
