package com.ironhack.MidTermProject.controller.impl.Users;

import com.ironhack.MidTermProject.controller.interfaces.Users.ThirdPartyControllerInterface;
import com.ironhack.MidTermProject.model.entities.Users.ThirdParty;
import com.ironhack.MidTermProject.service.Users.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ThirdPartyControllerImpl implements ThirdPartyControllerInterface {
    @Autowired
    ThirdPartyService thirdPartyService;

    @GetMapping("/third-parties")
    @ResponseStatus(HttpStatus.OK)
    public List<ThirdParty> getAll() {
        return thirdPartyService.getAll();
    }

    @GetMapping("/third-party/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ThirdParty findById(@PathVariable Long id) {
        return thirdPartyService.findById(id);
    }

    @PostMapping("/third-party")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdParty createThirdParty(@RequestBody ThirdParty thirdParty) throws Exception {
        return thirdPartyService.createThirdParty(thirdParty);
    }

    @DeleteMapping("/third-party/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        thirdPartyService.deleteById(id);
    }
}
