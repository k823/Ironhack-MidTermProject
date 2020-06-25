package com.ironhack.MidTermProject.model.dto;

import java.math.BigDecimal;

public class Transference {
    private Long senderId;
    private Long receiverId;
    private String receiverName;
    private BigDecimal amount;

    public Transference(){}
    public Transference(Long senderId, Long receiverId, String receiverName, BigDecimal amount) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.receiverName = receiverName;
        this.amount = amount;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
