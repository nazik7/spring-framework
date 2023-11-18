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


    //Write a derived query to read a user with an username?

    //Write a derived query to list all users that contain a specific name?

    //Write a derived query to list all users that contain a specific name in the ignore case mode?

    //Write a derived query to list all users with an age greater than a specified age?

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
    @Query(value = "Select * from user u join account a ON u.account_details_id = a.id" +
            " where a.name is ?1", nativeQuery = true)
    List<User> retrieveAllUsersByName(String name);

    //Write a native query that returns all users?

    //Write a native query that returns all users in the range of ages?

    //Write a native query to read a user by email?

}
