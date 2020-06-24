package com.ironhack.MidTermProject.service.Accounts;

import com.ironhack.MidTermProject.exception.DataNotFoundException;
import com.ironhack.MidTermProject.model.entities.Accounts.CheckingAccount;
import com.ironhack.MidTermProject.model.entities.Accounts.StudentCheckingAccount;
import com.ironhack.MidTermProject.model.entities.Users.AccountHolder;
import com.ironhack.MidTermProject.repository.Accounts.CheckingAccountRepository;
import com.ironhack.MidTermProject.service.Users.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.YEARS;

@Service
public class CheckingAccountService {

    @Autowired
    CheckingAccountRepository checkingAccountRepository;

    @Autowired
    StudentCheckingAccountService studentCheckingAccountService;

    @Autowired
    AccountHolderService accountHolderService;

    public CheckingAccount createCheckingAccount(CheckingAccount checkingAccount) {
        return checkingAccountRepository.save(checkingAccount);
    }

    public Object checkAccountType(CheckingAccount checkingAccount) {
        AccountHolder accountHolder = accountHolderService.findById(checkingAccount.getPrimaryOwner().getId());
        Long primaryOwnerAge = checkAge(accountHolder.getBirthDate());

        if (primaryOwnerAge < 24) {
            StudentCheckingAccount studentCheckingAccount = new StudentCheckingAccount(
                    checkingAccount.getBalance(),
                    checkingAccount.getSecretKey(),
                    accountHolder,
                    checkingAccount.getSecondaryOwner()
            );

            System.out.println("An Student Account will be created.");
            return studentCheckingAccountService.createStudentCheckingAccount(studentCheckingAccount);
        } else {
            System.out.println("A Checking Account will be created.");
            return createCheckingAccount(new CheckingAccount(
                    checkingAccount.getBalance(),
                    checkingAccount.getSecretKey(),
                    accountHolder,
                    checkingAccount.getSecondaryOwner()
            ));
        }
    }

    public long checkAge(LocalDate inputBirth) {
        LocalDate now = LocalDate.now();
        return Math.abs(YEARS.between(inputBirth, now));
    }

    public List<CheckingAccount> getAll() {
        return checkingAccountRepository.findAll();
    }

    public CheckingAccount findById(Long id) {
        return checkingAccountRepository.findById(id).orElseThrow(() -> new DataNotFoundException("CheckingAccount not found."));
    }

    public void deleteById(Long id) {
        checkingAccountRepository.deleteById(id);
    }
}
