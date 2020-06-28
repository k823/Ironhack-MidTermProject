package com.ironhack.MidTermProject.controller.impl.Accounts;

import com.ironhack.MidTermProject.controller.interfaces.Accounts.AccountControllerInterface;
import com.ironhack.MidTermProject.model.classes.Account;
import com.ironhack.MidTermProject.model.dto.AccountMoney;
import com.ironhack.MidTermProject.service.Accounts.AccountService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Accounts - General Account Controller")
@RestController
@RequestMapping("/api")
public class AccountControllerImpl implements AccountControllerInterface {
    @Autowired
    AccountService accountService;

    @GetMapping("/find/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account findById(@PathVariable Long id) {
        return accountService.findById(id);
    }

    @GetMapping("/find/mine")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> findMine(@RequestHeader("Authorization") String auth) throws Exception {
        return accountService.findMine(auth);
    }

    @GetMapping("/find/mine/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account findMineId(@RequestHeader("Authorization") String auth, @PathVariable Long id) throws Exception {
        return accountService.findMineId(auth, id);
    }

    @PostMapping("/balance")
    @ResponseStatus(HttpStatus.CREATED)
    public void setBalance(@RequestBody AccountMoney accountMoney) throws Exception {
         accountService.setBalance(accountMoney);
    }
}
