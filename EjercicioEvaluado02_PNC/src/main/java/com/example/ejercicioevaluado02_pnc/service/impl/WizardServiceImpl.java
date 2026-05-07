package com.example.ejercicioevaluado02_pnc.service.impl;


import com.example.ejercicioevaluado02_pnc.domain.entity.Wizard;
import com.example.ejercicioevaluado02_pnc.repository.WizardRepository;
import com.example.ejercicioevaluado02_pnc.service.WizardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WizardServiceImpl implements WizardService {
    private final WizardRepository productRepository;

    @Override
    public void createWizard(Wizard wizard) {
        productRepository.save(wizard);
    }

    @Override
    public List<Wizard> getAllWizards() {
        return productRepository.findAll();
    }

    @Override
    public List<Wizard> getAllByIsDeatheater(Boolean isDeatheater) {
        return productRepository.findByIsDeatheater(isDeatheater);
    }

    @Override
    public List<Wizard> getByPatronus(String patronus) {
        return productRepository.findByPatronus(patronus);
    }

    @Override
    public Wizard deleteWizard(UUID id) {
        Wizard wizard = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));

        productRepository.deleteById(id);
        return wizard;
    }

    @Override
    public Wizard updateWizard(UUID id, Wizard request) {
        if (request.getName() == null || request.getPatronus() == null || request.getHouse() == null || request.getIsDeatheater() == null) {
            throw new RuntimeException("All fields are required");
        }
        Wizard wizard = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        wizard.setName(request.getName());
        wizard.setHouse(request.getHouse());
        wizard.setIsDeatheater(request.getIsDeatheater());
        wizard.setPatronus(request.getPatronus());
        return productRepository.save(wizard);
    }
}

