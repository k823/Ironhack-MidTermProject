package com.ironhack.MidTermProject.repository.Users;

import com.ironhack.MidTermProject.model.entities.Users.ThirdParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThirdPartyRepository extends JpaRepository<ThirdParty, Long> {
}
