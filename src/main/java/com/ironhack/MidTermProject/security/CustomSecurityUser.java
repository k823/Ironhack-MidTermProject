package com.ironhack.MidTermProject.security;

import com.ironhack.MidTermProject.model.classes.User;
import com.ironhack.MidTermProject.model.enums.UserType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

public class CustomSecurityUser extends User implements UserDetails {
    private static final long serialVersionUID = -4381938875186527688L;

    public CustomSecurityUser(User user) {
        this.setName(user.getName());
        this.setPassword(user.getPassword());
        this.setRole(user.getRole());
        this.setId(user.getId());
        System.out.println("This is the user: " + user);
        System.out.println("This is the custom user: " + this);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new HashSet<>();
        UserType role = this.getRole();
        authorities.add(new SimpleGrantedAuthority(role.toString()));
        return authorities;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}