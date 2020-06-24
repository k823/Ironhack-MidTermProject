package com.ironhack.MidTermProject.service.Accounts;

import com.ironhack.MidTermProject.model.classes.Account;
import com.ironhack.MidTermProject.model.dto.AccountMoney;
import com.ironhack.MidTermProject.model.dto.Transference;
import com.ironhack.MidTermProject.repository.Accounts.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Transactional
    public void makeTransference(Transference transference) throws Exception {
        Account senderAccount = accountRepository.findById(transference.getSenderId()).orElseThrow(() -> new Exception("Sender Account not found."));
        senderAccount.getBalance().decreaseAmount(transference.getAmount());
        accountRepository.save(senderAccount);

        Account receiverAccount = accountRepository.findById(transference.getReceiverId()).orElseThrow(() -> new Exception("Receiver Account not found."));
        receiverAccount.getBalance().increaseAmount(transference.getAmount());
        accountRepository.save(receiverAccount);
    }

    public BigDecimal setBalance(AccountMoney accountMoney) throws Exception {
        Account targetAccount = accountRepository.findById(accountMoney.getAccountId()).orElseThrow(() -> new Exception("Account not found."));
        return targetAccount.getBalance().increaseAmount(accountMoney.getAmount());
    }
}
