package com.finservice.basicbank.service.impl;

import com.finservice.basicbank.model.domain.Cards;
import com.finservice.basicbank.model.domain.Customer;
import com.finservice.basicbank.repository.jpa.CardsRepository;
import com.finservice.basicbank.repository.jpa.CustomerRepository;
import com.finservice.basicbank.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardsRepository repository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Cards> getCardDetails(int id) {
        List<Cards> cards = repository.findByCustomerId(id);
        if (cards != null) {
            return cards;
        } else {
            return null;
        }
    }

    @Override
    public List<Cards> getCardDetailsByEmail(String email) {
        List<Customer> customer = customerRepository.findByEmail(email);
        if (customer != null) {
           List<Cards> cards =  repository.findByCustomerId(customer.get(0).getId());
            if (cards != null) {
                return cards;
            }
        }
        return null;
    }
}
