package com.ironhack.MidTermProject.model.entities.Transferences;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity(name = "transference_registry")
public class TransferenceRegistry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long senderAccountId;
    private String senderAccountName;
    private BigDecimal senderAccountBalance;
    private Long receiverAccountId;
    private String receiverAccountName;
    private BigDecimal receiverAccountBalance;
    private BigDecimal amount;
    private LocalDate date;
    private LocalTime time;

    public TransferenceRegistry(){}

    public TransferenceRegistry(Long senderAccountId, String senderAccountName, BigDecimal senderAccountBalance, Long receiverAccountId, String receiverAccountName, BigDecimal receiverAccountBalance, BigDecimal amount) {
        this.senderAccountId = senderAccountId;
        this.senderAccountName = senderAccountName;
        this.senderAccountBalance = senderAccountBalance;
        this.receiverAccountId = receiverAccountId;
        this.receiverAccountName = receiverAccountName;
        this.receiverAccountBalance = receiverAccountBalance;
        this.amount = amount;
        this.date = LocalDate.now();
        this.time = LocalTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSenderAccountId() {
        return senderAccountId;
    }

    public void setSenderAccountId(Long senderAccountId) {
        this.senderAccountId = senderAccountId;
    }

    public String getSenderAccountName() {
        return senderAccountName;
    }

    public void setSenderAccountName(String senderAccountName) {
        this.senderAccountName = senderAccountName;
    }

    public BigDecimal getSenderAccountBalance() {
        return senderAccountBalance;
    }

    public void setSenderAccountBalance(BigDecimal senderAccountBalance) {
        this.senderAccountBalance = senderAccountBalance;
    }

    public Long getReceiverAccountId() {
        return receiverAccountId;
    }

    public void setReceiverAccountId(Long receiverAccountId) {
        this.receiverAccountId = receiverAccountId;
    }

    public String getReceiverAccountName() {
        return receiverAccountName;
    }

    public void setReceiverAccountName(String receiverAccountName) {
        this.receiverAccountName = receiverAccountName;
    }

    public BigDecimal getReceiverAccountBalance() {
        return receiverAccountBalance;
    }

    public void setReceiverAccountBalance(BigDecimal receiverAccountBalance) {
        this.receiverAccountBalance = receiverAccountBalance;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "TransferenceRegistry{" +
                "id=" + id +
                ", senderAccountId=" + senderAccountId +
                ", senderAccountName='" + senderAccountName + '\'' +
                ", senderAccountBalance=" + senderAccountBalance +
                ", receiverAccountId=" + receiverAccountId +
                ", receiverAccountName='" + receiverAccountName + '\'' +
                ", receiverAccountBalance=" + receiverAccountBalance +
                ", amount=" + amount +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
