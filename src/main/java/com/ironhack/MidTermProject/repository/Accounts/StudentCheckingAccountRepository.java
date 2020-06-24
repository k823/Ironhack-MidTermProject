package com.ironhack.MidTermProject.repository.Accounts;

import com.ironhack.MidTermProject.model.entities.Accounts.StudentCheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCheckingAccountRepository extends JpaRepository<StudentCheckingAccount, Long> {
}
