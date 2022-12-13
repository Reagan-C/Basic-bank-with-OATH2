package com.finservice.basicbank.controller;

import com.finservice.basicbank.model.domain.Accounts;
import com.finservice.basicbank.repository.jpa.CustomerRepository;
import com.finservice.basicbank.service.AccountService;
import com.finservice.basicbank.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private LoginService loginService;

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam String email) {
        return accountService.getAccountByEmail(email);
    }
}
