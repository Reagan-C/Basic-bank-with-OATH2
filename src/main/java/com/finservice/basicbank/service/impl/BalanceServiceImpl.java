package com.finservice.basicbank.service.impl;

import com.finservice.basicbank.model.domain.AccountTransactions;
import com.finservice.basicbank.model.domain.Customer;
import com.finservice.basicbank.repository.jpa.AccountTransactionsRepository;
import com.finservice.basicbank.repository.jpa.CustomerRepository;
import com.finservice.basicbank.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private AccountTransactionsRepository repository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<AccountTransactions> getBalance(int id) {
        List<AccountTransactions> accountTransactions = repository.findByCustomerIdOrderByTransactionDateDesc(id);
        if (accountTransactions != null) {
            return accountTransactions;
        } else {
            return null;
        }
    }

    @Override
    public List<AccountTransactions> getAccountTransactionByEmail(String email) {
        List<Customer> customers = customerRepository.findByEmail(email);
        if (customers != null) {
            List<AccountTransactions> accountTransactions = repository.findByCustomerIdOrderByTransactionDateDesc(customers.get(0).getId());
            if (accountTransactions != null) {
                return accountTransactions;
            }
        }
        return null;
    }
}
