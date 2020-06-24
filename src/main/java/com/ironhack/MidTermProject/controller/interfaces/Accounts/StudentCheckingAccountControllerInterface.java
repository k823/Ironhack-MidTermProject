package com.ironhack.MidTermProject.controller.interfaces.Accounts;

import com.ironhack.MidTermProject.model.entities.Accounts.StudentCheckingAccount;

import java.util.List;

public interface StudentCheckingAccountControllerInterface {
    public StudentCheckingAccount createStudentCheckingAccount(StudentCheckingAccount studentCheckingAccount);
    public List<StudentCheckingAccount> getAll();
    public StudentCheckingAccount findById(Long id);
    public void deleteById(Long id);
}
