package com.ironhack.MidTermProject.service.Users;

import com.ironhack.MidTermProject.exception.DataNotFoundException;
import com.ironhack.MidTermProject.model.entities.Users.ThirdParty;
import com.ironhack.MidTermProject.repository.Users.ThirdPartyRepository;
import com.ironhack.MidTermProject.util.PasswordUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.hibernate.bytecode.BytecodeLogger.LOGGER;

@Service
public class ThirdPartyService {
    @Autowired
    ThirdPartyRepository thirdPartyRepository;

    public List<ThirdParty> getAll() {
        return thirdPartyRepository.findAll();
    }

    public ThirdParty findById(Long id) {
        return thirdPartyRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Could not find ThirdPartyControllerImpl."));
    }

    public ThirdParty createThirdParty(ThirdParty thirdParty) throws Exception {
        if (thirdParty.getName() == null) {
            LOGGER.error("ThirdParty Name must not be null. " + thirdParty.getName());
            throw new Exception("ThirdParty Name must not be null.");
        }
        thirdParty.setHashedKey(PasswordUtility.main());
        LOGGER.info("ThirdParty has been created: " + thirdParty);
        return thirdPartyRepository.save(thirdParty);
    }

    public void deleteById(Long id) {
        LOGGER.info("ThirdParty has been deleted by ID: " + id);
        thirdPartyRepository.deleteById(id);
    }
}
