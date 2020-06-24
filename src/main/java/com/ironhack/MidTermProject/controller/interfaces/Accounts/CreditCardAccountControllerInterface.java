package com.ironhack.MidTermProject.controller.interfaces.Accounts;

import com.ironhack.MidTermProject.model.entities.Accounts.CreditCardAccount;

import java.util.List;

public interface CreditCardAccountControllerInterface {
    public CreditCardAccount createCreditCardAccount(CreditCardAccount creditCardAccount);
    public List<CreditCardAccount> getAll();
    public CreditCardAccount findById(Long id);
    public void deleteById(Long id);
}
