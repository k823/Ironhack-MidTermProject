package com.ironhack.MidTermProject.controller.impl.Users;

import com.ironhack.MidTermProject.controller.interfaces.Users.UserControllerInterface;
import com.ironhack.MidTermProject.model.classes.User;
import com.ironhack.MidTermProject.service.Users.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Users - General User Controller")
@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserControllerInterface {

    @Autowired
    UserService userService;

    @GetMapping("/find/all")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }
}
