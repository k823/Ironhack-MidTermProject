package com.ironhack.MidTermProject.controller.interfaces.Accounts;

import com.ironhack.MidTermProject.model.entities.Accounts.SavingsAccount;

import java.util.List;

public interface SavingsAccountControllerInterface {
    public SavingsAccount createSavingsAccount(SavingsAccount savingsAccount) throws Exception;
    public List<SavingsAccount> getAll();
    public SavingsAccount findById(Long id);
    public void deleteById(Long id);
}
