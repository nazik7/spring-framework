package com.cydeo.bootstrap;

import com.cydeo.entity.Account;
import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class DataGenerator implements CommandLineRunner {


    private final AccountRepository accountRepository;
    private final CinemaRepository cinemaRepository;
    private final MovieRepository movieRepository;
    private final MovieCinemaRepository movieCinemaRepository;
    private final TicketRepository ticketRepository;
    private final GenreRepository genreRepository;
    private final UserRepository userRepository;

    public DataGenerator(AccountRepository accountRepository, CinemaRepository cinemaRepository, MovieRepository movieRepository, MovieCinemaRepository movieCinemaRepository, TicketRepository ticketRepository, GenreRepository genreRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.cinemaRepository = cinemaRepository;
        this.movieRepository = movieRepository;
        this.movieCinemaRepository = movieCinemaRepository;
        this.ticketRepository = ticketRepository;
        this.genreRepository = genreRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(cinemaRepository.findByName("Hall 1 - EMPIRE"));
        System.out.println(accountRepository.getAdminAccounts());
        System.out.println(cinemaRepository.distinctBySponsoredName());
        System.out.println(movieRepository.fetchAllMovieNames());
        System.out.println(movieCinemaRepository.countAllByCinemaId(4L));
        System.out.println(movieCinemaRepository.getAllMovieCinemasBy("AMC Empire 25"));
        System.out.println(ticketRepository.fetchAllTicketsFromUserAccount(4L)); //fetchAllTicketsByUserAccount(4L)
        System.out.println(ticketRepository.fetchAllTicketsBetweenDates(LocalDateTime.now().minusDays(1000), LocalDateTime.now()));
                //fetchAllTicketsBetweenRangeOfDateTimes(LocalDateTime.now().minusDays(1000), LocalDateTime.now()));
        System.out.println(ticketRepository.retrieveAllBySearchCriteria("it"));
        System.out.println(genreRepository.findAll());
        System.out.println(userRepository.retrieveAllUsers());

    }
}
