package com.ironhack.MidTermProject.model.entities.Accounts;

import com.ironhack.MidTermProject.model.classes.Account;
import com.ironhack.MidTermProject.model.classes.Money;
import com.ironhack.MidTermProject.model.entities.Users.AccountHolder;
import com.ironhack.MidTermProject.model.enums.AccountType;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@Entity
@Table(name = "credit_card_account")
@DynamicUpdate
public class CreditCardAccount extends Account {
    @Digits(integer = 5, fraction = 5)
    @DecimalMax(value = "100000")
    private BigDecimal creditLimit;
    @Digits(integer = 5, fraction = 5)
    @DecimalMin(value = "0.1")
    private BigDecimal interestRate;

    public CreditCardAccount(){
        super(AccountType.CREDIT_CARD_ACCOUNT);
        this.creditLimit = new BigDecimal(100);
        this.interestRate = new BigDecimal(0.2);
    }

    public CreditCardAccount(Money balance, String secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner, BigDecimal creditLimit, BigDecimal interestRate) {
        super(balance, secretKey, primaryOwner, secondaryOwner, AccountType.CREDIT_CARD_ACCOUNT);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit.setScale(4, RoundingMode.HALF_EVEN);
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getInterestRate() {
        return interestRate.setScale(4, RoundingMode.HALF_EVEN);
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CreditCardAccount that = (CreditCardAccount) o;
        return Objects.equals(creditLimit, that.creditLimit) &&
                Objects.equals(interestRate, that.interestRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), creditLimit, interestRate);
    }

    @Override
    public String toString() {
        return "CreditCardAccount{" +
                ", creditLimit=" + creditLimit +
                ", interestRate=" + interestRate +
                ", balance=" + balance +
                ", secretKey='" + secretKey + '\'' +
                ", primaryOwner=" + primaryOwner +
                ", secondaryOwner=" + secondaryOwner +
                '}';
    }
}
