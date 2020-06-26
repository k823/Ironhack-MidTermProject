package com.ironhack.MidTermProject.repository.Users;

import com.ironhack.MidTermProject.model.entities.Users.ThirdParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThirdPartyRepository extends JpaRepository<ThirdParty, Long> {
    public List<ThirdParty> findByHashedKey(String hashedKey);
}
