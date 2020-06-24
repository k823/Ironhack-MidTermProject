package com.ironhack.MidTermProject.controller.interfaces.Users;

import com.ironhack.MidTermProject.model.entities.Users.Admin;

import java.util.List;

public interface AdminControllerInterface {
    public List<Admin> getAll();
    public Admin findById(Long id);
    public Admin createAdmin(Admin admin) throws Exception;
    public void deleteById(Long id);
}
