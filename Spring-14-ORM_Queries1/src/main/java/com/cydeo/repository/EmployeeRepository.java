package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.LongStream;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //display all employees with email address
    List<Employee> findByEmail(String email);

    //display all employees with firstName and Last name and with email address
    List<Employee> findByFirstNameAndByLastNameOrEmail(String firstName, String lastName, String email);

    //display all employees whose firstName is not sth
    List<Employee> findByFirstNameIsNot(String firstName);

    //display all employees where last name starts with sth
    List<Employee> findByLastNameStartsWith(String pattern);

    //display all employees with salaries higher than
    List<Employee> findBySalaryGreaterThan(Long salary);

    //display all employees with salaries less than
    List<Employee> findBySalaryLessThanEqual(Long salary);

    //display all employees that have been hired between the dates
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //display all employees where salary is greter than or equal to sth in order
    List<Employee> findBySalaryIsGreaterThanEqualOrderBySalaryDesc(Long salary);

    //display top unique 3 employees that make less than sth
    List<Employee> findDistinctTop3BySalaryLessThan(Long salary);

    //display all employees that do not have email address
    List<Employee> findByEmailIsNull();


}
