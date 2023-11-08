package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //display all employees with email address
    List<Employee> findByEmail(String email);

    //display all employees with firstName and Last name and with email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

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

    //display all employees where salary is greater than or equal to sth in order
    List<Employee> findBySalaryIsGreaterThanEqualOrderBySalaryDesc(Long salary);

    //display top unique 3 employees that make less than sth
    List<Employee> findDistinctTop3BySalaryLessThan(Long salary);

    //display all employees that do not have email address
    List<Employee> findByEmailIsNull();
    @Query("SELECT e from Employee e WHERE e.email = 'sdubber7@t-online.de'")
    Employee getEmployeeDetail();
    @Query("SELECT e.salary from Employee  e where e.email='bmanueau0@dion.ne.jp'")
    Long getEmployeeSalary();
    @Query("select e from Employee e where e.email = ?1")
    Optional<Employee> getEmployeeDetail(String email);

    @Query("select e from Employee e where e.email=?1 and e.salary = ?2")
    Optional<Employee> getEmployeeDetail(String email, Long salary);


}
