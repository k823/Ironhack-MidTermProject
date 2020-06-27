package com.ironhack.MidTermProject.controller.impl.Users;

import com.ironhack.MidTermProject.controller.interfaces.Users.AdminControllerInterface;
import com.ironhack.MidTermProject.model.entities.Users.Admin;
import com.ironhack.MidTermProject.service.Users.AdminService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Users - Admin Controller")
@RestController
@RequestMapping("/users/admin")
public class AdminControllerImpl implements AdminControllerInterface {
    @Autowired
    AdminService adminService;

    @GetMapping("/find/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Admin> getAll() {
        return adminService.getAll();
    }

    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Admin findById(@PathVariable Long id) {
        return adminService.findById(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin createAdmin(@RequestBody Admin admin) throws Exception {
        return adminService.createAdmin(admin);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        adminService.deleteById(id);
    }
}
