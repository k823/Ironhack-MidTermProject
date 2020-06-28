package com.ironhack.MidTermProject.service.Accounts;

import com.ironhack.MidTermProject.exception.DataNotFoundException;
import com.ironhack.MidTermProject.model.classes.Money;
import com.ironhack.MidTermProject.model.dto.CheckingAccountDto;
import com.ironhack.MidTermProject.model.entities.Accounts.CheckingAccount;
import com.ironhack.MidTermProject.model.entities.Accounts.StudentCheckingAccount;
import com.ironhack.MidTermProject.model.entities.Users.AccountHolder;
import com.ironhack.MidTermProject.repository.Accounts.CheckingAccountRepository;
import com.ironhack.MidTermProject.service.Users.AccountHolderService;
import com.ironhack.MidTermProject.util.PasswordUtility;
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

    PasswordUtility passwordUtility = new PasswordUtility();

    public CheckingAccount createCheckingAccount(CheckingAccount checkingAccount) {
        return checkingAccountRepository.save(checkingAccount);
    }

    public Object checkAccountType(CheckingAccountDto checkingAccountDto) throws Exception {
        if (checkingAccountDto.getAccountHolderId() == null
                || checkingAccountDto.getBalance() == null ) {
            throw new Exception("Please introduce the accountHolderId and balance.");
        } else if (checkingAccountDto.getSecretKey() == null) {
            checkingAccountDto.setSecretKey(passwordUtility.main());
        }
        try {
            AccountHolder accountHolder = accountHolderService.findById(checkingAccountDto.getAccountHolderId());

        Long primaryOwnerAge = checkAge(accountHolder.getBirthDate());

        if (primaryOwnerAge < 24) {
            StudentCheckingAccount studentCheckingAccount = new StudentCheckingAccount(
                    new Money(checkingAccountDto.getBalance()),
                    checkingAccountDto.getSecretKey(),
                    accountHolder,
                    null
            );

            System.out.println("An Student Account will be created.");
            return studentCheckingAccountService.createStudentCheckingAccount(studentCheckingAccount);
        } else {
            System.out.println("A Checking Account will be created.");
            return createCheckingAccount(new CheckingAccount(
                    new Money(checkingAccountDto.getBalance()),
                    checkingAccountDto.getSecretKey(),
                    accountHolder,
                    null
            ));
        }

        } catch (Exception e) {
                throw new Exception("Please introduce a valid AccountHolder");
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
