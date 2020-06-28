package com.ironhack.MidTermProject.controller.impl.Accounts;

import com.ironhack.MidTermProject.controller.interfaces.Accounts.CheckingAccountControllerInterface;
import com.ironhack.MidTermProject.model.dto.CheckingAccountDto;
import com.ironhack.MidTermProject.model.entities.Accounts.CheckingAccount;
import com.ironhack.MidTermProject.service.Accounts.CheckingAccountService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Accounts - CheckingAccount Controller")
@RestController
@RequestMapping("/accounts/checking")
public class CheckingAccountControllerImpl implements CheckingAccountControllerInterface {

    @Autowired
    CheckingAccountService checkingAccountService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Object createCheckingAccount(@RequestBody CheckingAccountDto checkingAccountDto) throws Exception {
        return checkingAccountService.checkAccountType(checkingAccountDto);
    }

    @GetMapping("/find/all")
    @ResponseStatus(HttpStatus.OK)
    public List<CheckingAccount> getAll() {
        return checkingAccountService.getAll();
    }

    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CheckingAccount findById(@PathVariable Long id) {
        return checkingAccountService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        checkingAccountService.deleteById(id);
    }
}
