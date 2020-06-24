package com.ironhack.MidTermProject.repository.Users;

import com.ironhack.MidTermProject.model.entities.Users.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {
}
