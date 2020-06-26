package com.ironhack.MidTermProject.model.dto;

import java.math.BigDecimal;

public class ThirdPartyAccess {
    private Long accountId;
    private BigDecimal amount;
    private String accountSecretKey;

    public ThirdPartyAccess(Long accountId, BigDecimal amount, String accountSecretKey) {
        this.accountId = accountId;
        this.amount = amount;
        this.accountSecretKey = accountSecretKey;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAccountSecretKey() {
        return accountSecretKey;
    }

    public void setAccountSecretKey(String accountSecretKey) {
        this.accountSecretKey = accountSecretKey;
    }
}
