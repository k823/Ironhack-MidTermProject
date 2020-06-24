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
import java.time.LocalDate;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.YEARS;

@Entity
@Table(name = "savings_account")
@DynamicUpdate
public class SavingsAccount extends Account {
    @Digits(integer = 4, fraction = 5)
    @DecimalMin(value = "100.00")
    private BigDecimal minimumBalance;
    @Digits(integer = 2, fraction = 5)
    @DecimalMin(value = "0.0025")
    @DecimalMax(value = "0.5")
    private BigDecimal interestRate;


    public SavingsAccount(){
        super(AccountType.SAVINGS_ACCOUNT);
        this.minimumBalance = new BigDecimal(1000);
        this.interestRate = new BigDecimal(0.0025);
    }
    public SavingsAccount(Money balance, String secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner, BigDecimal minimumBalance, BigDecimal interestRate) {
        super(balance, secretKey, primaryOwner, secondaryOwner, AccountType.SAVINGS_ACCOUNT);
        this.minimumBalance = minimumBalance;
        this.interestRate = interestRate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance.setScale(4, RoundingMode.HALF_EVEN);
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public BigDecimal getInterestRate() {
        return interestRate.setScale(4, RoundingMode.HALF_EVEN);
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public void addInterest() {
        LocalDate now = LocalDate.now();
        Long diff = Math.abs(YEARS.between(this.updatedAt, now));

        if (diff == 1) {
            this.balance.increaseAmount(getBalance().increaseAmount(balance.getAmount().multiply(interestRate)));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SavingsAccount that = (SavingsAccount) o;
        return Objects.equals(minimumBalance, that.minimumBalance) &&
                Objects.equals(interestRate, that.interestRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), minimumBalance, interestRate);
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                ", minimumBalance=" + minimumBalance +
                ", interestRate=" + interestRate +
                ", balance=" + balance +
                ", secretKey='" + secretKey + '\'' +
                ", primaryOwner=" + primaryOwner +
                ", secondaryOwner=" + secondaryOwner +
                '}';
    }
}
