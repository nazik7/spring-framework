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
    List<Account> findAccountByCountryOrState(String country, String state);

    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> findAccountByAgeLessThanEqual(int age);

    //Write a derived query to list all accounts with a specific role
    List<Account> findAccountByRole(UserRole role);

    //Write a derived query to list all accounts between a range of ages
    List<Account> findAccountByAgeBetween(int age1, int age2);

    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account> findAccountByAddressStartingWith(String pattern);

    //Write a derived query to sort the list of accounts with age
    List<Account> findAccountByAgeOrderByAge(int age);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("select a from Account a")
    List<Account> returnAccounts();

    //Write a JPQL query to list all admin accounts
    @Query("select a from Account a where a.role = 'ADMIN'")
    List<Account> getAdminAccounts();

    //Write a JPQL query to sort all accounts with age
    @Query("select a from Account a order by a.age")
    List<Account> sortAccountsByAge();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value
    @Transactional
    @Modifying
    @Query(value = "select * from account_details where age = :age", nativeQuery = true)
    List<Account> getAccountsOfAgeOrLower(@Param(("age")) int age);

    //Write a native query to read all accounts that a specific value
    // can be containable in the name, address, country, state city
    @Transactional
    @Modifying
    @Query(value = "select * from account ",nativeQuery = true)
    List<Account> findAccounts(String name,String address, String country,String state, String city);

    //Write a native query to read all accounts with an age lower than a specific value
    @Transactional
    @Modifying
    @Query(value = "select * from account where age > :age",nativeQuery = true)
    List<Account> findAccountsWithAge(@Param("age") int age);

}
