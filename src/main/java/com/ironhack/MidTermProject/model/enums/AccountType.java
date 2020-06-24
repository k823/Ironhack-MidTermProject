package com.ironhack.MidTermProject.model.enums;

public enum AccountType {
    CHECKING_ACCOUNT("Checking Account"),
    CREDIT_CARD_ACCOUNT("Credit Card Account"),
    SAVINGS_ACCOUNT("Savings Account"),
    STUDENT_CHECKING_ACCOUNT("Student Checking Account");

    private String description;

    AccountType() {
    }

    AccountType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
