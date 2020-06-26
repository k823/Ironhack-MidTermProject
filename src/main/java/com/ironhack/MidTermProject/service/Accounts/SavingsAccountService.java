package com.ironhack.MidTermProject.service.Accounts;

import com.ironhack.MidTermProject.exception.DataNotFoundException;
import com.ironhack.MidTermProject.model.entities.Accounts.SavingsAccount;
import com.ironhack.MidTermProject.model.entities.Users.AccountHolder;
import com.ironhack.MidTermProject.repository.Accounts.SavingsAccountRepository;
import com.ironhack.MidTermProject.service.Users.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class SavingsAccountService {

    @Autowired
    SavingsAccountRepository savingsAccountRepository;

    @Autowired
    AccountHolderService accountHolderService;

    public SavingsAccount createSavingsAccount(SavingsAccount savingsAccount) throws Exception {
        AccountHolder accountHolder = accountHolderService.findById(savingsAccount.getPrimaryOwner().getId());

        BigDecimal interestRate = savingsAccount.getInterestRate();
        BigDecimal maxInterestRate = new BigDecimal("0.5");
        BigDecimal minimumBalance = savingsAccount.getMinimumBalance();
        BigDecimal minMinimumBalance = new BigDecimal("100");

        if (interestRate == null){
            savingsAccount.setInterestRate(new BigDecimal("0.0025"));
        } else if (interestRate.compareTo(maxInterestRate) == 1) {
            savingsAccount.setInterestRate(maxInterestRate.setScale(4, RoundingMode.HALF_EVEN));
            System.out.println("The maximum interest rate is 0.5. This account will be assigned that. If you have further concerns please contact an admin.");
        }

        if (minimumBalance == null) {
            savingsAccount.setMinimumBalance(new BigDecimal("1000"));
        } else if (minimumBalance.compareTo(minMinimumBalance) == -1) {
            savingsAccount.setMinimumBalance(minMinimumBalance);
            System.out.println("The minimum balance is 100. This account will be assigned that. If you have further concerns please contact an admin.");
        }

        if (minMinimumBalance.compareTo(savingsAccount.getBalance().getAmount()) == 1) {
            throw new Exception("An account with a Balance lesser than 100 cannot be created.");
        }

        savingsAccount.setPrimaryOwner(accountHolder);

      return savingsAccountRepository.save(savingsAccount);
    }

    public List<SavingsAccount> getAll() {
        return savingsAccountRepository.findAll();
    }

    public SavingsAccount findById(Long id) {
        return savingsAccountRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Could not find that Account."));
    }

    public void deleteById(Long id) {
        savingsAccountRepository.deleteById(id);
    }

//    public void addInterest() {
//        LocalDate now = LocalDate.now();
//        Long diff = Math.abs(YEARS.between(this.updatedAt, now));
//
//        if (diff == 1) {
//            this.balance.increaseAmount(getBalance().increaseAmount(balance.getAmount().multiply(interestRate)));
//        }
//    }
}
