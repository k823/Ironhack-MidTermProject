package com.ironhack.MidTermProject.controller.interfaces.Accounts;

import com.ironhack.MidTermProject.model.classes.Account;
import com.ironhack.MidTermProject.model.dto.AccountMoney;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

public interface AccountControllerInterface {
    public List<Account> getAll();
    public Account findById(@PathVariable Long id);
    public List<Account> findMine(@RequestHeader("Authorization") String auth) throws Exception;
    public Account findMineId(@RequestHeader("Authorization") String auth, @PathVariable Long id) throws Exception;
    public void setBalance(@RequestBody AccountMoney accountMoney) throws Exception;
}
