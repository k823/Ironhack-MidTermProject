package com.ironhack.MidTermProject.model.classes;

import com.ironhack.MidTermProject.model.entities.Users.AccountHolder;
import com.ironhack.MidTermProject.model.enums.AccountStatus;
import com.ironhack.MidTermProject.model.enums.AccountType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "account")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Account {
    @Id
    @GeneratedValue
    protected Long id;
    @Embedded
    protected Money balance;
    protected String secretKey;
    @ManyToOne
    @JoinColumn(name = "primary_owner")
    protected AccountHolder primaryOwner;
    @ManyToOne
    @JoinColumn(name = "secondary_owner")
    protected AccountHolder secondaryOwner;
    protected final BigDecimal penaltyFee = new BigDecimal("40");
    @Enumerated(EnumType.STRING)
    protected AccountType accountType;
    @Enumerated(EnumType.STRING)
    protected AccountStatus status;
    protected Integer maxTransactions24Hrs;
    protected Integer maxTransactionsToday;
    protected LocalDate createdAt;
    protected LocalDate updatedAt;

    public Account() {
        this.secretKey = "bananas";
        this.balance = new Money(new BigDecimal(0));
        this.status = AccountStatus.ACTIVE;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    public Account(AccountType accountType) {
        this.secretKey = "bananas";
        this.balance = new Money(new BigDecimal(0));
        this.status = AccountStatus.ACTIVE;
        this.accountType = accountType;
        this.maxTransactions24Hrs = 0;
        this.maxTransactionsToday = 0;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    public Account(Money balance, String secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner, AccountType accountType) {
        this.balance = balance;
        this.secretKey = secretKey;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
        this.accountType = accountType;
        this.status = AccountStatus.ACTIVE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = new Money(balance);
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public AccountHolder getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(AccountHolder primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public AccountHolder getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(AccountHolder secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public Integer getMaxTransactions24Hrs() {
        return maxTransactions24Hrs;
    }

    public void setMaxTransactions24Hrs(Integer maxTransactions24Hrs) {
        this.maxTransactions24Hrs = maxTransactions24Hrs;
    }

    public Integer getMaxTransactionsToday() {
        return maxTransactionsToday;
    }

    public void setMaxTransactionsToday(Integer maxTransactionsToday) {
        this.maxTransactionsToday = maxTransactionsToday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(balance, account.balance) &&
                Objects.equals(secretKey, account.secretKey) &&
                Objects.equals(primaryOwner, account.primaryOwner) &&
                Objects.equals(secondaryOwner, account.secondaryOwner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, secretKey, primaryOwner, secondaryOwner);
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", secretKey='" + secretKey + '\'' +
                ", primaryOwner=" + primaryOwner +
                ", secondaryOwner=" + secondaryOwner +
                '}';
    }
}
