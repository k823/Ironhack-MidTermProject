package com.ironhack.MidTermProject.repository.Transferences;

import com.ironhack.MidTermProject.model.entities.Transferences.TransferenceRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferenceRegistryRepository extends JpaRepository<TransferenceRegistry, Long> {
}
