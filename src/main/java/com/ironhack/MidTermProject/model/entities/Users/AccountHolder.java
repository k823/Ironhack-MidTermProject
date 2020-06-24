package com.ironhack.MidTermProject.model.entities.Users;

import com.ironhack.MidTermProject.model.classes.Account;
import com.ironhack.MidTermProject.model.classes.Address;
import com.ironhack.MidTermProject.model.classes.User;
import com.ironhack.MidTermProject.model.enums.UserType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "account_holder")
public class AccountHolder extends User {
    private LocalDate birthDate;
    @Embedded
    @NotNull(message = "Please introduce a Primary Address")
    private Address primaryAddress;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "mailing_street")),
            @AttributeOverride(name = "city", column = @Column(name = "mailing_city")),
            @AttributeOverride(name = "country", column = @Column(name = "mailing_country")),
            @AttributeOverride(name = "country", column = @Column(name = "mailing_country")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "mailing_postal_code"))
    })
    private Address mailingAddress;

    @OneToMany(mappedBy = "primaryOwner")
    private List<Account> accounts;

    public AccountHolder(){
        super(UserType.ACCOUNT_HOLDER);
        this.accounts = new ArrayList<>();
    }
    public AccountHolder(String name, String password, LocalDate birthDate, Address primaryAddress, Address mailingAddress) {
        super(name, password, UserType.ACCOUNT_HOLDER);
        this.birthDate = birthDate;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
        this.accounts = new ArrayList<>();

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AccountHolder that = (AccountHolder) o;
        return Objects.equals(birthDate, that.birthDate) &&
                Objects.equals(primaryAddress, that.primaryAddress) &&
                Objects.equals(mailingAddress, that.mailingAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), birthDate, primaryAddress, mailingAddress);
    }

    @Override
    public String toString() {
        return "AccountHolder{" +
                ", birthDate=" + birthDate +
                ", primaryAddress=" + primaryAddress +
                ", mailingAddress=" + mailingAddress +
                ", name='" + name + '\'' +
                '}';
    }
}
