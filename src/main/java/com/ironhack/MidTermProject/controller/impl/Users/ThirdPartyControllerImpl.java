package com.ironhack.MidTermProject.controller.impl.Users;

import com.ironhack.MidTermProject.controller.interfaces.Users.ThirdPartyControllerInterface;
import com.ironhack.MidTermProject.model.entities.Users.ThirdParty;
import com.ironhack.MidTermProject.service.Users.ThirdPartyService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Users - ThirdParty Controller")
@RestController
@RequestMapping("/users/third-party")
public class ThirdPartyControllerImpl implements ThirdPartyControllerInterface {
    @Autowired
    ThirdPartyService thirdPartyService;

    @GetMapping("/find/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ThirdParty> getAll() {
        return thirdPartyService.getAll();
    }

    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ThirdParty findById(@PathVariable Long id) {
        return thirdPartyService.findById(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdParty createThirdParty(@RequestBody ThirdParty thirdParty) throws Exception {
        return thirdPartyService.createThirdParty(thirdParty);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        thirdPartyService.deleteById(id);
    }
}
