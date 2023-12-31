package com.cydeo.repository;

import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?
    Optional<User> findByEmail(String email);


    //Write a derived query to read a user with an username?
    Optional<User> getUserByUsername(String username);

    //Write a derived query to list all users that contain a specific name?
    List<User> findAllByAccountContains(String name);

    //Write a derived query to list all users that contain a specific name in the ignore case mode?
    List<User> findAllByAccountNameContainingIgnoreCase(String name);

    //Write a derived query to list all users with an age greater than a specified age?
    List<User> findAllByAccount_AgeGreaterThan(int age);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?
    @Query("select u from User u where u.email = 'email' ")
    Optional<User> retrieveByEmail(String email);

    //Write a JPQL query that returns a user read by username?
    @Query("select u from User u where u.username = 'userName' ")
    Optional<User> retrieveByUserName(String userName);

    //Write a JPQL query that returns all users?
    @Query("select u from User u")
    List<User> retrieveAllUsers();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?
    @Query(value = "Select * from user_account u join account_details a ON u.account_details_id = a.id" +
            " where a.name ILIKE concat('%',?1,'%')", nativeQuery = true)
    List<User> retrieveAllUsersByName(String name);

    //Write a native query that returns all users?
    @Query(value = "select * from user_account",nativeQuery = true)
    List<User> retrieveAllUsersF();

    //Write a native query that returns all users in the range of ages?
    @Query(value = "select * from user_account u join account_details a on " +
            " u.account_details_id = a.id where age in(?1,?2)",nativeQuery = true)
    List<User> retrieveUsersInAgeRange(int age1, int age2);

    //Write a native query to read a user by email?
    @Query(value = "SELECT  * from user_account where email = ?1",nativeQuery = true)
    Optional<User> fetchByEmail(String email);

}
