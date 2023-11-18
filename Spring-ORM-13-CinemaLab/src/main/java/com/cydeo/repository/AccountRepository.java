package com.cydeo.repository;

import com.cydeo.entity.Account;
import com.cydeo.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
    List<Account> findAllByCountryOrState(String country, String state);

    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> findAccountByAgeLessThanEqual(int age);

    //Write a derived query to list all accounts with a specific role
    List<Account> findAccountByRole(UserRole role);
    //findAllByRole(UserRole role);

    //Write a derived query to list all accounts between a range of ages
    List<Account> findAccountByAgeBetween(int age1, int age2);
    //List<Account> findAllByAgeBetween(int age1, int age2);

    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account> findAccountByAddressStartingWith(String pattern);
    //List<Account> findAllByAddressStartingWith(String pattern);

    //Write a derived query to sort the list of accounts with age
    List<Account> findAccountByOrderByAge();

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("select a from Account a")
    List<Account> getAllAccounts();

    //Write a JPQL query to list all admin accounts
    @Query("select a from Account a where a.role = 'ADMIN'")
    List<Account> getAdminAccounts();

    //Write a JPQL query to sort all accounts with age
    @Query("select a from Account a order by a.age")
    List<Account> sortAccountsByAge();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value

    @Query(value = "select * from account_details where age < :age", nativeQuery = true)
    List<Account> getAccountsOfAgeOrLower(Integer age); //don't always need to define parameter if the parameter name

    //Write a native query to read all accounts that a specific value
    // can be containable in the name, address, country, state city

    @Query(value = "select * from account where name like %pattern% or address like %pattern%  or country like %pattern% " +
            " or state like %pattern% or city like %pattern% ",nativeQuery = true)
    List<Account> findAccountBySearchCriteria(String pattern);

    @Query(value = "select * from account where " +
            "name ILIKE concat('%',?1,'%') or " +
            "address ILIKE concat('%',?1,'%') or " +
            "country ILIKE concat('%',?1,'%') or " +
            "state ILIKE concat('%',?1,'%') or " +
            "city ILIKE concat('%',?1,'%')",nativeQuery = true)
    List<Account> findAccountBySearchCriteriaSecondWay(String pattern);

    //Write a native query to read all accounts with an age lower than a specific value

    @Query(value = "select * from account where age > :age",nativeQuery = true)
    List<Account> findAccountsWithAge(@Param("age") int age);

}
