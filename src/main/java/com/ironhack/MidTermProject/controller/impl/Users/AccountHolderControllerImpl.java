package com.ironhack.MidTermProject.controller.impl.Users;

import com.ironhack.MidTermProject.controller.interfaces.Users.AccountHolderControllerInterface;
import com.ironhack.MidTermProject.exception.DataNotFoundException;
import com.ironhack.MidTermProject.model.entities.Users.AccountHolder;
import com.ironhack.MidTermProject.service.Users.AccountHolderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Users - AccountHolder Controller")
@RestController
@RequestMapping("/users/account-holder")
public class AccountHolderControllerImpl implements AccountHolderControllerInterface {
    @Autowired
    AccountHolderService accountHolderService;

    @GetMapping("/find/all")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountHolder> getAll() {
        return accountHolderService.getAll();
    }

    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountHolder findById(@PathVariable Long id) throws DataNotFoundException {
        return accountHolderService.findById(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder createAccountHolder(@RequestBody AccountHolder accountHolder) throws Exception {
        return accountHolderService.createAccountHolder(accountHolder);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        accountHolderService.deleteById(id);
    }
}
