package com.ironhack.MidTermProject.model.enums;

public enum AccountStatus {
    FROZEN("This account is frozen and cannot be used. Please refer to the admin for further actions."),
    ACTIVE("This account is active and can perform operations as needed.");

    private String description;
    AccountStatus(String description) {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
