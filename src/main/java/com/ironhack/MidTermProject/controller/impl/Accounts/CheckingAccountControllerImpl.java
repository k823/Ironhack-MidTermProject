package com.ironhack.MidTermProject.controller.impl.Accounts;

import com.ironhack.MidTermProject.controller.interfaces.Accounts.CheckingAccountControllerInterface;
import com.ironhack.MidTermProject.model.entities.Accounts.CheckingAccount;
import com.ironhack.MidTermProject.service.Accounts.CheckingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CheckingAccountControllerImpl implements CheckingAccountControllerInterface {

    @Autowired
    CheckingAccountService checkingAccountService;

    @PostMapping("/checking-account")
    @ResponseStatus(HttpStatus.CREATED)
    public Object createCheckingAccount(@RequestBody CheckingAccount checkingAccount) {
        return checkingAccountService.checkAccountType(checkingAccount);
    }

    @GetMapping("/checking-accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<CheckingAccount> getAll() {
        return checkingAccountService.getAll();
    }

    @GetMapping("/checking-account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CheckingAccount findById(@PathVariable Long id) {
        return checkingAccountService.findById(id);
    }

    @DeleteMapping("/checking-account/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        checkingAccountService.deleteById(id);
    }
}
