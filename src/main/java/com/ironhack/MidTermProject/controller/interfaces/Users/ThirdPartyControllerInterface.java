package com.ironhack.MidTermProject.controller.interfaces.Users;

import com.ironhack.MidTermProject.model.entities.Users.ThirdParty;

import java.util.List;

public interface ThirdPartyControllerInterface {
    public List<ThirdParty> getAll();
    public ThirdParty findById(Long id);
    public ThirdParty createThirdParty(ThirdParty thirdParty) throws Exception;
    public void deleteById(Long id);
}
