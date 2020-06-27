package com.ironhack.MidTermProject.controller.interfaces.Users;

import com.ironhack.MidTermProject.model.classes.User;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserControllerInterface {
    public List<User> getAll();
    public User findById(@PathVariable Long id);
}
