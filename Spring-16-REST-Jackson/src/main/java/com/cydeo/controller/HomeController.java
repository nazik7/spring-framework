package com.cydeo.controller;

import com.cydeo.entity.Account;
import com.cydeo.entity.User;
import com.cydeo.repository.AccountRepository;
import com.cydeo.repository.UserRepository;

import java.util.List;

public class HomeController {
    private UserRepository userRepository;
    private AccountRepository accountRepository;

    public HomeController(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    @GetMapping("/users")
    public List<User> readAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/accounts")
    public List<Account> readAllAccounts(){
        return accountRepository.findAll();
    }
}
