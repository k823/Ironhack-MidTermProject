package com.ironhack.MidTermProject.service.Users;

import com.ironhack.MidTermProject.exception.DataNotFoundException;
import com.ironhack.MidTermProject.model.entities.Users.Admin;
import com.ironhack.MidTermProject.repository.Users.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.hibernate.bytecode.BytecodeLogger.LOGGER;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    public Admin findById(Long id) {
        return adminRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Could not find AdminControllerImpl."));
    }

    public Admin createAdmin(Admin admin) throws Exception {
        if (admin.getName() == null) {
            LOGGER.error("Admin Name must not be null. " + admin.getName());
            throw new Exception("Admin Name must not be null.");
        }
        LOGGER.info("Admin has been created: " + admin);
        return adminRepository.save(admin);
    }

    public void deleteById(Long id) {
        LOGGER.info("Admin has been deleted by ID: " + id);
        adminRepository.deleteById(id);
    }
}
