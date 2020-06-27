package com.ironhack.MidTermProject.controller.impl.Accounts;

import com.ironhack.MidTermProject.controller.interfaces.Accounts.SavingsAccountControllerInterface;
import com.ironhack.MidTermProject.model.entities.Accounts.SavingsAccount;
import com.ironhack.MidTermProject.service.Accounts.SavingsAccountService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Accounts - SavingsAccount Controller")
@RestController
@RequestMapping("/accounts/saving")
public class SavingsAccountControllerImpl implements SavingsAccountControllerInterface {
    @Autowired
    SavingsAccountService savingsAccountService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public SavingsAccount createSavingsAccount(@RequestBody SavingsAccount savingsAccount) throws Exception {
        return savingsAccountService.createSavingsAccount(savingsAccount);
    }

    @GetMapping("/find/all")
    @ResponseStatus(HttpStatus.OK)
    public List<SavingsAccount> getAll() {
        return savingsAccountService.getAll();
    }

    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SavingsAccount findById(@PathVariable Long id) {
        return savingsAccountService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        savingsAccountService.deleteById(id);
    }
}
