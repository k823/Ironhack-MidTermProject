package com.ironhack.MidTermProject.controller.interfaces.Users;

import com.ironhack.MidTermProject.exception.DataNotFoundException;
import com.ironhack.MidTermProject.model.entities.Users.AccountHolder;

import java.util.List;

public interface AccountHolderControllerInterface {

    public List<AccountHolder> getAll();

    public AccountHolder findById(Long id) throws DataNotFoundException;

    public AccountHolder createAccountHolder(AccountHolder accountHolder) throws Exception;

    public void deleteById(Long id);
}
