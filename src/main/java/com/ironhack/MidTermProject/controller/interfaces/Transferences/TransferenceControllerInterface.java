package com.ironhack.MidTermProject.controller.interfaces.Transferences;

import com.ironhack.MidTermProject.model.entities.Transferences.TransferenceRegistry;

import java.util.List;

public interface TransferenceControllerInterface {
    public List<TransferenceRegistry> getAll();
    public TransferenceRegistry findById(Long id);
    public TransferenceRegistry createTransferenceRegistry(TransferenceRegistry transferenceRegistry);
    public void deleteTransferenceRegistryById(Long id);
}
