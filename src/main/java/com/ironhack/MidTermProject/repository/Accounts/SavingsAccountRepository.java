package com.ironhack.MidTermProject.repository.Accounts;

import com.ironhack.MidTermProject.model.entities.Accounts.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Long> {
}
