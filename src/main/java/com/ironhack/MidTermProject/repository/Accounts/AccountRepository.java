package com.ironhack.MidTermProject.repository.Accounts;

import com.ironhack.MidTermProject.model.classes.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
