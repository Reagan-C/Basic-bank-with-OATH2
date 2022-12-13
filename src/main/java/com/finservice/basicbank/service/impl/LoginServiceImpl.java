package com.finservice.basicbank.service.impl;

import com.finservice.basicbank.model.domain.Customer;
import com.finservice.basicbank.repository.jpa.CustomerRepository;
import com.finservice.basicbank.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public Customer getUserDetails(Authentication authentication) {
        List<Customer> customers = customerRepository.findByEmail(authentication.getName());
        if (customers.size() > 0) {
            return customers.get(0);
        }else {
            return null;
        }
    }

}
