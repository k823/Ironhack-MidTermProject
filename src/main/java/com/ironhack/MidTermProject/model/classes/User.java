package com.ironhack.MidTermProject.model.classes;

import com.ironhack.MidTermProject.model.enums.UserType;
import com.ironhack.MidTermProject.util.PasswordUtility;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity(name = "user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected Long id;
    @NotNull(message = "Please introduce a Name.")
    protected String name;
    protected String password;
    @Enumerated(EnumType.STRING)
    protected UserType role;

    public User() {
    }

    public User(String name, String password, UserType role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public User(UserType role) {
        this.role = role;
        this.password = PasswordUtility.main();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserType getRole() {
        return role;
    }

    public void setRole(UserType role) {
        this.role = role;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
