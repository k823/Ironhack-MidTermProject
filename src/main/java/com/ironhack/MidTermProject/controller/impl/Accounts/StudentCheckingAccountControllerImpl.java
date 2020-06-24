package com.ironhack.MidTermProject.controller.impl.Accounts;

import com.ironhack.MidTermProject.model.entities.Accounts.StudentCheckingAccount;
import com.ironhack.MidTermProject.service.Accounts.StudentCheckingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class StudentCheckingAccountControllerImpl implements com.ironhack.MidTermProject.controller.interfaces.Accounts.StudentCheckingAccountControllerInterface {
    @Autowired
    StudentCheckingAccountService studentCheckingAccountService;

    @PostMapping("/student-checking-account")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentCheckingAccount createStudentCheckingAccount(@RequestBody StudentCheckingAccount studentCheckingAccount) {
        return studentCheckingAccountService.createStudentCheckingAccount(studentCheckingAccount);
    }

    @GetMapping("/student-checking-accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentCheckingAccount> getAll() {
        return studentCheckingAccountService.getAll();
    }

    @GetMapping("/student-checking-account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentCheckingAccount findById(@PathVariable Long id) {
        return studentCheckingAccountService.findById(id);
    }

    @DeleteMapping("/student-checking-account/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        studentCheckingAccountService.deleteById(id);
    }
}
