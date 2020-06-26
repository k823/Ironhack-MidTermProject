package com.ironhack.MidTermProject.service.Accounts;

import com.ironhack.MidTermProject.exception.DataNotFoundException;
import com.ironhack.MidTermProject.model.entities.Accounts.CreditCardAccount;
import com.ironhack.MidTermProject.model.entities.Users.AccountHolder;
import com.ironhack.MidTermProject.repository.Accounts.CreditCardAccountRepository;
import com.ironhack.MidTermProject.service.Users.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CreditCardAccountService {

    @Autowired
    CreditCardAccountRepository creditCardAccountRepository;


    @Autowired
    AccountHolderService accountHolderService;

    public CreditCardAccount createCreditCardAccount(CreditCardAccount creditCardAccount) {
        AccountHolder accountHolder = accountHolderService.findById(creditCardAccount.getPrimaryOwner().getId());

        BigDecimal creditLimit = creditCardAccount.getCreditLimit();
        BigDecimal maxCreditLimit = new BigDecimal("100000");
        BigDecimal interestRate = creditCardAccount.getInterestRate();
        BigDecimal minInterestRate = new BigDecimal("0.1");

        if (interestRate == null){
            creditCardAccount.setInterestRate(new BigDecimal("0.2"));
        } else if (interestRate.compareTo(minInterestRate) == -1) {
            creditCardAccount.setInterestRate(minInterestRate);
            System.out.println("The minimum Interest Rate is 0.1. This account will be assigned that. If you have further concerns please contact an admin.");
        }

        if (creditLimit == null) {
            creditCardAccount.setCreditLimit(new BigDecimal("100"));
        } else if (creditLimit.compareTo(maxCreditLimit) == 1) {
            creditCardAccount.setCreditLimit(maxCreditLimit);
            System.out.println("The maximum Credit Limit is 100000. This account will be assigned that. If you have further concerns please contact an admin.");
        }

        creditCardAccount.setPrimaryOwner(accountHolder);

        return creditCardAccountRepository.save(creditCardAccount);
    }

    public List<CreditCardAccount> getAll() {
        return creditCardAccountRepository.findAll();
    }

    public CreditCardAccount findById(Long id) {
        return creditCardAccountRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Could not find that Account."));
    }

    public void deleteById(Long id) {
        creditCardAccountRepository.deleteById(id);
    }

//    public void addInterest(Long id) {
//        CreditCardAccount creditCardAccount =  creditCardAccountRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Could not find that Account."));
//        LocalDate now = LocalDate.now();
//        Long diff = Math.abs(MONTHS.between(creditCardAccount.getUpdatedAt(), now));
//
//        BigDecimal monthlyInterest = creditCardAccount.getInterestRate().divide(new BigDecimal(12));
//
//        if (diff >= 1) {
//            creditCardAccount.setBalance(creditCardAccount.getBalance().increaseAmount(creditCardAccount.getBalance().getAmount().multiply(new BigDecimal(1).multiply(monthlyInterest))));
//        }
//    }

}
