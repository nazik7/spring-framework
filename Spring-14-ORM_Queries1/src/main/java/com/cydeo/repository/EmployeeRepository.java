package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    //not equal
    @Query("select e from Employee e where e.salary <> ?1")
    List<Employee> getEmployeeSalaryNotEqual(Long salary);

    //like/contains/startsWith
    @Query("select e from Employee e where e.firstName Like ?1")
    List<Employee> getEmployeeFirstNameLike(String pattern);

    //less than
    @Query("select e from Employee  e where e.salary < ?1")
    List<Employee> getEmployeeSalaryLessThan(Long salary);

    //before
    @Query("select e from Employee e where e.hireDate > ?1")
    List<Employee> getEmployeeHireDateBefore(LocalDate date);

    //between
    @Query("select e from Employee e where e.salary between ?1 and ?2")
    List<Employee> getEmployeeSalaryBetween(Long salary1, Long salary2);

    //null
    @Query("select e from Employee  e where e.email is Null")
    List<Employee> getEmployeeEmailIsNull();

    //not null
    @Query("select e from Employee  e where e.email is Not Null")
    List<Employee> getEmployeeEmailIsNotNull();

    //sorting in ascending order
    @Query("select e from Employee e ORDER BY e.salary")
    List<Employee> getEmployeeSalaryOrderAsc();

    //sorting in descending order
    @Query("select e from Employee e ORDER BY e.salary DESC")
    List<Employee> getEmployeeSalaryOrderDesc();
    @Query(value = "select  * from employees where salary ?1", nativeQuery = true)
    List<Employee> readEmployeeDetailBySalary(Long salary);
    @Query("select e from Employee e where e.salary = :salary")
    List<Employee> getEmployeeSalary(@Param("salary") Long salary);





}
