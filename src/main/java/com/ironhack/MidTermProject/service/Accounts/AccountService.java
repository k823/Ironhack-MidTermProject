package com.ironhack.MidTermProject.service.Accounts;

import com.ironhack.MidTermProject.exception.DataNotFoundException;
import com.ironhack.MidTermProject.model.classes.Account;
import com.ironhack.MidTermProject.model.classes.User;
import com.ironhack.MidTermProject.model.dto.AccountMoney;
import com.ironhack.MidTermProject.model.dto.Transference;
import com.ironhack.MidTermProject.model.entities.Transferences.TransferenceRegistry;
import com.ironhack.MidTermProject.model.enums.AccountStatus;
import com.ironhack.MidTermProject.repository.Accounts.AccountRepository;
import com.ironhack.MidTermProject.repository.Users.UserRepository;
import com.ironhack.MidTermProject.service.Transferences.TransferenceRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.SECONDS;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TransferenceRegistryService transferenceRegistryService;

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    public Account findById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Could not find that Account."));
    }

    public List<Account> findMine(String auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String b64codedAuth = auth.replace("Basic", "").trim();
        byte[] decodedBytes = Base64.getDecoder().decode(b64codedAuth);
        String b64decoded = new String(decodedBytes);
        int separator = b64decoded.indexOf(':');
        String name = b64decoded.substring(0, separator);
        String password = b64decoded.substring(separator+1);
        User user = userRepository.findByName(name);

        if (!encoder.matches(password, user.getPassword())) {
            throw new Exception("Password does not match user.");
        }
        return accountRepository.findAll()
                .stream().filter(account -> account.getPrimaryOwner().getId() == user.getId())
                .collect(Collectors.toList());
    }

    public Account findMineId(String auth, Long id) throws Exception {
        List<Account> accountList = findMine(auth);
        List<Account> targetList = accountList.stream().filter(account -> account.getId() == id).collect(Collectors.toList());
        if (targetList.size() == 0) throw new DataNotFoundException("That account does not belong to this user.");
        return targetList.get(0);
    }

    public void setBalance(AccountMoney accountMoney) throws Exception {
        Account targetAccount = accountRepository.findById(accountMoney.getAccountId()).orElseThrow(() -> new Exception("Account not found."));
        targetAccount.setBalance(targetAccount.getBalance().increaseAmount(accountMoney.getAmount()));
        accountRepository.save(targetAccount);
    }


    @Transactional
    public void makeTransference(String auth, Transference transference) throws Exception {
        if (transference.getSenderId() == null
                || transference.getReceiverId() == null
                || transference.getReceiverName() == null
                || transference.getAmount() == null) {
            throw new Exception("Please introduce all the required fields: senderId (account), receiverId (account), receiverName, amount");
        }
        Account senderAccount = findMineId(auth, transference.getSenderId());
        if (senderAccount.getStatus().equals(AccountStatus.FROZEN)) {
            throw new Exception("This account is frozen and cannot perform operations. Please contact an administrator.");
        } else if (senderAccount.getBalance().getAmount().compareTo(transference.getAmount()) == -1) {
            throw new Exception("This account does not have enough funds to complete this transaction.");
        }

        checkLastTransference(senderAccount);
        checkHistoricTransference(senderAccount);

        senderAccount.setBalance(senderAccount.getBalance().decreaseAmount(transference.getAmount()));
        accountRepository.save(senderAccount);

        Account receiverAccount = accountRepository.findById(transference.getReceiverId())
                .orElseThrow(() -> new Exception("Receiver Account not found."));
        System.out.println(receiverAccount.getPrimaryOwner().getName());
        System.out.println(transference.getReceiverName());
        if (!receiverAccount.getPrimaryOwner().getName().trim().equals(transference.getReceiverName().trim())
                || (receiverAccount.getSecondaryOwner() != null
                        && !receiverAccount.getSecondaryOwner().getName().trim().equals(transference.getReceiverName().trim()))) {
            throw new Exception("The given Account Id does not match the Account Owner's name.");
        }
        receiverAccount.setBalance(receiverAccount.getBalance().increaseAmount(transference.getAmount()));
        accountRepository.save(receiverAccount);

        TransferenceRegistry record = new TransferenceRegistry(
                senderAccount.getId(),
                senderAccount.getPrimaryOwner().getName(),
                senderAccount.getBalance().getAmount(),
                receiverAccount.getId(),
                receiverAccount.getPrimaryOwner().getName(),
                receiverAccount.getBalance().getAmount(),
                transference.getAmount());

        transferenceRegistryService.createTransferenceRegistry(record);
    }

    // FRAUD UTILITY
    public void checkLastTransference(Account senderAccount) throws Exception {
        List<TransferenceRegistry> transferenceList = transferenceRegistryService.getAll();
        if (transferenceList.size() > 0) {
            TransferenceRegistry lastTransference = transferenceList.get(transferenceList.size()-1);
            LocalTime lastTransferenceTime = transferenceList.get(transferenceList.size()-1).getTime();
            if (lastTransference.getSenderAccountName().equals(senderAccount.getPrimaryOwner().getName())
                    && SECONDS.between(lastTransferenceTime, LocalTime.now()) < 3) {
                senderAccount.setStatus(AccountStatus.FROZEN);
                accountRepository.save(senderAccount);
                throw new Exception("This account have committed a rule violation trying to make more than two transferences in a 2 seconds lapse and will be blocked." +
                        " Please contact and administrator.");
            }
        }
    }

    public void checkHistoricTransference(Account senderAccount) throws Exception {
        List<TransferenceRegistry> transferenceListSender = transferenceRegistryService.getAll().stream().filter(transferenceRegistry ->
                transferenceRegistry
                        .getSenderAccountName()
                        .equals(senderAccount.getPrimaryOwner()
                                .getName()))
                .collect(Collectors.toList());
        List<TransferenceRegistry> transferenceListSender
        System.out.println(transferenceList);

    }
}
