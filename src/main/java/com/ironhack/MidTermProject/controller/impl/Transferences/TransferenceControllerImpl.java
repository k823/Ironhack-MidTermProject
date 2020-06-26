package com.ironhack.MidTermProject.controller.impl.Transferences;

import com.ironhack.MidTermProject.controller.interfaces.Transferences.TransferenceControllerInterface;
import com.ironhack.MidTermProject.model.dto.ThirdPartyAccess;
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

    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransferenceRegistry findById(@PathVariable Long id) {
        return transferenceRegistryService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTransferenceRegistryById(Long id) {
        transferenceRegistryService.deleteTransferenceRegistryById(id);
    }

    // THIRD PARTY
    @PostMapping("/third-party/new")
    @ResponseStatus(HttpStatus.OK)
    public void operateAccount(@RequestHeader("HashedKey") String hashedKey, @RequestBody ThirdPartyAccess thirdPartyAccess) throws Exception {
        accountService.operateAccount(hashedKey, thirdPartyAccess);
    }
}
