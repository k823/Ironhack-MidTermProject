package com.ironhack.MidTermProject.repository.Users;

import com.ironhack.MidTermProject.model.classes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String username);
}
