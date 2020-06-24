package com.ironhack.MidTermProject.controller.impl.Accounts;

import com.ironhack.MidTermProject.model.classes.Account;
import com.ironhack.MidTermProject.model.dto.AccountMoney;
import com.ironhack.MidTermProject.model.dto.Transference;
import com.ironhack.MidTermProject.service.Accounts.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/")
public class AccountControllerImpl {
    @Autowired
    AccountService accountService;

    @GetMapping("/accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @PostMapping("/transference")
    @ResponseStatus(HttpStatus.OK)
    public void makeTransference(@RequestBody Transference transference) throws Exception {
        accountService.makeTransference(transference);
    }

    @PostMapping("/balance")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal setBalance(@RequestBody AccountMoney accountMoney) throws Exception {
        return accountService.setBalance(accountMoney);
    }
}
