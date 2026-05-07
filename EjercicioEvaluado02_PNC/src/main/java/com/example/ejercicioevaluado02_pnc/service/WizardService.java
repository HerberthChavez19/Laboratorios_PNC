package com.example.ejercicioevaluado02_pnc.service;

import com.example.ejercicioevaluado02_pnc.domain.entity.Wizard;

import java.util.List;
import java.util.UUID;

public interface WizardService {
    void createWizard(Wizard wizard);
    List<Wizard> getAllWizards();
    List<Wizard> getAllByIsDeatheater(Boolean isDeatheater);
    List<Wizard> getByPatronus(String patronus);
    Wizard deleteWizard(UUID id);
    Wizard updateWizard(UUID id, Wizard request);
}
