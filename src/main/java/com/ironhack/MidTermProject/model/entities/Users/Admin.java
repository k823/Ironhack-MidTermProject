package com.ironhack.MidTermProject.model.entities.Users;

import com.ironhack.MidTermProject.model.classes.User;
import com.ironhack.MidTermProject.model.enums.UserType;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin extends User {
    public Admin(){
        super(UserType.ADMIN);
    }
    public Admin(String name, String password) {
        super(name, password, UserType.ADMIN);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
