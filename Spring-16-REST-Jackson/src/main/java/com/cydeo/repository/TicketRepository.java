package com.cydeo.repository;

import com.cydeo.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //
//
//    //Write a derived query to count how many tickets a user bought
//    Integer countAllByUserAccountId(Long userId);
//
//    //Write a derived query to list all tickets by specific email
//    List<Ticket> findAllByUserAccount_Email(String email);
//
//    //Write a derived query to count how many tickets are sold for a specific movie
//    Integer countAllByMovieCinema_Movie_Name(String movieName);
//
//
//    //Write a derived query to list all tickets between a range of dates
//    List<Ticket> findAllByDateTimeBetween(LocalDate date1, LocalDate date2);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
    @Query("select t from Ticket t where t.userAccount.id = ?1")
    List<Ticket> fetchAllTicketsFromUserAccount(Long userId);

    //Write a JPQL query that returns all tickets between a range of dates
    @Query("select t from Ticket t where t.dateTime between ?1 and ?2")
    List<Ticket> fetchAllTicketsBetweenDates(LocalDateTime dateTime1, LocalDateTime dateTime2);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought
    @Query(value = "select count(*) from ticket where user_account_id = ?1",nativeQuery = true)
    Integer countAllTicketsOfUser(Long userId);

    //Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value = "select * from ticket where user_account_id=?1 AND date_time between ?2 and ?3", nativeQuery = true)
    Integer countTicketsByUserInDateRange(Long userId, LocalDateTime dateTime1, LocalDateTime dateTime2);

    //Write a native query to distinct all tickets by movie name
    @Query(value = "SELECT  distinct m.name from ticket t join movie_cinema mc On t.movie_cinema_id = mc.id" +
            " join movie m on mc.movie_id = m.id", nativeQuery = true)
    List<String> retrieveAllDistinctMovieNames();

    //Write a native query to find all tickets by user email
    //@Query(value = "", nativeQuery = true)
    //List<Ticket> findAllByUserEmail(String email);

    //Write a native query that returns all tickets

    //Write a native query to list all tickets where a specific value should be containable in the username or name or movie name
    @Query(value = "select * from ticket t join user_account u ON t.user_account_id = u.id" +
            " join account_details ad on u.account_details_id = ad.id" +
            " join movie_cinema mc ON t.movie_cinema_id = mc.id join " +
            " movie m On mc.movie_id = m.id " +
            "WHERE u.username ilike concat('%',?1,'%') OR ad.name ILIKE concat('%',?1,'%')" +
            "OR m.name ILIKE concat('%',?1,'%')", nativeQuery = true)
    List<Ticket> retrieveAllBySearchCriteria(String keyword);
}
