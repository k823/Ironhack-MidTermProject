package com.ironhack.MidTermProject.service.Accounts;

import com.ironhack.MidTermProject.exception.DataNotFoundException;
import com.ironhack.MidTermProject.model.entities.Accounts.StudentCheckingAccount;
import com.ironhack.MidTermProject.repository.Accounts.StudentCheckingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCheckingAccountService {
    @Autowired
    StudentCheckingAccountRepository studentCheckingAccountRepository;

    public StudentCheckingAccount createStudentCheckingAccount(StudentCheckingAccount studentCheckingAccount) {
        return studentCheckingAccountRepository.save(studentCheckingAccount);
    }

    public List<StudentCheckingAccount> getAll() {
        return studentCheckingAccountRepository.findAll();
    }

    public StudentCheckingAccount findById(Long id) {
        return studentCheckingAccountRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Could not find that Account."));
    }

    public void deleteById(Long id) {
        studentCheckingAccountRepository.deleteById(id);
    }
}
