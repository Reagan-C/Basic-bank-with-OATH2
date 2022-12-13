package com.finservice.basicbank.service.impl;

import com.finservice.basicbank.model.domain.Accounts;
import com.finservice.basicbank.model.domain.Customer;
import com.finservice.basicbank.repository.jpa.AccountsRepository;
import com.finservice.basicbank.repository.jpa.CustomerRepository;
import com.finservice.basicbank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountsRepository repository;

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Accounts getAccount(int id) {
        return repository.findByCustomerId(id);
    }
    @Override
    public Accounts getAccountByEmail(String email) {
        List<Customer> customers = customerRepository.findByEmail(email);
        if (customers != null) {
            Accounts account = repository.findByCustomerId(customers.get(0).getId());
            if (account != null) {
                return account;
            }
        }
        return null;
    }
}
