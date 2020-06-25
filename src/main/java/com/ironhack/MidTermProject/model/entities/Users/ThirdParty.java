package com.ironhack.MidTermProject.model.entities.Users;

import com.ironhack.MidTermProject.model.classes.User;
import com.ironhack.MidTermProject.model.enums.UserType;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "third_party")
public class ThirdParty extends User {
    private String hashedKey;

    public ThirdParty(){
        super(UserType.THIRD_PARTY);
    }
    public ThirdParty(String name, String password, String hashedKey) {
        super(name, password, UserType.THIRD_PARTY);
        this.hashedKey = hashedKey;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getHashedKey() {
        return hashedKey;
    }

    public void setHashedKey(String hashedKey) {
        this.hashedKey = hashedKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ThirdParty that = (ThirdParty) o;
        return Objects.equals(hashedKey, that.hashedKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hashedKey);
    }

    @Override
    public String toString() {
        return "ThirdParty{" +
                "hashedKey='" + hashedKey + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
