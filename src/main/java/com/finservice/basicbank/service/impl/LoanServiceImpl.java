package com.finservice.basicbank.service.impl;

import com.finservice.basicbank.model.domain.Customer;
import com.finservice.basicbank.model.domain.Loans;
import com.finservice.basicbank.repository.jpa.CustomerRepository;
import com.finservice.basicbank.repository.jpa.LoanRepository;
import com.finservice.basicbank.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository repository;

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Loans> getLoanDetails(String email) {
        List<Customer> customer = customerRepository.findByEmail(email);
        if (customer != null) {
            List<Loans> loans = repository.findByCustomerIdOrderByStartDateDesc(customer.get(0).getId());

            if (loans != null) {
                return loans;
            }
        }
        return null;
    }
}
