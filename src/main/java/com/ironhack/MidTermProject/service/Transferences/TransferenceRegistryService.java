package com.ironhack.MidTermProject.service.Transferences;

import com.ironhack.MidTermProject.exception.DataNotFoundException;
import com.ironhack.MidTermProject.model.entities.Transferences.TransferenceRegistry;
import com.ironhack.MidTermProject.repository.Transferences.TransferenceRegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferenceRegistryService {

    @Autowired
    TransferenceRegistryRepository transferenceRegistryRepository;

    public List<TransferenceRegistry> getAll() {
        return transferenceRegistryRepository.findAll();
    }

    public TransferenceRegistry findById(Long id) {
        return transferenceRegistryRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Could not find that Transference."));
    }

    public TransferenceRegistry createTransferenceRegistry(TransferenceRegistry transferenceRegistry) {
        return transferenceRegistryRepository.save(transferenceRegistry);
    }

    public void deleteTransferenceRegistryById(Long id) {
        transferenceRegistryRepository.deleteById(id);
    }
}
