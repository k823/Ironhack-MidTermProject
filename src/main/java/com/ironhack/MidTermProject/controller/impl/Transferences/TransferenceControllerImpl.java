package com.ironhack.MidTermProject.controller.impl.Transferences;

import com.ironhack.MidTermProject.controller.interfaces.Transferences.TransferenceControllerInterface;
import com.ironhack.MidTermProject.model.dto.Transference;
import com.ironhack.MidTermProject.model.entities.Transferences.TransferenceRegistry;
import com.ironhack.MidTermProject.service.Accounts.AccountService;
import com.ironhack.MidTermProject.service.Transferences.TransferenceRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transference")
public class TransferenceControllerImpl implements TransferenceControllerInterface {

    @Autowired
    TransferenceRegistryService transferenceRegistryService;

    @Autowired
    AccountService accountService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void makeTransference(@RequestHeader("Authorization") String auth,
                                 @RequestBody Transference transference) throws Exception {
         accountService.makeTransference(auth, transference);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<TransferenceRegistry> getAll() {
        return transferenceRegistryService.getAll();
    }

    public TransferenceRegistry findById(Long id) {
        return null;
    }

    public TransferenceRegistry createTransferenceRegistry(TransferenceRegistry transferenceRegistry) {
        return null;
    }

    public void deleteTransferenceRegistryById(Long id) {

    }
}
