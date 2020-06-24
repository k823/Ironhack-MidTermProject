package com.ironhack.MidTermProject.controller.interfaces.Accounts;

import com.ironhack.MidTermProject.model.entities.Accounts.CheckingAccount;

import java.util.List;

public interface CheckingAccountControllerInterface {
    public Object createCheckingAccount(CheckingAccount checkingAccount);
    public List<CheckingAccount> getAll();
    public CheckingAccount findById(Long id);
    public void deleteById(Long id);
}
