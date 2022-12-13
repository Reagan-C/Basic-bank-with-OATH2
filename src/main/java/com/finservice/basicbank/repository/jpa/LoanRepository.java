package com.finservice.basicbank.repository.jpa;

import com.finservice.basicbank.model.domain.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loans, Integer> {

    List<Loans> findByCustomerIdOrderByStartDateDesc(int customerId);
}
