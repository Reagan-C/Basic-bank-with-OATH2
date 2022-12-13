package com.finservice.basicbank.repository.jpa;

import com.finservice.basicbank.model.domain.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Integer> {

    Accounts findByCustomerId(int customerId);
}
