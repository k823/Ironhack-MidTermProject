package com.ironhack.MidTermProject.service.security;

import com.ironhack.MidTermProject.model.classes.User;
import com.ironhack.MidTermProject.repository.Users.UserRepository;
import com.ironhack.MidTermProject.security.CustomSecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static org.hibernate.bytecode.BytecodeLogger.LOGGER;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userRepo.findByName(username);
            return new CustomSecurityUser(user);
        } catch (Exception e) {
            LOGGER.error("Invalid username/password combination on authentication.");
            throw new UsernameNotFoundException("Invalid username/password combination.");
        }

    }
}