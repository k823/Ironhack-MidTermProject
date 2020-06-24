package com.ironhack.MidTermProject.model.entities.Accounts;

import com.ironhack.MidTermProject.model.classes.Account;
import com.ironhack.MidTermProject.model.classes.Money;
import com.ironhack.MidTermProject.model.entities.Users.AccountHolder;
import com.ironhack.MidTermProject.model.enums.AccountType;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "checking_account")
@DynamicUpdate
public class CheckingAccount extends Account {
    @Digits(integer = 4, fraction = 5)
    @DecimalMin(value = "250")
    private BigDecimal minimumBalance;
    private final BigDecimal penaltyFee = new BigDecimal("40");
    @Digits(integer = 4, fraction = 5)
    @DecimalMin(value = "12")
    private BigDecimal monthlyMaintenanceFee;

    public CheckingAccount() {
        super(AccountType.CHECKING_ACCOUNT);
        this.minimumBalance = new BigDecimal("250");
        this.monthlyMaintenanceFee = new BigDecimal("12");
    }

    public CheckingAccount(Money balance, String secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
        super(balance, secretKey, primaryOwner, secondaryOwner, AccountType.CHECKING_ACCOUNT);
        this.minimumBalance = new BigDecimal("250");
        this.monthlyMaintenanceFee = new BigDecimal("12");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Money getBalance() {
        return super.getBalance();
    }

    @Override
    public void setBalance(Money balance) {
        BigDecimal currentMoney = super.getBalance().getAmount();
        if (currentMoney.compareTo(this.minimumBalance) == -1) {
            balance.decreaseAmount(penaltyFee);
            super.setBalance(balance);
        }
        super.setBalance(balance);
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    public BigDecimal getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(BigDecimal monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CheckingAccount that = (CheckingAccount) o;
        return Objects.equals(minimumBalance, that.minimumBalance) &&
                Objects.equals(penaltyFee, that.penaltyFee) &&
                Objects.equals(monthlyMaintenanceFee, that.monthlyMaintenanceFee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), minimumBalance, penaltyFee, monthlyMaintenanceFee);
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                ", minimumBalance=" + minimumBalance +
                ", penaltyFee=" + penaltyFee +
                ", monthlyMaintenanceFee=" + monthlyMaintenanceFee +
                ", balance=" + balance +
                ", secretKey='" + secretKey + '\'' +
                ", primaryOwner=" + primaryOwner +
                ", secondaryOwner=" + secondaryOwner +
                '}';
    }
}
