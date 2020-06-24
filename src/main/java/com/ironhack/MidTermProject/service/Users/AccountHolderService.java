package com.ironhack.MidTermProject.service.Users;

import com.ironhack.MidTermProject.exception.DataNotFoundException;
import com.ironhack.MidTermProject.model.entities.Users.AccountHolder;
import com.ironhack.MidTermProject.repository.Users.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountHolderService {
    @Autowired
    AccountHolderRepository accountHolderRepository;

    public List<AccountHolder> getAll() {
        return accountHolderRepository.findAll();
    }

    public AccountHolder findById(Long id) {
        return accountHolderRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Could not find AccountHolder."));
    }

    public AccountHolder createAccountHolder(AccountHolder accountHolder) throws Exception {
        if (accountHolder.getName() == null) {
            throw new Exception("AccountHolder Name must not be null.");
        } else if (accountHolder.getBirthDate() == null) {
            throw new Exception("AccountHolder BirthDate must not be null.");
        } else if (accountHolder.getPrimaryAddress() == null) {
            throw new Exception("AccountHolder PrimaryAddress must not be null.");
        }
        return accountHolderRepository.save(accountHolder);
    }

    public void deleteById(Long id) {
        accountHolderRepository.deleteById(id);
    }
}
