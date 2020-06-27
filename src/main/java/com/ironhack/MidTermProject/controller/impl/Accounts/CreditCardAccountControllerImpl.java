package com.ironhack.MidTermProject.controller.impl.Accounts;

import com.ironhack.MidTermProject.controller.interfaces.Accounts.CreditCardAccountControllerInterface;
import com.ironhack.MidTermProject.model.entities.Accounts.CreditCardAccount;
import com.ironhack.MidTermProject.service.Accounts.CreditCardAccountService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Accounts - CreditCardAccount Controller")
@RestController
@RequestMapping("/accounts/credit")
public class CreditCardAccountControllerImpl implements CreditCardAccountControllerInterface {

    @Autowired
    CreditCardAccountService creditCardAccountService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCardAccount createCreditCardAccount(@RequestBody CreditCardAccount creditCardAccount) {
        return creditCardAccountService.createCreditCardAccount(creditCardAccount);
    }

    @GetMapping("/find/all")
    @ResponseStatus(HttpStatus.OK)
    public List<CreditCardAccount> getAll() {
        return creditCardAccountService.getAll();
    }

    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CreditCardAccount findById(@PathVariable Long id) {
        return creditCardAccountService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        creditCardAccountService.deleteById(id);
    }
}
