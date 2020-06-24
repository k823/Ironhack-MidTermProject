package com.ironhack.MidTermProject.repository.Accounts;

import com.ironhack.MidTermProject.model.entities.Accounts.CheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Long> {
}
