package com.ironhack.MidTermProject.model.dto;

import java.math.BigDecimal;

public class CheckingAccountDto {
    private Long accountHolderId;
    private BigDecimal balance;
    private String secretKey;

    public CheckingAccountDto() {
    }

    public CheckingAccountDto(Long accountHolderId, BigDecimal balance, String secretKey) {
        this.accountHolderId = accountHolderId;
        this.balance = balance;
        this.secretKey = secretKey;
    }

    public Long getAccountHolderId() {
        return accountHolderId;
    }

    public void setAccountHolderId(Long accountHolderId) {
        this.accountHolderId = accountHolderId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
