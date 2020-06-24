package com.ironhack.MidTermProject.repository.Accounts;

import com.ironhack.MidTermProject.model.entities.Accounts.CreditCardAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardAccountRepository extends JpaRepository<CreditCardAccount, Long> {
}
